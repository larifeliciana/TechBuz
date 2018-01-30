

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
	private TableView tabela;

	@FXML
	private TableColumn<Afastamento, Date> colunaInicio;

	@FXML
	private TableColumn<Afastamento, Date> colunaFim;

	@FXML
	private TableColumn<Afastamento, String> colunaTipo;

	@FXML
	private ChoiceBox<String> tipo;

	@FXML private Label msg;

	@FXML void initialize()
	{
	
		cpfString = Telas.getInstance().getCpf();
	
		
		ControlaFuncionario funcionarios = new ControlaFuncionario();
		Funcionario a = funcionarios.buscarFuncionario(cpfString);
		
		this.nome.setText(a.getNome());
		
		this.cpf.setText(cpfString);
		ControlaAfastamento afastamentos = new ControlaAfastamento();
		
		ArrayList<TipoAfastamento> tipoArray = afastamentos.listarTipoAfastamento();
		ArrayList<String> tipoString = new ArrayList<String>();
		
		for(int i = 0; i < tipoArray.size(); i++)
		{
			tipoString.add(tipoArray.get(i).getDescricao());
		}
		
		ObservableList lista = FXCollections.observableArrayList(tipoString);
	
		colunaInicio.setCellValueFactory(new PropertyValueFactory<>("inicio"));
		colunaFim.setCellValueFactory(new PropertyValueFactory<>("fim"));
		colunaTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
      
		
		ObservableList listat = FXCollections.observableArrayList(afastamentos.listarAfastamentoFuncionario(cpfString));
		tabela.setItems(listat);
			
		tipo.setItems(lista);
	}
	@FXML
	void alterar() {

		//fazer alterar no stricpt
	}

	@FXML
	void cadastrar() {
		
		Afastamento novo = new Afastamento();
		ControlaAfastamento afastamentos = new ControlaAfastamento();
		
		novo.setInicio(Date.valueOf(this.inicio.getValue()));
		System.out.println(novo.getInicio());
		novo.setFim(Date.valueOf(this.fim.getValue()));
		System.out.println(novo.getFim());
		novo.setFuncionario_cpf(cpfString);
		System.out.println(novo.getFuncionario_cpf());
		ArrayList<TipoAfastamento> tipos = new ArrayList<TipoAfastamento>();
		tipos = afastamentos.listarTipoAfastamento();
		
		
		for(int i = 0; i < tipos.size(); i++)
		{
			if(this.tipo.getValue().toString().equals(tipos.get(i).getDescricao()))
				novo.setCodigo(tipos.get(i).getCod());
			
		}
		
		System.out.println(novo.getCodigo());
		msg.setText(afastamentos.cadastrarAfastamento(novo));
		
		
		

	}

	@FXML
	void remover() {

	}

}
