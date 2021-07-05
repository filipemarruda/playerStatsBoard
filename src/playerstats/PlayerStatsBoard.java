package playerstats;

import java.util.HashMap;
import java.util.Map;

import playerstats.observers.PlayerStatsObserver;

public class PlayerStatsBoard {
	
	private Map<String, PlayerStatsObserver> observers = new HashMap<>();

	public void addPlayerStats(PlayerStats playerStats) {
		for(PlayerStatsObserver playerStatsObserver: this.observers.values())
			playerStatsObserver.process(playerStats);
	}


	public void addObserver(String string, PlayerStatsObserver playerStatObserver) {
		this.observers.put(string, playerStatObserver);
	}


	public String getStat(String string) {
		return this.observers.get(string).getResult();
	}
	
	

}
