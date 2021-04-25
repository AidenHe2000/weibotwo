package proxyPatternTest;

//����ģʽ������������������ʱ������ʦ��Ϊ����������

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
