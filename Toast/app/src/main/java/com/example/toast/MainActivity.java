package com.example.toast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void abrirToast (View view){
        /*
        * Criação do toast
        *
        * */
        /*Toast.makeText(getApplicationContext(), "Botão Pressionado",
                Toast.LENGTH_LONG ).show();*/

        ImageView imagem = new ImageView(getApplicationContext());
        imagem.setImageResource(android.R.drawable.star_big_off);

        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView( imagem );
        toast.show();
    }
}
