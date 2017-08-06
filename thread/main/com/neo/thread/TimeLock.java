package com.neo.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class TimeLock implements Runnable {

	public static ReentrantLock lock = new ReentrantLock();
	
	private String name;
	
	public TimeLock(String name)
	{
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		try{
			if(lock.tryLock(5, TimeUnit.SECONDS))
			{
				Thread.sleep(6000);
			}
			else 
			 {
				System.out.println(Thread.currentThread().getName() +" get lock failed");
			}
		}catch (InterruptedException e)
		{
			e.printStackTrace();
		}finally{
			if(lock.isHeldByCurrentThread()) 
			{
				lock.unlock();
			}
		}

	}

	public static void main(String[] args) {
		TimeLock tLock = new TimeLock("tm");
		Thread t1 = new Thread(tLock);
		Thread t2 = new Thread(tLock);
		t1.start();
		t2.start();

	}

}
