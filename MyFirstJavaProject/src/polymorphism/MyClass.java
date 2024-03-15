package polymorphism;

public class MyClass {
	
	public static void main(String[] args)
	{
		Employee e = new FullTime(); // runtime polymorphism - only look for the object type not reference 
		//Child class FullTime object referring to the parent class Employee reference variable
		System.out.println("Full time employee's salary is: "+e.salary());
		
		e = new Contractor();  // runtime polymorphism - only look for the object type not reference
		//Child class contractor object referring to the parent class Employee reference variable
		System.out.println("Contractor employee's salary is: "+e.salary());
		
		FullTime fulltime = new FullTime();
		fulltime.myMethod();
		
		System.out.println(Employee.designation());
		System.out.println(FullTime.designation());
		System.out.println(Contractor.designation());
		
		// Overloading
		MethodOverloadingClass methodOverload = new MethodOverloadingClass();
		methodOverload.myMethod1();
		methodOverload.myMethod1(1, "Rahul");
		methodOverload.myMethod1(2, 3);
		
	}

}
