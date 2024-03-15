package myInterface;

interface Shape {
	
	int i = 5;      // all the attributes or variables by default public, static and final in nature
	
	// all the methods by default abstract or public in nature
	String color(); 
	double area();
	String info();
	
	
	static void staticMethod()  // static method can not be override by subclass
	{
		System.out.println("Static Method");
	}

}
