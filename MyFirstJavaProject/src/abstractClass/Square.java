package abstractClass;

public class Square extends shapes {
	
	double side;
	
	public Square(String color, double side)
	{
		super(color);
		this.side = side;
	}

	@Override
	double area() {
		return Math.pow(side, 2);
	}

	@Override
	String info() {
		return "I'm a " + super.color + " Side and my area is: " +area();
	}

}
