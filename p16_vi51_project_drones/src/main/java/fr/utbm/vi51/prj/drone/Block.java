package fr.utbm.vi51.prj.drone;

import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glScalef;
import static org.lwjgl.opengl.GL11.glTranslatef;

public class Block {
	float r1, g1, b1, r2, g2, b2, r3, g3, b3;
	Cube cube, cube2, cube3;

	public Block(float r1, float g1, float b1, float r2, float g2, float b2, float r3, float g3, float b3) {
		super();
		this.r1 = r1;
		this.g1 = g1;
		this.b1 = b1;
		this.r2 = r2;
		this.g2 = g2;
		this.b2 = b2;
		this.r3 = r3;
		this.g3 = g3;
		this.b3 = b3;
		cube = new Cube(20, r1, g1, b1);
		cube2 = new Cube(20, r2, g2, b2);
		cube3 = new Cube(20, r3, g3, b3);
		
	}
	public void renderBlock() {
		glPushMatrix();
        cube.renderCube();  //1
        glPushMatrix();//2
        	glTranslatef(1.50f*10,1f*10,0f);
        	glScalef(0.5f, 2f, 0.5f);
        	cube2.renderCube();
        glPopMatrix();
        glPushMatrix();//3
         	glTranslatef(2.50f*10,0.5f*10,0f);
         	glScalef(0.5f, 1.5f, 1f);
         	cube3.renderCube();
     	 glPopMatrix();
     	 glPushMatrix();//4
        	glTranslatef(4.50f*10,0f*10,0f*10);
        	glScalef(0.5f, 1f, 0.5f);
        	cube.renderCube();
        glPopMatrix();
        glPushMatrix();//5
        	glTranslatef(-3f*10,0.5f*10,0f*10);
        	glScalef(1f, 1.5f, 1f);
        	cube2.renderCube();
        glPopMatrix();
        glPushMatrix();//6
        	glTranslatef(-4.50f*10,0f*10,0f*10);
        	glScalef(0.5f, 1f, 1f);
        	cube3.renderCube();
        glPopMatrix();
        glPushMatrix();//7
        	glTranslatef(-4.f*10,0.5f*10,-3f*10);
        	glScalef(1f, 1.5f, 1f);
        	cube.renderCube();
        glPopMatrix();
        glPushMatrix();//8
        	glTranslatef(-2.5f*10,-0.5f*10,-3f*10);
        	glScalef(0.5f, 0.5f, 1f);
        	cube2.renderCube();
        glPopMatrix();
        glPushMatrix();//9
        	glTranslatef(0f*10,0f*10,-3f*10);
        	glScalef(1, 01f, 0.5f);
        	cube3.renderCube();
        glPopMatrix();
        glPushMatrix();//10
        	glTranslatef(1.5f*10,0.5f*10,-3f*10);
        	glScalef(0.5f, 1.5f, 0.5f);
        	cube.renderCube();
        glPopMatrix();
        glPushMatrix();//11
        	glTranslatef(2.5f*10,-0.5f*10,-3f*10);
        	glScalef(0.5f, 0.5f, 0.5f);
        	cube2.renderCube();
        glPopMatrix();
        glPushMatrix();//12
        	glTranslatef(4.5f*10,0.5f*10,-3f*10);
        	glScalef(0.5f, 1.5f, 1f);
        	cube3.renderCube();
        glPopMatrix();
        glPushMatrix();//13
        	glTranslatef(-3.5f*10,2f*10,3f*10);
        	glScalef(1.5f, 3f, 1f);
        	cube.renderCube();
        glPopMatrix();
        glPushMatrix();//14
        	glTranslatef(0f*10,1.5f*10,3f*10);
        	glScalef(1f, 2.5f, 1f);
        	cube2.renderCube();
        glPopMatrix();
        glPushMatrix();//15
        	glTranslatef(2f*10,1f*10,3f*10);
        	glScalef(1f, 2f, 1f);
        	cube3.renderCube();
        glPopMatrix();
        glPushMatrix();//16
        	glTranslatef(4.5f*10,0f*10,3f*10);
        	glScalef(0.5f, 1f, 1f);
        	cube.renderCube();
        glPopMatrix();
        glPopMatrix();
	}
}
