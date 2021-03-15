/*
    Ankit Das - 19070122023 - CS A1

    Program for generating a deck of cards
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.lang.Math;


class sortCard implements Comparator<Card>
{
    public int compare(Card C1, Card C2)
    {   
        Byte AS = C1.getSuit();
        Byte BS = C2.getSuit();
        
        Byte AR = C1.getRank();
        Byte BR = C2.getRank();
        
        if(AS != BS){
            return AS.compareTo(BS);
        }

        else{
            return AR.compareTo(BR);
        }
    }
}

class Card {
    private Byte Suit;
    private Byte Rank;

    Card(){
        this.Rank = 0;
        this.Suit = 0;
    }

    Card(Byte Suit, Byte Rank){
        this.Suit = Suit;
        this.Rank = Rank;
    }

    public Byte getSuit(){
        return this.Suit;
    }

    public Byte getRank(){
        return this.Rank;
    }

    public static Card getCard(Byte Suit, Byte Rank){
        return new Card(Suit, Rank);
    }

    public void printCard(){
        String Suit = "";
        String Rank = "";

        switch(this.Suit){
            case 1:
                Suit = "HEARTS";
                break;
            
            case 2:
                Suit = "DIAMONDS";
                break;
            
            case 3:
                Suit = "CLUBS";
                break;

            case 4:
                Suit = "SPADES";
                break;    
        }

        switch(this.Rank){
            case 1:
                Rank = "ACE";
                break; 

            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                Rank = this.Rank.toString();
                break; 

            case 11:
                Rank = "JACK";
                break;

            case 12:
                Rank = "QUEEN";
                break;
            
            case 13:
                Rank = "KING";
                break;
        }

        System.out.println("SUIT: " + Suit);
        System.out.println("RANK: " + Rank + "\n");
    }

    public static Boolean sameCard(Card C1, Card C2){
        if(C1.Rank == C2.Rank && C1.Suit == C2.Suit){
            return true;
        }

        else{
            return false;
        }
    }

    public static Card compareCard(Card C1, Card C2){
        if(C1.Suit > C2.Suit){
            return C1;
        }

        else if(C1.Suit == C2.Suit && C1.Rank > C2.Rank){
            return C1;
        }

        else if(sameCard(C1, C2)){
            System.out.println("CARDS ARE THE SAME!");

            return null;
        }

        else{
            return C2;
        }
    }

    public Boolean compareValue(Byte Rank, Byte Suit){
        if(this.Rank == Rank && this.Suit == Suit){
            return true;
        }

        return false;
    }
}


class Deck extends Card {
    private ArrayList<Card> DeckOfCards;
    private ArrayList<Card> ArrayOfCards;

    Deck(){
        this.DeckOfCards = new ArrayList<Card>();
        this.ArrayOfCards = new ArrayList<Card>();
    }

    public void createDeck(){
        for(Byte i = 1; i < 5; i++){
            for(Byte j = 1; j < 14; j++){
                this.DeckOfCards.add(getCard(i,j));
            }
        }
    }

    public void createArray(){    
        Scanner input = new Scanner(System.in);

        Byte Rank;
        Byte Suit;

        while(true){
            try{
                System.out.println("-------");
                System.out.println("ENTER SUIT:" );
                Suit = input.nextByte();
                while(Suit < 1 || Suit > 4){
                    System.out.println("INVALID SUIT! TRY AGAIN!");
                    System.out.println("ENTER SUIT: ");
                    Suit = input.nextByte();
                }

                System.out.println("ENTER RANK: ");
                Rank = input.nextByte();
                while(Rank < 1 || Rank > 13){
                    System.out.println("INVALID RANK! TRY AGAIN!");
                    System.out.println("ENTER RANK: ");
                    Rank = input.nextByte();
                }

                this.ArrayOfCards.add(getCard(Suit,Rank));
            } catch (InputMismatchException e){
                break;
            } 
        }

    }

    public Card compareCard(Integer P1, Integer P2){
        Card C1 = this.ArrayOfCards.get(P1);
        Card C2 = this.ArrayOfCards.get(P2);

        try{
            C1 = compareCard(C1, C2);
        } catch (NullPointerException e){
        }

        return C1;
    }

    public Boolean sameCard(Integer P1, Integer P2){
        Card C1 = this.ArrayOfCards.get(P1);
        Card C2 = this.ArrayOfCards.get(P2);

        return sameCard(C1, C2);
    }

    public void printDeck(){
        this.DeckOfCards.forEach((card) -> card.printCard());    
    }

    public void printArray(){
        this.ArrayOfCards.forEach((card) -> card.printCard());    
    }

    public int findCard(Byte Rank, Byte Suit){
        for(int i = 0; i < this.ArrayOfCards.size(); i++){
            Card card = this.ArrayOfCards.get(i);
            if(card.compareValue(Rank,Suit)){
                return i;
            }
        }
        
        return -1;
    }

    public void sortCards(){
        Collections.sort(this.ArrayOfCards, new sortCard());
    }

    public void printCard(Integer Position){
        this.ArrayOfCards.get(Position).printCard();
    }

    public Boolean noDeck(){
        if(DeckOfCards.isEmpty()){
            return true;
        }

        return false;
    }

    public Boolean noArray(){
        if(ArrayOfCards.isEmpty()){
            return true;
        }

        return false;
    }

    public ArrayList<Card> dealCards(){
        ArrayList<Card> dealtCards = new ArrayList<Card>();
        int randomPosition = 0;

        for(int i = 0; i < 5; i++){
            randomPosition = (int)(Math.random() * (52 - 0 + 1));
            dealtCards.add(this.DeckOfCards.get(randomPosition));
        }

        return dealtCards;
    }
}

public class Cards {
    public static void main(String[] args) {
        Deck deck = new Deck();
        Scanner input = new Scanner(System.in);
        
        Integer Choice = 0;
        Integer P1 = 0;
        Integer P2 = 0;
        Byte Rank = 0;
        Byte Suit = 0;
        Integer index = 0;

        while(true){
            System.out.println("-- MENU -- \n");
            System.out.println("1. CREATE DECK");
            System.out.println("2. CREATE ARRAY");
            System.out.println("3. COMPARE CARDS");
            System.out.println("4. IS SAME");
            System.out.println("5. FIND CARD");
            System.out.println("6. SORT ARRAY");
            System.out.println("7. PRINT DECK");
            System.out.println("8. PRINT ARRAY");
            System.out.println("9. PRINT CARD");
            System.out.println("10. DEAL CARDS");
            System.out.println("11. EXIT");
            
            System.out.println("\nENTER CHOICE: ");
            Choice = input.nextInt();
            System.out.println("\n");

            switch(Choice){ 
                case 1:
                    deck.createDeck();
                    System.out.println("DECK CREATED!");
                    break;
                
                case 2:
                    deck.createArray();
                    System.out.println("ARRAY CREATED!");
                    break;
                
                case 3:
                    System.out.println("\nENTER POSITION 1: ");
                    P1 = input.nextInt();

                    System.out.println("ENTER POSITION 2: ");
                    P2 = input.nextInt();

                    try{
                        System.out.println("GREATER CARD IS: ");
                        deck.compareCard(P1, P2).printCard();
                    } catch(NullPointerException e){
                        System.out.println("\nCARDS ARE THE SAME!\n");
                    } catch(IndexOutOfBoundsException e){
                        System.out.println("INVALID POSITIONS!");
                    }
                    break;
                
                case 4:
                    try{
                        System.out.println("\nENTER POSITION 1: ");
                        P1 = input.nextInt();

                        System.out.println("ENTER POSITION 2: ");
                        P2 = input.nextInt();

                        if(deck.sameCard(P1, P2)){
                            System.out.println("\nCARDS ARE THE SAME!\n");
                        }

                        else{
                            System.out.println("\nCARDS ARE NOT THE SAME!\n");
                        }

                    } catch(IndexOutOfBoundsException e){
                        System.out.println("\nERROR: INVALID POSITIONS!");
                    }
                    break;
                
                case 5:
                    if(deck.noArray()){
                        System.out.println("ERROR: EMPTY ARRAY!");
                        break;
                    }

                    System.out.println("\nENTER SUIT: ");
                    Suit = input.nextByte();

                    System.out.println("ENTER RANK: ");
                    Rank = input.nextByte();
                    
                    index = deck.findCard(Rank, Suit);
                    if(index != -1){
                        System.out.println("CARD FOUND AT POSITION " + index +" !");
                    }

                    else{
                        System.out.println("CARD NOT FOUND!");
                    }

                    break;
                     
                case 6:
                    deck.sortCards();
                    System.out.println("ARRAY SORTED!");
                    break;
                
                case 7:
                    if(deck.noDeck()){
                        System.out.println("\nERROR: EMPTY DECK!\n");
                        break;
                    }

                    deck.printDeck();
                    break;
                
                case 8:
                    if(deck.noArray()){
                        System.out.println("\nERROR: EMPTY ARRAY!\n");
                        break;
                    }

                    deck.printArray();
                    break;
                
                case 9:
                    System.out.println("ENTER POSITION TO DISPLAY: ");
                    P1 = input.nextInt();

                    try {
                        deck.printCard(P1);
                    } catch (IndexOutOfBoundsException e){
                        System.out.println("\nERROR: INVALID POSITION!");
                    }
                    break;

                case 10:
                    if(deck.noDeck()){
                        System.out.println("\nEMPTY DECK!\n");
                        break;
                    }

                    ArrayList<Card> dealtCards = deck.dealCards();
                    dealtCards.forEach((card) -> card.printCard()); 
                    break;

                case 11:
                    input.close();
                    return;
                
                default:
                    System.out.println("\nERROR: INVALID CHOICE! TRY AGAIN!");
                    break;
            }
        }
    }
}
