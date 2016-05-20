package fr.utbm.vi51.prj.drone;

import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glScalef;
import static org.lwjgl.opengl.GL11.glTranslatef;
import static org.lwjgl.opengl.GL11.glRotatef;

public class DroneDisplay {
		protected Cube cube;
	    
	    protected float x; 
	    protected float y;
	    protected float z;
	    
	    protected float orientation;
	    
	    DroneDisplay( float length, float r, float g, float b, float x, float y, float z, float o )
		{
	    	this.cube=new Cube(length, r, g, b);
		   this.x = x;
		   this.y = y;
		   this.z = z;
		   this.orientation = o;
		}

		public void setX(float x) {
			this.x = x;
		}

		public void setY(float y) {
			this.y = y;
		}

		public void setZ(float z) {
			this.z = z;
		}

		public void setOrientation(float orientation) {
			this.orientation = orientation;
		}
	    
		public void renderDrone() {
			glPushMatrix();
	        	glTranslatef(x,y,z);
	        	glRotatef(orientation, 0, 1, 0 );
		        cube.renderCube();  
	        glPopMatrix();
		}
	    
}
