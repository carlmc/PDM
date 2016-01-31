package com.example.carlos.activity1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import android.view.View;

public class Activity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

    }

    public void mostrarAlerta(View view){
        Toast toast = Toast.makeText(getApplicationContext(),"Has pulsado el boton!",
                Toast.LENGTH_LONG);
        toast.show();
    }
}
