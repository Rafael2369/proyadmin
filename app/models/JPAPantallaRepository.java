package models;

import play.db.jpa.JPAApi;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.concurrent.CompletionStage;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.concurrent.CompletableFuture.supplyAsync;

/**
 * Provide JPA operations running inside of a thread pool sized to the connection pool
 */
public class JPAPantallaRepository implements PantallaRepository {

    private final JPAApi jpaApi;
    private final DatabaseExecutionContext executionContext;

    @Inject
    public JPAPantallaRepository(JPAApi jpaApi, DatabaseExecutionContext executionContext) {
        this.jpaApi = jpaApi;
        this.executionContext = executionContext;
    }

    @Override
    public CompletionStage<pantalla> add(pantalla pantalla) {
        return supplyAsync(() -> wrap(em -> insert(em, pantalla)), executionContext);
    }

    @Override
    public CompletionStage<Stream<pantalla>> list(String usuario) {
        return supplyAsync(() -> wrap(em -> list(em,usuario)), executionContext);
    }

    private <T> T wrap(Function<EntityManager, T> function) {
        return jpaApi.withTransaction(function);
    }

    private pantalla insert(EntityManager em, pantalla pantalla) {
        em.persist(pantalla);
        return pantalla;
    }

    public Stream<pantalla> list(EntityManager em, String usuario) {
        List<pantalla> listobj = em.createQuery("SELECT p FROM usuario u JOIN usuariomenu um ON u.USU_ID = um.MEN_IDUSUSARIO JOIN pantalla p ON um.MEN_IDAPPLICATION = p.PAN_ID_PANTALLA WHERE u.USU_USUARIO ='"+usuario+"'"
                , pantalla.class).getResultList();
        return listobj.stream();
    }
}
