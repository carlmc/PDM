package com.example.carlos.labo423;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnPW;
    private Button btnmarcaTel;
    private Button btnllamada;
    private Button btnaniadir;
    private Button btnalarma;
    private Button btncorreo;
    private Button btncamara;
    private Button btnvideo;
    private Button btngps;
    private Button btntexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnPW = (Button)findViewById(R.id.btnPW);
        btnmarcaTel = (Button)findViewById(R.id.btnmarcaTel);
        btnllamada = (Button)findViewById(R.id.btnLlamada);
        btnaniadir = (Button)findViewById(R.id.btnaniadir);
        btnalarma = (Button)findViewById(R.id.btnalarma);
        btncorreo = (Button)findViewById(R.id.btnCorreo);
        btncamara = (Button)findViewById(R.id.btnCamara);
        btnvideo = (Button)findViewById(R.id.btnVideo);
        btngps = (Button)findViewById(R.id.btnGps);
        btntexto = (Button)findViewById(R.id.btnTexto);

        btntexto.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent= new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT, "Moviles"); //cambie getResources().getString(R.string.text))
                intent.setType("text/plain");
                startActivity(intent);
            }
        });

        btngps.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:0,0?z=4&q=restaurantes"));
                startActivity(intent);
            }
        });

        btnvideo.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent= new Intent(MediaStore.INTENT_ACTION_VIDEO_CAMERA);
                startActivity(intent);
            }
        });

        btncamara.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(intent);
            }
        });

        btncorreo.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent= new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto", "support@itiox.com", null)); //cambie el getResources().getString(R.string.correo)
                intent.putExtra(Intent.EXTRA_SUBJECT, "ITIOX"); //cambie el getResources().getString( R.string.subject)
                startActivity(Intent.createChooser(intent, "mensaje para ITIOX")); //cambie el getResources().getString(R.string.envio)
            }
        });

        btnalarma.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent= new Intent(AlarmClock.ACTION_SET_ALARM);
                startActivity(intent);
            }
        });

        btnaniadir.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent= new Intent(Intent.ACTION_INSERT);
                intent.setType(ContactsContract.Contacts.CONTENT_TYPE);
                startActivity(intent);
            }
        });

        btnllamada.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:555-555-555"));
                try{
                    startActivity(intent);
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
        });

        btnmarcaTel.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(Intent.ACTION_DIAL);
                startActivity(intent);
            }
        });

        btnPW.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://desarrollandoandroid.wordpress.com"));
                startActivity(intent);
            }
        });
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
