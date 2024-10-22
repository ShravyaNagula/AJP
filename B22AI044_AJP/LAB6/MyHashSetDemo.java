import java.util.*;
public class MyHashSetDemo{
	public static void main(String[] args){
		HashSet <Integer> hs1 = new HashSet <Integer>();
		System.out.println("HashSet1 empty(initially): " + hs1.isEmpty());
		Random r = new Random();
		for(int i=0;i<r.nextInt(10)+1;i++)
			hs1.add(r.nextInt(100)+1);
		System.out.println("HashSet1: " + hs1);
		System.out.println("HashSet1 size: " + hs1.size());
		System.out.println("HashSet1 using Iterator: ");
		Iterator itr = hs1.iterator();
		for(;itr.hasNext();)
			System.out.print(itr.next() + " ");
		System.out.println("\nHashSet1 contains element 0: "+ hs1.contains(0));
		HashSet <Integer> hs2 = new HashSet <Integer>();
		hs2.addAll(hs1);
		System.out.println("New HashSet2 after adding elements HashSet1: " + hs2);
		System.out.println("HashSet2 after invoking clear() method: ");
		hs2.clear();
		for(Integer v1 : hs2)
			System.out.println(v1 + " ");
	}
}