package hw;

import java.awt.Graphics;
import java.lang.Math;

public class ComposedShape implements Shape{

	private static final double PI = 3.14;
	private Shape object;
	private Graphics drawing;
	
	@Override
	public double area() {
		return object.area();
	}

	@Override
	public double perimeter() {
		
		return object.perimeter();
	}

	@Override
	public void increment() {
		object.increment();
		
	}

	@Override
	public void decrement() {
		object.decrement();
		
	}

	@Override
	public void draw(Graphics object) {
		this.object.draw(object);
		
	}

	@Override
	public boolean Comparable(Shape object) {
		return this.object.Comparable(object);
	}
		
	public double optimalfit(Triangle tri1,Rectangle rec2){/*this function calculates how much small triangles fits into big triangle and returns residual area*/
		int i,j,counter=0;
		Graphics g = null;
		double side1=tri1.getside(),width2=rec2.getwidth(),height2=rec2.getheight(),height=side1*Math.sqrt(3)/2,line=side1-(2*(height2/Math.sqrt(3))),cur_x,cur_y=0,temp_x=height2/Math.sqrt(3);
		tri1.draw(g);		
		
		for(i=1;i<=height/height2;i++){

			cur_x=temp_x;
			for(j=1;j<=line/width2;j++){

				rec2.setx(cur_x);
				rec2.sety(cur_y);
				
				rec2.draw(g);
				cur_x+=width2;
				counter++;

			}
			temp_x+=height2/Math.sqrt(3);
			line-=(2*height2/Math.sqrt(3));
			cur_y+=height2;

		}

		

		System.out.printf("I can fit at most %d small shapes into the main container.\n",counter); 

		return (side1*side1)*Math.sqrt(3)/4 - counter*width2*height2;
	}
	
	
	public double optimalfit(Triangle tri1,Triangle tri2){/*this function calculates how much small triangles fits into big triangle and returns residual area*/

		Graphics g = null;
		int i,j,counter=0;
		double side1=tri1.getside(),side2=tri2.getside(),line=side1,height1=side1*Math.sqrt(3)/2, height2=side2*Math.sqrt(3)/2,coor1_x=0,coor1_y=0,coor2_x=side2,coor3_x=side2/2,coor3_y=height2,temp1_x=0;

		tri1.draw(g);
		
		
		for(i=1;i<=height1/height2;i++){

			coor1_x=temp1_x;
			coor2_x=temp1_x+side2;
			coor3_x=temp1_x+side2/2;
			for(j=1;j<=line/side2;j++){

				tri2.setcoor(coor1_x,coor1_y,coor2_x,coor3_x,coor3_y);
				
				tri2.draw(g);
				coor1_x+=side2;
				coor2_x+=side2;
				coor3_x+=side2;
				counter++;
			}

			coor1_y+=height2;
			coor3_y+=height2;
			temp1_x+=side2/2;
			line-=side2;

		}

		line=side1-side2;
		temp1_x=side2/2;
		coor1_y=height2;
		coor3_y=0;

		for(i=1;i<=height1/height2;i++){

			coor1_x=temp1_x;
			coor2_x=temp1_x+side2;
			coor3_x=temp1_x+side2/2;
			for(j=1;j<=line/side2;j++){

				tri2.setcoor(coor1_x,coor1_y,coor2_x,coor3_x,coor3_y);
				tri2.draw(g);				
				coor1_x+=side2;
				coor2_x+=side2;
				coor3_x+=side2;
				counter++;
			}

			coor1_y+=height2;
			coor3_y+=height2;
			temp1_x+=side2/2;
			line-=side2;

		}

		
		System.out.printf("I can fit at most %d small shapes into the main container.\n",counter);

		return (side1*side1)*Math.sqrt(3)/4 - counter*(side2*side2)*Math.sqrt(3)/4;
	}


	public double optimalfit(Triangle tri1,Circle circle2){/*this function calculates how much small circles fits into big triangle and returns residual area*/

		Graphics g = null;
		int i,j,counter=0;
		double side1=tri1.getside(),radius2=circle2.getradius(),height=side1*Math.sqrt(3)/2,cur_x,cur_y=radius2,temp_x=radius2*Math.sqrt(3),line=side1-2*radius2*Math.sqrt(3);
		
		tri1.draw(g);
		
		for(i=1;i<=height/(2*radius2);i++){

			cur_x=temp_x;
			for(j=1;j<=line/(2*radius2)+1;j++){
				
				circle2.setcoor_x(cur_x);
				circle2.setcoor_y(cur_y);
				circle2.draw(g);
				
				cur_x+=2*radius2;
				counter++;
			}

			cur_y+=2*radius2;
			line-=((4*radius2)/Math.sqrt(3));
			temp_x+=2*radius2/Math.sqrt(3);
		}

		System.out.printf("I can fit at most %d small shapes into the main container.\n",counter);

		return (side1*side1)*Math.sqrt(3)/4 - counter*PI*radius2*radius2;

	}
	
	
	public double optimalfit(Rectangle rec1,Triangle tri2){/*this function calculates how much small triangle fits into big rectangle, and returns residual area*/

		Graphics g = null;
		int i,j,counter=0;
		double width1=rec1.getwidth(),height1=rec1.getheight(),side2=tri2.getside(),coor1_x=0,coor1_y=0,coor2_x=side2,coor3_x=side2/2,coor3_y,height_tri=(side2*Math.sqrt(3))/2;
		coor3_y=height_tri;
		rec1.draw(g);
		 
		for(i=1;i<=height1/height_tri;i++){


	 		for(j=1;j<=width1/side2;j++){

	 			tri2.setcoor(coor1_x,coor1_y,coor2_x,coor3_x,coor3_y);
				tri2.draw(g);
	 			coor1_x+=side2;
	 			coor2_x+=side2;
	 			coor3_x+=side2;
	 			counter++;
			}

			coor1_x=0; coor1_y+=height_tri; coor2_x=side2; coor3_x=side2/2; coor3_y+=height_tri;



		}

		coor1_x=side2/2; coor1_y=height_tri; coor2_x=side2/2+side2; coor3_x=side2; coor3_y=0;

		for(i=1;i<=height1/height_tri;i++){/*this loop adds triangle 180 degree deflectingly*/

			for(j=1;j<=width1/side2-1;j++){

				tri2.setcoor(coor1_x,coor1_y,coor2_x,coor3_x,coor3_y);
				tri2.draw(g);
				coor1_x+=side2;
	 			coor2_x+=side2;
	 			coor3_x+=side2;
	 			counter++;
			}

			coor1_x=side2/2; coor1_y+=height_tri; coor2_x=side2/2+side2; coor3_x=side2; coor3_y+=height_tri;
		}


		System.out.printf("I can fit at most %d small shapes into the main container.\n",counter);
		
		return (height1*width1)-counter*(side2*side2)*Math.sqrt(3)/4;

	}
	
	public double optimalfit(Rectangle rec1,Rectangle rec2){/*this function calculates how much small rectangle fits into big rectangle, and returns residual area*/

		int i,j = 0,k,l,counter=0;
		Graphics g = null;
		double width1=rec1.getwidth(),height1=rec1.getheight(),width2=rec2.getwidth(),height2=rec2.getheight(),cur_x=0,cur_y=0;
		
		rec1.draw(g);
		
		
		for(i=1;i<=height1/height2;i++){

			for(j=1;j<=width1/width2;j++){
				
				rec2.setx(cur_x);
				rec2.sety(cur_y);
				rec2.draw(g);
				cur_x+=width2;
				counter++;
			}
			cur_x=0;
			cur_y+=height2;
		}
		j--;
		cur_y=0;
		cur_x=j*width2;
		for(k=1;k<=height1/width2;k++){/*if fits into deflectingly, it fits and draws*/

			for(l=1;l<=(width1-(j*width2))/height2;l++){
				
				rec2.setx(cur_x);
				rec2.sety(cur_y);
				rec2.draw(g);
				cur_x+=height2;
				counter++;
			}
			cur_x=j*width2;
			cur_y+=width2;
		}

		
		System.out.printf("I can fit at most %d small shapes into the main container.\n",counter);
		return (height1*width1)-counter*width2*height2;

	}

	
	public double optimalfit(Rectangle rec1,Circle circle2){/*this function calculates how much small circle fits into big rectangle, and returns residual area*/

		Graphics g = null;
		int i = 0,j;
		double width1=rec1.getwidth(),height1=rec1.getheight(),radius2=circle2.getradius(),cur_x=radius2,cur_y=radius2;

		rec1.draw(g);
		for(j=1;j<=(height1/(radius2*2));j++){/*this loop draws smallest shape*/

			for(i=1;i<=(width1/(radius2*2));i++){
				 
				circle2.setcoor_x(cur_x);
				circle2.setcoor_y(cur_y);
				circle2.draw(g);				
				cur_x += (radius2*2);
			}
			cur_x = radius2;
			cur_y += radius2*2;
		}

		i--; j--;

		System.out.printf("I can fit at most %d small shapes into the main container.\n",i*j);

		return (width1*height1) - (i*j*(PI*radius2*radius2));/*and returns resudial area*/

	}
	
	public double optimalfit(Circle circle1,Triangle tri2){/*this function calculates how much small triangles fits into big circle and returns residual area*/

		Graphics g = null;
		int i,j,k=0,counter=0;
		double radius1=circle1.getradius(),side2=tri2.getside(),line=2*radius1,res_len = 0,sur = 0,point,height2=side2*Math.sqrt(3)/2,coor1_x=0,coor1_y=radius1,coor2_x=side2,coor3_x=side2/2,coor3_y=radius1-height2,temp1_x=0;

		circle1.draw(g);
		for(i=1;i<=radius1/height2;i++){

			for(j=1;j<=line/side2;j++){

				tri2.setcoor(coor1_x,coor1_y,coor2_x,coor3_x,coor3_y);
				tri2.draw(g);
				if((coor3_x+side2-radius1)*(coor3_x+side2-radius1)+(coor3_y-radius1)*(coor3_y-radius1)<=radius1*radius1){
					
					tri2.setcoor(coor1_x,coor1_y,coor2_x,coor3_x,coor3_y);
					tri2.draw(g);
					counter++;
				}

				coor1_x+=side2;
				coor2_x+=side2;
				coor3_x+=side2;
				counter++;

			}
			k=0;
			coor1_y-=height2;
			coor3_y-=height2;

			if(coor1_y-height2<0) k++;
			while(k==0){
				temp1_x+=1;
				point=(temp1_x-radius1)*(temp1_x-radius1)+(coor1_y-radius1)*(coor1_y-radius1);
				if(point<=radius1*radius1){
					point=(temp1_x+side2/2-radius1)*(temp1_x+side2/2-radius1)+(coor3_y-radius1)*(coor3_y-radius1);
					if(point<=radius1*radius1){
						sur=temp1_x-res_len;
						k++;
					}
				}
			}
			line-=2*sur;
			res_len+=sur;
			coor1_x=temp1_x;
			coor2_x=temp1_x+side2;
			coor3_x=temp1_x+side2/2;

		}

		coor1_x=0;
		coor1_y=radius1;
		coor2_x=side2;
		coor3_x=side2/2;
		coor3_y=radius1+height2;
		line=2*radius1;
		temp1_x=0;
		res_len=0;

		for(i=1;i<=radius1/height2;i++){

			for(j=1;j<=line/side2;j++){

				tri2.setcoor(coor1_x,coor1_y,coor2_x,coor3_x,coor3_y);
				tri2.draw(g);

				if((coor3_x+side2-radius1)*(coor3_x+side2-radius1)+(coor3_y-radius1)*(coor3_y-radius1)<=radius1*radius1){
					
					tri2.setcoor(coor1_x,coor1_y,coor2_x,coor3_x,coor3_y);
					tri2.draw(g);
					counter++;
				}

				coor1_x+=side2;
				coor2_x+=side2;
				coor3_x+=side2;
				counter++;

			}
			k=0;
			coor1_y+=height2;
			coor3_y+=height2;

			if(coor1_y+height2>2*radius1) k++;
			while(k==0){
				temp1_x+=1;
				point=(temp1_x-radius1)*(temp1_x-radius1)+(coor1_y-radius1)*(coor1_y-radius1);
				if(point<=radius1*radius1){
					point=(temp1_x+side2/2-radius1)*(temp1_x+side2/2-radius1)+(coor3_y-radius1)*(coor3_y-radius1);
					if(point<=radius1*radius1){
						sur=temp1_x-res_len;
						k++;
					}
				}
			}
			line-=2*sur;
			res_len+=sur;
			coor1_x=temp1_x;
			coor2_x=temp1_x+side2;
			coor3_x=temp1_x+side2/2;

		}


		System.out.printf("I can fit at most %d small shapes into the main container.\n",counter);
		
		return PI*radius1*radius1 - counter*side2*side2*Math.sqrt(3)/4;
	}
	
	
	public double optimalfit(Circle circle1,Rectangle rec2){/*this functon calculates how much small rectangles fits into big circle and returns residual area*/

		Graphics g = null;
		int i,j,k=0,l=0,counter=0;
		double radius1=circle1.getradius(),height2=rec2.getheight(),width2=rec2.getwidth(),line,cur_x,cur_y,res_len,temp_x,sur = 0,point;

		circle1.draw(g);
		
		res_len=radius1-Math.sqrt(radius1*radius1-height2*height2);
		line=2*radius1-2*res_len;
		cur_x=res_len;
		cur_y=radius1-height2;
		temp_x=res_len;

		for(i=1;i<=radius1/height2;i++){

			for(j=1;j<=line/width2;j++){

				if((cur_x-radius1)*(cur_x-radius1)+(cur_y-radius1)*(cur_y-radius1)<=radius1*radius1){
					
					rec2.setx(cur_x);
					rec2.sety(cur_y);
					rec2.draw(g);
					cur_x+=width2;
					counter++;
				}
			}
			k=0;
			cur_y-=height2;
			if(cur_y-height2<0) k++;
			while(k==0){
				temp_x+=1;
				point=(temp_x-radius1)*(temp_x-radius1)+(cur_y-radius1)*(cur_y-radius1);
				if(point<=radius1*radius1){
					sur=temp_x-res_len;
					k++;
				}
			}
			line-=2*sur;
			res_len+=sur;
			cur_x=temp_x;

		}

		res_len=radius1-Math.sqrt(radius1*radius1-height2*height2);
		line=2*radius1-2*res_len;
		cur_x=res_len;
		cur_y=radius1-height2;
		temp_x=res_len;

		for(i=1;i<=(radius1)/height2;i++){

			for(j=1;j<=line/width2;j++){

				rec2.setx(cur_x);
				rec2.sety(cur_y);
				rec2.draw(g);
				cur_x+=width2;
				counter++;
			}
			l=0;
			cur_y+=height2;
			if(cur_y+height2>2*radius1) l++;
			while(l==0){
				temp_x+=1;
				point=(temp_x-radius1)*(temp_x-radius1)+(cur_y+height2-radius1)*(cur_y+height2-radius1);
				if(point<=radius1*radius1){
					sur=temp_x-res_len;
					l++;
				}
			}
			line-=2*sur;
			res_len+=sur;
			cur_x=temp_x;

		}


		System.out.printf("I can fit at most %d small shapes into the main container.\n",counter);

		return PI*radius1*radius1 - counter*height2*width2;
	}
	
	public double optimalfit(Circle circle1,Circle circle2){/*this function calculates how much small circle fits into big circle with using circle's equation, and returns residual area*/
		
		Graphics g = null;
		int counter=0,i,k=0;
		double radius1=circle1.getradius(),radius2=circle2.getradius(),cur_x,cur_y=radius1-radius2,point;
		
		circle1.draw(g);
		cur_x=0; cur_y=radius2;

		for(i=1;i<=radius1/radius2;i++){

			k=0;
			for(cur_x=0;k==0;cur_x++){

				point=(cur_x-radius1)*(cur_x-radius1)+(cur_y-radius1)*(cur_y-radius1);
				if(point<=radius1*radius1){
					point=(cur_x+radius2-radius1)*(cur_x+radius2-radius1)+(cur_y-radius2-radius1)*(cur_y-radius2-radius1);
					if(point<=radius1*radius1){
						point=(cur_x+radius2-radius2/Math.sqrt(2)-radius1)*(cur_x+radius2-radius1)+(cur_y+radius2/Math.sqrt(2)-radius1)*(cur_y+radius2/Math.sqrt(2)-radius1);
						if(point<=radius1*radius1){
							
							circle2.setcoor_x(cur_x);
							circle2.setcoor_y(cur_y);
							circle2.draw(g);	
							cur_x+=2*radius2-1;
							counter++;
						}
					}
				}

				if(cur_x>2*radius1){
					cur_x=0;
					cur_y+=2*radius2;
					k++;
				}
			}
		}

		
		System.out.printf("I can fit at most %d small shapes into the main container.\n",counter);
		return PI*radius1*radius1-counter*PI*radius2*radius2;
	}



}

