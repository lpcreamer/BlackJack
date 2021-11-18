package com.kaytinmatrangolaliamcreamer.cs483matrangolacreamerblackjack;

import java.util.HashMap;
import java.util.Map;

public class Card
{
    private int pointValue;
    private String rank;

    /**
     * Empty constructer for card
     */
    public Card()
    {

    }
    /**
     * Constructer for card
     * @param pointValue, integer for the number of points assigned to the card
     * @param  rank, String value of the rank of the card
     */
    public Card(int pointValue, String rank)
    {
        this.pointValue = pointValue;
        this.rank = rank;
    }

    /**
     * Getter for pointValue
     * @return pointValue, integer for the number of points assigned to the card
     */
    public int pointValue()
    {
        return pointValue;
    }

    /**
     * Setter for point value
     * @param pointValue, integer for the number of points assigned to the card
     */
    public void pointValue(int pointValue)
    {
        this.pointValue = pointValue;
    }

    /**
     *  Getter for rank
     * @return rank, String value of the rank of the card
     */
    public String rank()
    {
        return rank;
    }

}
