package test;

import com.company.natwest.model.CustomStructure;
import com.company.natwest.model.InstrumentType;
import com.company.natwest.model.Order;
import com.company.natwest.model.OrderType;

import java.util.PriorityQueue;

public class TestPriorityQueueSelling {

    public static  void main(String[] args) throws InterruptedException {
        CustomStructure customStructure = new CustomStructure(new PriorityQueue<Order>() , new PriorityQueue<Order>());
        PriorityQueue<Order> sellingQueue = customStructure.getSellingQueue();

        Order o1 = new Order("1",100, InstrumentType.CORPORATEBONDS, OrderType.SELL,50);
        Thread.sleep(500);
        Order o2 = new Order("2",50, InstrumentType.CORPORATEBONDS, OrderType.SELL,50);
        Thread.sleep(500);
        Order o3 = new Order("3",150, InstrumentType.CORPORATEBONDS, OrderType.SELL,50);
        Thread.sleep(500);
        Order o4 = new Order("4",150,InstrumentType.CORPORATEBONDS,OrderType.SELL,50);
        Thread.sleep(500);
        Order o5 = new Order("5",150,InstrumentType.CORPORATEBONDS,OrderType.SELL,50);
        Thread.sleep(500);

       sellingQueue.add(o1);
       sellingQueue.add(o2);
       sellingQueue.add(o3);
       sellingQueue.add(o4);
       sellingQueue.add(o5);

       while(!sellingQueue.isEmpty())
       {
           System.out.println( sellingQueue.remove().getId() );
       }
    }

}
