package GUI;

import java.sql.Date;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import negocio.ControlaViagem;

public class checarViagemController {

    @FXML
    private TextField placa;

    @FXML
    private DatePicker data;
    
    @FXML private Label msg;

    ControlaViagem viagens = new ControlaViagem();
    @FXML
    void verificar() {

  	boolean rs = viagens.checarViagemDiaOnibus(Date.valueOf(data.getValue()), placa.getText());
  	
  	if(rs)
  		msg.setText("Há viagem desse ônibus nessa data");
  	else
  	{
  		msg.setText("Não há viagem desse ônibus nessa data");
  	}
    	
    }

}
