package Repositorio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import GUI.Telas;
import Interfaces.IRepositorioLogin;
import beans.Login;

public class RepositorioLogin implements IRepositorioLogin {



	Connection con;

	private static IRepositorioLogin instance;

	public static synchronized IRepositorioLogin getInstance()
	{


		if(instance == null)
		{

			instance = new RepositorioLogin();
		}

		return instance;
	}


	private RepositorioLogin()
	{
		
	
		con = Conectar.getInstance().getCon();
	}

	public Login  checarLogin(String cpf, String senha)
	{
		String query = "select opcode from login where login_cpf =  ? and senha = ?";
		Login logado = new Login();
		logado.setOpcode(-1);
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, cpf);
			stmt.setString(2, senha);
			
			ResultSet resultado = stmt.executeQuery();
			
		while(resultado.next())
		{
			logado.setCpf(cpf);
			logado.setOpcode(resultado.getInt("opcode"));
		}
		resultado.close();
		stmt.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return logado;
	}
}
