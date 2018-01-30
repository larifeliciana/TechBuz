package beans;

import java.sql.Date;

public class BancoDeHoras {
	
	private Date dia;
	private int qtd_horas;
	private String funcionario_cpf;
	
	public BancoDeHoras(Date dia, int qtd_horas, String funcionario_cpf) {
	
		this.dia = dia;
		this.qtd_horas = qtd_horas;
		this.funcionario_cpf = funcionario_cpf;
	}

	public BancoDeHoras()
	{
		
	}
	public Date getDia() {
		return dia;
	}

	public void setDia(Date dia) {
		this.dia = dia;
	}

	public int getQtd_horas() {
		return qtd_horas;
	}

	public void setQtd_horas(int qtd_horas) {
		this.qtd_horas = qtd_horas;
	}

	public String getFuncionario_cpf() {
		return funcionario_cpf;
	}

	public void setFuncionario_cpf(String funcionario_cpf) {
		this.funcionario_cpf = funcionario_cpf;
	}
	
	
	

}
