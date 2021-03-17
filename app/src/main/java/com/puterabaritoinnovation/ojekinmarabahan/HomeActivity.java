package com.puterabaritoinnovation.ojekinmarabahan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import Model.SlidePromo;
import Model.jadwalToko;

public class HomeActivity extends AppCompatActivity {

    ViewFlipper flipperLayout;
    CardView food, services, jasakurir, produkBaru;
    TextView txtpromo, marquetxt;
    ImageView promo1, promo2, promo3, promo4, promo5, promo6, promo7, promo8, promo9, promo10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        flipperLayout = findViewById(R.id.flipper);

        int images [] = {R.drawable.slide3, R.drawable.slide6, R.drawable.slide7};

        for (int image:images) {
            flipperImages(image);
        }

        TextView textView = findViewById(R.id.marqueetext);
        textView.setSelected(true);

        food = findViewById(R.id.food);
        jasakurir = findViewById(R.id.menu_send);
        services = findViewById(R.id.servise);
        produkBaru = findViewById(R.id.newProduct);
        txtpromo = findViewById(R.id.promotoko);
        marquetxt = findViewById(R.id.marqueetext);

        promo1 = findViewById(R.id.promo1);
        promo2 = findViewById(R.id.promo2);
        promo3 = findViewById(R.id.promo3);
        promo4 = findViewById(R.id.promo4);
        promo5 = findViewById(R.id.promo5);
        promo6 = findViewById(R.id.promo6);
        promo7 = findViewById(R.id.promo7);
        promo8 = findViewById(R.id.promo8);
        promo9 = findViewById(R.id.promo9);
        promo10 = findViewById(R.id.promo10);

        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, StoreActivity.class);
                startActivity(intent);
            }
        });

        jasakurir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, KurirActivity.class);
                startActivity(intent);
            }
        });

        services.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, ServiceActivity.class);
                startActivity(intent);
            }
        });

        produkBaru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, KeranjangActivity.class);
                startActivity(intent);
            }
        });

        DatabaseReference reference1 = FirebaseDatabase.getInstance().getReference().child("Jadwal");
        reference1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    jadwalToko jadwalToko = dataSnapshot.getValue(Model.jadwalToko.class);
                    marquetxt.setText(jadwalToko.getHomemarquee());
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("Promo");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    SlidePromo slidePromo = dataSnapshot.getValue(SlidePromo.class);
                    txtpromo.setText(slidePromo.getTxtpromo());
                    Picasso.get().load(slidePromo.getPromo1())
                            .into(promo1);
                    Picasso.get().load(slidePromo.getPromo2())
                            .into(promo2);
                    Picasso.get().load(slidePromo.getPromo3())
                            .into(promo3);
                    Picasso.get().load(slidePromo.getPromo4())
                            .into(promo4);
                    Picasso.get().load(slidePromo.getPromo5())
                            .into(promo5);
                    Picasso.get().load(slidePromo.getPromo6())
                            .into(promo6);
                    Picasso.get().load(slidePromo.getPromo7())
                            .into(promo7);
                    Picasso.get().load(slidePromo.getPromo8())
                            .into(promo8);
                    Picasso.get().load(slidePromo.getPromo9())
                            .into(promo9);
                    Picasso.get().load(slidePromo.getPromo10())
                            .into(promo10);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    public void flipperImages (int image) {
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        flipperLayout.addView(imageView);
        flipperLayout.setFlipInterval(3000);
        flipperLayout.setAutoStart(true);

        flipperLayout.setInAnimation(this, android.R.anim.slide_in_left);
        flipperLayout.setOutAnimation(this, android.R.anim.slide_out_right);
    }
}