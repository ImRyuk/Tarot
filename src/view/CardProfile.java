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

public class CardProfile extends JPanel {
    private static final long serialVersionUID = 1L;

    public Card card;
    public JPanel panel;
    
    public CardProfile(JPanel panel, Card card) {
        this.card = card;
        this.panel = panel;
    }
    
    public void showWindow() {
    	
    	JFrame f = new JFrame("frame");
        
        //create a panel 
        JPanel p =new JPanel(); 
        
        CardImage image = new CardImage(card.getImage());
        
        p.add(image);
   
        f.add(p); 
          
        //set the size of frame 
        f.setSize(800,1000); 
           
        f.show(); 
    	
    }
    
}