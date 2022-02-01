package proxypattern;

public class ProcessObjectImpl implements ProcessObject {
	
	public ProcessObjectImpl() {
		processInitialConfiguration();
	}
	
	private void processInitialConfiguration() {
		System.out.println("loading initial configuration");
		
	}

	@Override
	public void process() {
		System.out.println("process completed");
	}

}
