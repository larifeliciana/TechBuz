package Repositorio;
import java.sql.*;
import java.util.ArrayList;

import Interfaces.IRepositorioEmpresa;
import Interfaces.IRepositorioFuncionario;
//import com.mysql.jdbc.*;
import beans.Empresa;

public class RepositorioEmpresa implements IRepositorioEmpresa {
	
	Connection con;
	
	private static IRepositorioEmpresa instance;
	
	public static synchronized IRepositorioEmpresa getInstance()
	{
		if(instance == null)
		{
		
			instance = new RepositorioEmpresa();
		}
		
		return instance;
	}
	
	
	private RepositorioEmpresa()
	{
		try{
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/techbuz","root","");
		}
		catch(Exception e)
		{
			System.out.println("deu ruim");
		}
	}
	
	public boolean cadastrarEmpresaBD(Empresa a, int opcode)
	{
		//1 fornecedor
		//2 matriz empresa
		//3 oficina
		//4 todos
		try{
			
			String query = "insert into empresa(cnpj, nome, email, razao_social, tipo) values(?,?)";
			PreparedStatement stmt = con.prepareStatement(query);
			
			stmt.setString(1, a.getCnpj());
			stmt.setString(2, a.getNome());
			stmt.setString(3, a.getEmail());
			stmt.setString(4, a.getRazao_social());
			stmt.setString(5, a.getTipo());
			
			stmt.executeUpdate();
			stmt.close(); 
			con.close();
			}
			catch(Exception e) {
				System.out.println("nao deu certo");
				return false;
			}
			
			return true;
		
	}
	
	public Empresa buscaEmpresaBD(String cnpj, int opcode)
	{
		Empresa a = new Empresa();
		try{
			
		
			String query = "";
			
			switch(opcode)
			{
			
			case 1:

				 query = "select * from fornecedor where cnpj = ?";
			break;
			
			case 2:

				 query = "select * from matriz_empresa where cnpj = ?";
				
			break;
			
			case 3:

				 query = "select * from oficina where cnpj = ?";
				
			break;
			
			case 4:

				 query = "select * from empresa where cnpj = ?";
				
			break;
			}
			
			
			//try codigo errado
			PreparedStatement stmt = con.prepareStatement(query);
			
			stmt.setString(1, cnpj);
			
			ResultSet resultado  = stmt.executeQuery();
			
			while(resultado.next()) {
			a.setCnpj(resultado.getString("cnpj"));
			a.setNome(resultado.getString("nome"));
			a.setEmail(resultado.getString("email"));
			a.setRazao_social(resultado.getString("razao_social"));
			}
			resultado.close();
			stmt.close(); 
			con.close();
			}
			catch(Exception e) {
				System.out.println("nao deu certo");
			//	return false;
			}
			
		return a;
			//return true;
		
		
	}
	
	public boolean removerEmpresaBD(String cnpj)
	{
		

		try{
		
		
		String query = "delete from empresa where cnpj = ?";
		PreparedStatement stmt = con.prepareStatement(query);
		
		stmt.setString(1, cnpj);
		
		
		stmt.executeUpdate();
		stmt.close(); 
		con.close();
		}
		catch(Exception e) {
			System.out.println("nao deu certo");
			return false;
		}
		
		return true;
	
}
	
	public ArrayList<Empresa> todasEmpresas(int opcode)
	{
	
		ArrayList empresas = new ArrayList<Empresa>();
		
		try {
			String query = "";
			
			switch(opcode)
			{
			
			case 1:

				 query = "select * from fornecedor";
			break;
			
			case 2:

				 query = "select * from matriz_empresa";
				
			break;
			
			case 3:

				 query = "select * from oficina ";
				
			break;
			
			case 4:

				 query = "select * from empresa";
				
			break;
			}
			PreparedStatement stmt = con.prepareStatement(query);
			
			ResultSet resultado = stmt.executeQuery();
			
			Empresa a;
			
			
			while(resultado.next()) {
			
			a = new Empresa();
			a.setCnpj(resultado.getString("cnpj"));
			a.setNome(resultado.getString("nome"));
			a.setEmail(resultado.getString("email"));
			a.setRazao_social(resultado.getString("razao_social"));
			
			empresas.add(a);
			
			}
			resultado.close();
			stmt.close(); 
			con.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("deu ruim");
		}
		
		
		
		return empresas;
		
		
	}
	
	public boolean cadastrarContrato()
	{
		
	}

	public boolean alterarContrato()
	{
		
	}
	
	public boolean excluirContrato()
	
	{
		
	}
	

}
