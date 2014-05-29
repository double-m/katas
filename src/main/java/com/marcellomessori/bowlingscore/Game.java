package com.marcellomessori.bowlingscore;

class Game {

	int score = 0;
	boolean isSecondRollOfAFrame;
	int valueOfPreviousRollWas;
	int rollLeftToAddForSpareOrStrike;
	int frame;
	
	public void roll(int pins) throws Exception {
		boolean isTheExtraBall = checkExtraBall();
		checkBonus(pins);
		
		if (!isTheExtraBall) {
			score += pins;
			setStatusForTheNextRoll(pins);
		}
	}

	private void updateFrame() {
		if (!isSecondRollOfAFrame) {
			frame++;
		}
	}

	private boolean checkExtraBall() throws Exception {
		boolean isTheLastBall = false;
		
		updateFrame();

		if ( frame > 10 && !isSecondRollOfAFrame) {
			if (rollLeftToAddForSpareOrStrike == 1) {
				// extra ball
				isTheLastBall = true;
			}
			else {
				throw new Exception("Exceeded number of frames: this roll started frame number " + frame + " (only 10 allowed)");
			}
		}
		
		return isTheLastBall;
	}

	private void checkBonus(int pins) {
		if (rollLeftToAddForSpareOrStrike > 0) {
			score += pins;
			rollLeftToAddForSpareOrStrike--;
		}
	}

	public int score() {
		return score;
	}

	public void init(int i) {
		score = i;
		isSecondRollOfAFrame = false;
		valueOfPreviousRollWas = 0;
		rollLeftToAddForSpareOrStrike = 0;
		frame = 0;
	}

	private void setStatusForTheNextRoll(int pins) {
		//spare
		if (isSecondRollOfAFrame && valueOfPreviousRollWas + pins == 10) {
			rollLeftToAddForSpareOrStrike = 1;
		}

		// strike
		if (!isSecondRollOfAFrame && pins == 10) {
			rollLeftToAddForSpareOrStrike = 2;
		}
		else {
			isSecondRollOfAFrame = !isSecondRollOfAFrame;
		}
		
		valueOfPreviousRollWas = pins;
	}

}
