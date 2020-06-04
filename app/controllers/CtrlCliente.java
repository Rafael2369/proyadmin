package controllers;

//import models.PersonaRepository;
import models.cliente;
import play.data.FormFactory;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.concurrent.CompletionStage;
import java.util.stream.Collectors;

import static play.libs.Json.toJson;

public class CtrlCliente extends Controller {

       // private final FormFactory formFactory;
  //      private final PersonaRepository personaRepository;
        //private final HttpExecutionContext ec;
    /*
        @Inject
        public CtrlCliente(FormFactory formFactory, PersonaRepository personaRepository, HttpExecutionContext ec) {
            this.formFactory = formFactory;
            this.personaRepository = personaRepository;
            this.ec = ec;
        }
    
        public Result index(final Http.Request request) {
            return ok(views.html.index.render());
        }

     */
        public Result cliente(){
            return ok(views.html.cliente.render());
        }
		public Result factura(){
            return ok(views.html.factura.render());
        }
/*
        public Result addCliente(final Http.Request request) {

            cliente cliente = formFactory.form(cliente.class).bindFromRequest(request).get();
            System.out.println("----->"+cliente);
            cliente.save();


             personaRepository
                    .add(cliente)
                    .thenApplyAsync(p -> redirect(routes.CtrlCliente.index()), ec.current());

            return (CompletionStage<Result>) ok("hola");
        }
        */
    /*
        public CompletionStage<Result> getPersonas() {
            return personaRepository
                    .list()
                    .thenApplyAsync(personStream -> ok(toJson(personStream.collect(Collectors.toList()))), ec.current());
        }


 */
}