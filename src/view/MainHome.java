package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import player.Player;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.awt.Color;

import javax.swing.JButton;

public class MainHome extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	public void run() {
		try {
			MainHome frame = new MainHome();
			frame.setVisible(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 * @param mainHome 
	 */
	public MainHome() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 554);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 11, 443, 242);
		panel.setBackground(Color.PINK);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tarot Mystic");
		lblNewLabel.setFont(new Font("Rage Italic", Font.PLAIN, 26));
		lblNewLabel.setBounds(137, 11, 128, 39);
		panel.add(lblNewLabel);
		
		JButton btnNewPlayer = new JButton("Nouveau Joueur");
		btnNewPlayer.setBounds(137, 74, 149, 32);
		panel.add(btnNewPlayer);
		btnNewPlayer.addActionListener(new ActionListener() {
	  		  
	  		  @Override
	  		  public void actionPerformed(ActionEvent arg0) {
	  			  CreatePlayerRender create = new CreatePlayerRender();
	  			  create.run();	  
	  		  }
	  	  });
		btnNewPlayer.addActionListener(e -> this.dispose());
		
		JButton btnExistPlayer = new JButton("Joueur existant");
		btnExistPlayer.setBounds(137, 128, 149, 32);
		panel.add(btnExistPlayer);
		
		JPanel panelImport = new JPanel();
		panelImport.setVisible(false);
		panelImport.setLayout(null);
		panelImport.setBackground(Color.PINK);
		panelImport.setBounds(5, 264, 443, 242);
		contentPane.add(panelImport);
		
		JLabel labelImport = new JLabel("Importer votre profil");
		labelImport.setFont(new Font("Rage Italic", Font.PLAIN, 26));
		labelImport.setBounds(137, 11, 213, 39);
		panelImport.add(labelImport);
		
		JButton btnImport = new JButton("Importer");
		btnImport.setBounds(137, 74, 149, 32);
		panelImport.add(btnImport);
		
		btnImport.addActionListener(new ActionListener() {
	  		  
	  		  @Override
	  		  public void actionPerformed(ActionEvent arg0) {
	  			JFileChooser choix = new JFileChooser();
	  			
	  			int retour = choix.showOpenDialog(contentPane);
	  			if(retour == JFileChooser.APPROVE_OPTION){
	  				
	  			 JOptionPane.showMessageDialog(null, 
                    "Le joueur a bien été importé", 
                    "ATTENTION", 
                    JOptionPane.WARNING_MESSAGE);
	  			Player player = DeserializePlayer(choix.getSelectedFile());
	  			CardsCollectionRender cdp = new CardsCollectionRender(player);
	  			cdp.run();
	  			 
	  			} else {
	  				JOptionPane.showMessageDialog(null, 
	                        "Aucun joueur selectionné!", 
	                        "ATTENTION", 
	                        JOptionPane.WARNING_MESSAGE);
	  			}
	  		  }
	  	  });
		
		btnExistPlayer.addActionListener(new ActionListener() {
	  		  
	  		  @Override
	  		  public void actionPerformed(ActionEvent arg0) {
	  			  panelImport.setVisible(true);
	  		  }
	  	  });
	}
	
	public static Player DeserializePlayer(File file) {
		  Player player = new Player(null, "");
		  try
	      {
	          FileInputStream fis = new FileInputStream(file);
	          ObjectInputStream ois = new ObjectInputStream(fis);

	          player = (Player) ois.readObject();

	          ois.close();
	          fis.close();
	      } 
	      catch (IOException ioe) 
	      {
	          ioe.printStackTrace();
	          return null;
	      } 
	      catch (ClassNotFoundException c) 
	      {
	          System.out.println("Class not found");
	          c.printStackTrace();
	          return null;
	      }
		  return player;
		  
	  }
	
}
