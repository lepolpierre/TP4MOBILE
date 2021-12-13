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

import com.example.tp4mobilegwenaelgalliot.databinding.FragmentClientBinding;
import com.example.tp4mobilegwenaelgalliot.model.Objet;

import java.util.ArrayList;
import java.util.List;

public class PanierFragment extends Fragment {

    private PanierViewModel panierViewModel;
    private FragmentClientBinding binding;
    public List<Objet> lstPanier;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        //panierViewModel =new ViewModelProvider(this).get(PanierViewModel.class);
        //lstPanier = panierViewModel.getAllObjetsPanier().getValue();

        binding = FragmentClientBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView tvPanier = binding.tvPanier;
//        panierViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                //textView.setText(s);
//            }
//        });
           return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


//        panierViewModel = new ViewModelProvider(requireActivity()).get(PanierViewModel.class);
//        panierViewModel.getAllObjetsPanier().observe(getActivity(), new Observer<List<Objet>>() {
//
//            @Override
//            public void onChanged(List<Objet> obet) {
//                // updation of UI
//            }
//        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}