package view;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import cards.Card;
import player.Player;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JTextArea;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;

public class CardProfileRender extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6L;
	private JPanel contentPane;
	private Card card;
	private Player player;
	private boolean changedImage = false;
	private File changedImageFile = null;

	/**
	 * Launch the application.
	 */
	public void run() {
		try {
			CardProfileRender frame = new CardProfileRender(card, player);
			frame.setVisible(true);
			frame.setSize(800,720);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public CardProfileRender(Card card, Player player) {
		this.card = card;
		this.player = player;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 720);
		
		contentPane = new JPanel();
		
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Navigation");
		JMenuItem save, cancel, back;  
		save = new JMenuItem("Enregistrer les modifications");  
        cancel = new JMenuItem("Annuler les modifications");  
        back = new JMenuItem("Revenir à la collection");  
        menu.add(save); menu.add(cancel); menu.add(back);
        
        menuBar.add(menu);
        setJMenuBar(menuBar);
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		CardImage cardImage = new CardImage(card.getImage());
		cardImage.setBounds(21, 157, 260, 410);
		contentPane.add(cardImage);
		
		JLabel lblNewLabel = new JLabel(card.getName());
		lblNewLabel.setBounds(90, 11, 126, 25);
		contentPane.add(lblNewLabel);
		
		JTextArea descriptionText = new JTextArea(card.getDescription());
		JScrollPane scrollDescription = new JScrollPane(descriptionText); 
		scrollDescription.setBounds(21, 47, 260, 87);
		contentPane.add(scrollDescription);
		
		JTextArea atout = new JTextArea(card.getAtout());
		JScrollPane scrollAtout = new JScrollPane(atout); 
		scrollAtout.setBounds(291, 36, 470, 68);
		contentPane.add(scrollAtout);
		
		JTextArea obstacle = new JTextArea(card.getObstacle());
		JScrollPane scrollObstacle = new JScrollPane(obstacle); 
		scrollObstacle.setBounds(291, 145, 470, 66);
		contentPane.add(scrollObstacle);
		
		JTextArea action = new JTextArea(card.getAction());
		JScrollPane scrollAction = new JScrollPane(action); 
		scrollAction.setBounds(293, 250, 468, 89);
		contentPane.add(scrollAction);
		
		JTextArea result = new JTextArea(card.getResult());
		JScrollPane scrollResult = new JScrollPane(result); 
		scrollResult.setBounds(291, 376, 470, 110);
		contentPane.add(scrollResult);
		
		JTextArea synthesis = new JTextArea(card.getSynthesis());
		JScrollPane scrollSynthesis = new JScrollPane(synthesis); 
		scrollSynthesis.setBounds(291, 522, 472, 113);
		contentPane.add(scrollSynthesis);
		
		JLabel labelAtout = new JLabel("Atout");
		labelAtout.setBounds(482, 16, 60, 14);
		contentPane.add(labelAtout);
		
		JLabel labelObstacle = new JLabel("Obstacle");
		labelObstacle.setBounds(493, 120, 60, 14);
		contentPane.add(labelObstacle);
		
		JLabel labelAction = new JLabel("Action");
		labelAction.setBounds(504, 222, 60, 14);
		contentPane.add(labelAction);
		
		JLabel labelResultat = new JLabel("R\u00E9sultat");
		labelResultat.setBounds(493, 351, 60, 14);
		contentPane.add(labelResultat);
		
		JLabel labelSynthesis = new JLabel("Synth\u00E8se");
		labelSynthesis.setBounds(493, 497, 60, 14);
		contentPane.add(labelSynthesis);
		
		JButton changeImage = new JButton("Changer l'image");
		changeImage.setBounds(74, 578, 158, 57);
		contentPane.add(changeImage);
		
		
		changeImage.addActionListener(new ActionListener() {
	  		  
	  		  @Override
	  		  public void actionPerformed(ActionEvent arg0) {
	  			JFileChooser choix = new JFileChooser();
	  			
	  			//Filter only the images files
	  			FileNameExtensionFilter imageFilter = new FileNameExtensionFilter("Image files", ImageIO.getReaderFileSuffixes());
	  			choix.setFileFilter(imageFilter);
	  			
	  			int retour=choix.showOpenDialog(contentPane);
	  			if(retour==JFileChooser.APPROVE_OPTION){
	  				
	  			 changedImage = true;
	  			 changedImageFile = choix.getSelectedFile();
	  			 JOptionPane.showMessageDialog(null, 
                        "L'image a été chargée, enregistrer les modifications pour voir les changements!", 
                        "ATTENTION", 
                        JOptionPane.WARNING_MESSAGE);
	  			} else {
	  				JOptionPane.showMessageDialog(null, 
	                        "Aucune image selectionnée!", 
	                        "ATTENTION", 
	                        JOptionPane.WARNING_MESSAGE);
	  			}
	  		  }
	  	  });
		
		save.addActionListener(new ActionListener() {
	  		  
	  		  @Override
	  		  public void actionPerformed(ActionEvent arg0) {
	  			
	  		  card.setDescription(descriptionText.getText());
	  		  card.setAtout(atout.getText());
	  		  card.setObstacle(obstacle.getText());
	  		  card.setResult(result.getText());
	  		  card.setSynthesis(synthesis.getText());
	  		  
	  		  if(changedImage) {
	  			card.setImage(changedImageFile);
	  		  }
	  		  CardProfileRender frame = new CardProfileRender(card, player);
	  		  frame.run();
	  		  }
	  	  });
      save.addActionListener(e -> this.dispose());
      
      cancel.addActionListener(new ActionListener() {
	  		  
	  		  @Override
	  		  public void actionPerformed(ActionEvent arg0) {
	  			
	  		  CardProfileRender frame = new CardProfileRender(card, player);
	  		  frame.run();
	  		  }
	  	  });
      cancel.addActionListener(e -> this.dispose());
      
      back.addActionListener(new ActionListener() {
	  		  
	  		  @Override
	  		  public void actionPerformed(ActionEvent arg0) {
	  			CardsCollectionRender frame = new CardsCollectionRender(player);
	  			frame.run();
	  		  }
	  	  });
      back.addActionListener(e -> this.dispose());
		
	}
}
