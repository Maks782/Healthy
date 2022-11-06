package com.max.healthy;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.splashscreen.SplashScreen;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.max.healthy.databinding.ActivityMainBinding;
import com.max.healthy.ui.login.LoginActivity;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private boolean isReady=false;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Handle the splash screen transition.
        SplashScreen.installSplashScreen(this);

        super.onCreate(savedInstanceState);

      //  binding = ActivityMainBinding.inflate(getLayoutInflater());
      //  setContentView(binding.getRoot());

        setContentView(R.layout.activity_first);
        View view = findViewById(android.R.id.content).getRootView();
        /*
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
*/
        button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivity();
            }
        });

        // Set up an OnPreDrawListener to the root view.
        view.getViewTreeObserver().addOnPreDrawListener(
                new ViewTreeObserver.OnPreDrawListener() {
                    @Override
                    public boolean onPreDraw() {
                        // Check if the initial data is ready.
                        if (isReady) {
                            // The content is ready; start drawing.
                            view.getViewTreeObserver().removeOnPreDrawListener(this);
                            return true;
                        } else {
                            // The content is not ready; suspend.
                            return false;
                        }
                    }
                });

        // wait 2 seconds before launching the app....
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                isReady = true;
            }
        }, 2000);


    }
    public void openNewActivity(){
        Intent intent = new Intent(this, TabActivity.class);
        startActivity(intent);
    }


}