import java.util.ArrayList;
import java.util.Iterator;
import java.util.Collections;
public class MyArrayListIntegerSort{
	public static void main(String[] args){
		ArrayList<Integer>o = new ArrayList<Integer>();
		o.add(10);
		o.add(20);
		o.add(1);
		o.add(15);
		Iterator it = o.iterator();
		System.out.println("ArrayList values before sort: ");
		while(it.hasNext())
			System.out.print(it.next() + " ");
		Collections.sort(o);
		System.out.println();
		System.out.println("ArrayList values after sort: ");
		it = o.iterator();
		while(it.hasNext())
			System.out.print(it.next() + " ");
	}
}
