import java.util.ArrayList;
import java.util.Scanner;
/**
 * This class ties all the elements together and implement the flow of the game
 * @author Xueli Cao
 *
 */
public class BlackjackSolitaire {
	Board board;
	Card card;
	Deck deck;
	
	public BlackjackSolitaire() {		
	}

	//

	/**
	 * The method implement the flow of the game.
	 * 1.Display the initial game board
	 * 2.shuflle the deck
	 * 3.dealing a card
	 * 4.prompts the position request to the player
	 * 5.error check the position
	 * 6.update the game board according to the dealt card and position entered by the player
	 * 7.repeat until 16 grid spots are filled with cards (while loop)
	 * 8.calculate the score the pring the final score
	 */
	void play() {
	// 1.display the initial state of the game
	Board board = new Board();
	board.display();
	//System.out.println(board.gameBoard[0][0].valueOfCard);
	
	//2.shuflle the deck
	//Card[] myDeck = new Card[52];
	Card[] myDeck = Deck.shuflleDeck(Deck.getDeck());
	
	
	ArrayList<Integer> gridSpots = new ArrayList<Integer>();
	ArrayList<Integer> discardSpots = new ArrayList<Integer>();
	ArrayList<Integer> allEnteredSpots = new ArrayList<Integer>();
	
	int cardNum = 0;
	int numOfDiscardSpotsLeft = 0;
	String[] Discards = {"11", "15", "16", "20"};
	
	while (gridSpots.size() <16) {
	//3.deal a card
	Card cardDealt = myDeck[cardNum];
	System.out.println("The card you get is: " + cardDealt.rankSuit);
	
	//4.prompts the position request to the player
	Scanner userInputScanner = new Scanner(System.in);
	
	//5.error check if out of range or if a spot already has a card
	int position = 0;
	while(true) {
		System.out.println("Please enter the position: ");
		int n = userInputScanner.nextInt();
		if (n < 1 || n > 20) {
			
			System.out.println("The position you entered is out of range!");
			continue;
		}
		else {
			if (allEnteredSpots.contains(n)) {
				System.out.println("The position you entered already has a card!");
				continue;
			}
			else{
					position = n;
					break;
				}
			}
	}
		
	//update the arraylists
	allEnteredSpots.add(position);
	if (position != 11 & position !=15 & position !=16 & position !=20) {
		gridSpots.add(position);
	}
	else {
		discardSpots.add(position);
	}
	numOfDiscardSpotsLeft = 4 - discardSpots.size();
	
	//6.update the gameboard
	if (position == 11) {
		Discards[0] = cardDealt.rankSuit;			
	}
	else if (position == 15) {
		Discards[1] = cardDealt.rankSuit;
	}
	else if (position == 16) {
		Discards[2] = cardDealt.rankSuit;
	}
	else if (position == 20) {
		Discards[3] = cardDealt.rankSuit;
	}
	
	board.gameBoard = board.update(cardDealt, position);
	
	System.out.println("Discards: ");
	for (int i = 0; i < Discards.length; i++) {
		System.out.print(Discards[i] + " ");
	}
	
	System.out.println();
	
	System.out.println("You have " + numOfDiscardSpotsLeft + " discard spots left!");
	
	System.out.println();
	
	cardNum ++;
	
	}
	
	/*
	for (int i = 0; i < 4; i++) {
		for (int j = 0; j <5; j++) {
			System.out.format("%5s", board.gameBoard[i][j].rankSuit);
		}
		System.out.println();
	
	}
	*/
	//8.calculate score
	board.score();
	
	System.out.println("Your final score is: " + board.score());
	}
}
