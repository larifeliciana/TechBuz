package beans;

import java.sql.Date;

public class Funcionario {

	
	private String nome;
	private String cpf;
	private String identidade;
	private String email;
	private String fone_1;
	private String fone_2;
	private String foto; //endereco
	private char sexo;
	private char disponibilidade;
	private char ativo; //não trabalha 
	private Date nascimento;
	private Date data_admissao;
	
	public Funcionario()
	{
		
	}
	
	public Funcionario(String nome1, String cpf1, String identidade1, String email1, String fone_11, String fone_12, String foto1,
	char sexo1, char disponibilidade1, char ativo1, Date nascimento1, Date data_admissao1)
	{
		this.nome = nome1;
		this.cpf = cpf1;
		this.identidade = identidade1;
		this.email = email1;
		this.fone_1 = fone_11;
		this.fone_2 = fone_12;
		this.foto = foto1;
		this.sexo = sexo1;
		this.disponibilidade = disponibilidade1;
		this.ativo = ativo1;
		this.nascimento = nascimento1;
		this.data_admissao = data_admissao1;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getIdentidade() {
		return identidade;
	}

	public void setIdentidade(String identidade) {
		this.identidade = identidade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFone_1() {
		return fone_1;
	}

	public void setFone_1(String fone_1) {
		this.fone_1 = fone_1;
	}

	public String getFone_2() {
		return fone_2;
	}

	public void setFone_2(String fone_2) {
		this.fone_2 = fone_2;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public char getDisponibilidade() {
		return disponibilidade;
	}

	public void setDisponibilidade(char disponibilidade) {
		this.disponibilidade = disponibilidade;
	}

	public char getAtivo() {
		return ativo;
	}

	public void setAtivo(char ativo) {
		this.ativo = ativo;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public Date getData_admissao() {
		return data_admissao;
	}

	public void setData_admissao(Date data_admissao) {
		this.data_admissao = data_admissao;
	}
	
	
}

