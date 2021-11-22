package com.example.tp4mobilegwenaelgalliot.ui.Vendeur;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class VendeurViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public VendeurViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is vendeur fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}