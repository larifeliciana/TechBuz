package Repositorio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Interfaces.IRepositorioLinha;
import beans.Linha;
import beans.Trajeto;

public class RepositorioLinha implements IRepositorioLinha{


	Connection con;

	private static IRepositorioLinha instance;

	public static synchronized IRepositorioLinha getInstance()
	{


		if(instance == null)
		{

			instance = new RepositorioLinha();
		}

		return instance;
	}


	private RepositorioLinha()
	{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			//botar conexão
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/techbuz","root","");


		}
		catch(Exception e)
		{
			System.out.println("erro de classe");
		}

	}

	public ArrayList<Linha> listarLinhas()
	{
		ArrayList<Linha> linhas = new ArrayList<Linha>();
		Linha linha;
		String query = "select * from linha";
		{
			try
			{
				PreparedStatement stmt = con.prepareStatement(query);

				ResultSet resultado = stmt.executeQuery();

				while(resultado.next())
				{
					linha = new Linha();
					linha.setNome(resultado.getString("nome"));
					linha.setNumero(resultado.getString("numero"));
					linha.setTarifa_cod(resultado.getString("tarifa_tipo"));

					linhas.add(linha);

				}
			}catch(Exception e)
			{
				e.printStackTrace();

			}
		}

		return linhas;
	}

	public ArrayList<Trajeto> listarTrajeto(String linha)
	{
		ArrayList<Trajeto> trajetos = new ArrayList<Trajeto>();
		Trajeto trajeto;
		
		String query =  "call listarTrajeto(?)";
		
				try {


					PreparedStatement stmt = con.prepareStatement(query);
					stmt.setString(1, linha);
					ResultSet resultado = stmt.executeQuery();

					while(resultado.next())
					{
						trajeto = new Trajeto();
						
						trajeto.setBairro(resultado.getString("bairro"));
						trajeto.setCidade(resultado.getString("cidade"));
						trajeto.setNumero(resultado.getString("numero"));
						trajeto.setNumeracao(resultado.getInt("numeracao"));
						trajeto.setRua(resultado.getString("rua"));
						trajetos.add(trajeto);
					}

				}catch(Exception e)
		{
					e.printStackTrace();
		}
	
	return trajetos;
	}





}
