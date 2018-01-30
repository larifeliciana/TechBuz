package negocio;

import java.util.ArrayList;

import Interfaces.IRepositorioOnibus;
import Repositorio.RepositorioOnibus;
import beans.Acessorio;
import beans.Frota;
import beans.OcorrenciaOnibus;
import beans.Onibus;
import beans.Peca;

public class ControlaOnibus {

	IRepositorioOnibus onibus;
	
	public ControlaOnibus()
	{
		onibus = RepositorioOnibus.getInstance();
	}

	public  String cadastrarOnibusBD(Onibus a) {

		return onibus.cadastrarOnibusBD(a);
	}
	public  Onibus buscaOnibusBD(String placa)
	{
		return onibus.buscaOnibusBD(placa);
	}
	public  boolean removerOnibusBD(String placa)
	{
		return onibus.removerOnibusBD(placa);
		
	}
	public  ArrayList<Onibus> listarOnibus()
	{
		return onibus.listarOnibus();
		
	}
	public  ArrayList<Onibus> listarOnibusFrota(int frota)
	{
		return onibus.listarOnibusFrota(frota);
	}
	public  ArrayList<Onibus> listarOnibusSentadosMaiorque( int x){
		
		return onibus.listarOnibusSentadosMaiorque(x);
	}
	public  ArrayList<Onibus> listarOnibusNaoAlocados()
	{
		return onibus.listarOnibusNaoAlocados();
	}
	public  ArrayList<Frota> listarFrotas()
	{
		return onibus.listarFrotas();
	}

	public String cadastrarOcorrenciaOnibus(OcorrenciaOnibus a)
	{
		return onibus.cadastrarOcorrenciaOnibus(a);
	}
	public boolean removerOcorrenciaOnibus(int cod)
	{
		return onibus.removerOcorrenciaOnibus(cod);
	}
	public OcorrenciaOnibus buscarOcorrenciaOnibus(int cod)
	{
		return onibus.buscarOcorrenciaOnibus(cod);
	}
	public ArrayList<OcorrenciaOnibus> listarOcorrenciaOnibus(String onibus_placa)
	{
		return onibus.listarOcorrenciaOnibus(onibus_placa);
	}
	
	///////////////////////////////////////////////
	

	public String cadastrarAcessorio(Acessorio a)
	{
		return onibus.cadastrarAcessorio(a);
	}
	
	public boolean removerAcessorio(int cod)
	{
		return onibus.removerAcessorio(cod);
	}
	public Acessorio buscarAcessorio(int cod)
	{
		return onibus.buscarAcessorio(cod);
	}
	public ArrayList<Acessorio> listarAcessorioOnibus(String onibus_placa)
	{
		return onibus.listarAcessorioOnibus(onibus_placa);
	}
	
	public ArrayList<Acessorio> listarAcessoriosDisponiveis()
	{
		return onibus.listarAcessoriosDisponiveis();
	}
	
	public boolean removerFrota(int frota)
	{
		return onibus.removerFrota(frota);
	}
	
	public Frota buscarFrota(String cnpj)
	{
		return onibus.buscarFrota(cnpj);
	}
	
	////////////////////////////
	public String cadastrarPeca(Peca a) {
		return onibus.cadastrarPeca(a);
	}
	public  boolean removerPeca(int cod)
	{
		return onibus.removerPeca(cod);
	}
	public  Peca buscarPeca(int cod)
	{
		return onibus.buscarPeca(cod);
	}
	public  ArrayList<Peca> listarPecasFornecedor(String cnpj)
	{
		return onibus.listarPecasFornecedor(cnpj);
	}

}


