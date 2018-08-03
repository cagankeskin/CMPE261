import java.util.ArrayList;
import java.util.Scanner;

public class Test {
	private static Scanner input;

	//printList is used for printing grade list.
	public static void printList(ArrayList<Student> x){
		System.out.println("FIRST NAME"+"\t"+"LAST NAME"+"    "+"\t"+"ID"+"\t"+"\t"+"QUIZ1"+"\t"+"QUIZ2"+"\t"+"PROJECT"+"\t"+"MIDTERM"+"\t"+"FINAL"+"\t"+"AVERAGE"+"\t"+"LETTER GRADE");
		System.out.println("-------------------------------------------------------------------------------------------------------------");
		for(Student y:x){
			System.out.println(y);
			System.out.println();
		}
		int q1=0,q2=0,p=0,m=0,f=0,counter=0;
		double avg=1;
		String letter;
		for(Student y:x){
			q1=q1+y.getQ1();
			q2=q2+y.getQ2();
			p=p+y.getP();
			m=m+y.getM();
			f=f+y.getF();
			counter++;
		}
		if(counter!=0) {
			q1=q1/counter;q2=q2/counter;p=p/counter;m=m/counter;f=f/counter;
			avg=(q1+q2+p+m+f)/5;
			letter=Student.letterCalc(avg);
			System.out.println();
			System.out.println("\t"+"\t"+"\t"+"\t"+"AVERAGE:"+"\t"+q1+"\t"+q2+"\t"+p+"\t"+m+"\t"+f+"\t"+avg+"\t"+letter);
		}

		System.out.println("-------------------------------------------------------------------------------------------------------------");
	}
	//addStudent is used for add student(s) with specific quantity to list.
	public static void addStudent(ArrayList<Student> sList,int x){
		for(int i=0;i<x;i++){
			sList.add(new Student());
		}
	}
	//removeStudent is used for remove specific student with ID.
	public static void removeStudent(ArrayList<Student> sList,String id){
		int found=0;
		for(int i=0;i<sList.size();i++){
			if(sList.get(i).getId().equals(id)){
				System.out.println("Student with ID "+id+" is deleted.");
				sList.remove(i); found=1; break;
			}
		}
		if(found==0){System.out.println("No such student is found.");}
	}
	
	//clearList is used for clear all students in the list.
	public static void clearList(ArrayList<Student> sList){
		sList.clear();
	}
	
	 // This is the main method of program. args[0] is used to generate student list.
	public static void main(String[] args) {
		input = new Scanner(System.in);
		ArrayList<Student> sList=new ArrayList<>();
		addStudent(sList, Integer.parseInt(args[0]));
		System.out.println(args[0]+" students are generated.");
		
		while(true){//to make infity loops.
			System.out.println();
			System.out.println(	"Enter 1 to add student(s)."+System.lineSeparator()+
								"Enter 2 to remove student."+System.lineSeparator()+
								"Enter 3 to see the grade list."+System.lineSeparator()+
								"Enter 4 to clear the grade list."+System.lineSeparator()+
								"Enter 5 to exit." );
			int x=input.nextInt();
			if(x<1||x>5){ System.out.println("Invalid selection."); continue;}//to make continue program even the selection is incorrect.
			else if(x==1){
				System.out.println("Enter how many student you want to add.");
				int toAdd=input.nextInt();
				addStudent(sList, toAdd);
				System.out.println(toAdd+" students are added. Total number of student is : "+sList.size());
			}
			else if(x==2){
				System.out.println("Enter the ID of the student you want to remove from the list.");
				input.nextLine();
				String id=input.nextLine();
				removeStudent(sList, id);
			}
			else if(x==3){
				printList(sList);
			}
			else if(x==4){
				clearList(sList);
				System.out.println("Student list is cleared.");
			}
			else if(x==5){
				break;
			}
		}
		System.out.println("Bye!");
	}
}
