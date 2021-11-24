package com.example.tp4mobilegwenaelgalliot;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.tp4mobilegwenaelgalliot.databinding.ActivityMainBinding;
import com.example.tp4mobilegwenaelgalliot.databinding.ActivityInscriptionBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

public class InscriptionActivity extends AppCompatActivity {

    private ActivityInscriptionBinding binding;
    private FirebaseAuth mAuth;



    private static final String TAG = "***SignUp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityInscriptionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Instance du service d'authentification
        mAuth = FirebaseAuth.getInstance();

        // Si token user déjà valide
        if (mAuth.getCurrentUser() != null) {
            Log.d(TAG, "onCreate: " + mAuth.getCurrentUser());
            Toast.makeText(this, "Vous êtes déjà connecté.", Toast.LENGTH_SHORT).show();
            updateUi(mAuth.getCurrentUser());
        }

        // Création de compte
        binding.buttonSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createAccount(binding.editTextTextPersonName.getText().toString(), binding.editTextTextEmail.getText().toString(), binding.editTextTextPassword.getText().toString());
            }
        });

        binding.buttonDejaInscrit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(InscriptionActivity.this, ConnectionActivity.class));
            }
        });
    }

    // Inscription
    private void createAccount(String nom, String courriel, String mdp) {
        // mode courriel + mdp : noter qu'on ne peut pas vraiment passer un username
        mAuth.createUserWithEmailAndPassword(courriel, mdp)

                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Succès, on a désormais accès a l'objet utilisateur
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Intent intent;
                            intent = new Intent(InscriptionActivity.this, ConnectionActivity.class);
                            startActivity(intent);


                            // Mais on peut construire un profil associé à un utilisateur
                            UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                                    .setDisplayName(nom)
                                    // on peut également ajouter une photo avec .setPhotoUri(Uri uri)
                                    .build();

                            user.updateProfile(profileUpdates)
                                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if (task.isSuccessful()) {
                                                Log.d(TAG, "Profil mis à jour.");

                                                Toast.makeText(InscriptionActivity.this, "Bienvenue Nouvel Utilisateur.",
                                                        Toast.LENGTH_SHORT).show();
                                                updateUi(user);
                                            }
                                        }
                                    });
                        } else {
                            // Échec
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(InscriptionActivity.this, "Échec de l'Authentication.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
        // Ici, on pourrait ajouter un callback .addOnFailureListener
    }

    private void updateUi(FirebaseUser user) {

//        // token retourné par Firebase : utile si on doit par la suite communiquer avec un backend tierce
//        binding.textView5.setText("Bienvenue "+user.getIdToken(true));
//
//        binding.textView5.setText("Bienvenue "+user.getDisplayName());
//
//        if (user.isEmailVerified()) binding.textView6.setText("Courriel vérifié");
//        else binding.textView6.setText("Courriel non vérifié");
    }

    @Override
    protected void onStop() {
        super.onStop();
        FirebaseAuth.getInstance().signOut();
    }
}