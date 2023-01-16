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
		
		
		// get game menu selection
		choice = getChoice(scan);

		
		// iterate user choice
		while (choice != -1) {
			String name1 = new String();
			String name2 = new String();
			name1 = scan.nextLine();
			switch(choice) {
				// case 1 start
				case 1: {
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
					break;
				}//end case 1
				case 2: {displayRules(); break;}//end case 2
				case 3: {admin(scan); break;}//end case 3
				//case 4: {}//end case 4
				default: {break;}//end default
			}//end switch
			
			
			// print game menu
			displayMenu();
			
			
			// get game menu selection
			choice = getChoice(scan);
			
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
		System.out.println(" [2] - Rules");
		//System.out.println(" [3] - Stats");
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
	
	
	// user menu choice
	private static int getChoice(Scanner scan) {
		// game menu selection
		int choice;
		while (true) {
			try {
				System.out.print(" Enter Selection: ");
				choice = scan.nextInt();
				if (choice == -1) {break;}//end IF condition
				else if (choice < 1 || choice > 3) {
					System.out.printf(" '%d' %s\n", choice,"Is Out of Range!\n");
					continue;
				}//end IF condition
				else {break;}//end else
			}//end try
			catch (java.util.InputMismatchException e) {
				handleMismatch(scan);
			}//end catch
			catch (Exception e) {
				handleExcept(scan);
			}//end catch
		}//end while loop
		return choice;
	}//end method getChoice
	
	
	// handle mismatch exception
	private static void handleMismatch(Scanner scan) {
		System.out.println("\n" + "-".repeat(26) + " INPUT MISMATCH " + "-".repeat(27));
		System.out.println(" Sorry, Your Choice Is Not On The Menu. Please Try Again!\n");
		scan.nextLine();
	}//end handleMismatch
	
	
	// handle exception
	private static void handleExcept(Scanner scan) {
		System.out.println("\n" + "-".repeat(29) + " EXCEPTION " + "-".repeat(29));
		System.out.println(" Not Valid, Please Try Again!\n");
		scan.nextLine();
	}//end handleExcept
	
	
	// play game
	private static void playGame(Game game, Player p1, Player p2, Scanner scan) {
		System.out.println("\n" + "=".repeat(7) + " PLAY GAME " + "=".repeat(51));
		System.out.println("\n Player One: " + p1.getName());
		System.out.println(" Player Two: " + p2.getName());
		
		
		// local variable
		Console cons;
		String again = new String("y");
		
		// loop while again
		while (!again.toLowerCase().equals("n")) {
			
			int pickP1 = 0;
			int pickP2 = 0;
			
			System.out.println("\n LETS BEGIN!");
			System.out.printf(" %2s %s\n", "1 =", "ROCK");
			System.out.printf(" %2s %s\n", "2 =", "PAPER");
			System.out.printf(" %2s %s\n", "3 =", "SCISSORS");

			// input player 1 pick
			while (true) {
				try {
					System.out.println(" PLAYER ONE");
					System.out.println("-".repeat(69));
					
					
					if ((cons = System.console()) != null) {
						char[] input = cons.readPassword(" Make Your Pick: ");
						String pick_str = new String(input);
						pickP1 = Integer.parseInt(pick_str);
					}//end IF condition
					else {
						System.out.print(" Make Your Pick: ");
						pickP1 = scan.nextInt();
					}//end else
					
					if (pickP1 < 1 || pickP1 > 3) {
						System.out.println("\n " + pickP1 + " Out of Range, Please Choose (1-3).");
						continue;
					}//end IF condition
					game.setPickP1(pickP1);
					break;
				}//end try
				catch (java.util.InputMismatchException e) {
					handleMismatch(scan);
				}//end catch
				catch (Exception e) {
					handleExcept(scan);
				}//end catch
			}//end while loop
			System.out.println();
			// input player 2 pick
			while (true) {
				try {
					System.out.println(" PLAYER TWO");
					System.out.println("-".repeat(69));
					if ((cons = System.console()) != null) {
						char[] input = cons.readPassword(" Make Your Pick: ");
						String pick_str = new String(input);
						pickP2 = Integer.parseInt(pick_str);
					}//end IF condition
					else {
						System.out.print(" Make Your Pick: ");
						pickP2 = scan.nextInt();
					}//end else
					if (pickP2 < 1 || pickP2 > 3) {
						System.out.println("\n " + pickP2 + " Out of Range, Please Choose (1-3).");
						continue;
					}//end IF condition
					game.setPickP2(pickP2);
					break;
				}//end try
				catch (java.util.InputMismatchException e) {
					handleMismatch(scan);
				}//end catch
				catch (Exception e) {
					handleExcept(scan);
				}//end catch
			}//end while loop
			
			// get winner & print results
			Player[] players = {p1, p2};
			System.out.println("\n Player One Picks: " + game.getPick(game.getPickP1()));
			System.out.println(" Player Two Picks: " + game.getPick(game.getPickP2()));
			
			int winner = game.winner();
			game.updatePlayers(winner);
			if (winner == 1) {
				System.out.println(" *** " + game.getPick(game.getPickP1()) + " - beats - " + game.getPick(game.getPickP2()) + " ***");
				System.out.println(" Congratulations " + game.getPlayer1().getName() + " You Win!");
			}//end IF condition
			else if (winner == 2) {
				System.out.println(" *** " + game.getPick(game.getPickP2()) + " - beats - " + game.getPick(game.getPickP1()) + " ***");
				System.out.println(" Congratulations " + game.getPlayer2().getName() + " You Win!");
			}//end IF condition
			else if (winner == 0) {
				System.out.println(" *** " + game.getPick(game.getPickP1()) + " - ties - " + game.getPick(game.getPickP2()) + " ***");
				System.out.println(" The Game is a Tie, Sorry, No Winners.");
			}//end IF condition
			System.out.println("\n" + "-".repeat(7) + " STATISTICS " + "-".repeat(50));
			System.out.printf(" %-20s %8s %8s %8s\n", "PLAYER", "WINS", "LOSES", "TIES");
			System.out.println("-".repeat(69) + "\n");
			for(int i = 0; i < players.length; i++) {
				System.out.printf(" %-20s %8d %8d %8d\n", players[i].getName(), 
						players[i].getWins(),
						players[i].getLoses(),
						players[i].getTies());
			}//end for loop
						
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
					System.out.println(" Sorry to see you Go! ");
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
	
	
	// administration testing
	private static void admin(Scanner scan) {
		int stay = 1;
		while (stay != 0) {
			// test area
			Console cons;
			if ((cons = System.console()) != null) {
			char[] password = cons.readPassword(" Input Password: ");
			System.out.println(" Password: " + new String(password));
			}
			else {
			System.out.println(" No Console Found...");
			}
			
			System.out.println();
			System.out.println();
			
			
//			System.out.println(" Print: ");
//			String input = System.console().readLine();
//			System.out.println(" Input: " + input);
			
			
			// game menu selection
			while (true) {
				try {
					System.out.print(" Enter Selection (0/1): ");
					stay = scan.nextInt();
					if (stay == 0) {break;}//end IF condition
					else if (stay < 1 || stay > 3) {
						System.out.printf(" '%d' %s\n", stay,"Is Out of Range!");
						continue;
					}//end IF condition
					else {break;}//end else
				}//end try
				catch (java.util.InputMismatchException e) {
					handleMismatch(scan);
				}//end catch
				catch (Exception e) {
					handleExcept(scan);
				}//end catch
			}//end while loop
		}//end while loop
	}//end method admin

}//end class GameBoard
