package fr.utbm.vi51.prj.drone;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex3f;


public class Cube {
    protected float length;
    protected float red;
    protected float green;
    protected float blue;
    

	Cube( float length, float r, float g, float b )
	{
		   this.length=length;
		   this.red = r;
		   this.green = g;
		   this.blue = b;
	}


	public void renderCube() {
		 glBegin(GL_QUADS);
		 glColor3f(this.red,this.green,this.blue);           
	        glVertex3f( length/2, length/2,-length/2);        
	        glVertex3f(-length/2, length/2,-length/2);        
	        glVertex3f(-length/2, length/2, length/2);
	        glVertex3f( length/2, length/2, length/2);  
	        glColor3f(this.red,this.green,this.blue);            
	        glVertex3f( length/2,-length/2, length/2);
	        glVertex3f(-length/2,-length/2, length/2);
	        glVertex3f(-length/2,-length/2,-length/2);
	        glVertex3f( length/2,-length/2,-length/2);
	        glColor3f(this.red,this.green,this.blue);
	        glVertex3f( length/2, length/2, length/2);
	        glVertex3f(-length/2, length/2, length/2);
	        glVertex3f(-length/2,-length/2, length/2);
	        glVertex3f( length/2,-length/2, length/2);
	        glColor3f(this.red,this.green,this.blue);
	        glVertex3f( length/2,-length/2,-length/2);
	        glVertex3f(-length/2,-length/2,-length/2);
	        glVertex3f(-length/2, length/2,-length/2);
	        glVertex3f( length/2, length/2,-length/2);
	        glColor3f(this.red,this.green,this.blue);
	        glVertex3f(-length/2, length/2, length/2);
	        glVertex3f(-length/2, length/2,-length/2);
	        glVertex3f(-length/2,-length/2,-length/2);
	        glVertex3f(-length/2,-length/2, length/2);
	        glColor3f(this.red,this.green,this.blue);
	        glVertex3f( length/2, length/2,-length/2);
	        glVertex3f( length/2, length/2, length/2);
	        glVertex3f( length/2,-length/2, length/2);
	        glVertex3f( length/2,-length/2,-length/2);
		 glEnd();
		 }


}
