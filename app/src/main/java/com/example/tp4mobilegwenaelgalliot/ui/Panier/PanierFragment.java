package com.example.tp4mobilegwenaelgalliot.ui.Panier;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.tp4mobilegwenaelgalliot.databinding.FragmentClientBinding;
import com.example.tp4mobilegwenaelgalliot.model.Objet;
import com.example.tp4mobilegwenaelgalliot.ui.ObjetAdapteur;
import com.example.tp4mobilegwenaelgalliot.ui.PanierAdapteur;

import java.util.ArrayList;
import java.util.List;

public class PanierFragment extends Fragment {

    private PanierViewModel panierViewModel;
    private FragmentClientBinding binding;
    private PanierAdapteur panierAdapteur;
    public LiveData<List<Objet>> lstPanier;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentClientBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        panierViewModel = new ViewModelProvider(requireActivity()).get(PanierViewModel.class);

        lstPanier = panierViewModel.getLstLiveData();

        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        // déclaration et instanciation du RecyclerView
        binding.rvPanier.setLayoutManager(new LinearLayoutManager(getContext()));

        // instanciation de l'adapteur et passage de l'adapteur au RecyclerView
        panierAdapteur = new PanierAdapteur();
        binding.rvPanier.setAdapter(panierAdapteur);

        lstPanier = panierViewModel.getLstLiveData();
        lstPanier.observe(getActivity(),new Observer<List<Objet>>() {
            @Override
            // Paramètre : dernière version observée de la liste de todos
            public void onChanged(List<Objet> objets) { panierAdapteur.setObjetsList(objets); }

        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}