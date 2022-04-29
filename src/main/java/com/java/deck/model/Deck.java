package com.java.deck.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import java.util.stream.Collectors;

public class Deck {

    private ArrayList<Card> deck;
    private String deckId;
    private LinkedHashMap<String, Card> orderedDeck;


    public Deck(ArrayList<Card> deck) {

        this.deck = deck;

    }

    public Deck() {

        List<String> suits = Card.getValidSuits();
        List<String> faceNames = Card.getValidFaceNames();

        deck = new ArrayList<>();

        for (String suit : suits) {
            for (String faceName : faceNames) {
                deck.add(new Card(faceName, suit));
            }
        }

        this.deckId = UUID.randomUUID().toString().substring(0,4);
    }

    public String getDeckId() {

        return deckId;
    }

    public ArrayList<Card> getDeck() {

        return deck;
    }


    public void shuffle() {

        Collections.shuffle(deck);
        orderDeck();
    }

    private void orderDeck() {

        final Map<String, Card> collect =
            deck.stream().collect(Collectors.toMap(card -> card.getId(), card -> card));
        orderedDeck = new LinkedHashMap<>(collect);

    }

    public Entry<String, Card> getNextCard(final String cardId) {

        if (orderedDeck == null) {
            return null;
        }
        if (cardId == null && orderedDeck.entrySet().iterator().hasNext()) {
            return orderedDeck.entrySet().iterator().next();
        }
        final Iterator<Entry<String, Card>> iterator = orderedDeck.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry me = iterator.next();
            if (me.getKey().equals(cardId) && iterator.hasNext()) {
                return iterator.next();
            }
        }
        return null;
    }

    public String spikNextCard(final String cardIndex) {

        if (orderedDeck == null) {
            return null;
        }
        if (cardIndex == null && orderedDeck.entrySet().iterator().hasNext()) {
            orderedDeck.entrySet().iterator().next();
            if (orderedDeck.entrySet().iterator().hasNext()) {
                return orderedDeck.entrySet().iterator().next().getKey();
            } else {
                return null;
            }
        }
        final Iterator<Entry<String, Card>> iterator = orderedDeck.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry me = iterator.next();
            if (me.getKey().equals(cardIndex) && iterator.hasNext()) {
                iterator.next();
                if (me.getKey().equals(cardIndex) && iterator.hasNext()) {
                    return iterator.next().getKey();
                } else {
                    return null;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {

        Deck deck = new Deck();
        System.out.println(deck.getDeck());
        deck.shuffle();
        System.out.println(deck.getDeck());
    }

}
