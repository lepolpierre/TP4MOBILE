package com.example.tp4mobilegwenaelgalliot.ui;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tp4mobilegwenaelgalliot.R;
import com.example.tp4mobilegwenaelgalliot.databinding.VendeurRowBinding;
import com.example.tp4mobilegwenaelgalliot.model.Objet;
import java.util.ArrayList;
import java.util.List;

class ObjetAdapteur extends ArrayAdapter<Objet> {

    private Context contexte;
    private ArrayList<Objet> rowModels;
    VendeurRowBinding binding;

    public ObjetAdapteur(@NonNull Context context, int resource) {
        super(context, resource);
    }

    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // creation et instanciation du layout
        binding = VendeurRowBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);

        // routour du noteHolder
        return new NoteHolder(binding.getRoot());

    }

    @Override
    public void onBindViewHolder(@NonNull NoteHolder holder, int position) {

        // recuperation du point
        Objet current = rowModels.get(position);

        holder.txtAdress.setText(current.getNom());
        holder.txtAdress.setText(current.get());
        holder.txtCategorie.setText(current.getCategorie());


        // set image
//        if (current.getCategorie().equals("parc")){
//            holder.img.setImageResource(R.drawable.parc);
//        }else if(current.getCategorie().equals("maison")){
//            holder.img.setImageResource(R.drawable.maison);
//        }else{
//            holder.img.setImageResource(R.drawable.foret);
//        }

        // gestion du clic sur la ranger
        // Navigation vers le fragment Détail avec Id du point détaillé
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavDirections action = (NavDirections) HomeFragmentDirections.actionNavHomeToDetailsFragment(current.getId());
                Navigation.findNavController(view).navigate(action);
            }
        });
    }

    // nombre d objet dans la liste
    @Override
    public int getItemCount() {
        if (rowModels != null)
            return rowModels.size();
        else return 0;
    }

    // set location
    public void setLocations(ArrayList<Objet> objet) {
        rowModels = objet;
        notifyDataSetChanged();
    }


    // référence les éléments de la vue
    public class NoteHolder extends RecyclerView.ViewHolder {
        public TextView txtNom, txtCategorie, txtPrix, txtQtt;

        public NoteHolder(@NonNull View itemView) {
            super(itemView);
            txtNom = binding.t;
            txtNom = binding.tvNom;
            txtAdress = binding.tvAdresse;
        }
    }
}
