package com.cs4125.bookingapp.ui.main;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import com.cs4125.bookingapp.R;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class MainFragmentDirections {
  private MainFragmentDirections() {
  }

  @NonNull
  public static ActionMainFragmentToBookingFragment actionMainFragmentToBookingFragment(
      int userId) {
    return new ActionMainFragmentToBookingFragment(userId);
  }

  @NonNull
  public static ActionMainFragmentToSearchFragment actionMainFragmentToSearchFragment(int userId) {
    return new ActionMainFragmentToSearchFragment(userId);
  }

  public static class ActionMainFragmentToBookingFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ActionMainFragmentToBookingFragment(int userId) {
      this.arguments.put("userId", userId);
    }

    @NonNull
    public ActionMainFragmentToBookingFragment setUserId(int userId) {
      this.arguments.put("userId", userId);
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
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_mainFragment_to_bookingFragment;
    }

    @SuppressWarnings("unchecked")
    public int getUserId() {
      return (int) arguments.get("userId");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionMainFragmentToBookingFragment that = (ActionMainFragmentToBookingFragment) object;
      if (arguments.containsKey("userId") != that.arguments.containsKey("userId")) {
        return false;
      }
      if (getUserId() != that.getUserId()) {
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
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionMainFragmentToBookingFragment(actionId=" + getActionId() + "){"
          + "userId=" + getUserId()
          + "}";
    }
  }

  public static class ActionMainFragmentToSearchFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ActionMainFragmentToSearchFragment(int userId) {
      this.arguments.put("userId", userId);
    }

    @NonNull
    public ActionMainFragmentToSearchFragment setUserId(int userId) {
      this.arguments.put("userId", userId);
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
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_mainFragment_to_searchFragment;
    }

    @SuppressWarnings("unchecked")
    public int getUserId() {
      return (int) arguments.get("userId");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionMainFragmentToSearchFragment that = (ActionMainFragmentToSearchFragment) object;
      if (arguments.containsKey("userId") != that.arguments.containsKey("userId")) {
        return false;
      }
      if (getUserId() != that.getUserId()) {
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
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionMainFragmentToSearchFragment(actionId=" + getActionId() + "){"
          + "userId=" + getUserId()
          + "}";
    }
  }
}
