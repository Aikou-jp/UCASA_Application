package com.example.ucasa_application;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

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

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications).build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
        /*ArrayList data = new ArrayList<>();
        data.add("サービス");
        if(usersServiceInfo.name != null) {
            data.add(usersServiceInfo.getName());
        }

        // リスト項目とListViewを対応付けるArrayAdapterを用意する
        ArrayAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);

        // ListViewにArrayAdapterを設定する
        ListView listView = (ListView)findViewById(R.id.serviceListView);
        listView.setAdapter(adapter);*/
    }
    /** Called when the user taps the Send button */
    public void changeSensorActivity(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, SensorActivity.class);
        startActivity(intent);
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
