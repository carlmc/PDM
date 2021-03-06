package com.example.carlosmc.labo61;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements EnviarMensaje{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void enviarDatos(String mensaje){
        Derecha derecha = (Derecha)getSupportFragmentManager().findFragmentById(R.id.derecho);
        derecha.obtenerDatos(mensaje);
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

        if(id == R.id.acerca_de) {
            Toast.makeText(getBaseContext(), "Acerca de ...", Toast.LENGTH_LONG).show();
        }
        else if(id == R.id.configuracion) {
            Toast.makeText(getBaseContext(), "Configuraciones", Toast.LENGTH_LONG).show();
        }
        else if(id == R.id.salir) {
            Toast.makeText(getBaseContext(), "Saliendo...", Toast.LENGTH_LONG).show();
        }


        return super.onOptionsItemSelected(item);
    }
}
