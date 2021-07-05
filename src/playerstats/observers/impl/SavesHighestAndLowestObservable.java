package playerstats.observers.impl;

import java.util.TreeSet;

import playerstats.PlayerStats;
import playerstats.observers.HighestAndLowerStatObserver;

public class SavesHighestAndLowestObservable implements HighestAndLowerStatObserver {

	private TreeSet<PlayerStats> stats = new TreeSet<PlayerStats>((stat1, stat2) -> stat1.getSaves().compareTo(stat2.getSaves()));
	
	@Override
	public void process(PlayerStats playerStats) {
		stats.add(playerStats);
	}

	@Override
	public String getResult() {
		PlayerStats highest = getPlayerStatsHighest();
		PlayerStats lowest = getPlayerStatsLowest();
		return highest.getSaves() + " saves by " + highest.getName() + " / " + lowest.getSaves() + " saves by " + lowest.getName();
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
