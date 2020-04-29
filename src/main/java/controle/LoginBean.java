package controle;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import dao.UsuarioDAO;
import dao.UsuarioDAOImpl;
import entidade.Usuario;
import util.JPAUtil;

/**
 * @author Nadjane LoginBean: Classe responsável pelo gerenciamento do login.
 */

@ManagedBean(name = "LoginBean")
@RequestScoped
public class LoginBean {

	
	private String usuarioInpt;
	private String senhaInpt;
	private static final String PESQUISAR = "pesquisarUsuario.xhtml";
	private static final String CADASTRO = "cadastroUsuario.xhtml";
	private UsuarioDAO usuarioDAO;
	private String msg;

	public LoginBean() {
		this.usuarioDAO = new UsuarioDAOImpl(JPAUtil.getEntityManager());
	}

	// Método entrar: Verifica as credenciais do usuário no sistema.

	public void entrar() throws IOException {

		Usuario pesquisarUsuario = this.usuarioDAO.pesquisar(this.usuarioInpt);

		if (pesquisarUsuario != null) {
			if (this.senhaInpt.equals(pesquisarUsuario.getSenha())) {
				FacesContext.getCurrentInstance().getExternalContext().redirect(PESQUISAR);
			} else {
				this.msg = "Senha Incorreta";
			}

		} else {
			this.msg = ("Usuário: " + usuarioInpt + " não está cadastrado.");
		}
	}
	
	
	public void cadastroUsuario() throws IOException {
		
		FacesContext.getCurrentInstance().getExternalContext().redirect(CADASTRO);
		
	}

	public String getUsuarioInpt() {
		return usuarioInpt;
	}

	public void setUsuarioInpt(String usuarioInpt) {
		this.usuarioInpt = usuarioInpt;
	}

	public String getSenhaInpt() {
		return senhaInpt;
	}

	public void setSenhaInpt(String senhaInpt) {
		this.senhaInpt = senhaInpt;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
	
}