package Repositorio;

import java.sql.Connection;
import java.sql.DriverManager;

import Interfaces.IRepositorioOrdemServico;

public class RepositorioOrdemServico implements IRepositorioOrdemServico {
	Connection con;

	private static IRepositorioOrdemServico instance;

	public static synchronized IRepositorioOrdemServico getInstance()
	{


		if(instance == null)
		{

			instance = new RepositorioOrdemServico();
		}

		return instance;
	}


	private RepositorioOrdemServico()
	{
		con = Conectar.getInstance().getCon();
	}

}
