package com.cs4125.bookingapp.ui.main;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

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
        NavHostFragment navHostFragment = (NavHostFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        navController = navHostFragment.getNavController();
        regBtn.setOnClickListener(view1 -> register());
    }

    private void bindUiItems(View view){
        username = view.findViewById(R.id.regUsername);
        email = view.findViewById(R.id.regEmail);
        password = view.findViewById(R.id.regPassword1);
        confirmPassword = view.findViewById(R.id.regPassword2);
        regBtn = view.findViewById(R.id.regBtn);
    }

    private void register() {

        if (username.getText().length() != 0 && password.getText().length() != 0 && confirmPassword.getText().length() != 0 && email.getText().length() != 0)
        {
            if (password.getText().toString().equals(confirmPassword.getText().toString()))
            {
                User regCred = new User.UserBuilder()
                        .setUsername(username.getText().toString())
                        .setPassword(password.getText().toString())
                        .setEmail(email.getText().toString())
                        .build();

                LiveData<String> response = registerViewModel.register(regCred);
                response.observe(getViewLifecycleOwner(), this::observeResponse);
            }
        }
        else
        {
            Utilities.showToast(this.getContext(), "Error: Missing Information");
        }
    }

    private void observeResponse(String s)
    {
        String[] temp = s.split(":");
        if (temp[0].equals("SUCCESS"))
        {
            Utilities.showToast(this.getContext(), "Registration Successful");

            navController.navigate(R.id.action_registerFragment_to_loginFragment);
        }
        else
        {
            Utilities.showToast(this.getContext(), "Registration Failed");
        }
    }
}