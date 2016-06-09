package fr.utbm.vi51.prj.drone;

import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glFrustum;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glRotatef;
import static org.lwjgl.opengl.GL11.glTranslatef;

import java.awt.Toolkit;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

import fr.utbm.vi51.prj.environment.Environment;

public class DisplayTest  {
	
	 float xrot=0,yrot=0,zrot=0,x=0,y=0,z=0;
	 private static boolean gameRunning=true;
	 private Environment env;
	 


	DroneDisplay drone =new DroneDisplay(5, 1, 1, 1, 0, 0, 0, 30);
	 DisplayMode displayMode;
	 float truc = 0;
	  //the rotation around the Y axis of the camera
    private float yaw= 0.0f;
    //the rotation around the X axis of the camera
    private float pitch= 0.0f;

   public void Start(){
   	 try {
   		 createWindow();
   	 initGL();
   	     run();
   	 } catch (Exception e) {
   		 e.printStackTrace();
   	 }
   	 
   	 
   }
   
   private void createWindow() throws Exception {
        Display.setFullscreen(false);
        DisplayMode d[] = Display.getAvailableDisplayModes();
        for (int i = 0; i < d.length; i++) {
            if (d[i].getWidth() == Toolkit.getDefaultToolkit().getScreenSize().getWidth()
                && d[i].getHeight() == Toolkit.getDefaultToolkit().getScreenSize().getHeight()
                && d[i].getBitsPerPixel() == 32) {
                displayMode = d[i];
                break;
            }
        }
        Display.setDisplayMode(displayMode);
        Display.setTitle("LWJGL Voxel engine");
        Display.create();
        
    }
   
   private void initGL() {
       GL11.glEnable(GL11.GL_TEXTURE_2D);
       GL11.glShadeModel(GL11.GL_SMOOTH);
       GL11.glClearColor(0.0f, 0.0f, 0.0f, 0.0f); 
       GL11.glClearDepth(1.0); 
       GL11.glEnable(GL11.GL_DEPTH_TEST);
       GL11.glDepthFunc(GL11.GL_LEQUAL); 

       GL11.glMatrixMode(GL11.GL_PROJECTION); 
       GL11.glLoadIdentity();
        
       perspectiveGL(45.0f,(float)displayMode.getWidth()/(float)displayMode.getHeight(), 0.1f, 1000.0f);

       GL11.glMatrixMode(GL11.GL_MODELVIEW);
       GL11.glHint(GL11.GL_PERSPECTIVE_CORRECTION_HINT, GL11.GL_NICEST);
   }
   
   private void update(){
       xrot+=0.1f;
       yrot+=0.1f;
       zrot+=0.1f;
   }
   
   public void lookThrough()
   {
   	  //Rotate the pitch around the X axis
       GL11.glRotatef(pitch, 1.0f, 0.0f, 0.0f);
       //Rotate the yaw around the Y axis
       GL11.glRotatef(yaw, 0.0f, 1.0f, 0.0f);
       //translate to the position vector's location
       GL11.glTranslatef(x, y, z);
   }
   
   private void run() {
   	float dx        = 0.0f;
       float dy        = 0.0f;
       float dt        = 1.0f; //length of frame
      
       float mouseSensitivity = 0.1f;
       float movementSpeed = 0.05f; //move 10 units per second

       //hide the mouse
       Mouse.setGrabbed(true);
       while(gameRunning){
	        update();
	        render();
	        Display.update();
	
           //distance in mouse movement from the last getDX() call.
           dx = Mouse.getDX();
           //distance in mouse movement from the last getDY() call.
           dy = Mouse.getDY();

           //control camera yaw from x movement from the mouse
           yaw(dx * mouseSensitivity);
           //control camera pitch from y movement from the mouse
           pitch(-dy * mouseSensitivity);


           //when passing in the distance to move
           //we times the movementSpeed with dt this is a time scale
           //so if its a slow frame u move more then a fast frame
           //so on a slow computer you move just as fast as on a fast computer
            
           //OVER HERE! What do I do to make the boolean canWalk actually work the right way?
            
           if (Keyboard.isKeyDown(Keyboard.KEY_Z) )//move forward
           {
               walkForward(movementSpeed*dt);
           }
           if (Keyboard.isKeyDown(Keyboard.KEY_S) )//move backwards
           {
              walkBackwards(movementSpeed*dt);
           }
           if (Keyboard.isKeyDown(Keyboard.KEY_Q) )//strafe left
           {
              strafeLeft(movementSpeed*dt);
           }
           if (Keyboard.isKeyDown(Keyboard.KEY_D) )//strafe right
           {
               strafeRight(movementSpeed*dt);
           }

           //set the modelview matrix back to the identity
           GL11.glLoadIdentity();
           //look through the camera before you draw anything
           lookThrough();
           //you would draw your scene here.
	
	        // finally check if the user has requested that the display be
	        // shutdown
	        if (Display.isCloseRequested()) {
               gameRunning = false;
               Display.destroy();
               System.exit(0);
	        }
	        if (Keyboard.isKeyDown(Keyboard.KEY_ESCAPE))
	        {
	            System.exit(0);
	        }
   	 }
   }
   private void render() {
   	 glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
   	 	glLoadIdentity();  
 
   	 	//glTranslatef(0f,0.0f,f); 
   	 	
   	 	//roatate the pitch around the X axis
   	 	glRotatef(pitch, 1.0f, 0.0f, 0.0f);
   	 	//roatate the yaw around the Y axis
	        glRotatef(yaw, 0.0f, 1.0f, 0.0f);
	        //translate to the position vector's location
	        glTranslatef(x, y, z);
	        
	        if(y>1)
	        	y=1;
	        
	        env.renderEnv();
   	 	//drone.renderDrone();
   }
   
   void perspectiveGL( double fovY, double aspect, double zNear, double zFar )
   {
       double pi = 3.1415926535897932384626433832795;
       double fW, fH;
       fH = Math.tan( fovY / 360 * pi )* zNear;
       fW = fH * aspect;

       glFrustum( -fW, fW, -fH, fH, zNear, zFar );
   }

     
       
   	//increment the camera's current yaw rotation
       public void yaw(float amount)
       {
           //increment the yaw by the amount param
           yaw += amount;
       }
    
       //increment the camera's current yaw rotation
       public void pitch(float amount)
       {
           //increment the pitch by the amount param
           pitch += amount;
       }
       //moves the camera forward relative to its current rotation (yaw)
       public void walkForward(float distance) {
       	x -= distance * (float) Math.sin(Math.toRadians(yaw));
       	y += distance * (float) Math.tan(Math.toRadians(pitch));
       	z += distance * (float) Math.cos(Math.toRadians(yaw));
       	}

       	public void walkBackwards(float distance) {
       	x += distance * (float) Math.sin(Math.toRadians(yaw));
       	y -= distance * (float) Math.tan(Math.toRadians(pitch));
       	z -= distance * (float) Math.cos(Math.toRadians(yaw));
       	}
    
       //strafes the camera left relative to its current rotation (yaw)
       public void strafeLeft(float distance)
       {
              x -= (distance * (float)Math.sin(Math.toRadians(yaw-90)));
               z += (distance * (float)Math.cos(Math.toRadians(yaw-90)));
       }
    
       //strafes the camera right relative to its current rotation (yaw)
       public void strafeRight(float distance)
       {
              x -= (distance * (float)Math.sin(Math.toRadians(yaw+90)));
               z += (distance * (float)Math.cos(Math.toRadians(yaw+90)));
       }
  
  	 public Environment getEnv() {
		return env;
	}

	public void setEnv(Environment env) {
		this.env = env;
	}
}