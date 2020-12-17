package player;
 

import java.io.Serializable;

import cards.ArrayListCard;

public class Player implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6L;
	private ArrayListCard cards;
	private String name;

//	ArrayListCard cards = new ArrayListCard();
	
	public Player(ArrayListCard cards, String name){
		this.cards = cards;
		this.name = name;
	}
	
	public ArrayListCard getCards() {
		return this.cards;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String checkCollection() {
		String string = "";
		
		for(int i = 0; i < cards.size; i++) {
			string += ("Card number: " + i + "\nName: " + cards.get(i) + "\n\r");
		}
		
		return string;
	}
	
}