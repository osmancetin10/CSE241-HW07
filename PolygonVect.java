package hw;
import java.awt.Graphics;
import java.util.ArrayList;

public class PolygonVect extends Polygon {

	private ArrayList<Point2D> vec;	
	
	public PolygonVect(){
		Point2D temp=new Point2D();
		vec= new ArrayList<>();		
		temp.x=0;
		temp.y=0;
	    vec.add(temp);
	}
	
	public PolygonVect(Rectangle rec){
		Point2D temp1=new Point2D();
		Point2D temp2=new Point2D();
		Point2D temp3=new Point2D();
		Point2D temp4=new Point2D();
		vec= new ArrayList<>();		
		
	    
	    
		temp1.x=rec.getcur_x();
	    temp1.y=rec.getcur_y();

	    temp2.x=rec.getcur_x()+rec.getwidth();
	    temp2.y=rec.getcur_y();

	    temp3.x=rec.getcur_x();
	    temp3.y=rec.getcur_y()+rec.getheight();

	    temp4.x=rec.getcur_x()+rec.getwidth();
	    temp4.y=rec.getcur_y()+rec.getheight();
	    
	    vec.add(temp1);
	    vec.add(temp2);
	    vec.add(temp3);
	    vec.add(temp4);
	    

	}
	
	public PolygonVect(Triangle tri){

		Point2D temp1=new Point2D();
		Point2D temp2=new Point2D();
		Point2D temp3=new Point2D();
		vec= new ArrayList<>();
		
		temp1.x=tri.getcoor1_x();
		temp1.y=tri.getcoor1_y();

		temp2.x=tri.getcoor2_x();
		temp2.y=tri.getcoor1_y();

		temp3.x=tri.getcoor3_x();
		temp3.y=tri.getcoor3_y();
		
		vec.add(temp1);
	    vec.add(temp2);
	    vec.add(temp3);
	}
	
	PolygonVect(Circle cir){

	    int i;
	    double radian=0;
	    Point2D temp1=new Point2D();

	    for(i=0;i<100;i++){

	        temp1.x=cir.getcoor_x()+cir.getradius()*Math.cos(radian);
	        temp1.y=cir.getcoor_x()+cir.getradius()*Math.sin(radian);
	        vec.add(temp1);
	        radian +=0.062;

	    }
	}
	
	public void Draw(Graphics g){
        int i;
        Point2D temp1=new Point2D();
        int[] coor_x = new int[vec.size()];
        int[] coor_y = new int[vec.size()];
        for(i=0;i<vec.size();i++){
            temp1 = vec.get(i);
            coor_x[i]=(int)temp1.x;
            coor_y[i]=(int)temp1.y;
            
        }
        g.drawPolygon(coor_x,coor_y,vec.size());
    }

	@Override
	public int size() {
		
		return vec.size();
	}
	
	
}