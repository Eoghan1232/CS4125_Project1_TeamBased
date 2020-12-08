package com.cs4125.bookingapp.ui.main;

import androidx.fragment.app.FragmentActivity;
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
import com.cs4125.bookingapp.entities.User;

public class RegisterFragment extends Fragment
{

    private RegisterViewModel registerViewModel;
    private EditText username;
    private EditText email;
    private EditText confirmPassword;
    private EditText password;
    private Button regBtn;
    private NavController navController;

    public static RegisterFragment newInstance()
    {
        return new RegisterFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.register_fragment, container, false);
        configureUiItems(view);
        registerViewModel = ViewModelProviders.of(this).get(RegisterViewModel.class);
        registerViewModel.init();
        return view;
    }

    private void configureUiItems(View view) {
        bindUiItems(view);
        Navigation.setViewNavController(view, new NavController(getContext()));
        navController = Navigation.findNavController(view);
        regBtn.setOnClickListener(view1 -> register());
    }

    private void bindUiItems(View view){
        username = view.findViewById(R.id.regUsername);
        email = view.findViewById(R.id.regEmail);
        password = view.findViewById(R.id.regPassword1);
        confirmPassword = view.findViewById(R.id.regPassword2);
        regBtn = view.findViewById(R.id.regBtn);
    }

    private void register(){

        if( password.getText().toString().equals(confirmPassword.getText().toString())) {
            User regCred = new User.UserBuilder()
                    .setUsername(username.getText().toString())
                    .setPassword(password.getText().toString())
                    .build();

            registerViewModel.register(regCred);
            Utilities.showToast(getContext(), "Registered successfully. Return to the login screen");
        }
    }

}