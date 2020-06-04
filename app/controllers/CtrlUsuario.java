package controllers;

import models.UsuarioRepository;
import models.usuario;
import models.colonia;
import play.data.FormFactory;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Http.Session;
import play.mvc.Result;
import views.html.admin;

import javax.inject.Inject;
import javax.xml.ws.spi.http.HttpContext;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import static play.mvc.Http.Session;
import static play.libs.Json.toJson;

public class CtrlUsuario extends Controller {
        public static final String USER_EMAIL = "ssl3w47l";
        public static String USER_NAME = "sslV5er44m3";
        public static final String USER_ID = "sslV5er44m3";
        Session session;
        private final FormFactory formFactory;
        private final UsuarioRepository usuarioRepository;
        private final HttpExecutionContext ec;
    //if your class extends play.mvc.Controller you can access directly to the session object

        @Inject
        public CtrlUsuario(FormFactory formFactory, Session session, UsuarioRepository usuarioRepository, HttpExecutionContext ec) {
            this.formFactory = formFactory;
            this.session=session;
            this.usuarioRepository = usuarioRepository;
            this.ec = ec;
        }
    
        public Result index(final Http.Request request) {
            return ok(views.html.index.render());
        }

        public CompletionStage<Result> guardarUsuario(final Http.Request request) {
            usuario usuario = formFactory.form(usuario.class).bindFromRequest(request).get();
            return usuarioRepository
                    .add(usuario)
                    .thenApplyAsync(p -> redirect(routes.CtrlPersona.index()), ec.current());
        }

        public CompletionStage<Result> getUsuarios() {
            System.out.println("lista usuarios");
            return usuarioRepository
                    .list()
                    .thenApplyAsync(personStream -> ok(toJson(personStream.collect(Collectors.toList()))), ec.current());
        }
        public Result FindId(final Http.Request request){
            usuario usuario = formFactory.form(usuario.class).bindFromRequest(request).get();
/*
            //Map usuario = request.body().asFormUrlEncoded();
            String user = usuario.getUSUARIO();
            System.out.println("------->"+user);
            return usuarioRepository
                    .findId(usuario)
                    .thenApplyAsync(p ->  ok(toJson(p.collect(Collectors.toList()))), ec.current());
  */
return ok("");
        }
		
	   public CompletionStage<Result> findColonia(Http.Request request){
            colonia colonia = formFactory.form(colonia.class).bindFromRequest(request).get();
			 return usuarioRepository
					.findColonia(colonia)
					.thenApplyAsync(p ->  ok(toJson(p.collect(Collectors.toList()))), ec.current());
	   }
	   
        public CompletionStage<Result> login(Http.Request request){
            usuario usuario = formFactory.form(usuario.class).bindFromRequest(request).get();
            String usuarioForm = usuario.getUSU_USUARIO();
            String passForm = usuario.getUSU_PASS();
            //Json.toJson(p.collect(Collectors.toList()))
           return usuarioRepository.findId(usuario).thenApplyAsync(p ->  {
               AtomicInteger acceso = new AtomicInteger();
               acceso.set(0);
               p.collect(Collectors.toList()).
                        forEach(o -> {
                            if(passForm.equals(o.getUSU_PASS())){
                                acceso.set(1);
                                Session a = new Session();
                                session=a.adding("usuario",o.getUSU_USUARIO());
                                USER_NAME= session.data().get("usuario");
                                System.out.println("::::::::::::::::."+USER_NAME);
                            }else {
                                acceso.set(0);
                                System.out.println("Error");
                            }
                        });
               if(acceso.get() == 1){
                   return ok(views.html.admin.render(USER_NAME));
               }else {
                   return  redirect(routes.CtrlPersona.index());
               }
                   }, ec.current());

        }
    public Result admin() {
        return ok(views.html.admin.render(USER_NAME));
    }
    public Result usuario() {
        return ok(views.html.usuario.render());
    }
}