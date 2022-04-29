package com.java.deck.config;

import com.java.deck.service.DeckService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomainServiceConfig {

    @Bean
    public DeckService deckService() {
        return new DeckService();
    }

}

