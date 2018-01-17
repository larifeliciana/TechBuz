package beans;

import java.sql.Date;

public class Afastamento {
	
	private String codigo;
	private Date inicio, fim;
	private String funcionario_cpf;
	private String tipo_cod;
	
	public Afastamento(String codigo, Date inicio, Date fim, String funcionario_cpf, String tipo_cod) {

		this.codigo = codigo;
		this.inicio = inicio;
		this.fim = fim;
		this.funcionario_cpf = funcionario_cpf;
		this.tipo_cod = tipo_cod;
	}
	

	public Afastamento()
	{
		
	}


	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public Date getInicio() {
		return inicio;
	}


	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}


	public Date getFim() {
		return fim;
	}


	public void setFim(Date fim) {
		this.fim = fim;
	}


	public String getFuncionario_cpf() {
		return funcionario_cpf;
	}


	public void setFuncionario_cpf(String funcionario_cpf) {
		this.funcionario_cpf = funcionario_cpf;
	}


	public String getTipo_cod() {
		return tipo_cod;
	}


	public void setTipo_cod(String tipo_cod) {
		this.tipo_cod = tipo_cod;
	}
	
	

}
