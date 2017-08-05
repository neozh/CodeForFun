package com.neo.thread;

public class BadLockOnInteger implements Runnable 
{
	public static Integer index = 0;
	static BadLockOnInteger instance = new BadLockOnInteger();
	
	@Override
	public void run() 
	{
		for (int i = 0; i < 10000000; i++) {
			synchronized(index)
			{
				index++;
			}
		}

	}

	public static void main(String[] args) throws InterruptedException 
	{
		Thread t1 = new Thread(instance);
		Thread t2 = new Thread(instance);
		
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println( index );
	}

}
