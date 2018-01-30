package beans;

public class Frota{

	private String empresa_cnpj;
	private String empresa;
	private int idade_media;
	private int numero_onibus;
	private String descricao;
	private int cod;

	public Frota()
	{

	}


	public Frota(String cnpj1, int idade1, int numero1, String descricao1)
	{

		this.empresa_cnpj = cnpj1;
		this.idade_media = idade1;
		this.numero_onibus = numero1;
		this.descricao = descricao1;
	}


	public int getCod() {
		return cod;
	}


	public void setCod(int cod) {
		this.cod = cod;
	}


	public String getEmpresa() {
		return empresa;
	}


	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}


	public String getEmpresa_cnpj() {
		return empresa_cnpj;
	}

	public void setEmpresa_cnpj(String empresa_cnpj) {
		this.empresa_cnpj = empresa_cnpj;
	}

	public int getIdade_media() {
		return idade_media;
	}

	public void setIdade_media(int idade_media) {
		this.idade_media = idade_media;
	}

	public int getNumero_onibus() {
		return numero_onibus;
	}

	public void setNumero_onibus(int numero_onibus) {
		this.numero_onibus = numero_onibus;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


}
