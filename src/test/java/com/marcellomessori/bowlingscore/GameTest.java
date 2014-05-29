package com.marcellomessori.bowlingscore;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class GameTest {

	private Game game;
	
    @Before
    public void setUp() {
		game = new Game();
    }

    @After
    public void tearDown() {
    }

	@Ignore
	public void shouldReturnTheFinalResultGivenByTheExample() {
		game.init(0);

		game.roll(1);
		game.roll(4);
		
		game.roll(4);
		game.roll(5);
		
		game.roll(6);
		game.roll(4);
		
		game.roll(5);
		game.roll(5);
		
		game.roll(10);
		
		game.roll(0);
		game.roll(1);
		
		game.roll(7);
		game.roll(3);
		
		game.roll(6);
		game.roll(4);
		
		game.roll(10);
		
		game.roll(2);
		game.roll(8);
		game.roll(6);
		
		assertEquals(133, game.score());
	}
	
	@Test
	public void shouldComputeAFrame() {
		game.init(5);

		game.roll(4);
		game.roll(5);
		
		assertEquals(14, game.score());
	}
	
	@Test
	public void shouldComputeAFrameWithASpare() {
		game.init(14);

		game.roll(6);
		game.roll(4);
		int pinsNextRoll = 5;
		game.roll(pinsNextRoll);
		
		assertEquals(29 + pinsNextRoll, game.score());
	}
}
