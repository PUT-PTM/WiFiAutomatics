package com.example.jurekkiler.myapplication;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client extends AsyncTask<Void,Void,Void> {

    private String message_out;
    public String message_in;

    Client(String m) {
        message_out = m;
    }

    @Override
    protected Void doInBackground(Void... params) {
        try {
            Socket socket = new Socket("192.168.4.1", 1337);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader cin = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out.write(message_out);
            out.flush();
            message_in = cin.readLine();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
