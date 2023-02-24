package othelloProject;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class Animations {

	static int animationR = 0;
	static int animationC = 0;
	static int animationRe = 0;
	static int animationCe = 0;
	static int rEight = 7;
	static int cEight = 0;
	static int timeSlice20 = 20; // update every 20 milliseconds
	static int timeSlice15 = 15;
	static int count = 0;
	static int test = 0;
	static int testTwo = 0;
	static int testThree = 0;
	static Color thisColor = (Color) gameOver.winnerColorOpposite;

	static Timer scatterFill = new Timer(timeSlice15, new ActionListener() {

		public void actionPerformed(ActionEvent e) {

			ttbFill.setInitialDelay(1050);
			ttbFill.start();
			
			if (animationR < 7) {
				try {
					OthelloWindow.buttonArray[(int) (Math.random() * 7) + 1][Math.abs(animationC-7)]
							.setBackground((Color) gameOver.winnerColorOpposite);
				} catch (Exception e1) {
					// Do nothing
				}
				animationR++;
			} else if (animationC < 8) {
				OthelloWindow.buttonArray[Math.abs(animationR - (int) (Math.random()*5))][(int) ((Math.random() * 7) + 1)]
						.setBackground((Color) gameOver.winnerColor);
				animationC++;
				animationR = 0;
			} else {
				animationR = 0;
				animationC = 0;
				scatterFill.stop();
				ttbFill.setInitialDelay(0);
				System.out.println("timer scatterFill has stopped");
			}
		}
	});

	static Timer ttbFill = new Timer(timeSlice20, new ActionListener() {

		public void actionPerformed(ActionEvent e) {

			if (animationRe < 7) {
				try {
					OthelloWindow.buttonArray[animationRe][animationCe].setBackground((Color) gameOver.winnerColor);
				} catch (Exception e1) {
					// Do nothing
				}
				animationRe++;
			} else if (animationCe < 8) {
				try {
					OthelloWindow.buttonArray[animationRe][animationCe].setBackground((Color) gameOver.winnerColor);
				} catch (Exception e1) {
					// Do nothing
				}
				animationCe++;
				animationRe = 0;
			} else {
				animationRe = 0;
				animationCe = 0;
				ttbFill.stop();
				System.out.println("timer ttbFill has stopped");
			}
		}
	});

	static Timer scatterAlternateFill = new Timer(timeSlice15, new ActionListener() {

		public void actionPerformed(ActionEvent e) {

			ttbFill.setInitialDelay(200);
			ttbFill.start();
			if (animationR < 7) {
				try {
					OthelloWindow.buttonArray[(int) (Math.random() * 7) + 1][animationC]
							.setBackground((Color) gameOver.winnerColorOpposite);
				} catch (Exception e1) {
					// Do nothing
				}
				animationR++;
			} else if (animationC < 8) {
				OthelloWindow.buttonArray[animationR][(int) (Math.random() * 7) + 1]
						.setBackground((Color) gameOver.winnerColor);
				animationC++;
				animationR = 0;
			} else {

				animationR = 0;
				animationC = 0;
				scatterAlternateFill.stop();
				System.out.println("timer scatterAlternateFill has stopped");
			}
		}
	});
	
	static Timer chaosFill = new Timer(timeSlice20, new ActionListener() {

		public void actionPerformed(ActionEvent e) {
			int randR = (int) (Math.random()*8);
			int randC = (int) (Math.random()*8);
			
			if (count < 58) {
				
				if (thisColor == (Color) gameOver.winnerColor) {
					thisColor = (Color) gameOver.winnerColorOpposite;
				} else {
					thisColor = (Color) gameOver.winnerColor;
				}
				OthelloWindow.buttonArray[randR][randC].setBackground(thisColor);
				count++;
			
			}
			if (count == 50) {
				scatterFill.start();
				chaosFill.stop();
				System.out.println("timer chaosFill has stopped");
				count = 0;
			}
			
		}
	});
	
	static Timer letterXFill = new Timer(150, new ActionListener() {

		public void actionPerformed(ActionEvent e) {
			
			
			
			if (test < 7) {
				OthelloWindow.buttonArray[rEight][cEight].setBackground((Color) gameOver.winnerColor);
				rEight--;
				cEight++;
				test++;
				animationC = 4;
				animationR = 4;
			}
			
			if (test == 7) {
				OthelloWindow.buttonArray[rEight][cEight].setBackground((Color) gameOver.winnerColorOpposite);
				cEight--;
				rEight++;
				testTwo++;
			}
			
			if (testTwo == 4) {
				OthelloWindow.buttonArray[rEight-1][cEight].setBackground((Color) gameOver.winnerColor);
				OthelloWindow.buttonArray[animationR][animationC].setBackground((Color) gameOver.winnerColorOpposite);
				test = 8;
				cEight--;
				rEight--;
				animationC++;
				animationR++;
				testThree++;
			}
			
			if (testThree == 4) {
				testTwo = 0;
				testThree = 0;
				test = 0;
				animationC = 0;
				animationR = 0;
				cEight = 0;
				rEight = 7;
				chaosFill.start();
				letterXFill.stop();
				System.out.println("timer letterXFill has stopped");
			}
			
		}
	});
	
	interface RandomAnimation {
		void anim();
	}
	
	private static RandomAnimation[] animationList = new RandomAnimation[] {
			
		new RandomAnimation() { public void anim() { scatterAlternateFill();}

			private void scatterAlternateFill() {
				scatterAlternateFill.start();
			
		} },
		
		new RandomAnimation() { public void anim() { scatterFill();}

			private void scatterFill() {
				scatterFill.start();
			
		} },
		
		new RandomAnimation() { public void anim() { ttbFill();}

			private void ttbFill() {
				ttbFill.start();
			
		} },
		
		new RandomAnimation() { public void anim() { chaosFill();}

			private void chaosFill() {
				chaosFill.start();
			
		} },
		
		new RandomAnimation() { public void anim() { letterXFill();}

			private void letterXFill() {
				letterXFill.start();
		
	} },
	}; 
	
	public static void anim(int index) {
		animationList[index].anim();
	}

}
