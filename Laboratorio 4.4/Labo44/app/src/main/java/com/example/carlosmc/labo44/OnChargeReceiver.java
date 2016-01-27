package com.example.carlosmc.labo44;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class OnChargeReceiver extends BroadcastReceiver{

    @Override
    public void onReceive(Context ctx, Intent i) {
        Log.d("App", "Recibido!");
        Toast.makeText(ctx, "Ha conectado el cargador.",
                Toast.LENGTH_SHORT).show();
    }

}
