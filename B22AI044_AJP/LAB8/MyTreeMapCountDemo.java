import java.util.TreeMap;
import java.util.Random;
import java.util.Iterator;
import java.util.Set;
public class MyTreeMapCountDemo{
	public static void main(String[] args){
		Random r = new Random();
		int n = r.nextInt(100) + 1;
		int a[] = new int[n];                
		for(int i=0; i<n; i++)
			a[i] = r.nextInt(20);
		TreeMap<Integer, Integer>tm = new TreeMap<Integer, Integer>();
		for(int i=0; i<n; i++){
			int k = a[i];
			if(tm.containsKey(k)){
				int v = tm.get(k);
				++v;
				tm.replace(k, v);
			}
			else
				tm.put(k, 1);
		}
		System.out.println("Array values are: ");
		for(int i=0; i<n; i++)
			System.out.print(a[i] + " ");
		System.out.println();
		System.out.println("Values of TreeSet are: ");
		Set<Integer>ks = tm.keySet();
		Iterator<Integer>it = ks.iterator();
		while(it.hasNext()){
			int k = it.next();
			System.out.println(k + "->" + tm.get(k));
		}
	}
}