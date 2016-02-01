package com.example.carlosmc.labo532;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private GridView grdOpciones;
    private TextView lblMensaje;

    private String[] datos = {" pollo"," gallina","lomo",
            "tacu tacu", "ceviche", "hostia"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datos);

        grdOpciones = (GridView)findViewById(R.id.GridOpciones);
        lblMensaje = (TextView)findViewById(R.id.LblMensaje);

        grdOpciones.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> parent,
                                            android.view.View v, int position, long id) {
                        lblMensaje.setText("Opción seleccionada: "
                                + parent.getItemAtPosition(position));
                    }
                });

        grdOpciones.setAdapter(adaptador);
    }
}

