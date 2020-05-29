
public class OverloadingDemo {
	
	public void show(int x)
	{
		String s = "ankit";
		String s1 = "ankit";
		System.out.println("Int method call "+(s==s1));

		System.out.println("Int method call "+(s.equals(s1)));
	}

	public void show(float x)
	{
		System.out.println("float method call "+x);
	}
	
	public void show(long x)
	{
		System.out.println("long method call "+x);
	}
	
	public void show(double x)
	{
		System.out.println("double method call "+x);
	}
	
	public static void main(String[] args) {
		
		OverloadingDemo d= new OverloadingDemo();
		d.show('a');
		
		d.show(3);
		d.show(300l);
		d.show(2.5);
		d.show(2f);
	}
	
}
