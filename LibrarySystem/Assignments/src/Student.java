package src;

public class Student
{
	private String name;
	private int mark;

	public Student(){
		setName(null);
		setMark(0);
	}

	public Student(String x, int y){
		setName(x);
		setMark(y);
	}

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String toString(){
		
		return getName() + " " + getMark(); 
	}

}