package com.cs4125.bookingapp.ui.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.cs4125.bookingapp.R;
import com.cs4125.bookingapp.entities.Route;

import java.util.List;

public class RouteAdapter extends RecyclerView.Adapter<RouteAdapter.RouteViewHolder> {

    public class RouteViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private final Context context;
        private TextView tvTitle;
        private TextView tvDescription;
        private Route route;

        public RouteViewHolder (View itemView)
        {
            super(itemView);
            context = itemView.getContext();
            itemView.setOnClickListener(this);
            tvTitle = (TextView) itemView.findViewById(R.id.routeIdText);
            tvDescription = (TextView) itemView.findViewById(R.id.routeDescriptionText);
        }

        public void setItem(Route item)
        {
            route = item;
            tvTitle.setText(item.getRouteID());
            tvDescription.setText(item.getStartStation() + ", " + item.getEndStation() + ", " + item.getDateTime() + ", " + item.getPrice());
        }

        @Override
        public void onClick(View view)
        {

        }
    }

    private List<Route> routes;

    public RouteAdapter (List<Route> routes)
    {
       this.routes = routes;
    }

    @Override
    public RouteAdapter.RouteViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View routeView = inflater.inflate(R.layout.route_search_item, parent, false);
        RouteViewHolder viewHolder = new RouteViewHolder(routeView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RouteAdapter.RouteViewHolder viewHolder, int position)
    {
        Route route = routes.get(position);
        viewHolder.setItem(route);
    }

    @Override
    public int getItemCount()
    {
        return routes.size();
    }



}
