package com.code_revolution.yuknontoncinema;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import org.w3c.dom.Text;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Random;


public class TicketDetail extends AppCompatActivity {
    TextView tvJudulFilm, tvJumlah, tvTambahan, tvTotal;

    Button share;

    String judul, kelas, include, jumlah;
    Integer grandTotal = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_detail);

        getSupportActionBar().setDisplayShowTitleEnabled(true);
//        getSupportActionBar().setElevation(0);
        getSupportActionBar().setElevation(0);

//        RelativeLayout n = (RelativeLayout) findViewById(R.id.black);

        getSupportActionBar().setTitle("Ticket Detail");
        tvJudulFilm = (TextView)findViewById(R.id.judulFilm);
        tvJumlah = (TextView)findViewById(R.id.jumlah);
        tvTambahan = (TextView)findViewById(R.id.tambahan);
        tvTotal = (TextView)findViewById(R.id.total);
        share = (Button)findViewById(R.id.share);
        TextView c = (TextView) findViewById(R.id.c);
        Random rand = new Random();
        Integer h = rand.nextInt(999999);
        c.setText(h.toString());
        Intent myIntent = getIntent();
        judul = myIntent.getStringExtra("judul");
        include = myIntent.getStringExtra("include");
        jumlah = myIntent.getStringExtra("jumlah");
        kelas = myIntent.getStringExtra("kelas");

        Integer i = Integer.parseInt(jumlah);

        if (kelas.equals("Regular")){
            if (include.equals("No")){
                grandTotal = 50000 * i;
                tvJumlah.setText(50000+" x "+i);
                setTextall();
            }else {
                grandTotal = (50000 + 30000) * i;
                tvJumlah.setText(50000+" + "+30000+" x "+i);
                setTextall();
            }

        }else if(kelas.equals("Executive")){
            if (include.equals("No")){
                grandTotal = 75000 * i;
                tvJumlah.setText(75000+" x "+i);
                setTextall();
            }else {
                grandTotal = (75000 + 30000) * i;
                tvJumlah.setText(75000+" + "+30000+" x "+i);
                setTextall();
            }

        }


        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txtShare = "Hore! Saya telah berhasil memesan tiket film "+ judul + " senilai Rp"+ money(grandTotal) +" dengan menggunakan aplikasi YukNonton";
                Intent shareIntent = new Intent();
                shareIntent.setAction(Intent.ACTION_SEND);
                shareIntent.putExtra(Intent.EXTRA_TEXT, txtShare);
                shareIntent.setType("text/plain");
                startActivity(shareIntent);
            }
        });



    }
    private String money(int val){
        return NumberFormat.getNumberInstance(Locale.ENGLISH).format(val);
    }

    private void setTextall(){
        tvJudulFilm.setText("Judul Film: "+judul);
        tvTambahan.setText("Tambahan: " + include);
        tvTotal.setText(money(grandTotal));
    }
}
