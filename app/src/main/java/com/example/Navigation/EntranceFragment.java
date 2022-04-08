package com.example.Navigation;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class EntranceFragment extends Fragment {

    Button btnSubmit;
    Button btnTimein;
    Spinner sOccupation;
    Spinner sPArea;
    Spinner sPlateno;
    EditText tvTimein;

    Calendar calendar;
    SimpleDateFormat simpleDateFormat;
    String Date;

    DatabaseReference entryDbRef;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_entrance, container, false);

        String [] values =
                {"--Occupation--","Staff", "Student", "Visitor"};
        Spinner occupation = (Spinner) v.findViewById(R.id.s_occupation);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, values);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        occupation.setAdapter(adapter);

        String [] values1 =
                {"--Parking Area--","SPD", "LBB", "ECA", "LIBRARY"};
        Spinner pArea = (Spinner) v.findViewById(R.id.s_pArea);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, values1);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        pArea.setAdapter(adapter1);

        String [] values2 =
                {"--Number Plate--", "KDD 145Y", "KCY 564Z"};
        Spinner plateno = (Spinner) v.findViewById(R.id.s_plateno);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, values2);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        plateno.setAdapter(adapter2);

        btnSubmit = v.findViewById(R.id.btn_submit);
        btnTimein = v.findViewById(R.id.btn_timein);
        tvTimein = v.findViewById(R.id.tv_timein);
        sOccupation = v.findViewById(R.id.s_occupation);
        sPArea = v.findViewById(R.id.s_pArea);
        sPlateno = v.findViewById(R.id.s_plateno);

        calendar = Calendar.getInstance();
        simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy  HH:mm");
        Date = simpleDateFormat.format(calendar.getTime());

        entryDbRef = FirebaseDatabase.getInstance().getReference().child("Entry");

        btnTimein.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvTimein.setText(Date);
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertEntryData();

                Intent intent = new Intent(getActivity(), GenerateActivity.class);
                startActivity(intent);
            }
        });
              return v;
            //return inflater.inflate(R.layout.fragment_entrance, container, false);
    }

    private void insertEntryData() {
        String Occupation = sOccupation.getSelectedItem().toString();
        String PArea = sPArea.getSelectedItem().toString();
        String Plateno = sPlateno.getSelectedItem().toString();
        String Timein = tvTimein.getText().toString();

        Entry entry = new Entry(Occupation, PArea, Plateno,Timein);

        entryDbRef.push().setValue(entry);

        }
    }
