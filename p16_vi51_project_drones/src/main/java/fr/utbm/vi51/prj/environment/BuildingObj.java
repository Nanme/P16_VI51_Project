package fr.utbm.vi51.prj.environment;

public class BuildingObj extends EnvironmentObject {

	protected float x, y, z;
	
	public BuildingObj(float width, float height, float depth, float x, float y, float z) {
		super(width, height, depth, null);
		this.x=x;
		this.y=y;
		this.z=z;
		// TODO Auto-generated constructor stub
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getZ() {
		return z;
	}

	public void setZ(float z) {
		this.z = z;
	}

}
