package Repositorio;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Interfaces.IRepositorioBancoDeHoras;
import beans.Afastamento;
import beans.BancoDeHoras;

public class RepositorioBancoDeHoras implements IRepositorioBancoDeHoras {


	Connection con;

	private static IRepositorioBancoDeHoras instance;

	public static synchronized IRepositorioBancoDeHoras getInstance()
	{


		if(instance == null)
		{

			instance = new RepositorioBancoDeHoras();
		}

		return instance;
	}


	private RepositorioBancoDeHoras()
	{
		con = Conectar.getInstance().getCon();
	}

	
	public String cadastrarBancoDeHoras(BancoDeHoras a)
	{
		try
		{
			String query = "call adicionarBancoHoras( ?, ?, ?)";
			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setDate(1, a.getDia());
			stmt.setInt(2,  a.getQtd_horas());
			stmt.setString(3, a.getFuncionario_cpf());
		
			stmt.executeUpdate();



			stmt.close();
			
		}catch(Exception e)
		{
			return "Horas não podem ser cadastrada";
		}
		
		return "Horas  cadastrada com sucesso";
	}
	
	public boolean removerBancoDeHoras(Date dia, String funcionario_cpf)
	{
		try {
			
			String query = "call removerBancoHoras(?, ?)";
			

			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setDate(1, dia);
			stmt.setString(2, funcionario_cpf);
			stmt.executeUpdate();
			stmt.close(); 

			
		}catch(Exception e)
		{
			return false;
		}
		
		return true;
	}
	
	
	public boolean alterarBancoDeHoras(int qtd, Date dia, String cpf)
	{
		
		try {
			
			String query = "update banco_de_horas set qtd_horas = ? where data_banco = ? and funcionario_cpf = ?";
			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setInt(1, qtd);
			stmt.setDate(2, dia);
			stmt.setString(3, cpf);
			
			
		}catch(Exception e)
		{
			System.out.println("erro alterar");
			return false;
		}
		
		return true;
	}
	
	public BancoDeHoras buscarBancoDeHoras (String cpf, Date dia)
	{
		BancoDeHoras a = new BancoDeHoras();
	
		try{
			String query="";

			query = "call buscarBancoHoras(?, ?)";
			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setDate(1, dia);
			stmt.setString(2, cpf);
			
			ResultSet resultado  = stmt.executeQuery();

			while(resultado.next()) {
			
			a.setDia(resultado.getDate("data_banco"));
			a.setFuncionario_cpf(resultado.getString("funcionario_cpf"));
			a.setQtd_horas(resultado.getInt("qtd_horas"));
			
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
	
	public ArrayList<BancoDeHoras> listarBancoDeHorasFuncionario(String cpf)
	{
		ArrayList<BancoDeHoras> banco = new ArrayList<BancoDeHoras>();
		
		BancoDeHoras a = new BancoDeHoras();
		try {
			String query = "call listarBancoHorasFuncionario(?)";

			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setString(1, cpf);

			ResultSet resultado  = stmt.executeQuery();

			while(resultado.next())
			{
				a = new BancoDeHoras();
			

				
				a.setDia(resultado.getDate("data_banco"));
				a.setFuncionario_cpf(resultado.getString("funcionario_cpf"));
				a.setQtd_horas(resultado.getInt("qtd_horas"));

				banco.add(a);
				
				};
			resultado.close();
			stmt.close();
		
		}catch(Exception e)
		{
			System.out.println("nao foi possivel listar");
			return null;
		}
		
		return banco;
		
	}
	

	public ArrayList<BancoDeHoras> listarBancoDeHorasDia(Date dia)
	{
		ArrayList<BancoDeHoras> banco = new ArrayList<BancoDeHoras>();
		
		BancoDeHoras a = new BancoDeHoras();
		try {
			String query = "call listarBancoHorasDia(?)";

			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setDate(1, dia);

			ResultSet resultado  = stmt.executeQuery();

			while(resultado.next())
			{
				a = new BancoDeHoras();
			

				
				a.setDia(resultado.getDate("data_banco"));
				a.setFuncionario_cpf(resultado.getString("funcionario_cpf"));
				a.setQtd_horas(resultado.getInt("qtd_horas"));

				banco.add(a);
				
				};
			resultado.close();
			stmt.close();
		
		}catch(Exception e)
		{
			System.out.println("nao foi possivel listar");
			return null;
		}
		
		return banco;
		
	}
	
	public int calcular(Date inicio, Date fim, String cpf)
	{
		String query = "select(retornarTotalHoras(?,?, ?))";
		
		int a = -1;
		try {
		PreparedStatement stmt = con.prepareStatement(query);

		stmt.setDate(1, inicio);
		stmt.setDate(2, fim);
		stmt.setString(3, cpf);

		ResultSet resultado  = stmt.executeQuery();

		while(resultado.next())
		{
			
			a = resultado.getInt(1);
			}
		resultado.close();
		stmt.close();
	
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	
	return a;
	
}
	
}


