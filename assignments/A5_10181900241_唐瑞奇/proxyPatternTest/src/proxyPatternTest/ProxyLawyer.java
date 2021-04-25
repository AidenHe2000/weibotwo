package proxyPatternTest;

public class ProxyLawyer implements Lawsuit{
	private Prosecutor client;
	
	public ProxyLawyer(Prosecutor client) {
        this.client = client;
    }

    public void submit() {
    	client.submit();
    }

    public void burden() {
    	client.burden();
    }

    public void defend() {
    	client.defend();
    }

    public void finish() {
    	client.finish();
    }
}
