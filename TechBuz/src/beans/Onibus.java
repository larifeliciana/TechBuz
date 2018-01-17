package beans;

import java.sql.Date;

public class Onibus {

	private String placa;
	private String tipo; //tipo de onibus microonibus/sanfona/normal
	private String operacao; //tipo de operacao que o onibus realiza
	private Date data_inclusao; //data de inclusao na frota
	private char disponibilidade; //se esta disponivel para qualquer operação
	private char status_alocacao; //Se esta alocado para viagem
	private int sentado;
	private int cod_frota;
	private int ano;
	
	public Onibus(String placa1, String tipo1, String operacao1, Date data_inclusao1, char disponibilidade1, char status_alocacao1,
			int sentado1, int cod_frota1, int ano1)
	{
		this.ano = ano1;
		this.cod_frota = cod_frota1;
		this.data_inclusao = data_inclusao1;
		this.disponibilidade = disponibilidade1;
		this.operacao = operacao1;
		this.placa = placa1;
		this.sentado = sentado1;
		this.status_alocacao = status_alocacao1;
		this.tipo = tipo1;
	}
	

	public Onibus()
	{
		
	}


	public String getPlaca() {
		return placa;
	}


	public void setPlaca(String placa) {
		this.placa = placa;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public String getOperacao() {
		return operacao;
	}


	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}


	public Date getData_inclusao() {
		return data_inclusao;
	}


	public void setData_inclusao(Date data_inclusao) {
		this.data_inclusao = data_inclusao;
	}


	public char getDisponibilidade() {
		return disponibilidade;
	}


	public void setDisponibilidade(char disponibilidade) {
		this.disponibilidade = disponibilidade;
	}


	public char getStatus_alocacao() {
		return status_alocacao;
	}


	public void setStatus_alocacao(char status_alocacao) {
		this.status_alocacao = status_alocacao;
	}


	public int getSentado() {
		return sentado;
	}


	public void setSentado(int sentado) {
		this.sentado = sentado;
	}


	public int getCod_frota() {
		return cod_frota;
	}


	public void setCod_frota(int cod_frota) {
		this.cod_frota = cod_frota;
	}


	public int getAno() {
		return ano;
	}


	public void setAno(int ano) {
		this.ano = ano;
	}
	
	//#getters and setters
	
	
}
