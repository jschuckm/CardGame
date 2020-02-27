package coms362.cards.socket;

import org.eclipse.jetty.websocket.servlet.ServletUpgradeRequest;
import org.eclipse.jetty.websocket.servlet.ServletUpgradeResponse;
import org.eclipse.jetty.websocket.servlet.WebSocketCreator;

public class CardSocketCreator implements WebSocketCreator {
    CardSocketListener cardSocketListener;
    
    public CardSocketCreator(CardSocketListener cardSocketListener) {
        this.cardSocketListener = cardSocketListener;
    }

    public Object createWebSocket(ServletUpgradeRequest arg0, ServletUpgradeResponse arg1) {
        return new CardSocket(cardSocketListener);
    }   
}
