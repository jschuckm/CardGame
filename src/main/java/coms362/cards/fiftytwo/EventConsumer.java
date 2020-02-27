package coms362.cards.fiftytwo;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import coms362.cards.main.Card;
import coms362.cards.socket.CardSocket;
import coms362.cards.socket.CardSocketListener;
import coms362.cards.socket.Event;

public class EventConsumer implements CardSocketListener {
    private String suits[] = {"h", "s", "d", "c"};
    private CardSocket cardSocket;
    private Random random;
    private List<Card> cards;

    public EventConsumer() {
        random = new Random();
        cards = new LinkedList<Card>();
    }

    public void onConnect() {
        System.out.println("onConnect");
    }

    public void onReceive(Event event) {
        Object eventObj = event.get("event");
        if (eventObj != null) {
            String eventName = (String) eventObj;
            System.out.println(eventName);
            if ("dealevent".equals(eventName)) {
                dealCards();
            } else if ("cardevent".equals(eventName)) {
                String id = event.get("id").toString();
                try {
                    cardSocket.getRemote().sendString("discardPile.addCard(allCards[" + id + "])");
                    cardSocket.getRemote().sendString("discardPile.render()");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void setCardSocket(CardSocket cardSocket) {
        this.cardSocket = cardSocket;
    }
    
    private void dealCards() {
        cards = new LinkedList<Card>();
        try {
            int cardCounter = 0;
            for (String suit : suits) {
                for (int i = 1; i <= 12; i++) {
                    Card card = new Card();
                    card.setId(cardCounter++);
                    card.setSuit(suit);
                    card.setNumber(i);
                    card.setX(random.nextInt(200) + 100);
                    card.setY(random.nextInt(200) + 100);
                    card.setRotate(random.nextInt(360));
                    card.setFaceUp(random.nextBoolean());
                    cards.add(card);
                }
            }
            sendCards();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void sendCards() {
        try {
            cardSocket.getRemote().sendString(
                    "cards.init({table:'#card-table', cardsUrl:'js/3rdparty/einaregilsson-cards-js/img/cards.png'})");
            cardSocket.getRemote().sendString(
                    "discardPile = new cards.Deck({faceUp:false, x:500, y:350})");
            for (Card c : cards) {
                cardSocket.getRemote().sendString("card1 = new cards.Card('" + c.getSuit() + "', "
                        + c.getNumber() + ", cards.options.table)");
                cardSocket.getRemote()
                        .sendString("card1.moveTo(" + c.getX() + ", " + c.getY() + ", 1, null)");
                cardSocket.getRemote().sendString("card1.rotate(" + c.getRotate() + ")");
                cardSocket.getRemote().sendString("card1.faceUp = " + c.isFaceUp());
                cardSocket.getRemote().sendString("card1.id = " + c.getId());
                cardSocket.getRemote().sendString("card1.el.click(cardMouseEvent)");
                cardSocket.getRemote().sendString("allCards[" + c.getId() + "] = card1");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
