package com.company.natwest.service;


import com.company.natwest.model.CustomStructure;
import com.company.natwest.model.InstrumentType;
import com.company.natwest.model.Order;
import com.company.natwest.persistence.CustomPersistence;

import java.util.HashMap;

public class MatchingService
{

    //private static MatchingService matchingService;

    private MatchingService()
    {

    }

    public static void doMatch(InstrumentType type)
    {
        HashMap<InstrumentType, CustomStructure> hashMap = CustomPersistence.database;

        CustomStructure customStructure = hashMap.get(type);

        if( !customStructure.getSellingQueue().isEmpty() && !customStructure.getBuyingQueue().isEmpty()  )
        {
            //both selling and buying are not empty
            boolean changeInState = true;

            while(changeInState && !customStructure.getSellingQueue().isEmpty() && !customStructure.getBuyingQueue().isEmpty() )
            {
                Order buying = customStructure.getBuyingQueue().peek();
                Order selling = customStructure.getSellingQueue().peek();
                if(buying.getPrice() >= selling.getPrice())
                {
                    //something we can execute
                    if(buying.getQuantity() == selling.getQuantity())
                    {
                        System.out.println("order executed with buying id: " +buying.getId() + " selling id "+selling.getId() + " quantity is "+ buying.getQuantity());
                        customStructure.getBuyingQueue().remove();
                        customStructure.getSellingQueue().remove();
                        continue;
                    }
                    if(buying.getQuantity() < selling.getQuantity())
                    {
                        System.out.println("order executed buying id: "+buying.getId() + " ---- partially executed selling id "+selling.getId() + " ------ transaction quantity is "+buying.getQuantity());
                        customStructure.getBuyingQueue().remove();
                        customStructure.getSellingQueue().remove();
                        Order newSellingOrder = new Order(selling.getId(),selling.getPrice(),selling.getOrderInstrument(),selling.getOrderType(), selling.getQuantity() - buying.getQuantity());
                        customStructure.getSellingQueue().add(newSellingOrder);
                        continue;
                    }
                    if(buying.getQuantity() > selling.getQuantity())
                    {
                        System.out.println("order executed selling id: "+selling.getId() + " --------- partially executed buying id "+buying.getId() + " ----- transaction quantity is "+selling.getQuantity());
                        customStructure.getSellingQueue().remove();
                        customStructure.getBuyingQueue().remove();
                        Order newBuyingOrder = new Order(buying.getId(), buying.getPrice(), buying.getOrderInstrument(),buying.getOrderType(), buying.getQuantity()- selling.getQuantity());
                        customStructure.getBuyingQueue().add(newBuyingOrder);
                        continue;
                    }

                }
                else
                {
                    changeInState = false;

                }
            }

        }
    }



}
