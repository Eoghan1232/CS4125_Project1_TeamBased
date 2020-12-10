package com.cs4125.bookingapp.ui.main;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import com.cs4125.bookingapp.R;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class BookingFragmentDirections {
  private BookingFragmentDirections() {
  }

  @NonNull
  public static ActionBookingFragmentToBookingResultFragment actionBookingFragmentToBookingResultFragment(
      int userId, @NonNull String bookingInfo) {
    return new ActionBookingFragmentToBookingResultFragment(userId, bookingInfo);
  }

  public static class ActionBookingFragmentToBookingResultFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ActionBookingFragmentToBookingResultFragment(int userId, @NonNull String bookingInfo) {
      this.arguments.put("userId", userId);
      if (bookingInfo == null) {
        throw new IllegalArgumentException("Argument \"bookingInfo\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("bookingInfo", bookingInfo);
    }

    @NonNull
    public ActionBookingFragmentToBookingResultFragment setUserId(int userId) {
      this.arguments.put("userId", userId);
      return this;
    }

    @NonNull
    public ActionBookingFragmentToBookingResultFragment setBookingInfo(
        @NonNull String bookingInfo) {
      if (bookingInfo == null) {
        throw new IllegalArgumentException("Argument \"bookingInfo\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("bookingInfo", bookingInfo);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
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
    public int getActionId() {
      return R.id.action_bookingFragment_to_bookingResultFragment;
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

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionBookingFragmentToBookingResultFragment that = (ActionBookingFragmentToBookingResultFragment) object;
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
      if (getActionId() != that.getActionId()) {
        return false;
      }
      return true;
    }

    @Override
    public int hashCode() {
      int result = 1;
      result = 31 * result + getUserId();
      result = 31 * result + (getBookingInfo() != null ? getBookingInfo().hashCode() : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionBookingFragmentToBookingResultFragment(actionId=" + getActionId() + "){"
          + "userId=" + getUserId()
          + ", bookingInfo=" + getBookingInfo()
          + "}";
    }
  }
}
