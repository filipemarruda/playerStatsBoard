package playerstats;

public class PlayerStats {

	private String name;
	private int gamesPlayed;
	private int goals;
	private int assists;
	private int points;
	private int saves;
	private int shotsTaken;

	public PlayerStats(String name, int gamesPlayed, int goals, int assists, int points, int saves, int shotsTaken) {
		this.name = name;
		this.gamesPlayed = gamesPlayed;
		this.goals = goals;
		this.assists = assists;
		this.points = points;
		this.saves = saves;
		this.shotsTaken = shotsTaken;
	}

	public String getName() {
		return name;
	}

	public Integer getGamesPlayed() {
		return gamesPlayed;
	}

	public Integer getGoals() {
		return goals;
	}

	public Integer getAssists() {
		return assists;
	}

	public Integer getPoints() {
		return points;
	}

	public Integer getSaves() {
		return saves;
	}

	public Integer getShotsTaken() {
		return shotsTaken;
	}

}
