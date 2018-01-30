package GUI;

import java.sql.Date;

import beans.Funcionario;
import beans.Ocorrencia;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import negocio.ControlaFuncionario;
import negocio.ControlaOcorrencia;

public class OcorrenciaController {

    @FXML
    private Label nome;

    @FXML
    private Label cpf;
    
    @FXML
    private TableView tabela;

    @FXML
    private TableColumn<Ocorrencia, Date> colunaData;

    @FXML
    private TableColumn<Ocorrencia, String> colunaStatus;

    @FXML
    private TableColumn<Ocorrencia, String> colunaTipo;
    
    @FXML
    private TableColumn<Ocorrencia, String> colunaCod;


    @FXML
    private Button alterar;

    @FXML
    private Button remover;

    @FXML
    private Button visualizar;

    @FXML private void initialize(){
    	ControlaOcorrencia ocorrencias = new ControlaOcorrencia();
    	ControlaFuncionario funcionarios = new ControlaFuncionario();
    	
    	System.out.println(Telas.getInstance().getCpf());
    	
    	colunaData.setCellValueFactory(new PropertyValueFactory<>("data_ocorrencia"));
		colunaStatus.setCellValueFactory(new PropertyValueFactory<>("status_ocorrencia"));
		colunaTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
		colunaCod.setCellValueFactory(new PropertyValueFactory<>("cod"));
		String cpf1 = Telas.getInstance().getCpf();
		
		Funcionario a = funcionarios.buscarFuncionario(cpf1);
		
		this.cpf.setText(cpf1);
		this.nome.setText(a.getNome());
		tabela.setItems(FXCollections.observableArrayList(ocorrencias.listarOcorrenciaFuncionario(cpf1)));
	
    }
    
    @FXML private void remover()
    {
    	
    System.out.println("remover");
    	 Ocorrencia novo =  (Ocorrencia) 		tabela.getSelectionModel().getSelectedItem();
		 ControlaOcorrencia ocorrencias = new ControlaOcorrencia();
		 //System.out.println(novo.getCpf());
		 String tipo =  ocorrencias.acharTipo(novo.getCod());
		 int opcode = 0;
		 if (tipo == "Falta")
			 opcode =1;
		 else if (tipo == "Atraso")
			 opcode = 2;
		 else if(tipo == "Multa")
			 opcode = 3;
		 
		 ocorrencias.removerOcorrenciaI(novo.getCod(),  opcode);
		 
		 tabela.setItems(FXCollections.observableList(ocorrencias.listarOcorrenciaFuncionario(novo.getFuncionario_cpf())));

    	
    	
    }
}
