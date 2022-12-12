package com.max.healthy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ToggleButton;

public class CreateProfile4 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_profile4);

        Bundle extras = getIntent().getExtras();

        findViewById(R.id.button8).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivity();
            }
        });
        findViewById(R.id.imageButton2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivity2();
            }
        });




    }

    public void openNewActivity(){
        Intent intent = new Intent(this, MonBilan.class);
        Bundle extras = getIntent().getExtras();
        intent.putExtra("taille",extras.getInt("taille"));
        intent.putExtra("poids",extras.getInt("poids"));
        intent.putExtra("age",extras.getInt("age"));
        intent.putExtra("sexe",extras.getString("sexe"));
        intent.putExtra("nom", extras.getString("nom"));
        intent.putExtra("prenom", extras.getString("prenom"));
        intent.putExtra("activite", extras.getString("activite"));

        String obj ="";
        ToggleButton PertePoids = (ToggleButton) findViewById(R.id.toggleButton);
        ToggleButton Maintien = (ToggleButton) findViewById(R.id.toggleButton3);
        ToggleButton PrisePoids = (ToggleButton) findViewById(R.id.toggleButton2);

        Boolean PerteActif = PertePoids.isChecked();
        Boolean MaintienActif = Maintien.isChecked();
        Boolean PriseActif = PrisePoids.isChecked();

        if(PerteActif){
            obj = "Perte" ;
            Maintien.setChecked(false);
            PrisePoids.setChecked(false);
        }

        if(MaintienActif){
            obj = "Maintien" ;
            PertePoids.setChecked(false);
            PrisePoids.setChecked(false);
        }

        if(PriseActif){
            obj = "Prise" ;
            PertePoids.setChecked(false);
            Maintien.setChecked(false);
        }
        intent.putExtra("obj",obj);
        startActivity(intent);
    }
    public void openNewActivity2(){
        Intent intent = new Intent(this, HomePageActivity.class);
        startActivity(intent);
    }

}