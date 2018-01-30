package Interfaces;

import java.util.ArrayList;

import beans.Acessorio;
import beans.Frota;
import beans.OcorrenciaOnibus;
import beans.Onibus;
import beans.Peca;

public abstract  interface IRepositorioOnibus {

	
	public abstract  String cadastrarOnibusBD(Onibus a);
	public abstract  Onibus buscaOnibusBD(String placa);
	public abstract  boolean removerOnibusBD(String placa);
	public abstract  ArrayList<Onibus> listarOnibus();
	public abstract  ArrayList<Onibus> listarOnibusFrota(int frota);
	public abstract  ArrayList<Onibus> listarOnibusSentadosMaiorque( int x);
	public abstract  ArrayList<Onibus> listarOnibusNaoAlocados();
	public abstract  ArrayList<Frota> listarFrotas();
	public abstract String cadastrarOcorrenciaOnibus(OcorrenciaOnibus a);
	public abstract boolean removerOcorrenciaOnibus(int cod);
	public abstract OcorrenciaOnibus buscarOcorrenciaOnibus(int cod);
	public abstract ArrayList<OcorrenciaOnibus> listarOcorrenciaOnibus(String onibus_placa);
	public abstract String cadastrarAcessorio(Acessorio a);
	public abstract boolean removerAcessorio(int cod);
	public abstract Acessorio buscarAcessorio(int cod);
	public abstract ArrayList<Acessorio> listarAcessorioOnibus(String onibus_placa);
	public abstract boolean removerFrota(int frota);
	public abstract Frota buscarFrota(String cnpj);
	public abstract  ArrayList<Acessorio> listarAcessoriosDisponiveis();
	public abstract String cadastrarPeca(Peca a);
	public abstract boolean removerPeca(int cod);
	public abstract Peca buscarPeca(int cod);
	public abstract ArrayList<Peca> listarPecasFornecedor(String cnpj);
	
}
