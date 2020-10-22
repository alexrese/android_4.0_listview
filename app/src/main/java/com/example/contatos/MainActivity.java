package com.example.contatos;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String mNome[] = {"Alex Rese", "Anatielle T Gomes", "Julio Cesar", "Pablo Escobar", "Sigmund Freud", "Quentin Tarantino"};
    String mDescricao[] = {"Professor disciplinar", "Psicóloga comercial", "Imperador Romano", "Produtor de drogas", "Responsável pela revolução no estudo da mente humana", "Diretor de filmes PoP"};

    int images[] = {R.drawable.alex, R.drawable.anatielle, R.drawable.julio, R.drawable.pablo, R.drawable.freud, R.drawable.tarantino};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.minhaListagem);

        ContatoAdapter adapter = new ContatoAdapter(this, mNome, mDescricao, images);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    Toast.makeText(MainActivity.this, "Alex", Toast.LENGTH_SHORT).show();
                }
                if (position == 1){
                    Toast.makeText(MainActivity.this, "Nati", Toast.LENGTH_SHORT).show();
                }
                if (position == 2){
                    Toast.makeText(MainActivity.this, "Julio", Toast.LENGTH_SHORT).show();
                }
                if (position == 3){
                    Toast.makeText(MainActivity.this, "Pablo", Toast.LENGTH_SHORT).show();
                }
                if (position == 4){
                    Toast.makeText(MainActivity.this, "Freud", Toast.LENGTH_SHORT).show();
                }
                if (position == 5){
                    Toast.makeText(MainActivity.this, "Tarantino", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

     class ContatoAdapter extends ArrayAdapter {
        Context context;
        String rNome[];
        String rDescricao[];
        int rImgs[];

        ContatoAdapter (Context c, String nome[], String descricao[], int img[]){
            super (c, R.layout.elemento, R.id.textoNome, nome);
            this.context = c;
            this.rNome = nome;
            this.rDescricao = descricao;
            this.rImgs = images;
        }

         @NonNull
         @Override
         public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
             LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
             View elemento = layoutInflater.inflate(R.layout.elemento, parent, false);
             ImageView images = elemento.findViewById(R.id.image);
             TextView meuNome = elemento.findViewById(R.id.textoNome);
             TextView minhaDescricao = elemento.findViewById(R.id.textoDrescricao);

             images.setImageResource(rImgs[position]);
             meuNome.setText(rNome[position]);
             minhaDescricao.setText(rDescricao[position]);

             return elemento;
         }
     }
}