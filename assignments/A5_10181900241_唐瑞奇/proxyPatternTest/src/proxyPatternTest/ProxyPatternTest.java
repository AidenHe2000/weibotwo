package proxyPatternTest;

//代理模式：遇到法律问题起诉时，请律师作为代理诉讼人

public class ProxyPatternTest {

	public static void main(String[] args) {
		Prosecutor prosecutor = new Prosecutor();
		ProxyLawyer proxyLawyer = new ProxyLawyer(prosecutor);
		
		proxyLawyer.submit();
		proxyLawyer.burden();
		proxyLawyer.defend();
		proxyLawyer.finish();
	}

}
