package com.max.healthy;
//Cette activity correpsond à la première partie de création du profil
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CreateProfile1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_profile1);

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivity();
            }
        });
        // les boutons marchent de la manière suivante : on cherche sur la page un bouton via son
        //identifiant que l'on a fixé dans les layout, puis lorsque l'on a trouvé ce bouton, on lui
        // associe un listener qui sera appeler quand l'utilisateur appuie sur le bouton
        // le listener va alors appeler la fonction openNewActivity() qui elle va permettre
        // de passer à l'activity suivante ici il s'agit de CreateProfile2
        findViewById(R.id.imageButton4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivity2();
            }
        });
        // Ce bouton est un peu différent, il s'agit d'un imageButton, il est présent sur toutes
        // les pages et permet de revenir à la page d'accueil lorsque l'utilisateur s'est trompé
    }

    public void openNewActivity(){
        //Ici on récupère les informations de nom et prenom que l'on transmettra aux pages
        //suivantes sous forme de String
        String nom;
        String prenom;
        nom = ((EditText)findViewById(R.id.editNom)).getText().toString();
        prenom = ((EditText)findViewById(R.id.editPrenom)).getText().toString();
        Intent intent = new Intent(this, CreateProfile2.class);
        intent.putExtra("nom", nom);
        intent.putExtra("prenom",prenom);
        startActivity(intent);
    }
    public void openNewActivity2(){
        Intent intent = new Intent(this, HomePageActivity.class);
        startActivity(intent);
    }

}