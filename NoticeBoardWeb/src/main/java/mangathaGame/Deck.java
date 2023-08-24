package mangathaGame;

import java.util.*;
public class Deck {
    private List<Card> cards;
    public Deck() {
        cards = new ArrayList<Card>();
            for(int i=Card.MIN_RANK;i<=Card.MAX_RANK;i++) {
                for(int j=Card.MIN_SUIT;j<=Card.MAX_SUIT;j++) {
                    cards.add(new Card(i,j));
                    //cards.add("🂡");
                }
        }
    }
    public void shuffle(){
        Collections.shuffle(cards);
    }
    public Card removeFromTop() {
        if(!cards.isEmpty())
            return cards.remove(0);
        else {
            System.out.println("Invalid response");
            return null;
        }
    }
    public Card getFromTop() {
        if(!cards.isEmpty())
            return cards.get(0);
        else {
            System.out.println("Invalid response");
            return null;
        }
    }
    public void addToTop(Card card) {
        if(!cards.contains(card))
            cards.add(0, card);
        else
            System.out.println("Invalid response");
    }
    public boolean isEmpty() {
    	
    	if(cards.size() == 0)return true;
    	return false;
    }

    @Override
    public String toString() {
        return cards.toString();
    }
}
