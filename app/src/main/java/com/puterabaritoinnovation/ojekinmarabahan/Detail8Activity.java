package com.puterabaritoinnovation.ojekinmarabahan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

import Model.Products;

public class Detail8Activity extends AppCompatActivity {

    private ImageView productImage;
    private EditText tambahanPesanan;
    private TextView productName, productDescription, txtjumlahpesanan, productPrice, productStore, contactSeller;
    private Button btnminus, btnplus, keranjangBtn;
    private String productID = "", status = "Normal";
    String productRandomKey, saveCurrentDate, saveCurrentTime;
    Integer valuejumlahpesanan = 1;

    String USERNAME_KEY = "usernamekey";
    String username_key = "";
    String username_key_new = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail8);
        getUserNameLocal();

        Calendar calendar = Calendar.getInstance();

        SimpleDateFormat currentDate = new SimpleDateFormat("MMM dd, yyyy");
        saveCurrentDate = currentDate.format(calendar.getTime());

        SimpleDateFormat currentTime = new SimpleDateFormat("HH:mm:ss a");
        saveCurrentTime = currentTime.format(calendar.getTime());

        productRandomKey = saveCurrentDate + saveCurrentTime;

        productID = getIntent().getStringExtra("pid");

        btnminus = (Button) findViewById(R.id.btnminus);
        btnplus = (Button) findViewById(R.id.btnplus);
        keranjangBtn = (Button) findViewById(R.id.checkout_btn);
        productImage = (ImageView) findViewById(R.id.product_image_details);
        productName = (TextView) findViewById(R.id.product_name_details);
        txtjumlahpesanan = (TextView) findViewById(R.id.jumlahpesanan);
        productPrice = (TextView) findViewById(R.id.product_price_details);
        productStore = (TextView) findViewById(R.id.product_store_details);
        productDescription = (TextView) findViewById(R.id.product_description_details);
        contactSeller = (TextView) findViewById(R.id.product_contact_details);
        tambahanPesanan = (EditText) findViewById(R.id.tambahan_pesanan);

        //settingvalue
        txtjumlahpesanan.setText(valuejumlahpesanan.toString());

        //default hide btnminus
        btnminus.animate().alpha(0).setDuration(300).start();
        btnminus.setEnabled(false);

        btnplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valuejumlahpesanan +=1;
                txtjumlahpesanan.setText(valuejumlahpesanan.toString());
                if (valuejumlahpesanan > 1) {
                    btnminus.animate().alpha(1).setDuration(300).start();
                    btnminus.setEnabled(true);
                }
            }
        });

        btnminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valuejumlahpesanan -=1;
                txtjumlahpesanan.setText(valuejumlahpesanan.toString());
                if (valuejumlahpesanan < 2) {
                    btnminus.animate().alpha(1).setDuration(300).start();
                    btnminus.setEnabled(true);
                }
            }
        });

        keranjangBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (status.equals("Pesanan dalam proses") || status.equals("Pesanan sudah diantarkan")){
                    Toast.makeText(Detail8Activity.this, "Anda dapat melakukan pemesanan kembali setelah pesanan anda sebelumnya telah selesai diproses", Toast.LENGTH_SHORT).show();
                }else {
                    addingToCartList();
                }

            }
        });
        getProductDetails (productID);
    }

    private void getProductDetails(String productID) {
        DatabaseReference productsRef = FirebaseDatabase.getInstance().getReference().child("Products").child("Warung Makan Mami");
        productsRef.child(productID).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()){
                    Products products = dataSnapshot.getValue(Products.class);
                    productName.setText(products.getPname());
                    productPrice.setText("Rp" + products.getPrice());
                    productDescription.setText(products.getDescription());
                    contactSeller.setText(products.getContact());
                    productStore.setText(products.getStore());
                    Picasso.get().load(products.getImage())
                            .into(productImage);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        CheckOrderState();
    }

    private void addingToCartList() {
        final DatabaseReference cartListRef = FirebaseDatabase.getInstance().getReference().child("Cart List");

        final HashMap<String, Object> cartMap = new HashMap<>();
        cartMap.put("pid", productID);
        cartMap.put("pname", productName.getText().toString());
        cartMap.put("price", productPrice.getText().toString());
        cartMap.put("quantity", txtjumlahpesanan.getText().toString());
        cartMap.put("store", productStore.getText().toString());
        cartMap.put("tambahan", tambahanPesanan.getText().toString());

        cartListRef.child("User View").child(username_key_new).child("Products").child(productID)
                .updateChildren(cartMap)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                        if (task.isSuccessful()){
                            cartListRef.child("Admin View").child(username_key_new).child("Products").child(productID)
                                    .updateChildren(cartMap)
                                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {

                                            if (task.isSuccessful()) {
                                                Toast.makeText(Detail8Activity.this, "Produk sukses ditambahkan ke dalam keranjang, cek menu Keranjang Saya", Toast.LENGTH_SHORT).show();
                                            }

                                        }
                                    });
                        }

                    }
                });

    }

    private void CheckOrderState()
    {
        DatabaseReference ordersRef;
        ordersRef = FirebaseDatabase.getInstance().getReference().child("Orders").child(username_key_new);

        ordersRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    String shippingState = dataSnapshot.child("status").getValue().toString();
                    if (shippingState.equals("Sudah diantar")){
                        status = "Pesanan sudah diantarkan";
                    } else if(shippingState.equals("Belum diantar")){
                        status = "Pesanan dalam proses";
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    public void getUserNameLocal () {
        SharedPreferences sharedPreferences = getSharedPreferences(USERNAME_KEY, MODE_PRIVATE);
        username_key_new = sharedPreferences.getString(username_key, "");
    }
}