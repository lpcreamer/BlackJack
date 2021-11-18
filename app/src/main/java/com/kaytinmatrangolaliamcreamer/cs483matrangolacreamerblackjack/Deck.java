package com.kaytinmatrangolaliamcreamer.cs483matrangolacreamerblackjack;
import java.util.*;

public class Deck
{
    static int NUMSTARTING = 52;
    private ArrayList<Card> deckOfCards = new ArrayList<Card>();

    /**
     * Constructor for deck
     */
    Deck()
    {
    }

    /**
     * Pops the top card from the deck
     * @return the Card on top of the deck
     */
    public Card pop()
    {
        Card top =  deckOfCards.get(0);
        deckOfCards.remove(0);
        return top;

    }

    /**
     * Shuffles the deck
     * @param n number of cards in deck to shuffle
     */
    public void shuffleDeck(int n)
    {
        int i, j, k;

        for ( k = 0; k < n; k++ )
        {
            //pick 2 random cards in the deck
            i = (int) ( NUMSTARTING * Math.random() );
            j = (int) ( NUMSTARTING * Math.random() );

            //swap locations
            Card temp = deckOfCards.get(i);
            deckOfCards.set(i, deckOfCards.get(j));
            deckOfCards.set(j, temp);
        }
    }

    /**
     * Make a new deck
     */
   public void newDeck()
   {
       //Instansiate cardst that will go in the deck
       Card ace1 = new Card(11, "A");
       Card ace2 = new Card(11, "A");
       Card ace3 = new Card(11, "A");
       Card ace4 = new Card(11, "A");
       Card two1 = new Card(2, "2");
       Card two2 = new Card(2, "2");
       Card two3 = new Card(2, "2");
       Card two4 = new Card(2, "2");
       Card three1 = new Card(3, "3");
       Card three2 = new Card(3, "3");
       Card three3 = new Card(3, "3");
       Card three4 = new Card(3, "3");
       Card four1 = new Card(4, "4");
       Card four2 = new Card(4, "4");
       Card four3 = new Card(4, "4");
       Card four4 = new Card(4, "4");
       Card five1 = new Card(5, "5");
       Card five2 = new Card(5, "5");
       Card five3 = new Card(5, "5");
       Card five4 = new Card(5, "5");
       Card six1 = new Card(6, "6");
       Card six2 = new Card(6, "6");
       Card six3 = new Card(6, "6");
       Card six4 = new Card(6, "6");
       Card seven1 = new Card(7, "7");
       Card seven2 = new Card(7, "7");
       Card seven3 = new Card(7, "7");
       Card seven4 = new Card(7, "7");
       Card eight1 = new Card(8, "8");
       Card eight2 = new Card(8, "8");
       Card eight3 = new Card(8, "8");
       Card eight4 = new Card(8, "8");
       Card nine1 = new Card(9, "9");
       Card nine2 = new Card(9, "9");
       Card nine3 = new Card(9, "9");
       Card nine4 = new Card(9, "9");
       Card ten1 = new Card(10, "10");
       Card ten2 = new Card(10, "10");
       Card ten3 = new Card(10, "10");
       Card ten4 = new Card(10, "10");
       Card jack1 = new Card(10, "J");
       Card jack2 = new Card(10, "J");
       Card jack3 = new Card(10, "J");
       Card jack4 = new Card(10, "J");
       Card queen1 = new Card(10, "Q");
       Card queen2 = new Card(10, "Q");
       Card queen3 = new Card(10, "Q");
       Card queen4 = new Card(10, "Q");
       Card king1 = new Card(10, "K");
       Card king2 = new Card(10, "K");
       Card king3 = new Card(10, "K");
       Card king4 = new Card(10, "K");

       //add the cards to the deck
       deckOfCards.add(ace1);
       deckOfCards.add(ace2);
       deckOfCards.add(ace3);
       deckOfCards.add(ace4);
       deckOfCards.add(two1);
       deckOfCards.add(two2);
       deckOfCards.add(two3);
       deckOfCards.add(two4);
       deckOfCards.add(three1);
       deckOfCards.add(three2);
       deckOfCards.add(three3);
       deckOfCards.add(three4);
       deckOfCards.add(four1);
       deckOfCards.add(four2);
       deckOfCards.add(four3);
       deckOfCards.add(four4);
       deckOfCards.add(five1);
       deckOfCards.add(five2);
       deckOfCards.add(five3);
       deckOfCards.add(five4);
       deckOfCards.add(six1);
       deckOfCards.add(six2);
       deckOfCards.add(six3);
       deckOfCards.add(six4);
       deckOfCards.add(seven1);
       deckOfCards.add(seven2);
       deckOfCards.add(seven3);
       deckOfCards.add(seven4);
       deckOfCards.add(eight1);
       deckOfCards.add(eight2);
       deckOfCards.add(eight3);
       deckOfCards.add(eight4);
       deckOfCards.add(nine1);
       deckOfCards.add(nine2);
       deckOfCards.add(nine3);
       deckOfCards.add(nine4);
       deckOfCards.add(ten1);
       deckOfCards.add(ten2);
       deckOfCards.add(ten3);
       deckOfCards.add(ten4);
       deckOfCards.add(jack1);
       deckOfCards.add(jack2);
       deckOfCards.add(jack3);
       deckOfCards.add(jack4);
       deckOfCards.add(queen1);
       deckOfCards.add(queen2);
       deckOfCards.add(queen3);
       deckOfCards.add(queen4);
       deckOfCards.add(king1);
       deckOfCards.add(king2);
       deckOfCards.add(king3);
       deckOfCards.add(king4);

       //shuffle the deck
       shuffleDeck(NUMSTARTING);

   }


}
