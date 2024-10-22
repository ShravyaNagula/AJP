import java.util.TreeSet;
import java.util.Random;
import java.util.Iterator;
class Student implements Comparable <Student>{
	private String sName, sRollNo;
	Student(){}
	Student(String Name, String RollNo){
		sName = Name;
		sRollNo = RollNo;
	}
	void dispStudentData(){
		System.out.println("Name: " + sName + " RollNo: " + sRollNo);
	}
	public int compareTo(Student s){
		return sRollNo.compareTo(s.sRollNo);
	}
}
public class MyTreeSetDemo{
	public static void main(String args[]){
		TreeSet<Student>ts = new TreeSet<Student>();
		Random r = new Random();
		int N = r.nextInt(10) + 1;
		for(int i=1; i<=N; i++){
			int n = r.nextInt(100);
			ts.add(new Student("Name" + n, "RollNo" + n));
		}
		Iterator<Student>it = ts.iterator();
		System.out.println("Data present in TreeSet are: ");
		while(it.hasNext())
			it.next().dispStudentData();
	}
}
