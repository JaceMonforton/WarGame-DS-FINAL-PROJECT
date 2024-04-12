package FinalProject;
/*
 * Author: Jace Monforton, Marlone Nkamtchou
 * Assignment: Data Structures Final Assignment
 */

import java.util.*;

public class WarGame {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int countPlayer2 = 0; // Counter for player 2 wins
        int countPlayer1 = 0; // Counter for player 1 wins

        // Prompt for the number of cards for player 1
        System.out.println("Enter the number of cards for player 1:");
        int size1 = s.nextInt();
        s.nextLine();
        String[] player1Cards = new String[size1];

        // Prompt for player 1's cards
        if (size1 != 0) {
            System.out.println("Enter Player 1 Cards:");
            for (int i = 0; i < size1; i++) {
                player1Cards[i] = s.next();
            }
        }

        // Prompt for the number of cards for player 2
        System.out.println("Enter the number of cards for player 2:");
        int size2 = s.nextInt();
        s.nextLine();
        String[] player2Cards = new String[size2];

        // Prompt for player 2's cards
        System.out.println("Enter Player 2 Cards:");
        if (size2 != 0) {
            for (int i = 0; i < size2; i++) {
                player2Cards[i] = s.next();
            }
        }

        // Create decks for players
        Queue<String> player1Deck = new LinkedList<>(Arrays.asList(player1Cards));
        Queue<String> player2Deck = new LinkedList<>(Arrays.asList(player2Cards));
        Queue<String> pot = new LinkedList<>(); // Pot of cards

        // Game loop
        while (!player1Deck.isEmpty() && !player2Deck.isEmpty()) { //Runs until one player runs out of cards.
            String player1Card = player1Deck.poll(); // Player 1 draws a card
            String player2Card = player2Deck.poll(); // Player 2 draws a card

            // Display cards played by players
            System.out.println("Player 1: " + player1Card);
            System.out.println("Player 2: " + player2Card);

            // Compare cards played by players
            int comparison = compareCards(player1Card, player2Card);

            if (comparison > 0) { // Player 1 wins
                System.out.println("Player 1 wins the battle!");
                // Add cards to player 1's deck
                player1Deck.add(player1Card);
                player1Deck.add(player2Card);
                countPlayer1++;
            } else if (comparison < 0) { // Player 2 wins
                System.out.println("Player 2 wins the battle!");
                // Add cards to player 2's deck
                player2Deck.add(player1Card);
                player2Deck.add(player2Card);
                countPlayer2++;
            } else { // War situation
                System.out.println("War!");

                // Add cards to the pot for war
                pot.add(player1Card);
                pot.add(player2Card);
                for (int i = 0; i < 3; i++) {
                    if (!player1Deck.isEmpty())
                        pot.add(player1Deck.poll()); // Transfer cards to the pot from player 1's deck
                    if (!player2Deck.isEmpty())
                        pot.add(player2Deck.poll()); // Transfer cards to the pot from player 2's deck
                }
                    /*
                    * The pot serves as a temporary storage for the cards that will be won by the winner of the war.
                    * this section of the code handles the mechanics of a "war" in the game.
                    * It ensures that when players draw equal cards, additional cards are added to a pot,
                    * and then three more cards from each player are added to the pot to determine the winner of the war.
                    */
                // Check if either player has run out of cards during war
                if (player1Deck.isEmpty() || player2Deck.isEmpty()) {
                    System.out.println("Game over - both players ran out of cards.");
                    break;
                }
            }
        }

        // Determine the winner of the game
        if (player1Deck.isEmpty() && player2Deck.isEmpty()) { //Both 1 & 2 are out of cards, TIE, no one wins.
            System.out.println("Both players ran out of cards. It's a tie!");
        } else if (player1Deck.isEmpty()) { //player 1 is out of cards, player 2 wins.
            System.out.println("Player 2 Won: " + countPlayer2 + " Times");
        } else { //player 2 is out of cards, player 1 wins.
            System.out.println("Player 1 Won: " + countPlayer1 + " Times");
        }
    }

    // Method to compare card values
    private static int compareCards(String card1, String card2) {
        String values = "23456789TJQKA"; // Assigns numerical values to cards
        int value1 = values.indexOf(card1.charAt(0)); // Retrieves numerical value of the first character of card1
        int value2 = values.indexOf(card2.charAt(0)); // Retrieves numerical value of the first character of card2
        return Integer.compare(value1, value2); // Compares the numerical values of the cards
    }
}
