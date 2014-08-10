/**
 * 1. The getInstance() method is STATIC!!!
 * 2. The constructor Singleton() is PRIVATE!!!
 */
package designpattern;

public class Singleton {
	private static Singleton instance = null;
	private int data;

	private Singleton(int data) {
		this.data = data;
	}

	public static Singleton getInstance(int data) {
		if (instance == null) {
			instance = new Singleton(data);
		}

		return instance;
	}

	public void printData() {
		System.out.println("Data: " + this.data);
	}

	public static void main(String[] args) {
		Singleton s1 = Singleton.getInstance(0);
		Singleton s2 = Singleton.getInstance(1);
		Singleton s3 = Singleton.getInstance(2);

		s1.printData();
		s2.printData();
		s3.printData();
	}
}
