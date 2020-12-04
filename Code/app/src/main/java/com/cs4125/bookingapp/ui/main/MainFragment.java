package com.cs4125.bookingapp.ui.main;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cs4125.bookingapp.MainActivity;
import com.cs4125.bookingapp.R;
import com.cs4125.bookingapp.web.RetrofitClientInstance;
import com.cs4125.bookingapp.web.SpringRetrofitService;

import org.w3c.dom.Text;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainFragment extends Fragment
{
    private MainViewModel mViewModel;

    private SpringRetrofitService web = RetrofitClientInstance.getRetrofitInstance().create(SpringRetrofitService.class);
    private EditText t1;
    private Button b1;

    public static MainFragment newInstance()
    {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.main_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        t1 = getView().findViewById(R.id.editTestText);

        t1.setText("Hello there");
        b1 = getView().findViewById(R.id.myTestButtonDamian);
        b1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Call<ResponseBody> returnVal = web.getAllDiscounts();

                returnVal.enqueue(new Callback<ResponseBody>()
                {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response)
                    {
                        System.out.println("RESPONSE!");
                        String s = null;  // <- response is null here
                        try
                        {
                            s = response.body().string();
                        } catch (IOException e)
                        {
                            e.printStackTrace();
                        }
                        System.out.println("BODY!\t" + s);
                        // Log.d(LOG_TAG, "Couldn't not reach this place");
                        t1.setText(s);
                        Toast.makeText(getActivity(), "Success!", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t)
                    {
                        System.out.println("FAILED!!   " + t.toString());
                        Toast.makeText(getActivity(), "Failed !", Toast.LENGTH_LONG).show();
                    }
                });

                System.out.println(returnVal);
                //Toast.makeText(getActivity(), returnVal, Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        // TODO: Use the ViewModel
    }
}