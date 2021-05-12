package ru.job4j.stream;

import java.util.stream.Stream;

public class PackOfCards {

    public enum Suit {
        Diamonds, Hearts, Spades, Clubs
    }

    public enum Value {
        V_6, V_7, V_8
    }

    public static class Card {
        private final Suit suit;
        private final Value value;

        public Card(Suit suit, Value value) {
            this.suit = suit;
            this.value = value;
        }

        public Suit getSuit() {
            return suit;
        }

        public Value getValue() {
            return value;
        }
    }

        public static void main(String[] args) {
            Stream.of(Suit.values())
                    .flatMap(suit -> Stream.of(Value.values())
                            .map(value -> suit + " " + value))
                    .forEach(System.out::println);
        }
    }
