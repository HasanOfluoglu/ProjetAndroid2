package com.example.hasan.projetandroid;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;
import android.widget.Toast;

import java.io.IOException;
import java.util.UUID;

/**
 * Created by hasan on 26/02/16.
 */


public class AcceptThread extends Thread {
    private final BluetoothServerSocket mmServerSocket;
    private final static String NAME = "SERVER";
    private final static UUID MY_UUID= new UUID(0,1000000000);
    public AcceptThread() {
        // Use a temporary object that is later assigned to mmServerSocket,
        // because mmServerSocket is final
        BluetoothServerSocket tmp = null;
        try {
            // MY_UUID is the app's UUID string, also used by the client code
            BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
            tmp = mBluetoothAdapter.listenUsingRfcommWithServiceRecord(NAME, MY_UUID);
            //TODO tmp = mBluetoothAdapter.listenUsingInsecureRfcommWithServiceRecord("meetphone", uuid);
        } catch (IOException e) {

        }
        mmServerSocket = tmp;
    }

    public void run() {
        BluetoothSocket socket = null;
        // Keep listening until exception occurs or a socket is returned
        while(true){
            try {
                socket = mmServerSocket.accept();
            } catch (IOException e) {

                try {
                    socket.close();
                } catch (IOException closeException) { }
            }
            // If a connection was accepted
            if (socket != null) {
                //Do work to manage the connection (in a separate thread)
                //manageConnectedSocket(socket);
                try {

                    mmServerSocket.close();
                } catch (IOException e) {
                    try {
                        socket.close();
                    } catch (IOException closeException) { }
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

    /** Will cancel the listening socket, and cause the thread to finish */
    public void cancel() {
        try {
            mmServerSocket.close();
        } catch (IOException e) { }
    }
}


