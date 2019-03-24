package hw;

import java.awt.Graphics;

public class Rectangle implements Shape {
	
	private double height;
	private double width;
	private double cur_x;
	private double cur_y;
	
	public Rectangle() {
		setrectangle(0,0);
	}
	
	public Rectangle(double x, double y) {
		setrectangle(x,y);
	}
	
	void setrectangle(double x,double y) {
		
		width=x; height=y; 
	}
	
	public void setx(double x){ cur_x=x; };
	public void sety(double y){ cur_y=y; };
	
	public double getwidth(){ return width;}
    public double getheight(){ return height;}
    public double getcur_x(){ return cur_x;}
    public double getcur_y(){ return cur_y;}

	@Override
	public double area() {
		return width*height;
	}

	@Override
	public double perimeter() {
		return 2*width+2*height;
	}

	@Override
	public void increment() {
		cur_x++; cur_y++;		
	}

	@Override
	public void decrement() {
		cur_x--; cur_y--;		
	}

	@Override
	public void draw(Graphics object) {
		object.drawRect((int)cur_x,(int)cur_y,(int)width,(int)height);
		
	}

	@Override
	public boolean Comparable(Shape object) {
		if(this.area()==object.area()) return true;
		return false;
	}
	
}
