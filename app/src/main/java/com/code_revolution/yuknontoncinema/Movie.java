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
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Movie extends AppCompatActivity {
    CollapsingToolbarLayout judul;
    String[] Version;
    String[] rating, rilis, genre, menit,sinopsis;
    TextView film1, rilis1, genre1, menit1, sinopsis1;
    int[] image;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        film1 = (TextView) findViewById(R.id.film);
        rilis1 = (TextView) findViewById(R.id.rilis);
        genre1 = (TextView) findViewById(R.id.genre);
        menit1 = (TextView) findViewById(R.id.menit);
        sinopsis1 = (TextView) findViewById(R.id.sinopsis);


        Version = new String[]{
                "Justice League",
                "Pengabdi Setan",
                "JigSaw",
                "Dear Nathan",
                "Hujan Bulan Juni",
                "Power Ranger"
        };
        rating = new String[]{
                "4.1",
                "5",
                "3.8",
                "2.8",
                "5",
                "3.9"
        };
        rilis = new String[]{
                ":\t19 November 2017",
                ":\t4 November 2017",
                ":\t30 October 2017",
                ":\t5 March 2017",
                ":\t28 September 2017",
                ":\t20 Juni 2017"
        };

        genre = new String[]{
                ":\tAction",
                ":\tHorror",
                ":\tHorror",
                ":\tRomance",
                ":\tRomance",
                ":\tRomance"
        };
        menit = new String[]{
                ":\t120 Menit",
                ":\t120 Menit",
                ":\t120 Menit",
                ":\t120 Menit",
                ":\t120 Menit",
                ":\t120 Menit"
        };
        image = new int[]{
                R.drawable.g1,
                R.drawable.g21,
                R.drawable.g3,
                R.drawable.g4,
                R.drawable.g5,
                R.drawable.g6

        };

        sinopsis = new String[]{
                "\tKebangkitan kembali Superman (Henry Cavill) setelah kematiannya ditangan Doomsday membuat Batman (Ben Affleck) mencari metode baru dan mulai mengumpulkan tim yang berisi superhero untuk melindungi bumi dari berbagai macam ancaman. Bersama-sama dengan Wonder Woman (Gal Gadot) mereka menemukan Cyborg (Ray Fisher), The Flash (Ezra Miller) dan Aquaman (Jason Momoa).",
                "\tRini (Tara Basro) tinggal di pinggiran kota Jakarta di sebuah rumah tua milik neneknya, Rahma Saidah (Elly D. Luthan), bersama ibunya, Mawarni Suwono (Ayu Laksmi), bapaknya (Bront Palarae), dan ketiga adik laki-lakinya, Tony (Endy Arfian), Bondi (Nasar Annuz), dan Ian (Muhammad Adhiyat). Kisah dibuka dengan masalah finansial keluarga mereka yang kehabisan uang untuk biaya pengobatan sakit sang ibu. Penyakit yang begitu parah membuat Mawarni tak mampu menggerakkan tubuhnya dan hanya berbaring di tempat tidur. Untuk memanggil dan meminta bantuan, Mawarni harus membunyikan lonceng.",
                "\tFilm ini akan menceritakan tentang mayat-mayat yang berputar di sekitar kota, yang mana masing-masing dari mereka mengalami kematian yang sangat unik. Seiring dengan penyelidikan yang berlangsung, bukti menunjukkan salah seorang tersangka, yaitu  John Kramer (diperankan Tobin Bell), Ia adalah pria yang dikenal sebagai Jigsaw, yang mana dirinya telah meninggal selama sepuluh tahun. ",
                "\tSalma (Amanda Rawles) merupakan seorang murid pindahan di SMA Garuda. Suatu pagi ia terlambat datang ke upacara bendera dan seorang murid bernama Nathan (Jefri Nichol), yang dikenal sebagai murid berandal yang hobi tawuran, menyelamatkannya dari hukuman. Salma, yang bertekad untuk selektif memilih teman, berusaha menjauhi Nathan, namun Nathan justru membuat heboh satu sekolah dengan terang-terangan mengejar cinta Salma. Berbagai cara dilakukan Salma untuk menghindar, namun semakin ia menjauh, semakin ia dihadapkan pada kesempatan demi kesempatan untuk memahami masa lalu Nathan dan perlahan jatuh cinta. Saat Nathan mulai membuka diri dan mau berubah demi Salma, kekasih masa lalu Nathan, Seli, datang untuk meminta cintanya kembali.",
                "\tHujan Bulan Juni merupakan film Indonesia bergenre drama romantis yang digarap oleh Starvision dan Sinema Imaji selaku pihak produksi film. Mengadaptasi cerita dari novel karya Sapardi Djoko Damono yang berjudul \"Hujan Bulan Juni\" terbitan tahun 2015, Film ini melibatkan Reni Nurcahyo Hestu Saputra (Air Mata Surga, Perfect Dream) selaku sutradara. Dalam film ini, Sapardi juga ikut ambil bagian dalam penulisan skenario film bersama Titien Wattimena (Negeri Van Oranje, Labuan Hati).",
                "\tFilm \"Powers Rangers\" akan menceritakan tentang asal mula Mighty Morphin Power Ranges. Dikisahkan sekelompok remaja yang mendapatkan kekuatan super sebagai pahlawan super. Dengan kekuatan itu, mereka diminta oleh Zorgon untuk menyelamatkan dunia dari alien jahat bernama Rita."
        };
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final int position = getIntent().getIntExtra("position",0);
        judul = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        judul.setTitle(Version[position]);
        judul.setBackgroundResource(image[position]);
        judul.setExpandedTitleColor(Color.argb(0,0,0,0));
        judul.setCollapsedTitleTextColor(Color.rgb(255,255,255));

        film1.setText(Version[position]);
        rilis1.setText(rilis[position]);
        genre1.setText(genre[position]);
        menit1.setText(menit[position]);
        sinopsis1.setText(sinopsis[position]);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Movie.this, "You like this movie",Toast.LENGTH_SHORT).show();
            }
        });


        btn = (Button) findViewById(R.id.btn_booking);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tiket = new Intent(Movie.this, TicketBooking.class);
                tiket.putExtra("position", position);
                startActivity(tiket);
            }
        });
    }
}
