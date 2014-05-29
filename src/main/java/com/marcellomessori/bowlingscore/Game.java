package com.marcellomessori.bowlingscore;

class Game {

	int score = 0;
	boolean isSecondRollOfAFrame;
	int valueOfPreviousRollWas;
	int rollLeftToAddForStrike;

	public void roll(int pins) {
		if (rollLeftToAddForStrike > 0) {
			score += pins;
			rollLeftToAddForStrike--;
		}
		
		score += pins;

		setStatusForTheNextRoll(pins);
	}

	public int score() {
		return score;
	}

	public void init(int i) {
		score = i;
		isSecondRollOfAFrame = false;
		valueOfPreviousRollWas = 0;
		rollLeftToAddForStrike = 0;
	}

	private void setStatusForTheNextRoll(int pins) {
		//spare
		if (isSecondRollOfAFrame && valueOfPreviousRollWas + pins == 10) {
			rollLeftToAddForStrike = 1;
		}

		// strike
		if (!isSecondRollOfAFrame && pins == 10) {
			rollLeftToAddForStrike = 2;
		}
		else {
			isSecondRollOfAFrame = !isSecondRollOfAFrame;
		}
		
		valueOfPreviousRollWas = pins;
	}

}
