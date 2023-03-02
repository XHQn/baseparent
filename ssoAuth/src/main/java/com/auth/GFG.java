package com.auth;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.*;
  
public class GFG { 
    public static void main(String[] args) 
    { 
  
        // create an ConcurrentLinkedQueue 
        ConcurrentLinkedQueue<Integer> 
            queue = new ConcurrentLinkedQueue<Integer>(); 
  
        // Add Numbers to queue 
        queue.add(4353); 
        queue.add(7824); 
        queue.add(78249); 
        queue.add(8724); 
  
        // Displaying the existing ConcurrentLinkedQueue 
        System.out.println("ConcurrentLinkedQueue: " + queue); 
  
        // apply poll() 
        int response1 = queue.poll(); 
  
        // print after applying poll method 
        System.out.println("Head: " + response1); 
  
        // Displaying the existing ConcurrentLinkedQueue 
        System.out.println("Current ConcurrentLinkedQueue: " + queue); 
    }




}