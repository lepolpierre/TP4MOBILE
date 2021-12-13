package com.example.tp4mobilegwenaelgalliot;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;

import com.example.tp4mobilegwenaelgalliot.ui.Panier.PanierViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.tp4mobilegwenaelgalliot.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    public PanierViewModel panierViewModel;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        panierViewModel = new ViewModelProvider(this).get(PanierViewModel.class);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_vendeur, R.id.navigation_client)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu p_menu) {
        // Création du menu
        getMenuInflater().inflate(R.menu.admin, p_menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_ajouter:

                // ce btn correspond au mode admin
                // affiche / cache les options de l'administrateur quand on click dessus


                return true;

            default:
                Log.w("MainActivity", "Menu inconnu : " + item.getTitle());
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();



        switch (item.getItemId()) {
            // Modifier
            case R.id.menu_set:
                // popup pour gérer l'interaction
                //handleSetWordMenu(menuInfo.position);
                return true;

            // Ajouter
            case R.id.menu_ajout:
//                RowModel c_row = m_RowModels.get(menuInfo.position);
//                String data = c_row.getContent().toUpperCase();
//                m_RowModels.remove(menuInfo.position);
//                m_RowModels.add(menuInfo.position, new RowModel(data));
//                // notification de l'adapteur
//                m_Adapter.notifyDataSetChanged();
                return true;

            // Supprimer
            case R.id.menu_remove:
//                m_RowModels.remove(menuInfo.position);
//                // notification de l'adapteur
//                m_Adapter.notifyDataSetChanged();
                return true;

            default:
                Log.w("MainActivity", "Menu inconnu : " + item.getTitle());
        }
        return super.onContextItemSelected(item);
    }

}