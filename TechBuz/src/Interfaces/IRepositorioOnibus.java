package Interfaces;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

import beans.Acessorio;
import beans.Empresa;
import beans.Frota;
import beans.OcorrenciaOnibus;
import beans.Onibus;
import beans.OrdemServico;
import beans.Peca;
import beans.Servico;

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
	public abstract ArrayList<Onibus> listarOnibusSemFrota();
	public abstract boolean adicionarAFrota(String placa, int frota);
	public abstract boolean removerDaFrota(String placa);
	public abstract ArrayList<OcorrenciaOnibus> listarOcorrencia();
	public abstract ArrayList<Servico> listarServicos();
	public abstract int acharCod();
	public abstract boolean inserirOrdem(String desc_servico, Date data_ordem, String gerente_cpf, 
			String oficina_cnpj, int ocorrencia_onibus_codigo, String status_ordem);
	public abstract boolean inserirCompostaPor(int cod_ordem, int cod_servico);
	public abstract void atualizarFrota( int cod);
	public abstract void atualizartodas();
	public abstract ArrayList<OrdemServico> listarOrdens();
	public abstract ArrayList<OrdemServico> listarOrdensFinalizadas();
	public abstract ArrayList<Servico> pegarServicos(int cod);
	public abstract boolean updateOrdem(int ordem, float orcamento, Date data_realizacao, Time inicio, Time fim, String mecanico_chefe);
	public abstract boolean removerOrdem(int numero);
	public abstract boolean alterarPeca(String tipo, String nome, String marca, int quantidade, int cod);
	public abstract ArrayList<Empresa> listaOficinasComContrato(String cnpj);
	public abstract String acharCnpj(String placa);

}
