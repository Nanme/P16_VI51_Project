package fr.utbm.vi51.prj.drone.ia.formation;

import fr.utbm.vi51.prj.drone.framework.math.Point2f;
import fr.utbm.vi51.prj.drone.framework.math.Vector2f;
import fr.utbm.vi51.prj.drone.ia.formation.Anchor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class Formation {
  private final Point2f globalPosition = new Point2f();
  
  private final Vector2f globalOrientation = new Vector2f();
  
  private final Anchor root;
  
  private final ArrayList<Anchor> anchors = new ArrayList<Anchor>();
  
  public Formation(final Anchor root) {
    this.root = root;
    this.root.setFormation(this);
  }
  
  public int addAnchor(final Anchor anchor) {
    this.anchors.add(anchor);
    int _size = this.anchors.size();
    return (_size - 1);
  }
  
  @Pure
  public Collection<Anchor> getAnchors() {
    return Collections.<Anchor>unmodifiableCollection(this.anchors);
  }
  
  @Pure
  public Anchor getAnchor(final int index) {
    return this.anchors.get(index);
  }
  
  @Pure
  public int getAnchorCount() {
    return this.anchors.size();
  }
  
  @Pure
  public Anchor getRoot() {
    return this.root;
  }
  
  @Pure
  public Vector2f getGlobalOrientation() {
    return this.globalOrientation.clone();
  }
  
  @Pure
  public Point2f getGlobalPosition() {
    return this.globalPosition.clone();
  }
  
  public void setGlobalOrientation(final Vector2f o) {
    this.globalOrientation.set(o);
  }
  
  public void setGlobalPosition(final Point2f p) {
    this.globalPosition.set(p);
  }
}
