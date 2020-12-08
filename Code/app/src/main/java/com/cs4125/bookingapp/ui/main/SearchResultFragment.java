package com.cs4125.bookingapp.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cs4125.bookingapp.R;
import com.cs4125.bookingapp.entities.Route;

import java.util.ArrayList;

public class SearchResultFragment extends Fragment
{
    private SearchViewModel searchViewModel;
    private NavController navController;
    private RecyclerView recyclerView;
    public ArrayList<Route> routeArrayList;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.search_result_fragment, container, false);
        configureUiItems(view);
        searchViewModel = ViewModelProviders.of(this).get(SearchViewModel.class);
        searchViewModel.init();
        return view;
    }

    private void configureUiItems(View view) {
        bindUiItems(view);
        Navigation.setViewNavController(view, new NavController(getContext()));
        navController = Navigation.findNavController(view);
        routeArrayList = new ArrayList<>();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        RouteAdapter adapter = new RouteAdapter(routeArrayList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
       //// recyclerView.setOnClickListener(view1 -> recycler());
    }

    private void bindUiItems(View view){
        recyclerView = view.findViewById(R.id.resultList);
    }

    private void recycler() {


    }

}
