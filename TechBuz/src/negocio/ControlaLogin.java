package negocio;

import Interfaces.IRepositorioLogin;
import Repositorio.RepositorioLogin;
import beans.Login;

public class ControlaLogin {

	IRepositorioLogin login;
	
	public ControlaLogin()
	{
		login = RepositorioLogin.getInstance();
	}
	
	public Login checarLogin(String cpf, String senha)
	{
		return login.checarLogin(cpf, senha);
	}
}
