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
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

import Model.Ongkir;

public class ConfirmFinalOrderActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_LOCATION_PERMISSION = 1;

    private EditText nameET, addressET, tambahanET;
    private TextView ongkir, textView_latlong, txtFoodOngkir, txtConfirm;
    private Button confirmOrderBtn;
    String productRandomKey, saveCurrentDate, saveCurrentTime;

    String USERNAME_KEY = "usernamekey";
    String username_key = "";
    String username_key_new = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_final_order);

        getUserNameLocal();

        Calendar calendar = Calendar.getInstance();

        SimpleDateFormat currentDate = new SimpleDateFormat("MMM dd, yyyy");
        saveCurrentDate = currentDate.format(calendar.getTime());

        SimpleDateFormat currentTime = new SimpleDateFormat("HH:mm:ss a");
        saveCurrentTime = currentTime.format(calendar.getTime());

        productRandomKey = saveCurrentDate + saveCurrentTime;

        confirmOrderBtn = findViewById(R.id.confirm_final_order_btn);
        nameET = findViewById(R.id.shippment_nama_pemesan);
        addressET = findViewById(R.id.shippment_alamat_pemesan);
        tambahanET = findViewById(R.id.shippment_tambahan_pesanan);
        ongkir = (TextView) findViewById(R.id.jarak_ongkir);
        textView_latlong = findViewById(R.id.textLatLong);
        txtFoodOngkir = findViewById(R.id.foodOngkirTxt);
        txtConfirm = findViewById(R.id.confirmTxt);

        ongkir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(
                        getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(
                            ConfirmFinalOrderActivity.this,
                            new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                            REQUEST_CODE_LOCATION_PERMISSION
                    );
                } else {
                    getCurrentLocation();
                }

                Intent intent = new Intent(ConfirmFinalOrderActivity.this, DistanceActivity.class);
                startActivity(intent);
            }
        });



        confirmOrderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                check();

            }
        });

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("Ongkir");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    Ongkir ongkir = dataSnapshot.getValue(Ongkir.class);
                    txtFoodOngkir.setText(ongkir.getOngkirJekFood());
                    txtConfirm.setText(ongkir.getConfirmText());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    private void check() {

        if (TextUtils.isEmpty(nameET.getText().toString()))
        {
            Toast.makeText(this, "Silahkan tulis nama pengguna", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(addressET.getText().toString()))
        {
            Toast.makeText(this, "Silahkan tulis alamat pengantaran", Toast.LENGTH_SHORT).show();
        }
        else {
            ConfirmOrder ();
        }

    }

    private void ConfirmOrder() {

        final DatabaseReference ordersRef = FirebaseDatabase.getInstance().getReference().child("Orders")
                .child(username_key_new);

        HashMap<String, Object> ordersMap = new HashMap<>();
        ordersMap.put("nama_pemesan", nameET.getText().toString());
        ordersMap.put("alamat_pengantaran", addressET.getText().toString());
        ordersMap.put("tambahan_pesanan", tambahanET.getText().toString());
        ordersMap.put("date", saveCurrentDate);
        ordersMap.put("time", saveCurrentTime);
        ordersMap.put("status", "Belum diantar");

        ordersRef.updateChildren(ordersMap).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

                if (task.isSuccessful()){
                    FirebaseDatabase.getInstance().getReference().child("Cart List")
                            .child("User View")
                            .child(username_key_new)
                            .removeValue()
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful())
                                    {
                                        final String nama = nameET.getText().toString();
                                        final String alamat = addressET.getText().toString();
                                        final String tambahan = tambahanET.getText().toString();

                                        boolean installed = appInstalledOrNot("com.whatsapp");

                                        if (installed){
                                            Intent intent = new Intent(Intent.ACTION_VIEW);
                                            intent.setData(Uri.parse("http://api.whatsapp.com/send?phone="+"+6285651121002"+"&text=*Nama Pemesan* : " + nama + "\n" + "*Alamat Pengantaran* : "+ alamat + "\n" + "*Tambahan* : "+ tambahan));
                                            startActivity(intent);
                                        } else {
                                            Toast.makeText(ConfirmFinalOrderActivity.this, "Aplikasi WhatsApp belum terinstal di Smartphone anda", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }
                            });
                }

            }
        });



    }

    private void getCurrentLocation() {

        LocationRequest locationRequest = new LocationRequest();
        locationRequest.setInterval(10000);
        locationRequest.setFastestInterval(3000);
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        LocationServices.getFusedLocationProviderClient(ConfirmFinalOrderActivity.this)
                .requestLocationUpdates(locationRequest, new LocationCallback() {
                    @Override
                    public void onLocationResult(LocationResult locationResult) {
                        super.onLocationResult(locationResult);
                        LocationServices.getFusedLocationProviderClient(ConfirmFinalOrderActivity.this).removeLocationUpdates(this);
                        if (locationResult != null && locationResult.getLocations().size() > 0) {
                            int latestLocationIndex = locationResult.getLocations().size() - 1;
                            double latitude = locationResult.getLocations().get(latestLocationIndex).getLatitude();
                            double longitude = locationResult.getLocations().get(latestLocationIndex).getLongitude();
                            textView_latlong.setText(
                                    String.format(
                                            "Lat: %s\nLong: %s",
                                            latitude,
                                            longitude
                                    )
                            );
                        }
                    }
                }, Looper.getMainLooper());
    }

    private boolean appInstalledOrNot (String url) {
        PackageManager packageManager = getPackageManager();
        boolean app_installed;
        try {
            packageManager.getPackageInfo(url, PackageManager.GET_ACTIVITIES);
            app_installed = true;
        }
        catch (PackageManager.NameNotFoundException e) {
            app_installed =false;
        }
        return app_installed;
    }

    public void getUserNameLocal () {
        SharedPreferences sharedPreferences = getSharedPreferences(USERNAME_KEY, MODE_PRIVATE);
        username_key_new = sharedPreferences.getString(username_key, "");

    }
}