package proxypattern;

public class ProxyMain {

	public static void main(String[] args) {
		ProcessObject p=new ProcessObjectProxy();
		p.process();
		p.process();
	}

}
