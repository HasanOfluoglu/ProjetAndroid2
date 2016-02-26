package com.example.hasan.projetandroid;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private final int REQUEST_ENABLE_BT = 2016;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BluetoothAdapter myBluetooth = BluetoothAdapter.getDefaultAdapter();
        if (myBluetooth == null) {
            // Device does not support Bluetooth
        }

        if (!myBluetooth.isEnabled()) {
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
        }




    }


    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.creer :
                Intent intent = new Intent(this,Server_Activity.class);
                startActivity(intent);

                break;
            case R.id.rejoindre:
                startActivity(new Intent(this,ClientActivity.class));
                break;
        }
    }
}
