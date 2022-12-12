package com.max.healthy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class MonBilan2 extends AppCompatActivity {
    double Kal = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extras = getIntent().getExtras();
        setContentView(R.layout.activity_mon_bilan2);

        String Activite = extras.getString("activite");
        String obj = extras.getString("obj");
        double taille = extras.getInt("taille");
        taille = taille/100;
        int poids = extras.getInt("poids");
        int age = extras.getInt("age");
        String sexe = extras.getString("sexe");
        String prenom = extras.getString("prenom");
        String ResIMC = extras.getString("ResImc");
        double Mb = 0;




        findViewById(R.id.SuiteBilan).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivity();
            }
        });
        findViewById(R.id.imageButton7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivity2();
            }
        });

        
        if (age <= 59 || (ResIMC.equals("Surpoids")==false && ResIMC.equals("Obésité modérée")==false || ResIMC.equals("Obésité sévère")==false) ){

            if (sexe.toLowerCase().equals("m")){

                Mb = 13.707* poids + 492.3*taille -6.673*age + 77.607;

                if(Activite.equals(" Tres Actif")){
                    Mb= Mb * 1.725;
                }

                if(Activite.equals("Actif")){
                    Mb= Mb * 1.55;
                }

                if(Activite.equals(" Pas Actif")){
                    Mb= Mb * 1.2;
                }
            }
            
            if (sexe.toLowerCase().equals("f")){

                Mb = 9.740* poids + 172.9*taille - 4.737*age + 667.051;

                if(Activite.equals(" Tres Actif")){
                    Mb= Mb * 1.725;
                }

                if(Activite.equals("Actif")){
                    Mb= Mb * 1.55;
                }

                if(Activite.equals(" Pas Actif")){
                    Mb= Mb * 1.2;
                }
            }
        }

            if(age >=60 || (ResIMC.equals("Maigreur")==false && ResIMC.equals("Normal")==false)) {

            if (sexe.toLowerCase().equals( "m")){

                Mb = 259*(Math.pow(poids,0.48))*(Math.pow(taille,0.50))*(Math.pow(age,-0.13));

                if(Activite.equals(" Tres Actif")){
                    Mb= Mb * 1.725;
                }

                if(Activite.equals("Actif")){
                    Mb= Mb * 1.55;
                }

                if(Activite.equals( " Pas Actif")){
                    Mb= Mb * 1.2;
                }
            }

            if (sexe.toLowerCase().equals( "f")){

                Mb = 230*(Math.pow(poids,0.48))*(Math.pow(taille,0.50))*(Math.pow(age,-0.13));

                if(Activite.equals(" Tres Actif")){
                    Mb= Mb * 1.725;
                }

                if(Activite.equals("Actif")){
                    Mb= Mb * 1.55;
                }

                if(Activite.equals(" Pas Actif")){
                    Mb= Mb * 1.2;
                }
            }


        }



        if( obj.equals("Prise")){
            Kal = Mb + 200;
        }

        if( obj.equals("Perte")){
            Kal = Mb - 350;
        }

        if( obj.equals("Maintien")){
            Kal = Mb;
        }

        final TextView Meta1 = (TextView) findViewById(R.id.Meta1);
        Meta1.setText("D'après les informations renseignées, tu as un métabolisme de " +String.format("%.02f", Mb )+ " Kilocalories par jour");

        final TextView Kal1 = (TextView) findViewById(R.id.Kal1);
        Kal1.setText("Pour répondre à tes objectifs, nous te conseillons de consommer environ " +String.format("%.02f", Kal) + " Kilocalories par jour");
}



    public void openNewActivity(){
        Intent intent = new Intent(this, Monbilan3.class);
        Bundle extras = getIntent().getExtras();
        intent.putExtra("taille",extras.getInt("taille"));
        intent.putExtra("poids",extras.getInt("poids"));
        intent.putExtra("age",extras.getInt("age"));
        intent.putExtra("sexe",extras.getString("sexe"));
        intent.putExtra("nom", extras.getString("nom"));
        intent.putExtra("prenom", extras.getString("prenom"));
        intent.putExtra("activite", extras.getString("activite"));
        intent.putExtra("obj", extras.getString("obj"));
        intent.putExtra("ResImc", extras.getString("ResImc"));
        intent.putExtra("Kal",Kal);
        startActivity(intent);

    }
    public void openNewActivity2(){
        Intent intent = new Intent(this, HomePageActivity.class);
        startActivity(intent);
    }
}