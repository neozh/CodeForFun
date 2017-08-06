package com.neo.thread;

import java.util.concurrent.locks.ReentrantLock;

public class IntLock implements Runnable{

	public static ReentrantLock lock1 = new ReentrantLock();
	public static ReentrantLock lock2 = new ReentrantLock();
	
	int lock;
	String name;
	
	public IntLock(int lock, String name)
	{
		this.lock = lock;
		this.name = name;
		
	}
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	@Override
	public void run() 
	{
		try{
			if(lock == 1)
			{
				lock1.lockInterruptibly();
				try{
					Thread.sleep(500);
				}catch( InterruptedException e)
				{
				//	e.printStackTrace();
				}
				lock2.lockInterruptibly();
				System.out.println(this.getName() + " finished!");
			}else {
				lock2.lockInterruptibly();
				try{
					Thread.sleep(500);
				}catch(InterruptedException e)
				{
					//lock1.isHeldByCurrentThread();
				}
				lock1.lockInterruptibly();
				System.out.println(this.getName() + " finished!");
			}
		}
		catch( InterruptedException e)
		{
			e.printStackTrace();
		}finally
		{
			if( lock1.isHeldByCurrentThread())
			{
				lock1.unlock();
			}
			if( lock2.isHeldByCurrentThread())
			{
				lock2.unlock();
			}
			System.out.println( Thread.currentThread().getId() +" - " + Thread.currentThread().getName() + " - "+ this.getName()+ "线程退出");
		}
		
	}

	
	public static void main(String[] args) throws InterruptedException 
	{
		IntLock r1 = new IntLock(1, "r1");
		IntLock r2 = new IntLock(2, "r2");
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);

		t1.start();
		t2.start();
		Thread.sleep(1000);
		
		t2.interrupt();
		
	}

}
