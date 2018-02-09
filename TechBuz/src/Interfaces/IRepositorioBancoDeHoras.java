package Interfaces;

import java.sql.Date;
import java.util.ArrayList;

import beans.BancoDeHoras;

public abstract interface IRepositorioBancoDeHoras {

	public abstract String cadastrarBancoDeHoras(BancoDeHoras a);
	public abstract boolean removerBancoDeHoras(Date dia, String funcionario_cpf);
	public abstract boolean alterarBancoDeHoras(int qtd, Date dia, String cpf);
	public abstract BancoDeHoras buscarBancoDeHoras (String cpf, Date dia);
	public abstract ArrayList<BancoDeHoras> listarBancoDeHorasFuncionario(String cpf);
	public abstract ArrayList<BancoDeHoras> listarBancoDeHorasDia(Date dia);
	public abstract int calcular(Date inicio, Date fim, String cpf);
}
