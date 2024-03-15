package test;

public class MyClass {
	
	enum mychar{
	
		A,
		B
	}
	// fields - parameters - variables - int, float, double, boolean, String
	// constructor
	//methods
	
	int i = 4; //class level variable or instance variable
	String str = "Hello World";
	
	public MyClass() {
//		i = 4;
	}
	
//	public MyClass(int i) { // pass the argument as int i - method level variable
//		this.i = i;
//	}
	
	/*
	 * public MyClass(int i, int j) { // pass the argument as int i, int j - method
	 * level variable this.i = i; this.j = j; }
	 */
	
	public static void main(String[] args) //main method is always static
	{
		MyClass myclass = new MyClass(); // it will reset the previous variables values
		System.out.println(myclass.initilize().i);		
		System.out.println(myclass.str);
		System.out.println(MyConstants.Long_Wait);
		System.out.println(EnumConstants.Sunday);
		myclass.StringCheck();
		myclass.ifelseCheck();
		myclass.forLoopCheck();
		myclass.forEachLoop();
		myclass.WhileLoopCheck();
		myclass.switchCaseCheck();
		
	}
	
	public void StringCheck() {
		System.out.println(str.concat(" !!"));
		System.out.println(str.toUpperCase());
		System.out.println(str.toLowerCase());
		String Str = str.substring(6,11);
		System.out.println(Str);
		boolean flag = Str.equalsIgnoreCase("World");
		System.out.println(flag);
		
		Str = "6";
		i = Integer.parseInt(Str);
		System.out.println(i);
		
		i = 8;
		str = String.valueOf(i);
		System.out.println(str);
		
	}
	
	public void ifelseCheck()
	{
		boolean flag = true;
		String str = "mystr";
		
		if(str.equalsIgnoreCase("mystr") || flag)
		{
			System.out.println("I'm in if");
		}
		else
		{
			System.out.println("I'm in else");
		}
	}
	
	public void forLoopCheck()
	{
		for(int i=0; i<5; i++)
		{
			System.out.println(i);
			if(i==3)
			{
				break;
			}
		}
	}
	
	public void forEachLoop()
	{
		String [] arr = {"a","b","c"};
		
		for(String str:arr)
		{
			System.out.println(str);
			if(str.equalsIgnoreCase("b"))
			{
				break;
			}
		}
	}
	
	public void WhileLoopCheck()
	{
		i = 5;
		
		while(i>0)
		{
			System.out.println(i--);
			if(i==3)
			{
			break;
			}
		}
	}
	
	public void switchCaseCheck()
	{
		String str = "c";
		mychar newchar = mychar.B;
		
		switch(newchar) {
		case A:
			System.out.println(newchar);
			break;
		case B:
			System.out.println(newchar);
			break;
//		default:
//		System.out.println(str);
		}
	}
	
	public MyClass initilize()
	{
		i = 9;
//		return i;
		return this;
	}

}
