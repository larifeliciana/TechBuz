import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.application.Application;
import javafx.stage.Stage;



import GUI.Telas;
import Repositorio.Teste;
import beans.Empresa;
import beans.Endereco;
import beans.Funcionario;
import beans.Login;
import javafx.stage.Stage;
import negocio.ControlaFuncionario;
import negocio.ControlaOnibus;

public class Main extends Application{
	
	
	@Override
	public void start(Stage primaryStage) {
		
		try {
		
			Login novo = new Login();
			novo.setOpcode(0);
			Telas.getInstance().setLogado(novo);
			
			Telas.getInstance().setMainStage(primaryStage);
			Telas.getMainStage().setTitle("TechBuz");
			Telas.getMainStage().setResizable(false);
			Telas.setScene(Telas.getInstance().getTelaLogin());
		
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
			launch(args);
	//	ControlaOnibus onibus = new ControlaOnibus();
		//System.out.println(onibus.acharCod());
	}
}  


	

