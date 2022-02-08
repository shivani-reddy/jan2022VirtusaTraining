package singletondemo;

public class Singleton {

	private static Singleton obj1;
	private Singleton() {}
	
	public static Singleton getInstance() {
		if(obj1==null) 
			obj1=new Singleton();
		return obj1;	
	}
	public void show() {
		System.out.println("inside show methods");
	}
}
