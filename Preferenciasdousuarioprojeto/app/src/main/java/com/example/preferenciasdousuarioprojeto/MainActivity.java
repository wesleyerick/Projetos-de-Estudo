package com.example.preferenciasdousuarioprojeto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private Button buttonSalvar;
    private TextInputEditText editNome;
    private TextView textResultado;
    private static final String ARQUIVO_PREFERENCIA = "ArquivoPreferencia";

    //static= travar a informação para que ela sempre seja a mesma independente das instancias criadas
    //final= coloca-se para que a informação nunca possa ser alterada (eu acho)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonSalvar = findViewById(R.id.buttonSalvar);
        editNome = findViewById(R.id.editNome);
        textResultado = findViewById(R.id.textResultado);

        buttonSalvar.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Cria um arquivo para salvar informações leves (preferencias de usuário por exemplo)

                SharedPreferences preferences = getSharedPreferences( ARQUIVO_PREFERENCIA, 0 ); // getSharedPreferences( nome do arquivo, modo: se outros apps podem alterar o arquivo ou só este app, neste caso "0" determina privado  )
                SharedPreferences.Editor editor =  preferences.edit();

                //Validar o nome
                if( editNome.getText().toString().equals("") ) {
                    Toast.makeText(getApplicationContext(), "Preencha o nome", Toast.LENGTH_LONG ).show();

                }else {

                    String nome = editNome.getText().toString();
                    editor.putString("nome", nome );
                    editor.commit();
                    textResultado.setText("Olá, " + nome);

                }
            }
        });

        //Recuperar dados salvos
        SharedPreferences preferences = getSharedPreferences( ARQUIVO_PREFERENCIA, 0 );

        //Valida se temos o nome em preferencias
        if ( preferences.contains("nome") ){

            String nome = preferences.getString("nome", "");
            textResultado.setText("Olá, " + nome);

        }else {
            textResultado.setText("Olá, usuário não definido");
        }


    }
}
