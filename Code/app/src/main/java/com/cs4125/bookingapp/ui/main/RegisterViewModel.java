package com.cs4125.bookingapp.ui.main;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

import com.cs4125.bookingapp.entities.User;
import com.cs4125.bookingapp.repositories.BookingRepositoryImpl;
import com.cs4125.bookingapp.repositories.ResultCallback;
import com.cs4125.bookingapp.repositories.RouteRepositoryCacheProxy;
import com.cs4125.bookingapp.repositories.UserRepository;
import com.cs4125.bookingapp.repositories.UserRepositoryImpl;

import okhttp3.ResponseBody;

public class RegisterViewModel extends ViewModel
{
    private UserRepository repository;
    private SavedStateHandle state;

    public RegisterViewModel(SavedStateHandle savedStateHandle)
    {
        state = savedStateHandle;
    }

    public void init() {
        if(state.contains("user_repository"))
        {
            this.repository = state.get("user_repository");
        }
        else
        {
            this.repository = new UserRepositoryImpl();
            state.set("user_repository", this.repository);
        }
    }

    public LiveData<String> register(User userRegister){
        MutableLiveData<String> liveString = new MutableLiveData<>();
        repository.registerUser(userRegister, new ResultCallback()
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
