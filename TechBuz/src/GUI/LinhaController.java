package GUI;

import beans.Linha;
import beans.Trajeto;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import negocio.ControlaLinha;

public class LinhaController {

    @FXML
    private TableView<Linha> linhas;

    @FXML
    private TableColumn<Linha, String> numero;

    @FXML
    private TableColumn<Linha, String> nome;

    @FXML
    private TableColumn<Linha, String> tipo_tarifa;

    @FXML
    private TableView<Trajeto> trajeto;

    @FXML
    private TableColumn<Trajeto, Integer> numeracao;

    @FXML
    private TableColumn<Trajeto, String> rua;

    @FXML
    private TableColumn<Trajeto, String> bairro;
    
    @FXML
    private TableColumn<Trajeto, String> cidade;


    ControlaLinha linhasC = new ControlaLinha();
    
    @FXML void initialize()
    {
    	nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
    	numero.setCellValueFactory(new PropertyValueFactory<>("numero"));
    	tipo_tarifa.setCellValueFactory(new PropertyValueFactory<>("tarifa_cod"));
		
    	
    	linhas.setItems(FXCollections.observableArrayList(linhasC.listarLinhas()));
    
    	EventHandler selecionouLinha = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {

				atualizarTabelaTrajeto();
			}
		};   
    	linhas.setOnMouseClicked(selecionouLinha);
    	
    	numeracao.setCellValueFactory(new PropertyValueFactory<>("numeracao"));
    	rua.setCellValueFactory(new PropertyValueFactory<>("rua"));
    	bairro.setCellValueFactory(new PropertyValueFactory<>("bairro"));
    	cidade.setCellValueFactory(new PropertyValueFactory<>("cidade"));
    	
    }
    
    @FXML void atualizarTabelaTrajeto()
    {
    	String linha = linhas.getSelectionModel().getSelectedItem().getNumero();
    	
    	trajeto.setItems(FXCollections.observableArrayList(linhasC.listarTrajeto(linha)));
    }
}
