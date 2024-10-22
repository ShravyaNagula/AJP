interface If1{ 
	double fun1();
}
interface If2{ 
	long fact(int n);
}
interface If3{ 
	long mult(int x, int y);
}
class LambdaExpresssionParametersDemo{
	public static void main(String[] args){
		If1 o1 = () -> 10.2;
		System.out.println("Lambda expression without parameters: " + o1.fun1());
		If2 o2 = (int n) -> {
			if(n < 0)
				return -1;
			else if (n == 0)
				return 1;
			else{
				long prod = 1;
				for(int i=1; i<=n; i++)
					prod *= i;
				return prod;
			}
		};
		System.out.println("Lambda expression with one parameter: ");
		System.out.println("Factorial of 4: " + o2.fact(4));
		System.out.println("Factorial of 5: " + o2.fact(5));
		If3 o3 = (int x, int y) -> {
			return x*y;
		};
		System.out.println("lambda expression with more than one parameter: " );
		System.out.println("product of 4 and 5 is: " + o3.mult(4,5));
	}
}
