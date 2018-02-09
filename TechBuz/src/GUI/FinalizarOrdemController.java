package GUI;

import java.sql.Date;
import java.sql.Time;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import negocio.ControlaOnibus;

public class FinalizarOrdemController {

    @FXML
    private TextField mecanico_chefe;

    @FXML
    private TextField orcamento;

    @FXML
    private TextField inicio;

    @FXML
    private DatePicker data;

    @FXML
    private TextField fim;

    int ordem;
    ControlaOnibus onibus = new ControlaOnibus();
    
    @FXML
    void finalizar() {

    	ordem = Telas.getInstance().getOrdem();
    	System.out.println(ordem);
    	System.out.println(onibus.updateOrdem(ordem, Float.valueOf(orcamento.getText()), Date.valueOf(data.getValue()), Time.valueOf(inicio.getText()), Time.valueOf(fim.getText()), mecanico_chefe.getText()));
    	
    }

}
