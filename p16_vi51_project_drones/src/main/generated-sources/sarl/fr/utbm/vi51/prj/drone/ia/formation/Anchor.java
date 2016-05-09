package fr.utbm.vi51.prj.drone.ia.formation;

import fr.utbm.vi51.prj.drone.framework.math.Point2f;
import fr.utbm.vi51.prj.drone.framework.math.Vector2f;
import fr.utbm.vi51.prj.drone.ia.formation.Formation;
import java.lang.ref.WeakReference;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class Anchor {
  private final Vector2f relativePosition = new Vector2f();
  
  private final float relativeOrientation;
  
  private int index = (-1);
  
  private WeakReference<Anchor> weakParent;
  
  private WeakReference<Formation> weakFormation;
  
  public Anchor(final Vector2f position, final float orientation) {
    this.relativePosition.set(position);
    this.relativeOrientation = orientation;
  }
  
  WeakReference<Formation> setFormation(final Formation form) {
    WeakReference<Formation> _weakReference = new WeakReference<Formation>(form);
    return this.weakFormation = _weakReference;
  }
  
  @Pure
  public Anchor getParent() {
    Anchor _xifexpression = null;
    if ((this.weakParent == null)) {
      _xifexpression = null;
    } else {
      _xifexpression = this.weakParent.get();
    }
    return _xifexpression;
  }
  
  @Pure
  public int getIndex() {
    return this.index;
  }
  
  @Pure
  public Formation getFormation() {
    Formation _xifexpression = null;
    if ((this.weakFormation == null)) {
      _xifexpression = null;
    } else {
      _xifexpression = this.weakFormation.get();
    }
    return _xifexpression;
  }
  
  public int addChildAnchor(final Anchor child) {
    Formation form = this.getFormation();
    int index = form.addAnchor(child);
    WeakReference<Anchor> _weakReference = new WeakReference<Anchor>(this);
    child.weakParent = _weakReference;
    child.index = index;
    return index;
  }
  
  @Pure
  public Vector2f getGlobalOrientation() {
    Anchor previousAnchor = null;
    Anchor currentAnchor = this;
    float relOrientation = 0f;
    do {
      {
        float _relOrientation = relOrientation;
        relOrientation = (_relOrientation + currentAnchor.relativeOrientation);
        previousAnchor = currentAnchor;
        Anchor _parent = currentAnchor.getParent();
        currentAnchor = _parent;
      }
    } while((currentAnchor != null));
    Formation _formation = previousAnchor.getFormation();
    Vector2f _globalOrientation = _formation.getGlobalOrientation();
    Vector2f globalOrientation = _globalOrientation.clone();
    globalOrientation.turn(relOrientation);
    return globalOrientation;
  }
  
  @Pure
  public Point2f getGlobalPosition() {
    Anchor previousAnchor = null;
    Anchor currentAnchor = this;
    Vector2f relPosition = new Vector2f();
    do {
      {
        relPosition.operator_add(currentAnchor.relativePosition);
        previousAnchor = currentAnchor;
        Anchor _parent = currentAnchor.getParent();
        currentAnchor = _parent;
      }
    } while((currentAnchor != null));
    Formation _formation = previousAnchor.getFormation();
    Point2f _globalPosition = _formation.getGlobalPosition();
    Point2f globalPosition = _globalPosition.clone();
    Formation _formation_1 = previousAnchor.getFormation();
    Vector2f _globalOrientation = _formation_1.getGlobalOrientation();
    float _orientationAngle = _globalOrientation.getOrientationAngle();
    relPosition.turn(_orientationAngle);
    globalPosition.operator_add(relPosition);
    return globalPosition;
  }
}
