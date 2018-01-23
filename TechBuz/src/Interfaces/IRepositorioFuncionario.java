package Interfaces;

import java.util.ArrayList;

import beans.Endereco;
import beans.Funcionario;

public interface IRepositorioFuncionario {

	
	public abstract String cadastrarFuncionarioBD(Funcionario a, Endereco b, int opcode, String cnh);
	public abstract Funcionario buscaFuncionarioBD(String cpf, int opcode);
	public abstract ArrayList<Funcionario> todosFuncionariosAtivosBD(int opcode);//1 ativos 	//2 inativos 	//3 disponiveis 	//4 afastados 	
	public abstract  ArrayList<Funcionario> todosFuncionariosInativosBD( int opcode);
	public abstract ArrayList<Funcionario> todosFuncionariosDisponiveisBD( int opcode);
	public abstract boolean removerFuncionarioBD(String cpf, int opcode);
	public abstract boolean updateFuncionarioBD(Funcionario novo);
	public abstract ArrayList<Funcionario> buscaFuncionarioNomeBD(String nome, int i);
	
}
