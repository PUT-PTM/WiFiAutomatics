package com.example.jurekkiler.myapplication;

import android.os.AsyncTask;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client extends AsyncTask<Void,Void,Void> {

    private String message;

    Client(String m) {
        message = m;
    }

    @Override
    protected Void doInBackground(Void... params) {
        try {
            Socket socket = new Socket("192.168.4.1", 1337);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            out.write(message);
            out.flush();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
