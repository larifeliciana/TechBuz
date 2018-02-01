package Interfaces;

import java.util.ArrayList;

import beans.Linha;
import beans.Trajeto;

public interface IRepositorioLinha {

	public abstract ArrayList<Linha> listarLinhas();

	public abstract ArrayList<Trajeto> listarTrajeto(String linha);
}
