package controllers;
import models.persona;
import controllers.Util;
import models.PersonaRepository;
import play.data.FormFactory;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import javax.inject.Inject;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.CompletionStage;
import java.util.stream.Collectors;
import static play.libs.Json.toJson;
public class CtrlPersona extends Controller {

        private final FormFactory formFactory;
        private final PersonaRepository personaRepository;
        private final HttpExecutionContext ec;
    
        @Inject
        public CtrlPersona(FormFactory formFactory, PersonaRepository personaRepository, HttpExecutionContext ec) {
            this.formFactory = formFactory;
            this.personaRepository = personaRepository;
            this.ec = ec;
        }
    
        public Result index(final Http.Request request) {
            return ok(views.html.index.render());
        }
        public Result persona(){
            return ok(views.html.persona.render());
        }

        public CompletionStage<Result> guardarPersona(final Http.Request request) {
            persona persona = formFactory.form(persona.class).bindFromRequest(request).get();
            Util a = new Util();
            System.out.println("Fecha: "+a.fechaActual()+"");
            persona.setPER_FECHAREGISTRO(a.fechaActual()+"");
            return personaRepository
                    .add(persona)
                    .thenApplyAsync(p -> ok(toJson(p.getPER_IDPERSONA())), ec.current());
        }

        public CompletionStage<Result> getPersonas() {
            return personaRepository
                    .list()
                    .thenApplyAsync(personStream -> ok(toJson(personStream.collect(Collectors.toList()))), ec.current());
        }

		public CompletionStage<Result> findId(final Http.Request request) {
            persona persona = formFactory.form(persona.class).bindFromRequest(request).get();
			System.out.println("----->"+persona.getPER_IDPERSONA());
            return personaRepository
                    .findId(persona.getPER_IDPERSONA())
                    .thenApplyAsync(personStream -> ok(toJson(personStream.collect(Collectors.toList()))), ec.current());
        }


}