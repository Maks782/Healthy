package com.max.healthy;
// Cette activity sert aux utilisateurs qui ont déjà un profil, dans notre cas on ne stocke pas encore
// de profil sur un serveur, c'est une partie que nous aimerions développer davantage
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Connect2ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect2_profile);

        findViewById(R.id.button5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //openNewActivity();
            }
        });
        findViewById(R.id.imageButton9).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {openNewActivity2();
            }
        });
    }

    public void openNewActivity(){
        Intent intent = new Intent(this, TabActivity.class);
        startActivity(intent);
    }
    public void openNewActivity2(){
        Intent intent = new Intent(this, HomePageActivity.class);
        startActivity(intent);
    }
}
