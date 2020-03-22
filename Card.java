//The purpose of this class is to create an object called "card"
// The card object will have two attributes, a rank from ace to king and a suit, hearts, spades, clubs and diamonds

public class Card {
    private String rank; //variable that will hold the value of whatever rank is given to the card in the "Deck" class
    private String suit; //variable that will hold the value of whatever suit is given to the card in the "Deck" class

    //constructor method that creates an object of class "card"
    public Card(String cardRank, String cardSuit){
        rank = cardRank;
        suit = cardSuit;
    }
    //Once the attributes have been given to the object "Card" this String method returns the card
    public String toString(){
        return rank + " " + suit;
    }
    //this was a method that was added later in the program when I needed to seperate the rank and suit
    //the purpose behind this was the need to ascride an integer value to both the suit and rank for the purpose
    //of comparing both the cards to each other and following that the value of hands to compare to a second hand
    public String getRank(){
        return rank;
    }

    //see previous method
    public String getSuit() {
        return suit;
    }

}


