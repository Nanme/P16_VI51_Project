package environment;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;

import fr.utbm.vi51.prj.drone.DisplayTest;
import fr.utbm.vi51.prj.drone.framework.util.LocalizedString;
import fr.utbm.vi51.prj.drone.framework.util.Resources;
import fr.utbm.vi51.prj.drone.ia.evt.DynamicType;

public class BehaviorTypeSelector extends JDialog {

	private static final long serialVersionUID = -1718324646190007840L;
	
	private DynamicType behaviorType = null;

	/** Open the dialog box for selecting a type of behavior.
	 * 
	 * @return the selected type or <code>null</code> if the dialog box was manually closed.
	 */
	public static DynamicType open() {
		BehaviorTypeSelector selector = new BehaviorTypeSelector();
		selector.setVisible(true);
		DynamicType type = selector.getSelectedBehaviorType();
		selector.dispose();
		return type;
	}
	
	protected BehaviorTypeSelector() {
//		URL imageUrl;
//		Icon icon;
//		String label;
//		
//		setTitle(LocalizedString.getString(BehaviorTypeSelector.class, "TITLE"));
//		setModal(true);
//		
//		setLayout(new GridLayout(2, 1));

//		//imageUrl = Resources.getResource(BehaviorTypeSelector.class, "kinematic.png");
//	//	icon = new ImageIcon(imageUrl);
//		label = LocalizedString.getString(BehaviorTypeSelector.class, "KINEMATIC_BUTTON");
//		//JButton kinematicButton = new JButton(label, icon);
//		//kinematicButton.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				synchronized(BehaviorTypeSelector.this) {
//					BehaviorTypeSelector.this.behaviorType = DynamicType.STEERING;
//				}
//				BehaviorTypeSelector.this.setVisible(false);
//			}
//		});
//		add(kinematicButton);
//
//		imageUrl = Resources.getResource(BehaviorTypeSelector.class, "steering.png");
//		icon = new ImageIcon(imageUrl);
//		label = LocalizedString.getString(BehaviorTypeSelector.class, "STEERING_BUTTON");
//		JButton steeringButton = new JButton(label, icon);
//		steeringButton.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				synchronized(BehaviorTypeSelector.this) {
//					BehaviorTypeSelector.this.behaviorType = DynamicType.STEERING;
//				}
//				BehaviorTypeSelector.this.setVisible(false);
//			}
//		});
//		add(steeringButton);
//		
//		pack();
//		Dimension d = getSize();
//		setLocation(-d.width/2, -d.height/2);
//		setLocationRelativeTo(null);
		
		DisplayTest r = new DisplayTest();
        r.Start();
	}

	/** Replies the selected behavior type.
	 *
	 * @return the selected behavior type. It could be <code>null</code> if the user
	 * has close the dialog box without selecting a type.
	 */
	public synchronized DynamicType getSelectedBehaviorType()  {
		return this.behaviorType;
	}

}