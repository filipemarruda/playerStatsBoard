package playerstats.observers.impl;

import java.util.ArrayList;
import java.util.List;

import playerstats.PlayerStats;
import playerstats.observers.PlayerStatsObserver;

public class CounterObservable implements PlayerStatsObserver{

	private List<PlayerStats> stats = new ArrayList<>(); 
	
	@Override
	public void process(PlayerStats playerStats) {
		stats.add(playerStats);
	}

	@Override
	public String getResult() {
		return "The number of stats is " + stats.size();
	}

}
