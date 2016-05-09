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
public final class OctTreeNode<D, N extends OctTreeNode<D, N>> extends AbstractTreeNode<D, N> {
	
	private D data;
	private final OctTreeZone zone;
	private final List<N> children = new ArrayList<>();
	
	/**
	 * 
	 */
	public OctTreeNode(N parent, D data, OctTreeZone zone) {
		super(parent, data);
		this.zone = zone;
	}

	@Override
	public Collection<N> getChildren() {
		return children;
	}

	@Override
	public int getChildCount() {
		return children.size();
	}

	@Override
	public N getChildAt(int index) {
		return children.get(index);
	}

	@Override
	public int indexOf(N child) {
		return children.indexOf(child);
	}
	
	public N getChildAtZone(OctTreeZone zone){
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
