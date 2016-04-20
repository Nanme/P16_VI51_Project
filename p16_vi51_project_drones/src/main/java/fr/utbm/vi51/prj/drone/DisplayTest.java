package fr.utbm.vi51.prj.drone;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import static org.lwjgl.opengl.GL11.*;

/**
 * If this application shows a blank and responsive window
 * and doesn't throw any errors, you know you have installed lwjgl
 * correctly.
 * @author Oskar Veerhoek
 */
public class DisplayTest {
    public static void main(String[] args) {
    	 //les paramètres d'affichage que nous voulons :
    	 int width=640;
    	 int height=400;
    	 int depth=100;
    			try
    			{
    	 			// On récupère dans un tableau tout les modes d'affichages disponibles
    	 			DisplayMode modes[] = Display.getAvailableDisplayModes();
    	 
    				// On parcours ce tableau à la recherche d'un mode ayant les caractéristiques recherchées 
    				for(DisplayMode currentMode : modes)
    				{
    					// test si le mode correspond aux 3 critères
    					if(currentMode.getWidth() == width &&
    					   currentMode.getHeight() == height &&
    					   currentMode.getBitsPerPixel() == depth)
    	 				{
    						// s'il correspond on en fait le mode d'affichage
    						// actuel dans la classe Display
    						Display.setDisplayMode(currentMode);
    						break;
    					}
    				}
    				//choix du titre de la fenetre et de sa position
    				Display.setTitle("Affichage d'un triangle avec LWJGL");
    				Display.setLocation(10, 10);
    	 
    				//création de la fenêtre
    				Display.create();
    				// création d'une matrice de projection
    				glOrtho(0.0, Display.getDisplayMode().getWidth(), 0.0, Display.getDisplayMode().getHeight(), -1.0, 1.0);
    			}
    			catch(Exception e)
    			{
    				System.out.println("Erreur Une erreur est survenue lors de la création de l'affichage : " + e);
    				System.exit(1);
    			}
    	  glTranslatef(400, 200, 0);
    	 //une petite boucle qui attend que l'on clique sur la croix
    	 while(!Display.isCloseRequested()){
    	 
    	    //efface l'écran	
    	    glClear(GL_COLOR_BUFFER_BIT);
    	 
    	    //trace le triangle
    	   
    	     glRotatef(0.05f, 0, 1, 0);
    	     glBegin(GL_TRIANGLES);
    	       	glVertex3f(0, 0, 0);
    	        glVertex3f(200, 0, 0);
    	        glVertex3f(100, 200, 1);
    	        glVertex3f(100, 0, 200);
    	        glVertex3f(0, 0, 0);
    	        glVertex3f(200, 0, 0);
    	    glEnd();
    	 
    	    //actualise l'affichage dans la fenêtre
    	    Display.update();
    	 
    	 }
    }
}