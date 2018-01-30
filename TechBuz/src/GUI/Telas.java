package GUI;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Telas {

	private Scene telaInicial;
	private String cpf;
	private String placa;

	private Scene telaEmpresas;


	private Scene telaFuncionarios;
	private Scene telaVisualizarFuncionario;

	private Scene telaOcorrencia;
	private Scene telaAdicionarOcorrencia;
	private Scene telaAfastamento;

	private Scene telaOnibus;
	private Scene telaCadastrarOnibus;
	private Scene telaVistorias;
	private Scene telaDocumentos;
	private Scene telaVencimentos;	


	private static Stage mainStage;

	private static Telas instance;

	private Telas() {

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
			{ // Repare no IF.
				telaVistorias = new Scene(FXMLLoader.load(getClass().getResource("telavistorias.fxml")));
			}
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
			if (telaInicial == null) { // Repare no IF.
				telaInicial = new Scene(FXMLLoader.load(getClass().getResource("telainicial.fxml")));
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

}
