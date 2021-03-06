package com.cs4125.bookingapp.ui.main;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.FragmentManager;
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
            //tvTitle.setText(Integer.toString(item.getRouteID()));
            if(item.getPrice() <= 0.0)
                tvTitle.setText("Free!");
            else
                tvTitle.setText("€" + Double.toString(item.getPrice()));

//            int changes = 0;
//            try
//            {
//                String[] parts = item.getConnectionPath().split("&");
//                if(parts.length >= 2)
//                    changes = parts.length - 1;
//            }
//            catch (Exception e)
//            {
//                System.out.println(e.toString());
//            }
            tvDescription.setText("Start: " + item.getStartStation() + ", End: " + item.getEndStation() + ", Date and Time: " + item.getDateTime());
        }

        @Override
        public void onClick(View view)
        {
            //Utilities.showToast(view.getContext(), route.toString());
            try
            {
                SearchResultFragment s = FragmentManager.findFragment(view);
                s.bookSelectedRoute(route.toString());
            }
            catch (Exception e)
            {
                System.out.println("Missing Search Result Fragment: " + e.toString());
            }
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

    public Route getItem(int position){
        return routes.get(position);
    }

    @Override
    public int getItemCount()
    {
        return routes.size();
    }

}
