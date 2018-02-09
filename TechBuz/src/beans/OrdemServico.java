package beans;

import java.sql.Date;
import java.sql.Time;

public class OrdemServico {
	
	private Date data_realizacao;
	private String desc_servico;
	private Date data_ordem;
	private String gerente_cpf;
	private String oficina_cnpj;
	private int ocorrencia_onibus_codigo;
	private	String status;
	private Time inicio;
	private Time fim;
	private int cod;
	private String mecanico_chefe;
	
	

	public OrdemServico()
	{
		
	}

	


	public int getCod() {
		return cod;
	}




	public void setCod(int cod) {
		this.cod = cod;
	}




	public Date getData_realizacao() {
		return data_realizacao;
	}



	public void setData_realizacao(Date data_realizacao) {
		this.data_realizacao = data_realizacao;
	}



	public String getDesc_servico() {
		return desc_servico;
	}



	public void setDesc_servico(String desc_servico) {
		this.desc_servico = desc_servico;
	}



	public Date getData_ordem() {
		return data_ordem;
	}



	public void setData_ordem(Date data_ordem) {
		this.data_ordem = data_ordem;
	}



	public String getGerente_cpf() {
		return gerente_cpf;
	}



	public void setGerente_cpf(String gerente_cpf) {
		this.gerente_cpf = gerente_cpf;
	}



	public String getOficina_cnpj() {
		return oficina_cnpj;
	}



	public void setOficina_cnpj(String oficina_cnpj) {
		this.oficina_cnpj = oficina_cnpj;
	}



	public int getOcorrencia_onibus_codigo() {
		return ocorrencia_onibus_codigo;
	}



	public void setOcorrencia_onibus_codigo(int ocorrencia_onibus_codigo) {
		this.ocorrencia_onibus_codigo = ocorrencia_onibus_codigo;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public Time getInicio() {
		return inicio;
	}



	public void setInicio(Time inicio) {
		this.inicio = inicio;
	}



	public Time getFim() {
		return fim;
	}



	public void setFim(Time fim) {
		this.fim = fim;
	}



	public String getMecanico_chefe() {
		return mecanico_chefe;
	}



	public void setMecanico_chefe(String mecanico_chefe) {
		this.mecanico_chefe = mecanico_chefe;
	}
	
	
}
