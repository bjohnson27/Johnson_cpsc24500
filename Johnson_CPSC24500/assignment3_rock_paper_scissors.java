/*
 * CPSC 24500-001 Assignment 3 - Rock, Paper, Scissors
 * due 2/23/24
 * Ben Johnson
 * 
 */
import java.util.Scanner; 
import java.util.Random;
public class assignment3_rock_paper_scissors {


	public static String getComputerMove() {
	Random random = new Random();	
	int rand_num = random.nextInt(3)+1;
	if(rand_num == 1) {
		 return "rock";
	} else if (rand_num == 2) {
		 return "paper";
	} else {
		 return "scissors";
	}
	}	
	
    public static String getUserMove(Scanner scan) {
        boolean validInput = false;
        String user_move="";
        while (!validInput) {
            System.out.println("Select one: ");
            System.out.println("1 = rock | 2 = paper | 3 = scissors");
            if (scan.hasNextInt()) {
                int user_choice = scan.nextInt();
                if (user_choice >= 1 && user_choice <= 3) {
                    validInput = true;
                    if (user_choice == 1) {
                        user_move = "rock";
                    } else if (user_choice == 2) {
                        user_move = "paper";
                    } else {
                        user_move = "scissors";
                    }
                } else {
                    System.out.println("Error: Invalid input! Please enter a number between 1 and 3.");
                    // Consume the invalid input
                    scan.nextLine();
                }
            } else {
                System.out.println("Error: Invalid input! Please enter a number.");
                // Consume the invalid input
                scan.next();
            }
        }
		return user_move;
    }
	public static void pickWinner(String com_move, String user_move) {
		 if (com_move.equals(user_move)) {
			 System.out.println("It's a tie!");
		 } else if(user_move.equals("rock") && com_move.equals("scissors")) {
			 System.out.println("YOU WIN");
		 }else if(user_move.equals("paper") && com_move.equals("rock")) {
			 System.out.println("YOU WIN");
		 } else if(user_move.equals("scissors") && com_move.equals("paper")) {
			 System.out.println("YOU WIN");
		 } else {
			 System.out.println("YOU LOSE");
		 }
	}
	
	
	
	
	public static void main(String[] args) {
		boolean exit_game = false;
		Scanner scan = new Scanner(System.in);
		Random random = new Random();
			System.out.println("Welcome to Rock, Paper, Scissors");
			System.out.println();
			
			
			while(!exit_game) {
				String com_move = getComputerMove();
				String user_move = getUserMove(scan);
				System.out.println("your move: " + user_move);
				System.out.println("computer move: " + com_move);
				System.out.println();
				pickWinner(com_move, user_move);
				
	            if (com_move.equals(user_move)) {
	                continue;
	            }
	            
				System.out.println("Do you want to play again? y or n?");
				String playAgain = scan.next();
				if (!playAgain.equalsIgnoreCase("y")) {
					exit_game = true;
				}
			}
			System.out.println("Thank you for playing");
		}
}
