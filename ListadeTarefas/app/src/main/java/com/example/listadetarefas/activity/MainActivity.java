package com.example.listadetarefas.activity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;

import com.example.listadetarefas.R;
import com.example.listadetarefas.adapter.TarefaAdapter;
import com.example.listadetarefas.helper.DbHelper;
import com.example.listadetarefas.helper.RecyclerItemClickListener;
import com.example.listadetarefas.helper.TarefaDAO;
import com.example.listadetarefas.model.Tarefa;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TarefaAdapter tarefaAdapter;
    private List<Tarefa> listaTarefas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Configurar Recycler
        recyclerView = findViewById(R.id.recyclerView);


        //Adicionar evento de clique
        recyclerView.addOnItemTouchListener(

               new RecyclerItemClickListener(
                       getApplicationContext(),
                       recyclerView,
                       new RecyclerItemClickListener.OnItemClickListener() {
                           @Override
                           public void onItemClick(View view, int position) {

                              //Recuperar tarefa para edição
                               Tarefa tarefaSelecionada = listaTarefas.get(position);


                               //Enviar tarefa para tela adicionar tarefa
                               Intent intent = new Intent(MainActivity.this, AdicionarTarefaActivity.class);
                               intent.putExtra("tarefaSelecionada", tarefaSelecionada);

                               startActivity( intent );



                           }

                           @Override
                           public void onLongItemClick(View view, int position) {
                               Log.i("clique", "onLongItemClick");

                           }

                           @Override
                           public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                           }
                       }

               )
        );


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AdicionarTarefaActivity.class);
                startActivity( intent);
            }
        });
    }

    public void carregarListaTarefas(){

        //Listas tarefas
       TarefaDAO tarefaDAO = new TarefaDAO(getApplicationContext());
       listaTarefas = tarefaDAO.listar();

        /*
            Exibe lista de tarefas no Recyclerview
         */


        //Configurar um adapter
        tarefaAdapter = new TarefaAdapter( listaTarefas );

        //Configurar Recyclerview
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager( layoutManager );
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayout.VERTICAL));
        recyclerView.setAdapter( tarefaAdapter );

    }

    @Override
    protected void onStart() {
        carregarListaTarefas();
        super.onStart();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
