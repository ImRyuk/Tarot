package view;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import cards.ArrayListCard;
import cards.Card;
import player.Player;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class CardsCollectionRender extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Player player;
	
	/**
	 * Launch the application.
	 */
	public void run() {
		try {
			CardsCollectionRender frame = new CardsCollectionRender(player);
			frame.setVisible(true);
			frame.setSize(800,600);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	/**
	 * Create the frame.
	 */
	public CardsCollectionRender(Player player) {
		this.player = player;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 582);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		JScrollPane panelScroll = new JScrollPane(panel); 
		panelScroll.setBounds(70, 72, 617, 240);
		contentPane.add(panelScroll);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel labelName = new JLabel("Nom du joueur: " + player.getName() );
		labelName.setBounds(10, 11, 187, 14);
		contentPane.add(labelName);
		
		JLabel nbcards = new JLabel("Nombre de cartes: " + player.getCards().size);
		nbcards.setBounds(70, 47, 127, 14);
		contentPane.add(nbcards);
		
		JButton btnAddCard = new JButton("Ajouter une Carte");
		btnAddCard.setBounds(70, 338, 146, 42);
		contentPane.add(btnAddCard);
		
		JButton btnExportPlayer = new JButton("Exporter Joueur");
		btnExportPlayer.setBounds(70, 468, 146, 42);
		contentPane.add(btnExportPlayer);
		
		JTextField textFieldFile = new JTextField();
		textFieldFile.setBounds(70, 427, 146, 20);
		contentPane.add(textFieldFile);
		textFieldFile.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nom du fichier pour l exportation");
		lblNewLabel.setBounds(70, 396, 214, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnPlay = new JButton("Jouer");
		btnPlay.setBounds(411, 338, 247, 84);
		contentPane.add(btnPlay);
		
		JButton btnSearch = new JButton("Chercher");
		btnSearch.setBounds(664, 18, 89, 23);
		contentPane.add(btnSearch);
		
		JTextField textFieldSearch = new JTextField();
		textFieldSearch.setBounds(488, 19, 86, 20);
		contentPane.add(textFieldSearch);
		textFieldSearch.setColumns(10);
		
		JRadioButton rdbtnIndex = new JRadioButton("Index");
		rdbtnIndex.setSelected(true);
		rdbtnIndex.setBounds(587, 7, 71, 23);
		contentPane.add(rdbtnIndex);
		
		JRadioButton rdbtnName = new JRadioButton("Nom");
		rdbtnName.setBounds(587, 33, 71, 23);
		contentPane.add(rdbtnName);
		
		rdbtnIndex.addActionListener(new ActionListener() {
	  		  
	  		  @Override
	  		  public void actionPerformed(ActionEvent arg0) {
	  			  //Searching with the name
	  			rdbtnName.setSelected(false);
	  		  }
	  	  });
		
		rdbtnName.addActionListener(new ActionListener() {
	  		  
	  		  @Override
	  		  public void actionPerformed(ActionEvent arg0) {
	  			  //Searching with the name
	  			rdbtnIndex.setSelected(false);
	  		  }
	  	  });
		
		JLabel labelSearchCard = new JLabel("Chercher Carte");
		labelSearchCard.setBounds(389, 22, 108, 14);
		contentPane.add(labelSearchCard);
		
		btnSearch.addActionListener(new ActionListener() {
	  		  
	  		  @Override
	  		  public void actionPerformed(ActionEvent arg0) {
	  			  //Searching with the name
	  			  if(rdbtnName.isSelected() && !rdbtnIndex.isSelected()) {
	  				  String searchName = textFieldSearch.getText();
	  				  Card searchedCard = (Card) player.getCards().get(searchName);
	  				  CardProfileRender cdp = new CardProfileRender(searchedCard, player);
	  				  cdp.run();
	  			  } 
	  			  //Searching with the index
	  			  else if (rdbtnIndex.isSelected() && !rdbtnName.isSelected()) {
	  				String search = textFieldSearch.getText();
	  				int searchIndex = Integer.parseInt(search);
	  				Card searchedCard = (Card) player.getCards().get(searchIndex);
	  				CardProfileRender cdp = new CardProfileRender(searchedCard, player);
	  				cdp.run();
	  			  } else {
	  				JOptionPane.showMessageDialog(null, 
	                        "Merci de cocher un des deux selecteurs seulement!", 
	                        "ATTENTION", 
	                        JOptionPane.WARNING_MESSAGE);
	  			  }
	  		  }
	  	  });
		
		btnPlay.addActionListener(new ActionListener() {
	  		  
	  		  @Override
	  		  public void actionPerformed(ActionEvent arg0) {
	  			  //Searching with the name
	  			  PlayCardsRender play = new PlayCardsRender(player);
	  			  play.run();
	  		  }
	  	  });
		btnPlay.addActionListener(e -> this.dispose());
		
		
		btnExportPlayer.addActionListener(new ActionListener() {
	  		  
	  		  @Override
	  		  public void actionPerformed(ActionEvent arg0) {
	  			  if(!textFieldFile.getText().isEmpty()) {
	  				SerializePlayer(player, textFieldFile.getText());
		  			JOptionPane.showMessageDialog(null, 
	                        "Le joueur a été exporté", 
	                        "ATTENTION", 
	                        JOptionPane.WARNING_MESSAGE);
	  			  } else {
	  				JOptionPane.showMessageDialog(null, 
	                        "Merci d'entrer un nom pour le fichier!", 
	                        "ATTENTION", 
	                        JOptionPane.WARNING_MESSAGE);
	  			  }
	  		  }
	  	  });
		
		
		btnAddCard.addActionListener(new ActionListener() {
	  		  
	  		  @Override
	  		  public void actionPerformed(ActionEvent arg0) {
	  			
	  		  NewCardRender nc = new NewCardRender(player);
  			  nc.run();
	  		  }
	  	  });
		btnAddCard.addActionListener(e -> this.dispose());
		
		ArrayListCard cards = player.getCards();
    	for(int i=0; i < cards.size(); i++) {
    	  	  
    	  	  Card card = (Card) cards.get(i);
    	  	  String image = card.getImage().toString();
    	  	  ImageIcon icon =  new ImageIcon(new ImageIcon(image).getImage().getScaledInstance(100, 200, Image.SCALE_DEFAULT));
    	  	  JButton button =  new JButton(card.getName(), icon);
    	  	  
    	  	  button.addActionListener(new ActionListener() {
    	  		  
    	  		  @Override
    	  		  public void actionPerformed(ActionEvent arg0) {
    	  			
    	  		  CardProfileRender cd = new CardProfileRender(card, player);
  	  			  cd.run();
    	  		  }
    	  	  });
    	  	button.addActionListener(e -> this.dispose());
    	  	panel.add(button);
    	    }
  
	}
	
	public static void SerializePlayer(Player p, String fileName) {
		  try
	      {
	          FileOutputStream fos = new FileOutputStream("files/serialization/" + fileName);
	          ObjectOutputStream oos = new ObjectOutputStream(fos);
	          oos.writeObject(p);
	          oos.close();
	          fos.close();
	      } 
		      catch (IOException ioe) 
		      {
		          ioe.printStackTrace();
		      }
		}
}
