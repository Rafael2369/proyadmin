package controllers;
import models.unidadMedida;
import controllers.Util;
import models.unidadMedidaRepository;
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
public class CtrlUnidadMedida extends Controller {

        private final FormFactory formFactory;
        private final unidadMedidaRepository unidadMedidaRepository;
        private final HttpExecutionContext ec;
    
        @Inject
        public CtrlUnidadMedida(FormFactory formFactory, unidadMedidaRepository unidadMedidaRepository, HttpExecutionContext ec) {
            this.formFactory = formFactory;
            this.unidadMedidaRepository = unidadMedidaRepository;
            this.ec = ec;
        }
    
        public Result index(final Http.Request request) {
            return ok(views.html.index.render());
        }
        public Result unidadMedida(){
            return ok(views.html.unidadMedida.render());
        }

        public CompletionStage<Result> guardarUnidadMedida(final Http.Request request) {
            unidadMedida unidadMedida = formFactory.form(unidadMedida.class).bindFromRequest(request).get();
          
            return unidadMedidaRepository
                    .add(unidadMedida)
                    .thenApplyAsync(p -> ok(toJson(p.getUNI_ID())), ec.current());
        }

        public CompletionStage<Result> getUnidadMedidas(){
            return unidadMedidaRepository
                    .list()
                    .thenApplyAsync(personStream -> ok(toJson(personStream.collect(Collectors.toList()))), ec.current());
        }



}