package GUI;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Telas {

	private Scene telaInicial;
	private Scene telaEmpresas;
	private String cpf;
	
	private Scene telaFuncionarios;
	private Scene telaVisualizarFuncionario;
	private static Stage mainStage;

	private static Telas instance;

	private Telas() {

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
				// Esta linha cria uma Scene a partir de um Root, O root Ã©
				// gerado pelo FXMLLoader e ele lanÃ§a uma exceÃ§Ã£o.
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
				if (telaFuncionarios == null) { // Repare no IF.
					// Esta linha cria uma Scene a partir de um Root, O root Ã©
					// gerado pelo FXMLLoader e ele lanÃ§a uma exceÃ§Ã£o.
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
				if (this.telaVisualizarFuncionario == null) { // Repare no IF.
					// Esta linha cria uma Scene a partir de um Root, O root Ã©
					// gerado pelo FXMLLoader e ele lanÃ§a uma exceÃ§Ã£o.
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
				if (telaEmpresas == null) { // Repare no IF.
					// Esta linha cria uma Scene a partir de um Root, O root Ã©
					// gerado pelo FXMLLoader e ele lanÃ§a uma exceÃ§Ã£o.
					telaEmpresas = new Scene(FXMLLoader.load(getClass().getResource("telaempresas.fxml")));
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("ERROOOOO");
			}
			return telaEmpresas;
		}

}
