package beans;

import java.sql.Date;
import java.sql.Time;

public class Ocorrencia {

	
	private Date data_ocorrencia;
	private String status_ocorrencia;
	private String funcionario_cpf;
	private String justificativa;
	private Time horario;
	private String motivo;
	private float valor;
	private String tipo;
	private int cod;
	
	public Ocorrencia()
	{
		
	}
	
	
	public Ocorrencia(String descricao, Date data_ocorrencia, String status_ocorrencia, String funcionario_cpf,
			String justificativa, Time horario, String motivo, float valor) {
		
		this.data_ocorrencia = data_ocorrencia;
		this.status_ocorrencia = status_ocorrencia;
		this.funcionario_cpf = funcionario_cpf;
		this.justificativa = justificativa;
		this.horario = horario;
		this.motivo = motivo;
		this.valor = valor;
	}
	
	
	public int getCod() {
		return cod;
	}


	public void setCod(int cod) {
		this.cod = cod;
	}


	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Date getData_ocorrencia() {
		return data_ocorrencia;
	}
	public void setData_ocorrencia(Date data_ocorrencia) {
		this.data_ocorrencia = data_ocorrencia;
	}
	public String getStatus_ocorrencia() {
		return status_ocorrencia;
	}
	public void setStatus_ocorrencia(String status_ocorrencia) {
		this.status_ocorrencia = status_ocorrencia;
	}
	public String getFuncionario_cpf() {
		return funcionario_cpf;
	}
	public void setFuncionario_cpf(String funcionario_cpf) {
		this.funcionario_cpf = funcionario_cpf;
	}
	public String getJustificativa() {
		return justificativa;
	}
	public void setJustificativa(String justificativa) {
		this.justificativa = justificativa;
	}
	public Time getHorario() {
		return horario;
	}
	public void setHorario(Time horario) {
		this.horario = horario;
	}
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	
	
}
