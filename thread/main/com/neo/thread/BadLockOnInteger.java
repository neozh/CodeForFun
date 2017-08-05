package com.neo.thread;

public class BadLockOnInteger implements Runnable 
{
	public static Integer index = 0;
	static BadLockOnInteger instance = new BadLockOnInteger();
	
	@Override
	public void run() 
	{
		for (int i = 0; i < 10000000; i++) {
			synchronized(index) //修改方法： index 换成 instance.
			{
			    //错误点: Integer的自增，只要数字不再 -127 到 128 之间，
		            // 都会新创建一个新对象, 则锁对象实际上就变了。
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
