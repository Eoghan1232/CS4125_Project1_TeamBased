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

public class SearchFragmentDirections {
  private SearchFragmentDirections() {
  }

  @NonNull
  public static ActionSearchFragmentToSearchResultFragment actionSearchFragmentToSearchResultFragment(
      int userId, @NonNull String routesFound) {
    return new ActionSearchFragmentToSearchResultFragment(userId, routesFound);
  }

  public static class ActionSearchFragmentToSearchResultFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ActionSearchFragmentToSearchResultFragment(int userId, @NonNull String routesFound) {
      this.arguments.put("userId", userId);
      if (routesFound == null) {
        throw new IllegalArgumentException("Argument \"routesFound\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("routesFound", routesFound);
    }

    @NonNull
    public ActionSearchFragmentToSearchResultFragment setUserId(int userId) {
      this.arguments.put("userId", userId);
      return this;
    }

    @NonNull
    public ActionSearchFragmentToSearchResultFragment setRoutesFound(@NonNull String routesFound) {
      if (routesFound == null) {
        throw new IllegalArgumentException("Argument \"routesFound\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("routesFound", routesFound);
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
      if (arguments.containsKey("routesFound")) {
        String routesFound = (String) arguments.get("routesFound");
        __result.putString("routesFound", routesFound);
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_searchFragment_to_searchResultFragment;
    }

    @SuppressWarnings("unchecked")
    public int getUserId() {
      return (int) arguments.get("userId");
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getRoutesFound() {
      return (String) arguments.get("routesFound");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionSearchFragmentToSearchResultFragment that = (ActionSearchFragmentToSearchResultFragment) object;
      if (arguments.containsKey("userId") != that.arguments.containsKey("userId")) {
        return false;
      }
      if (getUserId() != that.getUserId()) {
        return false;
      }
      if (arguments.containsKey("routesFound") != that.arguments.containsKey("routesFound")) {
        return false;
      }
      if (getRoutesFound() != null ? !getRoutesFound().equals(that.getRoutesFound()) : that.getRoutesFound() != null) {
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
      result = 31 * result + (getRoutesFound() != null ? getRoutesFound().hashCode() : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionSearchFragmentToSearchResultFragment(actionId=" + getActionId() + "){"
          + "userId=" + getUserId()
          + ", routesFound=" + getRoutesFound()
          + "}";
    }
  }
}
