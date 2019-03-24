package hw;

import java.awt.Graphics;

public class PolygonDyn extends Polygon {
	
	private Point2D[] arr;   
    
	public PolygonDyn(){
        arr=new Point2D[1];
        arr[0].x=0;
        arr[0].y=0;
    }
	
	public PolygonDyn(Rectangle rec){

	    arr=new Point2D[4];
	    arr[0].size=4;
	    arr[0].x=rec.getcur_x();
	    arr[0].y=rec.getcur_y();

	    arr[1].x=rec.getcur_x()+rec.getwidth();
	    arr[1].y=rec.getcur_y();

	    arr[3].x=rec.getcur_x();
	    arr[3].y=rec.getcur_y()+rec.getheight();

	    arr[2].x=rec.getcur_x()+rec.getwidth();
	    arr[2].y=rec.getcur_y()+rec.getheight();

	}
	
	public PolygonDyn(Triangle tri){

	    arr=new Point2D[3];
	    arr[0].size=3;
	    arr[0].x=tri.getcoor1_x();
	    arr[0].y=tri.getcoor1_y();

	    arr[1].x=tri.getcoor2_x();
	    arr[1].y=tri.getcoor1_y();

	    arr[2].x=tri.getcoor3_x();
	    arr[2].y=tri.getcoor3_y();
	}
    
	public PolygonDyn(Circle cir){

	    arr=new Point2D[100];
	    arr[0].size=100;
	    int i;
	    double radian=0;

	    for(i=0;i<100;i++){

	        arr[i].x=cir.getcoor_x()+cir.getradius()*Math.cos(radian);
	        arr[i].y=cir.getcoor_x()+cir.getradius()*Math.sin(radian);
	        radian +=0.062;

	    }
	}
    
    public void Draw(Graphics object){
        int i;
    	int[] coor_x = new int[arr.length];
        int[] coor_y = new int[arr.length];
        for(i=0;i<arr.length;i++){
            coor_x[i] = (int) arr[i].x;
            coor_y[i] = (int) arr[i].y;
        }
        object.drawPolygon(coor_x,coor_y,arr.length);
    }

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
    
   

}