package com.example.user.wifiautomatics;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class ChangeName extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_name);
    }

    public void cancel(View view) {
        ChangeName.this.onBackPressed();
    }

    public void ok(View view) {
        Intent intent = new Intent(ChangeName.this, Local.class);
        //intent.putExtra();
        startActivity(intent);
    }
}
