package com.kaytinmatrangolaliamcreamer.cs483matrangolacreamerblackjack;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;



/**
 * This is the driver for the game
 *
 * @author Kaytin Matrangola
 * @author Liam Creamer
 * @version 1.0 09/30/2020
 */
public class MainActivity extends AppCompatActivity {
    Deck deck = new Deck();
    Card playerCard1 = new Card();
    Card playerCard2 = new Card();
    Card playerCard3 = new Card();
    Card playerCard4 = new Card();
    Card playerCard5 = new Card();


    Card dealerCard1 = new Card();
    Card dealerCard2 = new Card();
    Card dealerCard3 = new Card();
    Card dealerCard4 = new Card();
    Card dealerCard5 = new Card();


    Player player = new Player(0,0);
    Dealer dealer = new Dealer(0,0);

    Button hitButton;
    Button newGame;
    Button stopButton;

    TextView playerCardView1;
    TextView playerCardView2;
    TextView playerCardView3;
    TextView playerCardView4;
    TextView playerCardView5;
    TextView dealerCardView1;
    TextView dealerCardView2;
    TextView dealerCardView3;
    TextView dealerCardView4;
    TextView dealerCardView5;
    TextView playerScore;
    TextView dealerScore;

    /**
     * On startup of the app this sets up the game
     * deals out the first two cards to dealer and player
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        deck.newDeck();


        hitButton = (Button) findViewById(R.id.HitButton);
        newGame = (Button) findViewById(R.id.NewGameButton);
        stopButton = (Button) findViewById((R.id.StopButton));

        playerCardView1 = (TextView) findViewById(R.id.PlayerCard1);
        playerCardView2 = (TextView) findViewById(R.id.PlayerCard2);

        playerCardView3 = (TextView) findViewById(R.id.PlayerCard3);
        playerCardView3.setVisibility(View.INVISIBLE);

        playerCardView4 = (TextView) findViewById(R.id.PlayerCard4);
        playerCardView4.setVisibility(View.INVISIBLE);

        playerCardView5 = (TextView) findViewById(R.id.PlayerCard5);
        playerCardView5.setVisibility(View.INVISIBLE);

        playerScore = (TextView) findViewById(R.id.PlayerScore);

        dealerCardView1 = (TextView) findViewById(R.id.DealerCard1);
        dealerCardView2 = (TextView) findViewById(R.id.DealerCard2);

        dealerCardView3 = (TextView) findViewById(R.id.DealerCard3);
        dealerCardView3.setVisibility(View.INVISIBLE);

        dealerCardView4 = (TextView) findViewById(R.id.DealerCard4);
        dealerCardView4.setVisibility(View.INVISIBLE);

        dealerCardView5 = (TextView) findViewById(R.id.DealerCard5);
        dealerCardView5.setVisibility(View.INVISIBLE);

        dealerScore = (TextView) findViewById(R.id.DealerScore);



        playerCard1 = deck.pop();
        playerCard2 = deck.pop();

        // Show players cards rank
        playerCardView1.setText(playerCard1.rank());
        playerCardView2.setText(playerCard2.rank());


        player.addCard(playerCard1);
        player.addCard(playerCard2);


        dealerCard1 = deck.pop();
        dealerCard2 = deck.pop();

        player.updatePoints(playerCard1.pointValue());
        player.updatePoints(playerCard2.pointValue());

        playerScore.setText("Player Score: " + String.valueOf(player.points()));



        // Show dealers cards rank
        dealerCardView1.setText(dealerCard1.rank());
        dealerCardView2.setText(dealerCard2.rank());

        dealer.addCard(dealerCard1);
        dealer.addCard(dealerCard2);
        dealer.updatePoints(dealerCard1.pointValue());
        dealer.updatePoints(dealerCard2.pointValue());
        dealerScore.setText("Dealer Score: " + String.valueOf(dealer.points()));

        if(player.points() == 21 && dealer.points() == 21)
        {
            playerScore.setText("Player: TIE");
            dealerScore.setText("Dealer: TIE");
            hitButton.setVisibility(View.INVISIBLE);
            stopButton.setVisibility(View.INVISIBLE);
        }
        else if(player.points() == 21)
        {
            playerScore.setText("Player: WIN :)");
            dealerScore.setText("Dealer: LOSE :(");
            hitButton.setVisibility(View.INVISIBLE);
            stopButton.setVisibility(View.INVISIBLE);
        }
        else if(dealer.points() == 21)
        {
            playerScore.setText("Player: LOSE :(");
            dealerScore.setText("Dealer: WIN :)");
            hitButton.setVisibility(View.INVISIBLE);
            stopButton.setVisibility(View.INVISIBLE);
        }
    }


    /**
     * Draws another card for the player
     * updates the score of the player
     *
     * @param View
     *            The view
     */
    public void playerHit(View view)
    {
        if(player.hit() == false)
        {
            hitButton.setVisibility(View.INVISIBLE);
        }
        switch(player.numHits())
        {
            case(1):
                playerCard3 = deck.pop();
                player.addCard(playerCard3);
                playerCardView3.setVisibility(view.VISIBLE);
                playerCardView3.setText(playerCard3.rank());
                player.updatePoints(playerCard3.pointValue());
                playerScore.setText("Player Score: " +String.valueOf(player.points()));
                break;
            case(2):
                playerCard4 = deck.pop();
                player.addCard(playerCard4);
                playerCardView4.setVisibility(view.VISIBLE);
                playerCardView4.setText(playerCard4.rank());
                player.updatePoints(playerCard4.pointValue());
                playerScore.setText("Player Score: " + String.valueOf(player.points()));
                break;
            case(3):
                playerCard5 = deck.pop();
                player.addCard(playerCard5);
                playerCardView5.setVisibility(view.VISIBLE);
                playerCardView5.setText(playerCard5.rank());
                player.updatePoints(playerCard5.pointValue());
                playerScore.setText("Player Score: " + String.valueOf(player.points()));
                break;
        }
        if(player.points() == 21)
        {
            hitButton.setVisibility(View.INVISIBLE);

        }
        if(player.points() > 21)
        {
            hitButton.setVisibility(View.INVISIBLE);
            stopButton.setVisibility(view.INVISIBLE);
            playerScore.setText("Player: LOSE :(");
            dealerScore.setText("Dealer: WIN :)");

        }
    }

    /**
     * Initiates the dealers turn
     * Calculates their score and who won the game
     * @param View
     *            The view
     */
    public void dealerHit(View view)
    {
        hitButton.setVisibility(view.INVISIBLE);
        while(dealer.hit(player.points()) == true) {
            switch (dealer.numHits()) {
                case (1):
                    dealerCard3 = deck.pop();

                    dealer.addCard(dealerCard3);
                    dealerCardView3.setVisibility(view.VISIBLE);
                    dealerCardView3.setText(dealerCard3.rank());
                    dealer.updatePoints(dealerCard3.pointValue());
                    dealerScore.setText("Dealer Score: " +String.valueOf(dealer.points()));
                    break;
                case (2):
                    dealerCard4 = deck.pop();
                    dealer.addCard(dealerCard4);
                    dealerCardView4.setVisibility(view.VISIBLE);
                    dealerCardView4.setText(dealerCard4.rank());
                    dealer.updatePoints(dealerCard4.pointValue());
                    dealerScore.setText("Dealer Score: " + String.valueOf(dealer.points()));
                    break;
                case (3):
                    dealerCard5 = deck.pop();
                    dealer.addCard(dealerCard5);
                    dealerCardView5.setVisibility(view.VISIBLE);
                    dealerCardView5.setText(dealerCard5.rank());
                    dealer.updatePoints(dealerCard5.pointValue());
                    dealerScore.setText("Dealer Score: " + String.valueOf(dealer.points()));
                    break;
            }
        }
        if (player.points() == dealer.points()) {
            playerScore.setText("Player: TIE");
            dealerScore.setText("Dealer: TIE");
            hitButton.setVisibility(View.INVISIBLE);
            stopButton.setVisibility(View.INVISIBLE);
        } else if (player.points() > dealer.points()) {
            playerScore.setText("Player: WIN :)");
            dealerScore.setText("Dealer: LOSE :(");
            hitButton.setVisibility(View.INVISIBLE);
            stopButton.setVisibility(View.INVISIBLE);
        } else if (dealer.points() <= 21) {
            playerScore.setText("Player: LOSE :(");
            dealerScore.setText("Dealer: WIN :)");
            hitButton.setVisibility(View.INVISIBLE);
            stopButton.setVisibility(View.INVISIBLE);
        } else {
            playerScore.setText("Player: WIN :)");
            dealerScore.setText("Dealer: LOSE :(");
            hitButton.setVisibility(View.INVISIBLE);
            stopButton.setVisibility(View.INVISIBLE);
        }
    }


    /**
     * Shuffles the deck resets the state of the game
     * and deals new cards
     *
     * @param View
     *            The View
     */
    public void newGame(View view)
    {

        deck.newDeck();
        player.reset();
        dealer.reset();
        hitButton.setVisibility(view.VISIBLE);
        stopButton.setVisibility(view.VISIBLE);

        hitButton = (Button) findViewById(R.id.HitButton);
        newGame = (Button) findViewById(R.id.NewGameButton);
        stopButton = (Button) findViewById((R.id.StopButton));

        playerCardView1 = (TextView) findViewById(R.id.PlayerCard1);
        playerCardView2 = (TextView) findViewById(R.id.PlayerCard2);

        playerCardView3 = (TextView) findViewById(R.id.PlayerCard3);
        playerCardView3.setVisibility(View.INVISIBLE);

        playerCardView4 = (TextView) findViewById(R.id.PlayerCard4);
        playerCardView4.setVisibility(View.INVISIBLE);

        playerCardView5 = (TextView) findViewById(R.id.PlayerCard5);
        playerCardView5.setVisibility(View.INVISIBLE);

        playerScore = (TextView) findViewById(R.id.PlayerScore);

        dealerCardView1 = (TextView) findViewById(R.id.DealerCard1);
        dealerCardView2 = (TextView) findViewById(R.id.DealerCard2);

        dealerCardView3 = (TextView) findViewById(R.id.DealerCard3);
        dealerCardView3.setVisibility(View.INVISIBLE);

        dealerCardView4 = (TextView) findViewById(R.id.DealerCard4);
        dealerCardView4.setVisibility(View.INVISIBLE);

        dealerCardView5 = (TextView) findViewById(R.id.DealerCard5);
        dealerCardView5.setVisibility(View.INVISIBLE);

        dealerScore = (TextView) findViewById(R.id.DealerScore);



        playerCard1 = deck.pop();
        playerCard2 = deck.pop();

        // Show players cards rank
        playerCardView1.setText(playerCard1.rank());
        playerCardView2.setText(playerCard2.rank());


        player.addCard(playerCard1);
        player.addCard(playerCard2);


        dealerCard1 = deck.pop();
        dealerCard2 = deck.pop();

        player.updatePoints(playerCard1.pointValue());
        player.updatePoints(playerCard2.pointValue());

        playerScore.setText("Player Score: " +  String.valueOf(player.points()));



        // Show dealers cards rank
        dealerCardView1.setText(dealerCard1.rank());
        dealerCardView2.setText(dealerCard2.rank());

        dealer.addCard(dealerCard1);
        dealer.addCard(dealerCard2);
        dealer.updatePoints(dealerCard1.pointValue());
        dealer.updatePoints(dealerCard2.pointValue());
        dealerScore.setText("Dealer Score: " + String.valueOf(dealer.points()));

        if(player.points() == 21 && dealer.points() == 21)
        {
            playerScore.setText("Player: TIE");
            dealerScore.setText("Dealer: TIE");
            hitButton.setVisibility(View.INVISIBLE);
            stopButton.setVisibility(View.INVISIBLE);
        }
        else if(player.points() == 21)
        {
            playerScore.setText("Player: WIN :)");
            dealerScore.setText("Dealer: LOSE :(");
            hitButton.setVisibility(View.INVISIBLE);
            stopButton.setVisibility(View.INVISIBLE);
        }
        else if(dealer.points() == 21)
        {
            playerScore.setText("Player: LOSE :(");
            dealerScore.setText("Dealer: WIN :)");
            hitButton.setVisibility(View.INVISIBLE);
            stopButton.setVisibility(View.INVISIBLE);
        }

    }

}
