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
import android.widget.Toast;

import com.cs4125.bookingapp.MainActivity;
import com.cs4125.bookingapp.R;
import com.cs4125.bookingapp.entities.Booking;
import com.cs4125.bookingapp.entities.Discount;
import com.cs4125.bookingapp.repositories.BookingRepository;
import com.cs4125.bookingapp.repositories.BookingRepositoryImpl;
import com.cs4125.bookingapp.repositories.DiscountRepository;
import com.cs4125.bookingapp.repositories.DiscountRepositoryImpl;
import com.cs4125.bookingapp.repositories.ResultCallback;
import com.cs4125.bookingapp.web.RetrofitClientInstance;
import com.cs4125.bookingapp.web.SpringRetrofitService;

import org.w3c.dom.Text;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.Field;

public class MainFragment extends Fragment
{
    private MainViewModel mainViewModel;
    private NavController navController;
    private Button bookBtn;
    private Button searchBtn;

    private SpringRetrofitService web = RetrofitClientInstance.getRetrofitInstance().create(SpringRetrofitService.class);
    private EditText t1;
    private Button b1;

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
        return view;
    }

    private void configureUiItems(View view) {
        bindUiItems(view);
        Navigation.setViewNavController(view, new NavController(getContext()));
        navController = Navigation.findNavController(view);
        searchBtn.setOnClickListener(view1 -> goToSearchScreen());
        bookBtn.setOnClickListener(view1 -> goToBookingScreen());
    }

    private void bindUiItems(View view){
        searchBtn = view.findViewById(R.id.toSearchBtn)
        bookBtn = view.findViewById(R.id.toBookingBtn);
    }

    private void goToSearchScreen(){
        navController.navigate(R.id.action_mainFragment_to_searchFragment);
    }

    private void goToBookingScreen(){
        navController.navigate(R.id.action_mainFragment_to_bookingFragment);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        t1 = getView().findViewById(R.id.editTestText);

        t1.setText("Hello there");
        b1 = getView().findViewById(R.id.myTestButtonDamian);
        b1.setOnClickListener(v -> {
            BookingRepository bookingRepository = new BookingRepositoryImpl();
            Booking booking = new Booking.BookingBuilder().setPassengerID(1).setRouteID(1).setQuantity(1).build();
            bookingRepository.userBooking(booking, "hello", new ResultCallback()
            {
                @Override
                public void onResult(String result)
                {
                    Toast.makeText(getActivity(), result, Toast.LENGTH_LONG).show();
                    t1.setText(result);
                    System.out.println(result);
                }

                @Override
                public void onFailure(Throwable error)
                {
                    Toast.makeText(getActivity(), "Failed: " + error.toString(), Toast.LENGTH_LONG).show();
                    System.out.println(error.toString());
                }
            });
//                DiscountRepository discountRepository = new DiscountRepositoryImpl();
//                discountRepository.getAllDiscounts(new ResultCallback()
//                {
//                    @Override
//                    public void onResult(String result)
//                    {
//                        Toast.makeText(getActivity(), result, Toast.LENGTH_LONG).show();
//                        t1.setText(result);
//                        System.out.println(result);
//                    }
//
//                    @Override
//                    public void onFailure(Throwable error)
//                    {
//                        Toast.makeText(getActivity(), "Failed: " + error.toString(), Toast.LENGTH_LONG).show();
//                        System.out.println(error.toString());
//                    }
//                });
        });
    }
}