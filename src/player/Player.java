package player;
 

import cards.ArrayListCard;

public class Player {
	
	private ArrayListCard cards;

//	ArrayListCard cards = new ArrayListCard();
	
	public Player(ArrayListCard cards){
		this.cards = cards;
	}
	
	public ArrayListCard getCards() {
		return this.cards;
	}
	
	public String checkCollection() {
		String string = "";
		
		for(int i = 0; i < cards.size; i++) {
			string += ("Card number: " + i + "\nName: " + cards.get(i) + "\n\r");
		}
		
		return string;
	}
	
}