package coms362.cards.webapp;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.webapp.WebAppContext;

import cards.streams.InBoundQueue;
import cards.streams.RemoteTableGateway;
import coms362.cards.fiftytwo.FiftyTwo;
import coms362.cards.socket.CardSocketCreator;
import coms362.cards.socket.ServletContextHolder;

/**
 * bring up the 
 */
public class Bootstrap {
	// TODO: do these, especially the queue, need to be static? 
	private static InBoundQueue asyncQ = new InBoundQueue();
	private static CardSocketCreator socketCreator = new CardSocketCreator(new EventConsumer(asyncQ) );
	private static ServletContextHolder context = new ServletContextHolder(socketCreator, "/socket");
    private static WebappConfig cardsConfig = new WebappConfig("src/main/cards362app", "/cards362",
            "src/main/webdefault/WEB-INF/webdefault.xml", context
            );
    private static WebappConfig webappConfigs[] = {cardsConfig};
    private Server server;

    public Bootstrap() {
        server = new Server(8080);
    }

    public void configWebapps(WebappConfig webappConfigs[]) {
        HandlerCollection handlers = new HandlerCollection();
        for (WebappConfig config : webappConfigs) {
            configWebapp(config, handlers);
        }
        server.setHandler(handlers);
    }


    public void start() throws Exception {
        server.start();
        System.out.println("Server Started");
        int i = 300;
        while (! RemoteTableGateway.getInstance().isReady() && i-- > 0){
        	Thread.sleep(1000);
        }
        FiftyTwo app = new FiftyTwo(asyncQ, RemoteTableGateway.getInstance());
        app.run();
        
        System.out.println("Application Started");
 
        app.notifyAll();
        server.join();

        System.out.println("Application Thread exiting");
    }

    private void configWebapp(WebappConfig config, HandlerCollection handlers) {
        WebAppContext webapp = new WebAppContext();
        webapp.setResourceBase(config.getResourceBase());
        webapp.setContextPath(config.getContextPath());
        webapp.setDefaultsDescriptor(config.getDefaultsDescriptor());
        webapp.addServlet(config.getServletContextHolder().getServletHolder(),
                config.getServletContextHolder().getContext());
        handlers.addHandler(webapp);
    }

    public static void main(String[] args) throws Exception {
        Bootstrap uiHandler = new Bootstrap();

        uiHandler.configWebapps(webappConfigs);
        
        try {
            uiHandler.start(); //UI start
            
        } catch (Exception e) {
            System.err.println("ERROR starting app server");
            e.printStackTrace();
        }
    }
}
