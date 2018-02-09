package Repositorio;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

import Interfaces.IRepositorioViagem;
import beans.Viagem;

public class RepositorioViagem implements IRepositorioViagem{


	Connection con;

	private static IRepositorioViagem instance;

	public static synchronized IRepositorioViagem getInstance()
	{


		if(instance == null)
		{

			instance = new RepositorioViagem();
		}

		return instance;
	}


	private RepositorioViagem()
	{
		con = Conectar.getInstance().getCon();

	}


	public boolean checarViagemDiaOnibus(Date dia,String placa)
	{
		String query = "SELECT(viagemOnibusDia(?, ?))";
		int valor = -1;
		try {

			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setDate(1, dia);
			stmt.setString(2, placa);

			ResultSet resultado = stmt.executeQuery();


			while(resultado.next())
			{
				valor = resultado.getInt(1);
			}

		}catch(Exception e)
		{
			e.printStackTrace();
		}
		if(valor==1)
			return true;

		else return false;
	}




	public boolean cadastrarViagem(Viagem a)
	{
		String query = "insert into viagem(onibus_placa, linha_numero, data_hr_min, status_viagem, motorista_cpf, cobrador_cpf)"
				+ " values(?, ?, ?, ?, ?, ?)";

		try {

			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setString(1, a.getPlaca());
			stmt.setString(2, a.getLinha());
			stmt.setTimestamp(3, a.getData_hr_min());
			stmt.setString(4, a.getStatus_viagem());
			stmt.setString(5, a.getMotorista_cpf());
			stmt.setString(6, a.getCobrador_cpf());


			stmt.executeUpdate();

		}catch(Exception e)
		{
			e.printStackTrace();
		}

		return true;
	}

	public boolean removerViagem(String onibus_placa, String linha_numero ,Timestamp data_hr_min)

	{
		String query = "delete from viagem where onibus_placa = ? and linha_numero = ? and data_hr_min = ?";

		try {

			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setString(1,onibus_placa);
			stmt.setString(2, linha_numero);
			stmt.setTimestamp(3, data_hr_min);


			stmt.executeUpdate();

		}catch(Exception e)
		{
			e.printStackTrace();
		}

		return true;

	}

	public boolean alterarViagem(Viagem a, String placa, String linha, Timestamp data_hr_min)
	{
		String query = "update viagem set  onibus_placa = ?, linha_numero = ?, data_hr_min = ?, status_viagem = ?, motorista_cpf = ?, cobrador_cpf =?,"
				+ "receita = ?, meia = ?, inteira = ? , pagantes = ?, nao_pagantes = ?, diferenca_catraca = ?, fiscal_cpf = ?"
				+ " where onibus_placa = ? and linha_numero = ? and data_hr_min = ?"; 

		try {

			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setString(1, a.getPlaca());
			stmt.setString(2, a.getLinha());
			stmt.setTimestamp(3, a.getData_hr_min());
			stmt.setString(4, a.getStatus_viagem());
			stmt.setString(5, a.getMotorista_cpf());
			stmt.setString(6, a.getCobrador_cpf());
			stmt.setFloat(7, a.getReceita());
			stmt.setInt(8, a.getMeia());
			stmt.setInt(9, a.getInteira());
			stmt.setInt(10, a.getPagantes());
			stmt.setInt(11, a.getNao_pagantes());
			stmt.setInt(12, a.getDiferenca_catraca());
			stmt.setString(13, a.getFiscal_cpf());
			stmt.setString(14, placa);
			stmt.setString(15, linha);
			stmt.setTimestamp(16, data_hr_min);
		


			stmt.executeUpdate();
			

		}catch(SQLException e)
		{
			return false;
		}

		return true;
	}

	public ArrayList<Viagem> listarViagemData(Date a)
	{
		Viagem viagem;
		
		ArrayList<Viagem> viagens = new ArrayList<Viagem>();
		
		String query = "select * from viagem where Date(data_hr_min) = ?";
		try {

			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setDate(1, a);
			
			ResultSet resultado = stmt.executeQuery();
			
			while(resultado.next())
			{
				viagem = new Viagem();
				
				viagem.setCobrador_cpf(resultado.getString("cobrador_cpf"));
				viagem.setData_hr_min(resultado.getTimestamp("data_hr_min"));
				LocalTime hora = (viagem.getData_hr_min().toLocalDateTime()).toLocalTime();
				viagem.setHora(Time.valueOf(hora));
				viagem.setDiferenca_catraca(resultado.getInt("diferenca_catraca"));
				viagem.setFiscal_cpf(resultado.getString("fiscal_cpf"));
				viagem.setInteira(resultado.getInt("inteira"));
				viagem.setLinha(resultado.getString("linha_numero"));
				viagem.setMeia(resultado.getInt("meia"));
				viagem.setMotorista_cpf(resultado.getString("motorista_cpf"));
				viagem.setNao_pagantes(resultado.getInt("nao_pagantes"));
				viagem.setOcorrencia_onibus_codigo(resultado.getInt("ocorrencia_onibus_codigo"));
				viagem.setPagantes(resultado.getInt("pagantes"));
				viagem.setPlaca(resultado.getString("onibus_placa"));
				viagem.setReceita(resultado.getInt("receita"));
				viagem.setStatus_viagem(resultado.getString("status_viagem"));
				System.out.println("here");
				viagens.add(viagem);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return viagens;
	}

		public boolean  finalizarViagem(Viagem a)
		{


			String query = "update viagem set receita = ?, meia = ?, inteira = ? , pagantes = ?, nao_pagantes = ?, diferenca_catraca = ?, data_hr_min = ?, fiscal_cpf = ?,"
					+ " status_viagem = ? where onibus_placa = ? and linha_numero = ? and data_hr_min = ?"; 

			try {

				PreparedStatement stmt = con.prepareStatement(query);

				stmt.setFloat(1, a.getReceita());
				stmt.setInt(2, a.getMeia());
				stmt.setInt(3, a.getInteira());
				stmt.setInt(4, a.getPagantes());
				stmt.setInt(5, a.getNao_pagantes());
				stmt.setInt(6, a.getDiferenca_catraca());
				stmt.setTimestamp(7, a.getData_hr_min());
				stmt.setString(8, a.getFiscal_cpf());
				stmt.setString(9, a.getStatus_viagem());
				stmt.setString(10, a.getPlaca());
				stmt.setString(11, a.getLinha());
				stmt.setTimestamp(12,a.getData_hr_min());
			

				System.out.println(a.getData_hr_min());


				stmt.executeUpdate();
				
				stmt.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}

			return true;

		}
	}
