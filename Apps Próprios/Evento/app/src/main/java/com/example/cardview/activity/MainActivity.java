package com.example.cardview.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.cardview.R;
import com.example.cardview.adapter.PostagemAdapter;
import com.example.cardview.model.Postagem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerPostagem;
    private List<Postagem> postagens = new ArrayList<>();

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerPostagem = findViewById(R.id.recyclerPostagem);

        //Define layout
        /* Usar esse para recycler view de visualização em pé:
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);*/

        /* Usar esse para visualização do cardView na horizontal:
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayout.HORIZONTAL);*/

        //Usar este código para visualização em formato de grade:
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,2);
        recyclerPostagem.setLayoutManager( layoutManager );

        //define adapter
        this.prepararPostagens();

        PostagemAdapter adapter = new PostagemAdapter( postagens );
        recyclerPostagem.setAdapter( adapter );

    }


    public void prepararPostagens(){

        Postagem p = new Postagem("Wesley Erick","#tbt Viagem Top!", R.drawable.imagem1);
        this.postagens.add(p);

        p = new Postagem("Hotel Ibis","Viaje, aproveite nossos descontos!", R.drawable.imagem2);
        this.postagens.add(p);

        p = new Postagem("Bianca Santos","#Paris!!", R.drawable.imagem3);
        this.postagens.add(p);

        p = new Postagem("Angel Oliveira","Que foto linda!", R.drawable.imagem4);
        this.postagens.add(p);

    }

}
