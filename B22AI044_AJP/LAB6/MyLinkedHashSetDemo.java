import java.util.*;
public class MyLinkedHashSetDemo{
	public static void main(String[] args){
		LinkedHashSet <String> o1 = new LinkedHashSet <String>();
		o1.add("Ravi");
		o1.add("Vijay");
		o1.add("Ravi");
		o1.add("Ajay");
		Iterator <String> itr = o1.iterator();
		while(itr.hasNext())
			System.out.println(itr.next());
		String z[] = new String[o1.size()];
		o1.toArray(z);
		System.out.println("LinkedHashSet elements in reverse order: ");
		for(int i=z.length-1;i>=0;i--)
			System.out.println(z[i] + " ");
	}
}