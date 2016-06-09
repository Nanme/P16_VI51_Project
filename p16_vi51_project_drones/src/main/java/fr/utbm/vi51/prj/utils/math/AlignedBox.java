package fr.utbm.vi51.prj.utils.math;

public class AlignedBox {
	
	private double minX;
	private double minY;
	private double minZ;
	private double maxX;
	private double maxY;
	private double maxZ;
	
	/**
	 * @param minX
	 * @param minY
	 * @param minZ
	 * @param maxX
	 * @param maxY
	 * @param maxZ
	 */
	public AlignedBox(double minX, double minY, double minZ, double maxX, double maxY, double maxZ) {
		super();
		this.minX = minX;
		this.minY = minY;
		this.minZ = minZ;
		this.maxX = maxX;
		this.maxY = maxY;
		this.maxZ = maxZ;
	}

	/**
	 * @return the minX
	 */
	public double getMinX() {
		return minX;
	}

	/**
	 * @param minX the minX to set
	 */
	public void setMinX(double minX) {
		this.minX = minX;
	}

	/**
	 * @return the minY
	 */
	public double getMinY() {
		return minY;
	}

	/**
	 * @param minY the minY to set
	 */
	public void setMinY(double minY) {
		this.minY = minY;
	}

	/**
	 * @return the minZ
	 */
	public double getMinZ() {
		return minZ;
	}

	/**
	 * @param minZ the minZ to set
	 */
	public void setMinZ(double minZ) {
		this.minZ = minZ;
	}

	/**
	 * @return the maxX
	 */
	public double getMaxX() {
		return maxX;
	}

	/**
	 * @param maxX the maxX to set
	 */
	public void setMaxX(double maxX) {
		this.maxX = maxX;
	}

	/**
	 * @return the maxY
	 */
	public double getMaxY() {
		return maxY;
	}

	/**
	 * @param maxY the maxY to set
	 */
	public void setMaxY(double maxY) {
		this.maxY = maxY;
	}

	/**
	 * @return the maxZ
	 */
	public double getMaxZ() {
		return maxZ;
	}

	/**
	 * @param maxZ the maxZ to set
	 */
	public void setMaxZ(double maxZ) {
		this.maxZ = maxZ;
	}

	public static boolean intersectsAlignedBoxAlignedBox(
			double lower1x, double lower1y, double lower1z, double upper1x, double upper1y, double upper1z,
			double lower2x, double lower2y, double lower2z, double upper2x, double upper2y, double upper2z) {
		assert(lower1x<=upper1x);
		assert(lower1y<=upper1y);
		assert(lower1z<=upper1z);
		assert(lower2x<=upper2x);
		assert(lower2y<=upper2y);
		assert(lower2z<=upper2z);

		boolean intersects;
		if (lower1x<lower2x) intersects = upper1x>lower2x;
		else intersects = upper2x>lower1x;

		if (intersects) {
			if (lower1y<lower2y) intersects = upper1y>lower2y;
			else intersects = upper2y>lower1y;

			if (intersects) {
				if (lower1z<lower2z) intersects = upper1z>lower2z;
				else intersects = upper2z>lower1z;
			}
		}

		return intersects;
	}
	
	public static boolean containsAlignedBoxPoint(
			double minx, double miny, double minz, double maxx, double maxy, double maxz,
			double px, double py, double pz) {
		return (minx<=px && px<=maxx
				&&
				miny<=py && py<=maxy
				&&
				minz<=pz && pz<=maxz);
	}
	
	public boolean intersects(AlignedBox s) {
		return intersectsAlignedBoxAlignedBox(
				getMinX(), getMinY(), getMinZ(),
				getMaxX(), getMaxY(), getMaxZ(),
				s.getMinX(), s.getMinY(), s.getMinZ(),
				s.getMaxX(), s.getMaxY(), s.getMaxZ());
	}

}
