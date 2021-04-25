package observerPatternTest;

public class Student extends Observer{
	private String name;
	
	public Student(Lesson lesson, String name) {
		this.lesson = lesson;
		this.lesson.attach(this);
		this.name = name;
	}
	
	@Override
	public void update() {
	   if(lesson.getState()==true)
		   System.out.println(name + " : this course is available.");
	   else
		   System.out.println(name + " : this course is full.");
	}
}
