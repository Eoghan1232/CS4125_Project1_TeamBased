package com.cs4125.bookingapp.ui.main;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.cs4125.bookingapp.R;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class LoginFragmentDirections {
  private LoginFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionLoginFragmentToRegisterFragment() {
    return new ActionOnlyNavDirections(R.id.action_loginFragment_to_registerFragment);
  }

  @NonNull
  public static ActionLoginFragmentToMainFragment actionLoginFragmentToMainFragment(int userId) {
    return new ActionLoginFragmentToMainFragment(userId);
  }

  public static class ActionLoginFragmentToMainFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ActionLoginFragmentToMainFragment(int userId) {
      this.arguments.put("userId", userId);
    }

    @NonNull
    public ActionLoginFragmentToMainFragment setUserId(int userId) {
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
      return R.id.action_loginFragment_to_mainFragment;
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
      ActionLoginFragmentToMainFragment that = (ActionLoginFragmentToMainFragment) object;
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
      return "ActionLoginFragmentToMainFragment(actionId=" + getActionId() + "){"
          + "userId=" + getUserId()
          + "}";
    }
  }
}
