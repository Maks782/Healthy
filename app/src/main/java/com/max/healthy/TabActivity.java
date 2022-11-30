package com.max.healthy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class TabActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);


        //pour recuperer la variable prenom
        Bundle extras = getIntent().getExtras();
        final TextView calcIMC = (TextView) findViewById(R.id.calcIMC);
        calcIMC.setText(extras.getString("poids"));

        //int taillefinale = Integer.parseInt("taille");
        //int poidsfinal = Integer.parseInt("poids");
        //new int IMC = poidsfinal/(taillefinale*taillefinale);
        //switch case en fonction des valeurs de l'imc (normal/surpoids/obese...)
        //new int IMGH = (1,2*IMC)+(0,23*age)-10,8;
        //new int IMGF = (1,2*IMC)+(0,23*age);
        //switch case en fonction des valeurs de l'img (trop maigre/pourcentage normal/trop de graisse)
        // d'après ces premiers résultats il apparait que vous etes (ex) en surpoids avec trop
        // de graisse notre recommendation est la perte de poids et de continuer/commencer une activité

        //2eme onglet : mise en relation avec des specialistes

        //

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

    }
}