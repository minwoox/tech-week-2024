package tech.week;

import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.linecorp.armeria.server.Server;
import com.linecorp.armeria.server.ServerBuilder;

public final class App {

    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) throws UnknownHostException, InterruptedException {
        final ServerBuilder sb = Server.builder();
        sb.http(8080);
        sb.annotatedService(new ShoesService());

        final Server server = sb.build();
        server.closeOnJvmShutdown();
        server.start().join();

        logger.info("Server has been started at http://127.0.0.1:{}", server.activeLocalPort());
    }
}
