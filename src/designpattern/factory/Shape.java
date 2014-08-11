/**
 * Code copied from: http://www.tutorialspoint.com/design_pattern/factory_pattern.htm
 */

package designpattern.factory;

public interface Shape {
	// "It is permitted, but discouraged as a matter of style, to redundantly specify the public and/or abstract modifier for a method declared in an interface."
	// See:
	// http://stackoverflow.com/questions/161633/should-methods-in-a-java-interface-be-declared-with-or-without-a-public-access-m
	void draw();
}
