package beans;

public class Servico {

	private int cod;
	private String descricao;
	private String obs;
	
	
	public Servico() {
		
	}


	public int getCod() {
		return cod;
	}


	public void setCod(int cod) {
		this.cod = cod;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public String getObs() {
		return obs;
	}


	public void setObs(String obs) {
		this.obs = obs;
	}


	@Override
	public String toString() {
		return "Servico [cod=" + cod + ", descricao=" + descricao + ", obs=" + obs + "]";
	}
	
	
	
	
}
