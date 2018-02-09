package GUI;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Empresa;
import beans.Funcionario;
import beans.Servico;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import negocio.ControlaEmpresa;
import negocio.ControlaFuncionario;
import negocio.ControlaOnibus;

public class OrdemServicoController {

	@FXML
	private DatePicker data;

	@FXML
	private ChoiceBox<Funcionario> gerente;

	@FXML
	private ChoiceBox<Empresa> oficina;

	private String placa;

	@FXML
	private ChoiceBox<String> status;

	@FXML Label msg;

	@FXML
	private TableView<Servico> servico;

	@FXML TableColumn<Servico, String> coluna;

	@FXML TableColumn<Servico, String> obs;

	@FXML TextArea descricao;
	ControlaEmpresa empresas = new ControlaEmpresa();

	ControlaFuncionario funcionarios = new ControlaFuncionario();

	ControlaOnibus onibus = new ControlaOnibus();

	@FXML void initialize()
	{
		placa = Telas.getInstance().getPlaca();
		//
		//    	coluna.setCellValueFactory(new PropertyValueFactory<>("descricao"));
		//    	obs.setCellValueFactory(new PropertyValueFactory<>("obs"));
		//    	
		servico.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);


		coluna = new TableColumn("Descricão");
		obs = new TableColumn("Obs");
		this.coluna.setCellValueFactory(new PropertyValueFactory<>("descricao"));
		this.obs.setCellValueFactory(new PropertyValueFactory<>("obs"));

		ObservableList nova = FXCollections.observableArrayList(onibus.listarServicos());

		servico.getColumns().addAll(coluna, obs);
		servico.setItems(nova);
		//
		//			
		////    	
		ObservableList lista = FXCollections.observableArrayList(funcionarios.retornarAtivosGerente());
		//    
		gerente.setItems(lista);
		//placa x achar empresa x todasoficinas(cnpj);    	
		//ObservableList lista1 = FXCollections.observableArrayList(empresas.todasEmpresasOficina());
		//    	
		//oficina.setItems(lista1);
		//    
		//
		
		carregarOficinas();
		
				ObservableList lista3 = FXCollections.observableArrayList("Em Avaliação", "Solicitado", "Concluído");
		this.status.setItems(lista3);
		//    	
	}	
	//
	
	@FXML void carregarOficinas()
	{
		ObservableList lista1 = FXCollections.observableArrayList(onibus.listaOficinasComContrato(onibus.acharCnpj(placa)));
		oficina.setItems(lista1);
		
	}
	@FXML void gerar()
	{

		ObservableList a =  servico.getSelectionModel().getSelectedItems();
		java.sql.Date data = Date.valueOf(this.data.getValue());
		try {
			onibus.inserirOrdem(descricao.getText(),data,  this.gerente.getValue().getCpf(), this.oficina.getValue().getCnpj(), Telas.getInstance().getCodigo(), this.status.getValue());
			System.out.println(descricao.getText()+" "+data +" "+ this.gerente.getValue().getCpf() +" "+ this.oficina.getValue().getCnpj() +" "+ Telas.getInstance().getCodigo()+" "+ this.status.getValue());
			int cod = onibus.acharCod();

			for(int i = 0; i<a.size(); i++)

			{

				onibus.inserirCompostaPor(cod, ((Servico) a.get(i)).getCod());
			}
		}catch(Exception e)
		{
			msg.setText("Não foi possível concluir");
		}

		msg.setText("Ordem gerada");
		

	}
}
