import java.util.Arrays;
//The purpose of this class is to check the value of a hand. It does NOT compare two hands.
//The goal primarily and originally was to simply do boolean checks for the presence of a pair, three of a kind (trips)
//a straight or a flush. The poker class then gave a numerical value based on the presence of these conditions in a hand.

//However, after completing the spec i.e trips beats paris, flush beats straight etc. I found how often each hand has a pair.
//in the original program a pair of 9's had the same value as a pair of 2's. problem.
//So, I set up a secondary check in this class, the pairValue, tripsValue and straightValue methods give a value to the respective hands
//so the highest pair/three pair/ Straight now wins.
public class Checker {
    private int value; //value needed to be set for comparrison in poker class
    private int[] rank = new int[5];


    public Checker() { //constructor method to create checker object in Poker class
        this.value = value;
    }

    //method takes an array of integers, sorts it and compares each element to find matching ranks and therefore a pair
    public boolean isPair(int[] rank) {
        boolean isPair = false; //boolean initially set to false for no pair present
        int count = 1; //count integer set to one because you always have one of each card, you're looking for a second
        Arrays.sort(rank, 0, 4); //rank array is sorted

        for (int i = 0; i < rank.length - 1; i++) { //searching through the rank array
            if (rank[i] == rank[i + 1]) {
                count++;
            }
        }

        if (count == 2) { //set to equals two, if it's more than two you're into three of a kind territory
            isPair = true; //now set to true if the pair was found
        }
        return isPair;
    }
    //the following method gives a value based on the strength of a pair for the case of two pairs being compared
    public int pairValue(int[] rank) {
        int pairValue = 0; //pair value initially set to zero

        Arrays.sort(rank, 0, 4); //rank array sorted to get the pairs together

        for (int i = 0; i < rank.length - 1; i++) { //searching through the rank array
            if (rank[i] == rank[i + 1]) {
                pairValue = rank[i]; //here the pair value is set based on the actual rank value of the second card in the pair
            }
            //in the event of an ace in position 0 and position 1 I don't want to rank to be set at that level
            if ((rank[0] == 0) && (rank[1] == 0)) {
                pairValue = 13;
            }

        }
        return pairValue; //returns the value of the pair for comparison
    }

    //almost exactly the same as isPair method but looking for a higher count for the case of three cards of the same rank
    public boolean isTrips(int[] rank) {
        boolean isTrips = false;//boolean initially set to false for no three of a kind present
        int count = 1;
        Arrays.sort(rank, 0, 4);

        for (int i = 0; i < rank.length - 1; i++) {//searching through the rank array
            if (rank[i] == rank[i + 1]) {
                count++; //count incremented if identical card rank is in the next position
            }
        }
        if (count == 3) { //if three identical cards are found then the hand contains three of a kind
            isTrips = true;
        }
        return isTrips; //returns positive if three of a kind is found
    }
    //the following method sets up a value for a three of a kind in a hand in case of two hands containing three of a kind
    public int tripsValue(int[] rank) {
        int tripsValue = 0; //initial value of the three of a kind is set to zero

        Arrays.sort(rank, 0, 4);

        for (int i = 0; i < rank.length - 1; i++) {
            if (rank[i] == rank[i + 1]) {//searching through the rank array
                tripsValue = rank[i] + 20; //+20 to put it out of range of any pair value
            }
            //in the event of an ace in position 0 and position 1
            if ((rank[0] == 0) && (rank[1] == 0) && (rank[2] == 0)) {
                tripsValue = 33;
            }

        }
        return tripsValue; //returns the value of the three of a kind for comparison
    }

    //following method sorts the rank array into ascending order and then check if each element has -1 value of the element ahead
    //of it in the array
    public boolean isStraight(int[] rank) {
        boolean isStraight = false; //boolean value initially set to false for no straight present
        boolean ace = false; //the presence of an ace needs to be detected for the event of the highest straight
        int count = 0; //a count that increments if the element in front of another is numerically one place ahead

        Arrays.sort(rank, 0, 4); //sorting the array
        if (rank[0] == 0) { //if position zero in the array is value zero an ace is present
            ace = true;
        }

        for (int i = 0; i < rank.length - 1; i++) { //searching through the array
            if (rank[i] == (rank[i + 1] - 1)) { //comparing each element with the element ahead
                count++;
            }

        }
        if (count == 4) { //if the count is 4 a straight is present
            isStraight = true;
        }
        if ((rank[4] == 12) && (count == 3) && (ace)) { //in the event of an ace present rank[4] is a king and count is three, so we have a four card straight up to a king and an ace present so it's a stairght, ace high
            isStraight = true;

        }
        return isStraight;
    }
//method to give a value to a straight in the event that we need to compare two straights. It's based on the highest card
    public int straightValue(int[] rank) {

        int straightValue = 0;
        Arrays.sort(rank, 0, 4);
        //getting the value of the last card in the straight to compare in the case of straight vs straight, highest straight wins
        straightValue = rank[4] + 40;  //+40 to put it out of range of any three pair value
        boolean ace = false; //ace check need the same as the previous hand. At this stage we will know the hand contains a straight so this is just to check if its' ace high
        if (rank[0] == 0) {
            ace = true;
        }
        if ((ace) && (rank[4] == 12)) {
            straightValue = 13 + 40;//value is needed to be given because the actual rank of ace is zero
        }
        return straightValue;//returns the value of the straight for comparison
    }





//method for counting the number of any kind of suit in a hand.
    //takes in the suit int array that is set up in the poker class
        public boolean isFlush(int [] suit){
        boolean isFlush = false; //initially set to false
            int count = 0; //count initially set to ero, needs three for the presence of a flush

            Arrays.sort(suit, 0, 4); //sorts array to get the matching suits side by side
        for(int i = 0; i < suit.length - 1; i++ ) { //searches array
            if (suit[i] == suit[i + 1]) {
                count++; //increments count if an element in the array is the same as the the elememt in next position
            }
        }
            if (count == 3){ //is count is incremented to 3 there is a flush present
                isFlush = true;
            }
            return isFlush; //returns the presence of a flush (the value of a flush is set in the poker class
        }

        }



