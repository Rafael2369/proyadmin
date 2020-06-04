package controllers;
import models.categoria;
import controllers.Util;
import models.categoriaRepository;
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
public class CtrlCategoria extends Controller {

        private final FormFactory formFactory;
        private final categoriaRepository categoriaRepository;
        private final HttpExecutionContext ec;
    
        @Inject
        public CtrlCategoria(FormFactory formFactory, categoriaRepository categoriaRepository, HttpExecutionContext ec) {
            this.formFactory = formFactory;
            this.categoriaRepository = categoriaRepository;
            this.ec = ec;
        }
    
        public Result index(final Http.Request request) {
            return ok(views.html.index.render());
        }
        public Result categoria(){
            return ok(views.html.categoria.render());
        }

        public CompletionStage<Result> guardarCategoria(final Http.Request request) {
            categoria categoria = formFactory.form(categoria.class).bindFromRequest(request).get();
          
            return categoriaRepository
                    .add(categoria)
                    .thenApplyAsync(p -> ok(toJson(p.getCAT_ID())), ec.current());
        }

        public CompletionStage<Result> getCategorias(){
            return categoriaRepository
                    .list()
                    .thenApplyAsync(personStream -> ok(toJson(personStream.collect(Collectors.toList()))), ec.current());
        }
		public CompletionStage<Result> listCategoriaArea(){
            return categoriaRepository
                    .listCategoriaArea()
                    .thenApplyAsync(personStream -> ok(toJson(personStream.collect(Collectors.toList()))), ec.current());
        }



}