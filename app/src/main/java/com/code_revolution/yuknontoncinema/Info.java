package com.code_revolution.yuknontoncinema;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class Info extends AppCompatActivity {
    CollapsingToolbarLayout judul;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txtShare = "Hore! Saya sedang memesan tiket bioskop" +
                        " dengan aplikasi YukNonton. Ayo! install aplikasinya sekarang juga";
                Intent shareIntent = new Intent();
                shareIntent.setAction(Intent.ACTION_SEND);
                shareIntent.putExtra(Intent.EXTRA_TEXT, txtShare);
                shareIntent.setType("text/plain");
                startActivity(shareIntent);
            }
        });

        judul = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        judul.setTitle("Info");
        judul.setBackgroundResource(R.drawable.info2);
        judul.setExpandedTitleColor(Color.argb(0,0,0,0));
        judul.setCollapsedTitleTextColor(Color.rgb(255,255,255));
    }

    /**
     * Created by Asus on 27/11/2017.
     */


}
