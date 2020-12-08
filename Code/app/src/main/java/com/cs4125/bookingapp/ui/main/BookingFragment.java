package com.cs4125.bookingapp.ui.main;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

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

import com.cs4125.bookingapp.R;

public class BookingFragment extends Fragment
{

    private BookingViewModel bookingViewModel;
    private EditText routeId;
    private EditText quantity;
    private EditText discount;
    private Button payBtn;
    private NavController navController;

    public static BookingFragment newInstance()
    {
        return new BookingFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.booking_fragment, container, false);
        configureUiItems(view);
        bookingViewModel = ViewModelProviders.of(this).get(BookingViewModel.class);
        bookingViewModel.init();
        return view;
    }

    private void configureUiItems(View view) {
        bindUiItems(view);
        Navigation.setViewNavController(view, new NavController(getContext()));
        navController = Navigation.findNavController(view);
        payBtn.setOnClickListener(view1 -> book());
    }

    private void bindUiItems(View view){
        routeId = view.findViewById(R.id.routeIdIn);
        quantity = view.findViewById(R.id.quantityIn);
        discount = view.findViewById(R.id.discountIn);
        payBtn = view.findViewById(R.id.bookingBookBtn);
    }

    private void book(){
        navController.navigate(R.id.);
    }

}