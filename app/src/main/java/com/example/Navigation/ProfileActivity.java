package com.example.Navigation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.Navigation.databinding.ActivityHistoryBinding;
import com.example.Navigation.databinding.ActivityProfileBinding;

public class ProfileActivity extends DrawerBaseActivity {
    ActivityProfileBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        allocateActivityTitle("Profile");

    }
}