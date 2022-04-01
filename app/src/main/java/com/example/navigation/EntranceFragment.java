package com.example.navigation;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;

public class EntranceFragment extends Fragment {

    Button btnSubmit;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_entrance, container, false);

        String [] values =
                {"--Occupation--","Staff", "Student", "Visitor"};
        Spinner occupation = (Spinner) v.findViewById(R.id.occupation);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, values);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        occupation.setAdapter(adapter);

        String [] values1 =
                {"--Parking Area--","SPD", "LBB", "ECA", "LIBRARY"};
        Spinner pArea = (Spinner) v.findViewById(R.id.pArea);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, values1);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        pArea.setAdapter(adapter1);

        String [] values2 =
                {"--Number Plate--", "KDD 145Y", "KCY 564Z"};
        Spinner plateno = (Spinner) v.findViewById(R.id.plateno);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, values2);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        plateno.setAdapter(adapter2);

        btnSubmit= v.findViewById(R.id.btn_submit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), GenerateActivity.class);
                startActivity(intent);
            }
        });

        return v;

        //return inflater.inflate(R.layout.fragment_entrance, container, false);
    }
}