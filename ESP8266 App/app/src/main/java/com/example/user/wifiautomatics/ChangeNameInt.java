package com.example.user.wifiautomatics;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ChangeNameInt extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_name);
    }

    public void cancel(View view) {
        ChangeNameInt.this.onBackPressed();
    }

    public void ok(View view) {

    }
}
