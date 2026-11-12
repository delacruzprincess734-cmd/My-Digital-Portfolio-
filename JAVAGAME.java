import java.util.*;
	public class WordAdventure {
		static Scanner input = new Scanner(System.in);
		
		//Guess the Word Game
		
		static final int MAX_LIVES = 7;
		static String[] words = {
			"ALGORITHM",
			"VARIABLE",
			"NETWORK",
			"PROGRAMMING", 
			"SOFTWARE",
			"HARDWARE",
			"COMPUTER",
			"BOOLEAN"	};
			
		static String[] clues = {
			"A step by step procedure used to solve a problem.",
			"A container used to store data in programming.",
			"A group of connected computer or devices.",
			"A set of instructions written for a computer.",
			"Program and applications used by a computer.",
			"The physical parts of a computer.",
			"An electronic device that processes data.",
			"Java data type that represents two values, true or false."	};
			
		public static void main (String[]args) {
			
				int lives = MAX_LIVES;
				int score = 0;
				
			List<Integer> questionOrder = new ArrayList<>();
			
			//Random word order
			
		for(int i = 0; i < words.length; i++) {
				questionOrder.add(i); }
				
			Collections.shuffle(questionOrder);
			
			System.out.println("=======================================================");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~WORD ADVENTURE~~~~~~~~~~~~~~~~~~~~");
			System.out.println("=======================================================");
			
			System.out.println("Welcome to our incredible game called, Word Adventure.");
			System.out.println("Let your word be an answer.");
			System.out.println("All you need to do is, guess the hidden word ;P");
			System.out.println("Remember you only have 7 lives, put your best shot.");
			System.out.println("-------------------------------------------------------");
			
			System.out.print("Enter your name: ");
			String name = input.nextLine();
			
			System.out.println("\nGood luck " +name + "! Enjoy your game:)");
			
			System.out.println("Please Press ENTER to start...");
			input.nextLine();
			
			//Game questions
			
			for(int index : questionOrder) {
				if(lives <= 0) { break;
				}
				
			String answer =words[index];
			char[] hiddenWord = new char[answer.length()];
			Arrays.fill(hiddenWord,'_');
			
			Set<Character> guessedLetters = new HashSet<>();
			
			boolean solved = false;
			
			System.out.println("=======================================================");
			System.out.println("NEW WORD");
			System.out.println("CLUE: " + clues[index]);
			
			while(lives > 0 && !solved) {
			
			System.out.print("\nWord: ");
			for(int i = 0; i < hiddenWord.length; i++) {
			System.out.print(hiddenWord[i] + " "); }
			
			System.out.println();
			System.out.println("Lives Remaining: " + lives);
			System.out.println("Current Score: " + score);
			System.out.print("Enter ONE Letter: ");
			
			String guess = input.nextLine().trim().toUpperCase();
			
			if(!guess.matches("[A-Z]")) {
				System.out.println("Invalid input! Please ONE letter only.");
				continue; }
				
				char letter = guess.charAt(0);
				if(guessedLetters.contains(letter)) {
				System.out.println("You already guessed that letter! Try another.");
				continue; }
				
				guessedLetters.add(letter);
				boolean found = false;
				
				for(int i = 0; i < answer.length(); i++) {
				if(answer.charAt(i) == letter) {
					hiddenWord[i]= letter;
					found = true; }
				}
				
				if(found) {
				System.out.println("Correct Letter!");
				score ++;
				
				} else {
				lives --;
				
				System.out.println("Wrong Letter!");
				
				System.out.println("You lost 1 life"); }
				
				solved = String.valueOf(hiddenWord).equals(answer);
				
				if(solved) {
				System.out.println("\nCONGRATULATIONS!");
				System.out.println("You have succesfully guessed the answer.");
				System.out.println("The correct word is: " +answer);
				System.out.println("You earned 5points");
				
				score += 5; }
				
					
				System.out.println("-------------------------------------------------------"); }
			}
				
				System.out.println("\n=======================================================");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~GAME OVER~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("\n=======================================================");
				
				System.out.println("Player Name: " + name);
				System.out.println("Final Score: " + score);
				System.out.println("Remaining Lives: " + lives);
				
				if(lives > 0) {
				System.out.println("\nCongratulations");
				System.out.println("You have successfully finished all the words.");
				} else {
				System.out.println("\nSorry, You ran out of lives.");
				System.out.println("Better luck next time");
				}
				
				System.out.println("\nThank you for playing and trying our game, hope you enjoy:)");
				System.out.println("==========================================================");
			
	}
}
						