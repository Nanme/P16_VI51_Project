package environment;


public interface FrameworkGUI extends EnvironmentListener {
	
	/** Change the visibility of the GUI.
	 * 
	 * @param visible
	 */
	public void setVisible(boolean visible);
	
	/** Release all the resources own by the UI.
	 */
	public void dispose();

}
