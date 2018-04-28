package com.code_revolution.yuknontoncinema;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private SliderLayout sliderLayout;
    TextView date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("YukNonton");
        getSupportActionBar().setSubtitle("Book Cinema Ticket");
        sliderLayout = (SliderLayout) findViewById(R.id.slider);
        // Load image dari URL
//        HashMap<String,String> url_maps = new HashMap<String, String>();
//        url_maps.put("Hannibal", "http://static2.hypable.com/wp-content/uploads/2013/12/hannibal-season-2-release-date.jpg");
//        url_maps.put("Big Bang Theory", "http://tvfiles.alphacoders.com/100/hdclearart-10.png");
//        url_maps.put("House of Cards", "http://cdn3.nflximg.net/images/3093/2043093.jpg");
//        url_maps.put("Game of Thrones", "http://images.boomsbeat.com/data/images/full/19640/game-of-thrones-season-4-jpg.jpg");
        // Load Image Dari res/drawable
        HashMap<String, Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("Hannibal", R.drawable.info1);
        file_maps.put("Hannibal2", R.drawable.info2);
        file_maps.put("Hannibal3", R.drawable.info3);

        for (String name : file_maps.keySet()) {
            TextSliderView textSliderView = new TextSliderView(this);
            // initialize a SliderLayout
            textSliderView
//                    .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit);
            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra", name);
            sliderLayout.addSlider(textSliderView);
        }
        sliderLayout.setPresetTransformer(SliderLayout.Transformer.Tablet);
        sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Left_Top);
//        sliderLayout.setCustomAnimation(new DescriptionAnimation());
        sliderLayout.setDuration(3000);
        date = (TextView) findViewById(R.id.date);
        date.setBackgroundColor(Color.argb(200,0,0,0));
        String[] monthName = {"Januari", "Februari",
                "Maret", "April", "Mei", "Juni", "Juli",
                "Agustus", "September", "Oktober", "November",
                "Desember"};

        Calendar cal = Calendar.getInstance();
        String month = monthName[cal.get(Calendar.MONTH)];
        int day = cal.get(Calendar.DATE);
        int  year = cal.get(Calendar.YEAR);
//
//        SimpleDateFormat sdf = new SimpleDateFormat("dd");
//        String currentDateandTime = sdf.format(new Date());



        date.setText(day + " " + month +" " + year);

        CardView exit = (CardView) findViewById(R.id.exit);
        CardView movie = (CardView) findViewById(R.id.movie);
        CardView info = (CardView) findViewById(R.id.info);
        CardView tiket = (CardView) findViewById(R.id.tiket);

        movie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent movie = new Intent(MainActivity.this, MovieList.class);
                startActivity(movie);
            }
        });
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent info = new Intent(MainActivity.this, Info.class);
                startActivity(info);
            }
        });

        final int position = 0;

        tiket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tiket = new Intent(MainActivity.this, TicketBooking.class);
                tiket.putExtra("position", position);
                startActivity(tiket);
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(getApplicationContext(), "hsjkas", Toast.LENGTH_SHORT).show();
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Keluar");
                builder.setMessage("Yakin ingin keluar?");

                builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override

                    public void onClick(DialogInterface dialogInterface, int i) {

                        finish();

                    }
                });

                builder.show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_settings, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_share) {
            String txtShare = "Hore! Saya sedang memesan tiket bioskop" +
                    " dengan aplikasi YukNonton. Ayo! install aplikasinya sekarang juga";
            Intent shareIntent = new Intent();
            shareIntent.setAction(Intent.ACTION_SEND);
            shareIntent.putExtra(Intent.EXTRA_TEXT, txtShare);
            shareIntent.setType("text/plain");
            startActivity(shareIntent);
        } else if (id == R.id.action_about) {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("About");
            builder.setMessage("Aplikasi ini dibuat oleh \nRyan Adhitama Putra \nsebagai final project untuk\n Indonesia Android Kejar");
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override

                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });

            builder.show();
        }
        return super.onOptionsItemSelected(item);
    }
}
