package observerPatternTest;

//�۲���ģʽ
//ѡ��ϵͳ��ĳһ�γ���ѡ�����Ƿ�ﵽ����
//ѡ��ϵͳ(ĳһ�γ�)ΪPublisher��ѧ��ΪSubscriber

public class ObserverPatternTese {
	public static void main(String[] args) {
		Lesson lesson001 = new Lesson("lesson001");
		
		new Student(lesson001, "Ricky");
		new Student(lesson001, "Lily");
		
		lesson001.setState(false);
		lesson001.setState(true);
	}
}


