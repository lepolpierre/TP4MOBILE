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

public class ObjetAdapteur extends RecyclerView.Adapter<ObjetAdapteur.NoteHolder> {

    private Context contexte;
    private ArrayList<Objet> objetsList;
    VendeurRowBinding binding;


    public ObjetAdapteur(Activity context, ArrayList<Objet> m_RowModels) {
            /* Le constructeur à 4 paramètres :
               1. Activité appelante
               2. Layout pour la rangée
               3. Conteneur pour l'affichage du texte dans le layout
               4. Données
               */
        //super(context, R.layout.vendeur_row, R.id.nom_rangee, m_RowModels);

        contexte = context;
        objetsList = m_RowModels;
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
        Objet current = objetsList.get(position);

        holder.tvCategorie.setText(current.getCategorie());
        holder.tvNom.setText(current.getNom());
        holder.tvPrix.setText(current.getPrix().toString());
        holder.tvQtt.setText(current.getQtt().toString());


//        // set image
//        if (current.getCategorie().equals("parc")){
//            holder.img.setImageResource(R.drawable.parc);
//        }else if(current.getCategorie().equals("maison")){
//            holder.img.setImageResource(R.drawable.maison);
//        }else{
//            holder.img.setImageResource(R.drawable.foret);
//        }
//
//        // gestion du clic sur la ranger
//        // Navigation vers le fragment Détail avec Id du point détaillé
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                NavDirections action = (NavDirections) HomeFragmentDirections.actionNavHomeToDetailsFragment(current.getId());
//                Navigation.findNavController(view).navigate(action);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return 0;
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


//    public ObjetAdapteur(@NonNull Context context, ArrayList<Objet> m_RowModels) {
//
//        super(context, R.layout.vendeur_row, R.id.nom_rangee, m_RowModels);
//        contexte = context;
//        rowModels = m_RowModels;
//    }
//
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        ViewHolder viewHolder;
//
//            /* Android recycle les conteneurs destinés à l'affichage
//               ici, convertView est une vue recyclée qui représente un conteneur de rangée (View row)
//               on vérifie qu'elle existe - si non, alors on la crée. */
//        if (convertView == null) {
//            // On crée d'abord un LayoutInflater depuis le contexte pour cette classe
//            // car on ne peut pas utiliser celui de notre activité (classe englobante)
//            LayoutInflater inflater = (LayoutInflater) contexte.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            convertView = inflater.inflate(R.layout.vendeur_row, parent, false);
//            // Création d'un ViewHolder
//            viewHolder = new ViewHolder(convertView);
//            // On le passe à la vue recyclée grâce à setTag
//            convertView.setTag(viewHolder);
//        }
//        else { viewHolder = (ViewHolder) convertView.getTag(); }
//
//        // Recyclage d'une ligne à l'aide de la méthode de la classe mère.
//        View row = super.getView(position, convertView, parent);
//
//        Objet rowData = rowModels.get(position);
//        viewHolder.tvCategorie.setText(rowData.getCategorie());
//        viewHolder.tvNom.setText(rowData.getNom());
//        viewHolder.tvPrix.setText(rowData.getPrix().toString());
//        viewHolder.tvQtt.setText(rowData.getQtt().toString());
//
//
//        return row;
//    }
//
//
//    private static class ViewHolder {
//        TextView tvCategorie;
//        TextView tvNom;
//        TextView tvPrix;
//        TextView tvQtt;
//
//        /** ViewHolder
//         *
//         * @param view
//         */
//        public ViewHolder(View view) {
//            tvCategorie = (TextView) view.findViewById(R.id.categorie_rangee);
//            tvNom = (TextView) view.findViewById(R.id.nom_rangee);
//            tvPrix = (TextView) view.findViewById(R.id.prix_rangee);
//            tvQtt = (TextView) view.findViewById(R.id.qtt_rangee);
//        }
//    }


}
