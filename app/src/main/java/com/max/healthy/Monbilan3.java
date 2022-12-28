package com.max.healthy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Monbilan3 extends AppCompatActivity {
int delai;
int kilos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extras = getIntent().getExtras();
        setContentView(R.layout.activity_monbilan3);
        double taille = extras.getInt("taille");
        String sexe = extras.getString("sexe");
        int poidsIdeal = 0;
        if (sexe.toLowerCase().equals("m")) {
            poidsIdeal = (int) (taille - 100 - ((taille - 150) / 4));
        }
        if (sexe.toLowerCase().equals("f")) {
            poidsIdeal = (int) (taille- 100 - ((taille- 150) /2.5 ));
        }

        final TextView PIdeal = (TextView) findViewById(R.id.PoidsIdeal);
        PIdeal.setText("D'après les informations renseignées, nous estimons que, pour ta taille, le poids idéal est de " +poidsIdeal+ " kilos");

        findViewById(R.id.Calculer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String kilosStr = ((EditText) findViewById(R.id.Kilos)).getText().toString();
                kilos = Integer.parseInt(kilosStr);
                delai = (int) (kilos * 1.5);
                final TextView Delai = (TextView) findViewById(R.id.resultat);
                Delai.setText("D'après nos estimations, ton objectif est atteignable en " + delai + " semaines");
            }
        });
        findViewById(R.id.Commencer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivity2();
            }
        });
        findViewById(R.id.logo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivity3();
            }
        });


    }

    /*public void openNewActivity() {
        Intent intent = new Intent(this, Monbilan3.class);
        String kilosStr = ((EditText) findViewById(R.id.Kilos)).getText().toString();
        kilos = Integer.parseInt(kilosStr);
        delai = (int) (kilos * 0.7);
        final TextView Delai = (TextView) findViewById(R.id.resultat);
        Delai.setText("D'après nos estimations, votre objectif est atteignable en " + delai + " semaines");
        startActivity(intent);
    }*/

    public void openNewActivity2(){
        Intent intent = new Intent(this, Tableau_de_bord.class);
        Bundle extras = getIntent().getExtras();
        intent.putExtra("taille",extras.getInt("taille"));
        intent.putExtra("poids",extras.getInt("poids"));
        intent.putExtra("age",extras.getInt("age"));
        intent.putExtra("sexe",extras.getString("sexe"));
        intent.putExtra("nom", extras.getString("nom"));
        intent.putExtra("prenom", extras.getString("prenom"));
        intent.putExtra("activite", extras.getString("activite"));
        intent.putExtra("obj", extras.getString("obj"));
        intent.putExtra("Kal", extras.getDouble("Kal"));
        intent.putExtra("ResImc", extras.getString("ResImc"));
        intent.putExtra("delai",delai);
        //intent.putExtra("delai", extras.getInt("delai"));
        intent.putExtra("kilos",kilos);
        //intent.putExtra("kilos", extras.getInt("kilos"));
        startActivity(intent);
    }
    public void openNewActivity3(){
        Intent intent = new Intent(this, HomePageActivity.class);
        startActivity(intent);
    }

}