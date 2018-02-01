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
import javafx.stage.Stage;
import negocio.ControlaFuncionario;
import negocio.ControlaOnibus;

public class Conexao extends Application{
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Telas.getInstance().setMainStage(primaryStage);
			Telas.getMainStage().setTitle("TechBuz");
			Telas.getMainStage().setResizable(false);
			Telas.setScene(Telas.getInstance().getTelaInicial());
			
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


	

