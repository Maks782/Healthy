package com.max.healthy;
//Cette activity correspond à la page d'accueil de l'application
//l'utilisateur à le choix entre se connecter ou se créer un profil
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomePageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivity();
            }
        });
        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivity2();
            }
        });
    }

    public void openNewActivity(){
        Intent intent = new Intent(this, CreateProfile1.class);
        startActivity(intent);
    }

    public void openNewActivity2(){
        Intent intent = new Intent(this, Connect2ProfileActivity.class);
        startActivity(intent);
    }

}