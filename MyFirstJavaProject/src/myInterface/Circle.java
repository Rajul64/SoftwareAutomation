package myInterface;

public class Circle implements Shape{
	
	double radius;
	String color;
	
	public Circle(String color, double radius) {
		this.radius = radius;
		this.color = color;
	}

	@Override
	public String color() {
		return color;
	}

	@Override
	public double area() {
		return Math.PI * Math.pow(radius, 2);  // formula = Pi * r2
	}

	@Override
	public String info() {
		return "I'm a " + color() + " Circle and my area is: " + area();
	}

}
