package coms362.cards.socket;

public interface CardSocketListener {
    void onConnect();
    void onReceive(Event event);
    void setCardSocket(CardSocket cardSocket);
}
