package Repositorio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Interfaces.IRepositorioFuncionario;
import beans.Empresa;
import beans.Funcionario;
import Interfaces.IRepositorioFuncionario;

public class RepositorioFuncionario  implements IRepositorioFuncionario{
	
	
	Connection con;
	
	private static IRepositorioFuncionario instance;
	
	public static synchronized IRepositorioFuncionario getInstance()
	{
		if(instance == null)
		{
		
			instance = new RepositorioFuncionario();
		}
		
		return instance;
	}
	
	
	private RepositorioFuncionario()
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
	public boolean cadastrarFuncionarioBD(Funcionario a)
	{
			try{
			
			
			
			String query = "insert into funcionario(cpf, nome, nascimento, identidade, sexo, foto, email, fone_1, fone_2, ativo, data_admissao, disponibilidade) values(?,?, ?, ?, ?, ?,?, ?, ?, ?, ?, ? )";
			PreparedStatement stmt = con.prepareStatement(query);
			//AJEITAR AQUI
			stmt.setString(2, a.getNome());
			stmt.setString(1, a.getCpf());
			stmt.setString(4, a.getIdentidade());
			stmt.setString(7, a.getEmail());
			stmt.setString(8, a.getFone_1());
			stmt.setString(9, a.getFone_2());
			stmt.setString(6, a.getFoto());
			stmt.setString(5, ""+a.getSexo());
			stmt.setString(12, ""+a.getDisponibilidade());
			stmt.setString(10, ""+a.getAtivo());
			stmt.setDate(3, a.getNascimento());
			stmt.setDate(11, a.getData_admissao());
			
			
			
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
	
	public Funcionario buscaFuncionarioBD(String cpf)
	{
		Funcionario a = new Funcionario();
		try{
			
			
			String query = "select * from funcionario where cpf = ?";
			PreparedStatement stmt = con.prepareStatement(query);
			
			stmt.setString(1, cpf);

			
			
	
			
			ResultSet resultado  = stmt.executeQuery();
			
			while(resultado.next()) {
				
		
			a.setAtivo(resultado.getString("ativo").charAt(0));
			a.setCpf(resultado.getString("cpf"));
			a.setData_admissao(resultado.getDate("data_admissao"));
			a.setDisponibilidade((resultado.getString("disponibilidade").charAt(0)));
			a.setEmail((resultado.getString("email")));
			a.setFone_1((resultado.getString("fone_1")));
			a.setFone_2((resultado.getString("fone_2")));
			a.setFoto((resultado.getString("foto")));
			a.setIdentidade((resultado.getString("identidade")));
			a.setNascimento(resultado.getDate("nascimento"));
			a.setNome((resultado.getString("nome")));
			a.setSexo((resultado.getString("sexo").charAt(0)));
			
			
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
	
	
	public ArrayList<Funcionario> todosFuncionariosBD( int opcode)
	{
		//1 ativos
		//2 inativos
		//3 disponiveis
		//4 afastados
		
		Funcionario a = new Funcionario();
		ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
		try{
		
			String query ="";
			if(opcode == 1) {
			 query = "select * from funcionario where ativo = 'S'";
			}//COM OU SEM ASPAS
			if(opcode == 2) {
				 query = "select * from funcionario where ativo = 'N";
				}
			if(opcode == 3) {
				query = "select * from funcionario where disponibilidade = 'S";
				}
			if(opcode == 4) {
				query = "select * from funcionario join afastamento on afastamento.funcionario_cpf = funcionario.cpf";
			}
			
			
			try {
			PreparedStatement stmt = con.prepareStatement(query);
					
			ResultSet resultado  = stmt.executeQuery();
			
			while(resultado.next()) {
				
			a = new Funcionario();
			//a.setCnpj(resultado.getString("cnpj"));
			a.setAtivo(resultado.getString("ativo").charAt(0));
			a.setCpf(resultado.getString("cpf"));
			a.setData_admissao(resultado.getDate("data_admissao"));
			a.setDisponibilidade((resultado.getString("disponibilidade").charAt(0)));
			a.setEmail((resultado.getString("email")));
			a.setFone_1((resultado.getString("fone_1")));
			a.setFone_2((resultado.getString("fone_2")));
			a.setFoto((resultado.getString("foto")));
			a.setIdentidade((resultado.getString("identidade")));
			a.setNascimento(resultado.getDate("nascimento"));
			a.setNome((resultado.getString("nome")));
			a.setSexo((resultado.getString("sexo").charAt(0)));
			
			
			}
			resultado.close();
			stmt.close(); 
			con.close();
			}
			catch(Exception e)
			{
				System.out.println("opcode errado");
			}
			}
			catch(Exception e) {
				System.out.println("nao deu certo");
			
			}
			
		return funcionarios;
			
		
		
	}
	
	public boolean removerFuncionarioBD(String cpf)
	{
		

		try{
		
	
		String query = "delete from funcionario where cpf = ?";
		PreparedStatement stmt = con.prepareStatement(query);
		
		stmt.setString(1, cpf);
		
		
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
	
	public boolean updateFuncionarioBD( Funcionario novo)//talvez não esteja errado, se sim, fazer set pra tudo
	{ 
	
	try {
		removerFuncionarioBD(novo.getCpf());
		cadastrarFuncionarioBD(novo);
	}
	catch(Exception e)
	{
		return false;
		
	}
		return true;
	//Posso fazer isso porque quando vai ter o mesmo código e tudo
		//talvez não desse com auto_increment
	}


}
