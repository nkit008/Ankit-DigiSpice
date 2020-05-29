class Cat {
	int j ;
	Cat(int j){
		
		this.j = j;
	}
}

class Dog implements Cloneable
{
	Cat c;
	int i;
	
	Dog(Cat c,int i)
	{
		this.c= c;
		this.i= i;
	}
	
	
	/*
	 * public Object clone( ) throws CloneNotSupportedException { return
	 * super.clone( ); }
	 */
	
	
	
	
	  public Object clone( ) throws CloneNotSupportedException { Cat t1 = new
	  Cat(c.j); Dog d1= new Dog(t1, i); return d1; }
	 
	 

}

public class CloneDemo implements Cloneable{

	    public static void main(String[] args) throws CloneNotSupportedException
	    { 
	    	Cat t1 = new Cat(10);
	    	
	    	Dog d1= new Dog(t1, 20);
	    	System.out.println(d1.i +"    "+d1.c.j);
	    	
	    	Dog d2 = (Dog)d1.clone();
	    	System.out.println(d2.i +"    "+d2.c.j);
	    	
	    	d1.i=888;
	    	d1.c.j=999;
	    	
	    	System.out.println(d1.i +"    "+d1.c.j);
	    	System.out.println(d2.i +"    "+d2.c.j);
	    	
}
	    
}



