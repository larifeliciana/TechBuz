package GUI;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class VencimentosController {

    @FXML
    private TableView<?> vencimentos;

    @FXML
    private TableColumn<?, ?> colunaData;

    @FXML
    private TableColumn<?, ?> colunaDescricao;

    @FXML
    private Label placa;

    @FXML
    private DatePicker validade;

    @FXML
    private TextField descricao;

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
