package negocio;

import java.util.ArrayList;

import Interfaces.IRepositorioLinha;
import Repositorio.RepositorioLinha;
import beans.Linha;
import beans.Trajeto;

public class ControlaLinha {
	
	IRepositorioLinha linhas;
	
	public ControlaLinha()
	{
		linhas = RepositorioLinha.getInstance();
	}
	public ArrayList<Linha> listarLinhas(){
		return linhas.listarLinhas();
	}
	public ArrayList<Trajeto> listarTrajeto(String linha)
	{
		return linhas.listarTrajeto(linha);
	}

}
