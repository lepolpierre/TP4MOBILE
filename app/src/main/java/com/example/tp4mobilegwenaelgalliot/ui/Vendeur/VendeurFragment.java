package com.example.tp4mobilegwenaelgalliot.ui.Vendeur;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.tp4mobilegwenaelgalliot.databinding.FragmentVendeurBinding;

public class ClientFragment extends Fragment {

    private VendeurViewModel clientViewModel;
    private FragmentVendeurBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        clientViewModel =
                new ViewModelProvider(this).get(VendeurViewModel.class);

        binding = FragmentVendeurBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        clientViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}