package com.cs4125.bookingapp.ui.main;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
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
import com.cs4125.bookingapp.entities.Booking;
import com.cs4125.bookingapp.entities.Route;

public class BookingFragment extends Fragment
{
    private BookingViewModel bookingViewModel;
    private EditText routeId;
    private EditText quantity;
    private EditText discount;
    private Button payBtn;
    private NavController navController;
    private int userId;

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
//        bookingViewModel = ViewModelProviders.of(this).get(BookingViewModel.class);
        bookingViewModel = new ViewModelProvider(this).get(BookingViewModel.class);
        bookingViewModel.init();
        userId = BookingFragmentArgs.fromBundle(getArguments()).getUserId();

        return view;
    }

    private void configureUiItems(View view) {
        bindUiItems(view);
        NavHostFragment navHostFragment = (NavHostFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        navController = navHostFragment.getNavController();
        payBtn.setOnClickListener(view1 -> book());
    }

    private void bindUiItems(View view){
        routeId = view.findViewById(R.id.routeIdIn);
        quantity = view.findViewById(R.id.quantityIn);
        discount = view.findViewById(R.id.discountIn);
        payBtn = view.findViewById(R.id.bookingBookBtn);
    }

    private void book(){
        if(routeId.getText().length() != 0 && quantity.getText().length() != 0)
        {
            String fdiscount = "";
            if(discount.getText().length() != 0)
                fdiscount = discount.getText().toString();

            try
            {
                int fquantity = Integer.parseInt(quantity.getText().toString());
                if (fquantity < 0)
                    Utilities.showToast(getContext(), "Quantity cannot be a negative number!");
                else
                {
                    Booking newBooking = new Booking.BookingBuilder().setRouteID(Integer.parseInt(routeId.getText().toString())).setPassengerID(userId).setQuantity(fquantity).build();
                    LiveData<String> response = bookingViewModel.bookTicket(newBooking, fdiscount);
                    response.observe(getViewLifecycleOwner(), this::observeResponse);
                }
            }
            catch (NumberFormatException e)
            {
                Utilities.showToast(getContext(), "Invalid Input");
            }
        }
        else
        {
            Utilities.showToast(getContext(), "Missing Information");
        }
    }

    private void observeResponse(String s)
    {
        String[] temp = s.split(": ");
        if (temp[0].equals("SUCCESS"))
        {
            String bookingInfo = temp[1];

            BookingFragmentDirections.ActionBookingFragmentToBookingResultFragment action = BookingFragmentDirections.actionBookingFragmentToBookingResultFragment(userId, bookingInfo);
            navController.navigate(action);
        }
        else
        {
            Utilities.showToast(this.getContext(), "Booking Failed");
        }
    }
}