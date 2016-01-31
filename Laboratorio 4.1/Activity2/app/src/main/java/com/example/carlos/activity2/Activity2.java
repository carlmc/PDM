package com.example.carlos.activity2;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;

public class Activity2 extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
    }

    @Override
    protected void onPause() {
        Log.d("Hello World","onPause");
    }

    @Override
    protected void onResume() {
        Log.d("Hello World", "onResume");
    }

    @Override
    protected void onDestroy() {
        Log.d("Hello World", "onDestroy");
    }

    @Override
    protected void onRestart() {
        Log.d("Hello World", "onRestart");
    }
}
