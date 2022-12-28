package com.max.healthy;
//Cette activity correpsond à la troisème partie de création du profil

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class CreateProfile3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("maxime", "prof3");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_profile3);
        //pour recuperer la variable prenom
        Bundle extras = getIntent().getExtras();

        findViewById(R.id.button7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivity();
            }
        });
        findViewById(R.id.imageButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivity2();
            }
        });
    }

    public void openNewActivity(){
        String Activite ="";
        Intent intent = new Intent(this, CreateProfile4.class);
        //Log.i("maxime", "getparameter");
        Bundle extras = getIntent().getExtras();
        intent.putExtra("taille",extras.getInt("taille"));
        intent.putExtra("poids",extras.getInt("poids"));
        intent.putExtra("age",extras.getInt("age"));
        intent.putExtra("sexe",extras.getString("sexe"));
        intent.putExtra("nom", extras.getString("nom"));
        intent.putExtra("prenom", extras.getString("prenom"));

       Boolean swActif = ((Switch)findViewById(R.id.swActif)).isChecked();
        Boolean swPasActif = ((Switch)findViewById(R.id.swPasActif)).isChecked();
        Boolean swTresActif = ((Switch)findViewById(R.id.swTresActif)).isChecked();
        if (swActif){
           Activite = "Actif";
       }else if (swPasActif){
           Activite = " Pas Actif";
       }else if (swTresActif){
            Activite = " Tres Actif";
        }else{
            Activite ="erreur null";
        }
        intent.putExtra("activite",Activite);

        startActivity(intent);
    }
    public void openNewActivity2(){
        Intent intent = new Intent(this, HomePageActivity.class);
        startActivity(intent);
    }

}