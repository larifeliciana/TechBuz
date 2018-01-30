package Interfaces;

import java.util.ArrayList;

import beans.Afastamento;
import beans.TipoAfastamento;

public interface IRepositorioAfastamento {

	
	public String cadastrarAfastamento(Afastamento a);
	public boolean removerAfastamento(int cod);
	public boolean checaEncerraAfastamento(int cod);
	public boolean EncerraAfastamento(int cod);
	public Afastamento buscarAfastamento (int cod);
	public ArrayList<Afastamento> listarAfastamentoFuncionario(String cpf);
	public String adicionarTipoAfastamento(String descricao);
	public String removerTipoAfastamento(int cod);
	public ArrayList<TipoAfastamento> listarTipoAfastamento();
}
