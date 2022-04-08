package com.example.Navigation;

import android.os.Bundle;

import com.example.Navigation.databinding.ActivityHistoryBinding;

public class HistoryActivity extends DrawerBaseActivity {

        ActivityHistoryBinding binding;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            binding = ActivityHistoryBinding.inflate(getLayoutInflater());
            setContentView(binding.getRoot());
            allocateActivityTitle("History");
    }
}