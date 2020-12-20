package view;

import java.awt.BorderLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Prediction.Prediction;
import cards.ArrayListCard;
import player.Player;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JTextPane;
import java.awt.Font;

public class PredictionRender extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6L;
	private JPanel contentPane;
	private ArrayListCard cards;
	private Player player;
	private Prediction prediction;

	/**
	 * Launch the application.
	 */
	public void run() {
		try {
			PredictionRender frame = new PredictionRender(cards, player);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public PredictionRender(ArrayListCard cards, Player player) {
		
		this.cards = cards;
		this.player = player;
		this.prediction = new Prediction(cards);
		
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 951, 596);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("Navigation");
		menuBar.add(menu);
		
		JMenuItem back = new JMenuItem("Revenir \u00E0 la collection");
		menu.add(back);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Votre Pr\u00E9diction ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(340, 11, 180, 23);
		contentPane.add(lblNewLabel);
		
		JTextPane textPaneAtout = new JTextPane();
		textPaneAtout.setBounds(10, 56, 904, 76);
		textPaneAtout.setText("Vos atouts: " + prediction.getAtoutCard().getName() + "\n" + prediction.getAtoutCard().getAtout());
		textPaneAtout.setEditable(false);
		contentPane.add(textPaneAtout);
		
		JTextPane textPaneObstacle = new JTextPane();
		textPaneObstacle.setText("Vos obstacles: " + prediction.getObstacleCard().getName() + "\n" + prediction.getObstacleCard().getObstacle());
		textPaneObstacle.setEditable(false);
		textPaneObstacle.setBounds(10, 143, 904, 76);
		contentPane.add(textPaneObstacle);
		
		JTextPane textPaneAction = new JTextPane();
		textPaneAction.setText("L'action: " + prediction.getActionCard().getName() + "\n" + prediction.getActionCard().getAction());
		textPaneAction.setEditable(false);
		textPaneAction.setBounds(10, 433, 904, 76);
		contentPane.add(textPaneAction);
		
		JTextPane textPaneResult = new JTextPane();
		textPaneResult.setText("Le résultat: " + prediction.getResultCard().getName() + "\n" + prediction.getResultCard().getResult());
		textPaneResult.setEditable(false);
		textPaneResult.setBounds(10, 329, 904, 76);
		contentPane.add(textPaneResult);
		
		JTextPane textPaneSynthesis = new JTextPane();
		textPaneSynthesis.setText("La synthèse: " + prediction.getSynthesisCard().getName() + "\n" + prediction.getSynthesisCard().getSynthesis());
		textPaneSynthesis.setEditable(false);
		textPaneSynthesis.setBounds(10, 242, 904, 76);
		contentPane.add(textPaneSynthesis);
		
		
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
