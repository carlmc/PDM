package com.example.carlosmc.labo625;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class Activity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);


    }

    public void forwardZoom(View button){
        startActivity(new Intent(this, Activity2.class));
        overridePendingTransition(R.anim.zoom_forward_in,
                R.anim.zoom_forward_out);
    }

    public void left(View button){
        startActivity(new Intent(this, Activity2.class));
        overridePendingTransition(R.anim.left_in, R.anim.left_out);
    }

    public void fade(View button){
        startActivity(new Intent(this, Activity2.class));
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    public void byDefault(View button){
        startActivity(new Intent(this, Activity2.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity1, menu);
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
