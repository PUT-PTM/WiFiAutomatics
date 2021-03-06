package com.example.user.wifiautomatics;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class WiFipassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wi_fipassword);
        String ssid = getResources().getString(R.string.network) + ": " + getSSID();
        TextView tv = (TextView)findViewById(R.id.textView8);
        tv.setText(ssid);
    }

    protected String getSSID() {
        Intent intent = getIntent();
        return intent.getExtras().getString("ssid");
    }

    public void cancel(View view) {
        WiFipassword.this.onBackPressed();
    }

    public void connect(View view) {
        EditText et = (EditText)findViewById(R.id.editText2);
        String pass = et.getText().toString();
        //new Client("^" + getSSID() + ";" + pass + ";").execute();
        Client c = (Client) new Client("192.168.4.1", "^" + getSSID() + ";" + pass + ";").execute();
        while(c.message_in == null) {}
        Toast myToast = Toast.makeText(getBaseContext(), c.message_in, Toast.LENGTH_LONG);
        myToast.show();
        if (c.message_in.equals("Connected")) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        } else {
            this.recreate();
        }
    }
}
