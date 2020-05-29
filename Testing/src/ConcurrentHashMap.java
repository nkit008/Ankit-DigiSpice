import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class ConcurrentHashMap {
	
	public void work()
	{
	
		/* HashMap<String,String> s= new HashMap<String, String>(); */
		java.util.concurrent.ConcurrentHashMap<String,String> s= new java.util.concurrent.ConcurrentHashMap<String, String>();
		System.out.println(s.put("1", "a"));
		//System.out.println(s.put("2", null));
		System.out.println(s.put("1", "abc"));
		//System.out.println(s.put(null, "abc"));
		//System.out.println(s.put(null, null));
		System.out.println(s);
		
		Iterator h = s.entrySet().iterator();
		
		System.out.println("-------------Iterating Hash Map------------");
		while(h.hasNext())
		{
			s.put("3","aaaaaaa");
			System.out.println(h.next());
		}
	}
	
	public ConcurrentHashMap() {
	
		System.out.println("Constructor Called");
	}
	
public static void main(String[] args) {
	
	ConcurrentHashMap h = new ConcurrentHashMap();
	h.work();
}	
	

}
