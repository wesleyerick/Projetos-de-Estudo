 package com.example.classemetodosnapratica;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



       /* Pessoa pessoa = new Pessoa();
        pessoa.exibirDados( "Maria", 52);*/

       //ContaBancaria conta = new ContaBancaria( );


        Obama obama = new Obama();
        obama.direitosDeveres();











    }


}
