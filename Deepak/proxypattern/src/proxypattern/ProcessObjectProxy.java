package proxypattern;

public class ProcessObjectProxy implements ProcessObject {
	
	private static ProcessObject obj;
	
	@Override
	public void process() {
		if(obj==null) {
			obj=new ProcessObjectImpl();
			}
		
		obj.process();
		
	}

}
