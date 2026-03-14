package edu.ntnu.idatt2003.cardgame.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PlayingCardTest {

    @Test
    void constructorCreatesCardWithValidSuitAndFace() {
        PlayingCard card = new PlayingCard('H', 10);

        assertEquals('H', card.getSuit());
        assertEquals(10, card.getFace());
    }

    @Test
    void constructorThrowsExceptionForInvalidSuit() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new PlayingCard('X', 5)
        );

        assertEquals("Parameter suit must be one of H, D, C or S", exception.getMessage());
    }

    @Test
    void constructorThrowsExceptionForFaceBelowRange() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new PlayingCard('H', 0)
        );

        assertEquals("Parameter face must be a number between 1 to 13", exception.getMessage());
    }

    @Test
    void constructorThrowsExceptionForFaceAboveRange() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new PlayingCard('H', 14)
        );

        assertEquals("Parameter face must be a number between 1 to 13", exception.getMessage());
    }

    @Test
    void getAsStringReturnsCorrectFormat() {
        PlayingCard card = new PlayingCard('S', 12);

        assertEquals("S12", card.getAsString());
    }

    @Test
    void getSuitReturnsCorrectSuit() {
        PlayingCard card = new PlayingCard('D', 7);

        assertEquals('D', card.getSuit());
    }

    @Test
    void getFaceReturnsCorrectFace() {
        PlayingCard card = new PlayingCard('C', 3);

        assertEquals(3, card.getFace());
    }


    @Test
    void equalsReturnsTrueForSameObject() {
        PlayingCard card = new PlayingCard('H', 5);

        assertTrue(card.equals(card));
    }

    @Test
    void equalsReturnsTrueForCardsWithSameSuitAndFace() {
        PlayingCard card1 = new PlayingCard('S', 8);
        PlayingCard card2 = new PlayingCard('S', 8);

        assertTrue(card1.equals(card2));
    }

    @Test
    void equalsReturnsFalseForNull() {
        PlayingCard card = new PlayingCard('H', 5);

        assertFalse(card.equals(null));
    }

    @Test
    void equalsReturnsFalseForDifferentType() {
        PlayingCard card = new PlayingCard('H', 5);

        assertFalse(card.equals("H5"));
    }

    @Test
    void equalsReturnsFalseForDifferentSuit() {
        PlayingCard card1 = new PlayingCard('H', 5);
        PlayingCard card2 = new PlayingCard('S', 5);

        assertFalse(card1.equals(card2));
    }

    @Test
    void equalsReturnsFalseForDifferentFace() {
        PlayingCard card1 = new PlayingCard('H', 5);
        PlayingCard card2 = new PlayingCard('H', 6);

        assertFalse(card1.equals(card2));
    }
}
