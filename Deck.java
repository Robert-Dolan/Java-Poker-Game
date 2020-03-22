
import java.util.Random;

//the purpose of this class is to create an array of 52 objects of class "Card"
//The card objects when initialised will have no rank or suit so the deck method will also give each new object those attributes

public class Deck {

    private Card deck[]; //object array, a virtual deck that will be populated with 52 card objects
    private Card hand[]; //object array, populated with cards from the deck array to create a hand
    private int NumberInDeck = 52; //integer value to set the number of card objects that will be filled into the deck array
    private Random randnum; //

    public Deck() { //constructor method that will be called in the poker class
        String[] rank = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "Queen", "King"}; //array of rank values that will be given to card object
        String[] suit = {"\u2664", "\u2661", "\u2663", "\u2662"}; //originally these values were heart, spade, diamond and club, but the spec stated to print out the suits in a nice format so I went with unicode, simple change at the end of the project

        deck = new Card[NumberInDeck];//initialises the deck
        randnum = new Random(); //initialises the random object which will be needed later in the classes

        //the following for loop populates the deck of card objects
               for (int count = 0; count < deck.length; count++) {
            deck[count] =
                    new Card(rank[count % 13], suit[count / 13]);
        }


    }


    //once the deck is filled the following method can be used to call the deck in poker class
    public Card[] getDeck() {
        return deck;
    }


    //the following method was created to fill an int array of the value of a cark based on rank
    public int value(int i) {
        String[] rank = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "Queen", "King"}; //array needed to compare the string rank with and assign an integer value of its' position
        int value = 0; //value of the rank initially set to zero

        for (int n = 0; n < 13; n++) { //for loop to iterate through the rank array to find the value of the cards rank
            if (getDeck()[i].getRank() == rank[n]) {
                value = n; //value is then set to that cards position so "2" would be value 1, "3" would be 2 etc.

            }
        }
        return value; //return integer value of rank
    }

    //similar to previous method, the suitvalue was needed specifically to deal with the possibility of a flush, an integer value was
    //needed for quick comparison to check is 4 of the same suit were present in a hand
    //the following method gives that value
    public int suitValue(int i) {
        String[] suit = {"\u2664", "\u2661", "\u2663", "\u2662"}; //like above, these values were switched to unicode at the end of the project
        int value = 0; //value of the suit initially set to zero
        for (int n = 0; n < 4; n++) { //iterating through the suit String array looking for the suit value for each card
            if (getDeck()[i].getSuit() == suit[n]) {
                value = n; //when the value is found it is set

            }
        }
        return value; //returns value of suit for comnparison

    }
}

