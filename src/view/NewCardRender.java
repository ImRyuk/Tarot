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
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class NewCardRender extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6L;
	private JPanel contentPane;
	private Player player;
	private File image = null;
	private boolean changedImage = false;
	/**
	 * Launch the application.
	 */
	public void run() {
		try {
			NewCardRender frame = new NewCardRender(player);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	/**
	 * Create the frame.
	 */
	public NewCardRender(Player player) {
		this.player = player;
		
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Navigation");
		JMenuItem back;   
        back = new JMenuItem("Revenir à la collection");  
        menu.add(back);
        
        menuBar.add(menu);
        setJMenuBar(menuBar);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 793, 595);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(40, 39, 713, 482);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel labelName = new JLabel("Nom");
		labelName.setBounds(10, 22, 43, 24);
		panel.add(labelName);
		
		JLabel labelDescription = new JLabel("Description");
		labelDescription.setBounds(10, 71, 43, 24);
		panel.add(labelDescription);
		
		JLabel labelAtout = new JLabel("Atout");
		labelAtout.setBounds(10, 136, 43, 24);
		panel.add(labelAtout);
		
		JLabel labelObstacle = new JLabel("Obstacle");
		labelObstacle.setBounds(10, 206, 43, 24);
		panel.add(labelObstacle);
		
		JLabel labelAction = new JLabel("Action");
		labelAction.setBounds(10, 272, 43, 24);
		panel.add(labelAction);
		
		JLabel labelResult = new JLabel("R\u00E9sultat");
		labelResult.setBounds(10, 364, 43, 24);
		panel.add(labelResult);
		
		JLabel labelSynthesis = new JLabel("Synth\u00E8se");
		labelSynthesis.setBounds(10, 428, 86, 24);
		panel.add(labelSynthesis);
		
		JButton btnAddImage = new JButton("Ajouter Image");
		btnAddImage.setBounds(555, 63, 102, 40);
		panel.add(btnAddImage);
		
		JButton btnCreateCard = new JButton("Cr\u00E9er");
		btnCreateCard.setBounds(555, 400, 102, 40);
		panel.add(btnCreateCard);
		
		JTextField textName = new JTextField();
		textName.setBounds(74, 24, 172, 20);
		panel.add(textName);
		textName.setColumns(10);
		
		JTextArea textDescription = new JTextArea();
		JScrollPane scrollDescription = new JScrollPane(textDescription); 
		scrollDescription.setBounds(74, 71, 426, 40);
		panel.add(scrollDescription);
		
		JTextArea textAtout = new JTextArea();
		JScrollPane scrollAtout = new JScrollPane(textAtout); 
		scrollAtout.setBounds(74, 136, 426, 40);
		panel.add(scrollAtout);
		
		JTextArea textObstacle = new JTextArea();
		JScrollPane scrollObstacle = new JScrollPane(textObstacle); 
		scrollObstacle.setBounds(74, 206, 426, 40);
		panel.add(scrollObstacle);
		
		JTextArea textAction= new JTextArea();
		JScrollPane scrollAction = new JScrollPane(textAction); 
		scrollAction.setBounds(74, 272, 426, 40);
		panel.add(scrollAction);
		
		JTextArea textResult = new JTextArea();
		JScrollPane scrollResult = new JScrollPane(textResult); 
		scrollResult.setBounds(74, 348, 426, 40);
		panel.add(scrollResult);
		
		JTextArea textSynthesis = new JTextArea();
		JScrollPane scrollSynthesis = new JScrollPane(textSynthesis); 
		scrollSynthesis.setBounds(74, 408, 426, 40);
		panel.add(scrollSynthesis);
		
		JLabel lblNewLabel = new JLabel("Nouvelle carte");
		lblNewLabel.setBounds(255, 11, 112, 30);
		contentPane.add(lblNewLabel);
		
		btnAddImage.addActionListener(new ActionListener() {
	  		  
	  		  @Override
	  		  public void actionPerformed(ActionEvent arg0) {
	  			JFileChooser choix = new JFileChooser();
	  			
	  			
	  			//Filter only the images files
	  			FileNameExtensionFilter imageFilter = new FileNameExtensionFilter("Image files", ImageIO.getReaderFileSuffixes());
	  			choix.setFileFilter(imageFilter);
	  			
	  			int retour=choix.showOpenDialog(contentPane);
	  			if(retour==JFileChooser.APPROVE_OPTION){
	  				
	  			 image = choix.getSelectedFile();
	  			 changedImage = true;
	  			 JOptionPane.showMessageDialog(null, 
                    "L'image a bien été chargée", 
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
		
		btnCreateCard.addActionListener(new ActionListener() {
	  		  
	  		  @Override
	  		  public void actionPerformed(ActionEvent arg0) {
	  			if(changedImage && !textName.getText().isEmpty() && !textDescription.getText().isEmpty() && !textAtout.getText().isEmpty() && !textAction.getText().isEmpty() && !textObstacle.getText().isEmpty() && !textAction.getText().isEmpty() && !textResult.getText().isEmpty() && !textSynthesis.getText().isEmpty()) {
	  				System.out.println("WESH");
	  				
//	  				String desc, atout, obstacle,action,result, synthesis;
	  				Card card = new Card(textName.getText(), textDescription.getText(), textAtout.getText(), textObstacle.getText(), textAction.getText(), textResult.getText(), textSynthesis.getText(), image);
	  				player.getCards().add(card);
	  				JOptionPane.showMessageDialog(null, 
	  						"La carte a bien été ajoutée à votre collection", 
	  						"ATTENTION", 
	  						JOptionPane.WARNING_MESSAGE);
	  				CardsCollectionRender frame = new CardsCollectionRender(player);
	  				frame.run();
	  			} else {
	  				JOptionPane.showMessageDialog(null, 
	                        "Merci de remplir tous les champs!", 
	                        "ATTENTION", 
	                        JOptionPane.WARNING_MESSAGE);
	  			}
	  		  }
	  	  });
		btnCreateCard.addActionListener(e -> this.dispose());
		
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
