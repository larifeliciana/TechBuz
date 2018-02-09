package GUI;

import java.sql.Date;

import beans.BancoDeHoras;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import negocio.ControlaBanco;

public class BancoController {

	private String cpf;
    @FXML
    private TableView<BancoDeHoras> tabelaHoras;

    @FXML
    private TableColumn<BancoDeHoras, Date> data;
    
    

    @FXML
    private TableColumn<BancoDeHoras, Integer> qtd;

    @FXML
    private DatePicker d1;

    @FXML
    private DatePicker d2;

    @FXML
    private Label horas;

    ControlaBanco banco = new ControlaBanco();
    
    @FXML void initialize()
    {
    	cpf = Telas.getInstance().getCpf();
    	data.setCellValueFactory(new PropertyValueFactory<>("dia"));
    	qtd.setCellValueFactory(new PropertyValueFactory<>("qtd_horas"));
		
    	tabelaHoras.setItems(FXCollections.observableArrayList(banco.listarBancoDeHorasFuncionario(cpf)));
		
    }
    @FXML
    void calcular() {

    	horas.setText(""+banco.calcular(Date.valueOf(d1.getValue()), Date.valueOf(d2.getValue()), cpf));
    }

}
