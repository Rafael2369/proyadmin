package controllers;
//import models.venta;
import controllers.Util;
//import models.VentaRepository;
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
public class CtrlVenta extends Controller {

        private final FormFactory formFactory;
        //private final VentaRepository ventaRepository;
        private final HttpExecutionContext ec;
    
        @Inject
        public CtrlVenta(FormFactory formFactory,  HttpExecutionContext ec) {
            this.formFactory = formFactory;
            //this.ventaRepository = ventaRepository;
            this.ec = ec;
        }
    /*
        public Result index(final Http.Request request) {
            return ok(views.html.index.render());
        }
		*/
        public Result venta(){
            return ok(views.html.venta.render());
        }
		/*
        public CompletionStage<Result> guardarVenta(final Http.Request request) {
            venta venta = formFactory.form(venta.class).bindFromRequest(request).get();
          
            return ventaRepository
                    .add(venta)
                    .thenApplyAsync(p -> ok(toJson(p.getMAR_ID())), ec.current());
        }

        public CompletionStage<Result> getVentas(){
            return ventaRepository
                    .list()
                    .thenApplyAsync(personStream -> ok(toJson(personStream.collect(Collectors.toList()))), ec.current());
        }
		*/



}