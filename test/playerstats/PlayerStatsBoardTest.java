package playerstats;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import playerstats.PlayerStats;
import playerstats.PlayerStatsBoard;
import playerstats.observers.impl.AssistsHighestAndLowestObservable;
import playerstats.observers.impl.CounterObservable;
import playerstats.observers.impl.GamesPlayedHighestAndLowestObservable;
import playerstats.observers.impl.GoalsHighestAndLowestObservable;
import playerstats.observers.impl.PointsHighestAndLowestObservable;
import playerstats.observers.impl.SavesHighestAndLowestObservable;
import playerstats.observers.impl.ShotsTakenHighestAndLowestObservable;

public class PlayerStatsBoardTest {
	
	void addPlayers(PlayerStatsBoard playerStatsBoard) {
		playerStatsBoard.addPlayerStats(new PlayerStats("Player1", 32, 5, 12, 9, 3, 8));
		playerStatsBoard.addPlayerStats(new PlayerStats("Player2", 14, 2, 7, 3, 0, 6));
		playerStatsBoard.addPlayerStats(new PlayerStats("Player3", 34, 13, 10, 26, 14, 19));
		playerStatsBoard.addPlayerStats(new PlayerStats("Player4", 3, 0, 1, 0, 2, 3));
		playerStatsBoard.addPlayerStats(new PlayerStats("Player5", 8, 4, 6, 7, 5, 9));
	}

	@Test
	public void getSimpleCounter() {
		PlayerStatsBoard playerStatsBoard = new PlayerStatsBoard();
		playerStatsBoard.addObserver("counter", new CounterObservable());

		this.addPlayers(playerStatsBoard);
		
		assertEquals("The number of stats is 5", playerStatsBoard.getStat("counter"));
	}
	
	@Test
	public void getGamesPlayedHighestAndLowest() {
		PlayerStatsBoard playerStatsBoard = new PlayerStatsBoard();
		playerStatsBoard.addObserver("gamesPlayed", new GamesPlayedHighestAndLowestObservable());

		this.addPlayers(playerStatsBoard);
		
		
		assertEquals("34 games played by Player3 / 3 games played by Player4", playerStatsBoard.getStat("gamesPlayed"));
	}


	
	@Test
	public void getGoalsHighestAndLowest() {
		PlayerStatsBoard playerStatsBoard = new PlayerStatsBoard();
		playerStatsBoard.addObserver("goals", new GoalsHighestAndLowestObservable());

		this.addPlayers(playerStatsBoard);
		
		
		assertEquals("13 goals by Player3 / 0 goals by Player4", playerStatsBoard.getStat("goals"));
	}	
	@Test
	public void getAssistsHighestAndLowest() {
		PlayerStatsBoard playerStatsBoard = new PlayerStatsBoard();
		playerStatsBoard.addObserver("assists", new AssistsHighestAndLowestObservable());

		this.addPlayers(playerStatsBoard);
		
		
		assertEquals("12 assists by Player1 / 1 assists by Player4", playerStatsBoard.getStat("assists"));
	}
	
	@Test
	public void getPointsHighestAndLowest() {
		PlayerStatsBoard playerStatsBoard = new PlayerStatsBoard();
		playerStatsBoard.addObserver("points", new PointsHighestAndLowestObservable());

		this.addPlayers(playerStatsBoard);
		
		
		assertEquals("26 points by Player3 / 0 points by Player4", playerStatsBoard.getStat("points"));
	}
	
	@Test
	public void getSavesHighestAndLowest() {
		PlayerStatsBoard playerStatsBoard = new PlayerStatsBoard();
		playerStatsBoard.addObserver("saves", new SavesHighestAndLowestObservable());

		this.addPlayers(playerStatsBoard);
		
		
		assertEquals("14 saves by Player3 / 0 saves by Player2", playerStatsBoard.getStat("saves"));
	}
	
	@Test
	public void getShotsTakenHighestAndLowest() {
		PlayerStatsBoard playerStatsBoard = new PlayerStatsBoard();
		playerStatsBoard.addObserver("shotsTaken", new ShotsTakenHighestAndLowestObservable());

		this.addPlayers(playerStatsBoard);
		
		
		assertEquals("19 shots taken by Player3 / 3 shots taken by Player4", playerStatsBoard.getStat("shotsTaken"));
	}

}
