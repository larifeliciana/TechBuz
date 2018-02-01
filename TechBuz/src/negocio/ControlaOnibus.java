package negocio;

import java.sql.Date;
import java.util.ArrayList;

import Interfaces.IRepositorioOnibus;
import Repositorio.RepositorioOnibus;
import beans.Acessorio;
import beans.Frota;
import beans.OcorrenciaOnibus;
import beans.Onibus;
import beans.Peca;
import beans.Servico;

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
	public ArrayList<Onibus> listarOnibusSemFrota()
	{
		return onibus.listarOnibusSemFrota();
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
	
	public ArrayList<OcorrenciaOnibus> listarOcorrencia()
	{
		return onibus.listarOcorrencia();
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
	public  boolean adicionarAFrota(String placa, int frota)
	{
		return onibus.adicionarAFrota(placa, frota);
	}
	public  boolean removerDaFrota(String placa)
	{
		
		return onibus.removerDaFrota(placa);
	}
	

	public ArrayList<Servico> listarServicos()
	{
		return onibus.listarServicos();
	}
	
	public int acharCod()
	{
		return onibus.acharCod();
	}
	public boolean inserirOrdem(String desc_servico, Date data_ordem, String gerente_cpf, 
			String oficina_cnpj, int ocorrencia_onibus_codigo, String status_ordem)
	{
			return onibus.inserirOrdem(desc_servico, data_ordem, gerente_cpf, oficina_cnpj, ocorrencia_onibus_codigo, status_ordem);
	}
	public boolean inserirCompostaPor(int cod_ordem, int cod_servico)
	{
		return onibus.inserirCompostaPor(cod_ordem, cod_servico);
	}


	public void atualizarFrota( int cod)
	{
		onibus.atualizarFrota(cod);
	}

	public void atualizartodas()
	{
		onibus.atualizartodas();
	}
}


