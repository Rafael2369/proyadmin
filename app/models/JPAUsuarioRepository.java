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
public class JPAUsuarioRepository implements UsuarioRepository {

    private final JPAApi jpaApi;
    private final DatabaseExecutionContext executionContext;

    @Inject
    public JPAUsuarioRepository(JPAApi jpaApi, DatabaseExecutionContext executionContext) {
        this.jpaApi = jpaApi;
        this.executionContext = executionContext;
    }

    @Override
    public CompletionStage<usuario> add(usuario usuario) {
        return supplyAsync(() -> wrap(em -> insert(em, usuario)), executionContext);
    }

    @Override
    public CompletionStage<Stream<usuario>> list() {
        return supplyAsync(() -> wrap(em -> list(em)), executionContext);
    }
    @Override
    public CompletionStage<Stream<usuario>> findId(usuario usuario) {
        return supplyAsync(() -> wrap(em -> findId(em,usuario)), executionContext);
    }
	
	@Override
    public CompletionStage<Stream<colonia>> findColonia(colonia colonia) {
        return supplyAsync(() -> wrap(em -> findColonia(em,colonia)), executionContext);
    }
    private <T> T wrap(Function<EntityManager, T> function) {
        return jpaApi.withTransaction(function);
    }

    private usuario insert(EntityManager em, usuario usuario) {
        em.persist(usuario);
        em.flush();
        em.refresh(usuario);
        return usuario;
    }

    private Stream<usuario> list(EntityManager em) {
        List<usuario> persons = em.createQuery("select p from usuario p", usuario.class).getResultList();
        return persons.stream();
    }
    private Stream<usuario> findId(EntityManager em, usuario usuario) {
        List<usuario> persons = em.createQuery("select p from usuario p where p.USU_USUARIO ='"+usuario.getUSU_USUARIO()+"' ", usuario.class).getResultList();
        return persons.stream();
    }
	 private Stream<colonia> findColonia(EntityManager em, colonia colonia) {
		System.out.println("---->"+colonia.getCOL_CP());
        List<colonia> persons = em.createQuery("SELECT co FROM  colonia co WHERE co.COL_CP ='"+colonia.getCOL_CP()+" ORDER BY co.COL_NOMBRE'", colonia.class).getResultList();
        return persons.stream();
    }
}
