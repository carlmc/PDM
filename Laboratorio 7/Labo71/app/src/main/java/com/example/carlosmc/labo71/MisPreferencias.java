package com.example.carlosmc.labo71;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class MisPreferencias extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.preferences);

    }

}


