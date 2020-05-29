
class MyThread extends Thread
{
	
	public void run()
	{
		
		for(int i=0;i<5;i++)
		{
			System.out.println("child thread");
			
		}
	}
}



public class SimpleThreading {
	static int i;
	public static void main(String[] args) throws Exception {
		MyThread t= new MyThread();
		t.start();
		System.out.println(i);
		for(int i=0;i<5;i++)
		{
			System.out.println("main thread");
		}
	}

}
