package GUI;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class DocumentosController {

    @FXML
    private TextField tipo;

    @FXML
    private TableView<?> documento;

    @FXML
    private TableColumn<?, ?> colunaId;

    @FXML
    private TableColumn<?, ?> colunaEmissao;

    @FXML
    private TableColumn<?, ?> colunaValidade;

    @FXML
    private TableColumn<?, ?> colunaTipo;

    @FXML
    private TableColumn<?, ?> colunaDescricao;

    @FXML
    private Label placa;

    @FXML
    private DatePicker emissao;

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
    void remover(	) {

    }

}
