package beans;

public class Peca {
	
	private int cod;
	private String tipo;
	private String nome;
	private String marca;
	private String fornecedor_cnpj;
	private int quantidade;
	
	public Peca()
	{
		
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getFornecedor_cnpj() {
		return fornecedor_cnpj;
	}

	public void setFornecedor_cnpj(String fornecedor_cnpj) {
		this.fornecedor_cnpj = fornecedor_cnpj;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	
	
	
}
