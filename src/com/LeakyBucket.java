package com;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class LeakyBucket implements AccessBucket{
    BlockingQueue<Integer> leakyBucket ;
    int capacity ;
    public LeakyBucket(int capacity){
        leakyBucket = new LinkedBlockingQueue(capacity);
        this.capacity = capacity;
    }

    @Override
    public boolean access() {
       if(leakyBucket.remainingCapacity() > 0) {
           leakyBucket.add(1);
           return true;
       }
       return false;
    }
}
