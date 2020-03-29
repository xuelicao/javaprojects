/**
 * This class creates Card objects which will be used in Deck, Board and for dealing a card
 * @author Xueli Cao
 *
 */
public class Card {
	String rankSuit;
	int value;
	
	public Card(String rankSuit, int value) {
		this.rankSuit = rankSuit;
		this.value = value;
	}
}

