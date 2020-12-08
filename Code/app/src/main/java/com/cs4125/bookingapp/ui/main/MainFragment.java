package com.cs4125.bookingapp.ui.main;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.cs4125.bookingapp.R;

public class MainFragment extends Fragment
{
    private MainViewModel mainViewModel;
    private NavController navController;
    private Button bookBtn;
    private Button searchBtn;
    private int userId;

    public static MainFragment newInstance()
    {
        return new MainFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment, container, false);
        configureUiItems(view);
        userId = MainFragmentArgs.fromBundle(getArguments()).getUserId();
        return view;
    }

    private void configureUiItems(View view) {
        bindUiItems(view);
        NavHostFragment navHostFragment = (NavHostFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        navController = navHostFragment.getNavController();
        searchBtn.setOnClickListener(view1 -> goToSearchScreen());
        bookBtn.setOnClickListener(view1 -> goToBookingScreen());
    }

    private void bindUiItems(View view){
        searchBtn = view.findViewById(R.id.toSearchBtn);
        bookBtn = view.findViewById(R.id.toBookingBtn);
    }

    private void goToSearchScreen(){
        MainFragmentDirections.ActionMainFragmentToSearchFragment action = MainFragmentDirections.actionMainFragmentToSearchFragment(userId);
        navController.navigate(action);
    }

    private void goToBookingScreen(){
        MainFragmentDirections.ActionMainFragmentToBookingFragment action = MainFragmentDirections.actionMainFragmentToBookingFragment(userId);
        navController.navigate(action);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
    }
}