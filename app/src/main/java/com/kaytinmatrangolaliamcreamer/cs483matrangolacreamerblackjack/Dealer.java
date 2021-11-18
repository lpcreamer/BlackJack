package com.kaytinmatrangolaliamcreamer.cs483matrangolacreamerblackjack;

import android.util.Log;

import java.util.ArrayList;

public class Dealer extends Player
{

    /**
     * Constructor for Dealer
     * @param points, number of points the dealer has
     * @param numHits, number of times the dealer has hit
     */
    Dealer(int points, int numHits)
    {
        super.points = points;
        super.numHits = numHits;
    }

    /**
     * executes a hit for the dealer
     * @param playerScore, number of points the player has
     * @return true if the dealer will hit, and false otherwise
     */
    public boolean hit(int playerScore)
    {
        //hit if still have hits left and losing
        if(numHits <= 3 && points < playerScore)
        {
            numHits++;
        }
        if(numHits <= 3 && points < playerScore)
        {
            return true;
        }
        else
        {
            return false;
        }

    }
}
