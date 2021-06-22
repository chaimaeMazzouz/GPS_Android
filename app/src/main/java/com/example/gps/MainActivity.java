package com.example.gps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    GpsUtil gps;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void getLocation(View view) {
        gps = new GpsUtil(MainActivity.this);

        // Vérifier est ce que le GPS est activé
        if(gps.canGetLocation()){

            double latitude = gps.getLatitude();
            double longitude = gps.getLongitude();


            Toast.makeText(getApplicationContext(), "Votre position is - \nLat: " + latitude + "\nLong: " + longitude, Toast.LENGTH_LONG).show();
        }else{
            // localisation impossible
            // GPS est disactivé
            // Demander à l'utilisateur de l'activé
            gps.showSettingsAlert();
        }
    }

}