package com.example.lista_contatos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText etNome;
    EditText etTelefone;
    EditText etEmail;
    String DATABASE_NAME = "my-db";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNome = findViewById(R.id.etNome);
        etTelefone = findViewById(R.id.etTelefone);
        etEmail = findViewById(R.id.etEmail);

        List<Contato> contatos = buscaContatos();

        ListView listView = findViewById(R.id.listView);
        MeuAdaptador adapter = new MeuAdaptador(this, R.layout.item_contato, contatos);
        listView.setAdapter(adapter);

    }

    public void gravarContato(View view) {
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, DATABASE_NAME).build();

        ContatoDao contatoDAO = db.contatoDAO();
        //instanciar a entidade
        Contato contato = new Contato();
        contato.nome = etNome.getText().toString();
        contato.telefone = etTelefone.getText().toString();
        contato.email = etEmail.getText().toString();

        new Thread(new Runnable() {
            @Override
            public void run() {
                contatoDAO.insert(contato);
            }
        }).start();

    }

    private List<Contato> buscaContatos() {
        List<Contato> contatos = new ArrayList<>();

        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, DATABASE_NAME).build();

        ContatoDao contatoDAO = db.contatoDAO();

        Runnable buscaContatosRunnable = new Runnable() {
            @Override
            public void run() {
                contatos.addAll(contatoDAO.getAll());
            }
        };

        Thread thread = new Thread(buscaContatosRunnable);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return contatos;
    }
}