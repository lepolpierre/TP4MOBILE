package com.example.tp4mobilegwenaelgalliot;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tp4mobilegwenaelgalliot.databinding.ActivityConnectionBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.google.firebase.auth.FirebaseUser;

public class ConnectionActivity extends AppCompatActivity {

    ActivityConnectionBinding binding;
    private FirebaseAuth mAuth;

    private static final String TAG = "***SignIn";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityConnectionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Instance du service d'authentification
        mAuth = FirebaseAuth.getInstance();

        // Si token user déjà valide
        if (mAuth.getCurrentUser() != null) {
//            Log.d(TAG, "onCreate: " + mAuth.getCurrentUser());
//            Toast.makeText(this, "Vous êtes déjà connecté.", Toast.LENGTH_SHORT).show();
//            updateUi(mAuth.getCurrentUser());

            Intent intent;
            intent = new Intent(ConnectionActivity.this, MainActivity.class);
            startActivity(intent);
        }

        // Connexion
        binding.buttonConnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn(binding.editTextTextEmail.getText().toString(), binding.editTextTextPassword.getText().toString());
            }
        });
    }

    private void signIn(String courriel, String mdp) {

        mAuth.signInWithEmailAndPassword(courriel, mdp)

                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(ConnectionActivity.this, "Connecté.",
                                    Toast.LENGTH_SHORT).show();
                            //updateUi(user);

                            Intent intent;
                            intent = new Intent(ConnectionActivity.this, MainActivity.class);
                            startActivity(intent);
                        } else {
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                        }
                    }
                })
                // Ce callback nous permet d'avoir accès aux exceptions

                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        if (e instanceof FirebaseAuthInvalidCredentialsException) {
                            Toast.makeText(ConnectionActivity.this, "Mot-de-Passe Incorrect.",
                                    Toast.LENGTH_SHORT).show();
                        } else if (e instanceof FirebaseAuthInvalidUserException) {
                            Toast.makeText(ConnectionActivity.this, "Adresse Courriel Incorrecte.",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(ConnectionActivity.this, "Échec de Connexion.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

//    private void updateUi(FirebaseUser user) {
//        // token retourné par Firebase : utile si on doit par la suite communiquer avec un backend tierce
//        binding.textView5.setText("Bienvenue "+user.getIdToken(true));
//
//        binding.textView5.setText("Bienvenue "+user.getDisplayName());
//
//        if (user.isEmailVerified() == true) binding.textView6.setText("Courriel vérifié");
//        else binding.textView6.setText("Courriel non vérifié");
//    }

    @Override
    protected void onStop() {
        super.onStop();
        FirebaseAuth.getInstance().signOut();
    }
}