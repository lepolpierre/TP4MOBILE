package com.example.tp4mobilegwenaelgalliot.ui;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tp4mobilegwenaelgalliot.databinding.VendeurRowBinding;
import com.example.tp4mobilegwenaelgalliot.model.Objet;
import com.example.tp4mobilegwenaelgalliot.ui.Panier.PanierViewModel;

import java.util.List;


public class PanierAdapteur extends RecyclerView.Adapter<PanierAdapteur.NoteHolder> {
    private List<Objet> objetsList;
    VendeurRowBinding binding;
    public int i;


    public PanierAdapteur() { }


    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // creation et instanciation du layout
        binding = VendeurRowBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new NoteHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull NoteHolder holder, int position) {
        // recuperation du point
        Objet current = objetsList.get(position);

        holder.tvCategorie.setText(current.getCategorie());
        holder.tvNom.setText(current.getNom());
        holder.tvPrix.setText(current.getPrix().toString());
        holder.tvQtt.setText(current.getQtt().toString());


//        // set image
//        if (current.getCategorie().equals("fruit")){
//            holder.img.setImageResource(R.drawable.fruit);
//        }else if(current.getCategorie().equals("legumes")){
//            holder.img.setImageResource(R.drawable.legumes);
//        }else{
//            holder.img.setImageResource(R.drawable.autre);
//        }

    }


    @Override
    public int getItemCount() {
        if (objetsList != null)
            return objetsList.size();
        else return 0;
    }


    public void setObjetsList(List<Objet> objets) {
        objetsList = objets;
        notifyDataSetChanged();
    }


    public class NoteHolder extends RecyclerView.ViewHolder {
        public TextView tvCategorie, tvNom, tvPrix,tvQtt;

        public NoteHolder(@NonNull View itemView) {
            super(itemView);
            tvCategorie = binding.categorieRangee;
            tvNom = binding.nomRangee;
            tvPrix = binding.prixRangee;
            tvQtt = binding.qttRangee;
        }
    }
}
