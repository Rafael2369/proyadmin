package controllers;

//import models.PersonaRepository;
//import models.persona;
import play.mvc.Controller;
import play.mvc.Result;

public class CtrlVendedor extends Controller {

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
        public Result vendedor(){
            return ok(views.html.vendedor.render());
        }
/*
        public CompletionStage<Result> addPersona(final Http.Request request) {
            persona persona = formFactory.form(persona.class).bindFromRequest(request).get();
            return personaRepository
                    .add(persona)
                    .thenApplyAsync(p -> redirect(routes.CtrlPersona.index()), ec.current());
        }
    
        public CompletionStage<Result> getPersonas() {
            return personaRepository
                    .list()
                    .thenApplyAsync(personStream -> ok(toJson(personStream.collect(Collectors.toList()))), ec.current());
        }


 */
}