package Repositorio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import beans.Funcionario;

public class Teste {

	public Teste()
	{
		
	}

	public ArrayList<Funcionario> todosFuncionariosAtivosBD(int opcode)
	{ArrayList<Funcionario> funcionarios =  new ArrayList<Funcionario>();
		try {

			
				Class.forName("com.mysql.jdbc.Driver");
			
				
				Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/techbuz","root","");
			
			String query = "call listarAtivos(1)";
			System.out.println("12312323");
		PreparedStatement stmt = con.prepareStatement(query);

		ResultSet resultado = stmt.executeQuery();
		
		Funcionario a = new Funcionario();
		
		while(resultado.next()) {
			
			a.setAtivo(resultado.getString("funcionario.ativo"));
			a.setCpf(resultado.getString("funcionario.cpf"));
			a.setData_admissao(resultado.getDate("funcionario.data_admissao"));
			a.setDisponibilidade((resultado.getString("funcionario.disponibilidade")));
			a.setEmail((resultado.getString("funcionario.email")));
			a.setFone_1((resultado.getString("funcionario.fone_1")));
			a.setFone_2((resultado.getString("funcionario.fone_2")));
			a.setFoto((resultado.getString("funcionario.foto")));
			a.setIdentidade((resultado.getString("funcionario.identidade")));
			a.setNascimento(resultado.getDate("funcionario.nascimento"));
			a.setNome((resultado.getString("funcionario.nome")));
			a.setSexo((resultado.getString("funcionario.sexo")));
			a.setCnh(resultado.getString("motorista.cnh"));
		
			
			funcionarios.add(a);
			}
			resultado.close();
			stmt.close(); 
			con.close();
			}
		
		catch(Exception e)
		{
			System.out.println("deu erro");
		}
		
		
		return funcionarios;
		}		
	
		
	
	

}
