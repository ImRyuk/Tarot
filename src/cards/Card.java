package cards;

import java.io.File;
import java.io.Serializable;

public class Card implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6L;
	
	
	//A Card is made of 5 Great 
	public int index;
	public String name;
	public String description;
	public String atout; 
	public String obstacle; 
	public String actionToLead; 
	public String result; 
	public String synthesis;
	public File image;
	
	public Card(int index, String name, String description, String atout, String obstacle,String actionToLead, String result,String synthesis, File image){
		this.index = index;
		this.name = name;
		this.description = description;
		this.atout = atout;
		this.obstacle = obstacle;
		this.actionToLead = actionToLead;
		this.result = result;
		this.synthesis = synthesis;
		this.image = image;
	
	}

	public void addDescription(String description) {
		this.description = description;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public String getAtout() {
		return this.atout;
	}
	
	public String getObstacle() {
		return this.obstacle;
	}
	
	public String getAction() {
		return this.actionToLead;
	}
	
	public String getResult() {
		return this.result;
	}
	
	public String getSynthesis() {
		return this.synthesis;
	}

	public File getImage() {
		return this.image;
	}
	
	public String toString() {
		return this.name;
	}
	
}