package com.max.healthy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class CreateProfile3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("maxime", "prof3");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_profile3);
        //pour recuperer la variable prenom
        Bundle extras = getIntent().getExtras();
        final TextView testPrenom = (TextView) findViewById(R.id.testTaille);
        testPrenom.setText(extras.getString("taille"));
        /*if (extras != null) {
            //Log.i("maxime", "taille="+taille);
            //The key argument here must match that used in the other activity

        }*/

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
        Intent intent = new Intent(this, CreateProfile4.class);
        //Log.i("maxime", "getparameter");
        Bundle extras = getIntent().getExtras();
        intent.putExtra("taille",extras.getInt("taille"));
        intent.putExtra("poids",extras.getInt("poids"));
        intent.putExtra("age",extras.getInt("age"));
        intent.putExtra("sexe",extras.getString("sexe"));
        intent.putExtra("nom", extras.getString("nom"));
        intent.putExtra("prenom", extras.getString("prenom"));
        startActivity(intent);
    }
    public void openNewActivity2(){
        Intent intent = new Intent(this, HomePageActivity.class);
        startActivity(intent);
    }

}