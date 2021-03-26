package com.cs4125.bookingapp.ui.main;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
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
import com.stripe.android.PaymentConfiguration;
import com.stripe.android.Stripe;
import com.stripe.android.model.ConfirmPaymentIntentParams;
import com.stripe.android.model.PaymentIntent;
import com.stripe.android.model.PaymentMethodCreateParams;
import com.stripe.android.view.CardInputWidget;

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
    private CardInputWidget cardInputWidget;

    private String paymentIntentClientSecret;
    private Stripe stripe;
    private String publicKey = "pk_test_51IX7WzA4GQu91tA9ygW9sAl0Q42Y0pQYRySwRCSfylSVx9EiL3n691M0ayb6n45E9B7dx8DjfKn1iAwQSrfE24Dn00TDsAbjXU";
    private String privateKey = "sk_test_51IX7WzA4GQu91tA9L6s5Nssb1MC2sVodWphIYYApH0ZwzsokQFlLFm44LeDfVvuHlmfdbs8rUpxgxCzMgc98d5ky00v1YjwyaH";

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

        PaymentConfiguration.init(
                getContext(),
                "pk_test_51IX7WzA4GQu91tA9ygW9sAl0Q42Y0pQYRySwRCSfylSVx9EiL3n691M0ayb6n45E9B7dx8DjfKn1iAwQSrfE24Dn00TDsAbjXU"
        );

        startPaymentProcess();

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
        cardInputWidget = view.findViewById(R.id.cardInputWidget);
    }

    private void startPaymentProcess()
    {
        LiveData<String> response = bookingViewModel.getPaymentIntent(currentBooking.getPrice());
        response.observe(getViewLifecycleOwner(), this::observePaymentIntentResponse);
    }

    private void observePaymentIntentResponse(String s)
    {
        String[] temp = s.split(": ");
        if(temp[0].equals("SUCCESS"))
        {
            String[] secondSplit = temp[1].split(",");
            publicKey = secondSplit[0].split("=")[1];
            paymentIntentClientSecret = secondSplit[1].split("=")[1];
        }
        else
        {
            Utilities.showToast(this.getContext(), "Payment Failed, try again later.");
        }
    }

    private void pay(){
        if (currentBooking == null)
            Utilities.showToast(getContext(), "Something went wrong, please retry later.");
        else
        {
            PaymentMethodCreateParams params = cardInputWidget.getPaymentMethodCreateParams();
            if (params != null)
            {
                try
                {
                    ConfirmPaymentIntentParams confirmParams = ConfirmPaymentIntentParams.createWithPaymentMethodCreateParams(params, paymentIntentClientSecret);
                    stripe = new Stripe(
                            getContext(),
                            publicKey
                    );
                    stripe.confirmPayment(this, confirmParams);
                    //LiveData<String> response = bookingViewModel.payForBooking(currentBooking);
                    //response.observe(getViewLifecycleOwner(), this::observeResponse);
                }
                catch(Exception e)
                {
                    System.out.println(e.toString());
                    Utilities.showToast(getContext(), "Missing Card Details!");
                }
            }
            else
            {
                Utilities.showToast(getContext(), "Missing Card Details!");
            }
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        // Assuming payment got confirmed successfully
        observeResponse("SUCCESS: 1");
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
        System.out.println(bookingInfo);
        String[] firstSplit = bookingInfo.split("Booking\\{");
        firstSplit[1] = firstSplit[1].substring(0, (firstSplit[1].length() - 1));
        String[] secondSplit = firstSplit[1].split(", ");
        String[] dataParts = new String[8];
        for(int j = 0; j < secondSplit.length; ++j)
        {
            String[] thirdSplit = secondSplit[j].split("=");
            dataParts[j] = thirdSplit[1];
        }
        try
        {
            currentBooking = new Booking.BookingBuilder()
                    .setBookingID(Integer.parseInt(dataParts[0]))
                    .setRouteID(Integer.parseInt(dataParts[1]))
                    .setPassengerID(userId).setDateTime(Timestamp.valueOf(dataParts[4]))
                    .setQuantity(Integer.parseInt(dataParts[3]))
                    .setPrice(Float.parseFloat(dataParts[5]))
                    .build();

            idText.setText(idText.getText().toString() + Integer.toString(currentBooking.getBookingID()));
            routeIdText.setText(routeIdText.getText().toString() + Integer.toString(currentBooking.getRouteID()));
            dateTimeText.setText(dateTimeText.getText().toString() + currentBooking.getDateTime().toString());
            quantityText.setText(quantityText.getText().toString() + Integer.toString(currentBooking.getQuantity()));
            priceText.setText(priceText.getText().toString() + Float.toString(currentBooking.getPrice()));
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
        }
    }
}