package com.example.Navigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.Navigation.databinding.ActivityHistoryBinding;
import com.example.Navigation.databinding.ActivityProfileBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfileActivity extends DrawerBaseActivity {
    ActivityProfileBinding binding;

    ImageView pImagev;
    private TextView pFullname;
    private TextView pEmailAddress;
    private TextView pPlateno;
    private TextView pPhone;
    //Button btnProfile;
    User user;
    DatabaseReference databaseReference;
    FirebaseAuth mAuth;
    FirebaseDatabase firebaseDatabase;
    String uid;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        allocateActivityTitle("Profile");

        //btnProfile = findViewById(R.id.btn_profile);
        pFullname = findViewById(R.id.p_fullname);
        pEmailAddress = findViewById(R.id.p_emailAddress);
        pPlateno = findViewById(R.id.p_plateno);
        pPhone = findViewById(R.id.p_phone);

        firebaseDatabase =  FirebaseDatabase.getInstance();
        mAuth = FirebaseAuth.getInstance();
        uid = mAuth.getCurrentUser().getUid();
         //databaseReference = mAuth.getRegetUid();



        if (!uid.isEmpty()) {

            getUserdata(uid);
        }

    }

    private void getUserdata(String uid) {
        DatabaseReference usersRef = FirebaseDatabase.getInstance().getReference().child("Users");
        DatabaseReference currentUser = usersRef.child(uid);
        currentUser.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for ( DataSnapshot postSnapshot : snapshot.getChildren())
                {
                    user = postSnapshot.getValue(User.class);
                    pFullname.setText(user.getFullName());
                    pEmailAddress.setText(user.getEmailAddress());
                    pPlateno.setText(user.getPlateno());
                    pPhone.setText(user.getPhone());

                     /*Fullname = snapshot.child("fullName").getValue().toString();
                    String EmailAddress = snapshot.child("emailAddress").getValue().toString();
                    String Plateno = snapshot.child("plateno").getValue().toString();*/


                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(com.example.Navigation.ProfileActivity.this, " Failed to read", Toast.LENGTH_SHORT).show();

            }
        });
    }

}

