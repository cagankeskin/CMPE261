import java.util.Locale;
import java.util.Random;

public class Student {
	//defining the variables
	String fname, lname,lgrade,id;
	int q1,q2,p,m,f;
	double average;
	
	//I only writed the needed get methods.
	public String getId() {
		return id;
	}
	public int getQ1() {
		return q1;
	}
	public int getQ2() {
		return q2;
	}
	public int getP() {
		return p;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getLgrade() {
		return lgrade;
	}
	public void setLgrade(String lgrade) {
		this.lgrade = lgrade;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setQ1(int q1) {
		this.q1 = q1;
	}
	public void setQ2(int q2) {
		this.q2 = q2;
	}
	public void setP(int p) {
		this.p = p;
	}
	public void setM(int m) {
		this.m = m;
	}
	public void setF(int f) {
		this.f = f;
	}
	public void setAverage(double average) {
		this.average = average;
	}
	public int getM() {
		return m;
	}
	public int getF() {
		return f;
	}
	public double getAverage() {
		return average;
	}
	
	//This method generates random name, used for both first and last name.
	public static String nameGen(){
		String name ="";
		Random rgen = new Random();
		int randomInt= rgen.nextInt(6)+3;
		for (int i=0;i<randomInt;i++){
			name=name+(char)(rgen.nextInt(26)+97);
		}
		return name;
	}
	//This method generates ID with random generator.
	public static String idGen(){
		String id="";
		Random rgen = new Random();
		for(int i=0;i<11;i++){
			id=id+Integer.toString(rgen.nextInt(8)+1);
		}
		return id;
		
	}
	//This method generates grade btw 0-100
	public static int gradeGen(){
		Random rgen = new Random();
		return rgen.nextInt(100);
	}
	
	//This method takes average and decides the letter grade.
	public static String letterCalc(double average){
		String lgrade = null;
		if(average<=30) lgrade="F";
		else if (average>=31&&average<=50)lgrade="D";
		else if (average>=51&&average<=60)lgrade="D+";
		else if (average>=61&&average<=65)lgrade="C-";
		else if (average>=66&&average<=70)lgrade="C";
		else if (average>=71&&average<=75)lgrade="C+";
		else if (average>=76&&average<=80)lgrade="B-";
		else if (average>=81&&average<=85)lgrade="B";
		else if (average>=86&&average<=90)lgrade="B+";
		else if (average>=91&&average<=95)lgrade="A-";
		else if (average>=96&&average<=100)lgrade="A";
		return lgrade;
	}
	
	public Student(){
		fname=nameGen();
		fname=fname.substring(0, 1).toUpperCase(Locale.ENGLISH) + fname.substring(1); //This makes first letter uppercase.
		lname=nameGen();
		lname=lname.toUpperCase(Locale.ENGLISH);//This makes the last names all capital.
		id=idGen();
		q1=gradeGen();
		q2=gradeGen();
		p=gradeGen();
		m=gradeGen();
		f=gradeGen();
		average=(q1+q2+p+m+f)/5;
		lgrade=letterCalc(average);
	}
	//I designed this part with if elses because printing the students specifics must be lined.
	public String toString(){
		if (fname.length()==8&&lname.length()==8)return fname+"\t"+lname+"\t"+id+"\t"+q1+"\t"+q2+"\t"+p+"\t"+m+"\t"+f+"\t"+average+"\t"+lgrade;
		else if(fname.length()==8)return fname+"\t"+lname+"\t"+"\t"+id+"\t"+q1+"\t"+q2+"\t"+p+"\t"+m+"\t"+f+"\t"+average+"\t"+lgrade;
		else if (lname.length()==8)return fname+"\t"+"\t"+lname+"\t"+id+"\t"+q1+"\t"+q2+"\t"+p+"\t"+m+"\t"+f+"\t"+average+"\t"+lgrade;
		else return fname+"\t"+"\t"+lname+"\t"+"\t"+id+"\t"+q1+"\t"+q2+"\t"+p+"\t"+m+"\t"+f+"\t"+average+"\t"+lgrade;
	}

}
