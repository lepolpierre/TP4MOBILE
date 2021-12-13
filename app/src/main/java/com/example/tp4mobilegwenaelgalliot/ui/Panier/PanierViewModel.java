package com.example.tp4mobilegwenaelgalliot.ui.Panier;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tp4mobilegwenaelgalliot.model.Objet;
import com.google.android.gms.common.internal.FallbackServiceBroker;

import java.util.ArrayList;
import java.util.List;

public class PanierViewModel extends AndroidViewModel {

    private MutableLiveData<List<Objet>> objetsPanier = new MutableLiveData<>();
    private List<Objet> lst;


    public PanierViewModel(Application application) { super(application); }


    public List<Objet> getAllObjetsPanier () {
        return objetsPanier.getValue();
    }


    public LiveData<List<Objet>> getLstLiveData(){return objetsPanier;}



    public void addObjetPanier(Objet unObjet){

        // initialisation / recuperation de la liste des objets du panier
        if (lst == null ){lst = new ArrayList<>();}
        //else{lst = new ArrayList<>();}

        boolean existe = false;
        int index = 0;
        int qtt = 0;

        for (Objet objet : lst ){
            if (objet.getNom() == unObjet.getNom()){
                existe = true;
                index = lst.indexOf(objet);
                qtt = objet.getQtt().intValue();
            }
        }



        if(existe){
            qtt++;
            unObjet.setQtt(qtt);
            lst.set(index, unObjet);
        }
        else{ lst.add(unObjet);}


        objetsPanier.postValue(lst);
    }
}