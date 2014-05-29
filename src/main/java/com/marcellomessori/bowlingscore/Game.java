package com.marcellomessori.bowlingscore;

class Game {

	int score = 0;
	boolean isSecondRollOfAFrame;
	int valueOfPreviousRollWas;
	boolean wasSpare;

	public void roll(int pins) {
		if (wasSpare) {
			score += pins;
			wasSpare = false;
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
		wasSpare = false;
	}

	private void setStatusForTheNextRoll(int pins) {
		if (isSecondRollOfAFrame && valueOfPreviousRollWas + pins == 10) {
			wasSpare = true;
		}

		valueOfPreviousRollWas = pins;
		isSecondRollOfAFrame = !isSecondRollOfAFrame;
	}

}
