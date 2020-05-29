import java.io.FileOutputStream;
import java.io.ObjectOutputStream;



public class SerializationDemo {

	public static void main(String[] args) throws Exception {
		
		FileOutputStream fos = new FileOutputStream("E:/abc.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		DoSerialize ds = new DoSerialize();
		oos.writeObject(ds);
		oos.close();
		
		
		
	}
}
