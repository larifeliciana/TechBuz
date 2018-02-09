package GUI;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;

import beans.Funcionario;
import beans.Linha;
import beans.Onibus;
import beans.Viagem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import negocio.ControlaFuncionario;
import negocio.ControlaLinha;
import negocio.ControlaOnibus;
import negocio.ControlaViagem;

public class ViagensController {
	
	ControlaViagem viagem = new ControlaViagem();

    @FXML
    private TableView<Viagem> viagens;

    @FXML
    private TableColumn<Viagem, String> colunaOnibus;

    @FXML
    private TableColumn<Viagem, String> colunaLinha;

    @FXML
    private TableColumn<Viagem, String> colunaMotorista;

    @FXML
    private TableColumn<Viagem, String> colunaCobrador;

    @FXML
    private TableColumn<Viagem, Time> colunaHorario;

    @FXML
    private TableColumn<Viagem, String> status;

    @FXML
    private DatePicker data;

    @FXML
    private Button finalizar;

    @FXML
    private Button remover;

    @FXML
    private Button alterar;

    @FXML
    private Button cadastrar;

    @FXML
    private ChoiceBox<Onibus> placa;

    @FXML
    private ChoiceBox<Linha> linha;

    @FXML
    private ChoiceBox<Funcionario> motorista;

    @FXML
    private ChoiceBox<Funcionario> cobrador;

    @FXML
    private TextField data_hora;
    
    ControlaOnibus onibus = new ControlaOnibus();
    ControlaFuncionario funcionarios = new ControlaFuncionario();
    ControlaLinha linhas = new ControlaLinha();

    @FXML 
    void initialize()
    {
    	this.colunaCobrador.setCellValueFactory(new PropertyValueFactory<>("cobrador_cpf"));

    	this.colunaHorario.setCellValueFactory(new PropertyValueFactory<>("hora"));

    	this.colunaLinha.setCellValueFactory(new PropertyValueFactory<>("linha"));

    	this.colunaMotorista.setCellValueFactory(new PropertyValueFactory<>("motorista_cpf"));

    	this.colunaOnibus.setCellValueFactory(new PropertyValueFactory<>("placa"));
    	
    	this.status.setCellValueFactory(new PropertyValueFactory<>("status_viagem"));
    	
    	placa.setItems(FXCollections.observableArrayList(onibus.listarOnibus()));
    	linha.setItems(FXCollections.observableArrayList(linhas.listarLinhas()));
    	motorista.setItems(FXCollections.observableArrayList(funcionarios.retornaDisponiveisMotorista()));
    	cobrador.setItems(FXCollections.observableArrayList(funcionarios.retornaDisponiveisCobrador()));



		
    }
    
    @FXML void atualizarTabela()
    {
  
    	ArrayList<Viagem> lista1 = this.viagem.listarViagemData(Date.valueOf(data.getValue()));
   
    	ObservableList lista = FXCollections.observableArrayList(lista1);
    	viagens.setItems(lista);
    }
    @FXML
    void alterar() {
    	
    	Telas.getInstance().setViagem(viagens.getSelectionModel().getSelectedItem());
    	Stage novatela = new Stage();
    	novatela.setScene(Telas.getInstance().getTelaAlterarViagem());
    	novatela.show();
    }
    
    @FXML void voltar(){
    	Telas.setScene(Telas.getInstance().getTelaInicial());
    }

    @FXML
    void cadastrar() {
    	
    	Viagem a = new Viagem();
    	a.setCobrador_cpf(cobrador.getValue().getCpf());
    	a.setData_hr_min(Timestamp.valueOf(this.data_hora.getText()));
    	a.setLinha(linha.getValue().getNumero());
    	a.setPlaca(placa.getValue().getPlaca());
    	a.setMotorista_cpf(motorista.getValue().getCpf());
    	a.setStatus_viagem("Prevista");
    	
    	System.out.println(this.viagem.cadastrarViagem(a));
    	atualizarTabela();
    }

    @FXML
    void finalizar() {
    	Viagem nova = this.viagens.getSelectionModel().getSelectedItem();
   
    	if(nova != null) {
    	Telas.getInstance().setViagem(nova);
    	Stage novatela = new Stage();
    	novatela.setScene(Telas.getInstance().getTelaFinalizarViagem());
    	novatela.show();}
    	else
    	System.out.println("impossivel");
    }

    @FXML
    void remover() {
    	Viagem nova = this.viagens.getSelectionModel().getSelectedItem();
    	   
    	viagem.removerViagem(nova.getPlaca(), nova.getLinha(), nova.getData_hr_min());
    	
    	this.atualizarTabela();
    }

    @FXML
    void telaChecar() {


    	Stage novatela = new Stage();
    	novatela.setScene(Telas.getInstance().getTelaChecarViagem());
    	novatela.show();
    }

}
	