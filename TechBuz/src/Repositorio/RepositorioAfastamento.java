package Repositorio;

import Repositorio.Conectar;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Interfaces.IRepositorioAfastamento;
import Interfaces.IRepositorioFuncionario;
import beans.Afastamento;
import beans.Funcionario;
import beans.Ocorrencia;
import beans.TipoAfastamento;

public class RepositorioAfastamento implements IRepositorioAfastamento{
	
	Connection con;

	private static IRepositorioAfastamento instance;

	public static synchronized IRepositorioAfastamento getInstance()
	{


		if(instance == null)
		{

			instance = new RepositorioAfastamento();
		}

		return instance;
	}


	private RepositorioAfastamento()
	{
		con = Conectar.getInstance().getCon();

	}

	
	public String cadastrarAfastamento(Afastamento a)
	{
		try
		{
			String query = "call adicionarAfastamento(?, ?, ?,?)";
			PreparedStatement stmt = con.prepareStatement(query);

			
			
			stmt.setDate(1, a.getInicio());
			stmt.setDate(2, a.getFim());
			stmt.setString(3, a.getFuncionario_cpf());
			stmt.setInt(4, a.getTipo_cod());
			stmt.executeUpdate();

			stmt.close(); 
		
		}catch(Exception e)
		{
			e.printStackTrace();
			return "Afastamento não pode ser cadastrada";
		}
		
		return "Afastamento cadastrada com sucesso";
	}
	
	public boolean removerAfastamento(int cod)
	{
		try {
			
			String query = "call removerAfastamento(?, ?)";
			

			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setInt(1, cod);

			stmt.executeUpdate();
			stmt.close(); 

			
		}catch(Exception e)
		{
			return false;
		}
		
		return true;
	}
	
	public boolean checaEncerraAfastamento(int cod)
	{

		try {
			
			String query = "call encerraAfastamento(?)";
			

			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setInt(1, cod);

			stmt.executeUpdate();
			stmt.close(); 

			
		}catch(Exception e)
		{
			return false;
		}
		
		return true;

	}
	
	public boolean EncerraAfastamento(int cod)
	{

		try {
			
			String query = "call encerraAfastamentoManualmente(?)";
			

			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setInt(1, cod);

			stmt.executeUpdate();
			stmt.close(); 

			
		}catch(Exception e)
		{
			return false;
		}
		
		return true;

	}
	
	public Afastamento buscarAfastamento (int cod)
	{
		Afastamento a = new Afastamento();
	
		try{
			String query="";

			query = "select * from afastamento where codigo = ?";
			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setInt(1, cod);
			
			ResultSet resultado  = stmt.executeQuery();

			while(resultado.next()) {
			
			a.setCodigo(resultado.getInt("codigo"));
			a.setFim(resultado.getDate("fim"));
			a.setInicio(resultado.getDate("inicio"));
			a.setFuncionario_cpf(resultado.getString("funcionario_cpf"));
			a.setTipo_cod(resultado.getInt("tipo_cod"));
			}
			
			resultado.close();
			stmt.close(); 
		}
		catch(Exception e) {
			System.out.println("erro Buscar");
			//	return false;
		}

		return a;
		//return true;

		
	}
	
	public ArrayList<Afastamento> listarAfastamentoFuncionario(String cpf)
	{
		ArrayList<Afastamento> afastamento = new ArrayList<Afastamento>();
		
		Afastamento a = new Afastamento();
		try {
			String query = "select * from afastamento where funcionario_cpf = ?";

			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setString(1, cpf);

			ResultSet resultado  = stmt.executeQuery();

			while(resultado.next())
			{
				a = new Afastamento();
			

				a.setCodigo(resultado.getInt("codigo"));
				a.setFim(resultado.getDate("fim"));
				a.setInicio(resultado.getDate("inicio"));
				a.setFuncionario_cpf(resultado.getString("funcionario_cpf"));
				a.setTipo_cod(resultado.getInt("tipo_cod"));
				
				a.setTipo(this.buscarTipoString(a.getTipo_cod()));
				afastamento.add(a);
				
				};
			resultado.close();
			stmt.close();
		
		}catch(Exception e)
		{
			System.out.println("nao foi possivel listar");
			return null;
		}
		
		return afastamento;
		
	}
	
	
	public String adicionarTipoAfastamento(String descricao)
	{
	
		try 
		{
			String query = "INSERT INTO tipo(descricao) values (?)" + 
					"";
			
			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setString(1, descricao);

			 stmt.executeUpdate();
			 
			 stmt.close();

			
			
		}catch(Exception e)
		{
			return ("erro cadastrar tipo");
		}
		
		return "cadastrado";
	}
	
	
	public String removerTipoAfastamento(int cod)
	{
		
		try 
		{
			String query = "delete from tipo where cod = ?" + 
					"";
			
			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setInt(1, cod);

			 stmt.executeUpdate();
			 
			 stmt.close();

			
			
		}catch(Exception e)
		{
			return ("erro remover tipo");
		}
		
		return "removido";
	}
	

	public String buscarTipoString( int tipo_cod)
	
	{
		ArrayList<TipoAfastamento> tipos = this.listarTipoAfastamento();
		for(int i = 0; i<tipos.size(); i++)
		{
			if(tipos.get(i).getCod()==tipo_cod)
				return tipos.get(i).getDescricao();
		}
		
		return "nulo";
	}
	
	
	public ArrayList<TipoAfastamento> listarTipoAfastamento()
	{
		ArrayList<TipoAfastamento> tipos = new ArrayList<TipoAfastamento>();
		TipoAfastamento tipo = new TipoAfastamento();
		
		try
		{
			String query = "select * from tipo" + 
					"";
			PreparedStatement stmt = con.prepareStatement(query);

			ResultSet resultado = stmt.executeQuery();
			
			while(resultado.next())
			{
				
				tipo = new TipoAfastamento();
				
				tipo.setCod(resultado.getInt("cod"));
				tipo.setDescricao(resultado.getString("descricao"));
				tipos.add(tipo);
			}
			
		}catch(Exception e)
		{
			System.out.println("erro");
			return null;
		}
		return tipos;
		
		
	}
	
	
}


