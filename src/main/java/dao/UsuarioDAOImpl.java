package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import entidade.Usuario;

/**
 * @author Nadjane Implementa��o da interface UsuarioDAO.
 */

public class UsuarioDAOImpl implements UsuarioDAO {

	private EntityManager em;

	public UsuarioDAOImpl(EntityManager em) {
		this.em = em;
	}

	// M�todo gravar(inserir): Recebe o usu�rio e salva-o no banco.
	// M�todo gravar(alterar): Recebe o usu�rio e salva-o no banco alterando o usu�rio existente.

	public boolean gravar(Usuario usuario) {

		EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(usuario);
		et.commit();

		return true;

	}

	
	// M�todo remover: Remove o usu�rio.

	public void remover(Usuario usuario) {

		EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(usuario);
		et.commit();

	}
	
	public void removerTelefone(long id) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(id);
		et.commit();
	}

	// M�todo pesquisar: Pesquisa o usu�rio pela chave prim�ria (email).

	public Usuario pesquisar(String email) {

		Usuario usuario = em.find(Usuario.class, email);

		return usuario;

	}

	// M�todo ListarTodos: Consulta o usu�rio e retorna uma lista de usu�rios.

	public List<Usuario> listarTodos() {

		Query query = em.createQuery("from Usuario u");

		@SuppressWarnings("unchecked")
		List<Usuario> usuarios = query.getResultList();

		return usuarios;

	}

}
