package com.company.natwest.model;

import java.util.PriorityQueue;

public class CustomStructure {

    public PriorityQueue<Order> getBuyingQueue() {
        return buyingQueue;
    }

    public PriorityQueue<Order> getSellingQueue() {
        return sellingQueue;
    }

    private PriorityQueue<Order> buyingQueue ;
    private PriorityQueue<Order> sellingQueue;

    public CustomStructure(PriorityQueue<Order> buyingQueue , PriorityQueue<Order> sellingQueue)
    {
        this.buyingQueue = buyingQueue;
        this.sellingQueue = sellingQueue;
    }



}
