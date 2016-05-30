/**
 * 
 */
package fr.utbm.vi51.prj.utils.tree.node;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import fr.utbm.vi51.prj.utils.OctTreeZone;

/**
 * @author renaud
 *
 */
public final class OctTreeNode<D> extends AbstractTreeNode<D, OctTreeNode<D>> {
	
	private D data;
	private final OctTreeZone zone;
	private final List<OctTreeNode<D>> children = new ArrayList<>();
	
	/**
	 * 
	 */
	public OctTreeNode(OctTreeNode<D> parent, D data, OctTreeZone zone) {
		super(parent, data);
		this.zone = zone;
	}

	@Override
	public Collection<OctTreeNode<D>> getChildren() {
		return children;
	}

	@Override
	public int getChildCount() {
		return children.size();
	}

	@Override
	public OctTreeNode<D> getChildAt(int index) {
		return children.get(index);
	}

	@Override
	public int indexOf(OctTreeNode<D> child) {
		return children.indexOf(child);
	}
	
	public OctTreeNode<D> getChildAtZone(OctTreeZone zone){
		return children.get(zone.getPosition());
	}
	
	public OctTreeZone getZone(){
		return zone;
	}

	@Override
	public boolean isEmpty() {
		return data == null;
	}

	@Override
	public boolean isLeaf() {
		return children.isEmpty();
	}

}
