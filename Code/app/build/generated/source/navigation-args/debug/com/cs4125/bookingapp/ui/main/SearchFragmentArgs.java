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

public class SearchFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private SearchFragmentArgs() {
  }

  private SearchFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static SearchFragmentArgs fromBundle(@NonNull Bundle bundle) {
    SearchFragmentArgs __result = new SearchFragmentArgs();
    bundle.setClassLoader(SearchFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("userId")) {
      int userId;
      userId = bundle.getInt("userId");
      __result.arguments.put("userId", userId);
    } else {
      throw new IllegalArgumentException("Required argument \"userId\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  public int getUserId() {
    return (int) arguments.get("userId");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
    Bundle __result = new Bundle();
    if (arguments.containsKey("userId")) {
      int userId = (int) arguments.get("userId");
      __result.putInt("userId", userId);
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
    SearchFragmentArgs that = (SearchFragmentArgs) object;
    if (arguments.containsKey("userId") != that.arguments.containsKey("userId")) {
      return false;
    }
    if (getUserId() != that.getUserId()) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + getUserId();
    return result;
  }

  @Override
  public String toString() {
    return "SearchFragmentArgs{"
        + "userId=" + getUserId()
        + "}";
  }

  public static class Builder {
    private final HashMap arguments = new HashMap();

    public Builder(SearchFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    public Builder(int userId) {
      this.arguments.put("userId", userId);
    }

    @NonNull
    public SearchFragmentArgs build() {
      SearchFragmentArgs result = new SearchFragmentArgs(arguments);
      return result;
    }

    @NonNull
    public Builder setUserId(int userId) {
      this.arguments.put("userId", userId);
      return this;
    }

    @SuppressWarnings("unchecked")
    public int getUserId() {
      return (int) arguments.get("userId");
    }
  }
}
