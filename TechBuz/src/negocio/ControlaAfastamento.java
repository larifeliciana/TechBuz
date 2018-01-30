package negocio;

import java.util.ArrayList;

import Interfaces.IRepositorioAfastamento;
import Interfaces.IRepositorioOcorrencia;
import Repositorio.RepositorioAfastamento;
import Repositorio.RepositorioOcorrencia;
import beans.Afastamento;
import beans.TipoAfastamento;

public class ControlaAfastamento {

	IRepositorioAfastamento afastamentos;
	
	public ControlaAfastamento()
	{
		afastamentos = RepositorioAfastamento.getInstance();
	}
	
	
	public String cadastrarAfastamento(Afastamento a)
	{
		return afastamentos.cadastrarAfastamento(a);
	}
	public boolean removerAfastamento(int cod)
	{
		return afastamentos.removerAfastamento(cod);
	}
	public boolean checaEncerraAfastamento(int cod)
	{
		return afastamentos.checaEncerraAfastamento(cod);
	}
	public boolean EncerraAfastamento(int cod)
	{
		return afastamentos.EncerraAfastamento(cod);
	}
	public Afastamento buscarAfastamento (int cod)
	{
		return afastamentos.buscarAfastamento(cod);
		
	}
	public ArrayList<Afastamento> listarAfastamentoFuncionario(String cpf)
	{
		return afastamentos.listarAfastamentoFuncionario(cpf);
	}
	
	public String adicionarTipoAfastamento(String descricao)
	{
		return afastamentos.adicionarTipoAfastamento(descricao);
	}
	
	public String removerTipoAfastamento(int cod)
	{
		return afastamentos.removerTipoAfastamento(cod);
	}
	public ArrayList<TipoAfastamento> listarTipoAfastamento()
	{
		return afastamentos.listarTipoAfastamento();
	}
}
