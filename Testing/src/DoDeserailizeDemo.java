import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class DoDeserailizeDemo {
	
	public static void main(String[] args) throws Exception {
		
		FileInputStream fis = new FileInputStream("E:/abc.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		DoSerialize d= (DoSerialize)ois.readObject();
		System.out.println(d.id);
		System.out.println(d.name);
		
		ois.close();
	}

}
