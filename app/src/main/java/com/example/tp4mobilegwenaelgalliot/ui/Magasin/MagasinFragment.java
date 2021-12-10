package com.example.tp4mobilegwenaelgalliot.ui.Magasin;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;


import com.example.tp4mobilegwenaelgalliot.ObjetAdapteur;
import com.example.tp4mobilegwenaelgalliot.databinding.FragmentVendeurBinding;
import com.example.tp4mobilegwenaelgalliot.databinding.VendeurRowBinding;
import com.example.tp4mobilegwenaelgalliot.model.Objet;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.ListenerRegistration;

import java.util.ArrayList;

public class MagasinFragment extends Fragment {

    private VendeurRowBinding binding;

    // Instanciation de la base de donnee firestore
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    //Declaration de la collection plat dans la bd
    CollectionReference collection = db.collection("items");

    // Declaration d'un document
    DocumentReference platRef = collection.document("item");

    // Declaratiioin d'un listener
    ListenerRegistration registration;

    // Declaration de la liste d'objet du magasin
    private ArrayList<Objet> items = new ArrayList<Objet>();

    private ObjetAdapteur objetAdapteur;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentVendeurBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        objetAdapteur = new ObjetAdapteur(getActivity(), items) {
        };
        binding.rvVendeur.setAdapter(objetAdapteur);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}