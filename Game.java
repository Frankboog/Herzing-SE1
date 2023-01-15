import java.util.Objects;

public class Game {
	
	// object attributes
	private Player p1, p2;
	private int pickP1, pickP2;


	// default constructor
	public Game() {
		this.p1 = new Player();
		this.p2 = new Player();
	}//end default constructor Game
	
	
	// constructor
	public Game(Player p1, Player p2) {
		this.setPlayer1(p1);
		this.setPlayer2(p2);
	}//end constructor Game
	
	
	// get winner
	public int winner() {
		int winner = 0;
		if (this.pickP1 == this.pickP2) {return winner = 0;}//end IF condition
		else if (this.pickP1 == 1 && this.pickP2 == 2) {return winner = 2;}//end IF condition
		else if (this.pickP1 == 1 && this.pickP2 == 3) {return winner = 1;}//end IF condition
		else if (this.pickP1 == 2 && this.pickP2 == 1) {return winner = 1;}//end IF condition
		else if (this.pickP1 == 2 && this.pickP2 == 3) {return winner = 2;}//end IF condition
		else if (this.pickP1 == 3 && this.pickP2 == 1) {return winner = 2;}//end IF condition
		else if (this.pickP1 == 3 && this.pickP2 == 2) {return winner = 1;}//end IF condition
		return winner;
	}//end method winner

	
	// update players
	public void updatePlayers(int winner) {
		if (winner == 1) {
			p1.addWin();
			p2.addLose();
		}//end IF condition
		else if (winner == 2) {
			p1.addLose();
			p2.addWin();
		}//end IF condition
		else if (winner == 0) {
			p1.addTie();
			p2.addTie();
		}//end IF condition
	}//end method updatePlayers
	
	
	// return pick
	public String getPick(int x) {
		String pick = new String();
		switch (x) {
			case 1: {pick = "ROCK"; break;}//end case 1
			case 2: {pick = "PAPER"; break;}//end case 1
			case 3: {pick = "SCISSORS"; break;}//end case 1
			default: {pick = "NONE"; break;}//end case 1
		}//end switch
		return pick;
	}//end method getPick

	
	// return player 1
	public Player getPlayer1() {
		return this.p1;
	}//end method getPlayer1

	
	// return player 2
	public Player getPlayer2() {
		return this.p2;
	}//end method getPlayer2
	
	
	// return player 1 pick
	public int getPickP1() {
		return this.pickP1;
	}//end method getPickP1

	
	// return player 2 pick
	public int getPickP2() {
		return this.pickP2;
	}//end method getPickP2
	
	
	// update player 1
	public void setPlayer1(Player p1) {
		this.p1 = p1;
	}//end method setPlayer1

	
	// update player 2
	public void setPlayer2(Player p2) {
		this.p2 = p2;
	}//end method setPlayer2

	
	// update player 1 pick
	public void setPickP1(int pickP1) {
		this.pickP1 = pickP1;
	}//end method setPickP1

	
	// update player 2 pick
	public void setPickP2(int pickP2) {
		this.pickP2 = pickP2;
	}//end method setPickP2

	
	@Override
	public String toString() {
		return " ProfileClass(player1=" + this.getPlayer1() + ", player2=" + this.getPlayer2() + ")";
	}//end method toString
	
	
	@Override
	public int hashCode() {
		return Objects.hash(p1, p2);
	}//end method hashCode
	
	
	@Override
	public boolean equals(final Object o) {
		if (this == o) {return true;}//end IF condition
		if (o == null) {return false;}//end IF condition
		if (getClass() != o.getClass()) {return false;}//end IF condition
		Game game = (Game) o;
		return Objects.equals(p1, game.p1) && Objects.equals(p2, game.p2);
	}//end method equals

}//end class Game
