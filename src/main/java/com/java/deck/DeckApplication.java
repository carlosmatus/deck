package com.java.deck;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DeckApplication {

	public static void main(String[] args) {
		System.setProperty("server.servlet.context-path", "/deckservice");
		SpringApplication.run(DeckApplication.class, args);
	}

}
