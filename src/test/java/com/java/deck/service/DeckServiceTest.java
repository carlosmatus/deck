package com.java.deck.service;

import com.java.deck.model.Card;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Map.Entry;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class DeckServiceTest {

    @InjectMocks DeckService deckService;

    @Test
    public void getNextCard() {
        final String faceName = "2";
        Card card = new Card("2", "diamonds");
        card.setFaceName(faceName);

        String deckId = deckService.generateNewDeck();
        final Entry<String, Card> result = deckService.getNextCard(deckId, null);

        assertThat(result.getValue().getFaceName()).isNotNull();
    }

    @Test
    public void skipNextCard() {

        String deckId = deckService.generateNewDeck();
        String cardIndex  = deckService.skipNextCard(deckId, null);

        assertThat(cardIndex).isNotNull();
    }
}
