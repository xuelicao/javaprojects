/**
 * Deck class will be getting the deck which includes all cards and shuflle the deck
 * @author Xueli Cao
 *
 */
public class Deck {
	//instant variables
	Card[] myDeck;
	
	
	//constructor
	public Deck (){
		myDeck = new Card[52];
	}
	
	//methods
	/**
	 * create the deck of cards that  use the convention that the card is
	 *going to be displayed with the rank combined with the suit
	 * @param numOfCards
	 * @return the deck
	 */
	public static Card[] getDeck () {
		Card[] allCards = new Card[52];
		String[] cardNum = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
		String[] cardSuit = {"S", "H", "D", "C"};
		int multiple = 0;
		for (int i = 0; i < cardSuit.length; i++) {
			for (int j = 0; j < cardNum.length; j++) {
				allCards[multiple * cardNum.length + j] = new Card(cardNum[j] + cardSuit[i], 1);
			}
			multiple ++;
		}
		return allCards;
	}	
	/**
	 * Take the initial deck as input and shuffle the deck using the RandomOrderGenerator 
	 * (though need to modify a bit to make sure the random sequence is from 0 - 51)
	 * @param initialDeck
	 * @param numOfCards
	 * @return the shuflled deck
	 */
	public static Card[] shuflleDeck (Card[] initialDeck){
		Card[] shuffledDeck = new Card[52];
		int[] sequenceRandom = RandomOrderGenerator.getRandomOrder(52);
		for (int i = 0; i < initialDeck.length; i++) {
			shuffledDeck[i] = initialDeck[sequenceRandom[i]];
		}
		return shuffledDeck;	
	}
		
	/*
	public static void main(String[] args) {
		//Deck myCards = new Deck(numOfCards);
		//System.out.println(Deck.GetCards(numOfCards).length);
		for (int i = 0; i < 52; i++) {
			System.out.print(Deck.getDeck()[i].rankSuit + ',');
		
		}
		
		System.out.println();
		
		for (int i = 0; i < 52; i++) {
			
			System.out.print(Deck.shuflleDeck(Deck.getDeck())[i].rankSuit + ',');
	
		}
		System.out.println();
		System.out.println(Deck.shuflleDeck(Deck.getDeck()).length);
		//System.out.println(Arrays.toString(Deck.getDeck()));
		//System.out.println(Arrays.toString(Deck.shuflleDeck(Deck.getDeck())));
		
		System.out.println(Arrays.toString(RandomOrderGenerator.getRandomOrder(52)));	
	}
	*/
}
