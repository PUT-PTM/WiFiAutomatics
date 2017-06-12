package com.example.user.wifiautomatics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class Local extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local);

        ToggleButton relay1 = (ToggleButton)findViewById(R.id.toggleButton3);
        ToggleButton relay2 = (ToggleButton)findViewById(R.id.toggleButton4);

        Client c = (Client) new Client("192.168.4.1", "?").execute();
        int i = 1000000000;
        while (i > 0)
        {
            if (c.message_in != null) {
                switch (c.message_in) {
                    case "10":
                        relay1.setChecked(true);
                        break;
                    case "01":
                        relay2.setChecked(true);
                        break;
                    case "11":
                        relay1.setChecked(true);
                        relay2.setChecked(true);
                        break;
                }
                break;
            }
            i--;
        }

        relay1.setOnCheckedChangeListener(new ToggleButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton toggleButton, boolean isChecked) {
                if (isChecked)
                {
                    new Client("192.168.4.1", "#").execute();
                    Toast myToast = Toast.makeText(getBaseContext(), "Relay #1 ON", Toast.LENGTH_SHORT);
                    myToast.show();
                }
                else
                {
                    new Client("192.168.4.1", "#").execute();
                    Toast myToast = Toast.makeText(getBaseContext(), "Relay #1 OFF", Toast.LENGTH_SHORT);
                    myToast.show();
                }
            }
        });

        relay2.setOnCheckedChangeListener(new ToggleButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton toggleButton, boolean isChecked) {
                if (isChecked)
                {
                    new Client("192.168.4.1", "$").execute();
                    Toast myToast = Toast.makeText(getBaseContext(), "Relay #2 ON", Toast.LENGTH_SHORT);
                    myToast.show();
                }
                else
                {
                    new Client("192.168.4.1", "$").execute();
                    Toast myToast = Toast.makeText(getBaseContext(), "Relay #2 OFF", Toast.LENGTH_SHORT);
                    myToast.show();
                }
            }
        });

        relay1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Intent intent = new Intent(Local.this, ChangeNameInt.class);
                startActivity(intent);
                return true;
            }
        });

        relay2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Intent intent = new Intent(Local.this, ChangeNameInt.class);
                startActivity(intent);
                return true;
            }
        });
    }
}
