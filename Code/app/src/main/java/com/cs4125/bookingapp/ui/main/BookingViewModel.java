package com.cs4125.bookingapp.ui.main;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

import com.cs4125.bookingapp.entities.Booking;
import com.cs4125.bookingapp.entities.Route;
import com.cs4125.bookingapp.repositories.BookingRepository;
import com.cs4125.bookingapp.repositories.BookingRepositoryCacheProxy;
import com.cs4125.bookingapp.repositories.BookingRepositoryImpl;
import com.cs4125.bookingapp.repositories.ResultCallback;
import com.cs4125.bookingapp.repositories.UserRepositoryImpl;

import okhttp3.ResponseBody;

public class BookingViewModel extends ViewModel
{
    private BookingRepository repository;
    private SavedStateHandle state;

    public BookingViewModel(SavedStateHandle savedStateHandle)
    {
        state = savedStateHandle;
    }

    public void init() {
        if(state.contains("booking_repository"))
        {
            this.repository = state.get("booking_repository");
        }
        else
        {
            this.repository = new BookingRepositoryCacheProxy();
            state.set("booking_repository", this.repository);
        }
    }

    public LiveData<String> bookTicket(Route route, Booking booking, String code){
        MutableLiveData<String> liveString = new MutableLiveData<>();
        repository.userBooking(route, booking, code, new ResultCallback()
        {
            @Override
            public void onResult(String result)
            {
                liveString.postValue(result);
            }

            @Override
            public void onFailure(Throwable error)
            {
                liveString.postValue(error.toString());
            }
        });

        return liveString;
    }
    //start booking, update booking
    public LiveData<String> payForBooking(Booking booking){
        MutableLiveData<String> liveString = new MutableLiveData<>();
        repository.bookingUpdate(booking, new ResultCallback()
        {
            @Override
            public void onResult(String result)
            {
                liveString.postValue(result);
            }

            @Override
            public void onFailure(Throwable error)
            {
                liveString.postValue(error.toString());
            }
        });

        return liveString;
    }

    public LiveData<String> cancelBooking(Booking booking){
        MutableLiveData<String> liveString = new MutableLiveData<>();
        repository.bookingCancel(booking, new ResultCallback()
        {
            @Override
            public void onResult(String result)
            {
                liveString.postValue(result);
            }

            @Override
            public void onFailure(Throwable error)
            {
                liveString.postValue(error.toString());
            }
        });

        return liveString;
    }

    public LiveData<String> allBooking(Booking booking){
        MutableLiveData<String> liveString = new MutableLiveData<>();
        repository.bookingList(booking, new ResultCallback()
        {
            @Override
            public void onResult(String result)
            {
                liveString.postValue(result);
            }

            @Override
            public void onFailure(Throwable error)
            {
                liveString.postValue(error.toString());
            }
        });

        return liveString;
    }
}
