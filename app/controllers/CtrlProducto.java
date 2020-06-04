package controllers;

import models.ProductoRepository;
import models.producto;
import models.ProductoRepository;
import play.data.FormFactory;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.concurrent.CompletionStage;
import java.util.stream.Collectors;

import static play.libs.Json.toJson;

public class CtrlProducto extends Controller {

        private final FormFactory formFactory;
        private final ProductoRepository ProductoRepository;
        private final HttpExecutionContext ec;

        @Inject
        public CtrlProducto(FormFactory formFactory, ProductoRepository ProductoRepository, HttpExecutionContext ec) {
            this.formFactory = formFactory;
            this.ProductoRepository = ProductoRepository;
            this.ec = ec;
        }
    /*
        public Result index(final Http.Request request) {
            return ok(views.html.index.render());
        }

     */
        public Result Producto(){
            return ok(views.html.Producto.render());
        }

        public CompletionStage<Result> addProducto(final Http.Request request) {
			producto producto = formFactory.form(producto.class).bindFromRequest(request).get();
       
            return ProductoRepository
                    .add(producto)
                    .thenApplyAsync(p -> ok(toJson("hola")), ec.current());

        }
        
		public CompletionStage<Result> editProducto(final Http.Request request) {
            producto producto = formFactory.form(producto.class).bindFromRequest(request).get();
            System.out.println("----->"+producto);
            
            return ProductoRepository
                    .edit(producto)
                    .thenApplyAsync(p -> ok(toJson("hola")), ec.current());

        }
		
		public CompletionStage<Result> delproducto(final Http.Request request) {
            producto producto = formFactory.form(producto.class).bindFromRequest(request).get();
         
            return ProductoRepository
                    .del(producto)
                    .thenApplyAsync(p -> ok(toJson("hola")), ec.current());
        }

        public CompletionStage<Result> getProducto(final Http.Request request) {
			producto producto = formFactory.form(producto.class).bindFromRequest(request).get();
            return ProductoRepository
                    .list(producto)
                    .thenApplyAsync(personStream -> ok(toJson(personStream.collect(Collectors.toList()))), ec.current());
        }
		
		public CompletionStage<Result> findCodigoBarra(final Http.Request request) {
			producto producto = formFactory.form(producto.class).bindFromRequest(request).get();
            return ProductoRepository
                    .findCodigoBarra(producto)
                    .thenApplyAsync(personStream -> ok(toJson(personStream.collect(Collectors.toList()))), ec.current());
        }


}