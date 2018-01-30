package GUI;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class VistoriaController {

    @FXML
    private TextField fiscalcpf;

    @FXML
    private TableView<?> vistorias;

    @FXML
    private TableColumn<?, ?> colunaData;

    @FXML
    private TableColumn<?, ?> colunaObservacoes;

    @FXML
    private TableColumn<?, ?> colunaFiscal;

    @FXML
    private Label placa;

    @FXML
    private DatePicker data;

    @FXML
    private TextArea observacoes;
    
    
    private String cpf;
    
    @FXML void initialize()
    {
    	
    }

    @FXML
    void alterar() {

    }

    @FXML
    void cadastrar() {

    }

    @FXML
    void remover() {

    }

}
