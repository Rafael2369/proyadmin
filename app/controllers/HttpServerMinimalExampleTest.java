package controllers;
import javax.inject.Inject;

import com.fasterxml.jackson.databind.JsonNode;
import play.api.mvc.*;
import play.mvc.Http;
import play.mvc.Http.Request;
import play.routing.Router;
import play.routing.RoutingDsl;
import java.util.concurrent.CompletableFuture;

import static play.mvc.Controller.*;
public class HttpServerMinimalExampleTest {

    private final RoutingDsl routingDsl;

    @Inject
    public HttpServerMinimalExampleTest(RoutingDsl routing) {
        this.routingDsl = routing;
    }

    public Router getRouter() {
        return this.routingDsl

                .GET("/hello/:to").routingTo(to -> ok("Hello " + to))

                .build();
    }
}