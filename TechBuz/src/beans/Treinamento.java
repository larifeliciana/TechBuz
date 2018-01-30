package beans;

import java.sql.Date;

public class Treinamento {

	
	private int codigo;
	private String nome;
	private String tipo;
	private int carga_horaria;
	private String funcionario_cpf;
	private float nota_final;
	private Date dt_realização;
	private String obs;
	private String resultado; //aprovado reprovado
	
	public Treinamento(int codigo, String nome, String tipo, int carga_horaria, String funcionario_cpf,
			float nota_final, Date dt_realização, String obs, String resultado) {
	
		
		this.codigo = codigo;
		this.nome = nome;
		this.tipo = tipo;
		this.carga_horaria = carga_horaria;
		this.funcionario_cpf = funcionario_cpf;
		this.nota_final = nota_final;
		this.dt_realização = dt_realização;
		this.obs = obs;
		this.resultado = resultado;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getCarga_horaria() {
		return carga_horaria;
	}

	public void setCarga_horaria(int carga_horaria) {
		this.carga_horaria = carga_horaria;
	}

	public String getFuncionario_cpf() {
		return funcionario_cpf;
	}

	public void setFuncionario_cpf(String funcionario_cpf) {
		this.funcionario_cpf = funcionario_cpf;
	}

	public float getNota_final() {
		return nota_final;
	}

	public void setNota_final(float nota_final) {
		this.nota_final = nota_final;
	}

	public Date getDt_realização() {
		return dt_realização;
	}

	public void setDt_realização(Date dt_realização) {
		this.dt_realização = dt_realização;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	
	
	
	
	
}
