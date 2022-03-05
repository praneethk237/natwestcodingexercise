package test;

import com.company.natwest.model.CustomStructure;
import com.company.natwest.model.InstrumentType;
import com.company.natwest.model.Order;
import com.company.natwest.model.OrderType;

import java.util.PriorityQueue;

public class TestPriorityQueueBuying {

    public static  void main(String[] args) throws InterruptedException 
    {
        CustomStructure customStructure = new CustomStructure(new PriorityQueue<Order>() , new PriorityQueue<Order>());
        PriorityQueue<Order> buyingQueue = customStructure.getBuyingQueue();

        Order o1 = new Order("1",100, InstrumentType.CORPORATEBONDS, OrderType.BUY,50);
        Thread.sleep(500);
        Order o2 = new Order("2",50, InstrumentType.CORPORATEBONDS, OrderType.BUY,50);
        Thread.sleep(500);
        Order o3 = new Order("3",150, InstrumentType.CORPORATEBONDS, OrderType.BUY,50);
        Thread.sleep(500);
        Order o4 = new Order("4",150,InstrumentType.CORPORATEBONDS,OrderType.BUY,50);
        Thread.sleep(500);
        Order o5 = new Order("5",150,InstrumentType.CORPORATEBONDS,OrderType.BUY,50);
        Thread.sleep(500);

       buyingQueue.add(o1);
       buyingQueue.add(o2);
       buyingQueue.add(o3);
       buyingQueue.add(o4);
       buyingQueue.add(o5);


       while(!buyingQueue.isEmpty())
       {
           System.out.println( buyingQueue.remove().getId() );
       }
    }

}
