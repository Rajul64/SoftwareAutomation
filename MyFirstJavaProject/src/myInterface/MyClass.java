package myInterface;

public class MyClass {

	public static void main(String[] args) {
		
		Circle circle = new Circle("Red", 4.0);
		System.out.println(circle.info());
		
		Square square = new Square("Blue", 8.5);
		System.out.println(square.info());
		
		Shape.staticMethod();
		System.out.println(Shape.i);
		

	}

}
