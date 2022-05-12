package com.androidexamples;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class DialogListFrag extends Fragment {
    Button alertBtn, customBtn,btnOk,btnCancel;
    EditText edtName,edtAddress;
    TextView result;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_list, container, false);



        alertBtn = view.findViewById(R.id.alert_dialog);
        customBtn = view.findViewById(R.id.custom_dialog);

        alertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAlertDialog();
            }
        });

        customBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCustomDialog();
            }
        });
        return view;
    }
//    CustomDialog method
    public void showCustomDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Custom Dialog");
        builder.setCancelable(true);

        LayoutInflater inflater = getLayoutInflater();
        View view=inflater.inflate(R.layout.custom_dialog, null);
        builder.setView(view);

        //wiring up widgets
        edtName=view.findViewById(R.id.edtName);
        edtAddress=view.findViewById(R.id.edt_addr);
        btnOk = view.findViewById(R.id.btn_ok);
        btnCancel = view.findViewById(R.id.btn_cancel);
        result = view.findViewById(R.id.result);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name,address;
                name = edtName.getText().toString();
                address = edtAddress.getText().toString();

                result.setText("Name : "+name+"\n"+"Address : "+address);

            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        AlertDialog alert = builder.create();
        alert.show();

    }


//    AlertDialog method

    public void showAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Exit App");
        builder.setMessage("Do you want to exit App?");
        builder.setCancelable(true);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
