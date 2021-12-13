package com.example.tp4mobilegwenaelgalliot.ui.Magasin;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.tp4mobilegwenaelgalliot.MainActivity;
import com.example.tp4mobilegwenaelgalliot.ui.ObjetAdapteur;
import com.example.tp4mobilegwenaelgalliot.databinding.FragmentMagasinBinding;
import com.example.tp4mobilegwenaelgalliot.databinding.VendeurRowBinding;
import com.example.tp4mobilegwenaelgalliot.model.Objet;
import com.example.tp4mobilegwenaelgalliot.ui.Panier.PanierViewModel;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.ListenerRegistration;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class  MagasinFragment extends Fragment {

    private FragmentMagasinBinding binding;

    private static final String KEY_NAME = "OBJET";
    private static final String KEY_CAT = "CATEGORIE";
    private static final String KEY_PRIX = "PRIX";
    private static final String KEY_QTT = "QUANTITE";
    private String last;

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

    private PanierViewModel panierViewModel;





    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentMagasinBinding.inflate(getLayoutInflater());

        View view = binding.getRoot();
        return view;
    }




    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.rvMagasin.setLayoutManager(new LinearLayoutManager(getContext()));

        panierViewModel = new ViewModelProvider(requireActivity()).get(PanierViewModel.class);


        objetAdapteur = new ObjetAdapteur(getActivity(),items,panierViewModel);

        binding.rvMagasin.setAdapter(objetAdapteur);

        registration = collection.addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                Log.d("TAG", "onEvent: " + value);
                items.clear();
                for (QueryDocumentSnapshot document : value ) {
                    Log.d("TAG", document.getId() + " => " + document.getData());
                    Objet objet = new Objet();
                    objet.setNom(document.getString(KEY_NAME));
                    objet.setCategorie(document.getString(KEY_CAT));
                    objet.setPrix(Double.parseDouble(document.getString(KEY_PRIX)));
                    objet.setQtt(Double.parseDouble(document.getString(KEY_QTT)));


                    // Ajout de l'Id créé par Firestore
//                    objet.setId(document.getId());
//                    last = document.getId();
                    last = document.getId();
                    items.add(objet);

                }
                objetAdapteur.notifyDataSetChanged();




                Toast toast = Toast.makeText(getContext(), items.get(0).getNom(), Toast.LENGTH_SHORT);
                toast.show();
            }
        });






        //  REMPLIR LA DATABASE

//        Map<String, Object> objet = new HashMap<>();
//        objet.put(KEY_NAME, "banane");
//        objet.put(KEY_CAT, "fruit");
//        objet.put(KEY_PRIX, "10.0");
//        objet.put(KEY_QTT, "2");
//        collection
//                .add(objet)
//                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
//                    @Override
//                    public void onSuccess(DocumentReference DocumentReference) {
//                        Log.d("TAG", "DocumentSnapshot added with ID: ");
//                    }
//                })
//                .addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        Log.w("TAG", "Error adding document", e);
//                    }
//                });

    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}