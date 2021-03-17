package com.puterabaritoinnovation.ojekinmarabahan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.card.MaterialCardView;

public class DriverCekOrderActivity extends AppCompatActivity {

    private MaterialCardView tujuan1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_cek_order);

        tujuan1 = findViewById(R.id.tujuan1);

        tujuan1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DriverCekOrderActivity.this, ADriverNewOrderActivity.class);
                startActivity(intent);
            }
        });

    }
}