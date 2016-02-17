package com.example.carlosmc.labo61;


//import android.app.Activity;
//import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class Izquierda extends Fragment {

    View rootView;
    Button boton;
    EditText campo;
    EnviarMensaje EM;

    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){
        rootView = inflater.inflate(R.layout.izquierda,container,false);
        campo = (EditText)rootView.findViewById(R.id.campotxt);
        boton = (Button)rootView.findViewById(R.id.boton);

        boton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String mensaje;
                mensaje = campo.getText().toString();
                EM.enviarDatos(mensaje);
            }
        });

        return rootView;
    }


    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            EM = (EnviarMensaje)context;
        } catch (ClassCastException e) {
            throw new ClassCastException("Necesitas implementar mensaje");
        }
    }
}
