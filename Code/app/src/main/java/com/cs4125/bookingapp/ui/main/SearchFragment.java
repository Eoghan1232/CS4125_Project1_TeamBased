package com.cs4125.bookingapp.ui.main;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;

import android.app.Activity;
import android.app.TimePickerDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;

import com.cs4125.bookingapp.R;

public class SearchFragment extends Fragment
{
    private SearchViewModel searchViewModel;
    private EditText location;
    private EditText destination;
    private Button time;
    private Button date;
    private Button searchBtn;
    private NavController navController;


    public static SearchFragment newInstance()
    {
        return new SearchFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.search_fragment, container, false);
        configureUiItems(view);
        searchViewModel = ViewModelProviders.of(this).get(SearchViewModel.class);
        searchViewModel.init();

        Button timePick = (Button) getView().findViewById(R.id.timePicker);
        timePick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    DialogFragment newFragment = new TimePickerFragment();
                    newFragment.show(getActivity().getSupportFragmentManager(), "timePicker");
            }
        });

        Button datePick = (Button) getView().findViewById(R.id.datePicker);
        datePick.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePicker = new TimePickerFragment();
                datePicker.show(getActivity().getSupportFragmentManager(), "date Picker");
            }
        }));

        return view;
    }


    private void configureUiItems(View view) {
        bindUiItems(view);
        Navigation.setViewNavController(view, new NavController(getContext()));
        navController = Navigation.findNavController(view);
        searchBtn.setOnClickListener(view1 -> search());
    }

        private void bindUiItems(View view){
        location = view.findViewById(R.id.regUsername);
        destination = view.findViewById(R.id.regEmail);
        time = view.findViewById(R.id.timePicker);
        date = view.findViewById(R.id.datePicker);
        searchBtn = view.findViewById(R.id.searchBtn);
    }

    private void search(){
        navController.navigate(R.id.action_searchFragment_to_searchResultFragment);
    }

}