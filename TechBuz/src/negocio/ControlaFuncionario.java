package negocio;

import java.util.ArrayList;

import Interfaces.IRepositorioFuncionario;
import Repositorio.RepositorioFuncionario;
import beans.Funcionario;

public class ControlaFuncionario {
	
	IRepositorioFuncionario funcionarios;
	
	public ControlaFuncionario()
	{
		funcionarios = RepositorioFuncionario.getInstance();
	}
	
	
	public boolean cadastrarFuncionario(Funcionario a)
	{
		return funcionarios.cadastrarFuncionarioBD(a);		
	
	}
	
	public boolean removerFuncionario(String cpf)
	{
		
		return funcionarios.removerFuncionarioBD(cpf);
	}
	
	public Funcionario buscarFuncionario(String cpf)
	{
		return funcionarios.buscaFuncionarioBD(cpf);
	}
	
	public ArrayList<Funcionario> retornarAtivos()
	{
		return funcionarios.todosFuncionariosBD(1);
	}
	
	public ArrayList<Funcionario> retornaInativos()
	{
		return funcionarios.todosFuncionariosBD(2);
	}
	
	public ArrayList<Funcionario> retornaDisponiveis()
	{
		return funcionarios.todosFuncionariosBD(3);
	}
	
	public ArrayList<Funcionario> retornaAfastados()
	{
		return funcionarios.todosFuncionariosBD(4);
	}

	public boolean checarDisponibilidade(String cpf)
	
	{
		if (funcionarios.buscaFuncionarioBD(cpf).getDisponibilidade() == 'S')
			return true;
		
		return false;
	}


	
}
