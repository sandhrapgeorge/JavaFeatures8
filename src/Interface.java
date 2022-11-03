class RectCircle {
	double x, y;

	RectCircle(final double x) {
		this.x = x;
	}

	RectCircle(final double x, final double y) {
		this.x = x;
		this.y = y;
	}
}

interface Area {
	double pi = 3.14;

	double computeRect();

	static void display() {
		System.out.println("inside interface static method");

	} // java interface static method is visible to interface methods only

	default void display2() {
		System.out.println("inside interface default method");
	}

	double computeCir();
}

class ShapeArea extends RectCircle implements Area {
	ShapeArea(final double x) {
		super(x);
	}

	ShapeArea(final double x, final double y) {
		super(x, y);
	}

	@Override
	public double computeRect() {
		return (x * y);
	}

	@Override
	public double computeCir() {
		return (pi * x * x);
	}

	// @Override
	// @Override
	public void display1() {
		System.out.println("inside child method");
	}
}

public class Interface {

	public static void main(final String[] args) {
		// Area calculation of Rectangle
		final int l = 5;
		final int b = 6;
		final ShapeArea s1 = new ShapeArea(l, b);
		final double area = s1.computeRect();
		System.out.println("The area of Rectangle is " + area);

		// Area calculation of Circle

		final int r = 9;
		final ShapeArea s2 = new ShapeArea(r);
		final double area1 = s2.computeCir();
		System.out.println("The area of Circle is " + area1);
		// s2.display();
		s2.display2();
		Area.display();

	}

}
