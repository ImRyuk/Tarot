package Prediction;

import java.io.Serializable;
import cards.ArrayListCard;
import cards.Card;

public class Prediction implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6L;
	
	
	//A Card is made of 5 Great 
	private ArrayListCard cards;
	private Card atoutCard;
	private Card obstacleCard;
	private Card resultCard;
	private Card synthesisCard;
	private Card actionToLeadCard;
	
	public Prediction(ArrayListCard cards){
		this.cards = cards;
		
		this.cards.shuffleArray();
		
		this.atoutCard = (Card) this.cards.get(0);
		
		this.obstacleCard = (Card) this.cards.get(1);
		
		this.resultCard = (Card) this.cards.get(2);
		
		this.synthesisCard = (Card) this.cards.get(3);
		
		this.actionToLeadCard = (Card) this.cards.get(4);
	}
	
	public ArrayListCard getCards() {
		return this.cards;
	}
	
	public Card getAtoutCard() {
		return this.atoutCard;
	}
	
	public Card getObstacleCard() {
		return this.obstacleCard;
	}
	
	public Card getActionCard() {
		return this.actionToLeadCard;
	}
	
	public Card getResultCard() {
		return this.resultCard;
	}
	
	public Card getSynthesisCard() {
		return this.synthesisCard;
	}
	
	
}