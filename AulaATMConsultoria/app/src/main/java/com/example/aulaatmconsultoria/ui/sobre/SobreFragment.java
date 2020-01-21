package com.example.aulaatmconsultoria.ui.sobre;

import android.app.Activity;
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
import com.example.aulaatmconsultoria.activity.SobreActivity;

import mehdi.sakout.aboutpage.AboutPage;

public class SobreFragment extends Fragment {

    private SobreViewModel sobreViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        sobreViewModel =
                ViewModelProviders.of(this).get(SobreViewModel.class);
        View root = inflater.inflate(R.layout.fragment_sobre, container, false);
        final TextView textView = root.findViewById(R.id.text_send);
        sobreViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;




    }
}