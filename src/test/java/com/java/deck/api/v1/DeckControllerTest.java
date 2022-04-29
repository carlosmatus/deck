package com.java.deck.api.v1;

import com.java.deck.service.DeckService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class DeckControllerTest {
    @InjectMocks private DeckController deckController;
    @Mock
    private DeckService deckService;

    @Test
    public void generateDeck() {

        deckController.generate();

        verify(deckService).generateNewDeck();

    }

    @Test
    public void genNextCard() {
        final String deckId= "a344";
        deckController.getNextCard(deckId,  null);

        verify(deckService).getNextCard(deckId, null);

    }

    @Test
    public void skipNextCard() {
        final String deckId= "a344";
        deckController.skipNextCard(deckId,  null);

        verify(deckService).skipNextCard(deckId, null);

    }
}
