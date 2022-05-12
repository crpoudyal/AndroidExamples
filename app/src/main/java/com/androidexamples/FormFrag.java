package com.androidexamples;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class FormFrag extends Fragment {

    EditText edtEmail, edtPassword, edtPhone, edtAddress;
    Button submitBtn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.example_form_layout, container, false);

        //        finding view

        edtEmail = view.findViewById(R.id.edt_email);
        edtPassword = view.findViewById(R.id.edt_password);
        edtPhone = view.findViewById(R.id.edt_phone);
        edtAddress = view.findViewById(R.id.edt_addr);
        submitBtn = view.findViewById(R.id.submit_btn);


        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//        getting view data

                String email = edtEmail.getText().toString();
                String password = edtPassword.getText().toString();
                String phone = edtPhone.getText().toString();
                String address = edtAddress.getText().toString();
                Boolean check = validation(email, password, phone, address);
                if (check) {
                    Toast.makeText(getActivity(), "Form Submitted successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getActivity(), "Please fill the form properly", Toast.LENGTH_SHORT).show();

                }
            }
        });
        return view;
    }

    private Boolean validation(String email, String password, String phone, String address) {
        if (email.isEmpty()) {
            edtEmail.setError("Please enter your email");
            return false;
        } else if (!email.matches("^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$")) {
            edtEmail.setError("valid email format xyz@xyz.com");
            return false;
        } else if (password.isEmpty()) {
            edtPassword.setError("Please enter your password");
            return false;
        } else if (phone.isEmpty()) {
            edtPhone.setError("Please enter your phone number");
            return false;
        } else if (address.isEmpty()) {
            edtPhone.setError("Please enter your Address");
            return false;
        } else {
            return true;
        }
    }
}
