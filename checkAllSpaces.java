package othelloProject;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;

public class checkAllSpaces {

	static JButton attemptedMove = (JButton) OthelloWindow.gameBoard
			.getComponentAt(OthelloWindow.gameBoard.getMousePosition());
	static ImageIcon currentTurn = OthelloWindow.blackPiece;
	static Color currentColor;

	public static ImageIcon whosTurn() {

		if (OthelloWindow.turn == 1) {
			currentTurn = OthelloWindow.blackPiece;
			currentColor = Color.BLACK;

		} else {
			currentTurn = OthelloWindow.whitePiece;
			currentColor = Color.WHITE;

		}
		return currentTurn;
	}

	// this is where valid move checking begins
	public static boolean isValidMove(int r, int c) {

		whosTurn();
		// this will call the methods to check for a valid move in all directions
		if (checkNESW(r, c) || checkDiag(r, c)) {
			checkDiag(r, c);
			return true;

		} else {
			return false;
		}
	}

	private static boolean checkDiag(int r, int c) {

		if (checkDiagNE(r, c) || checkDiagNW(r, c) || checkDiagSE(r, c) || checkDiagSW(r, c)) {

			checkDiagNW(r, c);
			checkDiagSE(r, c);
			checkDiagSW(r, c);
			return true;

		} else {
			return false;

		}
	}

	private static boolean checkDiagSW(int r, int c) {

		int sameColor = 0;
		int cl = c;

		for (int rw = r + 1; rw < 8; rw++) {

			cl = cl - 1;
			Object checkedIcon = checkIcon(rw, cl);

			// check how many discs are of the same color disc that is being placed this
			// turn
			if (checkedIcon == currentTurn) {
				sameColor++;
				break;
			}
		}

		// if no other disc in this direction is of the same color return false
		if (sameColor == 0) {
			sameColor = 0;
			return false;

		}
		// if the adjacent disc is an empty space return false
		try {
			if ((OthelloWindow.buttonArray[r + 1][c - 1].getIcon() == null)
					|| (OthelloWindow.buttonArray[r + 2][c - 2].getIcon() == null)) {

				return false;

			}
		} catch (Exception e) {
			return false;
		}
		// if adjacent disc is the same color as the one being placed return false
		try {
			if (OthelloWindow.buttonArray[r + 1][c - 1].getIcon() == currentTurn) {

				return false;

			}
		} catch (Exception e) {
			return false;
		}
		sameColor = 0;
		return true;
	}

	private static boolean checkDiagSE(int r, int c) {

		int sameColor = 0;
		int cl = c;
		for (int rw = r + 1; rw < 8; rw++) {
			cl = cl + 1;
			Object checkedIcon = checkIcon(rw, cl);
			// check how many discs are of the same color disc that is being placed this
			// turn
			if (checkedIcon == currentTurn) {
				sameColor++;
				break;
			}
		}

		// if no other disc in this direction is of the same color return false
		if (sameColor == 0) {
			sameColor = 0;
			return false;

		}
		// if the adjacent disc is an empty space return false
		try {
			if ((OthelloWindow.buttonArray[r + 1][c + 1].getIcon() == null)
					|| (OthelloWindow.buttonArray[r + 2][c + 2].getIcon() == null)) {

				return false;

			}
		} catch (Exception e) {
			return false;
		}
		// if adjacent disc is the same color as the one being placed return false
		try {
			if (OthelloWindow.buttonArray[r + 1][c + 1].getIcon() == currentTurn) {

				return false;

			}
		} catch (Exception e) {
			return false;
		}
		sameColor = 0;
		return true;
	}

	static boolean checkDiagNW(int r, int c) {

		int sameColor = 0;
		int rw = r;
		for (int cl = c - 1; cl > -1; cl--) {
			rw = rw - 1;
			Object checkedIcon = checkIcon(rw, cl);
			// check how many discs are of the same color disc that is being placed this
			// turn
			if (checkedIcon == currentTurn) {
				sameColor++;
				break;
			}
		}

		// if no other disc in this direction is of the same color return false
		if (sameColor == 0) {
			sameColor = 0;
			return false;

		}
		// if the adjacent disc is an empty space return false
		try {
			if ((OthelloWindow.buttonArray[r - 1][c - 1].getIcon() == null)
					|| (OthelloWindow.buttonArray[r - 2][c - 2].getIcon() == null)) {

				return false;

			}
		} catch (Exception e) {
			return false;
		}
		// if adjacent disc is the same color as the one being placed return false
		try {
			if (OthelloWindow.buttonArray[r - 1][c - 1].getIcon() == currentTurn) {

				return false;

			}
		} catch (Exception e) {
			return false;
		}
		sameColor = 0;
		return true;
	}

	private static boolean checkDiagNE(int r, int c) {

		int sameColor = 0;
		int cl = c;
		for (int rw = r - 1; rw > -1; rw--) {
			cl = cl + 1;
			Object checkedIcon = checkIcon(rw, cl);
			// check how many discs are of the same color disc that is being placed this
			// turn
			if (checkedIcon == currentTurn) {
				sameColor++;
				break;
			}
		}

		// if no other disc in this direction is of the same color return false
		if (sameColor == 0) {
			sameColor = 0;
			return false;

		}
		// if the adjacent disc is an empty space return false
		try {
			if ((OthelloWindow.buttonArray[r - 1][c + 1].getIcon() == null)
					|| (OthelloWindow.buttonArray[r - 2][c + 2].getIcon() == null)) {

				return false;

			}
		} catch (Exception e) {
			return false;
		}
		// if adjacent disc is the same color as the one being placed return false
		try {
			if (OthelloWindow.buttonArray[r - 1][c + 1].getIcon() == currentTurn) {

				return false;

			}
		} catch (Exception e) {
			return false;
		}
		sameColor = 0;
		return true;
	}

	private static boolean checkNESW(int r, int c) {

		if (checkNorth(r, c) || checkEast(r, c) || checkSouth(r, c) || checkWest(r, c)) {

			checkEast(r, c);
			checkSouth(r, c);
			checkWest(r, c);
			return true;

		} else {

			return false;
		}

	}

	private static boolean checkWest(int r, int c) {

		int sameColor = 0;
		for (int col = c - 1; col > -1; col--) {
			// check how many discs are of the same color disc that is being placed this
			// turn
			if (OthelloWindow.buttonArray[r][col].getIcon() == currentTurn) {
				if (OthelloWindow.buttonArray[r][col].getIcon() == null) {
					break;
				} else {
					sameColor++;
					break;
				}
			}
		}

		// if no other disc in this direction is of the same color return false
		if (sameColor == 0) {
			sameColor = 0;
			return false;

		}
		Object checkedIcon = checkIcon(r, c - 1);
		Object checkedIcon2 = checkIcon(r, c - 2);
		// if the adjacent disc is an empty space return false
		if ((checkedIcon == null) || (checkedIcon2 == null)) {
			return false;

		}
		// if adjacent disc is the same color as the one being placed return false
		if (OthelloWindow.buttonArray[r][c - 1].getIcon() == currentTurn) {
			return false;

		}

		sameColor = 0;
		return true;
	}

	private static boolean checkSouth(int r, int c) {

		int sameColor = 0;
		for (int rw = r + 1; rw < 8; rw++) {
			// check how many discs are of the same color disc that is being placed this
			// turn
			if (OthelloWindow.buttonArray[rw][c].getIcon() == currentTurn) {
				if (OthelloWindow.buttonArray[rw][c].getIcon() == null) {
					break;
				} else {
					sameColor++;
					break;
				}
			}
		}
		// if no other disc in this direction is of the same color return false
		if (sameColor == 0) {

			sameColor = 0;
			return false;

		}

		// if the adjacent disc is an empty space return false
		Object checkedIcon = checkIcon(r + 1, c);
		Object checkedIcon2 = checkIcon(r + 2, c);
		if ((checkedIcon == null) || (checkedIcon2 == null)) {

			return false;

		}
		// if adjacent disc is the same color as the one being placed return false
		if (OthelloWindow.buttonArray[r + 1][c].getIcon() == currentTurn) {

			return false;

		}

		sameColor = 0;
		return true;
	}

	private static boolean checkEast(int r, int c) {

		int sameColor = 0;
		for (int col = c + 1; col < 8; col++) {
			// check how many discs are of the same color disc that is being placed this
			// turn
			if (OthelloWindow.buttonArray[r][col].getIcon() == currentTurn) {
				if (OthelloWindow.buttonArray[r][col].getIcon() == null) {
					break;
				} else {
					sameColor++;
					break;
				}
			}
		}
		// if no other disc in this direction is of the same color return false
		if (sameColor == 0) {
			sameColor = 0;
			return false;

		}
		// if the adjacent disc is an empty space return false
		try {
			if ((OthelloWindow.buttonArray[r][c + 1].getIcon() == null)
					|| (OthelloWindow.buttonArray[r][c + 2].getIcon() == null)) {

				return false;

			}
		} catch (Exception e) {
			return false;
		}
		// if adjacent disc is the same color as the one being placed return false
		try {
			if (OthelloWindow.buttonArray[r][c + 1].getIcon() == currentTurn) {

				return false;

			}
		} catch (Exception e) {
			return false;
		}

		sameColor = 0;
		return true;
	}

	private static boolean checkNorth(int r, int c) {

		int sameColor = 0;
		for (int rw = r - 1; rw > -1; rw--) {
			// check how many discs are of the same color disc that is being placed this
			// turn
			if (OthelloWindow.buttonArray[rw][c].getIcon() == currentTurn) {
				if (OthelloWindow.buttonArray[rw][c].getIcon() == null) {
					break;
				} else {
					sameColor++;
					break;
				}

			}
		}
		// if no other disc in this direction is of the same color return false
		if (sameColor == 0) {

			sameColor = 0;
			return false;

		}
		// if the adjacent disc is an empty space return false
		try {
			if ((OthelloWindow.buttonArray[r - 1][c].getIcon() == null)
					|| (OthelloWindow.buttonArray[r - 2][c].getIcon() == null)) {

				return false;

			}
		} catch (Exception e) {
			return false;
		}
		// if adjacent disc is the same color as the one being placed return false
		try {
			if (OthelloWindow.buttonArray[r - 1][c].getIcon() == currentTurn) {

				return false;

			}
		} catch (Exception e) {
			return false;
		}

		sameColor = 0;
		return true;
	}

	private static Object checkIcon(int rw, int cl) {
		try {
			OthelloWindow.buttonArray[rw][cl].getIcon();
		} catch (Exception e) {
			return null;
		}
		return OthelloWindow.buttonArray[rw][cl].getIcon();
	}
}