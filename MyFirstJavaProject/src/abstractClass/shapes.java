package abstractClass;

abstract class shapes {
	
	String color;

	public shapes(String color) //constructor of the shapes class
	{
		this.color = color;
	}
	
	abstract double area(); // abstract methods
	abstract String info();
	
	public String getColor() {  // regular method
		return color;
	}

}
