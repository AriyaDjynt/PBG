package com.example.tugasakhirandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Nintendo extends AppCompatActivity {

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
            }
        });
        btnadventure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.activity_nintendo_genre);
                TextView text = (TextView)findViewById(R.id.textnintendogenre);
                text.setText("ADVENTURE");
            }
        });
        btnfighting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.activity_nintendo_genre);
                TextView text = (TextView)findViewById(R.id.textnintendogenre);
                text.setText("FIGHTING");
            }
        });
        btnshooting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.activity_nintendo_genre);
                TextView text = (TextView)findViewById(R.id.textnintendogenre);
                text.setText("SHOOTING");
            }
        });
        btnsimulation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.activity_nintendo_genre);
                TextView text = (TextView)findViewById(R.id.textnintendogenre);
                text.setText("SIMULATION");
            }
        });
        btnstrategy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.activity_nintendo_genre);
                TextView text = (TextView)findViewById(R.id.textnintendogenre);
                text.setText("STRATEGY");
            }
        });
    }
}
