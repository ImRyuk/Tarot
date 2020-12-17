package cards;

import java.io.File;
import java.io.Serializable;

public class Card implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6L;
	
	
	//A Card is made of 5 Great 
	private String name;
	private String description;
	private String atout; 
	private String obstacle; 
	private String actionToLead; 
	private String result; 
	private String synthesis;
	private File image;
	
	public Card( String name, String description, String atout, String obstacle,String actionToLead, String result,String synthesis, File image){
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
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getAtout() {
		return this.atout;
	}
	
	public void setAtout(String atout) {
		this.atout = atout;
	}
	
	public String getObstacle() {
		return this.obstacle;
	}
	
	public void setObstacle(String obstacle) {
		this.obstacle = obstacle;
	}
	
	public String getAction() {
		return this.actionToLead;
	}
	
	public void setAction(String actionToLead) {
		this.actionToLead = actionToLead;
	}
	
	public String getResult() {
		return this.result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public String getSynthesis() {
		return this.synthesis;
	}
	
	public void setSynthesis(String synthesis) {
		this.synthesis = synthesis;
	}

	public File getImage() {
		return this.image;
	}
	
	public void setImage(File image) {
		this.image = image;
	}
	
	public String toString() {
		return this.name;
	}
	
}