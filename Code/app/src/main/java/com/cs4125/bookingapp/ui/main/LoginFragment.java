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
import androidx.navigation.fragment.NavHostFragment;

import android.text.method.PasswordTransformationMethod;
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

    private void configureUiItems(View view) {
        bindUiItems(view);
        NavHostFragment navHostFragment = (NavHostFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        navController = navHostFragment.getNavController();
        loginBtn.setOnClickListener(view1 -> loginUser());
        registerBtn.setOnClickListener(view1 -> goToRegisterScreen());
    }

    private void bindUiItems(View view){
        usernameField = view.findViewById(R.id.usernameIn);
        passwordField = view.findViewById(R.id.passwordIn);
        passwordField.setTransformationMethod(new PasswordTransformationMethod());
        loginBtn = view.findViewById(R.id.loginBtn);
        registerBtn = view.findViewById(R.id.registerBtn);
    }

    private void goToRegisterScreen(){
        navController.navigate(R.id.action_loginFragment_to_registerFragment);
    }

    private void loginUser(){
        if (usernameField.getText().length() != 0 && passwordField.getText().length() != 0)
        {
            User loginCred = new User.UserBuilder().setUsername(usernameField.getText().toString()).setPassword(passwordField.getText().toString()).build();

            LiveData<String> response = loginViewModel.login(loginCred);
            response.observe(getViewLifecycleOwner(), this::observeResponse);
        }
        else
        {
            Utilities.showToast(this.getContext(), "Error: Missing Information");
        }
    }

    private void observeResponse(String s)
    {
        String[] temp = s.split(": ");
        if (temp[0].equals("SUCCESS"))
        {
            Utilities.showToast(this.getContext(), "Login Successful");
            LoginFragmentDirections.ActionLoginFragmentToMainFragment action = LoginFragmentDirections.actionLoginFragmentToMainFragment(Integer.parseInt(temp[1]));
            navController.navigate(action);
        } else
        {
            Utilities.showToast(this.getContext(), "Login Failed");
        }
    }
}