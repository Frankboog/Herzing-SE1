import java.io.Console;
import java.util.Scanner;

public class GameBoard {

	public static void main(String[] args) {		
		
		// instantiate scanner
		Scanner scan = new Scanner(System.in);
				
				
		// declare variable
		int choice = 0;
		
		
		// print title
		displayTitle();
		
		
		// print game menu
		displayMenu();
		
		
		// game menu selection
		while (true) {
			try {
				System.out.print(" Enter Selection: ");
				choice = scan.nextInt();
				if (choice == -1) {break;}//end IF condition
				else if (choice < 1 || choice > 4) {
					System.out.printf(" '%d' %s\n", choice,"Is Out of Range!");
					continue;
				}//end IF condition
				else {break;}//end else
			}//end try
			catch (java.util.InputMismatchException e) {
				System.out.println("\n========================== INPUT MISMATCH ===========================");
				System.out.println(" Sorry, Your Choice Is Not On The Menu: " + choice);
				scan.nextLine();
			}//end catch
			catch (Exception e) {
				System.out.println("\n============================= EXCEPTION =============================");
				System.out.println(" Not Valid, Please Try Again! ");
				scan.nextLine();
			}//end catch
		}//end while loop

		
		// iterate user choice
		while (choice != -1) {
			String name1 = new String();
			String name2 = new String();
			name1 = scan.nextLine();
			switch(choice) {
				// case 1 start
				case 1 -> {
					while (true) {
						System.out.print(" Enter Player 1 Name: ");
						name1 = scan.nextLine();
						if (name1.isEmpty()) {
							System.out.println("\n Player 1 needs a Name! ");
							continue;
						}//end IF condition
						else {break;}//end else
					}//end while loop
					while (true) {
						System.out.print(" Enter Player 2 Name: ");
						name2 = scan.nextLine();
						if (name2.isEmpty()) {
							System.out.println("\n Player 2 needs a Name! ");
							continue;
						}//end IF condition
						else if (name2.equals(name1)) {
							System.out.println("\n Names should be Unique! ");
							continue;
						}//end IF condition
						else {break;}//end else
					}//end while loop
					Player player1 = new Player (1, name1);
					Player player2 = new Player (2, name2);
					Game game = new Game (player1, player2);
					playGame(game, player1, player2, scan);
				}//end case 1
				case 2 -> {}//end case 2
				case 3 -> {displayRules();}//end case 3
				case 4 -> {admin();}//end case 4
				default -> {break;}//end default
			}//end switch
			
			
			// print game menu
			displayMenu();
			
			
			// game menu selection
			while (true) {
				try {
					System.out.print(" Enter Selection: ");
					choice = scan.nextInt();
					if (choice == -1) {break;}//end IF condition
					else if (choice < 1 || choice > 4) {
						System.out.printf(" '%d' %s\n", choice,"Is Out of Range!");
						continue;
					}//end IF condition
					else {break;}//end else
				}//end try
				catch (java.util.InputMismatchException e) {
					System.out.println("\n========================== INPUT MISMATCH ===========================");
					System.out.println(" Sorry, Your Choice Is Not On The Menu: " + choice);
					scan.nextLine();
				}//end catch
				catch (Exception e) {
					System.out.println("\n============================= EXCEPTION =============================");
					System.out.println(" Not Valid, Please Try Again! ");
					scan.nextLine();
				}//end catch
			}//end while loop
			
		}//end while loop (choice)
		
		
		// close scanner
		scan.close();
		
		
		// closing
		System.out.println("\n Thank you for Playing.");
		System.out.println(" Goodbye!");
		
	}//end main class
	
	
	// format/print title
	private static void displayTitle() {		
		System.out.println("\n" + "=".repeat(69));
		System.out.println(" ROCK, PAPER, SCISSORS");
		System.out.println("=".repeat(69) + "\n");
	}//end method displayTitle


	// format/print game menu
	private static void displayMenu() {
		System.out.println("\n" +"=".repeat(69));
		System.out.println("-".repeat(29) + " GAME MENU " + "-".repeat(29));
		System.out.println("=".repeat(69));
		System.out.println(" [1] - Play Game");
		System.out.println(" [2] - Stats");
		System.out.println(" [3] - Rules");
		System.out.println("[-1] - Exit");
		System.out.println("-".repeat(69) + "\n");
	}//end method displayMenu


	// format/print rules
	private static void displayRules() {
		System.out.println("=".repeat(29) + " GAME RULES " + "=".repeat(28));
		System.out.println(" Two Players Only");
		System.out.println(" Highest Total Wins End of Session Takes the Prize");
		System.out.println(" NO PEEKING!");
		System.out.println("=".repeat(69) + "\n");
	}//end method displayRules
	
	
	// play game
	private static void playGame(Game game, Player p1, Player p2, Scanner scan) {
		System.out.println("\n" + "=".repeat(7) + " PLAY GAME " + "=".repeat(51));
		System.out.println("\n Player One: " + p1.getName());
		System.out.println(" Player Two: " + p2.getName());
		
		
		// local variable
		String again = new String("y");
		
		// loop while again
		while (!again.toLowerCase().equals("n")) {
			
			int pickP1 = 0;
			int pickP2 = 0;
			
			System.out.println("\n LETS BEGIN!");
			System.out.printf(" %2s %s\n", "1 =", "ROCK");
			System.out.printf(" %2s %s\n", "2 =", "PAPER");
			System.out.printf(" %2s %s\n", "3 =", "SCISSORS");
			//System.out.printf(" %-10s %s\n", "ROCK", "= 1");
			//System.out.printf(" %-10s %s\n", "PAPER", "= 2");
			//System.out.printf(" %-10s %s\n\n", "SCISSORS", "= 3");

			// input player 1 pick
			while (true) {
				try {
					System.out.println(" PLAYER ONE");
					System.out.println("-".repeat(69));
					System.out.print(" Make Your Pick: ");
					pickP1 = scan.nextInt();
					game.setPickP1(pickP1);
					break;
				}//end try
				catch (java.util.InputMismatchException e) {
					System.out.println("\n========================== INPUT MISMATCH ===========================");
					System.out.println(" Your Choice Is Not On The Menu! ");
					scan.nextLine();
				}//end catch
				catch (Exception e) {
					System.out.println("\n============================= EXCEPTION =============================");
					System.out.println(" Not Valid, Please Try Again! ");
					scan.nextLine();
				}//end catch
			}//end while loop

			// input player 2 pick
			while (true) {
				try {
					System.out.println("\n PLAYER TWO");
					System.out.println("-".repeat(69));
					System.out.print(" Maker Your Pick: ");
					pickP2 = scan.nextInt();
					game.setPickP2(pickP2);
					break;
				}//end try
				catch (java.util.InputMismatchException e) {
					System.out.println("\n========================== INPUT MISMATCH ===========================");
					System.out.println(" Your Choice Is Not On The Menu! ");
					scan.nextLine();
				}//end catch
				catch (Exception e) {
					System.out.println("\n============================= EXCEPTION =============================");
					System.out.println(" Not Valid, Please Try Again! ");
					scan.nextLine();
				}//end catch
			}//end while loop
			
			// get winner & print results
			System.out.println("\n Player One Picks: " + game.getPick(pickP1));
			System.out.println(" Player Two Picks: " + game.getPick(pickP2));
			
			int winner = game.winner();
			game.updatePlayers(winner);
			if (winner == 1) {
				System.out.println(" *** " + game.getPick(pickP1) + " - beats - " + game.getPick(pickP2) + " ***");
				System.out.println(" Congratulations " + game.getPlayer1().getName() + " You Win!");
			}//end IF condition
			else if (winner == 2) {
				System.out.println(" *** " + game.getPick(pickP2) + " - beats - " + game.getPick(pickP1) + " ***");
				System.out.println(" Congratulations " + game.getPlayer2().getName() + " You Win!");
			}//end IF condition
			else if (winner == 0) {
				System.out.println(" *** " + game.getPick(pickP1) + " - ties - " + game.getPick(pickP2) + " ***");
				System.out.println(" The Game is a Tie, Sorry, No Winners.");
			}//end IF condition
			System.out.println("\n" + "-".repeat(7) + " STATISTICS " + "-".repeat(50));
			System.out.printf(" %-20s %8s %8s %8s\n", "PLAYER", "WINS", "LOSES", "TIES");
			System.out.println("-".repeat(69) + "\n");
			System.out.printf(" %-20s %8d %8d %8d\n", game.getPlayer1().getName(), 
												game.getPlayer1().getWins(),
												game.getPlayer1().getLoses(),
												game.getPlayer1().getTies());
			System.out.printf(" %-20s %8d %8d %8d\n", game.getPlayer2().getName(), 
												game.getPlayer2().getWins(),
												game.getPlayer2().getLoses(),
												game.getPlayer2().getTies());
			
			// play again selection
			while (true) {
				System.out.print("\n Play Again? (y/n): ");
				again = scan.next();
				//if () {}//end IF condition
				if (again.toLowerCase().equals("y")) {
					System.out.println(" Fantastic! ");
					break;
				}//end IF condition
				else if (again.toLowerCase().equals("n")) {
					System.out.println(" Sorry to see you go! ");
					break;
				}//end IF condition
				//else if (!again.toLowerCase().equals("y") && !again.toLowerCase().equals("n")) 
				else {
					System.out.println(" '" + again + "' Not a Valid Choice! ");
					continue;
				}//else
			}//end while loop
		}//end while loop
	}//end method addPlayers
	
	
	// play game
	private static void playGame_OLD(Player p1, Player p2, Scanner scan) {
		System.out.println(" Player One: " + p1.getName());
		System.out.println(" Player Two: " + p2.getName());
		System.out.println(" LETS BEGIN!\n");
		String again = new String("y");
		while (!again.toLowerCase().equals("n")) {
			
			int pickP1 = 0;
			int pickP2 = 0;

			System.out.printf("%10s %s\n", "ROCK", "= 1");
			System.out.printf("%10s %s\n", "PAPER", "= 2");
			System.out.printf("%10s %s\n", "SCISSORS", "= 3");

			while (true) {
				try {
					System.out.println(" PLAYER ONE");
					System.out.println("-".repeat(69));
					System.out.print(" Enter Selection: ");
					pickP1 = scan.nextInt();
					break;
				}//end try
				catch (java.util.InputMismatchException e) {
					System.out.println("\n========================== INPUT MISMATCH ===========================");
					System.out.println(" Your Choice Is Not On The Menu! ");
					scan.nextLine();
				}//end catch
				catch (Exception e) {
					System.out.println("\n============================= EXCEPTION =============================");
					System.out.println(" Not Valid, Please Try Again! ");
					scan.nextLine();
				}//end catch
			}//end while loop


			
			while (true) {
				try {
					System.out.println(" PLAYER TWO");
					System.out.println("-".repeat(69));
					System.out.print(" Enter Selection: ");
					pickP2 = scan.nextInt();
					break;
				}//end try
				catch (java.util.InputMismatchException e) {
					System.out.println("\n========================== INPUT MISMATCH ===========================");
					System.out.println(" Your Choice Is Not On The Menu! ");
					scan.nextLine();
				}//end catch
				catch (Exception e) {
					System.out.println("\n============================= EXCEPTION =============================");
					System.out.println(" Not Valid, Please Try Again! ");
					scan.nextLine();
				}//end catch
			}//end while loop
			
			
			
			System.out.println(" Player One Picks: " + getPick(pickP1));
			System.out.println(" Player Two Picks: " + getPick(pickP2));
			
			int winner = winner(pickP1, pickP2);
			System.out.println(" The Winner is Player: " + winner);
			System.out.println(" Congratulations!\n");

			
			while (true) {
				System.out.print("\n Play Again? (y/n): ");
				again = scan.next();
				//if () {}//end IF condition
				if (again.toLowerCase().equals("y")) {
					System.out.println(" Fantastic! ");
					break;
				}//end IF condition
				else if (again.toLowerCase().equals("n")) {
					System.out.println(" Sorry to see you go! ");
					break;
				}//end IF condition
				//else if (!again.toLowerCase().equals("y") && !again.toLowerCase().equals("n")) 
				else {
					System.out.println(" '" + again + "' Not a Valid Choice! ");
					continue;
				}//else
			}//end while loop
		}//end while loop
	}//end method addPlayers
	
	
	// get winner
	private static int winner(int pk1, int pk2) {
		int winner = 0;
		if (pk1 == pk2) {return winner = 0;}//end IF condition
		else if (pk1 == 1 && pk2 == 2) {return winner = 2;}//end IF condition
		else if (pk1 == 1 && pk2 == 3) {return winner = 1;}//end IF condition
		else if (pk1 == 2 && pk2 == 1) {return winner = 1;}//end IF condition
		else if (pk1 == 2 && pk2 == 3) {return winner = 2;}//end IF condition
		else if (pk1 == 3 && pk2 == 1) {return winner = 2;}//end IF condition
		else if (pk1 == 3 && pk2 == 2) {return winner = 1;}//end IF condition
		return winner;
	}//end method getPick

	
	// return pick
	private static String getPick(int x) {
		String pick = new String();
		switch (x) {
			case 1 -> {pick = "ROCK";}//end case 1
			case 2 -> {pick = "PAPER";}//end case 1
			case 3 -> {pick = "SCISSORS";}//end case 1
			default -> {pick = "ROCK";}//end case 1
		}//end switch
		return pick;
	}//end method getPick

	
	// administration testing
	private static void admin() {
		// test area
		//Console cons;
		//if ((cons = System.console()) != null) {
		//char[] password = cons.readPassword(" Input Password: ");
		//System.out.println(" Password: " + new String(password));
		//}
		//else {
		//System.out.println(" No Console Found...");
		//}
		
		System.out.println(" Print: ");
		String input = System.console().readLine();
		System.out.println(" Input: " + input);
		
		
		
	}//end method admin

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}//end class GameBoard
