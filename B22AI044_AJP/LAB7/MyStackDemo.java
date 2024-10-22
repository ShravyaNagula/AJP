import java.util.Stack;
import java.util.Random;
import java.util.Iterator;
class MyStackDemo{
	public static void main(String[] args){
		Stack <Integer> s = new Stack <Integer>();
		System.out.println("Capacity: " + s.capacity() + " Size: " + s.size() + " Empty: " + s.isEmpty());
		int size = new Random().nextInt(10)+1;
		for(int i=0;i<size;i++)
			s.push(new Random().nextInt(100));
		Iterator <Integer> itr = s.iterator();
		System.out.println("Stack Size: " + s.size());
		while(itr.hasNext())
			System.out.print(itr.next() + " ");
		System.out.println();
		System.out.println("Popped elements are: ");
		while(!s.empty())
			System.out.print(s.pop() + " ");
	}
}