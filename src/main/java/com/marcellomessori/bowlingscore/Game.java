package com.marcellomessori.bowlingscore;

class Game {

	int score = 0;

	void roll(int i) {
		score += i;
	}

	int score() {
		return score;
	}

	void init(int i) {
		score = i;
	}

}
