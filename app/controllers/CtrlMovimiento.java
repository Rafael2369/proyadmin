package controllers;
import models.movimiento;
import controllers.Util;
import models.MovimientoRepository;
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
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.CompletionStage;
import java.util.stream.Collectors;
public class CtrlMovimiento extends Controller {

        private final FormFactory formFactory;
        private final MovimientoRepository movimientoRepository;
        private final HttpExecutionContext ec;
    
        @Inject
        public CtrlMovimiento(FormFactory formFactory, MovimientoRepository movimientoRepository, HttpExecutionContext ec) {
            this.formFactory = formFactory;
            this.movimientoRepository = movimientoRepository;
            this.ec = ec;
        }
    /*
        public Result movimiento()(final Http.Request request) {
            return ok(views.html.index.render());
        }
		
        public Result movimiento(){
            return ok(views.html.movimiento.render());
        }
*/
        public CompletionStage<Result> guardarMovimiento(final Http.Request request) {
            movimiento movimiento = formFactory.form(movimiento.class).bindFromRequest(request).get();
			Util a = new Util();
            System.out.println("Fecha: "+a.fechaActual()+"");
            movimiento.setMOV_FECHA(a.fechaActual()+"");
			
            return movimientoRepository
                    .add(movimiento)
                    .thenApplyAsync(p -> ok(toJson(p.getMOV_ID())), ec.current());
        }

        public CompletionStage<Result> getMovimientos(){
            return movimientoRepository
                    .list()
                    .thenApplyAsync(personStream -> ok(toJson(personStream.collect(Collectors.toList()))), ec.current());
        }
		
		public CompletionStage<Result> findId(final Http.Request request){
            movimiento movimiento = formFactory.form(movimiento.class).bindFromRequest(request).get();
			
			System.out.println("-------->"+movimiento.getMOV_IDPERSONA());
            return movimientoRepository
                    .findId(movimiento)
                    .thenApplyAsync(personStream -> ok(toJson(personStream.collect(Collectors.toList()))), ec.current());
        }



}