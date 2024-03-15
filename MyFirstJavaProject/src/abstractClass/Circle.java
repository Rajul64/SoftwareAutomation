package abstractClass;

public class Circle extends shapes {
	
	double radius;
	
	public Circle(String color, double radius)
	{
		super(color);
		this.radius = radius;
	}

	@Override
	double area() {
		return Math.PI * Math.pow(radius, 2);
	}

	@Override
	String info() {
		return "I'm a " + super.color + " Circle and my are is: " +area();
	}

}
