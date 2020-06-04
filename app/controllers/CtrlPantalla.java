package controllers;

import models.PantallaRepository;
import models.pantalla;
import play.api.mvc.Session;
import play.data.FormFactory;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.concurrent.CompletionStage;
import java.util.stream.Collectors;

import static play.libs.Json.toJson;

public class CtrlPantalla extends Controller {

        private final FormFactory formFactory;
        private final PantallaRepository pantallaRepository;
        private final HttpExecutionContext ec;

        @Inject
        public CtrlPantalla(FormFactory formFactory, PantallaRepository pantallaRepository, HttpExecutionContext ec) {
            this.formFactory = formFactory;
            this.pantallaRepository = pantallaRepository;
            this.ec = ec;
        }
    
        public Result index(final Http.Request request) {
            return ok(views.html.index.render());
        }
    /*
        public CompletionStage<Result> addPantalla(final Http.Request request) {
            pantalla pantalla = formFactory.form(pantalla.class).bindFromRequest(request).get();
            return pantallaRepository
                    .add(pantalla)
                    .thenApplyAsync(p -> redirect(routes.CtrlPantalla.index()), ec.current());
        }
    */
        public CompletionStage<Result> getPantallas(final Http.Request request){
            System.out.println("lista pantallas");

            return pantallaRepository
                    .list(CtrlUsuario.USER_NAME)
                    .thenApplyAsync(personStream -> ok(toJson(personStream.collect(Collectors.toList()))), ec.current());
        }
    public CompletionStage<Result> getUsarioPantallas(String usuario){
        System.out.println("lista pantallas");

        return pantallaRepository
                .list(CtrlUsuario.USER_NAME)
                .thenApplyAsync(personStream -> ok(toJson(personStream.collect(Collectors.toList()))), ec.current());
    }

}