package hw;

import java.awt.Graphics;

public abstract class Polygon {
	
	public abstract void Draw(Graphics object);
    public abstract int size();
    
    public class Point2D{

        public double x;
        public double y;
        public int size;
    };

}
