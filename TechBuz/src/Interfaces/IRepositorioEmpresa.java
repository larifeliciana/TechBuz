package Interfaces;

import java.util.ArrayList;

import beans.Contrato;
import beans.Empresa;
import beans.Endereco;

public abstract interface IRepositorioEmpresa {

	public abstract String cadastrarEmpresaBD(Empresa a,Endereco b, int opcode);

	public abstract Empresa buscaEmpresaBD(String cnpj, int opcode);
	
	public abstract boolean removerEmpresaBD(String cnpj, int opcode);

	public abstract ArrayList<Empresa> todasEmpresas(int opcode);
	
	public abstract boolean cadastrarContrato(Contrato a);
	
	public abstract boolean excluirContrato(String matriz_empresa_cnpj, String oficina_cnpj);
	
	public abstract void adicionarTelefone(String telefone, String cnpj);
	
	public abstract int acharTipo(String cnpj);
	
}
