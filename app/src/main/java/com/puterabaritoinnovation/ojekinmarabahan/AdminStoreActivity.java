package com.puterabaritoinnovation.ojekinmarabahan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import Model.LogoToko;

public class AdminStoreActivity extends AppCompatActivity {

    private CardView produkbaru, logout, toko1, toko2, toko3, toko4, toko5, toko6, toko7, toko8, toko9, toko10;
    private CardView toko11, toko12, toko13, toko14, toko15, toko16, toko17, toko18, toko19, toko20;
    private CardView toko21, toko22, toko23, toko24, toko25, toko26, toko27, toko28, toko29, toko30;
    private CardView toko31, toko32, toko33, toko34, toko35, toko36, toko37, toko38, toko39, toko40;
    private CardView toko41, toko42, toko43, toko44, toko45, toko46, toko47, toko48, toko49, toko50;
    private CardView toko51, toko52, toko53, toko54, toko55, toko56, toko57, toko58, toko59, toko60;

    TextView nama1, nama2, nama3, nama4, nama5, nama6, nama7, nama8, nama9, nama10;
    TextView nama11, nama12, nama13, nama14, nama15, nama16, nama17, nama18, nama19, nama20;
    TextView nama21, nama22, nama23, nama24, nama25, nama26, nama27, nama28, nama29, nama30;
    TextView nama31, nama32, nama33, nama34, nama35, nama36, nama37, nama38, nama39, nama40;
    TextView nama41, nama42, nama43, nama44, nama45, nama46, nama47, nama48, nama49, nama50;
    TextView nama51, nama52, nama53, nama54, nama55, nama56, nama57, nama58, nama59, nama60;

    ImageView logo1, logo2, logo3, logo4, logo5, logo6, logo7, logo8, logo9, logo10;
    ImageView logo11, logo12, logo13, logo14, logo15, logo16, logo17, logo18, logo19, logo20;
    ImageView logo21, logo22, logo23, logo24, logo25, logo26, logo27, logo28, logo29, logo30;
    ImageView logo31, logo32, logo33, logo34, logo35, logo36, logo37, logo38, logo39, logo40;
    ImageView logo41, logo42, logo43, logo44, logo45, logo46, logo47, logo48, logo49, logo50;
    ImageView logo51, logo52, logo53, logo54, logo55, logo56, logo57, logo58, logo59, logo60;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_store);

        produkbaru = (CardView) findViewById(R.id.produkbaru);
        logout = (CardView) findViewById(R.id.logout_admin_btn);

        toko1 = (CardView) findViewById(R.id.toko1);
        toko2 = (CardView) findViewById(R.id.toko2);
        toko3 = (CardView) findViewById(R.id.toko3);
        toko4 = (CardView) findViewById(R.id.toko4);
        toko5 = (CardView) findViewById(R.id.toko5);
        toko6 = (CardView) findViewById(R.id.toko6);
        toko7 = (CardView) findViewById(R.id.toko7);
        toko8 = (CardView) findViewById(R.id.toko8);
        toko9 = (CardView) findViewById(R.id.toko9);
        toko10 = (CardView) findViewById(R.id.toko10);

        toko11 = (CardView) findViewById(R.id.toko11);
        toko12 = (CardView) findViewById(R.id.toko12);
        toko13 = (CardView) findViewById(R.id.toko13);
        toko14 = (CardView) findViewById(R.id.toko14);
        toko15 = (CardView) findViewById(R.id.toko15);
        toko16 = (CardView) findViewById(R.id.toko16);
        toko17 = (CardView) findViewById(R.id.toko17);
        toko18 = (CardView) findViewById(R.id.toko18);
        toko19 = (CardView) findViewById(R.id.toko19);
        toko20 = (CardView) findViewById(R.id.toko20);

        toko21 = (CardView) findViewById(R.id.toko21);
        toko22 = (CardView) findViewById(R.id.toko22);
        toko23 = (CardView) findViewById(R.id.toko23);
        toko24 = (CardView) findViewById(R.id.toko24);
        toko25 = (CardView) findViewById(R.id.toko25);
        toko26 = (CardView) findViewById(R.id.toko26);
        toko27 = (CardView) findViewById(R.id.toko27);
        toko28 = (CardView) findViewById(R.id.toko28);
        toko29 = (CardView) findViewById(R.id.toko29);
        toko30 = (CardView) findViewById(R.id.toko30);

        toko31 = (CardView) findViewById(R.id.toko31);
        toko32 = (CardView) findViewById(R.id.toko32);
        toko33 = (CardView) findViewById(R.id.toko33);
        toko34 = (CardView) findViewById(R.id.toko34);
        toko35 = (CardView) findViewById(R.id.toko35);
        toko36 = (CardView) findViewById(R.id.toko36);
        toko37 = (CardView) findViewById(R.id.toko37);
        toko38 = (CardView) findViewById(R.id.toko38);
        toko39 = (CardView) findViewById(R.id.toko39);
        toko40 = (CardView) findViewById(R.id.toko40);

        toko41 = (CardView) findViewById(R.id.toko41);
        toko42 = (CardView) findViewById(R.id.toko42);
        toko43 = (CardView) findViewById(R.id.toko43);
        toko44 = (CardView) findViewById(R.id.toko44);
        toko45 = (CardView) findViewById(R.id.toko45);
        toko46 = (CardView) findViewById(R.id.toko46);
        toko47 = (CardView) findViewById(R.id.toko47);
        toko48 = (CardView) findViewById(R.id.toko48);
        toko49 = (CardView) findViewById(R.id.toko49);
        toko50 = (CardView) findViewById(R.id.toko50);

        toko51 = (CardView) findViewById(R.id.toko51);
        toko52 = (CardView) findViewById(R.id.toko52);
        toko53 = (CardView) findViewById(R.id.toko53);
        toko54 = (CardView) findViewById(R.id.toko54);
        toko55 = (CardView) findViewById(R.id.toko55);
        toko56 = (CardView) findViewById(R.id.toko56);
        toko57 = (CardView) findViewById(R.id.toko57);
        toko58 = (CardView) findViewById(R.id.toko58);
        toko59 = (CardView) findViewById(R.id.toko59);
        toko60 = (CardView) findViewById(R.id.toko60);

        nama1 = findViewById(R.id.nama1);
        nama2 = findViewById(R.id.nama2);
        nama3 = findViewById(R.id.nama3);
        nama4 = findViewById(R.id.nama4);
        nama5 = findViewById(R.id.nama5);
        nama6 = findViewById(R.id.nama6);
        nama7 = findViewById(R.id.nama7);
        nama8 = findViewById(R.id.nama8);
        nama9 = findViewById(R.id.nama9);
        nama10 = findViewById(R.id.nama10);

        nama11 = findViewById(R.id.nama11);
        nama12 = findViewById(R.id.nama12);
        nama13 = findViewById(R.id.nama13);
        nama14 = findViewById(R.id.nama14);
        nama15 = findViewById(R.id.nama15);
        nama16 = findViewById(R.id.nama16);
        nama17 = findViewById(R.id.nama17);
        nama18 = findViewById(R.id.nama18);
        nama19 = findViewById(R.id.nama19);
        nama20 = findViewById(R.id.nama20);

        nama21 = findViewById(R.id.nama21);
        nama22 = findViewById(R.id.nama22);
        nama23 = findViewById(R.id.nama23);
        nama24 = findViewById(R.id.nama24);
        nama25 = findViewById(R.id.nama25);
        nama26 = findViewById(R.id.nama26);
        nama27 = findViewById(R.id.nama27);
        nama28 = findViewById(R.id.nama28);
        nama29 = findViewById(R.id.nama29);
        nama30 = findViewById(R.id.nama30);

        nama31 = findViewById(R.id.nama31);
        nama32 = findViewById(R.id.nama32);
        nama33 = findViewById(R.id.nama33);
        nama34 = findViewById(R.id.nama34);
        nama35 = findViewById(R.id.nama35);
        nama36 = findViewById(R.id.nama36);
        nama37 = findViewById(R.id.nama37);
        nama38 = findViewById(R.id.nama38);
        nama39 = findViewById(R.id.nama39);
        nama40 = findViewById(R.id.nama40);

        nama41 = findViewById(R.id.nama41);
        nama42 = findViewById(R.id.nama42);
        nama43 = findViewById(R.id.nama43);
        nama44 = findViewById(R.id.nama44);
        nama45 = findViewById(R.id.nama45);
        nama46 = findViewById(R.id.nama46);
        nama47 = findViewById(R.id.nama47);
        nama48 = findViewById(R.id.nama48);
        nama49 = findViewById(R.id.nama49);
        nama50 = findViewById(R.id.nama50);

        nama51 = findViewById(R.id.nama51);
        nama52 = findViewById(R.id.nama52);
        nama53 = findViewById(R.id.nama53);
        nama54 = findViewById(R.id.nama54);
        nama55 = findViewById(R.id.nama55);
        nama56 = findViewById(R.id.nama56);
        nama57 = findViewById(R.id.nama57);
        nama58 = findViewById(R.id.nama58);
        nama59 = findViewById(R.id.nama59);
        nama60 = findViewById(R.id.nama60);

        logo1 = findViewById(R.id.logo1);
        logo2 = findViewById(R.id.logo2);
        logo3 = findViewById(R.id.logo3);
        logo4 = findViewById(R.id.logo4);
        logo5 = findViewById(R.id.logo5);
        logo6 = findViewById(R.id.logo6);
        logo7 = findViewById(R.id.logo7);
        logo8 = findViewById(R.id.logo8);
        logo9 = findViewById(R.id.logo9);
        logo10 = findViewById(R.id.logo10);

        logo11 = findViewById(R.id.logo11);
        logo12 = findViewById(R.id.logo12);
        logo13 = findViewById(R.id.logo13);
        logo14 = findViewById(R.id.logo14);
        logo15 = findViewById(R.id.logo15);
        logo16 = findViewById(R.id.logo16);
        logo17 = findViewById(R.id.logo17);
        logo18 = findViewById(R.id.logo18);
        logo19 = findViewById(R.id.logo19);
        logo20 = findViewById(R.id.logo20);

        logo21 = findViewById(R.id.logo21);
        logo22 = findViewById(R.id.logo22);
        logo23 = findViewById(R.id.logo23);
        logo24 = findViewById(R.id.logo24);
        logo25 = findViewById(R.id.logo25);
        logo26 = findViewById(R.id.logo26);
        logo27 = findViewById(R.id.logo27);
        logo28 = findViewById(R.id.logo28);
        logo29 = findViewById(R.id.logo29);
        logo30 = findViewById(R.id.logo30);

        logo31 = findViewById(R.id.logo31);
        logo32 = findViewById(R.id.logo32);
        logo33 = findViewById(R.id.logo33);
        logo34 = findViewById(R.id.logo34);
        logo35 = findViewById(R.id.logo35);
        logo36 = findViewById(R.id.logo36);
        logo37 = findViewById(R.id.logo37);
        logo38 = findViewById(R.id.logo38);
        logo39 = findViewById(R.id.logo39);
        logo40 = findViewById(R.id.logo40);

        logo41 = findViewById(R.id.logo41);
        logo42 = findViewById(R.id.logo42);
        logo43 = findViewById(R.id.logo43);
        logo44 = findViewById(R.id.logo44);
        logo45 = findViewById(R.id.logo45);
        logo46 = findViewById(R.id.logo46);
        logo47 = findViewById(R.id.logo47);
        logo48 = findViewById(R.id.logo48);
        logo49 = findViewById(R.id.logo49);
        logo50 = findViewById(R.id.logo50);

        logo51 = findViewById(R.id.logo51);
        logo52 = findViewById(R.id.logo52);
        logo53 = findViewById(R.id.logo53);
        logo54 = findViewById(R.id.logo54);
        logo55 = findViewById(R.id.logo55);
        logo56 = findViewById(R.id.logo56);
        logo57 = findViewById(R.id.logo57);
        logo58 = findViewById(R.id.logo58);
        logo59 = findViewById(R.id.logo59);
        logo60 = findViewById(R.id.logo60);

        produkbaru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminStoreActivity.this, AdminNewOrderActivity.class);
                startActivity(intent);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminStoreActivity.this, LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
            }
        });

        toko1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminStoreActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("store", "Kotego");
                startActivity(intent);
            }
        });
        toko2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminStoreActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("store", "Cafe Despacito");
                startActivity(intent);
            }
        });
        toko3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminStoreActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("store", "RM Padang Alia");
                startActivity(intent);
            }
        });
        toko4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminStoreActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("store", "Haji Kadap");
                startActivity(intent);
            }
        });
        toko5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminStoreActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("store", "Pentol Paman Ijo");
                startActivity(intent);
            }
        });
        toko6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminStoreActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("store", "RM Mama Aving");
                startActivity(intent);
            }
        });
        toko7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminStoreActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("store", "Depot Safitri");
                startActivity(intent);
            }
        });
        toko8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminStoreActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("store", "Warung Makan Mami");
                startActivity(intent);
            }
        });
        toko9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminStoreActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("store", "Warung Lalapan Iis");
                startActivity(intent);
            }
        });
        toko10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminStoreActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("store", "Sate Teguh");
                startActivity(intent);
            }
        });

        toko11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminStoreActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("store", "Kebab Barokah");
                startActivity(intent);
            }
        });
        toko12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminStoreActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("store", "Martabak Santi");
                startActivity(intent);
            }
        });
        toko13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminStoreActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("store", "Kako");
                startActivity(intent);
            }
        });
        toko14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminStoreActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("store", "Lilin's Bakery");
                startActivity(intent);
            }
        });
        toko15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminStoreActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("store", "Kalasan's Fried Chicken");
                startActivity(intent);
            }
        });
        toko16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminStoreActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("store", "Warung Bajau Malela");
                startActivity(intent);
            }
        });
        toko17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminStoreActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("store", "Jus Bela");
                startActivity(intent);
            }
        });
        toko18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminStoreActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("store", "Pentol Kanji Legendaris");
                startActivity(intent);
            }
        });
        toko19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminStoreActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("store", "Pentol Emen");
                startActivity(intent);
            }
        });
        toko20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminStoreActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("store", "Kebab Aisyah");
                startActivity(intent);
            }
        });

        toko21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminStoreActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("store", "Lalapan Pa Rinda");
                startActivity(intent);
            }
        });
        toko22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminStoreActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("store", "Mie Ayam Siring");
                startActivity(intent);
            }
        });
        toko23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminStoreActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("store", "Sate Kacung");
                startActivity(intent);
            }
        });
        toko24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminStoreActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("store", "C2 Cafe");
                startActivity(intent);
            }
        });
        toko25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminStoreActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("store", "Depot Mie Ayam");
                startActivity(intent);
            }
        });
        toko26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminStoreActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("store", "Fresh Pizza Marabahan");
                startActivity(intent);
            }
        });
        toko27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminStoreActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("store", "Gondrong Nasi Goreng");
                startActivity(intent);
            }
        });
        toko28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminStoreActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("store", "Bakso Murni");
                startActivity(intent);
            }
        });
        toko29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminStoreActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("store", "Depot Mbak Yanti");
                startActivity(intent);
            }
        });
        toko30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminStoreActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("store", "Rocket Chicken Jln Kartini");
                startActivity(intent);
            }
        });

        toko31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminStoreActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("store", "Rocket Chicken Jln Vetran");
                startActivity(intent);
            }
        });
        toko32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminStoreActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("store", "Es Cincau Pojokan Kartini");
                startActivity(intent);
            }
        });
        toko33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminStoreActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("store", "RM Padang Suko Menanti Polres");
                startActivity(intent);
            }
        });
        toko34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminStoreActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("store", "RM Padang Suko Menanti Rumpiang");
                startActivity(intent);
            }
        });
        toko35.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminStoreActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("store", "Warung Jawa Timur");
                startActivity(intent);
            }
        });
        toko36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminStoreActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("store", "Ketupat Kandangan Kemenag");
                startActivity(intent);
            }
        });
        toko37.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminStoreActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("store", "Toko Roti Dapoer Gendhis");
                startActivity(intent);
            }
        });
        toko38.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminStoreActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("store", "I Say Moo By Shandy Aulia");
                startActivity(intent);
            }
        });
        toko39.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminStoreActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("store", "Soto Kuin Hanifa");
                startActivity(intent);
            }
        });
        toko40.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminStoreActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("store", "Bakso dan Mie Ayam Mas Bas");
                startActivity(intent);
            }
        });

        toko41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminStoreActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("store", "Depot Mega");
                startActivity(intent);
            }
        });
        toko42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminStoreActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("store", "Warung Nasi Lalapan 3D");
                startActivity(intent);
            }
        });
        toko43.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminStoreActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("store", "Nasi Goreng Jakarta");
                startActivity(intent);
            }
        });
        toko44.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminStoreActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("store", "RM Gorene");
                startActivity(intent);
            }
        });
        toko45.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminStoreActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("store", "Martabak Azizah");
                startActivity(intent);
            }
        });
        toko46.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminStoreActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("store", "Diang Cafe");
                startActivity(intent);
            }
        });
        toko47.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminStoreActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("store", "Warung Makan Lia");
                startActivity(intent);
            }
        });
        toko48.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminStoreActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("store", "Kedai Kopi Kontainer");
                startActivity(intent);
            }
        });
        toko49.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminStoreActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("store", "Terminal Kopi Marabahan");
                startActivity(intent);
            }
        });
        toko50.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminStoreActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("store", "Santo Fried Rice");
                startActivity(intent);
            }
        });

        toko51.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminStoreActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("store", "Toko 51");
                startActivity(intent);
            }
        });
        toko52.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminStoreActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("store", "Toko 52");
                startActivity(intent);
            }
        });
        toko53.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminStoreActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("store", "Toko 53");
                startActivity(intent);
            }
        });
        toko54.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminStoreActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("store", "Toko 54");
                startActivity(intent);
            }
        });
        toko55.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminStoreActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("store", "Toko 55");
                startActivity(intent);
            }
        });
        toko56.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminStoreActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("store", "Toko 56");
                startActivity(intent);
            }
        });
        toko57.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminStoreActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("store", "Toko 57");
                startActivity(intent);
            }
        });
        toko58.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminStoreActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("store", "Toko 58");
                startActivity(intent);
            }
        });
        toko59.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminStoreActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("store", "Toko 59");
                startActivity(intent);
            }
        });
        toko60.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminStoreActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("store", "Toko 60");
                startActivity(intent);
            }
        });

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("Logo");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    LogoToko logoToko = dataSnapshot.getValue(LogoToko.class);
                    nama1.setText(logoToko.getNama1());
                    Picasso.get().load(logoToko.getLogo1()).into(logo1);
                    nama2.setText(logoToko.getNama2());
                    Picasso.get().load(logoToko.getLogo2()).into(logo2);
                    nama3.setText(logoToko.getNama3());
                    Picasso.get().load(logoToko.getLogo3()).into(logo3);
                    nama4.setText(logoToko.getNama4());
                    Picasso.get().load(logoToko.getLogo4()).into(logo4);
                    nama5.setText(logoToko.getNama5());
                    Picasso.get().load(logoToko.getLogo5()).into(logo5);
                    nama6.setText(logoToko.getNama6());
                    Picasso.get().load(logoToko.getLogo6()).into(logo6);
                    nama7.setText(logoToko.getNama7());
                    Picasso.get().load(logoToko.getLogo7()).into(logo7);
                    nama8.setText(logoToko.getNama8());
                    Picasso.get().load(logoToko.getLogo8()).into(logo8);
                    nama9.setText(logoToko.getNama9());
                    Picasso.get().load(logoToko.getLogo9()).into(logo9);
                    nama10.setText(logoToko.getNama10());
                    Picasso.get().load(logoToko.getLogo10()).into(logo10);

                    nama11.setText(logoToko.getNama11());
                    Picasso.get().load(logoToko.getLogo11()).into(logo11);
                    nama12.setText(logoToko.getNama12());
                    Picasso.get().load(logoToko.getLogo12()).into(logo12);
                    nama13.setText(logoToko.getNama13());
                    Picasso.get().load(logoToko.getLogo13()).into(logo13);
                    nama14.setText(logoToko.getNama14());
                    Picasso.get().load(logoToko.getLogo14()).into(logo14);
                    nama15.setText(logoToko.getNama15());
                    Picasso.get().load(logoToko.getLogo15()).into(logo15);
                    nama16.setText(logoToko.getNama16());
                    Picasso.get().load(logoToko.getLogo16()).into(logo16);
                    nama17.setText(logoToko.getNama17());
                    Picasso.get().load(logoToko.getLogo17()).into(logo17);
                    nama18.setText(logoToko.getNama18());
                    Picasso.get().load(logoToko.getLogo18()).into(logo18);
                    nama19.setText(logoToko.getNama19());
                    Picasso.get().load(logoToko.getLogo19()).into(logo19);
                    nama20.setText(logoToko.getNama20());
                    Picasso.get().load(logoToko.getLogo20()).into(logo20);

                    nama21.setText(logoToko.getNama21());
                    Picasso.get().load(logoToko.getLogo21()).into(logo21);
                    nama22.setText(logoToko.getNama22());
                    Picasso.get().load(logoToko.getLogo22()).into(logo22);
                    nama23.setText(logoToko.getNama23());
                    Picasso.get().load(logoToko.getLogo23()).into(logo23);
                    nama24.setText(logoToko.getNama24());
                    Picasso.get().load(logoToko.getLogo24()).into(logo24);
                    nama25.setText(logoToko.getNama25());
                    Picasso.get().load(logoToko.getLogo25()).into(logo25);
                    nama26.setText(logoToko.getNama26());
                    Picasso.get().load(logoToko.getLogo26()).into(logo26);
                    nama27.setText(logoToko.getNama27());
                    Picasso.get().load(logoToko.getLogo27()).into(logo27);
                    nama28.setText(logoToko.getNama28());
                    Picasso.get().load(logoToko.getLogo28()).into(logo28);
                    nama29.setText(logoToko.getNama29());
                    Picasso.get().load(logoToko.getLogo29()).into(logo29);
                    nama30.setText(logoToko.getNama30());
                    Picasso.get().load(logoToko.getLogo30()).into(logo30);

                    nama31.setText(logoToko.getNama31());
                    Picasso.get().load(logoToko.getLogo31()).into(logo31);
                    nama32.setText(logoToko.getNama32());
                    Picasso.get().load(logoToko.getLogo32()).into(logo32);
                    nama33.setText(logoToko.getNama33());
                    Picasso.get().load(logoToko.getLogo33()).into(logo33);
                    nama34.setText(logoToko.getNama34());
                    Picasso.get().load(logoToko.getLogo34()).into(logo34);
                    nama35.setText(logoToko.getNama35());
                    Picasso.get().load(logoToko.getLogo35()).into(logo35);
                    nama36.setText(logoToko.getNama36());
                    Picasso.get().load(logoToko.getLogo36()).into(logo36);
                    nama37.setText(logoToko.getNama37());
                    Picasso.get().load(logoToko.getLogo37()).into(logo37);
                    nama38.setText(logoToko.getNama38());
                    Picasso.get().load(logoToko.getLogo38()).into(logo38);
                    nama39.setText(logoToko.getNama39());
                    Picasso.get().load(logoToko.getLogo39()).into(logo39);
                    nama40.setText(logoToko.getNama40());
                    Picasso.get().load(logoToko.getLogo40()).into(logo40);

                    nama41.setText(logoToko.getNama41());
                    Picasso.get().load(logoToko.getLogo41()).into(logo41);
                    nama42.setText(logoToko.getNama42());
                    Picasso.get().load(logoToko.getLogo42()).into(logo42);
                    nama43.setText(logoToko.getNama43());
                    Picasso.get().load(logoToko.getLogo43()).into(logo43);
                    nama44.setText(logoToko.getNama44());
                    Picasso.get().load(logoToko.getLogo44()).into(logo44);
                    nama45.setText(logoToko.getNama45());
                    Picasso.get().load(logoToko.getLogo45()).into(logo45);
                    nama46.setText(logoToko.getNama46());
                    Picasso.get().load(logoToko.getLogo46()).into(logo46);
                    nama47.setText(logoToko.getNama47());
                    Picasso.get().load(logoToko.getLogo47()).into(logo47);
                    nama48.setText(logoToko.getNama48());
                    Picasso.get().load(logoToko.getLogo48()).into(logo48);
                    nama49.setText(logoToko.getNama49());
                    Picasso.get().load(logoToko.getLogo49()).into(logo49);
                    nama50.setText(logoToko.getNama50());
                    Picasso.get().load(logoToko.getLogo50()).into(logo50);

                    nama51.setText(logoToko.getNama51());
                    Picasso.get().load(logoToko.getLogo51()).into(logo51);
                    nama52.setText(logoToko.getNama52());
                    Picasso.get().load(logoToko.getLogo52()).into(logo52);
                    nama53.setText(logoToko.getNama53());
                    Picasso.get().load(logoToko.getLogo53()).into(logo53);
                    nama54.setText(logoToko.getNama54());
                    Picasso.get().load(logoToko.getLogo54()).into(logo54);
                    nama55.setText(logoToko.getNama55());
                    Picasso.get().load(logoToko.getLogo55()).into(logo55);
                    nama56.setText(logoToko.getNama56());
                    Picasso.get().load(logoToko.getLogo56()).into(logo56);
                    nama57.setText(logoToko.getNama57());
                    Picasso.get().load(logoToko.getLogo57()).into(logo57);
                    nama58.setText(logoToko.getNama58());
                    Picasso.get().load(logoToko.getLogo58()).into(logo58);
                    nama59.setText(logoToko.getNama59());
                    Picasso.get().load(logoToko.getLogo59()).into(logo59);
                    nama60.setText(logoToko.getNama60());
                    Picasso.get().load(logoToko.getLogo60()).into(logo60);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}