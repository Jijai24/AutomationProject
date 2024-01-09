package practice;

public class GenericMethodsPractice {

	public static void main(String[] args) {  //caller
		
		//hard Coded
	/*	int a=20;
		int b=30;
		int c=a+b;
		System.out.println(c); */
		
		add(10,80,10);
		int sum = add(30,40,20);
		System.out.println(sum);
			}
	
	//Generic Method / Reusable Method
	
	public static int add (int a, int b,int d) //called
	{
		
		int c=a+b+d; 
		return c;
	}

}
