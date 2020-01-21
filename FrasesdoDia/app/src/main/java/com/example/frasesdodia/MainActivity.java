package com.example.frasesdodia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void gerarNovaFrase(View view) {

        String [] frases = {
                "“Mesmo que já tenhas feito uma longa caminhada, há sempre um novo caminho a fazer”. (Santo Agostinho)",
                "“É sempre divertido fazer o impossível”. (Walt Disney)",
                "“Devemos ser a mudança que queremos ver no mundo”. (Gandhi)",
                "“Algumas derrotas são mais triunfantes do que vitórias”. (Michael de Montaigne)",
                "“Nossa vida é o que os nossos pensamentos fazem dela”. (Marco Aurélio Antonino)"
        };
        int numero = new Random().nextInt( frases.length );

        TextView texto = (TextView) findViewById(R.id.text_resultado);

        texto.setText( frases[numero] );


    }

}
