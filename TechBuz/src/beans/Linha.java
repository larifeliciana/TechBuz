package beans;

public class Linha {

	private String numero, nome, tarifa_cod, ponto_inicial;
	
	public Linha(String numero,String nome,String tarifa_cod, String ponto_inicial)
	{
		this.numero = numero;
		this.nome = nome;
		this.tarifa_cod = tarifa_cod;
	}
	
	public Linha()
	{
		
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTarifa_cod() {
		return tarifa_cod;
	}

	public void setTarifa_cod(String tarifa_cod) {
		this.tarifa_cod = tarifa_cod;
	}

	public String getPonto_inicial() {
		return ponto_inicial;
	}

	public void setPonto_inicial(String ponto_inicial) {
		this.ponto_inicial = ponto_inicial;
	}
	
		
}
