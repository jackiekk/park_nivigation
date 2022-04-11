package com.example.Navigation;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignupActivity extends AppCompatActivity {

    private TextView tvAccount;


    private EditText edFullName;
    private EditText edEmailAddress;
    private EditText edPlateno;
    private EditText edPassword;
    private EditText edPhone;
    private EditText edConfirmPassword;
    private Button btnRegister;
    String emailpattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    ProgressDialog progressDialog;

    DatabaseReference userDbRef;

    FirebaseAuth mAuth;
    FirebaseUser mUser;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        tvAccount = findViewById(R.id.tv_account);

        edFullName = findViewById(R.id.ed_fullname);
        edEmailAddress = findViewById(R.id.ed_address);
        edPlateno = findViewById(R.id.ed_plateno);
        edPassword = findViewById(R.id.ed_pasword);
        edPhone = findViewById(R.id.ed_phone);
        edConfirmPassword = findViewById(R.id.ed_cpassword);
        btnRegister = findViewById(R.id.btn_register);
        tvAccount = findViewById(R.id.tv_account);

        userDbRef = FirebaseDatabase.getInstance().getReference().child("Users");

        progressDialog= new ProgressDialog(this);
        mAuth= FirebaseAuth.getInstance();
        mUser= mAuth.getCurrentUser();

        tvAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(com.example.Navigation.SignupActivity.this, com.example.Navigation.MainActivity.class));
            }
        });


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertEntryData();

                PerforAuth();
            }
        });
    }

    private void insertEntryData() {
        String FullName = edFullName.getText().toString();
        String EmailAddress = edEmailAddress.getText().toString();
        String Plateno = edPlateno.getText().toString();
        String Phone = edPhone.getText().toString();

        User user = new User(FullName, EmailAddress, Plateno, Phone);

        userDbRef.push().setValue(user);
    }

    private void PerforAuth() {
        String strFullName = edFullName.getText().toString();
        String strPlateno = edPlateno.getText().toString();
        String strEmailAddress = edEmailAddress.getText().toString();
        String strPhone = edPhone.getText().toString();
        String strPassword = edPassword.getText().toString();
        String strConfirmPassword = edConfirmPassword.getText().toString();

        if (strFullName.isEmpty())
        {
            edFullName.setError("Enter Full Name");

        }else if (!strEmailAddress.matches(emailpattern))
        {
            edEmailAddress.setError("Enter correct Email format");

        }else if (strPhone.isEmpty())
        {
            edPhone.setError("Enter Your Phone number");

        }else if (strPlateno.isEmpty())
        {
            edPlateno.setError("Enter Plate Number");

        } else if (strPassword.isEmpty() || strPassword.length()<8)
        {
            edPassword.setError("Enter Strong Password");

        } else if (!strPassword.equals(strConfirmPassword))
        {
            edConfirmPassword.setError("Password Does Not Match");

        } else
        {
            progressDialog.setMessage("Please Wait While Registration...");
            progressDialog.setTitle("Registration");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            mAuth.createUserWithEmailAndPassword(strEmailAddress,strPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful())
                    {
                        progressDialog.dismiss();
                        sendUserToNextActivity();
                        Toast.makeText(com.example.Navigation.SignupActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                    }else
                    {
                        progressDialog.dismiss();
                        Toast.makeText(com.example.Navigation.SignupActivity.this, ""+task.getException(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void sendUserToNextActivity() {
        Intent intent=new Intent(com.example.Navigation.SignupActivity.this, com.example.Navigation.NavigationActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}