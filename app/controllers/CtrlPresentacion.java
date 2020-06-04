package controllers;
import models.presentacion;
import controllers.Util;
import models.PresentacionRepository;
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
public class CtrlPresentacion extends Controller {

        private final FormFactory formFactory;
        private final PresentacionRepository presentacionRepository;
        private final HttpExecutionContext ec;
    
        @Inject
        public CtrlPresentacion(FormFactory formFactory, PresentacionRepository presentacionRepository, HttpExecutionContext ec) {
            this.formFactory = formFactory;
            this.presentacionRepository = presentacionRepository;
            this.ec = ec;
        }
    
        public Result index(final Http.Request request) {
            return ok(views.html.index.render());
        }
        public Result presentacion(){
            return ok(views.html.presentacion.render());
        }

        public CompletionStage<Result> guardarPresentacion(final Http.Request request) {
            presentacion presentacion = formFactory.form(presentacion.class).bindFromRequest(request).get();
          
            return presentacionRepository
                    .add(presentacion)
                    .thenApplyAsync(p -> ok(toJson(p.getPRE_ID())), ec.current());
        }

        public CompletionStage<Result> getPresentacions(){
            return presentacionRepository
                    .list()
                    .thenApplyAsync(personStream -> ok(toJson(personStream.collect(Collectors.toList()))), ec.current());
        }



}