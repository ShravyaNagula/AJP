class A<T>{
	T a;
	A(T a1){
		a = a1;
	}
	void showT(){
		System.out.println("a = "+a);
	}
}
class B<T, V> extends A<T>{
	V b;
	B(T a1, V b1){
		super(a1);
		b = b1;
	}
	void showV(){
		super.showT();
		System.out.println("b = "+b);
	}
}
public class GenericsInheritance{
	public static void main(String[] args){
		B<Integer, Double> o1 = new B<Integer, Double>(10, 25.36);
		o1.showV();
	}
}