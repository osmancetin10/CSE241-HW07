package hw;

import java.awt.Graphics;

public class Triangle implements Shape {

	private double side;
	private double height;
	private double coor1_x;
	private double coor1_y;
	private double coor2_x;
	private double coor3_x;
	private double coor3_y;
	
	public Triangle() {
		setside(0);
	}
    
	public Triangle(double x){
        setside(x);
    }
	
	public void setcoor(double x1,double y1,double x2,double x3,double y3) {
	
		coor1_x=x1;
		coor1_y=y1;
		coor2_x=x2;
		coor3_x=x3;
		coor3_y=y3;
	}
	
	void setside(double x) {
		
		side=x;
	    height=side*1.73/2;
	    coor1_x=0; coor1_y=0;
	    coor2_x=side;
	    coor3_x=side/2; coor3_y=height;
	}
	
	public double getside(){ return side;}
    public double getheight(){ return height;}
    public double getcoor1_x(){ return coor1_x;}
    public double getcoor1_y(){ return coor1_y;}
    public double getcoor2_x(){ return coor2_x;}
    public double getcoor3_x(){ return coor3_x;}
    public double getcoor3_y(){ return coor3_y;}

	@Override
	public double area() {
		return side*side*1.73/4;
	}

	@Override
	public double perimeter() {
		return side*3;
	}

	@Override
	public void increment() {
		coor1_x++; coor1_y++; coor2_x++; coor3_x++; coor3_y++;
		
	}

	@Override
	public void decrement() {
		 coor1_x--; coor1_y--; coor2_x--; coor3_x--; coor3_y--;
		
	}

	@Override
	public void draw(Graphics g) {
		int[] coords_x = new int[3];
		int[] coords_y = new int[3];
		
		coords_x[0] = (int) coor1_x;
		coords_x[1] = (int) coor2_x;
		coords_x[2] = (int) coor3_x;
		coords_x[0] = (int) coor1_y;
		coords_x[1] = (int) coor1_y;
		coords_x[2] = (int) coor3_y;
		
		g.drawPolygon(coords_x,coords_y,3);
		
	}

	@Override
	public boolean Comparable(Shape object) {
		if(this.area()==object.area()) return true;
		return false;
	}
	
	
	 
}
