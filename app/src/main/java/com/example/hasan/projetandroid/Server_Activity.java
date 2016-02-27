package com.example.hasan.projetandroid;

import android.bluetooth.BluetoothAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Server_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_server_);


        BluetoothAdapter myBluetooth = BluetoothAdapter.getDefaultAdapter();
        AcceptThread accept = new AcceptThread(myBluetooth);
        accept.run();


    }
}
