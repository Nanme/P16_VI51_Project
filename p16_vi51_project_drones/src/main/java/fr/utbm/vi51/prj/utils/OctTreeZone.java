/**
 * 
 */
package fr.utbm.vi51.prj.utils;

/**
 * @author renaud
 * Enumaration use to situate an {@link OctTreeNode<D, N>} in his parents node in the 3D space.
 */
public enum OctTreeZone {
	
	NORTH_EAST_UP(0),
	
	NORTH_EAST_DOWN(1),
	
	NORTH_WEST_UP(2),
	
	NORTH_WEST_DOWN(3),
	
	SOUTH_EAST_UP(4),
	
	SOUTH_EAST_DOWN(5),
	
	SOUTH_WEST_UP(6),
	
	SOUTH_WEST_DOWN(7);
	
	private int position;
	
	private OctTreeZone(int pos){
		this.position = pos;
	}
	
	public int getPosition(){
		return this.position;
	}

}
