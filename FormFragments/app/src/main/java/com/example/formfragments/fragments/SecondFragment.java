package com.example.formfragments.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.formfragments.R;
import com.google.android.material.switchmaterial.SwitchMaterial;

import java.util.ArrayList;

public class SecondFragment extends Fragment {

    Spinner spinner;

    Button finish_button;

    String selected, radioSelected, switchString;

    RadioGroup radioGroup;

    RadioButton radioButton;

    CheckBox checkbox_meat, checkbox_cheese;

    SwitchMaterial switchMaterial;

    ArrayList checkSelected;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        spinner = view.findViewById(R.id.spinner);
        radioGroup = view.findViewById(R.id.radio_group);
        finish_button = view.findViewById(R.id.finish);
        switchMaterial = view.findViewById(R.id.material_switch);
        switchString = "OFF";
        checkSelected = new ArrayList();
        selectSwitch();

        viewCheckBox(view);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                getContext(),
                R.array.planets_array,
                android.R.layout.simple_spinner_item
        );

        // Specify the layout to use when the list of choices appears.
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner.
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selected = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



        finish_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//              int selectedRadioId = radioGroup.getCheckedRadioButtonId();
//              radioButton = getView().findViewById(selectedRadioId);
                Toast.makeText(getContext(), switchString, Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    public void viewCheckBox(View view){
        checkbox_cheese = view.findViewById(R.id.checkbox_cheese);
        checkbox_meat = view.findViewById(R.id.checkbox_meat);

        checkbox_cheese.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    checkSelected.add(compoundButton.getText().toString());
                } else {
                    checkSelected.remove(compoundButton.getText().toString());
                }
            }
        });

        checkbox_meat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                   checkSelected.add(compoundButton.getText().toString());
                } else {
                    checkSelected.remove(compoundButton.getText().toString());
                }
            }
        });
    }

    public void selectSwitch(){
        switchMaterial.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    switchString = switchMaterial.getTextOn().toString();
                } else {
                    switchString = switchMaterial.getTextOff().toString();
                }
            }
        });
    }
}
