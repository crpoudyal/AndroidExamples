package com.androidexamples;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class UserFormActivity extends AppCompatActivity {
    public static final String EMAIL = "int_email";
    public static final String ADDRESS = "int_address";
    public static final String PHONE = "int_phone";


    EditText edtEmail,edtAddress,edtPhone;
    Button show_data;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_form_layout);


//        finding view
        edtEmail = findViewById(R.id.email);
        edtAddress = findViewById(R.id.address);
        edtPhone = findViewById(R.id.phone);
        show_data = findViewById(R.id.show_data);

//        getting data
        String email = edtEmail.getText().toString();
        String address = edtAddress.getText().toString();
        String phone = edtPhone.getText().toString();



        show_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserFormActivity.this,UserFormDataActivity.class);
                intent.putExtra(EMAIL,email);
                intent.putExtra(ADDRESS,address);
                intent.putExtra(PHONE,phone);
                startActivity(intent);
                finish();
            }
        });

    }
}
