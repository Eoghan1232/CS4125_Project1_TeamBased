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
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cs4125.bookingapp.R;
import com.cs4125.bookingapp.entities.Route;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class SearchResultFragment extends Fragment
{
    private SearchViewModel searchViewModel;
    private NavController navController;
    private RecyclerView recyclerView;
    public ArrayList<Route> routeArrayList;
    private int userId;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.search_result_fragment, container, false);
        configureUiItems(view);
        searchViewModel = ViewModelProviders.of(this).get(SearchViewModel.class);
        searchViewModel.init();
        userId = SearchResultFragmentArgs.fromBundle(getArguments()).getUserId();

        return view;
    }

    private void configureUiItems(View view) {
        bindUiItems(view);
        NavHostFragment navHostFragment = (NavHostFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        navController = navHostFragment.getNavController();

        routeArrayList = new ArrayList<>();
        routeArrayList.addAll(convertStringToRoutes(SearchResultFragmentArgs.fromBundle(getArguments()).getRoutesFound()));

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        RouteAdapter adapter = new RouteAdapter(routeArrayList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
       //// recyclerView.setOnClickListener(view1 -> recycler());
    }

    private void bindUiItems(View view){
        recyclerView = view.findViewById(R.id.resultList);
    }

    private List<Route> convertStringToRoutes(String s)
    {
        ArrayList<Route> routes = new ArrayList<>();
        String[] firstSplit = s.split("Route\\{");
        String[] dataParts = new String[5];
        for(int i = 1; i < firstSplit.length; ++i)
        {
            firstSplit[i] = firstSplit[i].substring(0, (firstSplit[i].length() - 1));
            String[] secondSplit = firstSplit[i].split(", ");
            for(int j = 0; j < secondSplit.length; ++j)
            {
                String[] thirdSplit = secondSplit[j].split("=");
                dataParts[j] = thirdSplit[1];
            }
            Route route = new Route.RouteBuilder()
                    .setRouteID(Integer.parseInt(dataParts[0]))
                    .setStartStation(dataParts[1])
                    .setEndStation(dataParts[2])
                    .setPrice(Float.parseFloat(dataParts[4]))
                    .setDateTime(Timestamp.valueOf(dataParts[3]))
                    .build();
            routes.add(route);
        }
        return routes;
    }
}
