package com.example.jurekkiler.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DisplayWiFiActivity extends AppCompatActivity {

    private ListView lv;
    private TextView tv;
    protected WifiManager mainWifiObj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_wi_fi);
        lv = (ListView) findViewById(R.id.listView1);
        tv = (TextView) findViewById(R.id.txtWifiNetworks);
        getWifiNetworksList();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 0, 0, R.string.ref);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        mainWifiObj.startScan();
        return super.onOptionsItemSelected(item);
    }

    private void getWifiNetworksList() {
        mainWifiObj = (WifiManager) getSystemService(Context.WIFI_SERVICE);
        WifiScanReceiver wifiReciever = new WifiScanReceiver();
        registerReceiver(wifiReciever, new IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));
        mainWifiObj.startScan();
    }

    class WifiScanReceiver extends BroadcastReceiver {

        ArrayList<String> lista = new ArrayList<String>();

        @Override
        public void onReceive(Context c, Intent intent) {
            StringBuilder sb = new StringBuilder();
            List<ScanResult> scanList = mainWifiObj.getScanResults();
            LayoutInflater inflater = LayoutInflater.from(DisplayWiFiActivity.this);
            View mTop = inflater.inflate(R.layout.header, null);
            sb.append(getResources().getString(R.string.nr_of_wifi)).append(": ").append(scanList.size()).append("\n");
            lista.clear();
            for (int i = 0; i < scanList.size(); i++)
                lista.add(scanList.get(i).SSID);
            tv.setText(sb);
            lv.addHeaderView(mTop);
            lv.addFooterView(mTop);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(DisplayWiFiActivity.this,
                    android.R.layout.simple_list_item_1,
                    android.R.id.text1,
                    lista);
            lv.setAdapter(adapter);
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(DisplayWiFiActivity.this, WiFipassword.class);
                    intent.putExtra("ssid", lista.get(position-1));
                    startActivity(intent);
                }
            });
        }
    }
}