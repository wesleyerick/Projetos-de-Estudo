package com.example.aulaatmconsultoria.ui.servicos;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ServicosViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ServicosViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Sistemas de Gestão da Qualidade");
    }

    public LiveData<String> getText() {
        return mText;
    }
}