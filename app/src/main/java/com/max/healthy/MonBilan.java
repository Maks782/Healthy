package com.max.healthy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MonBilan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mon_bilan);
        Bundle extras = getIntent().getExtras();

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
    }

    public void openNewActivity(){
        Intent intent = new Intent(this, TabActivity.class);
        Bundle extras = getIntent().getExtras();
        intent.putExtra("poids",extras.getString("poids"));
        //intent.putExtra("poids",extras.getString("poids"));
        startActivity(intent);
    }
    public void openNewActivity2(){
        Intent intent = new Intent(this, HomePageActivity.class);
        startActivity(intent);
    }

}