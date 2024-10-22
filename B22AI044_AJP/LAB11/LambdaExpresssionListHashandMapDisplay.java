import java.util.ArrayList;
import java.util.HashMap;
class LambdaExpresssionListHashandMapDisplay{
	public static void main(String args[]){
		ArrayList<Integer> o1 = new ArrayList<Integer>();
		o1.add(10);
		o1.add(20);
		o1.add(30);
		System.out.println("Display of List Elements using Lambda Expression: ");
		o1.forEach((Integer v) -> System.out.print(v + " "));
		HashMap <String, Integer> o2 = new HashMap <String, Integer> ();
		System.out.println();
		o2.put("CSE1", 90);
		o2.put("CSE2", 80);
		o2.put("CSE3", 70);
		System.out.println("Display of Hash Elements using Lambda Expression: ");
		o2.forEach((String k, Integer v) -> System.out.println(k + "->" + v));
	}
}