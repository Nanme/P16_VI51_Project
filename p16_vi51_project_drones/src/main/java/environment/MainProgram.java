package environment;


import fr.utbm.vi51.prj.drone.Drone;
import fr.utbm.vi51.prj.drone.framework.util.LocalizedString;
import fr.utbm.vi51.prj.drone.framework.util.SpawnMapping;
import fr.utbm.vi51.prj.drone.ia.evt.AgentBody;
import fr.utbm.vi51.prj.drone.ia.evt.DynamicType;
import io.sarl.lang.core.Agent;

public class MainProgram {

	private static float WORLD_SIZE_X = 700;
	private static float WORLD_SIZE_Y = 700;
	private static int NUMBER_DRONE = 1;
	
	/** Main program.
	 * 
	 * @param argv are the command line arguments.
	 * @throws Exception 
	 */	
	public static void main(String[] argv) throws Exception {
		
		System.out.println(LocalizedString.getString(MainProgram.class, "INTRO_MESSAGE")); //$NON-NLS-1$
		
		DynamicType type = BehaviorTypeSelector.open();
		if (type == null) {
			System.exit(0);
		}

		WorldModel environment = new WorldModel(WORLD_SIZE_X, WORLD_SIZE_Y);
		
		for (int i = 0; i < NUMBER_DRONE; ++i) {
			environment.createDrone();
		}

		FrameworkGUI gui = new GUI(WORLD_SIZE_X, WORLD_SIZE_Y, environment.getTimeManager());
		
		FrameworkLauncher.launchSimulation(
				environment,
				new ApplicationMapping(),
				type,
				gui);
	}
	
	private static class ApplicationMapping extends SpawnMapping {

		@Override
		public Class<? extends Agent> getAgentTypeForBody(AgentBody body) {
			return Drone.class;
		}
		
	}
}