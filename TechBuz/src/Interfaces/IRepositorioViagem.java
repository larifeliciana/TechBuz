package Interfaces;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

import beans.Viagem;

public abstract interface IRepositorioViagem {
	
	public abstract  boolean checarViagemDiaOnibus(Date dia,String placa);
	public abstract boolean cadastrarViagem(Viagem a);
	public abstract boolean removerViagem(String onibus_placa, String linha_numero ,Timestamp data_hr_min);
	public abstract boolean alterarViagem(Viagem a,  String placa, String linha, Timestamp data_hr_min);
	public abstract boolean  finalizarViagem(Viagem a);

	public abstract ArrayList<Viagem> listarViagemData(Date a);
}
