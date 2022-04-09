package com.example.Navigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.Navigation.databinding.ActivityHistoryBinding;
import com.example.Navigation.databinding.ActivityProfileBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfileActivity extends DrawerBaseActivity {
    ActivityProfileBinding binding;

    ImageView pImagev;
    EditText pFullname;
    EditText pEmailAddress;
    EditText pPlateno;
    Button btnProfile;
    User user;
    String Fullname, EmailAddress, Plateno, uid;

    FirebaseDatabase database;
    FirebaseAuth fAuth;
    DatabaseReference Dref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        allocateActivityTitle("Profile");

        btnProfile = findViewById(R.id.btn_profile);
        pFullname = findViewById(R.id.p_fullname);
        pEmailAddress = findViewById(R.id.p_emailAddress);
        pPlateno = findViewById(R.id.p_plateno);

        fAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        uid = fAuth.getCurrentUser().getUid().toString();

        Dref = database.getReference().child("Users");
        if (!uid.isEmpty()) {

            getUserdata();
        }

    }

    private void getUserdata() {
        Dref.child(uid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists() && snapshot.getChildrenCount() > 0)
                {
                    user = snapshot.getValue(User.class);
                    binding.pFullname.setText(user.FullName);
                    binding.pEmailAddress.setText(user.EmailAddress);
                    binding.pPlateno.setText(user.Plateno);
                    
                    /*String FullName = snapshot.child("fullName").getValue().toString();
                    String EmailAddress = snapshot.child("emailAddress").getValue().toString();
                    String Plateno = snapshot.child("plateno").getValue().toString();*/


                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

}

