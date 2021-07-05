package playerstats.observers;

import playerstats.PlayerStats;

public interface HighestAndLowerStatObserver extends PlayerStatsObserver {
	PlayerStats getPlayerStatsHighest();
	PlayerStats getPlayerStatsLowest();
}
