package negocio;

import java.util.ArrayList;

import Interfaces.IRepositorioFuncionario;
import Repositorio.RepositorioFuncionario;
import beans.Endereco;
import beans.Funcionario;
import javafx.scene.image.Image;

public class ControlaFuncionario {
	
	IRepositorioFuncionario funcionarios;
	
	public ControlaFuncionario()
	{
		funcionarios = RepositorioFuncionario.getInstance();
	}
	
	
	public int acharTipo(String cpf)
	{
		return funcionarios.acharTipo(cpf);
	}
	public String cadastrarFuncionarioMotorista(Funcionario a, Endereco b, String cnh)
	{
		return funcionarios.cadastrarFuncionarioBD(a, b,1, cnh);
	
	}
	
	public String cadastrarFuncionarioCobrador(Funcionario a, Endereco b)
	{
		return funcionarios.cadastrarFuncionarioBD(a, b, 2, null);
	
	}
	
	public String cadastrarFuncionarioFiscal(Funcionario a, Endereco b)
	{
		return funcionarios.cadastrarFuncionarioBD(a, b,3 , null);
	
	}
	
	public String cadastrarFuncionarioGerente(Funcionario a, Endereco b)
	{
		return funcionarios.cadastrarFuncionarioBD(a, b, 4, null);
	
	}
	
	//////////////////////////////////////////////////////////////////////////////
	public boolean removerFuncionarioMotorista(String cpf)
	{
		
		return funcionarios.removerFuncionarioBD(cpf, 1);
	}
	
	public boolean removerFuncionarioCobrador(String cpf)
	{
		
		return funcionarios.removerFuncionarioBD(cpf, 2);
	}
	
	public boolean removerFuncionarioFiscal(String cpf)
	{
		
		return funcionarios.removerFuncionarioBD(cpf, 3);
	}
	
	public boolean removerFuncionarioGerente(String cpf)
	{
		
		return funcionarios.removerFuncionarioBD(cpf, 4);
	}
	
	public boolean removerFuncionario(String cpf, int opcode)
	{
		return funcionarios.removerFuncionarioBD(cpf, opcode);
	}
	////////////////////////////////////////////////////////////////
	
public Funcionario buscarFuncionario(String cpf)
	
	{
		return funcionarios.buscaFuncionarioBD(cpf, 0);
	}
	
	public Funcionario buscarFuncionarioMotorista(String cpf)
	
	{
		return funcionarios.buscaFuncionarioBD(cpf, 1);
	}
	
	public Funcionario buscarFuncionarioCobrador(String cpf)
	{
		return funcionarios.buscaFuncionarioBD(cpf, 2);
	}
	
	public Funcionario buscarFuncionarioFiscal(String cpf)
	{
		return funcionarios.buscaFuncionarioBD(cpf, 3);
	}
	
	public Funcionario buscarFuncionarioGerente(String cpf)
	{
		return funcionarios.buscaFuncionarioBD(cpf, 4);
	}
///////////////////////////////////////////////////////////////
public ArrayList<Funcionario> buscarFuncionarioNome(String nome)
	
	{
		return funcionarios.buscaFuncionarioNomeBD(nome, 0);
	}
	
	public ArrayList<Funcionario> buscarFuncionarioMotoristaNome(String nome)
	
	{
		return funcionarios.buscaFuncionarioNomeBD(nome, 1);
	}
	
	public ArrayList<Funcionario> buscarFuncionarioCobradorNome(String nome)
	{
		return funcionarios.buscaFuncionarioNomeBD(nome, 2);
	}
	
	public ArrayList<Funcionario> buscarFuncionarioFiscalNome(String nome)
	{
		return funcionarios.buscaFuncionarioNomeBD(nome, 3);
	}
	
	public ArrayList<Funcionario> buscarFuncionarioGerenteNome(String nome)
	{
		return funcionarios.buscaFuncionarioNomeBD(nome, 4);
	}

	////////////////////////////////////////////////////////////////
	public ArrayList<Funcionario> retornarAtivos()
	{
		return funcionarios.todosFuncionariosAtivosBD(0);
	}
	
	public ArrayList<Funcionario> retornarAtivosMotorista()
	{
		return funcionarios.todosFuncionariosAtivosBD(1);
	}
	
	public ArrayList<Funcionario> retornarAtivosCobrador()
	{
		return funcionarios.todosFuncionariosAtivosBD(2);
	}
	
	public ArrayList<Funcionario> retornarAtivosFiscal()
	{
		return funcionarios.todosFuncionariosAtivosBD(3);
	}
	
	public ArrayList<Funcionario> retornarAtivosGerente()
	{
		return funcionarios.todosFuncionariosAtivosBD(4);
	}
	
	/////////////////////////////////////////////////////////////////
	
	public ArrayList<Funcionario> retornaInativosMotorista()
	{
		return funcionarios.todosFuncionariosInativosBD(1);
	}
	
	public ArrayList<Funcionario> retornaInativosCobrador()
	{
		return funcionarios.todosFuncionariosInativosBD(2);
	}
	
	public ArrayList<Funcionario> retornaInativosFiscal()
	{
		return funcionarios.todosFuncionariosInativosBD(3);
	}
	
	public ArrayList<Funcionario> retornaInativosGerente()
	{
		return funcionarios.todosFuncionariosInativosBD(4);
	}
	////////////////////////////////////////////////////////////
	public ArrayList<Funcionario> retornaDisponiveisMotorista()
	{
		return funcionarios.todosFuncionariosDisponiveisBD(1);
	}
	
	public ArrayList<Funcionario> retornaDisponiveisCobrador()
	{
		return funcionarios.todosFuncionariosDisponiveisBD(2);
	}
	public ArrayList<Funcionario> retornaDisponiveisFiscal()
	{
		return funcionarios.todosFuncionariosDisponiveisBD(3);
	}
	public ArrayList<Funcionario> retornaDisponiveisGerente()
	{
		return funcionarios.todosFuncionariosDisponiveisBD(4);
	}/////////////////////////////////////////////////////////////////////
	
	
	public boolean checarDisponibilidadeMotorista(String cpf)
	{
		if (funcionarios.buscaFuncionarioBD(cpf,1).getDisponibilidade().equals( "S"))
			return true;
		return false;
	}
	public boolean checarDisponibilidadeCobrador(String cpf)
	{
		if (funcionarios.buscaFuncionarioBD(cpf, 2).getDisponibilidade().equals( "S"))
			return true;
		return false;
	}
	public boolean checarDisponibilidadeFiscal(String cpf)
	{
		if (funcionarios.buscaFuncionarioBD(cpf , 3).getDisponibilidade().equals( "S"))
			return true;
		return false;
	}
	public boolean checarDisponibilidadeGerente(String cpf)
	{
		if (funcionarios.buscaFuncionarioBD(cpf, 4).getDisponibilidade().equals( "S"))
			return true;
		return false;
	}


	/////////////////////////////////////////////////////////////////////
	public Endereco buscaEnderecoFuncionario(String cpf)
	{
		return funcionarios.buscaEnderecoFuncionario(cpf);
	}
	public Image pegarFoto(String cpf)
	{
		return funcionarios.pegarFoto(cpf);
	}
}
