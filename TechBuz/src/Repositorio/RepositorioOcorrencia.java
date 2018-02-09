package Repositorio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import Interfaces.IRepositorioFuncionario;
import Interfaces.IRepositorioOcorrencia;
import beans.Funcionario;
import beans.Ocorrencia;

public class RepositorioOcorrencia implements IRepositorioOcorrencia {

	Connection con;

	private static IRepositorioOcorrencia instance;

	public static synchronized IRepositorioOcorrencia getInstance()
	{


		if(instance == null)
		{

			instance = new RepositorioOcorrencia();
		}

		return instance;
	}


	private RepositorioOcorrencia()
	{
		con = Conectar.getInstance().getCon();

	}
	
	public String cadastrarOcorrencia(Ocorrencia nova, int opcode)
	{
		try
		{
			String query = "call adicionarOcorrencia( ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setDate(1, nova.getData_ocorrencia());
			stmt.setString(2, nova.getStatus_ocorrencia());
			stmt.setString(3, null);

			stmt.setString(4,  nova.getFuncionario_cpf());
			stmt.setString(5, nova.getJustificativa());

			if(opcode == 2)
			stmt.setTime(6, nova.getHorario());
		
			else 
				stmt.setTime(6, null);

			if(opcode == 3) {
			stmt.setString(7, nova.getMotivo());
			stmt.setFloat(8, nova.getValor());
			}
			else {
			stmt.setString(7,null);
			stmt.setFloat(8, 0);
			}
			

			stmt.setInt(9, opcode);

			System.out.println(nova.getData_ocorrencia());
			System.out.println(nova.getStatus_ocorrencia());
		
			stmt.executeUpdate();



			stmt.close();
			
		}catch(Exception e)
		{
			return "Ocorrência não pode ser cadastrada";
		}
		
		return "Ocorrência cadastrada com sucesso";
	}
	
	public boolean removerOcorrencia(int codigo_ocorrencia, int opcode)
	{
		try {
			
			String query = "call removerOcorrencia(?, ?)";
			

			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setInt(1, codigo_ocorrencia);
			stmt.setInt(2, opcode);

			stmt.executeUpdate();
			stmt.close(); 

			
		}catch(Exception e)
		{
			return false;
		}
		
		return true;
	}
	/*
	public String alterarOcorrencia()
	{
		
	}
	*/
	public Ocorrencia buscarOcorrencia(int cod, int opcode)
	{
		Ocorrencia a = new Ocorrencia();
		ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
		try{
			String query="";

			query = "call buscarOcorrencia(?, ?)";
			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setInt(1, cod);
			stmt.setInt(2, opcode);

			ResultSet resultado  = stmt.executeQuery();

			
			while(resultado.next()) {
			
				a.setData_ocorrencia(resultado.getDate("ocorrencia.data_ocorrencia"));
				
				a.setFuncionario_cpf(resultado.getString("ocorrencia.funcionario_cpf"));
				if(opcode == 2)
				a.setHorario(resultado.getTime("atraso.horario"));
	
				a.setJustificativa(resultado.getString("ocorrencia.justificativa"));
				
				if(opcode == 3)
				{
					a.setMotivo(resultado.getString("multa.motivo"));
					a.setValor(resultado.getFloat("multa.valor"));
				}
				
				
				a.setStatus_ocorrencia(resultado.getString("ocorrencia.status_ocorrencia"));
				
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

	public String acharTipo(int codigo_ocorrencia)
	{
		Ocorrencia a;
		
		
		a = this.buscarOcorrencia(codigo_ocorrencia, 1);
		if(a.getData_ocorrencia()!=null)
			return "Falta";
		
		
		a = this.buscarOcorrencia(codigo_ocorrencia, 2);
		if(a.getData_ocorrencia()!=null)
			return "Atraso";
		
		a = this.buscarOcorrencia(codigo_ocorrencia, 3);
		if(a.getData_ocorrencia()!=null)
			return "Multa";
		
		return "";
		
		
	}	public ArrayList<Ocorrencia> listarOcorrenciasFuncionario(String cpf)
	{
		ArrayList<Ocorrencia> ocorrencias = new ArrayList<Ocorrencia>();
		Ocorrencia a = new Ocorrencia();
		try {
			String query = "call listarOcorrenciaFuncionario(?)";

			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setString(1, cpf);

			ResultSet resultado  = stmt.executeQuery();

			while(resultado.next())
			{
				a = new Ocorrencia();
			
				
				a.setCod(resultado.getInt("ocorrencia.codigo_ocorrencia"));
				
				System.out.println(a.getCod());
				a.setTipo(acharTipo(a.getCod()));

				a.setData_ocorrencia(resultado.getDate("ocorrencia.data_ocorrencia"));
				a.setFuncionario_cpf(resultado.getString("ocorrencia.funcionario_cpf"));
			
				
				
				a.setJustificativa(resultado.getString("ocorrencia.justificativa"));
				
				a.setStatus_ocorrencia(resultado.getString("ocorrencia.status_ocorrencia"));
				ocorrencias.add(a);
				
				};
			resultado.close();
			stmt.close();
		
		}catch(Exception e)
		{
			System.out.println("nao foi possivel listar");
			return null;
		}
		
		return ocorrencias;
		
	}
	}
