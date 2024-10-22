class genClass{
	public static void main(String[] args){
		// initialize generic class with integer data
		GenericsClass<Integer> intObj = new GenericsClass<>(5);
		System.out.println("Generic class returns: "+intObj.getData());
		// initialize generic class with string data
		GenericsClass<String> stringObj = new GenericsClass<>("Java Programmming");
		System.out.println("Generic class returns: "+stringObj.getData());
	}
}
//cretae generic class
class GenericsClass<T>{
	//variable of T type
	private T data;
	public GenericsClass(T data){
		this.data = data;
	}
	//method that retruns T variable
	public T getData(){
		return this.data;
	}
}