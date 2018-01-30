package negocio;

import java.util.ArrayList;

import Interfaces.IRepositorioFuncionario;
import Interfaces.IRepositorioOcorrencia;
import Repositorio.RepositorioFuncionario;
import Repositorio.RepositorioOcorrencia;
import beans.Ocorrencia;


public class ControlaOcorrencia {

	IRepositorioOcorrencia ocorrencias;
	
	public ControlaOcorrencia()
	{
		ocorrencias = RepositorioOcorrencia.getInstance();
	}
	
	public String acharTipo(int codigo_ocorrencia)
	{
		return ocorrencias.acharTipo(codigo_ocorrencia);
	}
	public String cadastrarOcorrencia(Ocorrencia nova, int opcode)
	{
		return ocorrencias.cadastrarOcorrencia(nova, opcode);
	}
	
	public boolean removerOcorrenciaI(int cod, int opcode)
	{
		return ocorrencias.removerOcorrencia(cod, opcode);
		
	}
	
	public Ocorrencia buscarOcorrencia(int cod, int opcode)
	{
		return ocorrencias.buscarOcorrencia(cod, opcode);
	}
	
	public ArrayList<Ocorrencia> listarOcorrenciaFuncionario(String cpf)
	{
		return ocorrencias.listarOcorrenciasFuncionario(cpf);
	}
}
