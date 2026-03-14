package edu.ntnu.idatt2003.cardgame.models;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class HandOfCardsTest {

    @Test
    void constructorStoresCards() {
        List<PlayingCard> cards = List.of(
                new PlayingCard('H', 1),
                new PlayingCard('S', 12)
        );

        HandOfCards hand = new HandOfCards(cards);

        assertEquals(2, hand.getCards().size());
        assertEquals(cards, hand.getCards());
    }

    @Test
    void constructorThrowsExceptionWhenCardsIsNull() {
        assertThrows(IllegalArgumentException.class, () -> new HandOfCards(null));
    }

    @Test
    void constructorThrowsExceptionWhenCardsIsEmpty() {
        assertThrows(IllegalArgumentException.class, () -> new HandOfCards(List.of()));
    }

    @Test
    void sumOfFacesReturnsCorrectSum() {
        HandOfCards hand = new HandOfCards(List.of(
                new PlayingCard('H', 4),
                new PlayingCard('S', 10),
                new PlayingCard('C', 1)
        ));

        assertEquals(15, hand.sumOfFaces());
    }

    @Test
    void heartsAsStringReturnsAllHearts() {
        HandOfCards hand = new HandOfCards(List.of(
                new PlayingCard('H', 12),
                new PlayingCard('C', 3),
                new PlayingCard('H', 9),
                new PlayingCard('S', 1),
                new PlayingCard('H', 1)
        ));

        assertEquals("H12 H9 H1", hand.heartsAsString());
    }

    @Test
    void heartsAsStringReturnsNoHeartsWhenThereAreNoHearts() {
        HandOfCards hand = new HandOfCards(List.of(
                new PlayingCard('S', 12),
                new PlayingCard('C', 3),
                new PlayingCard('D', 9)
        ));

        assertEquals("No Hearts", hand.heartsAsString());
    }

    @Test
    void containsQueenOfSpadesReturnsTrueWhenPresent() {
        HandOfCards hand = new HandOfCards(List.of(
                new PlayingCard('S', 12),
                new PlayingCard('H', 4),
                new PlayingCard('C', 8)
        ));

        assertTrue(hand.containsQueenOfSpades());
    }

    @Test
    void containsQueenOfSpadesReturnsFalseWhenNotPresent() {
        HandOfCards hand = new HandOfCards(List.of(
                new PlayingCard('S', 11),
                new PlayingCard('H', 12),
                new PlayingCard('C', 8)
        ));

        assertFalse(hand.containsQueenOfSpades());
    }

    @Test
    void hasFlushReturnsTrueWhenHandHasFiveCardsOfSameSuit() {
        HandOfCards hand = new HandOfCards(List.of(
                new PlayingCard('H', 2),
                new PlayingCard('H', 4),
                new PlayingCard('H', 6),
                new PlayingCard('H', 8),
                new PlayingCard('H', 10)
        ));

        assertTrue(hand.hasFlush());
    }

    @Test
    void hasFlushReturnsFalseWhenHandDoesNotHaveFiveCardsOfSameSuit() {
        HandOfCards hand = new HandOfCards(List.of(
                new PlayingCard('H', 2),
                new PlayingCard('H', 4),
                new PlayingCard('H', 6),
                new PlayingCard('S', 8),
                new PlayingCard('D', 10)
        ));

        assertFalse(hand.hasFlush());
    }

    @Test
    void toStringReturnsCardsSeparatedBySpaces() {
        HandOfCards hand = new HandOfCards(List.of(
                new PlayingCard('H', 4),
                new PlayingCard('H', 12),
                new PlayingCard('C', 3),
                new PlayingCard('D', 11),
                new PlayingCard('S', 1)
        ));

        assertEquals("H4 H12 C3 D11 S1", hand.toString());
    }
}