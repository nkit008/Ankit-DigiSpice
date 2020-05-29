
public class DeadockDemo {
	
	public static Object Lock1  = new Object();
	public static Object Lock2  = new Object();
	
	public static void main(String[] args) {
		
		Thread1 t1 = new Thread1();
		Thread2 t2 = new Thread2();
		
		t1.start();
		t2.start();
	}
	
	
	
	private static class Thread1 extends Thread
	{
		public void run()
		{
			synchronized (Lock1) {
				System.out.println("Thread 1: holding lock 1");
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				System.out.println("Thread 1: is sleping");
				e.printStackTrace();
			}
			
			System.out.println("Thread 1: Waiting  for Lock 2");
			
			synchronized (Lock2) {
				System.out.println("Thread 1: holding lock 2");
			}
		}
	}
}
	
	
	private static class Thread2 extends Thread
	{
		public void run()
			{
				synchronized (Lock2) {
					System.out.println("Thread 2: holding lock 2");
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					System.out.println("Thread 2: is sleping");
					e.printStackTrace();
				}
				
				System.out.println("Thread 2: Waiting for Lock 1");
				
				synchronized (Lock1) {
					System.out.println("Thread 2: holding lock 1");
				}
			}
		}
	}

	
}
