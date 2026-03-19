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
    void dealHandRemovesCardsFromDeck() {
        DeckOfCards deck = new DeckOfCards();

        deck.dealHand(5);

        assertEquals(47, deck.getDeck().size());
    }

    @Test
    void dealHandReturnsAllRemainingCardsWhen52AreRequested() {
        DeckOfCards deck = new DeckOfCards();

        HandOfCards hand = deck.dealHand(52);

        assertEquals(52, hand.getCards().size());
        assertEquals(52, new HashSet<>(hand.getCards()).size());
        assertEquals(0, deck.getDeck().size());
    }

    @Test
    void multipleHandsDoNotContainDuplicateCardsFromSameDeck() {
        DeckOfCards deck = new DeckOfCards();

        HandOfCards firstHand = deck.dealHand(5);
        HandOfCards secondHand = deck.dealHand(5);

        Set<PlayingCard> allDrawnCards = new HashSet<>();
        allDrawnCards.addAll(firstHand.getCards());
        allDrawnCards.addAll(secondHand.getCards());

        assertEquals(10, allDrawnCards.size());
        assertEquals(42, deck.getDeck().size());
    }

    @Test
    void resetDeckRestoresDeckTo52UniqueCards() {
        DeckOfCards deck = new DeckOfCards();

        deck.dealHand(5);
        deck.dealHand(10);
        deck.resetDeck();

        assertEquals(52, deck.getDeck().size());
        assertEquals(52, new HashSet<>(deck.getDeck()).size());
    }

    @Test
    void remainingCardsReturnsCorrectValueAfterDealAndReset() {
        DeckOfCards deck = new DeckOfCards();

        assertEquals(52, deck.remainingCards());

        deck.dealHand(5);
        assertEquals(47, deck.remainingCards());

        deck.resetDeck();
        assertEquals(52, deck.remainingCards());
    }

    @Test
    void dealHandThrowsExceptionWhenNIsTooSmall() {
        DeckOfCards deck = new DeckOfCards();

        assertThrows(IllegalArgumentException.class, () -> deck.dealHand(0));
    }

    @Test
    void dealHandThrowsExceptionWhenMoreCardsAreRequestedThanRemain() {
        DeckOfCards deck = new DeckOfCards();

        deck.dealHand(50);

        assertThrows(IllegalArgumentException.class, () -> deck.dealHand(3));
    }

    @Test
    void dealHandThrowsExceptionWhenNIsTooLargeInitially() {
        DeckOfCards deck = new DeckOfCards();

        assertThrows(IllegalArgumentException.class, () -> deck.dealHand(53));
    }
}