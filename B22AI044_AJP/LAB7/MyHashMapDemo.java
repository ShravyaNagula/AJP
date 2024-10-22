import java.util.HashMap; 
import java.util.Random; 
import java.util.Set; 
import java.util.Iterator; 
class MyHashMapDemo{
	public static void main(String[] args){
		HashMap<Integer, Integer>hm = new HashMap<Integer, Integer>(); 
		Random r = new Random();
		int n = r.nextInt(20) + 1;
		for(int i=1; i<=n;i++){ 
			int k = r.nextInt(20);
			int v = r.nextInt(100); 
			hm.put(k, v);
		}
		Set<Integer> s = hm.keySet(); 
		Iterator<Integer>it = s.iterator();
		System.out.println("size of HashMap: " + hm.size()); 
		System.out.println("Elements of HashMap are: "); 
		while(it.hasNext()){
			int key = it.next();
			System.out.println(key + "->" + hm.get(key));
		}
		it = s.iterator(); 
		int key = 1;
		while(it.hasNext())
			key = it.next();
		System.out.println("Key: " + key + " removed value is: " + hm.remove(key)); 
		it = s.iterator();
		System.out.println("Elements of HashMap after remove areas: "); 
		while(it.hasNext()){
			key = it.next();
			System.out.println(key + "->" + hm.get(key));
		}
		System.out.println("Size of HashMap is: " + hm.size());
		if(hm.containsKey(key))
			System.out.println(key + " is present in HashMap"); 
		else
			System.out.println(key + " is not present in HashMap");
	}
}
