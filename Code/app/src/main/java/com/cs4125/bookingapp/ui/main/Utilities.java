package com.cs4125.bookingapp.ui.main;

import android.content.Context;
import android.widget.Toast;

public class Utilities {

    public static void showToast (Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
