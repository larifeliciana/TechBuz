package beans;

public class TipoAfastamento {

	private String descricao;
	private int cod;
	
	
	
	public TipoAfastamento(String descricao, int cod) {
	
		this.descricao = descricao;
		this.cod = cod;
	}
	public TipoAfastamento() {
		// TODO Auto-generated constructor stub
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	
	
}
