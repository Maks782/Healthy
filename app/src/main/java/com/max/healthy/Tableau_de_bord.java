package com.max.healthy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.ToggleButton;

public class Tableau_de_bord extends AppCompatActivity {
    private int progr = 0;
    private int progr2 = 0;
    private double kal = 0;
    private double kal2 = 0;
    private int poids = 0;
    private int kilos = 0;
    private int diff = 0;
    private String prenom;
    private int delai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extras = getIntent().getExtras();
        kal =  extras.getDouble("Kal");
        poids = extras.getInt("poids");
        kilos = extras.getInt("kilos");
        prenom = extras.getString("prenom");
        delai = extras.getInt("delai");
        delai = delai *7;
        setContentView(R.layout.activity_tableau_de_bord);
        updateProgressBar(0);
        updateProgressBar2(0);

        TextView titre = (TextView) findViewById(R.id.titre);
        titre.setText("Bonjour "+prenom+" , Bon courage pour atteindre ton objectif !");

        TextView titreDelai = (TextView) findViewById(R.id.JoursRestants);
        titreDelai.setText(delai+" jours restants");

        findViewById(R.id.majKal).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String kalStr = ((EditText) findViewById(R.id.calories)).getText().toString();
                kal2 = Integer.parseInt(kalStr);
            progr += (int)((kal2/kal)*100);
            if(progr<=100) {
                updateProgressBar(progr);
            }
            if(progr>100){
                updateProgressBar(100);
            }
            }
        });
        findViewById(R.id.majKal2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String poidsActuelStr = ((EditText) findViewById(R.id.calories2)).getText().toString();
                diff = Integer.parseInt(poidsActuelStr)-poids;
                diff = Math.abs(diff);
                progr2 = (int)((diff*100/kilos));
                if(progr2<=100) {
                    updateProgressBar2(progr2);
                }
                if(progr2>100){
                    updateProgressBar(100);
                }
            }
        });

    }
     void updateProgressBar(int a){
         ProgressBar progress_bar = (ProgressBar) findViewById(R.id.progress_bar);
         progress_bar.setProgress(a);
         TextView text_view_progress2 = (TextView) findViewById(R.id.text_view_progress2);
         text_view_progress2.setText(""+a+" %");
    }
    void updateProgressBar2(int a){
        ProgressBar progress_bar = (ProgressBar) findViewById(R.id.progress_bar2);
        progress_bar.setProgress(a);
        TextView text_view_progress2 = (TextView) findViewById(R.id.text_view_progress);
        text_view_progress2.setText(""+a+" %");
    }
}