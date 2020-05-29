
interface I1
{
	public int a();
}

interface I2
{
	public String qa();
}
public class InterfaceDemo implements I1,I2{

	public int a()
	{
		//return "from Interface I1";
		return 90;
	}
	
	public String qa()
	{
		return "from Interface I2";
	}
	
	public static void main(String[] args) {
		
		I1 i1 = new InterfaceDemo();
		System.out.println(i1.a());
		
		I2 i2 = new InterfaceDemo();
		System.out.println(i2.qa());
	}
}
