package com.cs4125.bookingapp.repositories;

import com.cs4125.bookingapp.entities.Discount;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class DiscountRepositoryCacheProxy implements DiscountRepository, Serializable
{
    private DiscountRepository discountRepository;
    private ConcurrentHashMap<String, String> cachedResults;
    private Date lastUpdate;

    public DiscountRepositoryCacheProxy()
    {
        discountRepository = new DiscountRepositoryImpl();
        cachedResults = new ConcurrentHashMap<>();
    }

    @Override
    public void getAllDiscounts(ResultCallback callback)
    {
        long diffMinutes = 99;
        long diffHours = 99;
        if(lastUpdate != null)
        {
            long diffInMillis = Calendar.getInstance().getTime().getTime() - lastUpdate.getTime();
            diffMinutes = TimeUnit.MILLISECONDS.toMinutes(diffInMillis);
            diffHours = TimeUnit.MILLISECONDS.toMinutes(diffInMillis);
        }

        // this request doesn't depend on incoming parameter, so will store it as "ALLDISCOUNTS" in the cache
        if(diffHours < 1 && diffMinutes < 20 && cachedResults.containsKey("ALLDISCOUNTS"))
        {
            callback.onResult(cachedResults.get("ALLDISCOUNTS"));
        }
        else
        {
            lastUpdate = Calendar.getInstance().getTime();
            discountRepository.getAllDiscounts(new ResultCallback()
            {
                @Override
                public void onResult(String result)
                {
                    cachedResults.put("ALLDISCOUNTS", result);
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
    public void getDiscountById(Discount discount, ResultCallback resultCallback)
    {
        if(cachedResults.containsKey(Integer.toString(discount.getDiscountId())))
        {
            resultCallback.onResult(cachedResults.get(Integer.toString(discount.getDiscountId())));
        }
        else
        {
            discountRepository.getDiscountById(discount, new ResultCallback()
            {
                @Override
                public void onResult(String result)
                {
                    cachedResults.put(Integer.toString(discount.getDiscountId()), result);
                    resultCallback.onResult(result);
                }

                @Override
                public void onFailure(Throwable error)
                {
                    resultCallback.onFailure(error);
                }
            });
        }
    }

    @Override
    public void getDiscountByCode(Discount discount, ResultCallback resultCallback)
    {
        if(cachedResults.containsKey(discount.getCode()))
        {
            resultCallback.onResult(cachedResults.get(discount.getCode()));
        }
        else
        {
            discountRepository.getDiscountByCode(discount, new ResultCallback()
            {
                @Override
                public void onResult(String result)
                {
                    cachedResults.put(discount.getCode(), result);
                    resultCallback.onResult(result);
                }

                @Override
                public void onFailure(Throwable error)
                {
                    resultCallback.onFailure(error);
                }
            });
        }
    }

    @Override
    public void newDiscount(Discount discount, ResultCallback resultCallback)
    {
        discountRepository.newDiscount(discount, resultCallback);
    }

    @Override
    public void updateDiscount(Discount discount, ResultCallback resultCallback)
    {
        discountRepository.updateDiscount(discount, resultCallback);
    }

    @Override
    public void removeOldDiscount(Discount discount, ResultCallback resultCallback)
    {
        discountRepository.removeOldDiscount(discount, resultCallback);
    }

    public void resetCache()
    {
        cachedResults.clear();
    }
}
