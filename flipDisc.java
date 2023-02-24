package othelloProject;

public class flipDisc {

	/*
	 * This is the first method that flips captured discs for one direction, either
	 * North, East, South, etc. /* from point A (player move) to point B (farthest
	 * match) stopping if blank space is encountered
	 */
	public static void flipNorth(Object lastDisc, int r, int c) {

		// Calculate which row and column lastDisc is located
		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				if (lastDisc == OthelloWindow.buttonArray[row][col]) {
					// Begin from point A and flip all discs to point B
					for (int rw = r - 1; rw > row; rw--) {
						// check how many discs are of the same color disc that is being placed this
						// turn
						if (OthelloWindow.buttonArray[rw][c].getIcon() != allowableMove.currentTurn) {
							// Exit loop and stop turning over discs if empty space is encountered else keep
							// turning over discs
							if (OthelloWindow.buttonArray[rw][c].getIcon() == null) {
								return;
							} else {
								OthelloWindow.buttonArray[rw][c].setIcon(allowableMove.currentTurn);
							}
						}
					}
				}
			}
		}
	}

	public static void flipEast(Object lastDisc, int r, int c) {

		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				if (lastDisc == OthelloWindow.buttonArray[row][col]) {
					for (int cl = c + 1; cl < col; cl++) {
						// check how many discs are of the same color disc that is being placed this
						// turn
						if (OthelloWindow.buttonArray[r][cl].getIcon() != allowableMove.currentTurn) {
							if (OthelloWindow.buttonArray[r][cl].getIcon() == null) {
								return;
							} else {
								OthelloWindow.buttonArray[r][cl].setIcon(allowableMove.currentTurn);
							}
						}
					}
				}
			}
		}
	}

	public static void flipSouth(Object lastDisc, int r, int c) {

		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				if (lastDisc == OthelloWindow.buttonArray[row][col]) {
					for (int rw = r + 1; rw < row; rw++) {
						// check how many discs are of the same color disc that is being placed this
						// turn
						if (OthelloWindow.buttonArray[rw][c].getIcon() != allowableMove.currentTurn) {
							if (OthelloWindow.buttonArray[rw][c].getIcon() == null) {
								return;
							} else {
								OthelloWindow.buttonArray[rw][c].setIcon(allowableMove.currentTurn);
							}
						}
					}
				}
			}
		}
	}

	public static void flipWest(Object lastDisc, int r, int c) {

		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				if (lastDisc == OthelloWindow.buttonArray[row][col]) {
					for (int cl = c - 1; cl > col; cl--) {
						// check how many discs are of the same color disc that is being placed this
						// turn
						if (OthelloWindow.buttonArray[r][cl].getIcon() != allowableMove.currentTurn) {
							if (OthelloWindow.buttonArray[r][cl].getIcon() == null) {
								return;
							} else {
								OthelloWindow.buttonArray[r][cl].setIcon(allowableMove.currentTurn);
							}
						}
					}
				}
			}
		}

	}

	public static void flipSW(Object lastDisc, int r, int c) {

		int cl = c;

		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				if (lastDisc == OthelloWindow.buttonArray[row][col]) {
					for (int rw = r + 1; rw < row; rw++) {
						cl--;
						// check how many discs are of the same color disc that is being placed this
						// turn
						if (OthelloWindow.buttonArray[rw][cl].getIcon() != allowableMove.currentTurn) {
							if (OthelloWindow.buttonArray[rw][cl].getIcon() == null) {
								return;
							} else {
								OthelloWindow.buttonArray[rw][cl].setIcon(allowableMove.currentTurn);
							}
						}
					}
				}
			}
		}

	}

	public static void flipSE(Object lastDisc, int r, int c) {

		int cl = c;

		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				if (lastDisc == OthelloWindow.buttonArray[row][col]) {
					for (int rw = r + 1; rw < row; rw++) {
						cl++;
						// check how many discs are of the same color disc that is being placed this
						// turn
						if (OthelloWindow.buttonArray[rw][cl].getIcon() != allowableMove.currentTurn) {
							if (OthelloWindow.buttonArray[rw][cl].getIcon() == null) {
								return;
							} else {
								OthelloWindow.buttonArray[rw][cl].setIcon(allowableMove.currentTurn);
							}
						}
					}
				}
			}
		}

	}

	public static void flipNW(Object lastDisc, int r, int c) {

		int rw = r;

		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				if (lastDisc == OthelloWindow.buttonArray[row][col]) {
					for (int cl = c - 1; cl > col; cl--) {
						rw--;
						// check how many discs are of the same color disc that is being placed this
						// turn
						if (OthelloWindow.buttonArray[rw][cl].getIcon() != allowableMove.currentTurn) {
							if (OthelloWindow.buttonArray[rw][cl].getIcon() == null) {
								return;
							} else {
								OthelloWindow.buttonArray[rw][cl].setIcon(allowableMove.currentTurn);
							}
						}
					}
				}
			}
		}

	}

	public static void flipNE(Object lastDisc, int r, int c) {

		int cl = c;

		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				if (lastDisc == OthelloWindow.buttonArray[row][col]) {
					for (int rw = r - 1; rw > row; rw--) {
						cl++;
						// check how many discs are of the same color disc that is being placed this
						// turn
						if (OthelloWindow.buttonArray[rw][cl].getIcon() != allowableMove.currentTurn) {
							if (OthelloWindow.buttonArray[rw][cl].getIcon() == null) {
								return;
							} else {
								OthelloWindow.buttonArray[rw][cl].setIcon(allowableMove.currentTurn);
							}
						}
					}
				}
			}
		}
	}
}
