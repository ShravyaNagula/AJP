import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
public class MyArrayListDemo{
	public static void main(String[] args){
		ArrayList<Integer> o1 = new ArrayList<Integer>();
		System.out.println("ArrayList Empty: " + o1.isEmpty());
		for(int i=1;i<=new Random().nextInt(20)+1;i++)
			o1.add(i);
		System.out.println("ArrayList Empty(after adding elements): " + o1.isEmpty());
		System.out.println("ArrayList Size: " + o1.size());
		System.out.println("ArrayList Elements: ");
		for(int i=0;i<o1.size();i++)
			System.out.print(o1.get(i) + " ");
		System.out.println();
		Integer v2 = o1.remove(new Random().nextInt(o1.size()));
		System.out.println("The removed element is " + v2);
		System.out.println("ArrayListelements(After removing one element: ");
		for(int i=0;i<o1.size();i++)
			System.out.print(o1.get(i) + " ");
		System.out.println("");
		Integer v1 = 5;
		o1.set(0, v1);
		Iterator it = o1.iterator();
		System.out.println("ArrayList elements after updating first element(using iterator): ");
		while(it.hasNext())
			System.out.print(it.next() + " ");
	}
}	
	