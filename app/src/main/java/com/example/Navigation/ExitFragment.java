package com.example.Navigation;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ExitFragment extends Fragment {
    Button btnSubmit1;
    Button btnTimeout;
    TextView tvTimeout;
    Spinner spPlateno;

    Calendar calendar;
    SimpleDateFormat simpleDateFormat;
    String Date;

    DatabaseReference exitDbRef;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_exit, container, false);

        String [] values =
                {"--Number Plate--", "KDD 145Y", "KCY 564Z"};
        Spinner plateno = (Spinner) v.findViewById(R.id.sp_plateno);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, values);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        plateno.setAdapter(adapter);

        btnSubmit1 = v.findViewById(R.id.btn_submit1);
        btnTimeout = v.findViewById(R.id.btn_timeout);
        tvTimeout = v.findViewById(R.id.tv_timeout);
        spPlateno = v.findViewById(R.id.sp_plateno);

        calendar = Calendar.getInstance();
        simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy  HH:mm");
        Date = simpleDateFormat.format(calendar.getTime());

        exitDbRef = FirebaseDatabase.getInstance().getReference().child("Exit");

        btnTimeout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvTimeout.setText(Date);
            }
        });

        btnSubmit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertEntryData();

                Intent intent = new Intent(getActivity(), GenerateActivity.class);
                startActivity(intent);
            }
        });

        return v;

    }

    private void insertEntryData() {
        String Plateno = spPlateno.getSelectedItem().toString();
        String Timeout = tvTimeout.getText().toString();

        Exit exit = new Exit( Plateno,Timeout);

        exitDbRef.push().setValue(exit);
    }
}