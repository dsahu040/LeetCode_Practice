package practice;

import java.util.ArrayList;
import java.util.List;

class Card {
	String rank;
	Suit suit;
	
	Card(int r, Suit s){
        if(r > 0 && r<= 13) {
        switch(r) {
            case (1) :
                rank = "A";
                break;
            case (11) :
                rank = "J";
                break;
            case(12):
                rank = "Q";
                break;
            case(13):
                rank = "K";
                break;
            default :
                rank = String.valueOf(r);
        }
		suit = s;
        }
        else {
            throw new IllegalArgumentException("input number is not a valid entry for card deck");
        }
    }
}

enum Suit {
	
	HEART("h"),
	SPADE("s"),
	CLUB("c"),
	DIAMOND("d");
	
	private final String text;
	
	Suit(final String text) {
        this.text = text;
    }
	
	@Override
    public String toString() {
        return text;
    }
}

public class Deck {
	
	public static List<Card> createDeck() {
		List<Card> deck = new ArrayList();
	    
	    for(int i = 1; i <=13; i++){
	        deck.add(new Card(i, Suit.HEART));
	        deck.add(new Card(i, Suit.SPADE));
	        deck.add(new Card(i, Suit.CLUB));
	        deck.add(new Card(i, Suit.DIAMOND));
	    }
	    return deck;
	}
	
	public static List<Card> sDeck(List<Card> cards) {
	    
	    List<Card> random = new ArrayList<>();
	    
	    while(random.size() < 52) {    
	    int i = (int)(Math.random()*100 % 52);
	    	if(!random.contains(cards.get(i))){
	    		random.add(cards.get(i));
	    	}
	    }
	    return random;
	}
	
	public static void main(String[] args) {
		
		List<Card> deck = sDeck(createDeck());
		
		for(Card card : deck) {
			System.out.println(card.rank + "  " + card.suit.toString());
		}
	}
}
