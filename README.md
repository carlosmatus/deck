
Deck Service
========================

API that allow a user to generate a shuffled deck of cards and draw cards 1-by-1
or skip a card. The service operate without a DB.

-------------
##### Technical details
The application was created using Java 8, Maven, Springboot 2.6.7
## Limitations/concerns
It would have added more functionality if I had additional information like the purpose of the game, any use cases,context, etc.
   
#### Missing:
    Integration test
    Custom Response Objects
    Addional Exception handler 
    Logging 
    Adding additional http reponses

-------------

## Set up
Clone the following project from github:
```
git clone https://github.com/carlosmatus/deck.git
```
##### Building the application

The following command will build the application locally and generate a `target` directory:

```
mvn clean install
```
##### Create Container to run the application
Docker Instructions:
    From project root directory write the following commands:
 ```
docker build -t deckservice:deck .
docker run -p 8080:8080  -t deckservice:deck 
```

-------------


## API
 ```
POST /generate-new-deck
example: http://localhost:8080/deckservice/generate-new-deck

GET /get-next-card?deckId=xxx&cardIndex=xxx
Required: deckId
Optional: cardIndex
example: http://localhost:8080/deckservice/get-next-card?deckId=095d
example:
http://localhost:8080/deckservice/get-next-card?deckId=9db6
http://localhost:8080/deckservice/get-next-card?deckId=9db6&cardIndex=2d3e

GET /skip-next-card?deckId=xxx&cardIndex=xxx
Required: deckId
Optional: cardIndex
example:
http://localhost:8080/deckservice/skip-next-card?deckId=9db6
http://localhost:8080/deckservice/skip-next-card?deckId=9db6&cardIndex=2d3e
```
