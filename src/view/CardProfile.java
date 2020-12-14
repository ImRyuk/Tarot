package view;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import cards.ArrayListCard;
import cards.Card;
import player.Player;

import javax.swing.JTextPane;
import javax.swing.JCheckBox;
import java.awt.Font;

public class CardProfile extends JPanel {
    private static final long serialVersionUID = 1L;

    public Card card;
    public JPanel panel;
    public Player player;
    
    public CardProfile(JPanel panel, Card card, Player player) {
        this.card = card;
        this.panel = panel;
        this.player = player;
    }
    
    public void showWindow() {
    	
    	JFrame f = new JFrame("frame");
        
        //create a panel 
        JPanel p =new JPanel(); 
        
        JLabel label = new JLabel();
        label.setText(card.getName());
        
	  	  JButton button =  new JButton("Revenir à la collection");
	  	  
	  	  button.addActionListener(new ActionListener() {
	  		  
	  		  @Override
	  		  public void actionPerformed(ActionEvent arg0) {
	  			  f.setVisible(false);
	  	      
	  		  }
	  	  });
        
        CardImage image = new CardImage(card.getImage());
        
        JTextArea description = new JTextArea();
        description.setText(card.getDescription());
        JTextArea atout = new JTextArea();
        atout.setText(card.getAtout());
        JTextArea obstacle = new JTextArea();
        obstacle.setText(card.getObstacle());
        JTextArea actionToLead = new JTextArea();
        actionToLead.setText(card.getAction());
        JTextArea result = new JTextArea();
        result.setText(card.getResult());
        JTextArea synthesis = new JTextArea();
        synthesis.setText(card.getSynthesis());
        
        JLabel descriptionLabel = new JLabel();
        descriptionLabel.setText("Description");
        JLabel atoutLabel = new JLabel();
        atoutLabel.setText("Atout");
        JLabel obstacleLabel = new JLabel();
        obstacleLabel.setText("Obstacle");
        JLabel actionToLeadLabel = new JLabel();
        actionToLeadLabel.setText("Action à mener");
        JLabel resultLabel = new JLabel();
        resultLabel.setText("Résultat");
        JLabel synthesisLabel = new JLabel();
        synthesisLabel.setText("Synthèse");
        
        p.add(button);
        p.add(image);
        p.add(label);
        p.add(descriptionLabel);
        p.add(description);
        p.add(atoutLabel);
        p.add(atout);
        p.add(obstacleLabel);
        p.add(obstacle);
        p.add(actionToLeadLabel);
        p.add(actionToLead);
        p.add(resultLabel);
        p.add(result);
        p.add(synthesisLabel);
        p.add(synthesis);
        f.getContentPane().add(p); 
          
        //set the size of frame 
        f.setSize(800,1000); 
           
        f.show(); 
    	
    }
    
}