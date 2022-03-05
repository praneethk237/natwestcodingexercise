package com.company.natwest.service;

import com.company.natwest.model.CustomStructure;
import com.company.natwest.model.InstrumentType;
import com.company.natwest.model.Order;
import com.company.natwest.model.OrderType;
import com.company.natwest.persistence.CustomPersistence;

import java.util.HashMap;
import java.util.PriorityQueue;

public class PlaceService {


    public static void placeOrder(Order order)
    {
        HashMap<InstrumentType, CustomStructure> hashMap =  CustomPersistence.database;
        InstrumentType type = order.getOrderInstrument();
        CustomStructure structure = hashMap.get(type);
        PriorityQueue<Order> pq = null;
        if(order.getOrderType() == OrderType.BUY)
        {
            pq = structure.getBuyingQueue();
        }
        else
        {
            pq = structure.getSellingQueue();
        }
        pq.add(order);

        //since There is a change in our persistence it triggers matching mechanism

        MatchingService.doMatch(order.getOrderInstrument());

    }
}
