package com.example.aulaatmconsultoria.ui.contato;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.aulaatmconsultoria.R;

public class ContatoFragment extends Fragment {



    private ContatoViewModel contatoViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        enviarEmail();

        contatoViewModel =
                ViewModelProviders.of(this).get(ContatoViewModel.class);
        View root = inflater.inflate(R.layout.fragment_contato, container, false);
        final TextView textView = root.findViewById(R.id.text_share);
        contatoViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

    public void enviarEmail(){
        //Como dizer para o Android buscar os Apps, neste caso apra email, definir o email e seu assunto e mensagem
        Intent email = new Intent( Intent.ACTION_SEND );
        email.putExtra(Intent.EXTRA_EMAIL, new String []{"atmconsultoria@gmail.com"} );
        email.putExtra(Intent.EXTRA_SUBJECT, "Contato pelo App");
        email.putExtra(Intent.EXTRA_TEXT, "Mensagem Automática");

        //Configurar Apps para o Email
        email.setType("message/rfc822");

        startActivity ( Intent.createChooser(email, "Escolha o App de Email:") );



    }


}