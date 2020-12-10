package com.cs4125.bookingapp.ui.main;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.navigation.NavArgs;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class BookingResultFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private BookingResultFragmentArgs() {
  }

  private BookingResultFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static BookingResultFragmentArgs fromBundle(@NonNull Bundle bundle) {
    BookingResultFragmentArgs __result = new BookingResultFragmentArgs();
    bundle.setClassLoader(BookingResultFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("userId")) {
      int userId;
      userId = bundle.getInt("userId");
      __result.arguments.put("userId", userId);
    } else {
      throw new IllegalArgumentException("Required argument \"userId\" is missing and does not have an android:defaultValue");
    }
    if (bundle.containsKey("bookingInfo")) {
      String bookingInfo;
      bookingInfo = bundle.getString("bookingInfo");
      if (bookingInfo == null) {
        throw new IllegalArgumentException("Argument \"bookingInfo\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("bookingInfo", bookingInfo);
    } else {
      throw new IllegalArgumentException("Required argument \"bookingInfo\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  public int getUserId() {
    return (int) arguments.get("userId");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public String getBookingInfo() {
    return (String) arguments.get("bookingInfo");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
    Bundle __result = new Bundle();
    if (arguments.containsKey("userId")) {
      int userId = (int) arguments.get("userId");
      __result.putInt("userId", userId);
    }
    if (arguments.containsKey("bookingInfo")) {
      String bookingInfo = (String) arguments.get("bookingInfo");
      __result.putString("bookingInfo", bookingInfo);
    }
    return __result;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
        return true;
    }
    if (object == null || getClass() != object.getClass()) {
        return false;
    }
    BookingResultFragmentArgs that = (BookingResultFragmentArgs) object;
    if (arguments.containsKey("userId") != that.arguments.containsKey("userId")) {
      return false;
    }
    if (getUserId() != that.getUserId()) {
      return false;
    }
    if (arguments.containsKey("bookingInfo") != that.arguments.containsKey("bookingInfo")) {
      return false;
    }
    if (getBookingInfo() != null ? !getBookingInfo().equals(that.getBookingInfo()) : that.getBookingInfo() != null) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + getUserId();
    result = 31 * result + (getBookingInfo() != null ? getBookingInfo().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "BookingResultFragmentArgs{"
        + "userId=" + getUserId()
        + ", bookingInfo=" + getBookingInfo()
        + "}";
  }

  public static class Builder {
    private final HashMap arguments = new HashMap();

    public Builder(BookingResultFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    public Builder(int userId, @NonNull String bookingInfo) {
      this.arguments.put("userId", userId);
      if (bookingInfo == null) {
        throw new IllegalArgumentException("Argument \"bookingInfo\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("bookingInfo", bookingInfo);
    }

    @NonNull
    public BookingResultFragmentArgs build() {
      BookingResultFragmentArgs result = new BookingResultFragmentArgs(arguments);
      return result;
    }

    @NonNull
    public Builder setUserId(int userId) {
      this.arguments.put("userId", userId);
      return this;
    }

    @NonNull
    public Builder setBookingInfo(@NonNull String bookingInfo) {
      if (bookingInfo == null) {
        throw new IllegalArgumentException("Argument \"bookingInfo\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("bookingInfo", bookingInfo);
      return this;
    }

    @SuppressWarnings("unchecked")
    public int getUserId() {
      return (int) arguments.get("userId");
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getBookingInfo() {
      return (String) arguments.get("bookingInfo");
    }
  }
}
