package controllers;
import models.marca;
import controllers.Util;
import models.MarcaRepository;
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
public class CtrlMarca extends Controller {

        private final FormFactory formFactory;
        private final MarcaRepository marcaRepository;
        private final HttpExecutionContext ec;
    
        @Inject
        public CtrlMarca(FormFactory formFactory, MarcaRepository marcaRepository, HttpExecutionContext ec) {
            this.formFactory = formFactory;
            this.marcaRepository = marcaRepository;
            this.ec = ec;
        }
    
        public Result index(final Http.Request request) {
            return ok(views.html.index.render());
        }
        public Result marca(){
            return ok(views.html.marca.render());
        }

        public CompletionStage<Result> guardarMarca(final Http.Request request) {
            marca marca = formFactory.form(marca.class).bindFromRequest(request).get();
          
            return marcaRepository
                    .add(marca)
                    .thenApplyAsync(p -> ok(toJson(p.getMAR_ID())), ec.current());
        }

        public CompletionStage<Result> getMarcas(){
            return marcaRepository
                    .list()
                    .thenApplyAsync(personStream -> ok(toJson(personStream.collect(Collectors.toList()))), ec.current());
        }



}