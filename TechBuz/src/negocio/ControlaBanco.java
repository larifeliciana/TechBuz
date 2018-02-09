package negocio;

import java.sql.Date;
import java.util.ArrayList;

import Interfaces.IRepositorioBancoDeHoras;
import Repositorio.RepositorioBancoDeHoras;
import beans.BancoDeHoras;

public class ControlaBanco {

	IRepositorioBancoDeHoras banco;
	
	public ControlaBanco()
	{
		banco = RepositorioBancoDeHoras.getInstance();
		
		
	}
	

	public String cadastrarBancoDeHoras(BancoDeHoras a)
	{
		return banco.cadastrarBancoDeHoras(a);
	}
	public boolean removerBancoDeHoras(Date dia, String funcionario_cpf)
	{
		return banco.removerBancoDeHoras(dia, funcionario_cpf);
	}
	public boolean alterarBancoDeHoras(int qtd, Date dia, String cpf)
	{
		return banco.alterarBancoDeHoras(qtd, dia, cpf);
	}
	public BancoDeHoras buscarBancoDeHoras (String cpf, Date dia)
	{
		return banco.buscarBancoDeHoras(cpf, dia);
		
	}
	public ArrayList<BancoDeHoras> listarBancoDeHorasFuncionario(String cpf)
	{
		return banco.listarBancoDeHorasFuncionario(cpf);
	}
	public ArrayList<BancoDeHoras> listarBancoDeHorasDia(Date dia)
	{
		return banco.listarBancoDeHorasDia(dia);
	}
	
	public int calcular(Date inicio, Date fim, String cpf)
	{
		return banco.calcular(inicio, fim, cpf);
	}

}
