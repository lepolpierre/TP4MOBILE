package com.example.tp4mobilegwenaelgalliot.ui.Panier;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PanierViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public PanierViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is client fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}