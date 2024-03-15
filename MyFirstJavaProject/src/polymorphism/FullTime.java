package polymorphism;

public class FullTime extends Employee{
	
	@Override
	int salary()
	{
		return base + 20000;  // salary of the full time employee is 10000+20000 = 30000
	}
	
	void myMethod()
	{
		
	}
	
	static String designation()
	{
		return "FullTime";
	}

}
