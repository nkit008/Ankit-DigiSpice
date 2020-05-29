
public class LambdaExpr {
	public static void main() {
		FuncInterface fun = () -> {System.out.println("lambda expression");};
	}
	
	

}

interface FuncInterface {
	public void sum();
}
