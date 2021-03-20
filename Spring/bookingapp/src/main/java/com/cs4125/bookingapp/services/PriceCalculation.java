package com.cs4125.bookingapp.services;

import com.cs4125.bookingapp.model.entities.Connection;
import com.cs4125.bookingapp.model.entities.Route;
import com.cs4125.bookingapp.services.criteria.*;

import java.util.ArrayList;
import java.util.List;

public class PriceCalculation
{
    private String preferredTransportType;
    private List<Connection> connections;
    private static final String[] availableTransportTypes = {"WALK", "BIKE", "CAR", "BUS", "TRAIN", "PLANE", "TAXI", "UBER"};

    /**
     * @param preferredTransportType the transport type it will try to use for pricing, if not available it will try by cheapest
     * @param connections the connections that were used when creating the routes to look up distances and transport types
     */
    public PriceCalculation(String preferredTransportType, List<Connection> connections)
    {
        this.preferredTransportType = preferredTransportType;
        this.connections = connections;
    }

    public List<Double> getPrices(List<Route> routes)
    {
        List<Double> pricesForRoutes = new ArrayList<>();
        for (Route r : routes)
        {
            pricesForRoutes.add(getRoutePricing(r));
        }

        return pricesForRoutes;
    }

    private double getRoutePricing(Route r)
    {
        double totalPrice = 0;
        String[] connectionsToPrice = r.getConnectionPath().split("&");
        for (String s : connectionsToPrice)
        {
            try
            {
                int connectionId = Integer.parseInt(s);
                //TODO: rework once path finding algo is finished as not sure what exactly will be in connection path
                Connection currentConnection = connections.get(connectionId - 1);
                double distance = currentConnection.getDistance();

                if(preferredTransportType.equalsIgnoreCase("ALL"))
                {
                    for (String transportType : availableTransportTypes)
                    {
                        if (currentConnection.getTransportType().contains(transportType))
                        {
                            double pricePerKM = getTransportPricing(transportType);
                            // error
                            if (pricePerKM == -1)
                                return -1;

                            totalPrice += distance * pricePerKM;
                            break;
                        }
                    }
                }
                else
                {
                    double pricePerKM = getTransportPricing(preferredTransportType);
                    // error
                    if (pricePerKM == -1)
                        return -1;

                    totalPrice += distance * pricePerKM;
                }
            }
            catch(Exception e)
            {
                System.out.println("Error when reading connections for pricing: " + e.toString());
                return -1;
            }
        }

        return totalPrice;
    }

    private static double getTransportPricing(String transportType)
    {
        double pricingPerKM;
        switch(transportType)
        {
            case("BIKE"):
            case("WALK"):
            case("CAR"):
                pricingPerKM = 0;
                break;
            case("BUS"):
                pricingPerKM = 0.5;
                break;
            case("TRAIN"):
                pricingPerKM = 0.55;
                break;
            case("PLANE"):
                pricingPerKM = 0.6;
                break;
            case("TAXI"):
                pricingPerKM = 0.7;
                break;
            case("UBER"):
                pricingPerKM = 0.75;
                break;
            default:
                pricingPerKM = -1.0;
        }

        return pricingPerKM;
    }
}
