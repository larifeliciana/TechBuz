

package GUI;

import java.sql.Date;
import java.util.ArrayList;

import beans.Afastamento;
import beans.Funcionario;
import beans.TipoAfastamento;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArrayBase;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import negocio.ControlaAfastamento;
import negocio.ControlaFuncionario;

public class AfastamentoController {
	

	private String cpfString;
	@FXML
	private Label nome;

	@FXML
	private Label cpf;

	@FXML
	private DatePicker inicio;

	@FXML
	private DatePicker fim;

	@FXML 
	private TableView<Afastamento> tabela;

	@FXML
	private TableColumn<Afastamento, Date> colunaInicio;

	@FXML
	private TableColumn<Afastamento, Date> colunaFim;

	@FXML
	private TableColumn<Afastamento, String> colunaTipo;

	@FXML
	private ChoiceBox<TipoAfastamento> tipo;

	@FXML private Label msg;

	ControlaAfastamento afastamentos = new ControlaAfastamento();
	
	@FXML void initialize()
	{
	
		cpfString = Telas.getInstance().getCpf();
	
		
		ControlaFuncionario funcionarios = new ControlaFuncionario();
		Funcionario a = funcionarios.buscarFuncionario(cpfString);
		
		this.nome.setText(a.getNome());
		
		this.cpf.setText(cpfString);
		
		ArrayList<TipoAfastamento> tipoArray = afastamentos.listarTipoAfastamento();
		
		
		colunaInicio.setCellValueFactory(new PropertyValueFactory<>("inicio"));
		colunaFim.setCellValueFactory(new PropertyValueFactory<>("fim"));
		colunaTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
      
		
		ObservableList listat = FXCollections.observableArrayList(afastamentos.listarAfastamentoFuncionario(cpfString));
		tabela.setItems(listat);
			
		ObservableList listar = FXCollections.observableArrayList(afastamentos.listarTipoAfastamento());
		
		tipo.setItems(listar);
	}
	@FXML
	void alterar() {

		//fazer alterar no stricpt
	}

	@FXML
	void cadastrar() {
		
		Afastamento novo = new Afastamento();
		
		novo.setInicio(Date.valueOf(this.inicio.getValue()));
		novo.setFim(Date.valueOf(this.fim.getValue()));
		novo.setFuncionario_cpf(cpfString);
		novo.setTipo_cod(this.tipo.getValue().getCod());
		
		msg.setText(afastamentos.cadastrarAfastamento(novo));
		
		
		

	}

	@FXML
	void remover() {

	}

	@FXML void encerrar()
	{
		afastamentos.EncerraAfastamento(tabela.getSelectionModel().getSelectedItem().getCodigo());
	}
}
