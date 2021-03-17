package com.puterabaritoinnovation.ojekinmarabahan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import Model.Users;

public class LoginActivity extends AppCompatActivity {

    private EditText InputUserName, InputPassword;
    private TextView textView;
    private Button LoginButton;
    private String parentDbName = "Users";
    private ProgressDialog loadingBar;
    private ImageView AdminLink, DriverLink;
    private TextView NotAdminLInk, NotDriverLink;

    String USERNAME_KEY = "usernamekey";
    String username_key = "";
    String username_key_new = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getUserNameLocal();

        LoginButton = findViewById(R.id.login_btn);
        InputUserName = findViewById(R.id.login_username_input);
        InputPassword = findViewById(R.id.login_password_input);
        AdminLink = (ImageView) findViewById(R.id.admin_panel_link);
        DriverLink = (ImageView) findViewById(R.id.driver_panel_link);
        NotAdminLInk = (TextView) findViewById(R.id.not_admin_panel_link);
        NotDriverLink = (TextView) findViewById(R.id.not_driver_panel_link);
        textView = findViewById(R.id.create_account_btn);
        loadingBar = new ProgressDialog(this);

        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LoginUser();

            }
        });

        AdminLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginButton.setText("Login Admin");
                AdminLink.setVisibility(View.INVISIBLE);
                NotAdminLInk.setVisibility(View.VISIBLE);
                parentDbName = ("Admins");
            }
        });

        DriverLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginButton.setText("Login Driver");
                DriverLink.setVisibility(View.INVISIBLE);
                NotDriverLink.setVisibility(View.VISIBLE);
                parentDbName = ("Drivers");
            }
        });

        NotAdminLInk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginButton.setText("Login");
                AdminLink.setVisibility(View.VISIBLE);
                NotAdminLInk.setVisibility(View.INVISIBLE);
                parentDbName = ("Users");
            }
        });

        NotDriverLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginButton.setText("Login");
                DriverLink.setVisibility(View.VISIBLE);
                NotDriverLink.setVisibility(View.INVISIBLE);
                parentDbName = ("Users");
            }
        });

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

    }

    private void LoginUser() {
        String username = InputUserName.getText().toString();
        String password = InputPassword.getText().toString();

        if (TextUtils.isEmpty(username))
        {
            Toast.makeText(LoginActivity.this, "Silahkan tulis nama pengguna...", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(password))
        {
            Toast.makeText(LoginActivity.this, "Silahkan tulis password anda...", Toast.LENGTH_SHORT).show();
        }
        else
        {
            loadingBar.setTitle("Login akun");
            loadingBar.setMessage("Silahkan tunggu sebentar");
            loadingBar.setCanceledOnTouchOutside(false);
            loadingBar.show();

            AllowAccessToAccount (username, password);
        }
    }

    private void AllowAccessToAccount(final String username, final String password) {


        final DatabaseReference RootRef;
        RootRef = FirebaseDatabase.getInstance().getReference();


        RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.child(parentDbName).child(username).exists())
                {
                    Users usersData = dataSnapshot.child(parentDbName).child(username).getValue(Users.class);

                    if (usersData.getUsername().equals(username))
                    {
                        if (usersData.getPassword().equals(password))
                        {
                            if (parentDbName.equals("Admins"))
                            {
                                Toast.makeText(LoginActivity.this, "Selamat datang admin", Toast.LENGTH_SHORT).show();
                                loadingBar.dismiss();

                                Intent gotoadminsite = new Intent(LoginActivity.this, AdminStoreActivity.class);
                                startActivity(gotoadminsite);
                            }
                            if (parentDbName.equals("Drivers"))
                            {
                                Toast.makeText(LoginActivity.this, "Selamat datang driver", Toast.LENGTH_SHORT).show();
                                loadingBar.dismiss();

                                Intent intent = new Intent(LoginActivity.this, DriverCekOrderActivity.class);
                                startActivity(intent);
                            }
                            else if (parentDbName.equals("Users"))
                            {
                                SharedPreferences sharedPreferences = getSharedPreferences(USERNAME_KEY, MODE_PRIVATE);
                                SharedPreferences.Editor editor = sharedPreferences.edit();
                                editor.putString(username_key, InputUserName.getText().toString());
                                editor.apply();

                                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                                startActivity(intent);
                            }
                        }
                        else
                        {
                            loadingBar.dismiss();
                            Toast.makeText(LoginActivity.this, "Password anda salah", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
                else
                {
                    Toast.makeText(LoginActivity.this, "Akun " + username + " belum terdaftar", Toast.LENGTH_SHORT).show();
                    loadingBar.dismiss();
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