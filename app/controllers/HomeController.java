package controllers;

import play.mvc.*;
import play.libs.Json;
import router.Routes;
import play.routing.JavaScriptReverseRouter;
import models.persona;
/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
        /*
        com.fasterxml.jackson.databind.JsonNode json = Json.parse("{\"firstName\":\"Foo\", \"lastName\":\"Bar\", \"age\":13}");
        Usuario usuario = new Usuario();
        Json.fromJson(json, Usuario.class);
        system.out.Println("---->"+usuario.firstName);
        */
        persona p= new persona();
       
        return ok(views.html.index.render());
    }

 /*
    public Result Nuevo(data) {

        com.fasterxml.jackson.databind.JsonNode json = Json.parse("{\"firstName\":\"Foo\", \"lastName\":\"Bar\", \"age\":13}");
        Usuario usuario = new Usuario();
        Json.fromJson(json, Usuario.class);
        system.out.Println("---->"+usuario.firstName);

        return ok(views.html.index.render());
    }
    */
    public Result Oferta() {
        return ok(views.html.oferta.render());
    }
    public Result Nuevo() {
        return ok(views.html.nuevo.render());
    }
}
