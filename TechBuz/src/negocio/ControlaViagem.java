package negocio;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

import Interfaces.IRepositorioBancoDeHoras;
import Interfaces.IRepositorioViagem;
import Repositorio.RepositorioBancoDeHoras;
import Repositorio.RepositorioViagem;
import beans.Viagem;

public class ControlaViagem {
	
	IRepositorioViagem viagens;
	
	public ControlaViagem()
	{
		viagens = RepositorioViagem.getInstance();
		
		
	}
	
	public boolean checarViagemDiaOnibus(Date dia,String placa)
	{
		return viagens.checarViagemDiaOnibus(dia, placa);
	}
	
	public boolean cadastrarViagem(Viagem a)
	{
		return viagens.cadastrarViagem(a);
	}
	public boolean removerViagem(String onibus_placa, String linha_numero ,Timestamp data_hr_min)
	{
		return viagens.removerViagem(onibus_placa, linha_numero, data_hr_min);
	}
	
	public boolean alterarViagem(Viagem a,  String placa, String linha, Timestamp data_hr_min)
	{
		return viagens.alterarViagem(a, placa, linha, data_hr_min);
	}
	
	public boolean  finalizarViagem(Viagem a)
	{
		return viagens.finalizarViagem(a);
	}
	public ArrayList<Viagem> listarViagemData(Date a)
	{
		return viagens.listarViagemData(a);
	}

}
