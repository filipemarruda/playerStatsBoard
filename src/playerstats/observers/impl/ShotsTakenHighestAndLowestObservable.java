package playerstats.observers.impl;

import java.util.TreeSet;

import playerstats.PlayerStats;
import playerstats.observers.HighestAndLowerStatObserver;

public class ShotsTakenHighestAndLowestObservable implements HighestAndLowerStatObserver {

	private TreeSet<PlayerStats> stats = new TreeSet<PlayerStats>((stat1, stat2) -> stat1.getShotsTaken().compareTo(stat2.getShotsTaken()));
	
	@Override
	public void process(PlayerStats playerStats) {
		stats.add(playerStats);
	}

	@Override
	public String getResult() {
		PlayerStats highest = getPlayerStatsHighest();
		PlayerStats lowest = getPlayerStatsLowest();
		return highest.getShotsTaken() + " shots taken by " + highest.getName() + " / " + lowest.getShotsTaken() + " shots taken by " + lowest.getName();
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
