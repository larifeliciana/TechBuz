package Interfaces;

import beans.Login;

public interface IRepositorioLogin {

	public abstract Login checarLogin(String cpf, String senha);
}
