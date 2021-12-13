package com.example.tp4mobilegwenaelgalliot.ui.Panier;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tp4mobilegwenaelgalliot.model.Objet;

import java.util.ArrayList;
import java.util.List;

public class PanierViewModel extends AndroidViewModel {

    private MutableLiveData<List<Objet>> objetsPanier = new MutableLiveData<>();
    private List<Objet> lst;

    public PanierViewModel(Application application) {
        super(application);
//        mDb = LocationRoomDatabase.getDatabase(application);
//        objetsPanier = mDb.LocationDao().getAllLocations();
        //objetsPanier= new MutableLiveData<List<Objet>>();
    }

    public List<Objet> getAllObjetsPanier () {
        return objetsPanier.getValue();
    }

    public void addObjetPanier(Objet unObjet){
//        objetsPanier.getValue().add(unObjet);
        if (objetsPanier.getValue() != null ){lst = objetsPanier.getValue();}
        else{lst = new ArrayList<>();}

        //List<Objet> lst = new ArrayList<>();
        lst.add(unObjet);
        objetsPanier.postValue(lst);
    }
}