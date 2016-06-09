package fr.utbm.vi51.prj.drone;

import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glTranslatef;

import fr.utbm.vi51.prj.drone.framework.math.Vector2f;

import static org.lwjgl.opengl.GL11.glRotatef;

public class DroneDisplay {
		protected Cube cube;
	    
	    protected float x; 
	    protected float y;
	    protected float z;
	    protected float angle;
	    protected float angularVelocity=0;
	    protected Vector2f linearVelocity=new Vector2f(0,0);
	    
	    protected float orientation;
	    
	    public DroneDisplay( float length, float r, float g, float b, float x, float y, float z, float o )
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

		public float getX() {
			// TODO Auto-generated method stub
			return x;
		}

		public float getY() {
			// TODO Auto-generated method stub
			return y;
		}

		public Vector2f getLinearVelocity() {
			// TODO Auto-generated method stub
			return linearVelocity;
		}

		public float getAngularVelocity() {
			// TODO Auto-generated method stub
			return angularVelocity;
		}

		public float getAngle() {
			// TODO Auto-generated method stub
			return angle;
		}

		public float getZ() {
			  return z;
		}
	    
}
