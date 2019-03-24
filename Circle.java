package hw;

import java.awt.Graphics;

public class Circle implements Shape  {

	private static final double PI = 3.14;
	private double radius;
	private double coor_x;
	private double coor_y;
	
	public double getradius(){ return radius;}
    public double getcoor_x(){ return coor_x;}//-----------
    public double getcoor_y(){ return coor_y;}
	
	public Circle() {
		setradius(0);
	}
	
	public Circle(double x){
        setradius(x);
    }
	
	public void setradius(double x){
        radius=x;

    }

    public void setcoor_x(double x){
    	coor_x=x;
	}

	public void setcoor_y(double y){
    	coor_y=y;
	}
    
    @Override
	public double area() {
		
    	return PI*radius*radius;
	}

	@Override
	public double perimeter() {
		return 2*PI*radius;
	}

	@Override
	public void increment() {
		coor_x++; coor_y++;
		
	}

	@Override
	public void decrement() {
		coor_x--; coor_y--;
		
	}

	@Override
	public void draw(Graphics object) {
		object.drawOval((int)coor_x,(int)coor_y,(int)radius*2,(int)radius*2);
		
	}
	@Override
	public boolean Comparable(Shape object) {
		if(this.area()==object.area()) return true;
		return false;
	}

}
