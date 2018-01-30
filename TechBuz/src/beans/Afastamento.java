package beans;

import java.sql.Date;

public class Afastamento {
	
	private int codigo;
	private Date inicio, fim;
	private String funcionario_cpf;
	private int tipo_cod;
	private String tipo;
	
	public Afastamento(int codigo, Date inicio, Date fim, String funcionario_cpf, int tipo_cod) {

		this.codigo = codigo;
		this.inicio = inicio;
		this.fim = fim;
		this.funcionario_cpf = funcionario_cpf;
		this.tipo_cod = tipo_cod;
	}
	

	public Afastamento()
	{
		
	}

	

	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int i) {
		this.codigo = i;
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


	public int getTipo_cod() {
		return tipo_cod;
	}


	public void setTipo_cod(int tipo_cod) {
		this.tipo_cod = tipo_cod;
	}
	
	

}
