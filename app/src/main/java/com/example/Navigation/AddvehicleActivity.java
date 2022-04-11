package com.example.Navigation;

import android.os.Bundle;

import com.example.Navigation.databinding.ActivityAddvehicleBinding;

public class AddvehicleActivity extends DrawerBaseActivity {

        ActivityAddvehicleBinding binding;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            binding = ActivityAddvehicleBinding.inflate(getLayoutInflater());
            setContentView(binding.getRoot());
            allocateActivityTitle("My Vehicle");

    }
}