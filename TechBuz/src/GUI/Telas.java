package GUI;

import beans.Login;
import beans.Viagem;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Telas {

	private Scene telaInicial;
	private Scene telaFiscal;
	
	private String cpf;
	private String placa;
	private int codigo;
	private Viagem viagem;
	private Scene telaEmpresas;


	private Scene telaFuncionarios;
	private Scene telaVisualizarFuncionario;
	

	private Scene telaOcorrencia;
	private Scene telaAdicionarOcorrencia;
	private Scene telaAfastamento;
	private Scene telaBanco;
	
	private Scene telaOnibus;
	private Scene telaCadastrarOnibus;
	private Scene telaVistorias;
	private Scene telaDocumentos;
	private Scene telaVencimentos;	
	private Scene telaGerarOrdem;
	private Scene telaFinalizarOrdem;
	
	private Scene telaLinhas;
	
	private Scene telaLogin;

	private Scene telaViagem;
	private Scene telaChecarViagem;
	private Scene telaFinalizarViagem;
	private Scene telaAlterarViagem;
	

	private static Stage mainStage;

	private static Telas instance;

	private Login logado;
	private int ordem;
	
	private Telas() {

	}

	public void escolheTela(Login logar)
	{
		if(logar.getOpcode()==4)
		{
		this.setScene(this.getTelaInicial());	
		}
		if(logar.getOpcode()==3)
		{
		this.setScene(this.getTelaInicial());	
		}
		
		
		
		
	}

	public Scene getTelaOnibus() {

		try {
			 { // Repare no IF.
				telaOnibus = new Scene(FXMLLoader.load(getClass().getResource("telaonibus.fxml")));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERROOOOO");
		}

		return telaOnibus;
	}

	
	public Scene getTelaViagem() {

		try {
			 { // Repare no IF.
				telaViagem = new Scene(FXMLLoader.load(getClass().getResource("telaviagem.fxml")));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERROOOOO");
		}

		return telaViagem;
	}
	
	
	public Scene getTelaChecarViagem() {

		try {
			 { // Repare no IF.
				telaChecarViagem = new Scene(FXMLLoader.load(getClass().getResource("telachecarviagem.fxml")));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERROOOOO");
		}

		return telaChecarViagem;
	}
	
	
	public Scene getTelaFinalizarViagem() {

		try {
			 { // Repare no IF.
				telaFinalizarViagem = new Scene(FXMLLoader.load(getClass().getResource("telafinalizarviagem.fxml")));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERROOOOO");
		}

		return telaFinalizarViagem;
	}
	
	public Scene getTelaAlterarViagem() {

		try {
			 { // Repare no IF.
				telaAlterarViagem = new Scene(FXMLLoader.load(getClass().getResource("telaalterarviagem.fxml")));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERROOOOO");
		}

		return telaAlterarViagem;
	}
	
	public int getOrdem() {
		return ordem;
	}

	public void setOrdem(int ordem) {
		this.ordem = ordem;
	}

	public Scene getTelaFinalizarOrdem() {

		try {
			 { // Repare no IF.
				telaFinalizarOrdem = new Scene(FXMLLoader.load(getClass().getResource("telafinalizarordem.fxml")));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERROOOOO");
		}

		return telaFinalizarOrdem;
	}

	public Scene getTelaBanco() {

		try {
			 { // Repare no IF.
				telaBanco = new Scene(FXMLLoader.load(getClass().getResource("telabancohoras.fxml")));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERROOOOO");
		}

		return telaBanco;
	}

	
	public Scene getTelaLogin() {

		try {
			 { // Repare no IF.
				telaLogin = new Scene(FXMLLoader.load(getClass().getResource("telalogin.fxml")));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERROOOOO");
		}

		return telaLogin;
	}
	

	public Scene getTelaLinhas() {

		try {
			 { // Repare no IF.
				telaLinhas = new Scene(FXMLLoader.load(getClass().getResource("telalinha.fxml")));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERROOOOO");
		}

		return telaLinhas;
	}
	

	public Scene getGerarOrdem() {

		try {
			 { // Repare no IF.
				telaGerarOrdem = new Scene(FXMLLoader.load(getClass().getResource("telaGerarOrdem.fxml")));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERROOOOO");
		}

		return telaGerarOrdem;
	}

	public Scene getTelaCadastrarOnibus() {

		try {
		{ // Repare no IF.
				telaCadastrarOnibus = new Scene(FXMLLoader.load(getClass().getResource("telacadastraronibus.fxml")));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERROOOOO");
		}



		return telaCadastrarOnibus;
	}


	public Scene getTelaVistorias() {

		try {
		
				telaVistorias = new Scene(FXMLLoader.load(getClass().getResource("telavistorias.fxml")));
		
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERROOOOO");
		}

		return telaVistorias;
	}

	public Scene getTelaDocumentos() {

		try {
			{ // Repare no IF.
				telaDocumentos = new Scene(FXMLLoader.load(getClass().getResource("teladocumentos.fxml")));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERROOOOO");
		}

		return telaDocumentos;
	}


	public Scene gettelaVencimentos() {

		try {
			{ // Repare no IF.
				telaVencimentos = new Scene(FXMLLoader.load(getClass().getResource("telaVencimentos.fxml")));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERROOOOO");
		}

		return telaVencimentos;
	}
	public Scene getTelaOcorrencia() {

		try {
			{ // Repare no IF.
				telaOcorrencia = new Scene(FXMLLoader.load(getClass().getResource("telaocorrencia.fxml")));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERROOOOO");
		}

		return telaOcorrencia;
	}




	public Scene getTelaAdicionarOcorrencia() {


		try {

			 { // Repare no IF.

				this.telaAdicionarOcorrencia = new Scene(FXMLLoader.load(getClass().getResource("telaadicionarocorrencia.fxml")));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERROOOOO");
		}
		return telaAdicionarOcorrencia;
	}




	public Scene getTelaAfastamento() {


		try {
			 { // Repare no IF.
				telaAfastamento = new Scene(FXMLLoader.load(getClass().getResource("telaafastamento.fxml")));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERROOOOO");
		}

		return telaAfastamento;
	}


	public static Telas getInstance() {
		if (instance == null) {
			instance = new Telas();
		}
		return instance;
	}

	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}



	public String getPlaca() {
		return placa;
	}




	public void setPlaca(String placa) {
		this.placa = placa;
	}




	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public static void setScene(Scene a) {
		mainStage.setScene(a);
		mainStage.show();
	}



	public static Stage getMainStage() {
		return mainStage;
	}

	public void setMainStage(Stage stage) {
		mainStage = stage;
	}

	public Scene getTelaInicial() {

		try {
			if (this.logado.getOpcode()==4) { // Repare no IF.
				telaInicial = new Scene(FXMLLoader.load(getClass().getResource("telainicial.fxml")));
			}
		
			else if(this.logado.getOpcode() ==3)
			{
				telaInicial = new Scene(FXMLLoader.load(getClass().getResource("telainicialFiscal.fxml")));
			}
		
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERROOOOO");
		}
		return telaInicial;
	}
	
	
	public Scene getTelaFuncionarios() {
		try {
			{ // Repare no IF.
				telaFuncionarios = new Scene(FXMLLoader.load(getClass().getResource("telafuncionarios.fxml")));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERROOOOO");
		}
		return telaFuncionarios;
	}


	public Scene getTelaVisualizarFuncionario() {
		try {
			 { // Repare no IF.
				telaVisualizarFuncionario = new Scene(FXMLLoader.load(getClass().getResource("telavisualizarfuncionario.fxml")));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERROOOOO");
		}
		return telaVisualizarFuncionario;
	}

	public Scene getTelaEmpresas() {
		try {
		{ // Repare no IF.
				telaEmpresas = new Scene(FXMLLoader.load(getClass().getResource("telaempresas.fxml")));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERROOOOO");
		}
		return telaEmpresas;
	}


	
	
	
	public Viagem getViagem() {
		return viagem;
	}

	public void setViagem(Viagem viagem) {
		this.viagem = viagem;
	}

	public Login getLogado() {
		return logado;
	}
	
	


	public void setLogado(Login logado) {
		this.logado = logado;
	}

	
	
}
