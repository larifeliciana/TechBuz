package Interfaces;

import java.util.ArrayList;

import beans.Funcionario;

public interface IRepositorioFuncionario {

	
	public abstract boolean cadastrarFuncionarioBD(Funcionario a);
	public abstract Funcionario buscaFuncionarioBD(String cpf);
	public abstract ArrayList<Funcionario> todosFuncionariosBD(int opcode);//1 ativos 	//2 inativos 	//3 disponiveis 	//4 afastados 	
	public abstract boolean removerFuncionarioBD(String cpf);
	public abstract boolean updateFuncionarioBD(Funcionario novo);
	
	
}
