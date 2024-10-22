import java.util.LinkedList;
import java.util.Iterator;
import java.util.Random;
public class MyLinkedListDemo{
	public static void main(String[] args){
		LinkedList<Integer> ll1 = new LinkedList<Integer>();
		for(int i=1;i<=10;i++)
			ll1.add(new Random().nextInt(100)+1);
		System.out.println("LinkedList print using reference: " + ll1);
		System.out.println("getFirst: " + ll1.getFirst());
		System.out.println("LinkedList print using reference: " + ll1);
		System.out.println("removeFirst: " + ll1.removeFirst());
		System.out.println("LinkedList print using reference: " + ll1);
		ll1.addLast(100);
		System.out.println("LinkedList print using reference(After addLast): " + ll1);
		System.out.println("get(3): "+ ll1.get(3));
		System.out.println("peek: "+ ll1.peek());
		System.out.println("LinkedList print using reference: " + ll1);
		System.out.println("element(): " + ll1.element());
		System.out.println("LinkedList print using reference: " + ll1);
		System.out.println("poll(): " + ll1.poll());
		System.out.println("LinkedList print using reference: " + ll1);
		System.out.println("remove(): " + ll1.remove());
		System.out.println("LinkedList print using reference: " + ll1);
		ll1.push(150);
		System.out.println("LinkedList print using reference: " + ll1);
		System.out.println("pop(): " + ll1.pop());
		System.out.println("LinkedList print using reference: " + ll1);
		System.out.println("LL display using Iterator");
		Iterator it = ll1.descendingIterator();
		for(;it.hasNext();)
			System.out.print(it.next() + " ");
		System.out.println();
		System.out.println("The linked list elements are: ");
		for(int i:ll1)
			System.out.print(i + " ");
	}
}	