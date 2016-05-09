package fr.utbm.vi51.prj.drone.ia.formation;

import fr.utbm.vi51.prj.drone.framework.math.Vector2f;
import fr.utbm.vi51.prj.drone.ia.formation.Anchor;
import fr.utbm.vi51.prj.drone.ia.formation.Formation;
import fr.utbm.vi51.prj.drone.ia.formation.FormationFactory;
import org.eclipse.xtext.xbase.lib.IntegerRange;

@SuppressWarnings("all")
public class CircleFormationFactory implements FormationFactory {
  private final float bodySizeOnPerimeter;
  
  public CircleFormationFactory(final float bodySizeOnPerimeter) {
    this.bodySizeOnPerimeter = bodySizeOnPerimeter;
  }
  
  @Override
  public Formation build(final int nbAnchors) {
    Vector2f _vector2f = new Vector2f(0, 0);
    Anchor anchor = new Anchor(_vector2f, 0);
    Formation f = new Formation(anchor);
    double arc = ((2 * Math.PI) / nbAnchors);
    double radius = (this.bodySizeOnPerimeter / arc);
    IntegerRange _upTo = new IntegerRange(1, nbAnchors);
    for (final Integer i : _upTo) {
      {
        float angle = ((float) (((2 * Math.PI) / nbAnchors) * ((i).intValue() - 0.5)));
        Vector2f v = new Vector2f(radius, 0);
        v.turn(angle);
        Anchor a = new Anchor(v, angle);
        anchor.addChildAnchor(a);
      }
    }
    return f;
  }
}
