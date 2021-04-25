package observerPatternTest;

//观察者模式
//选课系统中某一课程已选人数是否达到上限
//选课系统(某一课程)为Publisher，学生为Subscriber

public class ObserverPatternTese {
	public static void main(String[] args) {
		Lesson lesson001 = new Lesson("lesson001");
		
		new Student(lesson001, "Ricky");
		new Student(lesson001, "Lily");
		
		lesson001.setState(false);
		lesson001.setState(true);
	}
}


