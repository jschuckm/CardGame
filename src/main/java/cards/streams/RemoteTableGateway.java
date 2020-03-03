package cards.streams;

import java.io.IOException;

import org.eclipse.jetty.websocket.api.RemoteEndpoint;

public class RemoteTableGateway {
	RemoteEndpoint remote = null;
	private static RemoteTableGateway instance = null; 
	
	
	private RemoteTableGateway(){
		
	}
	
	public void send(Marshalls e) throws IOException {
		remote.sendString(e.marshall());
	}
	
	public void sendString(String msg) throws IOException{
		remote.sendString(msg);
	}

	public void setSocket(RemoteEndpoint remote) {
		System.out.println("Gateway setting remote: "+instance.toString());
		this.remote = remote;
	}
	
	public boolean isReady(){
		return remote != null;
	}

	public static synchronized RemoteTableGateway getInstance() {
		if (instance == null){

			instance = new RemoteTableGateway();
			System.out.println("Creating Gateway "+instance.toString());
		}
		return instance;
	}
}
