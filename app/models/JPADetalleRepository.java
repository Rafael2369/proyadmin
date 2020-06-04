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
public class JPADetalleRepository implements DetalleRepository {
    private final JPAApi jpaApi;
    private final DatabaseExecutionContext executionContext;
    @Inject
    public JPADetalleRepository(JPAApi jpaApi, DatabaseExecutionContext executionContext) {
        this.jpaApi = jpaApi;
        this.executionContext = executionContext;
    }

    @Override
    public CompletionStage<detalle> add(detalle detalle) {
        return supplyAsync(() -> wrap(em -> insert(em, detalle)), executionContext);
    }

    @Override
    public CompletionStage<Stream<detalle>> list() {
        return supplyAsync(() -> wrap(em -> list(em)), executionContext);
    }@Override
	
    public CompletionStage<Stream<movimientoDetalle>> listmovimientoDetalle(movimientoDetalle movimientoDetalle) {
        return supplyAsync(() -> wrap(em -> listmovimientoDetalle(em, movimientoDetalle)), executionContext);
    }

    private <T> T wrap(Function<EntityManager, T> function) {
        return jpaApi.withTransaction(function);
    }

    private detalle insert(EntityManager em, detalle detalle) {

            //detalle.PER_IDPERSONA = System.currentTimeMillis(); // not ideal, but it works
         em.persist(detalle);
        em.flush();

        em.refresh(detalle);
            return detalle;

        //em.persist(detalle);

        //return detalle;
    }

    private Stream<detalle> list(EntityManager em) {
        List<detalle> persons = em.createQuery("select p from detalle p", detalle.class).getResultList();
        return persons.stream();
    }
	private Stream<movimientoDetalle> listmovimientoDetalle(EntityManager em, movimientoDetalle movimientoDetalle) {
		System.out.println("movimientoDetalle-------->"+movimientoDetalle.getDET_IDMOVIMIENTO());
        List<movimientoDetalle> persons = em.createQuery("SELECT p FROM movimientoDetalle p WHERE DET_IDMOVIMIENTO='39'", movimientoDetalle.class).getResultList();
        return persons.stream();
    }
}
