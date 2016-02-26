package com.example.hasan.projetandroid;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by hasan on 26/02/16.
 */
public class ServerActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AcceptThread accept = new AcceptThread();
        accept.run();
    }
}
