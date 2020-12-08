package com.cs4125.bookingapp.ui.main;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cs4125.bookingapp.R;
import com.cs4125.bookingapp.entities.User;
import com.cs4125.bookingapp.repositories.UserRepository;

import okhttp3.ResponseBody;

public class LoginFragment extends Fragment
{
    private EditText usernameField;
    private EditText passwordField;
    private Button   loginBtn;
    private Button registerBtn;
    private NavController navController;
    private LoginViewModel loginViewModel;

//    public static LoginFragment newInstance()
//    {
//        return new LoginFragment();
//    }


    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login_fragment, container, false);
        configureUiItems(view);
        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
        loginViewModel.init();
        return view;
    }

//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState)
//    {
//        super.onActivityCreated(savedInstanceState);
//        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
//        // TODO: Use the ViewModel
//    }

    private void configureUiItems(View view) {
        bindUiItems(view);
        Navigation.setViewNavController(view, new NavController(getContext()));
        navController = Navigation.findNavController(view);
        loginBtn.setOnClickListener(view1 -> loginUser());
        registerBtn.setOnClickListener(view1 -> goToRegisterScreen());
    }

    private void bindUiItems(View view){
        usernameField = view.findViewById(R.id.usernameIn);
        passwordField = view.findViewById(R.id.passwordIn);
        loginBtn = view.findViewById(R.id.loginBtn);
        registerBtn = view.findViewById(R.id.registerBtn);
    }

    private void goToRegisterScreen(){
        navController.navigate(R.id.action_loginFragment_to_registerFragment);
    }

    private void loginUser(){
        User loginCred = new User
                .UserBuilder()
                .setUsername(usernameField.getText().toString())
                .setPassword(passwordField.getText().toString())
                .build();

        String response = loginViewModel.login(loginCred);
        String [] temp = response.split(":");
        if(temp[0].equals("SUCCESS") ) {
            Utilities.showToast(this.getContext(), "Login Successful");

            navController.navigate(R.id.action_loginFragment_to_mainFragment);
        } else {
            Utilities.showToast(this.getContext(), "Login Failed");
        }

    }
}