package com.company.natwest.model;

import java.sql.Timestamp;
import java.util.Date;

public class Order implements Comparable<Order>, Cloneable
{
    private String id;

    public String getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public InstrumentType getOrderInstrument() {
        return orderInstrument;
    }

    public Date getCreatedTimeStamp() {
        return createdTimeStamp;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public int getQuantity() {
        return quantity;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    private int price;
    private InstrumentType orderInstrument;
    private Date createdTimeStamp;


    private OrderType orderType;
    private int quantity;
    private Timestamp timestamp;

    public Order(String id, int price, InstrumentType orderInstrument , OrderType orderType , int quantity)
    {
        this.id = id;
        this.price = price;
        this.orderInstrument = orderInstrument;
        this.orderType = orderType;
        this.quantity = quantity;
        this.createdTimeStamp = new Date();
        this.timestamp = new Timestamp(System.currentTimeMillis());
    }

    @Override
    public int compareTo(Order o)
    {
        if( o.orderType == OrderType.SELL  )
        {
            //it selling
            //someone who sells at minimum price stands out
            //so implement min-heap
            //so natural ordering on price
            if(this.price > o.price)
            {
                return 1;
            }
            if(this.price == o.price)
            {
                   if(this.timestamp.before(o.timestamp))
                   {
                       return -1;
                   }
                   if(this.timestamp.equals(o.timestamp))
                   {
                       return 0;
                   }
                   if(this.timestamp.after(o.timestamp))
                   {
                       return 1;
                   }
            }
            if(this.price < o.price)
            {
                return -1;
            }
        }
        else
        {
            //its buying
            //someone who wants to buy at greater price stands out
            //so implement max-heap
            //reverse the natural ordering of price
            if(this.price > o.price)
            {
                return -1;
            }
            if(this.price == o.price)
            {
                if(this.price == o.price)
                {
                    if(this.timestamp.before(o.timestamp))
                    {
                        return -1;
                    }
                    if(this.timestamp.equals(o.timestamp))
                    {
                        return 0;
                    }
                    if(this.timestamp.after(o.timestamp))
                    {
                        return 1;
                    }
                }
                return 0;
            }
            if(this.price < o.price)
            {
                return 1;
            }
        }
        throw new IllegalStateException("this state should have never come");
    }
}
