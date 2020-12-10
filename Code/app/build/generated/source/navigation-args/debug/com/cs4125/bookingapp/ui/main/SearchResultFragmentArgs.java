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

public class SearchResultFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private SearchResultFragmentArgs() {
  }

  private SearchResultFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static SearchResultFragmentArgs fromBundle(@NonNull Bundle bundle) {
    SearchResultFragmentArgs __result = new SearchResultFragmentArgs();
    bundle.setClassLoader(SearchResultFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("userId")) {
      int userId;
      userId = bundle.getInt("userId");
      __result.arguments.put("userId", userId);
    } else {
      throw new IllegalArgumentException("Required argument \"userId\" is missing and does not have an android:defaultValue");
    }
    if (bundle.containsKey("routesFound")) {
      String routesFound;
      routesFound = bundle.getString("routesFound");
      if (routesFound == null) {
        throw new IllegalArgumentException("Argument \"routesFound\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("routesFound", routesFound);
    } else {
      throw new IllegalArgumentException("Required argument \"routesFound\" is missing and does not have an android:defaultValue");
    }
    return __result;
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

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
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
  public boolean equals(Object object) {
    if (this == object) {
        return true;
    }
    if (object == null || getClass() != object.getClass()) {
        return false;
    }
    SearchResultFragmentArgs that = (SearchResultFragmentArgs) object;
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
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + getUserId();
    result = 31 * result + (getRoutesFound() != null ? getRoutesFound().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "SearchResultFragmentArgs{"
        + "userId=" + getUserId()
        + ", routesFound=" + getRoutesFound()
        + "}";
  }

  public static class Builder {
    private final HashMap arguments = new HashMap();

    public Builder(SearchResultFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    public Builder(int userId, @NonNull String routesFound) {
      this.arguments.put("userId", userId);
      if (routesFound == null) {
        throw new IllegalArgumentException("Argument \"routesFound\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("routesFound", routesFound);
    }

    @NonNull
    public SearchResultFragmentArgs build() {
      SearchResultFragmentArgs result = new SearchResultFragmentArgs(arguments);
      return result;
    }

    @NonNull
    public Builder setUserId(int userId) {
      this.arguments.put("userId", userId);
      return this;
    }

    @NonNull
    public Builder setRoutesFound(@NonNull String routesFound) {
      if (routesFound == null) {
        throw new IllegalArgumentException("Argument \"routesFound\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("routesFound", routesFound);
      return this;
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
  }
}
