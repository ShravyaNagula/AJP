class Gen<T, V>{
	T ob1;
	V ob2;
	Gen(T obj1, V obj2){
		ob1 = obj1;
		ob2 = obj2;
	}
	T getObj1(){
		return ob1;
	}
	V getObj2(){
		return ob2;
	}
	void showTypeObj1(){
		System.out.println("Type of T: "+ob1.getClass().getName());
	}
	void showTypeObj2(){
		System.out.println("Type of V: "+ob2.getClass().getName());
	}
}
public class genWith2Params{
	public static void main(String[] args){
		Gen<Integer, Double> o1 = new Gen<Integer, Double>(233, 10.5);
		System.out.println(o1.getObj1());
		System.out.println(o1.getObj2());
		o1.showTypeObj1();
		o1.showTypeObj2();
	}
}