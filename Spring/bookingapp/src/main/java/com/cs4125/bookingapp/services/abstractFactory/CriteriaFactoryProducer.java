package com.cs4125.bookingapp.services.abstractFactory;

public class CriteriaFactoryProducer {

    public static AbstractCriteriaFactory<?> getFactory(String factoryType)
    {
        AbstractCriteriaFactory<?> factory;
        switch(factoryType)
        {
            case("CONNECTION"):
                factory = new ConnectionCriteriaFactory();
                break;
            case("ROUTE"):
                factory = new RouteCriteriaFactory();
                break;
            default:
                factory = null;
        }

        return factory;
    }
}
