package edu.ntnu.idatt2003.cardgame.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DeckOfCards {
    private final List<PlayingCard> deck;
    private final char[]suits = {'S','H','D','C'};
    private final Random random = new Random();

    public DeckOfCards() {
        deck = new ArrayList<>();

        for(char suit : suits) {
            for (int face = 1; face <= 13; face++) {
                deck.add(new PlayingCard(suit, face));
            }
        }
    }

    public List<PlayingCard> getDeck() {
        return deck;
    }


    public HandOfCards dealHand(int n) {
        if (n < 1 || n > deck.size()) {
            throw new IllegalArgumentException("Number of cards must be between 1 and 52.");
        }

        List<PlayingCard> availableCards = new ArrayList<>(deck);
        List<PlayingCard> handCards = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int randomIndex = random.nextInt(availableCards.size());
            PlayingCard drawnCard = availableCards.remove(randomIndex);
            handCards.add(drawnCard);
        }

        return new HandOfCards(handCards);
    }
}


