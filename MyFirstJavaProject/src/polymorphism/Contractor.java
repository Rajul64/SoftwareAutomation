package polymorphism;

public class Contractor extends Employee {
	
	@Override
	int salary()
	{
		return base + 10000; // salary of the contractor is 10000+10000 = 20000
	}
	
	static String designation()
	{
		return "Contractor";
	}

}
