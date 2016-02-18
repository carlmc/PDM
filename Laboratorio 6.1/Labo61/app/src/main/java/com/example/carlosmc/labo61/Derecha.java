package com.example.carlosmc.labo61;



//import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Derecha extends Fragment {

    View rootView;
    TextView txt;

    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){
        rootView= inflater.inflate (R.layout.derecha, container, false);
        txt = (TextView) rootView.findViewById(R.id.textView2);
        return rootView;
    }

    public void obtenerDatos(String mensaje){

        txt.setText(mensaje);
    }
}


