package ws3;
import java.util.ArrayList;
import java.util.Random;

public class Course {
	String courseCode;
	char grade;
	
	public Course(){
		courseCode=generateCourseCode();
		grade=generateGrade();
	}
	
	public String toString(){
		return courseCode+"\t"+"\t"+grade;
	}
	
	public static String generateCourseCode(){
		String name ="";
		Random rgen = new Random();
		for (int i=0;i<3;i++){
			name=name+(char)(rgen.nextInt(25)+65);
		}
		name=name+" ";
		name=name+(rgen.nextInt(400)+100);
		return name;
	}
	
	public static char generateGrade(){
		Random rgen = new Random();
		char grade='E';
		while(grade=='E'){
			grade=(char)(rgen.nextInt(6)+65);
		}
		return grade;
	}
	public static void main(String[] args) {
		ArrayList<Course> cList=new ArrayList<>();
		Random rgen = new Random();
		int random=rgen.nextInt(19)+1;
		for (int i = 0; i <random; i++) {
			cList.add(new Course());
		}
		System.out.println("COURSE CODE"+"\t"+"GRADE");
		System.out.println("------------------------");
		for(Course x:cList){
			System.out.println(x);
		}
		System.out.println("------------------------");
	}
}
