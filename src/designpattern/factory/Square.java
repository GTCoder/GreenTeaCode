/**
 * Code copied from: http://www.tutorialspoint.com/design_pattern/factory_pattern.htm
 */

package designpattern.factory;

public class Square implements Shape {
	   @Override
	   public void draw() {
	      System.out.println("Inside Square::draw() method.");
	   }
	}
