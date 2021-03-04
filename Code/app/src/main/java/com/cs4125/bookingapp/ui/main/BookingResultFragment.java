package com.cs4125.bookingapp.ui.main;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.cs4125.bookingapp.R;
import com.cs4125.bookingapp.entities.Booking;
import com.cs4125.bookingapp.entities.Route;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;

public class BookingResultFragment extends Fragment {

    public static BookingResultFragment newInstance() {
        return new BookingResultFragment();
    }

    private BookingViewModel bookingViewModel;
    private TextView idText;
    private TextView routeIdText;
    private TextView dateTimeText;
    private TextView quantityText;
    private TextView priceText;
    private Button payBtn;
    private NavController navController;
    private int userId;
    private Booking currentBooking;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.booking_result_fragment, container, false);
        configureUiItems(view);
//        bookingViewModel = ViewModelProviders.of(this).get(BookingViewModel.class);
        bookingViewModel = new ViewModelProvider(this).get(BookingViewModel.class);
        bookingViewModel.init();
        userId = BookingResultFragmentArgs.fromBundle(getArguments()).getUserId();

        return view;
    }

    private void configureUiItems(View view) {
        bindUiItems(view);
        NavHostFragment navHostFragment = (NavHostFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        navController = navHostFragment.getNavController();
        convertStringToBookingInfo(BookingResultFragmentArgs.fromBundle(getArguments()).getBookingInfo());
        payBtn.setOnClickListener(view1 -> pay());
    }

    private void bindUiItems(View view){
        idText = view.findViewById(R.id.bookingResultTitle);
        routeIdText = view.findViewById(R.id.bookingRouteIdText);
        dateTimeText = view.findViewById(R.id.bookingDateTimeText);
        quantityText = view.findViewById(R.id.quantityText);
        priceText = view.findViewById(R.id.priceText);
        payBtn = view.findViewById(R.id.payBtn);
    }

    private void pay(){
        if (currentBooking == null)
            Utilities.showToast(getContext(), "Something went wrong, please retry later.");
        else
        {
            LiveData<String> response = bookingViewModel.payForBooking(currentBooking);
            response.observe(getViewLifecycleOwner(), this::observeResponse);
        }
    }

    private void observeResponse(String s)
    {
        String[] temp = s.split(": ");
        if (temp[0].equals("SUCCESS"))
        {
            Utilities.showToast(getContext(), "Transaction successful.");
            BookingResultFragmentDirections.ActionBookingResultFragmentToMainFragment action = BookingResultFragmentDirections.actionBookingResultFragmentToMainFragment(userId);
            navController.navigate(action);
        }
        else
        {
            Utilities.showToast(this.getContext(), "Payment Failed, try again later.");
        }
    }

    private void convertStringToBookingInfo(String bookingInfo)
    {
        String[] firstSplit = bookingInfo.split("Booking\\{");
        String[] secondSplit = firstSplit[1].split(", ");
        String[] dataParts = new String[8];
        for(int j = 0; j < secondSplit.length - 1; ++j)
        {
            String[] thirdSplit = secondSplit[j].split("=");
            dataParts[j] = thirdSplit[1];
        }
        currentBooking = new Booking.BookingBuilder()
                .setBookingID(Integer.parseInt(dataParts[0]))
                .setRouteID(Integer.parseInt(dataParts[1]))
                .setPassengerID(userId)
                .setDateTime(Timestamp.valueOf(dataParts[4]))
                .setQuantity(Integer.parseInt(dataParts[3]))
                .setPrice(Float.parseFloat(dataParts[5]))
                .build();

        idText.setText(idText.getText().toString() + Integer.toString(currentBooking.getBookingID()));
        routeIdText.setText(routeIdText.getText().toString() + Integer.toString(currentBooking.getRouteID()));
        dateTimeText.setText(dateTimeText.getText().toString() + currentBooking.getDateTime().toString());
        quantityText.setText(quantityText.getText().toString() + Integer.toString(currentBooking.getQuantity()));
        priceText.setText(priceText.getText().toString() + Float.toString(currentBooking.getPrice()));
    }
}