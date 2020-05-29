
class ThreadRunnable implements Runnable{
	
	public void run()
	{
		for(int i=0;i<5;i++)
		{
			System.out.println("Child thread");
			Thread.yield();
		}
	}

}

public class SimpleThreadRunnable{
	
	public static void main(String[] args) throws Exception{
		
		//Thread.currentThread().join();
		ThreadRunnable r= new ThreadRunnable();
		Thread t1 = new Thread(r);
		t1.start();
		t1.join();
		
		for(int i=0;i<5;i++)
		{
			System.out.println("parent thread by runable");
		}
	}
	
}

