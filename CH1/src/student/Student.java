package student;

public class Student {
	String name;
	int age;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String show(String name,int age){
		return "ĞÕÃû£º"+name+"£¬ÄêÁä£º"+age;
	}
}
