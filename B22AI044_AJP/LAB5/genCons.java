class Gen<T>{
	T obj;
	Gen(T obj1){
		obj = obj1;
	}
	void disp(){
		System.out.println("obj = "+obj);
	}
	void showType(){
		System.out.println("Type of T: "+obj.getClass().getName());
	}
}
public class genCons{
	public static void main(String[] args){
		Gen<Double> a = new Gen<Double>(10.3);
		a.disp();
		a.showType();
	}
}