package com.kaytinmatrangolaliamcreamer.cs483matrangolacreamerblackjack;

import android.util.Log;

import java.util.ArrayList;

public class Player
{
    private ArrayList<Card> hand = new ArrayList<Card>();
    protected int points;
    protected int numHits;

    /**
     * Empty constructor for Player
     */
    Player()
    {

    }

    /**
     * Constructor for Player
     * @param points, number of points the player has
     * @param numHits, number of times the player has hit
     */
    Player( int points, int numHits)
    {
        this.points = points;
        this.numHits = numHits;
    }

    /**
     * Getter for hand
     * @return hand, an array of Cards that the player has
     */
    public ArrayList<Card> playersHand()
    {
        return hand;
    }

    /**
     * Adds a card to the players deck
     * @param card, Card to add
     */
    public void addCard(Card card){
        hand.add(card);
    }

    /**
     * Getter for points
     * @return points, number of points the player has,
     */
    public int points()
    {
        return points;
    }

    /**
     * Resets the players hand to empty, number of points to 0, and number of hits to 0
     */
    public void reset()
    {
        numHits = 0;
        points = 0;
        playersHand().removeAll(playersHand());
    }

    /**
     * Updates the number of points the player has
     * @param point, additional point value of new Card
     */
    public void updatePoints(int point){
        // add to current player points
        points += point;
        //check if it is a bust
        if(points > 21 )
        {
            for(int i = 0; i < hand.size(); i++)
            {
                //if there is an ace with a point value of 11 switch the point value to 1
                if(hand.get(i).pointValue() == 11)
                {
                    hand.get(i).pointValue(1);
                    updatePoints(-10);
                   break;
                }
            }

        }
    }

    /**
     * Getter for number of hits
     * @return numHits, the number of times the player has hit
     */
    public int numHits()
    {
        return numHits;
    }

    /**
     * Evaluates if the player can hit
     * @return true if the player can hit and false otherwise
     */
    public boolean hit()
    {
        if(numHits < 3 )
        {
            numHits++;
        }
        if(numHits < 3 )
        {
            return true;
        }
        else
        {
            return false;
        }
    }

}
