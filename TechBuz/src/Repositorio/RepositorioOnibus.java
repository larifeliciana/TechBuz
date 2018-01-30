package Repositorio;
import java.sql.*;
import java.util.ArrayList;

import Interfaces.IRepositorioFuncionario;
import Interfaces.IRepositorioOnibus;
import beans.Acessorio;
import beans.Frota;
import beans.OcorrenciaOnibus;
//import com.mysql.jdbc.*;
import beans.Onibus;
import beans.Peca;

public class RepositorioOnibus implements IRepositorioOnibus{



	Connection con;

	private static IRepositorioOnibus instance;

	public static synchronized IRepositorioOnibus getInstance()
	{


		if(instance == null)
		{

			instance = new RepositorioOnibus();
		}

		return instance;
	}


	private RepositorioOnibus()
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


	public String cadastrarOnibusBD(Onibus a)
	{
		try{


			String query = "insert into onibus(placa, tipo, operacao, data_inclusao, disponibilidade, status_alocacao, num_sentados, cod_frota, ano) values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setString(1, a.getPlaca());
			stmt.setString(2, a.getTipo());
			stmt.setString(3, a.getOperacao());
			stmt.setDate(4, a.getData_inclusao());
			stmt.setString(5,""+a.getDisponibilidade());
			stmt.setString(6, ""+a.getStatus_alocacao());
			stmt.setInt(7, a.getSentado());
			stmt.setInt(8, a.getCod_frota());
			stmt.setInt(9, a.getAno());


			stmt.executeUpdate();
			stmt.close(); 
		}
		catch(Exception e) {
			System.out.println("nao deu certo");
			return "Erro ao inserir onibus";
		}

		return "Onibus inserido com sucesso";

	}

	public Onibus buscaOnibusBD(String placa)
	{
		Onibus a = new Onibus();
		try{



			String query = "select * from onibus where placa = ?";
			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setString(1, placa);



			ResultSet resultado  = stmt.executeQuery();
			while(resultado.next()) {
				a.setAno(resultado.getInt("ano"));
				a.setCod_frota(resultado.getInt("cod_frota"));
				a.setData_inclusao(resultado.getDate("data_inclusao"));
				a.setDisponibilidade(resultado.getString("disponibilidade").charAt(0)); //char 
				a.setOperacao(resultado.getString("operacao"));
				a.setPlaca(resultado.getString("placa"));
				a.setSentado(resultado.getInt("num_sentados"));
				a.setStatus_alocacao(resultado.getString("status_alocacao").charAt(0)); //char
				a.setTipo(resultado.getString("tipo"));
			}


			resultado.close();
			stmt.close(); 
		}
		catch(Exception e) {
			System.out.println("nao deu certo");
			//	return false;
		}

		return a;
		//return true;


	}

	public boolean removerOnibusBD(String placa)
	{


		try{

			String query = "delete from onibus where placa = ?";
			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setString(1, placa);


			stmt.executeUpdate();
			stmt.close(); 
		}
		catch(Exception e) {
			System.out.println("nao deu certo");
			return false;
		}

		return true;

	}

	public ArrayList<Onibus> listarOnibus()
	{
		ArrayList<Onibus> onibus = new ArrayList<Onibus>();


		Onibus a = new Onibus();
		try{



			String query = "select * from onibus";
			PreparedStatement stmt = con.prepareStatement(query);


			ResultSet resultado  = stmt.executeQuery();

			while(resultado.next()) {

				a = new Onibus();
				a.setAno(resultado.getInt("ano"));
				a.setCod_frota(resultado.getInt("cod_frota"));
				a.setData_inclusao(resultado.getDate("data_inclusao"));
				a.setDisponibilidade(resultado.getString("disponibilidade").charAt(0)); //char 
				a.setOperacao(resultado.getString("operacao"));
				a.setPlaca(resultado.getString("placa"));
				a.setSentado(resultado.getInt("num_sentados"));
				a.setStatus_alocacao(resultado.getString("status_alocacao").charAt(0)); //char
				a.setTipo(resultado.getString("tipo"));

				onibus.add(a);
			}

			resultado.close();
			stmt.close(); 
		}
		catch(Exception e) {
			System.out.println("nao deu certo");
			//	return false;
		}

		return onibus;
		//return true;


	}

	public boolean removerFrota(int frota)
	{
			
		
		try {
		
			String query = "delete from frota where cod = ?";
			PreparedStatement stmt = stmt = con.prepareStatement(query);;
			
			
			stmt.setInt(1, frota);
			stmt.executeUpdate();
			
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return false;
		}
		
		return true;
		
		
	}
	public ArrayList<Onibus> listarOnibusFrota(int frota)
	{
		ArrayList<Onibus> onibus = new ArrayList<Onibus>();


		Onibus a = new Onibus();
		try{
			String query = "select * from onibus where cod_frota =?";

			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, frota);

			ResultSet resultado  = stmt.executeQuery();

			while(resultado.next()) {

				a = new Onibus();
				a.setAno(resultado.getInt("ano"));
				a.setCod_frota(resultado.getInt("cod_frota"));
				a.setData_inclusao(resultado.getDate("data_inclusao"));
				a.setDisponibilidade(resultado.getString("disponibilidade").charAt(0)); //char 
				a.setOperacao(resultado.getString("operacao"));
				a.setPlaca(resultado.getString("placa"));
				a.setSentado(resultado.getInt("num_sentados"));
				a.setStatus_alocacao(resultado.getString("status_alocacao").charAt(0)); //char
				a.setTipo(resultado.getString("tipo"));

				onibus.add(a);
			}

			resultado.close();
			stmt.close(); 
		}
		catch(Exception e) {
			System.out.println("nao deu certo");
			//	return false;
		}

		return onibus;
		//return true;


	}


	public ArrayList<Onibus> listarOnibusSentadosMaiorque( int x)
	{
		ArrayList<Onibus> onibus = new ArrayList<Onibus>();


		Onibus a = new Onibus();
		try{



			String query = "select * from onibus where num_sentados > ?";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, x);

			ResultSet resultado  = stmt.executeQuery();

			while(resultado.next()) {

				a = new Onibus();
				a.setAno(resultado.getInt("ano"));
				a.setCod_frota(resultado.getInt("cod_frota"));
				a.setData_inclusao(resultado.getDate("data_inclusao"));
				a.setDisponibilidade(resultado.getString("disponibilidade").charAt(0)); //char 
				a.setOperacao(resultado.getString("operacao"));
				a.setPlaca(resultado.getString("placa"));
				a.setSentado(resultado.getInt("num_sentados"));
				a.setStatus_alocacao(resultado.getString("status_alocacao").charAt(0)); //char
				a.setTipo(resultado.getString("tipo"));

				onibus.add(a);
			}

			resultado.close();
			stmt.close(); 
		}
		catch(Exception e) {
			System.out.println("nao deu certo");
			//	return false;
		}

		return onibus;
		//return true;


	}

	public ArrayList<Onibus> listarOnibusNaoAlocados()
	{
		ArrayList<Onibus> onibus = new ArrayList<Onibus>();


		Onibus a = new Onibus();
		try{



			String query = "select * from onibus where status_alocacao='N'";
			PreparedStatement stmt = con.prepareStatement(query);


			ResultSet resultado  = stmt.executeQuery();

			while(resultado.next()) {

				a = new Onibus();
				a.setAno(resultado.getInt("ano"));
				a.setCod_frota(resultado.getInt("cod_frota"));
				a.setData_inclusao(resultado.getDate("data_inclusao"));
				a.setDisponibilidade(resultado.getString("disponibilidade").charAt(0)); //char 
				a.setOperacao(resultado.getString("operacao"));
				a.setPlaca(resultado.getString("placa"));
				a.setSentado(resultado.getInt("num_sentados"));
				a.setStatus_alocacao(resultado.getString("status_alocacao").charAt(0)); //char
				a.setTipo(resultado.getString("tipo"));

				onibus.add(a);
			}

			resultado.close();
			stmt.close(); 
		}
		catch(Exception e) {
			System.out.println("nao deu certo");
			//	return false;
		}

		return onibus;
		//return true;


	}


	public String empresaNome(String cnpj)
	{
		String nova = "";
		try {
			String query = "select nome from empresa where cnpj = ?";
			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setString(1, cnpj);
			ResultSet resultado = stmt.executeQuery();
			
			
			while (resultado.next())
			{
				nova =  resultado.getString("nome");
				
			}
			
		}catch(Exception e)
		{
			System.out.println("erro nome");
		}
		
		return nova;
	}
	
	public Frota buscarFrota(String cnpj)
	{
		Frota a = new Frota();
		try{



			String query = "select * from frota where matriz_empresa_cnpj = ?";
			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setString(1, cnpj);
			ResultSet resultado  = stmt.executeQuery();
			while(resultado.next()) {

				a = new Frota();
				
			
				a.setDescricao(resultado.getString("desccricao"));
				a.setEmpresa_cnpj(resultado.getString("matriz_empresa_cnpj"));
				a.setIdade_media(resultado.getInt("idade_media"));
				a.setNumero_onibus(resultado.getInt("numero_onibus"));
				a.setCod(resultado.getInt("cod"));
				a.setEmpresa(this.empresaNome(a.getEmpresa_cnpj()));
				
			}

			resultado.close();
			stmt.close(); 
		}
		catch(Exception e) {
			System.out.println("nao deu certo");
			//	return false;
		}

		return a;
	}
	public ArrayList<Frota> listarFrotas()
	{
		ArrayList<Frota> onibus = new ArrayList<Frota>();


		Frota a = new Frota();
		try{



			String query = "select * from frota";
			PreparedStatement stmt = con.prepareStatement(query);

			
			ResultSet resultado  = stmt.executeQuery();
			while(resultado.next()) {

				a = new Frota();
				
			
				a.setDescricao(resultado.getString("desccricao"));
				a.setEmpresa_cnpj(resultado.getString("matriz_empresa_cnpj"));
				a.setIdade_media(resultado.getInt("idade_media"));
				a.setNumero_onibus(resultado.getInt("numero_onibus"));
				a.setCod(resultado.getInt("cod"));
				a.setEmpresa(this.empresaNome(a.getEmpresa_cnpj()));
				onibus.add(a);
			}

			resultado.close();
			stmt.close(); 
		}
		catch(Exception e) {
			System.out.println("nao deu certo");
			//	return false;
		}

		return onibus;
		//return true;
	}




	public String cadastrarOcorrenciaOnibus(OcorrenciaOnibus a)

	{

		try {
			String query = "insert into ocorrencia_onibus (data_ocorrencia, descricao, tipo, obs, endereco_cep, endereco_numero"
					+ ", registro, onibus_placa, vistoria_seq) values(?,?,?,?,?,?,?,?,?)";
			PreparedStatement stmt = con.prepareStatement(query);


			stmt.setDate(1, a.getData_ocorrencia());
			stmt.setString(2, a.getDescricao());
			stmt.setString(3, a.getTipo());
			stmt.setString(4, a.getObs());
			stmt.setString(5, a.getEndereco_cep());
			stmt.setString(6, a.getEndereco_numero());
			stmt.setString(7, a.getRegistro());
			stmt.setString(8, a.getOnibus_placa());
			stmt.setInt(9, a.getVistoria_seq());

			stmt.executeUpdate();

			stmt.close();

		}catch(Exception e)
		{
			return "Erro ao cadastrar Ocorrencia";
		}
		return "Ocorrencia cadastrada";
	}

	public boolean removerOcorrenciaOnibus(int cod)
	{
		String query = "Delete from ocorrencia_onibus where codigo = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setInt(1, cod);

			stmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
			return false;
		}

		return true;


	}
	/*
	public String alterarOcorrenciaOnibus()
	{

	}*/

	public OcorrenciaOnibus buscarOcorrenciaOnibus(int cod)
	{
		OcorrenciaOnibus a = new OcorrenciaOnibus();
		String query = "select * from ocorrencia_onibus where codigo = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setInt(1, cod);
			ResultSet resultado = stmt.executeQuery();

			while(resultado.next())
			{
				a.setCodigo(resultado.getInt("codigo"));
				a.setData_ocorrencia(resultado.getDate("data_ocorrencia"));
				a.setDescricao(resultado.getString("descricao"));
				a.setEndereco_cep(resultado.getString("endereco_cep"));
				a.setEndereco_numero(resultado.getString("endereco_numero"));
				a.setObs(resultado.getString("obs"));
				a.setOnibus_placa(resultado.getString("onibus_placa"));
				a.setRegistro(resultado.getString("registro"));
				a.setTipo(resultado.getString("tipo"));
				a.setVistoria_seq(resultado.getInt("vistoria_seq"));



			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return a;



	}

	public ArrayList<OcorrenciaOnibus> listarOcorrenciaOnibus(String onibus_placa)
	{
		OcorrenciaOnibus a = new OcorrenciaOnibus();
		ArrayList<OcorrenciaOnibus> onibus = new ArrayList<OcorrenciaOnibus>();

		String query = "select * from ocorrencia_onibus where onibus_placa = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, onibus_placa);

			ResultSet resultado = stmt.executeQuery();

			while(resultado.next())
			{
				a = new OcorrenciaOnibus();
				a.setCodigo(resultado.getInt("codigo"));
				a.setData_ocorrencia(resultado.getDate("data_ocorrencia"));
				a.setDescricao(resultado.getString("descricao"));
				a.setEndereco_cep(resultado.getString("endereco_cep"));
				a.setEndereco_numero(resultado.getString("endereco_numero"));
				a.setObs(resultado.getString("obs"));
				a.setOnibus_placa(resultado.getString("onibus_placa"));
				a.setRegistro(resultado.getString("registro"));
				a.setTipo(resultado.getString("tipo"));
				a.setVistoria_seq(resultado.getInt("vistoria_seq"));
				onibus.add(a);


			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return onibus;

	}
/////////////////////////////////////////////////////////////////////////////////////
	

	public String cadastrarAcessorio(Acessorio a)

	{

		try {
			String query = "insert into acessorio(descricao, marca, estado) values(?,?,?) ";
			PreparedStatement stmt = con.prepareStatement(query);


			stmt.setString(1, a.getDescricao());
			stmt.setString(2, a.getMarca());
			stmt.setString(3, a.getEstado());
			stmt.executeUpdate();

			stmt.close();

		}catch(Exception e)
		{
			return "Erro ao cadastrar Acessorio";
		}
		return "Acessorio cadastrada";
	}

	public boolean removerAcessorio(int cod)
	{
		String query = "Delete from acessorio where codigo = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setInt(1, cod);

			stmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
			return false;
		}

		return true;


	}
	/*
	public String alterarOcorrenciaOnibus()
	{

	}*/

	public Acessorio buscarAcessorio(int cod)
	{
		Acessorio a = new Acessorio();
		String query = "select * from acessorio where codigo = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setInt(1, cod);
			ResultSet resultado = stmt.executeQuery();

			while(resultado.next())
			{
				a.setCodigo(resultado.getInt("codigo"));
				a.setDescricao(resultado.getString("descricao"));
				a.setEstado(resultado.getString("estado"));
				a.setMarca(resultado.getString("marca"));



			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return a;



	}

	public ArrayList<Acessorio> listarAcessorioOnibus(String onibus_placa)
	{
		Acessorio a = new Acessorio();
		ArrayList<Acessorio> acessorio = new ArrayList<Acessorio>();
		

		String query = "select * from acessorio_de join acessorio on codigo = acessorio_codigo where onibus_placa = ?";
		
		try {
			
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, onibus_placa);

			ResultSet resultado = stmt.executeQuery();

			while(resultado.next())
			{

				a = new Acessorio();
				
				a.setCodigo(resultado.getInt("acessorio.codigo"));
				a.setDescricao(resultado.getString("acessorio.descricao"));
				a.setEstado(resultado.getString("acessorio.estado"));
				a.setMarca(resultado.getString("acessorio.marca"));

				
				acessorio.add(a);
			}
			
			
			
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return acessorio;

	}
	
	public ArrayList<Acessorio> listarAcessoriosDisponiveis()
	{
		

		
			Acessorio a = new Acessorio();
			ArrayList<Acessorio> acessorio = new ArrayList<Acessorio>();
			

			String query = "select * from acessorio where acessorio.codigo not in (select acessorio_codigo from acessorio_de)";
			
			try {
				
				PreparedStatement stmt = con.prepareStatement(query);
				
				ResultSet resultado = stmt.executeQuery();

				while(resultado.next())
				{

					a = new Acessorio();
					
					a.setCodigo(resultado.getInt("acessorio.codigo"));
					a.setDescricao(resultado.getString("acessorio.descricao"));
					a.setEstado(resultado.getString("acessorio.estado"));
					a.setMarca(resultado.getString("acessorio.marca"));

					
					acessorio.add(a);
				}
				
				
				
			} catch (SQLException e) {

				e.printStackTrace();
			}

			return acessorio;

		}
		
	//////////////////////////////////////////////////////////////////////PECAS
	
	public String cadastrarPeca(Peca a)
	{
		
		
		try {
			String query = "insert into peca(tipo, nome, marca, fornecedor_cnpj, quantidade) values(?,?,?,?,?) ";
			PreparedStatement stmt = con.prepareStatement(query);
			
			stmt.setString(1, a.getTipo());
			stmt.setString(2, a.getNome());
			stmt.setString(3, a.getMarca());
			stmt.setString(4, a.getFornecedor_cnpj());
			stmt.setInt(5, a.getQuantidade());

			
			stmt.close();

		}catch(Exception e)
		{
			return "Erro ao cadastrar Acessorio";
		}
		return "Acessorio cadastrada";
	}
	
	/*
	public boolean alterarPeca()
	{
		
	}
	
	*/
	
	
	public boolean removerPeca(int cod)
	{

		String query = "Delete from peca where cod = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setInt(1, cod);

			stmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
			return false;
		}

		return true;


		
	}
	
	public Peca buscarPeca(int cod)
	{
		
		Peca a = new Peca();
		String query = "select * from peca where cod = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setInt(1, cod);
			ResultSet resultado = stmt.executeQuery();

			while(resultado.next())
			{
				a.setCod(resultado.getInt("cod"));
				a.setFornecedor_cnpj(resultado.getString("fornecedor_cnpj"));
				a.setMarca(resultado.getString("marca"));
				a.setNome(resultado.getString("nome"));
				a.setQuantidade(resultado.getInt("quantidade"));
				a.setTipo(resultado.getString("tipo"));


			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return a;


	}
	public ArrayList<Peca> listarPecasFornecedor(String cnpj)
	{
	
		

		Peca a = new Peca();
		ArrayList<Peca> peca = new ArrayList<Peca>();
		

		String query = "select * from peca where fornecedor_cnpj = ?";
		
		try {
			
			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setString(1, cnpj);
			ResultSet resultado = stmt.executeQuery();
			

			while(resultado.next())
			{

				a = new Peca();
				
				a.setCod(resultado.getInt("cod"));
				a.setFornecedor_cnpj(resultado.getString("fornecedor_cnpj"));
				a.setMarca(resultado.getString("marca"));
				a.setNome(resultado.getString("nome"));
				a.setQuantidade(resultado.getInt("quantidade"));
				a.setTipo(resultado.getString("tipo"));

				
				peca.add(a);
			}
			
			
			
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return peca;

	}
	

}
