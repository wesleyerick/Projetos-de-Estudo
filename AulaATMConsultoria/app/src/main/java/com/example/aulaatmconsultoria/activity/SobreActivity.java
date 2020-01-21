package com.example.aulaatmconsultoria.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.aulaatmconsultoria.R;

import mehdi.sakout.aboutpage.AboutPage;

public class SobreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String descricao = "A base para o crescimento sólido  é sustentada por três pilares essenciais: estrutura organizacional; competência e comprometimento dos recursos humanos; sistemas eficazes de gestão e controle.\n" +
                "Nesse sentido a ATM CONSULTORIA, por meio da excelência nos serviços de consultoria, identifica e implanta com o cliente soluções que complementam as necessidades das empresas e incrementam resultados.";
        View sobre = new AboutPage(this)
                .setImage(R.drawable.logo)
                .setDescription(descricao)
                .addGroup("Fale Conosco")
                .addEmail("atmconsultoria@gmail.com")
                .addWebsite("http://google.com.br/", "Acesse nosso site")
                .addGroup("Acesse nossas redes sociais")
                .addFacebook("Google", "Facebook")
                .addInstagram("google", "Instagram")
                .addYoutube("google", "Youtube")
                .addGitHub("wesleyerick", "GitHub")
                .create();



        setContentView( sobre );
    }



        @Override
        public void onBackPressed() {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
}
