    package com.radensaleh.sinsen;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

    public class MainActivity extends AppCompatActivity {

    TextView tvAkun, tvAbsensi, tvNama, tvKelas, tvScan, tvCreated;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvAkun = findViewById(R.id.tvAkun);
        tvAbsensi = findViewById(R.id.tvAbsensi);
        tvNama = findViewById(R.id.tvNama);
        tvKelas = findViewById(R.id.tvKelas);
        tvScan = findViewById(R.id.tvScan);
        tvCreated = findViewById(R.id.tvCreated);

        Typeface sh4= Typeface.createFromAsset(getAssets(), "fonts/sh4.otf");
        Typeface volkszeitung= Typeface.createFromAsset(getAssets(), "fonts/volkszeitung.otf");

        tvAkun.setTypeface(sh4);
        tvAbsensi.setTypeface(volkszeitung);
        tvNama.setTypeface(volkszeitung);
        tvKelas.setTypeface(volkszeitung);
        tvScan.setTypeface(sh4);
        tvCreated.setTypeface(volkszeitung);

    }
}
