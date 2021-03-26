package com.cs4125.bookingapp.repositories;

import com.cs4125.bookingapp.entities.Route;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class RouteRepositoryCacheProxy implements RouteRepository, Serializable
{
    private RouteRepository routeRepository;
    private ConcurrentHashMap<String, String> cachedResults;
    private Date lastUpdate;

    public RouteRepositoryCacheProxy()
    {
        routeRepository = new RouteRepositoryImpl();
        cachedResults = new ConcurrentHashMap<>();
    }

    @Override
    public void generateRoutes(String start, String end, String dateTime, ResultCallback callback)
    {
        long diffMinutes = 99;
        long diffHours = 99;
        if(lastUpdate != null)
        {
            long diffInMillis = Calendar.getInstance().getTime().getTime() - lastUpdate.getTime();
            diffMinutes = TimeUnit.MILLISECONDS.toMinutes(diffInMillis);
            diffHours = TimeUnit.MILLISECONDS.toMinutes(diffInMillis);
        }

        String keyString = "!NOFILTER!" + start + end + dateTime;

        if(diffHours < 1 && diffMinutes < 20 && cachedResults.containsKey(keyString))
        {
            callback.onResult(cachedResults.get(keyString));
        }
        else
        {
            lastUpdate = Calendar.getInstance().getTime();
            routeRepository.generateRoutes(start, end, dateTime, new ResultCallback()
            {
                @Override
                public void onResult(String result)
                {
                    cachedResults.put(keyString, result);
                    callback.onResult(result);
                }

                @Override
                public void onFailure(Throwable error)
                {
                    callback.onFailure(error);
                }
            });
        }
    }

    @Override
    public void generateFilteredRoutes(String start, String end, String filters, String dateTime, ResultCallback callback)
    {
        long diffMinutes = 99;
        long diffHours = 99;
        if(lastUpdate != null)
        {
            long diffInMillis = Calendar.getInstance().getTime().getTime() - lastUpdate.getTime();
            diffMinutes = TimeUnit.MILLISECONDS.toMinutes(diffInMillis);
            diffHours = TimeUnit.MILLISECONDS.toMinutes(diffInMillis);
        }

        String keyString = "!FILTER!" + start + end + dateTime;

        if(diffHours < 1 && diffMinutes < 20 && cachedResults.containsKey(keyString))
        {
            callback.onResult(cachedResults.get(keyString));
        }
        else
        {
            lastUpdate = Calendar.getInstance().getTime();
            routeRepository.generateFilteredRoutes(start, end, filters, dateTime, new ResultCallback()
            {
                @Override
                public void onResult(String result)
                {
                    cachedResults.put(keyString, result);
                    callback.onResult(result);
                }

                @Override
                public void onFailure(Throwable error)
                {
                    callback.onFailure(error);
                }
            });
        }
    }

    //    @Override
//    public void searchAllRoute(Route search, ResultCallback resultCallback)
//    {
//        long diffMinutes = 99;
//        long diffHours = 99;
//        if(lastUpdate != null)
//        {
//            long diffInMillis = Calendar.getInstance().getTime().getTime() - lastUpdate.getTime();
//            diffMinutes = TimeUnit.MILLISECONDS.toMinutes(diffInMillis);
//            diffHours = TimeUnit.MILLISECONDS.toMinutes(diffInMillis);
//        }
//
//        String searchString = "ALL" + search.getStartStation() + search.getEndStation() + search.getDateTime();
//        if(diffHours < 1 && diffMinutes < 20 && cachedResults.containsKey(searchString))
//        {
//            System.out.println("Return Cached Result!");
//            resultCallback.onResult(cachedResults.get(searchString));
//        }
//        else
//        {
//            System.out.println("No Cached Result, Fetching Request!");
//            lastUpdate = Calendar.getInstance().getTime();
//            routeRepository.searchAllRoute(search, new ResultCallback()
//            {
//                @Override
//                public void onResult(String result)
//                {
//                    cachedResults.put(searchString, result);
//                    resultCallback.onResult(result);
//                }
//
//                @Override
//                public void onFailure(Throwable error)
//                {
//                    resultCallback.onFailure(error);
//                }
//            });
//        }
//    }
//
//    @Override
//    public void searchRouteById(Route search, ResultCallback resultCallback)
//    {
//        if(cachedResults.containsKey(Integer.toString(search.getRouteID())))
//        {
//            System.out.println("Return Cached Result!");
//            resultCallback.onResult(cachedResults.get(Integer.toString(search.getRouteID())));
//        }
//        else
//        {
//            System.out.println("No Cached Result, Fetching Request!");
//            routeRepository.searchRouteById(search, new ResultCallback()
//            {
//                @Override
//                public void onResult(String result)
//                {
//                    cachedResults.put(Integer.toString(search.getRouteID()), result);
//                    resultCallback.onResult(result);
//                }
//
//                @Override
//                public void onFailure(Throwable error)
//                {
//                    resultCallback.onFailure(error);
//                }
//            });
//        }
//    }
//
//    @Override
//    public void searchRouteByStationOrDateTime(Route search, ResultCallback resultCallback)
//    {
//        long diffMinutes = 99;
//        long diffHours = 99;
//        if(lastUpdate != null)
//        {
//            long diffInMillis = Calendar.getInstance().getTime().getTime() - lastUpdate.getTime();
//            diffMinutes = TimeUnit.MILLISECONDS.toMinutes(diffInMillis);
//            diffHours = TimeUnit.MILLISECONDS.toMinutes(diffInMillis);
//        }
//
//        String searchString = search.getStartStation() + search.getEndStation() + search.getDateTime();
//        if(diffHours < 1 && diffMinutes < 20 && cachedResults.containsKey(searchString))
//        {
//            System.out.println("Return Cached Result!");
//            resultCallback.onResult(cachedResults.get(searchString));
//        }
//        else
//        {
//            System.out.println("No Cached Result, Fetching Request!");
//            lastUpdate = Calendar.getInstance().getTime();
//            routeRepository.searchAllRoute(search, new ResultCallback()
//            {
//                @Override
//                public void onResult(String result)
//                {
//                    cachedResults.put(searchString, result);
//                    resultCallback.onResult(result);
//                }
//
//                @Override
//                public void onFailure(Throwable error)
//                {
//                    resultCallback.onFailure(error);
//                }
//            });
//        }
//    }
//
//    @Override
//    public void newRoute(Route route, ResultCallback resultCallback)
//    {
//        routeRepository.newRoute(route, resultCallback);
//    }
//
//    @Override
//    public void updateRoute(Route route, ResultCallback resultCallback)
//    {
//        routeRepository.updateRoute(route, resultCallback);
//    }
//
//    @Override
//    public void deleteRoute(Route route, ResultCallback resultCallback)
//    {
//        routeRepository.deleteRoute(route, resultCallback);
//    }

    public void resetCache()
    {
        cachedResults.clear();
    }
}
