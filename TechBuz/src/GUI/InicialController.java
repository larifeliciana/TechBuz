package GUI;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class InicialController {
	
	@FXML private Button empresas;
	@FXML private Button funcionarios;
	
	@FXML public void telaEmpresa()
	{
		Telas.setScene(Telas.getInstance().getTelaEmpresas());
	}
	

	@FXML public void telaFuncionarios()
	{
		Telas.setScene(Telas.getInstance().getTelaFuncionarios());
	}
	
	@FXML public void telaOnibus()
	{
		Telas.setScene(Telas.getInstance().getTelaOnibus());
	}
	
	@FXML public void telaLinhas()
	{
		Telas.setScene(Telas.getInstance().getTelaLinhas());
	}
	
	@FXML public void telaViagem()
	{
		Telas.setScene(Telas.getInstance().getTelaViagem());
	}
	
	
	
}
