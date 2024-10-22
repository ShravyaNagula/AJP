import java.util.ArrayList;
import java.util.Iterator;
import java.util.Collections;
class Student implements Comparable <Student>{
	private String sName, sRollNo;
	Student(String Name, String RollNo){
		sName = Name;
		sRollNo = RollNo;
	}
	void dispData(){
		System.out.println("Name: " + sName + " RollNo: " + sRollNo);
	}
	public int compareTo(Student s){
		return sRollNo.compareTo(s.sRollNo);
	}
}
public class MyArrayListUserDefinedSort{
	public static void main(String[] args){
		ArrayList<Student> o = new ArrayList<Student>();
		o.add(new Student("Name" + "hhh", "RollNo" + 20));
		o.add(new Student("Name" + "mmm", "RollNo" + 1));
		o.add(new Student("Name" + "aaa", "RollNo" + 15));
		o.add(new Student("Name" + "rrr", "RollNo" + 10));
		Iterator<Student> it = o.iterator();
		System.out.println("ArrayList values before sort: ");
		while(it.hasNext())
			it.next().dispData();
		Collections.sort(o);
		System.out.println();
		System.out.println("ArrayList values after sort: ");
		it = o.iterator();
		while(it.hasNext())
			it.next().dispData();
	}
}