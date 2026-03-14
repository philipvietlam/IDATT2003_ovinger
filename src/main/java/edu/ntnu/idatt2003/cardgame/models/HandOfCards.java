package edu.ntnu.idatt2003.cardgame.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class HandOfCards {

    private final List<PlayingCard> cards;


    public HandOfCards(List<PlayingCard> cards) {
        if (cards == null || cards.isEmpty()) {
            throw new IllegalArgumentException("A hand must contain at least one card.");
        }
        this.cards = new ArrayList<>(cards);
    }


    public List<PlayingCard> getCards() {
        return cards;
    }


    public int sumOfFaces() {
        return cards.stream()
                .mapToInt(PlayingCard::getFace)
                .sum();
    }

    public String heartsAsString() {
        String hearts = cards.stream()
                .filter(card -> card.getSuit() == 'H')
                .map(PlayingCard::getAsString)
                .collect(Collectors.joining(" "));

        return hearts.isBlank() ? "No Hearts" : hearts;
    }

    public boolean containsQueenOfSpades() {
        return cards.stream()
                .anyMatch(card -> card.getSuit() == 'S' && card.getFace() == 12);
    }

    public boolean hasFlush() {
        Map<Character, Long> suitCount = cards.stream()
                .collect(Collectors.groupingBy(PlayingCard::getSuit, Collectors.counting()));

        return suitCount.values().stream()
                .anyMatch(count -> count >= 5);
    }




    @Override
    public String toString() {
        return cards.stream()
                .map(PlayingCard::getAsString)
                .collect(Collectors.joining(" "));
    }
}
