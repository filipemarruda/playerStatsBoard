package playerstats.observers.impl;

import java.util.TreeSet;

import playerstats.PlayerStats;
import playerstats.observers.HighestAndLowerStatObserver;

public class GamesPlayedHighestAndLowestObservable implements HighestAndLowerStatObserver {

	private TreeSet<PlayerStats> stats = new TreeSet<PlayerStats>((stat1, stat2) -> stat1.getGamesPlayed().compareTo(stat2.getGamesPlayed()));
	
	@Override
	public void process(PlayerStats playerStats) {
		stats.add(playerStats);
	}

	@Override
	public String getResult() {
		PlayerStats highest = getPlayerStatsHighest();
		PlayerStats lowest = getPlayerStatsLowest();
		return highest.getGamesPlayed() + " games played by " + highest.getName() + " / " + lowest.getGamesPlayed() + " games played by " + lowest.getName();
	}

	@Override
	public PlayerStats getPlayerStatsHighest() {
		return stats.last();
	}

	@Override
	public PlayerStats getPlayerStatsLowest() {
		return stats.first();
	}

}
