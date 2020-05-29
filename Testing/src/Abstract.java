
abstract class Parent
{
	void display(){}
	
	
}


public class Abstract extends Parent{
	
	public void display()
	{
		int a=0;
		System.out.println("aaaaaaaa "+a);
	}
	

	    public static void main(String[] args) throws CloneNotSupportedException
	    { 
	    	
	    	//Abstract a = new Abstract();
	    	Parent p = new Abstract();
	    	
	    	p.display();
	    
	    }
	    
}



