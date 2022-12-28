package com.max.healthy;
//Cette activity correpsond à la seconde partie de création du profil
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CreateProfile2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_profile2);

        findViewById(R.id.button6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivity();
            }
        });
        findViewById(R.id.imageButton3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivity2();
            }
        });

    }

    public void openNewActivity(){
        // ici on va récupérer d'autres informations que l'utilisateur entre tel que la taille
        //le poids, l'age et le sexe.
        // Ici certaine informations seront récupérées sous forme de String et d'autre en int
        //On verifiera que l'utilisateur rentre bien des chiffre lorsque que cela lui est demandé
        // au risque de ne pas pouvoir passer à la page suivante
        int taille;
        int poids;
        int age;
        String sexe;
        try {
            String tailleStr = ((EditText)findViewById(R.id.editTaille)).getText().toString();
            taille = Integer.parseInt(tailleStr);
        } catch(NumberFormatException ex) {
           return ;
        }

        try {
            String poidStr = ((EditText)findViewById(R.id.editPoids)).getText().toString();
            poids = Integer.parseInt(poidStr);
        } catch(NumberFormatException ex) {
            return ;
        }

        try {
            String ageStr = ((EditText)findViewById(R.id.editAge)).getText().toString();
            age = Integer.parseInt(ageStr);
        } catch(NumberFormatException ex) {
            return ;
        }

        sexe = ((EditText)findViewById(R.id.editSexe)).getText().toString().toLowerCase();
        if (!sexe.equals("f") && !sexe.equals("m")) {
            return;
        }

        Intent intent = new Intent(this, CreateProfile3.class);
        intent.putExtra("taille", taille);
        intent.putExtra("poids",poids);
        intent.putExtra("age",age);
        intent.putExtra("sexe",sexe);
        Bundle extras = getIntent().getExtras();
        intent.putExtra("nom", extras.getString("nom"));
        intent.putExtra("prenom", extras.getString("prenom"));

        //intent.putExtra("poids",((EditText)findViewById(R.id.editPoids)).getText().toString());
        startActivity(intent);

    }
    public void openNewActivity2(){
        Intent intent = new Intent(this, HomePageActivity.class);
        startActivity(intent);
    }


}