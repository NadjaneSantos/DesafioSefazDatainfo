package dao;

import java.util.List;

import entidade.Usuario;

/**
 * @author Nadjane
 * 
 *         Interface de compartilhamento da chamada dos m�todos. Implementados
 *         na classe UsuarioDAOImpl.
 */

public interface UsuarioDAO {

	public boolean gravar(Usuario usuario);

	public void remover(Usuario usuario);

	public Usuario pesquisar(String email);

	public List<Usuario> listarTodos();

}
