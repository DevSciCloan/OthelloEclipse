package othelloProject;

import java.awt.Color;

public class gameOver {

	private static int turnSkipped = 0;
	static Object winnerColor = Color.WHITE;
	static Object winnerColorOpposite = Color.BLACK;

	public static void countPoints() {

		int whiteDiscs = 0;
		int blackDiscs = 0;

		for (int r = 0; r < 8; r++) {
			for (int c = 0; c < 8; c++) {
				if (OthelloWindow.buttonArray[r][c].getIcon() == OthelloWindow.blackPiece) {
					blackDiscs++;
				} else if (OthelloWindow.buttonArray[r][c].getIcon() == OthelloWindow.whitePiece) {
					whiteDiscs++;
				}
				String black = String.format("%d", blackDiscs);
				String white = String.format("%d", whiteDiscs);
				OthelloWindow.blackScore.setText(black);
				OthelloWindow.whiteScore.setText(white);

				if (blackDiscs + whiteDiscs == 64) {
					whoWins(blackDiscs, whiteDiscs);
				}
			}
		}

	}

	public static void skipTurn() {

		int availableMove = loopAvailableMoves();

		if (availableMove == 0) {

			if (OthelloWindow.turn == 1) {
				OthelloWindow.turn = 2;
				allowableMove.currentTurn = OthelloWindow.whitePiece;
				OthelloWindow.playerTurn.setText("White player's turn");
			} else {
				OthelloWindow.turn = 1;
				allowableMove.currentTurn = OthelloWindow.blackPiece;
				OthelloWindow.playerTurn.setText("Black player's turn");
			}

			OthelloWindow.infoBox
					.setText("<html>" + "<center>" + "PLAYER your turn has been SKIPPED!" + "</center>" + "</html>");
			System.out.println("skipping player's turn");
			setTurnSkipped(getTurnSkipped() + 1);
			availableMove = loopAvailableMoves();
		}

		if ((availableMove == 0) && (getTurnSkipped() == 1)) {
			whoWon();
		}
	}

	static int loopAvailableMoves() {

		int availableMove = 0;
		for (int r = 0; r < 8; r++) {
			for (int c = 0; c < 8; c++) {
				clearPreviousMoves(r, c);
				if ((checkAllSpaces.isValidMove(r, c)) && (OthelloWindow.buttonArray[r][c].getIcon() == null)) {
					if (OthelloWindow.assistToggle.isSelected()) {
							OthelloWindow.buttonArray[r][c].setBackground(new Color(120, 130, 250));
						}
					availableMove++;

				}
			}

		}
		System.out.println("Player has " + availableMove + " moves available");
		return availableMove;
	}

	static void clearPreviousMoves(int r, int c) {

		OthelloWindow.buttonArray[r][c].setBackground(new Color(159, 180, 249));

	}

	public static void whoWon() {

		int whiteDiscs = 0;
		int blackDiscs = 0;

		for (int r = 0; r < 8; r++) {
			for (int c = 0; c < 8; c++) {
				if (OthelloWindow.buttonArray[r][c].getIcon() == OthelloWindow.blackPiece) {
					blackDiscs++;
				}

				if (OthelloWindow.buttonArray[r][c].getIcon() == OthelloWindow.whitePiece) {
					whiteDiscs++;
				}
			}
		} 
		whoWins(blackDiscs, whiteDiscs);
	}

	public static void whoWins(int blackDiscs, int whiteDiscs) {

		if (whiteDiscs > blackDiscs) {
			OthelloWindow.infoBox
					.setText("<html><center>" + "White Player Wins! CONGRATULATIONS!" + "</center></html>");
			winnerColor = Color.white;
			winnerColorOpposite = Color.BLACK;
			disableAllButtons();
		}

		if (whiteDiscs < blackDiscs) {
			OthelloWindow.infoBox
					.setText("<html><center>" + "Black Player Wins! CONGRATULATIONS!" + "</center></html>");
			winnerColor = Color.black;
			winnerColorOpposite = Color.WHITE;
			disableAllButtons();
		}

		Animations.anim((int) (Math.random()*5));
		//Animations.anim(1); // Use to test specific win animations
		
	}

	private static void disableAllButtons() {
		for (int r = 0; r < 8; r++) {
			for (int c = 0; c < 8; c++) {
				int rw = r;
				int cl = c;
				if (OthelloWindow.buttonArray[rw][cl].getIcon() == null) {

					OthelloWindow.buttonArray[rw][cl].setIcon(OthelloWindow.winnerIcon);
				}
			}
		}

	}

	public static int getTurnSkipped() {
		return turnSkipped;
	}

	public static void setTurnSkipped(int turnSkipped) {
		gameOver.turnSkipped = turnSkipped;
	}

}
