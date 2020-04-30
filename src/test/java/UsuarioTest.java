import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entidade.Telefone;
import entidade.Usuario;

public class UsuarioTest{

	 private EntityManagerFactory entityManagerFactory;

	    @Before
	    public void init() {
	        entityManagerFactory = Persistence.createEntityManagerFactory( "desafiosefaz" );
	    }

	    @After
	    public void destroy() {
	        entityManagerFactory.close();
	    }
	
		
	@Test
	public void UsuarioTeste() throws Exception {
	    EntityManager entityManager = entityManagerFactory.createEntityManager();
	    entityManager.getTransaction().begin();

	    Usuario usuario = new Usuario();
	    usuario.setNome("NadTeste");
		usuario.setEmail("Nad@Teste");
		usuario.setSenha("nad123Teste");
		Telefone t = new Telefone();
		t.setDdd(81);
		t.setNumero("12345678");
		t.setTipo("FIXO");
		t.setUsuario(usuario);
		
	    entityManager.persist(usuario);

	    List<Usuario> dbUsuarios = (List<Usuario>) entityManager.createQuery("select u " + "from Usuario u", Usuario.class).getResultList();
	    assertEquals(usuario.getNome(), ((Usuario) dbUsuarios).getNome());
	    
	    

	    entityManager.getTransaction().commit();
	    entityManager.close();
	}
	

}
