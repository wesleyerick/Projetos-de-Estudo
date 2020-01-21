package com.example.aulaatmconsultoria.ui.principal;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PrincipalViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public PrincipalViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("");
    }

    public LiveData<String> getText() {
        return mText;
    }
}