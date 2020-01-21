package com.example.bancodedadossqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try{

            SQLiteDatabase bancoDados = openOrCreateDatabase("app", MODE_PRIVATE, null );


            //Criar tabela
            bancoDados.execSQL("CREATE TABLE IF NOT EXISTS pessoas ( id INTEGER PRIMARY KEY AUTOINCREMENT, nome VARCHAR, idade INT(3) )"); //No caso de IDs usamos INTEGER e não INT pois o ID é um identificador //PRIMARY KEY determina que nunca pode se repetir um número

            //Apagando Coluna
            //bancoDados.execSQL("DROP TABLE pessoas "); //"DROP TABLE" é usado para apagar uma coluna

            //Inserir dados
           // bancoDados.execSQL ("INSERT INTO pessoas (nome, idade) VALUES('Mariana', 18) ");
           // bancoDados.execSQL ("INSERT INTO pessoas (nome, idade) VALUES('Maria', 35) ");


            //Atualiza os dados do Banco Offline
           // bancoDados.execSQL("UPDATE pessoas SET idade = 19, nome = 'Mariana Silva' WHERE id = '3'");
           // bancoDados.execSQL(" DELETE FROM pessoas WHERE id = 2 "); // deleta os registros do id 2
           // bancoDados.execSQL(" DELETE FROM pessoas "); // Deleta todos os registros



            //Recuperar pessoas
           /* String consulta =
                    "SELECT nome, idade FROM pessoas" +
                            "WHERE nome = 'Wesley' AND idade = 23 "; */


           //filtrar por informações da tabela
            /*String consulta =
                    "SELECT nome, idade FROM pessoas " +
                            "WHERE idade >= 40 OR idade = 18";*/

        /*    String consulta =
                    "SELECT nome, idade FROM pessoas WHERE idade IN(23,43)";*/

         /*   String consulta =
                    "SELECT nome, idade FROM pessoas " +
                            "WHERE idade BETWEEN 30 AND 45";*/

         //LIKE é usado para buscas, com o "%" é possivel buscar por exemplo nomes que contenham letras igual o exemplo abaixo.

           /* String filtro = "esle";
            String consulta =
                    "SELECT nome, idade FROM pessoas " +
                            "WHERE nome LIKE '%" + filtro +"%'"; */

            String consulta =
                    "SELECT * FROM pessoas " + // *= define todos os campos, substitui escrever todos os campos "id, nome, idade"
                            " WHERE 1=1 ";

            Cursor cursor = bancoDados.rawQuery(consulta,null);

            //Indices da tabela
            int indiceId = cursor.getColumnIndex("id");
            int indiceNome = cursor.getColumnIndex("nome");
            int indiceIdade = cursor.getColumnIndex("idade");

            cursor.moveToFirst();

            while (cursor != null){

                String nome = cursor.getString(indiceNome);
                String idade = cursor.getString(indiceIdade);
                String id = cursor.getString(indiceId);

                Log.i("RESULTADO - id ", id + "/ nome: " + nome + " / idade: " + idade);
                cursor.moveToNext();
            }

        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
