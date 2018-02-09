package GUI;

import Repositorio.Conectar;
import beans.Login;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import negocio.ControlaLogin;

public class LoginController {

	ControlaLogin login = new ControlaLogin();
    @FXML
    private TextField login_cpf;

    @FXML
    private PasswordField senha;

    @FXML
    private Label msg;

    @FXML
    void logar() {
    	

    	Login logar = login.checarLogin(login_cpf.getText(), senha.getText());
    	
		
    	if(logar.getOpcode()>0)
    	{
    		Telas.getInstance().setLogado(logar);
    	
    		System.out.println("logou");
    		Conectar.getInstance().fechar();
    		Conectar.getInstance();
    		Telas.setScene(Telas.getInstance().getTelaInicial());
    	}
    	
    	msg.setText("Erro ao logar");
    	
    	
    }

}
