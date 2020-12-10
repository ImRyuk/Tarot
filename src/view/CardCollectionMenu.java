package view;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import cards.ArrayListCard;
import cards.Card;

public class CardCollectionMenu extends JPanel {
    private static final long serialVersionUID = 1L;

    public ArrayListCard cards;
    public JPanel panel;
    public JFrame frame;
    
    public CardCollectionMenu(JPanel panel, ArrayListCard cards, JFrame frame) {
        this.cards = cards;
        this.panel = panel;
        this.frame = frame;
    }
    
    
    
    public void render() {
    	for(int i=0; i < cards.size(); i++) {
    	  	  
    	  	  Card card = (Card) cards.get(i);
    	  	  String image = card.getImage().toString();
    	  	  ImageIcon icon =  new ImageIcon(new ImageIcon(image).getImage().getScaledInstance(100, 200, Image.SCALE_DEFAULT));
    	  	  JButton button =  new JButton(card.getName(), icon);
    	  	  
    	  	  button.addActionListener(new ActionListener() {
    	  		  
    	  		  @Override
    	  		  public void actionPerformed(ActionEvent arg0) {
    	  			  frame.setVisible(false);
    	  			  CardProfile cd = new CardProfile(panel,card);
    	  			  cd.showWindow();
    	  		  }
    	  	  });
    	  	  
    	  	  panel.add(button);
    	    }
    }
    
}