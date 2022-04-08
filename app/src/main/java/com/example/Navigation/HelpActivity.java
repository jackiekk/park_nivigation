package com.example.Navigation;

import android.os.Bundle;

import com.example.Navigation.databinding.ActivityHelpBinding;

public class HelpActivity extends DrawerBaseActivity{

        ActivityHelpBinding binding;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            binding = ActivityHelpBinding.inflate(getLayoutInflater());
            setContentView(binding.getRoot());
            allocateActivityTitle("Help");
    }
}