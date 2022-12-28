package com.max.healthy;
//Cette activity correpsond au premier bilan individualisé de l'utilisateur

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MonBilan extends AppCompatActivity {
    // c'est ici que l'on va récupérer et exploiter les différentes informations de l'utilisateur
    //que l'on a transmit de page en page.
    String ResIMC = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extras = getIntent().getExtras();

        setContentView(R.layout.activity_mon_bilan);
        int taille = extras.getInt("taille");
        int poids = extras.getInt("poids");
        int age = extras.getInt("age");
        String sexe = extras.getString("sexe");
        String prenom = extras.getString("prenom");

        String ResIMG = "";
// Ces différentes informations vont nous permettre de calculer l'IMC et l'IMG
        double IMC = poids / ((taille / 100.0) * (taille / 100.0));
        double IMG = 0;
        if (sexe.toLowerCase().equals("f")) {
            IMG = (1.2 * IMC) + (0.23 * age) - 5.4;
        } else {
            IMG = (1.2 * IMC) + (0.23 * age) - 10.8 - 5.4;
        }
// en fonction du résulat obtenus, on va exprimer le résulat de l'utilisateur en fonction des
// normes connues
        if (IMC <= 18.5) {
            ResIMC = "Maigreur";
        } else if (IMC > 18.5 && IMC <= 25) {
            ResIMC = "Normal";
        } else if (IMC > 25 && IMC <= 30) {
            ResIMC = "Surpoids";
        } else if (IMC > 30 && IMC <= 40) {
            ResIMC = "Obésité modérée";
        } else {
            ResIMC = "Obésité sévère";
        }

        if (sexe.toLowerCase().equals("f") && IMG <= 25){
            ResIMG = "Trop faible";
        } else if (sexe.toLowerCase().equals("f") && IMG > 25 && IMG <= 30){
            ResIMG = " Normal";
        } else if (sexe.toLowerCase().equals("f") && IMG > 30){
            ResIMG = "Trop élevé";
        }else if  (sexe.toLowerCase().equals("m") && IMG <= 15){
            ResIMG = "Trop faible";
        } else if (sexe.toLowerCase().equals("m") && IMG > 15 && IMG <= 20){
            ResIMG = " Normal";
        } else if (sexe.toLowerCase().equals("m") && IMG > 20) {
            ResIMG = "Trop élevé";
        }else{
            ResIMG = "erreur null";
        }

        findViewById(R.id.MonProfil).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivity();
            }
        });
        findViewById(R.id.imageButton6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivity2();
            }
        });
//Enfin on va afficher les différents résultats avec une petite phrase personnalisée
        final TextView viewIMC = (TextView) findViewById(R.id.viewIMC);
        viewIMC.setText(String.format("%.02f", IMC));

        final TextView viewIMG = (TextView) findViewById(R.id.viewIMG);
        viewIMG.setText(String.format("%.02f", IMG )+" %");

        final TextView viewConcl = (TextView) findViewById(R.id.viewConcl);
        viewConcl.setText("Salut " + prenom + ", d'après les résultats obtenus ta corpulence est la suivante : "+ResIMC +"\n De plus d'après ton IMG, ton pourcentage de masse grasse est  : "+ ResIMG);
    }

    public void openNewActivity(){
        Intent intent = new Intent(this, MonBilan2.class);
        Bundle extras = getIntent().getExtras();
        intent.putExtra("taille",extras.getInt("taille"));
        intent.putExtra("poids",extras.getInt("poids"));
        intent.putExtra("age",extras.getInt("age"));
        intent.putExtra("sexe",extras.getString("sexe"));
        intent.putExtra("nom", extras.getString("nom"));
        intent.putExtra("prenom", extras.getString("prenom"));
        intent.putExtra("activite", extras.getString("activite"));
        intent.putExtra("obj", extras.getString("obj"));
        intent.putExtra("ResImc",ResIMC);
        startActivity(intent);
    }
    public void openNewActivity2(){
        Intent intent = new Intent(this, HomePageActivity.class);
        startActivity(intent);
    }
}

//switch case en fonction des valeurs de l'imc (normal/surpoids/obese...)
//new int IMGH = (1,2*IMC)+(0,23*age)-10,8;
//new int IMGF = (1,2*IMC)+(0,23*age);
//switch case en fonction des valeurs de l'img (trop maigre/pourcentage normal/trop de graisse)
// d'après ces premiers résultats il apparait que vous etes (ex) en surpoids avec trop
// de graisse notre recommendation est la perte de poids et de continuer/commencer une activité