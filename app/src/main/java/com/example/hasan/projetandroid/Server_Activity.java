package com.example.hasan.projetandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Server_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_server_);





        AcceptThread accept = new AcceptThread();
        accept.run();
    }
}
