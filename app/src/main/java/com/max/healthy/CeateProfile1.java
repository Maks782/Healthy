package com.max.healthy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CeateProfile1 extends AppCompatActivity {

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
        findViewById(R.id.imageButton4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivity2();
            }
        });
    }

    public void openNewActivity(){
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