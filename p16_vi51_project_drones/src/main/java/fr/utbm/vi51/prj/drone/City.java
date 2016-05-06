package fr.utbm.vi51.prj.drone;
import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glTranslatef;

public class City {
	Block b1, b2, b3, b4;
	City(){
		b1=new Block(0.85f,0.3f, 0.5f, 0.65f,0.4f, 0.8f, 0.25f,0.8f, 0.9f);
		b2=new Block(0.9f,0.2f, 0.2f, 0.2f,0.9f, 0.4f, 0.9f,0.9f, 0.2f);
		b3=new Block(0.2f,0.1f, 0.3f, 0.4f,0.5f, 0.6f, 0.7f,0.5f, 0.3f);
		b4=new Block(0.8f,0.2f, 0.4f, 0.1f,0.2f, 0.8f, 0.8f,0.6f, 0.1f);
	}
	
	void renderCity(){
		glPushMatrix();
			glTranslatef(-55f, 0f, -40f);
			b1.renderBlock();
		glPopMatrix();
		glPushMatrix();
			glTranslatef(55f, 0f, -40f);
			b2.renderBlock();
		glPopMatrix();
		glPushMatrix();
			glTranslatef(55f, 0f, 50f);
			b3.renderBlock();
		glPopMatrix();
		glPushMatrix();
			glTranslatef(-55f, 0f, 50f);
			b4.renderBlock();
		glPopMatrix();
	}
}
