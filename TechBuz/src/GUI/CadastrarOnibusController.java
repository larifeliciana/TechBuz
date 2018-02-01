package GUI;

import java.sql.Date;
import java.util.ArrayList;

import beans.Empresa;
import beans.Onibus;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import negocio.ControlaEmpresa;
import negocio.ControlaOnibus;

public class CadastrarOnibusController {

    @FXML
    private TextField placa;

    @FXML
    private TextField sentados;

    @FXML
    private TextField ano;

    @FXML
    private ChoiceBox<Empresa> empresa;

    @FXML
    private DatePicker data;

    @FXML
    private Label msg;

    
    @FXML ChoiceBox<String> tipo;
    
     @FXML
    void cadatrar() {

    	ControlaOnibus onibus = new ControlaOnibus();
    	Onibus on = new Onibus();
//    	
    	on.setAno(Integer.valueOf(ano.getText()));
    	
    	int cod = Integer.valueOf(onibus.buscarFrota(empresa.getValue().getCnpj()).getCod());
    	
    	on.setCod_frota(cod);
    	on.setData_inclusao(Date.valueOf(this.data.getValue()));
    	on.setDisponibilidade('S');
    	on.setOperacao("VIAGEM/PÚBLICO");
    	on.setPlaca(placa.getText());
    	on.setSentado(Integer.valueOf(sentados.getText()));
    	on.setStatus_alocacao('N');
//    	
    	on.setTipo(tipo.getValue());
    
    	System.out.println(on);
    	msg.setText(onibus.cadastrarOnibusBD(on));
    }

    @FXML void initialize()
    {
    	ControlaEmpresa empresas = new ControlaEmpresa();
    	
    	ArrayList<Empresa> empresa1 = empresas.todasEmpresasMatriz();
    	
    	ObservableList<Empresa> emm = FXCollections.observableArrayList(empresa1);
    	
    	empresa.setItems(emm);
    	
    	ObservableList<String> tipos = FXCollections.observableArrayList("MICRO", "NORMAL", "SANFONA");
    	tipo.setItems(tipos);
    	
    }
}
