package beans;

import java.sql.Date;

public class OcorrenciaOnibus {
	

	
	private int codigo;
	private Date data_ocorrencia;
	private String descricao;
	private String tipo;//danos onibus/externos
	private String obs;
	private String endereco_cep; 
	private String endereco_numero;
	private String registro;
	private String onibus_placa;
	private int vistoria_seq;

	
	public OcorrenciaOnibus()
	{
		
	}


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public Date getData_ocorrencia() {
		return data_ocorrencia;
	}


	public void setData_ocorrencia(Date data_ocorrencia) {
		this.data_ocorrencia = data_ocorrencia;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public String getObs() {
		return obs;
	}


	public void setObs(String obs) {
		this.obs = obs;
	}


	public String getEndereco_cep() {
		return endereco_cep;
	}


	public void setEndereco_cep(String endereco_cep) {
		this.endereco_cep = endereco_cep;
	}


	public String getEndereco_numero() {
		return endereco_numero;
	}


	public void setEndereco_numero(String endereco_numero) {
		this.endereco_numero = endereco_numero;
	}


	public String getRegistro() {
		return registro;
	}


	public void setRegistro(String registro) {
		this.registro = registro;
	}


	public String getOnibus_placa() {
		return onibus_placa;
	}


	public void setOnibus_placa(String onibus_placa) {
		this.onibus_placa = onibus_placa;
	}


	public int getVistoria_seq() {
		return vistoria_seq;
	}


	public void setVistoria_seq(int vistoria_seq) {
		this.vistoria_seq = vistoria_seq;
	}

	
}
