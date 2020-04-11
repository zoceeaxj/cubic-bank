package com.rab3tech;

import java.time.LocalDate;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueExample {
	public static void main(String[] args) {
	   Queue<String> priorityQueue = new PriorityQueue<>();
        
		priorityQueue.add("AAA");
		priorityQueue.add( "CCC");
		priorityQueue.add( "BBB");
		priorityQueue.add("FFF");
		priorityQueue.add("DDD");
		priorityQueue.add("EEE");
		 
		while(true) 
		{
		    String e = priorityQueue.poll();
		    System.out.println(e);
		    if(e == null) break;
		}
	}
}