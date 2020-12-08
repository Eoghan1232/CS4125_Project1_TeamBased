package com.cs4125.bookingapp.ui.main;

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

public class BookingResultFragment extends Fragment {



    public static BookingResultFragment newInstance() {
        return new BookingResultFragment();
    }

    private BookingViewModel bookingViewModel;
    private EditText username;
    private EditText email;
    private EditText confirmPassword;
    private EditText password;
    private Button payBtn;
    private NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.booking_result_fragment, container, false);
        configureUiItems(view);
        bookingViewModel = ViewModelProviders.of(this).get(BookingViewModel.class);
        bookingViewModel.init();
        return view;
    }

    private void configureUiItems(View view) {
        bindUiItems(view);
        Navigation.setViewNavController(view, new NavController(getContext()));
        navController = Navigation.findNavController(view);
        payBtn.setOnClickListener(view1 -> pay());
    }

    private void bindUiItems(View view){
        username = view.findViewById(R.id.regUsername);
        email = view.findViewById(R.id.regEmail);
        password = view.findViewById(R.id.regPassword1);
        confirmPassword = view.findViewById(R.id.regPassword2);
        payBtn = view.findViewById(R.id.payBtn);
    }

    private void pay(){
        Utilities.showToast(getContext(), "Transaction successful. Click continue");
        //navController.navigate(R.id.action_loginFragment_to_registerFragment);
    }

}