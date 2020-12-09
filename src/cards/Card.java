package cards;


public class Card {

	//A Card is made of 5 Great 
	public int index;
	public String name;
	public String description;
	public String atout; 
	public String obstacle; 
	public String actionToLead; 
	public String result; 
	public String synthesis; 
	
	public Card(int index, String name, String description, String atout, String obstacle,String actionToLead, String result,String synthesis){
		this.index = index;
		this.name = name;
		this.description = description;
		this.atout = atout;
		this.obstacle = obstacle;
		this.actionToLead = actionToLead;
		this.result = result;
		this.synthesis = synthesis;
	}

	public void addDescription(String description) {
		this.description = description;
	}
	
	public String toString() {
		return this.name + " : " + this.description;
	}
	
}