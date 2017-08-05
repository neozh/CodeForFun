package com.neo.thread;

import java.util.concurrent.locks.ReentrantLock;

public class ReenterLock implements Runnable 
{
	public static ReentrantLock lock = new ReentrantLock();
	public static int index;
	@Override
	public void run() {
		for (int j = 0; j < 10000000; j++) {
			lock.lock();
			try{
				index++;
			}finally{
				lock.unlock();
				
			}
		}

	}

	public static void main(String[] args) throws InterruptedException {
		ReenterLock rLock = new ReenterLock();
		
		Thread t1 = new Thread(rLock);
		Thread t2 = new Thread(rLock);
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		System.out.println(index);
		
	}

}
