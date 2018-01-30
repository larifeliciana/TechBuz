package Interfaces;

import java.util.ArrayList;

import beans.Acessorio;
import beans.Ocorrencia;

public interface IRepositorioOcorrencia {

	public abstract String cadastrarOcorrencia(Ocorrencia nova, int opcode);
	public abstract boolean removerOcorrencia(int codigo_ocorrencia, int opcode);
	public abstract Ocorrencia buscarOcorrencia(int cod, int opcode);
	public abstract  ArrayList<Ocorrencia> listarOcorrenciasFuncionario(String cpf);
	public abstract String acharTipo(int codigo_ocorrencia);

}
