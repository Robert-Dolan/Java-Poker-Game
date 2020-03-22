import java.util.Arrays;
import javax.swing.*;
import java.util.Random;

//poker class is a game that sets up a deck of 52 cards and deals two hands
//it uses the classes "Card" "Deck" and "Checker" to achieve this
//it then compares the value of each hand and declares a winner
//it interacts with the user using JOptionPane
public class Poker {


    public static void main(String[] args) {


        Deck deck1 = new Deck(); //initialising Deck object
        Checker check = new Checker();//initialising Checker object
        Random randnum;
        randnum = new Random(); //random number needed for taking random cards from the deck
        int[] hand1rank = new int[5]; //initialising an integer array for the first hand that will store the rank of each card for the checker class
        int[] hand1suit = new int[5]; //initialising an integer array for the first hand that will store the suit value of each card for the checker class
        int[] hand2suit = new int[5]; //initialising an integer array for the second hand that will store the rank of each card for the checker class
        int[] hand2rank = new int[5]; //initialising an integer array for the second hand that will store the suit  of each card for the checker class
        Card handOne[] = new Card[5]; //initialising a card object array for the first hand that will store the card objects for printing
        Card handTwo[] = new Card[5];//initialising a card object array for the second hand that will store the card objects for printing


        //first message for the players
        if (JOptionPane.showConfirmDialog(null, "Would you like to play a two player hand of Poker?", "Poker",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

            //setting up a hand:
            //the following do while loop takes a random card from the deck array of cards
            //once the card is taken out and it's rank and suit is recorded it is set to null
            //this is to prevent the same card from being used more than once
            int n = 0; //integer value needed to record the amount of cards
            do {
                {
                    int random = randnum.nextInt(52);
                    if (!(deck1.getDeck()[random] == null)) { //checks if the card has been used
                        handOne[n] = deck1.getDeck()[random]; //card recorded into hand for print up
                        hand1rank[n] = deck1.value(random); //rank recorded
                        hand1suit[n] = deck1.suitValue(random); //suit recorded
                        n++; //amount of cards in the hand in incremented
                        deck1.getDeck()[random] = null; //sets it to null
                    }
                }
            }
            while (n != 5); //when int n reaches 5 the hand is already full



            //exact same do while loop used to populate the second hand
            n = 0;
            do {
                {
                    int random = randnum.nextInt(52);
                    if (!(deck1.getDeck()[random] == null)) {
                        handTwo[n] = deck1.getDeck()[random];
                        hand2rank[n] = deck1.value(random);
                        hand2suit[n] = deck1.suitValue(random);
                        n++;
                        deck1.getDeck()[random] = null;
                    }
                }
            }
            while (n != 5);



            //printing up the results of the deal
            JOptionPane.showMessageDialog(null, "Player one:\n" + handOne[0].toString()+ "\n"+ handOne[1].toString()+ "\n"+ handOne[2].toString()+ "\n" +handOne[3].toString()+  "\n"+ handOne[4].toString()+ "\n" + "\n" + "Player Two:\n" + handTwo[0].toString()+ "\n"+ handTwo[1].toString()+ "\n"+ handTwo[2].toString()+ "\n" +handTwo[3].toString()+  "\n"+ handTwo[4].toString()+ "\n");


            //the following sequence of if/else if statements are set up in such a way that the highest value (flush) is checked first and if not present
            //then the program does subsequent checks

            //Value of hands comparison, Flush = 60 (highest), Straight = 3 + value of straight in checker class, 3 of a kind = 2 value of straight in checker class, pair = 1 value of straight in checker class
            int valueOfHandOne = 0;

            if (check.isFlush(hand1suit)){ //checker class checking for the presence of a flush
                valueOfHandOne = 60;
                JOptionPane.showMessageDialog(null, "Player one got a Flush!");
            }
            else if (check.isStraight(hand1rank)){ //checking for straight
                valueOfHandOne = 3 + check.straightValue(hand1rank); //if there is a straight we need the value of the straight in case hand No.2 also has a straight
                JOptionPane.showMessageDialog(null, "Player one got a Straight!");
            }
            else if (check.isTrips(hand1rank)){ //checking for three of a kind
                valueOfHandOne = 2 + check.tripsValue(hand1rank); //if there is three of a kind we need value for comparison in the event of hand 2 having three of a kind
                JOptionPane.showMessageDialog(null, "Player one got Three of a Kind!");
            }
            else if (check.isPair(hand1rank)){ //checking for a pair
                valueOfHandOne = 1 + check.pairValue(hand1rank); //value of pair check
                JOptionPane.showMessageDialog(null, "Player one got a pair!");
            }

            //checking the value of hand two
            //same process as previous hand
            int valueOfHandTwo = 0;

            if (check.isFlush(hand2suit)){
                valueOfHandTwo = 60;
                JOptionPane.showMessageDialog(null, "Player two got a Flush!");
            }
            else if (check.isStraight(hand2rank)){
                valueOfHandTwo = 3 + check.straightValue(hand2rank);
                JOptionPane.showMessageDialog(null, "Player two got a Straight!");
            }
            else if (check.isTrips(hand2rank)){
                valueOfHandTwo = 2 + check.tripsValue(hand2rank);
                JOptionPane.showMessageDialog(null, "Player two got Three of a Kind!");
            }
            else if (check.isPair(hand2rank)){
                valueOfHandTwo = 1 + check.pairValue(hand2rank);
                JOptionPane.showMessageDialog(null, "Player two got a pair!");
            }

            //The actual comparison of both hands
            //based simply on the numerical value of each hand set up previously
            if (valueOfHandOne > valueOfHandTwo) {
                JOptionPane.showMessageDialog(null, "Player one wins!");
            }
            else if (valueOfHandTwo > valueOfHandOne){
                JOptionPane.showMessageDialog(null, "Player two wins!");
            }

            //in the case of both hands being equal I want the hand with the highest value card "high card" to win

            //this was just an extra piece not required by the spec but I wanted to try and get it working.

            //What I ended up with was in the case of both hands being equal in terms of "straight" or "flush" or nothing at all etc they were
            //next judged by the highest card in their hand.



            if (valueOfHandOne == valueOfHandTwo){ //both hands are of equal value
                Arrays.sort(hand1rank, 0, 4); //sorting the hands
                Arrays.sort(hand2rank, 0, 4);

                //in the event of either hand having an ace
                boolean aceInHandOne = false;
                boolean aceInHandTwo = false;
                if (hand1rank[0] ==0){
                    aceInHandOne = true;
                }
                if (hand1rank[0] ==0){
                    aceInHandTwo = true;
                }
                if ((aceInHandOne) && (aceInHandTwo) ) {
                    JOptionPane.showMessageDialog(null, "Both players have Ace High! Draw!");
                }
                else if (aceInHandOne){
                    JOptionPane.showMessageDialog(null, "Player one wins with Ace High");
                }
                else if (aceInHandTwo){
                    JOptionPane.showMessageDialog(null, "Player two Wins with Ace High");
                }
                else if (hand1rank[4] > hand2rank[4]){ //because the hands are sorted by ranks, the highest card in the last position wins
                    JOptionPane.showMessageDialog(null, "Player one wins with the highest card!");
                }
                else {
                    JOptionPane.showMessageDialog(null, "Player two wins with the highest card!");
                }
            }

        }
    }
}

