package fr.utbm.vi51.prj.drone.ia.formation;

import fr.utbm.vi51.prj.drone.ia.formation.Anchor;
import fr.utbm.vi51.prj.drone.ia.formation.Formation;
import fr.utbm.vi51.prj.drone.ia.formation.FormationAssignmentPolicy;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class FIFOAssignmentPolicy implements FormationAssignmentPolicy {
  private final Formation formation;
  
  private int firstFreeAnchorIndex = 0;
  
  public FIFOAssignmentPolicy(final Formation formation) {
    this.formation = formation;
  }
  
  @Override
  @Pure
  public Formation getFormation() {
    return this.formation;
  }
  
  @Override
  public Anchor assignAnchorToMe() {
    synchronized (this) {
      int _anchorCount = this.formation.getAnchorCount();
      boolean _lessThan = (this.firstFreeAnchorIndex < _anchorCount);
      if (_lessThan) {
        Anchor anchor = this.formation.getAnchor(this.firstFreeAnchorIndex);
        this.firstFreeAnchorIndex++;
        return anchor;
      }
      return null;
    }
  }
}
