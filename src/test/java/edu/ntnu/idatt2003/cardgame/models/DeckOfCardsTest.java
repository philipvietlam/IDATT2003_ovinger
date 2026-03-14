package edu.ntnu.idatt2003.cardgame.models;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

class DeckOfCardsTest {

    @Test
    void constructorCreatesDeckWith52Cards() {
        DeckOfCards deck = new DeckOfCards();

        assertEquals(52, deck.getDeck().size());
    }

    @Test
    void deckContainsOnlyUniqueCards() {
        DeckOfCards deck = new DeckOfCards();

        Set<PlayingCard> uniqueCards = new HashSet<>(deck.getDeck());

        assertEquals(52, uniqueCards.size());
    }

    @Test
    void deckContainsExpectedCards() {
        DeckOfCards deck = new DeckOfCards();

        assertTrue(deck.getDeck().contains(new PlayingCard('S', 1)));
        assertTrue(deck.getDeck().contains(new PlayingCard('H', 13)));
        assertTrue(deck.getDeck().contains(new PlayingCard('D', 7)));
        assertTrue(deck.getDeck().contains(new PlayingCard('C', 12)));
    }

    @Test
    void dealHandReturnsCorrectNumberOfCards() {
        DeckOfCards deck = new DeckOfCards();

        HandOfCards hand = deck.dealHand(5);

        assertEquals(5, hand.getCards().size());
    }

    @Test
    void dealHandReturnsUniqueCards() {
        DeckOfCards deck = new DeckOfCards();

        HandOfCards hand = deck.dealHand(5);
        Set<PlayingCard> uniqueCards = new HashSet<>(hand.getCards());

        assertEquals(5, uniqueCards.size());
    }

    @Test
    void dealHandReturnsAll52CardsWhenRequested() {
        DeckOfCards deck = new DeckOfCards();

        HandOfCards hand = deck.dealHand(52);

        assertEquals(52, hand.getCards().size());
        assertEquals(52, new HashSet<>(hand.getCards()).size());
    }

    @Test
    void dealHandThrowsExceptionWhenNIsTooSmall() {
        DeckOfCards deck = new DeckOfCards();

        assertThrows(IllegalArgumentException.class, () -> deck.dealHand(0));
    }

    @Test
    void dealHandThrowsExceptionWhenNIsTooLarge() {
        DeckOfCards deck = new DeckOfCards();

        assertThrows(IllegalArgumentException.class, () -> deck.dealHand(53));
    }
}