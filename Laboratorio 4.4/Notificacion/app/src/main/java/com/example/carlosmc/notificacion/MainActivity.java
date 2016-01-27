package com.example.carlosmc.notificacion;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.NotificationCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    public int numMessages = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }

    public void lanza(View v){
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this) .setSmallIcon(R.drawable
                        .ic_launcher).setContentTitle("Mi notificación")
                        .setContentText("Hola Mundo!");
        Intent resultIntent = new Intent(this, MainActivity.class);
        PendingIntent resultPendingIntent = PendingIntent.getActivity(
                this, 0, resultIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        mBuilder.setContentIntent(resultPendingIntent);
        int mNotificationId = 001;
        NotificationManager mNotifyMgr = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        mNotifyMgr.notify(mNotificationId, mBuilder.build());
    }

    public void cambia(View v){
        NotificationManager mNotificationManager = (NotificationManager)
                getSystemService(Context.NOTIFICATION_SERVICE);
        int notifyID = 1;
        NotificationCompat.Builder mNotifyBuilder = new NotificationCompat.Builder(this)
                        .setContentTitle("Nuevo Mensaje").setContentText("Tienes mensajes nuevos!")
                        .setSmallIcon(R.drawable.ic_launcher);
        String currentText="Texto";
        mNotifyBuilder.setContentText(currentText).setNumber(++numMessages);
        mNotificationManager.notify( notifyID, mNotifyBuilder.build());
    }

    public void borra(View v){
        NotificationManager mNotificationManager = (NotificationManager)
                getSystemService(Context.NOTIFICATION_SERVICE);
        int notifyID = 1;
        mNotificationManager.cancel(notifyID);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
