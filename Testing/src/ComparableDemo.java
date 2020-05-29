import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

class Student implements Comparable
{
	int id;
	String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public int compareTo(Object o) {
		
		int id1 = ((Student)o).id;
		
		if(id<id1)
			return -1;
		else if(id>id1)
			return +1;
		else
			return 0;
	}
	
	public String toString()
	{
		return name +"  "+id;
	}
	
	
}

public class ComparableDemo {

	public static void main(String[] args) {
		
		Student s= new Student();
		s.setId(102);
		s.setName("Ankit");
		
		Student s1= new Student();
		s1.setId(101);
		s1.setName("Aankit");
		
		Student s2= new Student();
		s2.setId(101);
		s2.setName("vivek");
		
		HashSet<String> h = new HashSet<String>();
		h.add("ankit");
		h.add("b");
		
		HashMap<String, String> hm = new HashMap<String, String>();
		hm.put("103","ankit");
		hm.put("102","ankit");
		hm.put("101","ankita");
		
		System.out.println(hm);
		System.out.println(h);
		
		TreeSet<Student> t= new TreeSet<Student>();
		t.add(s);
		t.add(s1);
		t.add(s2);
		
		System.out.println(t);
	}
}
