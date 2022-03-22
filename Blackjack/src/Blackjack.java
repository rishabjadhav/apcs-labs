import java.util.*;

public class Blackjack
{
    public static ArrayList<Card> makeDeck()
    {
    	ArrayList<Card> newDeck = new ArrayList <Card>();

        for (int rank = 1; rank <= 13; rank = rank + 1)
        {
            for (int suit = 0; suit <= 3; suit = suit + 1)
            {
            	newDeck.add(new Card(rank, suit));
            }
        }
        
        return newDeck;
    }

    public static void swap(ArrayList<Card> cards, int i, int j)
    {
    	Card temp = cards.get(i);
    	cards.set(i, cards.get(j));
    	cards.set(j, temp);
    }

    public static void dealOneCard(ArrayList<Card> deck, ArrayList<Card> hand)
    {
    	hand.add(deck.get(0));
    	deck.remove(0);
    }

    public static int getScore(ArrayList<Card> hand)
    {
    	int sum = 0;
    	for (int i = 0; i < hand.size(); i++) {
    		if (hand.get(i).getRank() > 10) {
    			sum += 10;
    		}
    		else {
        		sum += hand.get(i).getRank();
    		}
    		
    	}
    	
        return sum;
    }
}