package controllers;
import models.detalle;
import models.movimientoDetalle;
import controllers.Util;
import models.DetalleRepository;
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
public class CtrlDetalle extends Controller {

        private final FormFactory formFactory;
        private final DetalleRepository detalleRepository;
        private final HttpExecutionContext ec;
    
        @Inject
        public CtrlDetalle(FormFactory formFactory, DetalleRepository detalleRepository, HttpExecutionContext ec) {
            this.formFactory = formFactory;
            this.detalleRepository = detalleRepository;
            this.ec = ec;
        }
    /*
        public Result detalle()(final Http.Request request) {
            return ok(views.html.index.render());
        }
		
        public Result detalle(){
            return ok(views.html.detalle.render());
        }
*/
        public CompletionStage<Result> guardarDetalle(final Http.Request request) {
            detalle detalle = formFactory.form(detalle.class).bindFromRequest(request).get();
          
            return detalleRepository
                    .add(detalle)
                    .thenApplyAsync(p -> ok(toJson(p.getDET_ID())), ec.current());
        }

        public CompletionStage<Result> getDetalles(){
            return detalleRepository
                    .list()
                    .thenApplyAsync(personStream -> ok(toJson(personStream.collect(Collectors.toList()))), ec.current());
        }
		
		public CompletionStage<Result> listmovimientoDetalle(final Http.Request request){
			movimientoDetalle obj = formFactory.form(movimientoDetalle.class).bindFromRequest(request).get();
            return detalleRepository
                    .listmovimientoDetalle(obj)
                    .thenApplyAsync(personStream -> ok(toJson(personStream.collect(Collectors.toList()))), ec.current());
        }



}