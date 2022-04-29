package com.java.deck.service;

import com.java.deck.model.Card;
import com.java.deck.model.Deck;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.AbstractMap;
import java.util.Map.Entry;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DeckServiceTest {

    @Mock
    private Deck deck;
    @InjectMocks DeckService deckService;

    @Test
    public void getNextCard() {
        final String faceName = "2";
        Card card = new Card("2", "diamonds");
        card.setFaceName(faceName);

        Entry<String, Card> entry = new AbstractMap.SimpleImmutableEntry<>("123", card);


        when(deck.getNextCard(anyString())).thenReturn(entry);
        String deckId = deckService.generateNewDeck();
        final Entry<String, Card> result = deckService.getNextCard(deckId, null);

        assertThat(result.getValue().getFaceName()).isNotNull();
    }

    @Test
    public void skipNextCard() {

        String newCardIndex = "12345";
        when(deck.spikNextCard(anyString())).thenReturn(newCardIndex);
        String deckId = deckService.generateNewDeck();
        String cardIndex  = deckService.skipNextCard(deckId, null);

        assertThat(cardIndex).isNotNull();
    }
}
