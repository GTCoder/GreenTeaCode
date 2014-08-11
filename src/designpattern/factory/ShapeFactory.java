/**
 * "Deal with the problem of creating objects without specifying the exact class of object that will be created. 
 * This is done by creating objects via a factory method, which is either 
 *     1) specified in an interface (abstract class) and implemented in implementing classes (concrete classes); 
 *     2) or implemented in a base class (optionally as a template method), which can be overridden when inherited in derived classes; rather than by a constructor."
 * "
 * Above copied from Wiki: http://en.wikipedia.org/wiki/Factory_method_pattern
 * 
 * Code copied from: http://www.tutorialspoint.com/design_pattern/factory_pattern.htm
 */
package designpattern.factory;

public class ShapeFactory {
	public Shape getShape(String shapeType) {
		if (shapeType == null) {
			return null;
		}

		if (shapeType.equalsIgnoreCase("circle")) {
			return new Circle();
		} else if (shapeType.equalsIgnoreCase("rectangle")) {
			return new Rectangle();
		} else if (shapeType.equalsIgnoreCase("square")) {
			return new Square();
		} else {
			return null;
		}
	}

	public static void main(String[] args) {
		ShapeFactory shapeFactory = new ShapeFactory();

		// get an object of Circle and call its draw method.
		Shape shape1 = shapeFactory.getShape("CIRCLE");

		// call draw method of Circle
		shape1.draw();

		// get an object of Rectangle and call its draw method.
		Shape shape2 = shapeFactory.getShape("RECTANGLE");

		// call draw method of Rectangle
		shape2.draw();

		// get an object of Square and call its draw method.
		Shape shape3 = shapeFactory.getShape("SQUARE");

		// call draw method of circle
		shape3.draw();
		
//		<Output>
//		Inside Circle::draw() method.
//		Inside Rectangle::draw() method.
//		Inside Square::draw() method.
	}
}
