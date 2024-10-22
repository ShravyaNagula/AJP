import java.util.ArrayList;
import java.util.Iterator;
import java.util.Collections;
import java.util.Comparator;
class Student implements Comparator <Student>{
	private String sName, sRollNo;
	Student(){}
	Student(String Name, String RollNo){
		sName = Name;
		sRollNo = RollNo;
	}
	void dispData(){
		System.out.println("Name: " + sName + " RollNo: " + sRollNo);
	}
	public int compare(Student s1, Student s2){
		return s1.sName.compareTo(s2.sName);
	}
}
public class MyArrayListUserDefinedComparatorSort{
	public static void main(String[] args){
		ArrayList<Student> o = new ArrayList<>();
		o.add(new Student("Name" + 10, "RollNo" + 10));
		o.add(new Student("Name" + 20, "RollNo" + 20));
		o.add(new Student("Name" + 1, "RollNo" + 1));
		o.add(new Student("Name" + 15, "RollNo" + 15));
		Iterator<Student>it = o.iterator();
		System.out.println("ArrayList values before sort: ");
		while(it.hasNext())
			it.next().dispData();
		Collections.sort(o, new Student());
		System.out.println();
		System.out.println("ArrayList values after sort: ");
		it = o.iterator();
		while(it.hasNext())
			it.next().dispData();
	}
}
