package fr.utbm.vi51.prj.drone.ia.formation;

import fr.utbm.vi51.prj.drone.ia.formation.Formation;

@SuppressWarnings("all")
public interface FormationFactory {
  public abstract Formation build(final int nbAnchors);
}
