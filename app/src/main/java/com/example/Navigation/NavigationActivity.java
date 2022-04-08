package com.example.Navigation;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;

import com.example.Navigation.databinding.ActivityNavigationBinding;


public class NavigationActivity extends DrawerBaseActivity {

   ActivityNavigationBinding binding;
   Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNavigationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        allocateActivityTitle("Dashboard");
        replaceFragment(new MapsFragment());



        binding.bottomNavView.setOnItemSelectedListener(item ->{
            switch (item.getItemId()){
                case R.id.map:
                    replaceFragment(new MapsFragment());
                    break;
                case R.id.entrance:
                    replaceFragment(new EntranceFragment());
                    break;
                case R.id.exit:
                    replaceFragment(new ExitFragment());
                    break;
                case R.id.more:
                    break;
            }
            return true;
        });
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,fragment);
        fragmentTransaction.commit();
    }
}