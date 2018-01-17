package beans;

public class Ponto {

	
	private String numeracao, endereco_numero, endereco_cep, descricao, latitude, longitude, ponto_numeracao_proximo, linha_numero;

	public Ponto(String numeracao, String endereco_numero, String endereco_cep, String descricao, String latitude, String longitude, String ponto_numeracao_proximo, String linha_numero)
	{
		this.numeracao = numeracao;
		this.endereco_cep = endereco_cep;
		this.endereco_numero = endereco_numero;
		this.descricao = descricao;
		this.latitude = latitude;
		this.longitude = longitude;
		this.ponto_numeracao_proximo = ponto_numeracao_proximo;
		this.linha_numero = linha_numero;
		
		
	}
	
	public Ponto()
	{
		
	}

	public String getNumeracao() {
		return numeracao;
	}

	public void setNumeracao(String numeracao) {
		this.numeracao = numeracao;
	}

	public String getEndereco_numero() {
		return endereco_numero;
	}

	public void setEndereco_numero(String endereco_numero) {
		this.endereco_numero = endereco_numero;
	}

	public String getEndereco_cep() {
		return endereco_cep;
	}

	public void setEndereco_cep(String endereco_cep) {
		this.endereco_cep = endereco_cep;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getPonto_numeracao_proximo() {
		return ponto_numeracao_proximo;
	}

	public void setPonto_numeracao_proximo(String ponto_numeracao_proximo) {
		this.ponto_numeracao_proximo = ponto_numeracao_proximo;
	}

	public String getLinha_numero() {
		return linha_numero;
	}

	public void setLinha_numero(String linha_numero) {
		this.linha_numero = linha_numero;
	}
	
	
}
