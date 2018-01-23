package beans;
public class Empresa {

	private String cnpj;
	private String nome;
	private String email;
	private String razao_social;
	private String tipo;
	
//botar tipo pra int?
	public Empresa()
	{
		
	}
	
	public Empresa(String cnpj1, String nome1, String razao_social1, String email1, String tipo)
	{
		this.cnpj = cnpj1;
		this.nome = nome1;
		this.razao_social = razao_social1;
		this.email = email1;
		this.tipo = tipo;
	}
	
	public String toString()
	{
		String a =  this.cnpj+", "+this.nome+", "+this.email+", "+this.razao_social+"/";
		
		return a;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRazao_social() {
		return razao_social;
	}

	public void setRazao_social(String razao_social) {
		this.razao_social = razao_social;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
}


	