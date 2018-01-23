package Repositorio;
import java.sql.*;
import java.util.ArrayList;

import Interfaces.IRepositorioEmpresa;
import Interfaces.IRepositorioFuncionario;
import beans.Contrato;
//import com.mysql.jdbc.*;
import beans.Empresa;
import beans.Endereco;

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
		}
		catch(Exception e)
		{
			System.out.println("deu ruim");
		}
	}
	
	public boolean cadastrarEmpresaBD(Empresa a,Endereco b, int opcode)
	{
		//1 fornecedor
		//2 matriz empresa
		//3 oficina
		//4 todos
		try{
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/techbuz","root","");
			
			String query = "call inserirEmpresa(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?);";
			PreparedStatement stmt = con.prepareStatement(query);
			
			stmt.setString(1, a.getCnpj());
			stmt.setString(2, a.getNome());
			stmt.setString(3, a.getEmail());
			stmt.setString(4, a.getRazao_social());
			stmt.setString(5, b.getCep());
			stmt.setString(6,b.getNumero());
			stmt.setString(7, b.getRua());
			stmt.setString(8, b.getBairro());
			stmt.setString(9, b.getCidade());
			stmt.setString(10, b.getEstado());
			stmt.setString(11, b.getComplemento());
			stmt.setString(12, b.getEmpresa_cnpj());
			stmt.setInt(13, opcode);
			
			stmt.executeUpdate();
			stmt.close(); 
			con.close();
			}
			catch(Exception e) {
				System.out.println("nao deu certo inserir empresa");
				return false;
			}
			
			return true;
		
	}
	
	public Empresa buscaEmpresaBD(String cnpj, int opcode)
	{
		Empresa a = new Empresa();
		try{
			
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/techbuz","root","");
			
		
			String query = "";
			
			
				 query = "call buscarEmpresa(?, ?)";
			
			PreparedStatement stmt = con.prepareStatement(query);
			
			stmt.setString(1, cnpj);
			stmt.setInt(2, opcode);
			
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
	
	public boolean removerEmpresaBD(String cnpj, int opcode)
	{
		

		try{
		
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/techbuz","root","");
			
		String query = "call removerEmpresa(?, ?)";
		PreparedStatement stmt = con.prepareStatement(query);
		
		stmt.setString(1, cnpj);
		stmt.setInt(2, opcode);
		
		stmt.executeUpdate();
		stmt.close(); 
		con.close();
		}
		catch(Exception e) {
			System.out.println("nao deu certo remover");
			return false;
		}
		
		return true;
	
}
	
	public ArrayList<Empresa> todasEmpresas(int opcode)
	{
	
		ArrayList empresas = new ArrayList<Empresa>();
		
		try {
			String query = "call listarEmpresas(?);";
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
	
	public boolean cadastrarContrato(Contrato a)
	{
		try
		{
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/techbuz","root","");
			
			
			String query = "call inserirContrato(?,?,?,?,?, ?);";
			PreparedStatement stmt = con.prepareStatement(query);
			
			stmt.setString(2, a.getOficina_cnpj());
			stmt.setString(1, a.getMatriz_empresa_cnpj());
			stmt.setDate(3, a.getDt_inicio());
			stmt.setDate(4, a.getDt_fim());
			stmt.setFloat(5, a.getVl_contrato());
			

			stmt.executeUpdate();
			stmt.close(); 
			con.close();
			
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	//public boolean alterarContrato()
	{
		
	}
	
	public boolean excluirContrato(String matriz_empresa_cnpj, String oficina_cnpj)
	
	{
		try{
			
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/techbuz","root","");
			
		String query = "call removerContrato(?, ?)";
		PreparedStatement stmt = con.prepareStatement(query);
		
		stmt.setString(1, matriz_empresa_cnpj);
		stmt.setString(2, oficina_cnpj);
		
		stmt.executeUpdate();
		stmt.close(); 
		con.close();
		}
		catch(Exception e) {
			System.out.println("nao deu certo removerContrato");
			return false;
		}
		
		return true;
	}
	

}
