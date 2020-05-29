import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class ArrayListDemo {
	
	public static void main(String[] args)
	{
		
		TreeSet<String> t= new TreeSet<String>();
		
		t.add("1");
		System.out.println(t);
		
		
		ArrayList<String> l = new ArrayList<String>();
		System.out.println(l.add("a"));
		System.out.println(l.add("b"));
		System.out.println(l.add("c"));
		System.out.println(l.add("d"));
		System.out.println(l.add(null));
		System.out.println(l.add(null));
		System.out.println(l.add(null));
		System.out.println(l.add(null));
		
		Iterator<String> i = l.iterator();
		
		while(i.hasNext())
		{
			//l.add("ankit");
			System.out.println(i.next());
		}
		
				
		
			
		
	
	}


}
