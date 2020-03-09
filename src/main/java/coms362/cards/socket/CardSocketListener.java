package coms362.cards.socket;

public interface CardSocketListener {
    void onConnect();
    void onReceive(SocketEvent event);
    void setCardSocket(CardSocket cardSocket);
}
