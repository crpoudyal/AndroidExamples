package com.androidexamples;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class UserFormDataActivity extends AppCompatActivity {
    String email_str, address_str, phone_str;
    TextView tvEmail, tvAddress, tvPhone;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_form_data_layout);


//        finding view
        tvEmail = findViewById(R.id.tv_email);
        tvAddress = findViewById(R.id.tv_address);
        tvPhone = findViewById(R.id.tv_phone);


        Intent intent = getIntent();


        email_str = intent.getStringExtra(UserFormActivity.EMAIL);
        tvEmail.setText("Email : " + email_str);


        address_str = intent.getStringExtra(UserFormActivity.ADDRESS);
        tvAddress.setText("Address : " + address_str);


        phone_str = intent.getStringExtra(UserFormActivity.PHONE);
        tvPhone.setText("Phone : " + phone_str);


    }
}
