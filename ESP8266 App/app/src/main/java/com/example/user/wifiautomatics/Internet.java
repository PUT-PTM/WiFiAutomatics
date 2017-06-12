package com.example.user.wifiautomatics;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class Internet extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internet);

        ToggleButton relay1net = (ToggleButton)findViewById(R.id.toggleButton);
        ToggleButton relay2net = (ToggleButton)findViewById(R.id.toggleButton2);

        relay1net.setOnCheckedChangeListener(new ToggleButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton toggleButton, boolean isChecked) {
                if (isChecked)
                {
                    new Client("195.181.209.127", "#").execute();
                    Toast myToast = Toast.makeText(getBaseContext(), "Relay #1 ON", Toast.LENGTH_SHORT);
                    myToast.show();
                }
                else
                {
                    new Client("195.181.209.127", "#").execute();
                    Toast myToast = Toast.makeText(getBaseContext(), "Relay #1 OFF", Toast.LENGTH_SHORT);
                    myToast.show();
                }
            }
        });

        relay2net.setOnCheckedChangeListener(new ToggleButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton toggleButton, boolean isChecked) {
                if (isChecked)
                {
                    new Client("195.181.209.127", "$").execute();
                    Toast myToast = Toast.makeText(getBaseContext(), "Relay #2 ON", Toast.LENGTH_SHORT);
                    myToast.show();
                }
                else
                {
                    new Client("195.181.209.127", "$").execute();
                    Toast myToast = Toast.makeText(getBaseContext(), "Relay #2 OFF", Toast.LENGTH_SHORT);
                    myToast.show();
                }
            }
        });

        relay1net.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Intent intent = new Intent(Internet.this, ChangeNameInt.class);
                startActivity(intent);
                return true;
            }
        });

        relay2net.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Intent intent = new Intent(Internet.this, ChangeNameInt.class);
                startActivity(intent);
                return true;
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 0, 0, "Połącz z siecią");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(this, DisplayWiFiActivity.class);
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }
}
