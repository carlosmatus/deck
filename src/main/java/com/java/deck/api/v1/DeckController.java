package com.java.deck.api.v1;

import com.java.deck.model.Card;
import com.java.deck.service.DeckService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map.Entry;
import javax.inject.Inject;

@RestController
public class DeckController {

    private DeckService deckService;

    @Inject
    public DeckController(DeckService deckService){
        this.deckService = deckService;
    }


    @GetMapping("/generate-new-deck")
    public ResponseEntity<?> generate(){
        try{
            String deckId = deckService.generateNewDeck();

                       return ResponseEntity.ok().body("DeckId = "+deckId);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("There was server error");
        }
    }

    @GetMapping("/get-next-card")
    public ResponseEntity<?> getNextCard(@RequestParam String deckId, @RequestParam(required = false) String cardIndex){

            final Entry<String, Card> nextCard = deckService.getNextCard(deckId, cardIndex);

       if(nextCard==null){
            return ResponseEntity.badRequest().body("deckId is not valid or there was an error processing the request");
        }
        return ResponseEntity.ok().body(nextCard.toString());

    }

    @GetMapping("/skip-next-card")
    public ResponseEntity<?> skipNextCard(@RequestParam String deckId, @RequestParam(required = false)  String cardIndex){

        final String newCardIndex = deckService.skipNextCard(deckId, cardIndex);

       if(newCardIndex ==null){
            return ResponseEntity.badRequest().body("deck id is not valid or there was an error processing the request");
        }
        return ResponseEntity.ok().body(newCardIndex);
    }
}
