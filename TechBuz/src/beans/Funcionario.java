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
	private String sexo;
	private String disponibilidade;
	private String ativo; //n�o trabalha 
	private Date nascimento;
	private Date data_admissao;
	private String cnh;
	
	public Funcionario()
	{
		
	}
	
	public Funcionario(String nome1, String cpf1, String identidade1, String email1, String fone_11, String fone_12, String foto1,
	String sexo1, String disponibilidade1, String ativo1, Date nascimento1, Date data_admissao1, String cnh)
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
		this.cnh = cnh;
	
	}
	
	public String toString()
	{
		return this.nome +"/"+this.cpf+"/"+this.ativo+"/"+this.identidade;
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

	public String getCnh() {
		return cnh;
	}

	public void setCnh(String cnh) {
		this.cnh = cnh;
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

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getDisponibilidade() {
		return disponibilidade;
	}

	public void setDisponibilidade(String disponibilidade) {
		this.disponibilidade = disponibilidade;
	}

	public String getAtivo() {
		return ativo;
	}

	public void setAtivo(String ativo) {
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

