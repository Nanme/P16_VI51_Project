package fr.utbm.vi51.prj.environment;

import java.util.ArrayList;
import java.util.UUID;

import fr.utbm.vi51.prj.drone.City;

public class Environment {
	private ArrayList<BuildingObj> cubes;
	private City city;
	private ArrayList<AgentBody> drones;
	
	//TODO Ajouter tous les immeubles
	public ArrayList<AgentBody> getDrones() {
		return drones;
	}
	public void setDrones(ArrayList<AgentBody> drones) {
		this.drones = drones;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public Environment() {
		city=new City();
		drones= new ArrayList<AgentBody>();
		cubes=new ArrayList<BuildingObj>();
		createListCubes();
	}
	public void addDrone(AgentBody drone){
		drones.add(drone);
	}

	public void renderEnv() {
		city.renderCity();
		if(drones!=null){
		for(EnvironmentObject d : drones){
			if(d.getBody()!=null)
			d.getBody().renderDrone();
		}
		}
	}
	
	void update(){
		
	}
	
	public AgentBody getAgentBody(UUID id){
		for(AgentBody drone : drones){
			if (drone.getId().equals(id)){
				return drone;
			}
		}
		return null;
	}
	
	public void createListCubes(){
		ArrayList<BuildingObj> block1=new ArrayList<BuildingObj>();
		block1.add(new BuildingObj(20, 20, 20, -65, 0, -35));//1
		block1.add(new BuildingObj(10, 40, 10, -45, 0, -40));//2
		block1.add(new BuildingObj(10, 30, 10, -35, 0, -35));//3
		block1.add(new BuildingObj(10, 20, 10, -15, 0, -40));//4
		block1.add(new BuildingObj(20, 30, 20, -95, 0, -35));//5
		block1.add(new BuildingObj(10, 20, 10, -105, 0, -35));//6
		block1.add(new BuildingObj(20, 30, 20, -105, 0, -65));//7
		block1.add(new BuildingObj(10, 10, 20, -85, 0, -65));//8
		block1.add(new BuildingObj(20, 20, 10, -65, 0, -70));//9
		block1.add(new BuildingObj(10, 30, 10, -45, 0, -70));//10
		block1.add(new BuildingObj(10, 10, 10, -35, 0, -70));//11
		block1.add(new BuildingObj(10, 30, 20, -15, 0, -65));//12
		block1.add(new BuildingObj(30, 60, 20, -105, 0, -5));//13
		block1.add(new BuildingObj(20, 50, 20, -65, 0, -5));//14
		block1.add(new BuildingObj(20, 40, 20, -45, 0, -5));//15
		block1.add(new BuildingObj(10, 20, 20, -15, 0, -5));//16
		ArrayList<BuildingObj> block2, block3, block4;
		block2=(ArrayList<BuildingObj>) block1.clone();
		for(BuildingObj b : block2){
			b.setX(b.getX()+105);
		}
		block3=(ArrayList<BuildingObj>) block1.clone();
		for(BuildingObj b : block3){
			b.setZ(b.getZ()+85);
		}
		block4=(ArrayList<BuildingObj>) block2.clone();
		for(BuildingObj b : block4){
			b.setZ(b.getZ()+85);
		}
		cubes.addAll(block1);
		cubes.addAll(block2);
		cubes.addAll(block3);
		cubes.addAll(block4);
	}
}