import java.util.Vector;
import java.util.Random;
import java.util.Iterator;
import java.util.Enumeration;
class Employee{
	private String empName, empNo;
	Employee(String ename, String empno){
		empName = ename;
		empNo = empno;
	}
	void dispEmpData(){
		System.out.println("Name: " + empName + "\tNo: " + empNo);
	}
}
class MyVectorDemo{
	public static void main(String[] args){
		Vector <Employee> o1 = new Vector <Employee>();
		Random r = new Random();
		for(int i=0;i<r.nextInt(20)+1;i++){
			int n = r.nextInt(100)+1;
			o1.add(new Employee("Name " + n, "Empno " + n));
		}
		System.out.println("Using Iterator: ");
		Iterator <Employee> itr = o1.iterator();
		while(itr.hasNext())
			itr.next().dispEmpData();
		System.out.println("\nUsing ENumeration: ");
		Enumeration <Employee> enum1 = o1.elements();
		while(enum1.hasMoreElements())
			enum1.nextElement().dispEmpData();
	}
}