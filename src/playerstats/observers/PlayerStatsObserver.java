package playerstats.observers;

import playerstats.PlayerStats;

public interface PlayerStatsObserver {
	void process(PlayerStats playerStats);
	String getResult();
}
