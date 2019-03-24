package hw;

import java.awt.Graphics;


public interface Shape {

	public double area();
	public double perimeter();
	public void increment();
	public void decrement();
	public void draw(Graphics object);
	public boolean Comparable(Shape object);
	
	
}
