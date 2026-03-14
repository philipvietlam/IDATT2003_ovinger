package edu.ntnu.idatt2003.cardgame.models;


public class PlayingCard {

    private final char suit; // 'S'=spade, 'H'=heart, 'D'=diamonds, 'C'=clubs
    private final int face; // a number between 1 and 13


    public PlayingCard(char suit, int face) {
        if (suit != 'H' && suit != 'D' && suit != 'C' && suit != 'S') {
            throw new IllegalArgumentException("Parameter suit must be one of H, D, C or S");
        }

        if (face < 1 || face > 13) {
            throw new IllegalArgumentException("Parameter face must be a number between 1 to 13");
        }

        this.suit = suit;
        this.face = face;
    }


    public String getAsString() {
        return String.format("%s%s", suit, face);
    }


    public char getSuit() {
        return suit;
    }


    public int getFace() {
        return face;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PlayingCard otherCard = (PlayingCard) o;
        return getSuit() == otherCard.getSuit() && getFace() == otherCard.getFace();
    }


    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + getSuit();
        hash = 31 * hash + getFace();
        return hash;
    }
}