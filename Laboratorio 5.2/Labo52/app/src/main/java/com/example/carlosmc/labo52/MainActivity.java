package com.example.carlosmc.labo52;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private Button imagebutton;
    private Button volver;
    private Button salvar;
    private EditText editText;
    private CheckBox checkBox;
    private RadioButton red;
    private RadioButton blue;
    private ToggleButton toggleButton;
    private RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setUpViews();

        volver.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });



    }

    public void setUpViews(){
        imagebutton = (Button)findViewById(R.id.imageButton);
        volver = (Button)findViewById(R.id.button);
        salvar = (Button)findViewById(R.id.button2);
        editText = (EditText)findViewById(R.id.editText);
        checkBox = (CheckBox)findViewById(R.id.checkBox);
        red = (RadioButton)findViewById(R.id.red);
        blue = (RadioButton)findViewById(R.id.blue);
        toggleButton = (ToggleButton)findViewById(R.id.toggleButton);
        ratingBar = (RatingBar)findViewById(R.id.ratingBar);
    }

    public void sendClick(View v){
        String allText = new String("campo:"+editText.getText());
        allText = allText + ":checkbox:";
        if(checkBox.isChecked()){
            allText = allText + "Checked:";
        } else {
            allText = allText + "Not Checked:";
        }
        allText = allText + ":toggle:";
        if(toggleButton.isChecked()){
            allText = allText + "Checked:";
        }else {
            allText = allText + "Not Checked:";
        }
        allText = allText + "radios:rojo:";
        String redtext = "";
        if (red.isChecked()) {
            redtext = "pulsado:";
        } else {
            redtext = "no pulsado:";
        }
        allText = allText + redtext;
        allText = allText + "azul";
        String bluetext = "";
        if (blue.isChecked()) {
            bluetext = "pulsado:";
        } else {
            bluetext = "no pulsado:";
        }
        allText = allText + bluetext;
        allText = allText + "rating:";
        float f = ratingBar.getRating();
        allText = allText + Float.toString( f ) + ":";
        Log.d("app", allText);
        Toast.makeText(this, allText, Toast.LENGTH_LONG).show();
    }

    public void checkBoxClick(View v){
        String text = "";
        if(checkBox.isChecked()){
            text = "Selected";
            salvar.setEnabled(true);
            Toast.makeText(this,"Ya puedes salvar",Toast.LENGTH_LONG).show();
        } else {
            salvar.setEnabled(false);
            Toast.makeText(this, "Hasta que no marques la casilla no podrás salvar",Toast.LENGTH_LONG).show();
            text = "Not selected";
        }
        Toast.makeText(this,text,Toast.LENGTH_SHORT).show();
    }

    public void radioButtonClick(View v){

        if(red.isChecked()){
            Toast.makeText(this,"red",Toast.LENGTH_LONG).show();
        }
        else if(blue.isChecked()){
            Toast.makeText(this,"blue",Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this,"Ningun radio seleccionado",Toast.LENGTH_SHORT).show();
        }
    }

    public void toggleButtonClick(View v){
        StringBuffer result = new StringBuffer();
        result.append(toggleButton.getText());
        Toast.makeText(this,result.toString(),Toast.LENGTH_SHORT).show();
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
