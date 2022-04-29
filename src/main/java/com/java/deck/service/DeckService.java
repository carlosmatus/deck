package com.java.deck.service;

import com.java.deck.model.Card;
import com.java.deck.model.Deck;

import java.util.HashMap;
import java.util.Map.Entry;


public class DeckService {
    private HashMap<String, Deck> decks;
    public DeckService(){
        decks = new HashMap<>();

    }

    public Deck getDeck(String deckId){
        return decks.get(deckId);
    }
    public String generateNewDeck(){
        Deck deck = new Deck();
        deck.shuffle();
        decks.put(deck.getDeckId(),deck);
        return deck.getDeckId();

    }
    public Entry<String, Card>  getNextCard(String deckId, String cardIndex){
        final Deck currentDeck = getDeck(deckId);
        if(decks.containsKey(deckId)){
            return currentDeck.getNextCard(cardIndex);
        }
        return null;
    }
    public String skipNextCard(String deckId, String cardIndex){
        final Deck currentDeck = getDeck(deckId);
        if(decks.containsKey(deckId)){
            return currentDeck.spikNextCard(cardIndex);

        }
        return null;
    }

}
