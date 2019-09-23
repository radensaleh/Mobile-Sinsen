    package com.radensaleh.sinsen;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONException;
import org.json.JSONObject;

    public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView tvAkun, tvAbsensi, tvNama, tvKelas, tvScan, tvCreated;
        CardView scanButton;
        private IntentIntegrator intentIntegrator;

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
        scanButton = findViewById(R.id.cvScan);

        Typeface sh4= Typeface.createFromAsset(getAssets(), "fonts/sh4.otf");
        Typeface volkszeitung= Typeface.createFromAsset(getAssets(), "fonts/volkszeitung.otf");

        tvAkun.setTypeface(sh4);
        tvAbsensi.setTypeface(volkszeitung);
        tvNama.setTypeface(volkszeitung);
        tvKelas.setTypeface(volkszeitung);
        tvScan.setTypeface(sh4);
        tvCreated.setTypeface(volkszeitung);

        scanButton.setOnClickListener(this);
    }

        @Override
        protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
            IntentResult result = IntentIntegrator.parseActivityResult(requestCode ,resultCode , data);
            if(result != null){
                if (result.getContents() == null){
                    Toast.makeText(this, "Hasil Tidak Ditemykan", Toast.LENGTH_LONG).show();

                }else{
                    try {
                        JSONObject object = new JSONObject(result.getContents());
                    }catch (JSONException e){
                        e.printStackTrace();
                        Toast.makeText(this , result.getContents(), Toast.LENGTH_LONG).show();
                    }
                }
            }else{
                super.onActivityResult(requestCode, resultCode, data);
            }
        }

        @Override
        public void onClick(View view) {
            intentIntegrator = new IntentIntegrator(this);
            intentIntegrator.initiateScan();

        }
    }
