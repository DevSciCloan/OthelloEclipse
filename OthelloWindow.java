package othelloProject;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import java.awt.Dimension;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Component;
import javax.swing.UIManager;
import javax.swing.JCheckBox;


public class OthelloWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static JLabel playerTurn;
	public static ImageIcon whitePiece = new ImageIcon(OthelloWindow.class.getResource("whiteDisc.png"));
	public static ImageIcon blackPiece = new ImageIcon(OthelloWindow.class.getResource("blackDisc.png"));
	public static ImageIcon winnerIcon = new ImageIcon(OthelloWindow.class.getResource("winnerIcon.png"));
	static JPanel gameBoard;
	static JCheckBox assistToggle;
	static JLabel infoBox, blackScore, whiteScore;
	static String infoBoxDefaultText = "<html>" + "<center>" + "This is where the game will tell you off for being a noob XD"+ "</center>" + "</html>";
	static int turn = 1;
	boolean placeValidMove = false;
	public static JButton[][] buttonArray = new JButton[8][8];
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OthelloWindow frame = new OthelloWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	public OthelloWindow() {
		setResizable(false);
		setTitle("CSIS 2410");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 828, 633);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new CompoundBorder(new EmptyBorder(0, 10, 0, 10), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel title = new JLabel("Othello");
		title.setForeground(new Color(204, 204, 204));
		title.setOpaque(true);
		title.setBackground(new Color(0, 0, 0));
		title.setFocusable(false);
		title.setFont(new Font("Cinzel Black", Font.BOLD, 24));
		title.setVerticalAlignment(SwingConstants.TOP);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(title, BorderLayout.NORTH);
		
		gameBoard = new JPanel();
		gameBoard.setBackground(new Color(27, 8, 126));
		gameBoard.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), new EmptyBorder(5, 5, 5, 5)));
		gameBoard.setLayout(new GridLayout(8,8,2,2));
		contentPane.add(gameBoard, BorderLayout.CENTER);
		
		
		playerTurn = new JLabel();
		playerTurn.setForeground(new Color(204, 204, 204));
		playerTurn.setOpaque(true);
		playerTurn.setBackground(new Color(0, 0, 0));
		playerTurn.setBorder(new CompoundBorder(new EmptyBorder(5, 0, 5, 0), new EmptyBorder(0, 10, 0, 0)));
		playerTurn.setFocusable(false);
		playerTurn.setFont(new Font("Tahoma", Font.BOLD, 18));
		playerTurn.setText("Black player's turn");
		contentPane.add(playerTurn, BorderLayout.SOUTH);
		
		JPanel controlPanel = new JPanel();
		controlPanel.setPreferredSize(new Dimension(250, 600));
		controlPanel.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), new EtchedBorder(EtchedBorder.LOWERED, null, null)));
		controlPanel.setBackground(Color.DARK_GRAY);
		contentPane.add(controlPanel, BorderLayout.EAST);
		controlPanel.setLayout(new BorderLayout(0, 0));
		
		JButton btnReset = new JButton("Reset");
		btnReset.setFont(new Font("Arial Black", Font.PLAIN, 14));
		btnReset.setBackground(new Color(204, 204, 204));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gameBoard.removeAll(); // deletes all of the buttons on the gameBoard
				gameBoard.revalidate(); // this is to revalidate (not 100% sure what this does) so that the following methods will actually work
				createButtonArray(); // creates all the buttons again!
				addAction(); // adds the action listeners to every button in the gameBoard panel again
				turn = 1;
				playerTurn.setText("Black player's turn");
				initialFour();
				infoBox.setText(infoBoxDefaultText);
				whiteScore.setText("2");
				blackScore.setText("2");
			}
		});
		
		btnReset.setToolTipText("Clear the board to start a new game");
		btnReset.setFocusable(false);
		btnReset.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnReset.setMinimumSize(new Dimension(50, 30));
		btnReset.setPreferredSize(new Dimension(50, 40));
		controlPanel.add(btnReset, BorderLayout.SOUTH);
		
		JPanel scoreBoard = new JPanel();
		scoreBoard.setBackground(new Color(169, 169, 169));
		controlPanel.add(scoreBoard, BorderLayout.CENTER);
		scoreBoard.setLayout(null);
		
		assistToggle = new JCheckBox(" Move Assist");
		assistToggle.setFocusable(false);
		assistToggle.setOpaque(false);
		assistToggle.setBounds(23, 210, 100, 23);
		scoreBoard.add(assistToggle);
		
		JButton white = new JButton("", whitePiece);
		white.setBounds(23, 128, 60, 60);
		white.setContentAreaFilled(false);
		white.setFocusPainted(false);
		white.setFocusable(false);
		white.setVerifyInputWhenFocusTarget(false);
		white.setOpaque(false);
		white.setPreferredSize(new Dimension(60, 60));
		white.setBorder(new EmptyBorder(0, 0, 0, 0));
		scoreBoard.add(white);
		
		JButton black = new JButton("", blackPiece);
		black.setLocation(23, 30);
		black.setContentAreaFilled(false);
		black.setFocusPainted(false);
		black.setFocusable(false);
		black.setVerifyInputWhenFocusTarget(false);
		black.setOpaque(false);
		black.setPreferredSize(new Dimension(60, 60));
		black.setSize(new Dimension(60, 60));
		black.setBorder(new EmptyBorder(0, 0, 0, 0));
		scoreBoard.add(black);
		
		blackScore = new JLabel("2");
		blackScore.setFont(new Font("Tahoma", Font.PLAIN, 32));
		blackScore.setHorizontalAlignment(SwingConstants.CENTER);
		blackScore.setBounds(105, 30, 60, 60);
		scoreBoard.add(blackScore);
		
		whiteScore = new JLabel("2");
		whiteScore.setHorizontalAlignment(SwingConstants.CENTER);
		whiteScore.setFont(new Font("Tahoma", Font.PLAIN, 32));
		whiteScore.setBounds(105, 128, 60, 60);
		scoreBoard.add(whiteScore);
		
		infoBox = new JLabel();
		infoBox.setVerticalTextPosition(SwingConstants.TOP);
		infoBox.setHorizontalTextPosition(SwingConstants.RIGHT);
		infoBox.setFont(new Font("Cinzel Black", Font.PLAIN, 14));
		infoBox.setHorizontalAlignment(SwingConstants.RIGHT);
		infoBox.setText(infoBoxDefaultText);
		infoBox.setOpaque(true);
		infoBox.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), UIManager.getBorder("Button.border")));
		infoBox.setBackground(new Color(204, 204, 204));
		infoBox.setBounds(10, 240, 222, 179);
		scoreBoard.add(infoBox);
		
		JLabel scoreBoardTitle = new JLabel("Player Scores");
		scoreBoardTitle.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new EmptyBorder(10, 0, 10, 0)));
		scoreBoardTitle.setFont(new Font("Arial Black", Font.PLAIN, 14));
		scoreBoardTitle.setHorizontalAlignment(SwingConstants.CENTER);
		scoreBoardTitle.setOpaque(true);
		scoreBoardTitle.setBackground(new Color(204, 204, 204));
		controlPanel.add(scoreBoardTitle, BorderLayout.NORTH);
		
		createButtonArray();
		addAction();
		initialFour();
		
	}
	
	

	// This method fills the panel (gameBoard) with identical buttons numbered 1-64 for an 8x8 board.
	public void createButtonArray() {
		for (int r = 0; r < 8; r++) {
			for (int c = 0; c < 8; c++) {
				buttonArray[r][c] = new JButton();
				buttonArray[r][c].setIcon(null);
				buttonArray[r][c].setFocusable(false);
				buttonArray[r][c].setBackground(new Color(159,180,249));
				gameBoard.add(buttonArray[r][c]);
			}
		}
	}
	
	// Method to place the first four discs at the start of the game
	public void initialFour() {
			
			JButton twenty7 = (JButton) gameBoard.getComponent(27);
			JButton twenty8 = (JButton) gameBoard.getComponent(28);
			JButton thirty5 = (JButton) gameBoard.getComponent(35);
			JButton thirty6 = (JButton) gameBoard.getComponent(36);
			twenty7.setIcon(blackPiece);
			thirty6.setIcon(blackPiece);
			twenty8.setIcon(whitePiece);
			thirty5.setIcon(whitePiece);
			
		}
	
	// This method adds the actionPerformed to every button inside our gameBoard panel.
	public void addAction() {
		
		Component[] components = gameBoard.getComponents();
		
		for (Component component : components) {
			if (component instanceof JButton) {
				JButton button = (JButton) component;
				button.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent ae) {
						allowableMove.whosTurn();
						Object source = ae.getSource();
						Icon clickedButton = null;

						for (int r = 0; r < 8; r++) {
							for (int c = 0; c < 8; c++) {
								if (source == buttonArray[r][c]) {
									clickedButton = buttonArray[r][c].getIcon();
									if (clickedButton == null) {
										placeValidMove = allowableMove.isValidMove(r,c);
									}
								} 
							}
						}
						System.out.println(clickedButton);
						if ((clickedButton == null) && (placeValidMove)) {
							gameOver.setTurnSkipped(0);
							if (turn == 1) {
								((JButton) component).setIcon(blackPiece);
								playerTurn.setText("White player's turn");
								turn = 2;

								
							} else {
								((JButton) component).setIcon(whitePiece);
								playerTurn.setText("Black player's turn");
								turn = 1;
								
							}
							gameOver.skipTurn(); // Only runs if a marker is placed
							gameOver.countPoints();
						}
					}
				});
			}
		}
	}
}


