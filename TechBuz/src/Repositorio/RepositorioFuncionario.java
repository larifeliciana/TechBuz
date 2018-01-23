package Repositorio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Interfaces.IRepositorioFuncionario;
import beans.Empresa;
import beans.Endereco;
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
			//botar conexão
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/techbuz","root","");


		}
		catch(Exception e)
		{
			System.out.println("erro de classe");
		}

	}
	public String cadastrarFuncionarioBD(Funcionario a, Endereco b, int opcode, String cnh)
	{
		try{

		


			String query = "call inserirFuncionario(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setString(1, a.getCpf());
			if(jaExiste(1, a.getCpf()))
				return "CPF já cadastrado";
			if(!a.getCpf().matches("[0-9]+"))
				return "CPF inválido";
			
			stmt.setString(2, a.getNome());
			stmt.setDate(3, a.getNascimento());
			stmt.setString(4, a.getIdentidade());
			
			if(jaExiste(0, a.getIdentidade()))
				return "Identidade já cadastrada";
			if(!a.getIdentidade().matches("[0-9]+"))
					return "Identidade inválida";
					
			

			stmt.setString(5, a.getSexo());
			stmt.setString(6, a.getFoto());
			stmt.setString(7, a.getEmail());
			if(jaExiste(2, a.getEmail()))
				return "E-mail já em uso";

			stmt.setString(8, a.getFone_1());
			
			if(jaExiste(3, a.getFone_1()))
				return "Celular já em uso";
			if(!a.getFone_1().matches("[0-9]+"))
					return "Celular inválido";
			
			stmt.setString(9, a.getFone_2());
			if(jaExiste(4, a.getFone_2()))
				return "Telefone já em uso";
			if(!a.getFone_2().matches("[0-9]+"))
				return "Telefone inválido";
			

			stmt.setString(10, a.getAtivo());
			stmt.setDate(11, a.getData_admissao());
			stmt.setString(12, a.getDisponibilidade());

			stmt.setString(13, b.getCep());
			if(!b.getCep().matches("[0-9]+"))
				return "CEP inválido";
			
			stmt.setString(14, b.getNumero());
			if(!b.getNumero().matches("[0-9]+"))
				return "Número inválido";
			
			stmt.setString(15, b.getRua());
			stmt.setString(16, b.getBairro());
			stmt.setString(17,  b.getCidade());
			stmt.setString(18, b.getEstado());
			stmt.setString(19, b.getComplemento());
			if(opcode==1)
				stmt.setString(20, cnh);
			if(jaExiste(4, a.getCnh()))
				return "CNH já cadastrado";
			if(!a.getCnh().matches("[0-9]+"))
				return "CNH inválido";
			
			else
				stmt.setString(20, null);
			stmt.setInt(21, opcode);
			stmt.executeUpdate();

			stmt.close(); 
		}
		catch(Exception e) {
			return "erro inserir funcionario";
			
		}

		return "Funcionário cadastrado";

	}

	public boolean jaExiste(int coluna, String valor )
	{


		try{
			

			String query="";

			query = "call jaExiste(?,?)";
			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setInt(1, coluna);
			stmt.setString(2, valor);
			
			ResultSet resultado  = stmt.executeQuery();


			
			while(resultado.next()) {
				System.out.println("ja existe");
				return true;
			}
			
			resultado.close();
			stmt.close(); 
		}
		catch(Exception e) {
			System.out.println("erro checar");
			//	return false;
		}

		return false;

	}
	public Funcionario buscaFuncionarioBD(String cpf, int opcode)
	{
		Funcionario a = new Funcionario();
		try{
		

			String query="";

			query = "call buscarFuncionario(?, ?)";
			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setString(1, cpf);
			stmt.setInt(2, opcode);

			ResultSet resultado  = stmt.executeQuery();



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
			
				if(opcode == 1)
					a.setCnh(resultado.getString("motorista.cnh"));



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
	
	public ArrayList<Funcionario> buscaFuncionarioNomeBD(String nome, int opcode)
	{
		Funcionario a = new Funcionario();
		ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
		try{
			String query="";

			query = "call buscarFuncionarioNome(?, ?)";
			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setString(1, nome);
			stmt.setInt(2, opcode);

			ResultSet resultado  = stmt.executeQuery();

			
			while(resultado.next()) {
				a = new Funcionario();
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
			
				if(opcode == 1)
					a.setCnh(resultado.getString("motorista.cnh"));

				funcionarios.add(a);

			}
			resultado.close();
			stmt.close(); 
		}
		catch(Exception e) {
			System.out.println("erro Buscar Nome");
			//	return false;
		}

		return funcionarios;
		//return true;


	}

	public ArrayList<Funcionario> todosFuncionariosAtivosBD(int opcode)
	{
		ArrayList<Funcionario> funcionarios =  new ArrayList<Funcionario>();
		try {

			String query = "call listarAtivos(?)";

			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setInt(1, opcode);
			ResultSet resultado = stmt.executeQuery();


			Funcionario a = new Funcionario();


			while(resultado.next()) {


				a = new Funcionario();
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

				if(opcode ==1)
					a.setCnh(resultado.getString("motorista.cnh"));
				funcionarios.add(a);

			}
			resultado.close();
			stmt.close(); 
			
			
		}

		catch(Exception e)
		{
			System.out.println("deu erro");
		}


		return funcionarios;
	}		

	public ArrayList<Funcionario> todosFuncionariosInativosBD( int opcode)
	{

		Funcionario a = new Funcionario();
		ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
		try{


			String query ="";

			query = "call listarNAtivos(?)";

			try {
				PreparedStatement stmt = con.prepareStatement(query);
				stmt.setInt(1, opcode);

				ResultSet resultado  = stmt.executeQuery();

				while(resultado.next()) {

					a = new Funcionario();
					//a.setCnpj(resultado.getString("cnpj"));
					a.setAtivo(resultado.getString("ativo"));
					a.setCpf(resultado.getString("cpf"));
					a.setData_admissao(resultado.getDate("data_admissao"));
					a.setDisponibilidade((resultado.getString("disponibilidade")));
					a.setEmail((resultado.getString("email")));
					a.setFone_1((resultado.getString("fone_1")));
					a.setFone_2((resultado.getString("fone_2")));
					a.setFoto((resultado.getString("foto")));
					a.setIdentidade((resultado.getString("identidade")));
					a.setNascimento(resultado.getDate("nascimento"));
					a.setNome((resultado.getString("nome")));
					a.setSexo((resultado.getString("sexo")));


				}
				resultado.close();
				stmt.close(); 
				
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

	public ArrayList<Funcionario> todosFuncionariosDisponiveisBD( int opcode)
	{
		//1 ativos
		//2 inativos
		//3 disponiveis
		//4 afastados


		Funcionario a = new Funcionario();
		ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
		try{

			String query ="";

			query = "call listarDisponiveis(?)";

			try {
				PreparedStatement stmt = con.prepareStatement(query);
				stmt.setInt(1, opcode);

				ResultSet resultado  = stmt.executeQuery();

				while(resultado.next()) {

					a = new Funcionario();
					//a.setCnpj(resultado.getString("cnpj"));
					a.setAtivo(resultado.getString("ativo"));
					a.setCpf(resultado.getString("cpf"));
					a.setData_admissao(resultado.getDate("data_admissao"));
					a.setDisponibilidade((resultado.getString("disponibilidade")));
					a.setEmail((resultado.getString("email")));
					a.setFone_1((resultado.getString("fone_1")));
					a.setFone_2((resultado.getString("fone_2")));
					a.setFoto((resultado.getString("foto")));
					a.setIdentidade((resultado.getString("identidade")));
					a.setNascimento(resultado.getDate("nascimento"));
					a.setNome((resultado.getString("nome")));
					a.setSexo((resultado.getString("sexo")));

					funcionarios.add(a);
				}
				resultado.close();
				stmt.close(); 
				
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
	public boolean removerFuncionarioBD(String cpf, int opcode)
	{


		try{

			String query = "call removerFuncionario(?, ?);";


			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setString(1, cpf);
			stmt.setInt(2, opcode);

			stmt.executeUpdate();
			stmt.close(); 
			
		}
		catch(Exception e) {
			System.out.println("nao deu certo remover");
			return false;
		}

		return true;

	}


	public boolean updateFuncionarioBD(Funcionario novo)//talvez n�o esteja errado, se sim, fazer set pra tudo
	{ 

		return true;
	}


}
