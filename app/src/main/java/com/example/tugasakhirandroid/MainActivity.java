package com.example.tugasakhirandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    //Carousel
    CarouselView carouselView;
    int[] sampleImages = {R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4, R.drawable.image5};

    //RecyclerView
    Context context;
    RecyclerView recyclerView;
    LinearLayoutManager LinearLayoutManager;
    List<ModelRecycler> list;
    ModelRecycler modelRecycler;
    AdapterRecycler adapterRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Carousel
        carouselView = (CarouselView)findViewById(R.id.carouselview);
        carouselView.setPageCount(sampleImages.length);
        carouselView.setImageListener(imageListener);

        //Recycler
        recyclerView = findViewById(R.id.recyclerview);
        LinearLayoutManager = new LinearLayoutManager(this);
        context = this;
        list = new ArrayList<>();
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(LinearLayoutManager);

        modelRecycler = new ModelRecycler("https://assets-a2.kompasiana.com/statics/crawl/5559a3700423bd29288b4567.jpeg?t=o&v=350");
        list.add(modelRecycler);

        adapterRecycler = new AdapterRecycler(list, context);
          recyclerView.setAdapter(adapterRecycler);

        //Intent
        ImageView btnplaystation = (ImageView) findViewById(R.id.playstation);
        ImageView btnxbox = (ImageView)findViewById(R.id.xbox);
        ImageView btnpc = (ImageView)findViewById(R.id.pc);
        ImageView btnnintendo = (ImageView)findViewById(R.id.nintendo);
        ImageView btnsearch = (ImageView)findViewById(R.id.searchlogo);
        btnplaystation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Playstation.class));
                finish();
            }
        });
        btnxbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Xbox.class));
                finish();
            }
        });
        btnpc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Pc.class));
                finish();
            }
        });
        btnnintendo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Nintendo.class));
                finish();
            }
        });
        btnsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Search.class));
                finish();
            }
        });
    }
    //Carousel ImageListener
    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
        }
    };

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawerlayout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.login){
            Log.i("debug", String.valueOf(id));
        }

        return true;
    }
}