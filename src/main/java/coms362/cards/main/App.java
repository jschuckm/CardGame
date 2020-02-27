package coms362.cards.main;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.webapp.WebAppContext;

import coms362.cards.fiftytwo.EventConsumer;
import coms362.cards.socket.CardSocketCreator;
import coms362.cards.socket.ServletContextHolder;

/**
 * main for app
 */
public class App {
    private static WebappConfig cardsConfig = new WebappConfig("src/main/cards362app", "/cards362",
            "src/main/webdefault/WEB-INF/webdefault.xml",
            new ServletContextHolder(new CardSocketCreator(new EventConsumer()), "/socket"));
    private static WebappConfig webappConfigs[] = {cardsConfig};
    private Server server;

    public App() {
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
        System.out.println("Started!");
        server.join();
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
        App app = new App();
        app.configWebapps(webappConfigs);
        try {
            app.start();
        } catch (Exception e) {
            System.err.println("ERROR starting app server");
            e.printStackTrace();
        }
    }
}
