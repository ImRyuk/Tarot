package view;

import javax.swing.ImageIcon;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import cards.ArrayListCard;
import cards.Card;
import player.Player;

import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

public class PlayCardsRender extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6L;
	private JPanel contentPane;
	private Player player;
	private int count = 0;
	private ArrayListCard cardsSelected = new ArrayListCard();
	private ArrayList<JButton> buttons = new ArrayList<JButton>();

	/**
	 * Launch the application.
	 */
	public void run() {
		try {
			PlayCardsRender frame = new PlayCardsRender(player);
			frame.setSize(800, 500);
			frame.setVisible(true);
			JOptionPane.showMessageDialog(null, 
                    "Les cartes ont été mélangées! A vous de choisir", 
                    "ATTENTION", 
                    JOptionPane.WARNING_MESSAGE);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public PlayCardsRender(Player player) {
		this.player = player;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 861, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel CardsPanel = new JPanel();
		JScrollPane panelScroll = new JScrollPane(CardsPanel);
		panelScroll.setBounds(81, 91, 677, 247);
		contentPane.add(panelScroll);
		CardsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel labelTitle = new JLabel("Choisissez 5 Cartes");
		labelTitle.setFont(new Font("Tahoma", Font.PLAIN, 25));
		labelTitle.setBounds(278, 11, 291, 69);
		contentPane.add(labelTitle);
		
		JLabel labelNbCards = new JLabel("Nombre de cartes choisies : ");
		labelNbCards.setBounds(81, 69, 176, 25);
		contentPane.add(labelNbCards);
		
		JButton btnPrediction = new JButton("Lancer la pr\u00E9diction");
		btnPrediction.setBounds(325, 384, 198, 43);
		contentPane.add(btnPrediction);
		
		ArrayListCard cards = player.getCards();
		cards.shuffleArray();
		
    	for(int i=0; i < cards.size(); i++) {
    	  	  
    	  	  Card card = (Card) cards.get(i);
    	  	  String image = card.getImage().toString();
    	  	  ImageIcon iconBackCard =  new ImageIcon(new ImageIcon("files/img/cards/card-back-side.jpg").getImage().getScaledInstance(100, 200, Image.SCALE_DEFAULT));
    	  	  JButton button =  new JButton(iconBackCard);
    	  	  
    	  	  buttons.add(button);
    	  	  
    	  	  button.addActionListener(new ActionListener() {
    	  		  @Override
    	  		  public void actionPerformed(ActionEvent arg0) {
    	  			if(count == 4) {
    	  				for(JButton button : buttons)
    	  					button.setEnabled(false);
    	    	  	  }
    	  			cardsSelected.add(card);
    	  			button.setEnabled(false);
    	  			ImageIcon icon =  new ImageIcon(new ImageIcon(image).getImage().getScaledInstance(100, 200, Image.SCALE_DEFAULT));
    	  			button.setIcon(icon);
    	  			count++;
    	  			labelNbCards.setText("Nombre de cartes choisies " + count);
    	  			
    	  		  }
    	  	  });
    	  	CardsPanel.add(button);
    	    }
    	
    	btnPrediction.addActionListener(new ActionListener() {
	  		  @Override
	  		  public void actionPerformed(ActionEvent arg0) {
	  			if(count == 5){
	  				
	  				PredictionRender prediction = new PredictionRender(cardsSelected, player);
	  				prediction.run();
		  			} else {
		  				JOptionPane.showMessageDialog(null, 
		                        "Vous n'avez pas selectionné 5 cartes!", 
		                        "ATTENTION", 
		                        JOptionPane.WARNING_MESSAGE);
		  			}
	  			
	  		  }
	  	  });
    	btnPrediction.addActionListener(e -> this.dispose());
	}
}
