package beans;

import java.sql.Date;

public class Contrato {
	
	private String oficina_cnpj;
	private String matriz_empresa_cnpj;
	private Date dt_inicio; 
	private Date dt_fim;
	private float vl_contrato;
	private int validade_em_meses;
	
	
	public Contrato(String oficina_cnpj, String matriz_empresa_cnpj, Date dt_inicio, Date dt_fim, float vl_contrato, int validade_em_meses) {
		
		this.oficina_cnpj = oficina_cnpj;
		this.matriz_empresa_cnpj = matriz_empresa_cnpj;
		this.dt_inicio = dt_inicio;
		this.dt_fim = dt_fim;
		this.vl_contrato = vl_contrato;
		this.validade_em_meses = validade_em_meses;
	}


	public String getOficina_cnpj() {
		return oficina_cnpj;
	}


	public void setOficina_cnpj(String oficina_cnpj) {
		this.oficina_cnpj = oficina_cnpj;
	}


	public String getMatriz_empresa_cnpj() {
		return matriz_empresa_cnpj;
	}


	public void setMatriz_empresa_cnpj(String matriz_empresa_cnpj) {
		this.matriz_empresa_cnpj = matriz_empresa_cnpj;
	}


	public Date getDt_inicio() {
		return dt_inicio;
	}


	public void setDt_inicio(Date dt_inicio) {
		this.dt_inicio = dt_inicio;
	}


	public Date getDt_fim() {
		return dt_fim;
	}


	public void setDt_fim(Date dt_fim) {
		this.dt_fim = dt_fim;
	}


	public float getVl_contrato() {
		return vl_contrato;
	}


	public void setVl_contrato(float vl_contrato) {
		this.vl_contrato = vl_contrato;
	}


	public int getValidade_em_meses() {
		return validade_em_meses;
	}


	public void setValidade_em_meses(int validade_em_meses) {
		this.validade_em_meses = validade_em_meses;
	}



	
	
}
