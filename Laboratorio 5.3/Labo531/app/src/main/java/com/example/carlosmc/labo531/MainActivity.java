package com.example.carlosmc.labo531;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ListView lv;

    final Comidas[] COMIDAS = new Comidas[]{new Comidas("arroz con pollo","Ingredientes:pollo,arroz,zanahoria,culantro\n" +
            "Tiempo de coccion:3h"),
            new Comidas("ají de gallina","Ingredientes:gallina,arroz,aji amarillo\n" +
                    "Tiempo de coccion:2h"),
            new Comidas("lomo saltado","Ingredientes:carne,arroz,papa,cebolla\n" +
                    "Tiempo de coccion:2h.30m"),
            new Comidas("tacu tacu","Ingredientes:frejol,arroz,tocino\n" +
                    "Tiempo de coccion:1h"),
            new Comidas("ceviche","Ingredientes:pescado,limon,aji,camote\n" +
                    "Tiempo de coccion:30m"),
            new Comidas("hostia que hambre me ha dado","Ingredientes:NN\n" +
                    "Tiempo de coccion:2h")};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView)findViewById(R.id.LstOpciones);

        AdaptadorComida adaptador = new AdaptadorComida(this,COMIDAS);
        lv.setAdapter(adaptador);
    }

    class AdaptadorComida extends ArrayAdapter<Comidas>{

        public AdaptadorComida(Context context, Comidas[] comida){
            super(context,R.layout.list_comida,comida);
        }

        public View getView(int position,View convertView,ViewGroup parent){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.list_comida, null);

            TextView comi = (TextView)item.findViewById(R.id.comi);
            comi.setText(COMIDAS[position].getNombre());

            TextView desc = (TextView)item.findViewById(R.id.descri);
            desc.setText(COMIDAS[position].getDescripcion());

            return item;
        }
    }
}
