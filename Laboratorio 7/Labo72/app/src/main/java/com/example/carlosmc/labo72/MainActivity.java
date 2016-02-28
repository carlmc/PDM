package com.example.carlosmc.labo72;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    public void abreInterno(View v){
        try{
            OutputStreamWriter fout=
                    new OutputStreamWriter(openFileOutput("prueba_int.txt",
                            Context.MODE_PRIVATE));
            fout.write("Texto de prueba.");
            fout.close();
        }
        catch (Exception ex){
            Log.e("Ficheros", "Error al escribir fichero a memoria interna");
        }
    }

    public void leeInterno(View v){
        try {
            BufferedReader fin =new BufferedReader(new InputStreamReader(openFileInput("prueba_int.txt")));
            String texto = fin.readLine();
            Toast.makeText(this,texto, Toast.LENGTH_LONG).show();
            fin.close();
        }
        catch (Exception ex){
            Log.e("Ficheros", "Error al leer desde memoria interna");
        }
    }

    public void abreExterno(View v){
        try {
            File ruta_sd = Environment.getExternalStorageDirectory();
            File f = new File(ruta_sd.getAbsolutePath(), "prueba_sd.txt");
            OutputStreamWriter fout = new OutputStreamWriter(new FileOutputStream(f));
            fout.write("Texto de prueba.");
            fout.close();
        }
        catch (Exception ex){
            Log.e("Ficheros", "Error al escribir fichero a tarjeta SD");
        }
    }

    public void leeExterno(View v){
        try{
            File ruta_sd = Environment.getExternalStorageDirectory();
            File f = new File(ruta_sd.getAbsolutePath(), "prueba_sd.txt");
            BufferedReader fin = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
            String texto = fin.readLine();
            Toast.makeText(this,texto, Toast.LENGTH_LONG).show();
            fin.close();
        }
        catch (Exception ex){
            Log.e("Ficheros", "Error al leer fichero desde tarjeta SD");
        }
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
