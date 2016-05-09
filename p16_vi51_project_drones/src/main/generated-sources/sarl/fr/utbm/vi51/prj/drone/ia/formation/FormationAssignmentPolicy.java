package fr.utbm.vi51.prj.drone.ia.formation;

import fr.utbm.vi51.prj.drone.ia.formation.Anchor;
import fr.utbm.vi51.prj.drone.ia.formation.Formation;

@SuppressWarnings("all")
public interface FormationAssignmentPolicy {
  public abstract Formation getFormation();
  
  public abstract Anchor assignAnchorToMe();
}
