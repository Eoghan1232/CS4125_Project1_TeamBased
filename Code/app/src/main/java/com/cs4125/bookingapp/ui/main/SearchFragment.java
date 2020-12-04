package com.cs4125.bookingapp.ui.main;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;

import android.app.TimePickerDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TimePicker;

import com.cs4125.bookingapp.R;

public class SearchFragment extends FragmentActivity
{

    private SearchViewModel mViewModel;

    public static SearchFragment newInstance()
    {
        return new SearchFragment();
    }

//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
//    {
//        return inflater.inflate(R.layout.search_fragment, container, false);
//    }

//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState)
//    {
//        super.onActivityCreated(savedInstanceState);
//        mViewModel = new ViewModelProvider(this).get(SearchViewModel.class);
//        // TODO: Use the ViewModel
//    }

    @Nullable
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Button timePick = (Button) findViewById(R.id.timePicker);
        timePick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment timePicker = new TimePickerFragment();
                timePicker.show(getSupportFragmentManager(), "time Picker");
            }
        });

        Button datePick = (Button) findViewById(R.id.datePicker);
        datePick.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePicker = new TimePickerFragment();
                datePicker.show(getSupportFragmentManager(), "date Picker");
            }
        }));
    }


}