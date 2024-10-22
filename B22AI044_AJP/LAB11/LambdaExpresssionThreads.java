class LambdaExpresssionThreads{
	public static void main(String args[]){
		Runnable o1 = () -> {
			for(int i=1; ; i++){
				if(i%2 == 0)
					System.out.println("i1 = " + i);
				try{
					Thread.currentThread().sleep(500);
				}
				catch(Exception e){}
			}
		};
		Runnable o2 = () -> {
			for(int i=1; ; i++){
				if(i%2 != 0)
					System.out.println("i2 = " + i);
				try{
					Thread.currentThread().sleep(1000);
				}
				catch(Exception e){}
			}
		};
		new Thread(o1).start();
		new Thread(o2).start();
	}
}
