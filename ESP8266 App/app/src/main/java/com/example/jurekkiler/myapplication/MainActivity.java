package com.example.jurekkiler.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ToggleButton relay1 = (ToggleButton)findViewById(R.id.toggleButton3);
        relay1.setOnCheckedChangeListener(new ToggleButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton toggleButton, boolean isChecked) {
                if (isChecked)
                {
                    new Client("#").execute();
                    Toast myToast = Toast.makeText(getBaseContext(), "Relay #1 ON", Toast.LENGTH_SHORT);
                    myToast.show();
                }
                else
                {
                    new Client("#").execute();
                    Toast myToast = Toast.makeText(getBaseContext(), "Relay #1 OFF", Toast.LENGTH_SHORT);
                    myToast.show();
                }
            }
        });

        ToggleButton relay2 = (ToggleButton)findViewById(R.id.toggleButton4);
        relay2.setOnCheckedChangeListener(new ToggleButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton toggleButton, boolean isChecked) {
                if (isChecked)
                {
                    new Client("$").execute();
                    Toast myToast = Toast.makeText(getBaseContext(), "Relay #2 ON", Toast.LENGTH_SHORT);
                    myToast.show();
                }
                else
                {
                    new Client("$").execute();
                    Toast myToast = Toast.makeText(getBaseContext(), "Relay #2 OFF", Toast.LENGTH_SHORT);
                    myToast.show();
                }
            }
        });
    }

    public void connectWifi(View view) {
        Intent intent = new Intent(this, DisplayWiFiActivity.class);
        startActivity(intent);
    }
}
