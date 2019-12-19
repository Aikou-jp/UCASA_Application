package com.example.ucasa_application;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import java.util.ArrayList;

import static android.content.Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS;

public class SelectActivity extends AppCompatActivity {

    public static UsersServiceInfo usersServiceInfo;

    public static UsersServiceInfo getUsersServiceInfo() {
        return usersServiceInfo;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
//        LinearLayout linearLayout = findViewById(R.id.container_linear);
//        getLayoutInflater().inflate(R.layout., linearLayout);

        BottomNavigationView navView = findViewById(R.id.nav_view);

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications).build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:


                        ListView listView = findViewById(R.id.serviceListView);

                        getLayoutInflater().inflate(R.layout.fragment_home, listView);
                        return true;
                    case R.id.navigation_dashboard:
                        return true;
                    case R.id.navigation_notifications:
                        return true;
                }
                return false;
            }
        });
    }



    /** Called when the user taps the Send button */
    public void changeSensorActivity(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, SensorActivity.class);
        startActivity(intent);
    }

    public void onClick(View view){

    }

    public void changeRuleActivity(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, RuleActivity.class);
        startActivity(intent);
    }
    public void changeServiceActivity(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, ServiceActivity.class);
        startActivity(intent);
    }

}
