package playerstats.observers.impl;

import java.util.TreeSet;

import playerstats.PlayerStats;
import playerstats.observers.HighestAndLowerStatObserver;

public class GoalsHighestAndLowestObservable implements HighestAndLowerStatObserver {

	private TreeSet<PlayerStats> stats = new TreeSet<PlayerStats>((stat1, stat2) -> stat1.getGoals().compareTo(stat2.getGoals()));
	
	@Override
	public void process(PlayerStats playerStats) {
		stats.add(playerStats);
	}

	@Override
	public String getResult() {
		PlayerStats highest = getPlayerStatsHighest();
		PlayerStats lowest = getPlayerStatsLowest();
		return highest.getGoals() + " goals by " + highest.getName() + " / " + lowest.getGoals() + " goals by " + lowest.getName();
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
