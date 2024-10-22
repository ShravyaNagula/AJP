import java.util.Iterator; 
import java.util.Random; 
import java.util.Set; 
import java.util.TreeMap;
public class MyTreeMapDemo{ 
	public static void main(String args[]){
		TreeMap<Integer, Integer> tm = new TreeMap<Integer, Integer>(); 
		Random r = new Random();
		System.out.println("Treemap Empty(initially): "+tm.isEmpty()); 
		for(int i=0;i<10;i++){
			int k = r.nextInt(20)+1; 
			int v = r.nextInt(100)+1; 
			tm.put(k, v);
		}
		System.out.println("Treemap Size after putting (keys,values): " + tm.size()); 
		System.out.println("Values of TreeMap are: ");
		Set<Integer> ks = tm.keySet(); 
		Iterator<Integer> it = ks.iterator(); 
		int k =1;
		while(it.hasNext()){ 
			k = it.next();
			System.out.println(k + "->" + tm.get(k));
		}
		tm.replace(k, 0);
		System.out.println("Values of TreeMapare(after replacing last key's value): "); 
		Iterator<Integer> it1 = ks.iterator();
		for(;it1.hasNext();){ 
			k = it1.next();
			System.out.println(k + "->" + tm.get(k));
		}
		tm.remove(k);
		System.out.println("After removinf last key, The TreeMap is:"+tm); 
		System.out.println("After invoking clear() method:");
		tm.clear();
		System.out.println("Treemap Size: "+tm.size());
	}
}