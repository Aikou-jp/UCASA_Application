package com.example.ucasa_application;

import android.app.Service;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import static com.example.ucasa_application.SelectActivity.usersServiceInfo;

public class ServiceActivity extends AppCompatActivity {

    private EditText Name;
    private Spinner spinnerContext;
    private Spinner spinnerService;

    private String contextName,serviceName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Backボタンを有効にする
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    public void onClick(View view){
        switch (view.getId()) {
            case R.id.save_button:
                // ボタン「保存」がタップされたとき

                Name = (EditText)findViewById(R.id.rule_name);

                spinnerContext = (Spinner)findViewById(R.id.spinner2);
                contextName = (String)spinnerContext.getSelectedItem();

                spinnerService = (Spinner)findViewById(R.id.spinner3);
                serviceName = (String)spinnerContext.getSelectedItem();

                store();
                break;
        }
    }

    private void store(){
        usersServiceInfo.setName(Name.getText().toString());
        usersServiceInfo.setContext(contextName);
        usersServiceInfo.setService(serviceName);

        ObjectStorage.save(usersServiceInfo, CachePref.KEY_USER);
    }

    private void load(){
        usersServiceInfo = ObjectStorage.get(CachePref.KEY_USER, UsersServiceInfo.class);

        // 読み込んだデータを画面に反映する
        setDtoToView();
    }

    /**
     * 画面のデータを画面に反映する
     */
    private void setDtoToView(){
        Name.setText(usersServiceInfo.getName());
    }

    // Toolbarのアイテムがタップされた場合に呼ばれる
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            // Backボタンがタップされた場合
            case android.R.id.home:
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

}
