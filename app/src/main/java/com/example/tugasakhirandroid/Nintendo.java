package com.example.tugasakhirandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Nintendo extends AppCompatActivity {
    String place = "NINTENDO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nintendo);

        ImageView btnaction = (ImageView)findViewById(R.id.action);
        ImageView btnadventure = (ImageView)findViewById(R.id.adventure);
        ImageView btnfighting = (ImageView)findViewById(R.id.fighting);
        ImageView btnshooting = (ImageView)findViewById(R.id.shooting);
        ImageView btnsimulation = (ImageView)findViewById(R.id.simulation);
        ImageView btnstrategy = (ImageView)findViewById(R.id.strategy);
        btnaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.activity_nintendo_genre);
                TextView text = (TextView)findViewById(R.id.textnintendogenre);
                text.setText("ACTION");
                place = "ACTION";
            }
        });
        btnadventure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.activity_nintendo_genre);
                TextView text = (TextView)findViewById(R.id.textnintendogenre);
                text.setText("ADVENTURE");
                place = "ADVENTURE";
            }
        });
        btnfighting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.activity_nintendo_genre);
                TextView text = (TextView)findViewById(R.id.textnintendogenre);
                text.setText("FIGHTING");
                place = "FIGHTING";
            }
        });
        btnshooting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.activity_nintendo_genre);
                TextView text = (TextView)findViewById(R.id.textnintendogenre);
                text.setText("SHOOTING");
                place = "SHOOTING";
            }
        });
        btnsimulation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.activity_nintendo_genre);
                TextView text = (TextView)findViewById(R.id.textnintendogenre);
                text.setText("SIMULATION");
                place = "SIMULATION";
            }
        });
        btnstrategy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.activity_nintendo_genre);
                TextView text = (TextView)findViewById(R.id.textnintendogenre);
                text.setText("STRATEGY");
                place = "STRATEGY";
            }
        });
    }

    @Override
    public void onBackPressed() {
        if(place.equals("NINTENDO")) {
            startActivity(new Intent(Nintendo.this, MainActivity.class));
            finish();
        } else if(place.equals("ACTION") || place.equals("ADVENTURE") || place.equals("ACTION") || place.equals("FIGHTING") || place.equals("SHOOTING") || place.equals("SIMULATION") || place.equals("STRATEGY")) {
            startActivity(new Intent(Nintendo.this, Nintendo.class));
            finish();
        }
    }
}
