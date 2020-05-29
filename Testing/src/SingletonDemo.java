
class Singleton
{
	public static Singleton singleton_instance = null;
	
	public static Singleton getInstance()
	{
		if(singleton_instance==null)
			singleton_instance =new Singleton();

		return singleton_instance; 
	}
	
	private Singleton()
	{
		
	}
}


public class SingletonDemo {

	public static void main(String[] args) {
		
		//Singleton s = new Singleton();
		Singleton s = Singleton.getInstance();
		System.out.println(s.hashCode());
		
		Singleton s1 = Singleton.getInstance();
		System.out.println(s1.hashCode());
	}
	
	
}
