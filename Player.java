import java.util.Objects;

public class Player {

	
	// object attributes
	private String name;
	private int ID, wins, loses, ties;


	// default constructor
	public Player() {
		this.setID(0);
		this.setName("");
		this.setWins(0);
		this.setLoses(0);
		this.setTies(0);
	}//end default constructor Player
	
	
	// constructor
	public Player(int id, String name) {
		this.setID(id);
		this.setName(name);
		this.setWins(0);
		this.setLoses(0);
		this.setTies(0);
	}//end constructor Player
	
		
	// constructor
	public Player(int id, String name, int wins, int loses, int ties) {
		this.setID(id);
		this.setName(name);
		this.setWins(wins);
		this.setLoses(loses);
		this.setTies(ties);
	}//end constructor Player
	
		
	// return id
	public int getID() {
		return this.ID;
	}//end method getID

	
	// return player name
	public String getName() {
		return this.name;
	}//end method getName

	
	// return wins
	public int getWins() {
		return this.wins;
	}//end method getWins

	
	// return loses
	public int getLoses() {
		return this.loses;
	}//end method getLoses
	
	
	// return ties
	public int getTies() {
		return this.ties;
	}//end method getTies
	
	
	// update id
	public void setID(int id) {
		this.ID = id;
	}//end method setID

	
	// update name
	public void setName(String name) {
		this.name = name;
	}//end method setName

	
	// update wins
	public void setWins(int wins) {
		this.wins = wins;
	}//end method setWins


	// update loses
	public void setLoses(int loses) {
		this.loses = loses;
	}//end method setLoses

	
	// update ties
	public void setTies(int ties) {
		this.ties = ties;
	}//end method setTies

	
	// add win
	public void addWin() {
		int wins = this.getWins();
		wins += 1;
		this.setWins(wins);
	}//end method addWin


	// add lose
	public void addLose() {
		int loses = this.getLoses();
		loses += 1;
		this.setLoses(loses);
	}//end method addLose

	
	// add tie
	public void addTie() {
		int ties = this.getTies();
		ties += 1;
		this.setTies(ties);
	}//end method addTie

	
	@Override
	public String toString() {
		return " ProfileClass(ID=" + this.getID() + ", name=" + 
									this.getName() + ", wins=" + 
									this.getWins() + ", loses=" + 
									this.getLoses() + ", ties=" + 
									this.getTies() + ")";
	}//end method toString
	
	
	@Override
	public int hashCode() {
		return Objects.hash(ID, name, wins, loses, ties);
	}//end method hashCode
	
	
	@Override
	public boolean equals(final Object o) {
		if (this == o) {return true;}//end IF condition
		if (o == null) {return false;}//end IF condition
		if (getClass() != o.getClass()) {return false;}//end IF condition
		Player player = (Player) o;
		return Objects.equals(ID, player.ID) 
				&& Objects.equals(name, player.name)
				&& Objects.equals(wins, player.wins)
				&& Objects.equals(loses, player.loses)
				&& Objects.equals(ties, player.ties);
	}//end method equals
	
}//end class Player
