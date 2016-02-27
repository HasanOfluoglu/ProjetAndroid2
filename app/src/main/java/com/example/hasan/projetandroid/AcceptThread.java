package com.example.hasan.projetandroid;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.widget.Toast;

import java.io.IOException;
import java.util.UUID;

/**
 * Created by hasan on 26/02/16.
 */


public class AcceptThread extends Thread {
        private final BluetoothServerSocket blueServerSocket;
    private final static UUID MY_UUID= new UUID(1,1) ;
    private final static String NOM = "SERVER";
        public AcceptThread(BluetoothAdapter bluetoothAdapter) {
            // On utilise un objet temporaire qui sera assigné plus tard à blueServerSocket car blueServerSocket est "final"
            BluetoothServerSocket tmp = null;
            try {
                // MON_UUID est l'UUID (comprenez identifiant serveur) de l'application. Cette valeur est nécessaire côté client également !
                tmp = bluetoothAdapter.listenUsingRfcommWithServiceRecord(NOM, MY_UUID);
            } catch (IOException e) { }
            blueServerSocket = tmp;
        }

        public void run() {
            BluetoothSocket blueSocket = null;
            // On attend une erreur ou une connexion entrante
            while (true) {
                System.out.println("ATTEND CONNEXION 1");
                try {
                    System.out.println("ATTEND CONNEXION 2");
                    blueSocket = blueServerSocket.accept();
                } catch (IOException e) {
                    System.out.println("ATTEND CONNEXION CATCH");
                    break;
                }
                System.out.println("ATTEND CONNEXION 3");
                // Si une connexion est acceptée
                if (blueSocket != null) {
                    System.out.println("CONNEXION ACCEPTER");
                    // On fait ce qu'on veut de la connexion (dans un thread séparé), à vous de la créer

                    manageConnectedSocket(blueSocket);
                    cancel();
                    break;
                }
            }
        }

    private void manageConnectedSocket(BluetoothSocket blueSocket) {
            System.out.println(blueSocket.isConnected());
    }

    // On stoppe l'écoute des connexions et on tue le thread
        public void cancel() {
            try {
                blueServerSocket.close();
            } catch (IOException e) { }
        }
    }



