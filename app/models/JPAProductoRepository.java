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
public class JPAProductoRepository implements ProductoRepository {
    private final JPAApi jpaApi;
    private final DatabaseExecutionContext executionContext;
    @Inject
    public JPAProductoRepository(JPAApi jpaApi, DatabaseExecutionContext executionContext) {
        this.jpaApi = jpaApi;
        this.executionContext = executionContext;
    }

    @Override
    public CompletionStage<producto> add(producto producto) {
        return supplyAsync(() -> wrap(em -> insert(em, producto)), executionContext);
    }
	@Override
    public CompletionStage<producto> edit(producto producto) {
        return supplyAsync(() -> wrap(em -> edit(em, producto)), executionContext);
    }
	@Override
    public CompletionStage<producto> del(producto producto) {
        return supplyAsync(() -> wrap(em -> delete(em, producto)), executionContext);
    }

    @Override
    public CompletionStage<Stream<producto>> list(producto producto) {
        return supplyAsync(() -> wrap(em -> list(em,producto)), executionContext);
    }
    @Override
    public CompletionStage<Stream<producto>> findCodigoBarra(producto producto) {
        return supplyAsync(() -> wrap(em -> findCodigoBarra(em,producto)), executionContext);
    }

    private <T> T wrap(Function<EntityManager, T> function) {
        return jpaApi.withTransaction(function);
    }

	private producto delete(EntityManager em, producto producto) {
            //producto.PER_IDProducto = System.currentTimeMillis(); // not ideal, but it works
		producto = em.merge(producto);
        em.remove(producto);
        //em.flush();
        //em.refresh(producto);
            return producto;
        //em.persist(producto);
        //return producto;
    }

    private producto insert(EntityManager em, producto producto) {
            //producto.PER_IDProducto = System.currentTimeMillis(); // not ideal, but it works
         em.persist(producto);
        em.flush();
        em.refresh(producto);
            return producto;
        //em.persist(producto);
        //return producto;
    }
	
    private producto edit(EntityManager em, producto producto) {
            //producto.PER_IDProducto = System.currentTimeMillis(); // not ideal, but it works
        em.merge(producto);
        //em.flush();
        //em.refresh(producto);
            return producto;
        //em.persist(producto);
        //return producto;
    }
	private Stream<producto> findCodigoBarra(EntityManager em, producto producto) {
		String a=producto.getPRO_CODIGOBARRA();
		System.out.println("----->"+a);
        List<producto> persons = em.createQuery("SELECT p FROM producto p WHERE pro_codigobarra ='"+a+"'", producto.class).getResultList();
        return persons.stream();
    }

    public  Stream<producto> list(EntityManager em, producto producto) {
		int a=producto.getPRO_STATUS();
        List<producto> persons = em.createQuery("select p from producto p where p.PRO_STATUS= case when "+a+"=1 then 1 when "+a+"=2 then 2 when "+a+"='' then p.PRO_STATUS end", producto.class).getResultList();
        return persons.stream();
    }
}
