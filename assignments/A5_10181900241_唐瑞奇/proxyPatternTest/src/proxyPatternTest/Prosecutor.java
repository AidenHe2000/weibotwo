package proxyPatternTest;

//起诉人

public class Prosecutor implements Lawsuit {
	public void submit() {
		System.out.println("诉讼提交");
	}
	
	public void burden() {
		System.out.println("进行举证");
	}
	
	public void defend() {
		System.out.println("开始辩护");
	}
	
	public void finish() {
		System.out.println("诉讼完成");
	}
}
