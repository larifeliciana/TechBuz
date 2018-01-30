package negocio;

import java.util.ArrayList;

import Interfaces.IRepositorioEmpresa;
import Interfaces.IRepositorioFuncionario;
import Repositorio.RepositorioEmpresa;
import Repositorio.RepositorioFuncionario;
import beans.Contrato;
import beans.Empresa;
import beans.Endereco;

public class ControlaEmpresa {

	IRepositorioEmpresa empresas;
	
	public ControlaEmpresa()
	{
		empresas = RepositorioEmpresa.getInstance();
	}
	
	
	
	public String cadastrarEmpresaBD(Empresa a,Endereco b, int opcode)
	{
		return empresas.cadastrarEmpresaBD(a, b, opcode);
	}
	
	/////////////////////////////////////////////////////////////////

	public Empresa buscaEmpresaBD(String cnpj, int opcode)
	{
		return empresas.buscaEmpresaBD(cnpj, opcode);
		
	}
	
	public Empresa buscaEmpresaFornecedorBD(String cnpj)
	{
		return empresas.buscaEmpresaBD(cnpj, 1);
		
	}
	
	
	public Empresa buscaEmpresaMatrizBD(String cnpj)
	{
		return empresas.buscaEmpresaBD(cnpj, 2);
		
		
	}
	
	public Empresa buscaEmpresaOficinaBD(String cnpj)
	{
		return empresas.buscaEmpresaBD(cnpj, 3);
		
	}
	
	///////////////////////////////////////////////////
	
	
	
	public boolean removerEmpresaBD(String cnpj, int opcode)
	{
	
		return empresas.removerEmpresaBD(cnpj, opcode);
	}
	
	public boolean removerEmpresaFornecedorBD(String cnpj)
	{
		return empresas.removerEmpresaBD(cnpj, 1);
		
	}
	
	public boolean removerEmpresaMatrizBD(String cnpj)
	{
		
		return empresas.removerEmpresaBD(cnpj, 2);
	}
	public boolean removerEmpresaOficinaBD(String cnpj)
	{
		return empresas.removerEmpresaBD(cnpj, 3);
	}
	
	////////////////////////////////////////////////////////////
	public ArrayList<Empresa> todasEmpresas(int opcode){
		
		return empresas.todasEmpresas(opcode);
	}
	
public ArrayList<Empresa> todasEmpresasFornecedor(){
	
	return empresas.todasEmpresas(1);
	}


public ArrayList<Empresa> todasEmpresasMatriz(){
		
	return empresas.todasEmpresas(2);
	}


public ArrayList<Empresa> todasEmpresasOficina(){
		
	return empresas.todasEmpresas(3);
	}
	
//////////////////////////////////////////////////////////////////

	public boolean cadastrarContrato(Contrato a)
	{
		return empresas.cadastrarContrato(a);
	}
	
	public boolean excluirContrato(String matriz_empresa_cnpj, String oficina_cnpj)
	{
		return empresas.excluirContrato(matriz_empresa_cnpj, oficina_cnpj);
	}

//////////////////////////////////////////////////////////////////////
	public void adicionarTelefone(String telefone, String cnpj)
	{
		empresas.adicionarTelefone(telefone, cnpj);
	}
	
	public int acharTipo(String cnpj)
	{
		return empresas.acharTipo(cnpj);
	}
}
