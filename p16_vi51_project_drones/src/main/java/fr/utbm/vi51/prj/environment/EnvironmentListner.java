package fr.utbm.vi51.prj.environment;

import io.sarl.lang.core.EventListener;

public interface EnvironmentListner extends EventListener {

	public abstract void EnvironmentChanged(Object object);
	
}