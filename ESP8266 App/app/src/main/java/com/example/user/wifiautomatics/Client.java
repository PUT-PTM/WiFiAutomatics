package com.example.user.wifiautomatics;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client extends AsyncTask<Void,Void,Void> {

    private String IP;
    private String message_out;
    public String message_in;

    Client(String IP, String m) {
        message_out = m;
        this.IP = IP;
    }

    @Override
    protected Void doInBackground(Void... params) {
        try {
            Socket socket = new Socket(IP, 1337);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader cin = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out.write(message_out);
            out.flush();
            message_in = cin.readLine();
            cin.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
