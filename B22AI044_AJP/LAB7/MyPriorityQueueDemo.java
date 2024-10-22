import java.util.PriorityQueue;
import java.util.Random;
import java.util.Iterator;
public class MyPriorityQueueDemo{
	public static void main(String args[]){
		PriorityQueue<Integer>pq = new PriorityQueue<Integer>();
		int n = new Random().nextInt(10) + 1;
		for(int i=0; i<n; i++){
			int n1 = new Random().nextInt(100);
			System.out.print(n1 + " "); 
			pq.add(n1);
		}
		System.out.println("\nPrioirity queue: " + pq);
		Iterator <Integer> it = pq.iterator();
		System.out.println("\nValues of priority queue using Iterator");
		while(it.hasNext())
			System.out.print(it.next() + " ");
		System.out.println("\nBefore offer size: " + pq.size()); 
		Integer v1 = 115;
		System.out.println("peek: " + pq.offer(v1)); 
		it = pq.iterator();
		System.out.println("Elements of priority queue using Iterator after offer"); 
		while(it.hasNext())
			System.out.print(it.next() + " ");	
		System.out.println("\nAfter offer size: " + pq.size()); 
		while(pq.size() > 0){
			Integer i1 = pq.peek(); 
			System.out.print(i1 + " "); 
			pq.remove(i1);
		}
		System.out.println("\nSize of PQ: " + pq.size()); 
	}
}
