package com.example.alertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void abrirAlerta(View view){

        /*
        * Criar AlertDialog
        * */
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);

        //Configura título e mensagem
        dialog.setTitle("Título");
        dialog.setMessage("Mensagem");

        //Confirmar Cancelamento (não é possível clicar fora da caixa de diálogo
        dialog.setCancelable(false);

        //Configura ícone
        dialog.setIcon(android.R.drawable.ic_dialog_alert);


        //Configura ações para botão sim ou não
        dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                Toast.makeText(getApplicationContext(), "Sim foi pressionado",
                        Toast.LENGTH_SHORT).show();

            }
        });

        dialog.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                Toast.makeText(getApplicationContext(), "Não foi pressionado",
                        Toast.LENGTH_SHORT).show();

            }
        });
                //Criar e exibir AlertDialog

        dialog.create();
        dialog.show();

    }

}
