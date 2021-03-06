package com.example.tp4mobilegwenaelgalliot.ui;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tp4mobilegwenaelgalliot.MainActivity;
import com.example.tp4mobilegwenaelgalliot.R;
import com.example.tp4mobilegwenaelgalliot.databinding.VendeurRowBinding;
import com.example.tp4mobilegwenaelgalliot.model.Objet;
import com.example.tp4mobilegwenaelgalliot.ui.Magasin.MagasinFragment;
import com.example.tp4mobilegwenaelgalliot.ui.Panier.PanierViewModel;

import java.util.ArrayList;
import java.util.List;



public class ObjetAdapteur extends RecyclerView.Adapter<ObjetAdapteur.NoteHolder> {
    private Context contexte;
    private List<Objet> objetsList;
    private List<Objet> panierList;
    VendeurRowBinding binding;
    PanierViewModel panierViewModel;
    private Context mContext;
    public int i;


    public ObjetAdapteur(Activity context, List<Objet> m_RowModels, PanierViewModel pvm) {
        contexte = context;
        objetsList = m_RowModels;
        i = 0;
        mContext = context;
        panierViewModel = pvm;
    }


    public ObjetAdapteur() { }


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
        //holder.tvQtt.setText(current.getQtt().toString());


//        // set image
//        if (current.getCategorie().equals("parc")){
//            holder.img.setImageResource(R.drawable.parc);
//        }else if(current.getCategorie().equals("maison")){
//            holder.img.setImageResource(R.drawable.maison);
//        }else{
//            holder.img.setImageResource(R.drawable.foret);
//        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { panierViewModel.addObjetPanier(current); }

        });
    }


    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);

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
            //tvQtt = binding.qttRangee;


        }
    }


}
