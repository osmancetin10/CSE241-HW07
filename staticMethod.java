package hw;

import java.awt.Graphics;

public class staticMethod {
	
	public void drawAll(Shape[] shapes, int length, Graphics object){
        int i;
		for(i=0;i<length;i++){
            shapes[i].draw(object);
        }
    }
	
	public Polygon[] convertAll(Shape[] shapes, int length){
        int i;
		PolygonVect[] newvect = new PolygonVect[length];
        for(i=0;i<length;i++){
            if(shapes[i] instanceof Circle)
            newvect[i] = new PolygonVect(((Circle) shapes[i]));
            else if(shapes[i] instanceof Rectangle)
            	newvect[i] = new PolygonVect(((Rectangle) shapes[i]));
            else if(shapes[i] instanceof Triangle)
            	newvect[i] = new PolygonVect(((Triangle) shapes[i]));
        
        }
        return newvect;
    }

}
