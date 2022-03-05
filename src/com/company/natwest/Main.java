package com.company.natwest;

import com.company.natwest.model.CustomStructure;
import com.company.natwest.model.InstrumentType;
import com.company.natwest.model.Order;
import com.company.natwest.model.OrderType;
import com.company.natwest.persistence.CustomPersistence;
import com.company.natwest.service.MatchingService;
import com.company.natwest.service.PlaceService;

import java.util.HashMap;
import java.util.PriorityQueue;

public class Main {


    public static void main(String[] args) throws InterruptedException {
        //pre steps
        createPersistence();
        //place a buy order
        Order o1 = new Order("1",99,InstrumentType.CORPORATEBONDS, OrderType.BUY,100);
        PlaceService.placeOrder(o1);


        //place a sell order




        Order o2 = new Order("2",100,InstrumentType.CORPORATEBONDS,OrderType.SELL,50);
        PlaceService.placeOrder(o2);

        Thread.sleep(500);

        Order o5 = new Order("2",100,InstrumentType.CORPORATEBONDS,OrderType.SELL,50);
        PlaceService.placeOrder(o5);

        Order o3 = new Order("3",200,InstrumentType.CORPORATEBONDS,OrderType.BUY,49);
        PlaceService.placeOrder(o3);

        Thread.sleep(500);

        Order o4 = new Order("4",201,InstrumentType.CORPORATEBONDS,OrderType.BUY,51);
        PlaceService.placeOrder(o4);


    }


    public static void createPersistence()
    {
        CustomPersistence customPersistence = new CustomPersistence(new HashMap<InstrumentType, CustomStructure>());
        for(InstrumentType it : InstrumentType.values())
        {
            PriorityQueue<Order> buyingQueue = new PriorityQueue<>();
            PriorityQueue<Order> sellingQueue = new PriorityQueue<>();
            customPersistence.database.put(it,new CustomStructure(buyingQueue,sellingQueue )  );
        }
    }

}
