package beans;

import java.sql.Date;

public class Documento {

	String id;
	Date dt_emissao;
	Date dt_validade; 
	String tipo;
	String descricao;
	String onibus_placa;
	
	
	public Documento(String id, Date dt_emissao, Date dt_validade, String tipo, String descricao, String onibus_placa) {
		super();
		this.id = id;
		this.dt_emissao = dt_emissao;
		this.dt_validade = dt_validade;
		this.tipo = tipo;
		this.descricao = descricao;
		this.onibus_placa = onibus_placa;
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getDt_emissao() {
		return dt_emissao;
	}
	public void setDt_emissao(Date dt_emissao) {
		this.dt_emissao = dt_emissao;
	}
	public Date getDt_validade() {
		return dt_validade;
	}
	public void setDt_validade(Date dt_validade) {
		this.dt_validade = dt_validade;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getOnibus_placa() {
		return onibus_placa;
	}
	public void setOnibus_placa(String onibus_placa) {
		this.onibus_placa = onibus_placa;
	}
}
