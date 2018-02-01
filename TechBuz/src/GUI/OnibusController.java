package GUI;

import java.sql.Date;
import java.util.ArrayList;

import beans.Acessorio;
import beans.Empresa;
import beans.Frota;
import beans.Ocorrencia;
import beans.OcorrenciaOnibus;
import beans.Onibus;
import beans.Peca;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import negocio.ControlaEmpresa;
import negocio.ControlaOnibus;

public class OnibusController {


	@FXML
	TableView<Frota> tabelaFrota;

	@FXML
	private TableColumn<Frota, String> colunaEmpresa;

	@FXML
	private TableColumn<Frota, Integer> colunaIdadeMedia;

	@FXML
	private TableColumn<Frota, Integer> colunaQuantidade;

	@FXML private TableColumn<Frota, String> colunaCnpj;

	@FXML
	private TableView<Onibus> tabelaOnibus;

	@FXML
	private TableColumn<Onibus, String> colunaPlaca;

	@FXML
	private TableColumn<Onibus, String> colunaTipo;

	@FXML
	private TableColumn<Onibus, String> colunaOperacao;

	@FXML
	private TableColumn<Onibus, String> colunaDisponibilidade;

	@FXML
	private TableColumn<Onibus, String> colunaAlocacao;

	@FXML
	private TableColumn<Onibus, Integer> colunaLugares;

	@FXML
	private TableView<OcorrenciaOnibus> tabelaOcorrencias;

	@FXML
	private TableColumn<OcorrenciaOnibus, String> descricao;

	@FXML
	private TableColumn<OcorrenciaOnibus, Date> dataOcorrencia;
	@FXML
	private TableColumn<OcorrenciaOnibus, Date> colunaplaca;

	@FXML
	private TableColumn<OcorrenciaOnibus, Date> tipo;


	@FXML
	private TableView<Acessorio> tabelaAcessorios;


	@FXML
	private TableColumn<Acessorio, String> colunaDescricao1;
	@FXML
	private TableColumn<Acessorio, String> colunaMarca2;

	@FXML
	private TableView<Peca> pecas;

	@FXML
	private TableColumn<Peca, String> colunaNome;

	@FXML
	private TableColumn<Peca, String> colunaMarca;

	@FXML
	private TableColumn<Peca, Integer> colunaCodigo;

	@FXML
	private TableColumn<Peca, Integer> colunaQuantidade1;

	@FXML
	private TableView<Acessorio> acessorios;

	@FXML
	private TableColumn<Acessorio, String> colunaNome1;

	@FXML
	private TableColumn<Acessorio, String> colunaMarca1;

	@FXML
	private TableColumn<Acessorio, String> colunaEstado;

	@FXML
	private TextField placa;

	@FXML
	private TextField nome;

	@FXML
	private TextField marca;

	@FXML
	private TextField quantidade;

	@FXML
	private TableView<Empresa> tabelaFornecedor;

	@FXML TableColumn<Empresa, String> colunaNomeFornecedor;

	@FXML TableColumn<Empresa, String> colunaCnpjFornecedor;

	@FXML
	private TextField nome1;

	@FXML
	private TextField marca1;

	@FXML
	private ChoiceBox<?> estado1;

	@FXML private Label msg;

	@FXML private RadioButton SFrota;

	@FXML private RadioButton NFrota;

	@FXML private ToggleGroup fr;

	ControlaOnibus onibus = new ControlaOnibus();

	@FXML void initialize()
	{
		//frota 

		colunaEmpresa.setCellValueFactory(new PropertyValueFactory<>("empresa"));
		this.colunaIdadeMedia.setCellValueFactory(new PropertyValueFactory<>("idade_media"));
		this.colunaQuantidade.setCellValueFactory(new PropertyValueFactory<>("numero_onibus"));
		this.colunaCnpj.setCellValueFactory(new PropertyValueFactory<>("empresa_cnpj"));


		atualizarTabelaFrota();
		///onibus sem frota
		atualizarTabelaOnibus();
		EventHandler selecionouFrota = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if(SFrota.isSelected())
					atualizarTabelaOnibus();

			}
		};

		EventHandler selecionouOnibus = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				//atualizarTabelaOcorrencia();
				//atualizarTabelaAcessorios();
			}
		};


		//		tabelaFrota.setOnMouseExited(value);
		tabelaFrota.setOnMouseClicked(selecionouFrota);

		tabelaOnibus.setOnMouseClicked(selecionouOnibus);


		////ONIBUS
		this.colunaAlocacao.setCellValueFactory(new PropertyValueFactory<>("status_alocacao"));
		this.colunaDisponibilidade.setCellValueFactory(new PropertyValueFactory<>("disponibilidade"));
		this.colunaPlaca.setCellValueFactory(new PropertyValueFactory<>("placa"));
		this.colunaTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
		this.colunaOperacao.setCellValueFactory(new PropertyValueFactory<>("operacao"));
		this.colunaLugares.setCellValueFactory(new PropertyValueFactory<>("sentado"));




		this.descricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
		this.dataOcorrencia.setCellValueFactory(new PropertyValueFactory<>("data_ocorrencia"));
		this.colunaplaca.setCellValueFactory(new PropertyValueFactory<>("onibus_placa"));
		this.tipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));

		ObservableList ocorrencias = FXCollections.observableArrayList(onibus.listarOcorrencia());

		tabelaOcorrencias.setItems(ocorrencias);


		///Acessorio

		//		this.colunaDescricao1.setCellValueFactory(new PropertyValueFactory<>("descricao"));
		//		this.colunaMarca2.setCellValueFactory(new PropertyValueFactory<>("marca"));


		//Acessorio1

		
		this.colunaNome1.setCellValueFactory(new PropertyValueFactory<>("descricao"));
		this.colunaEstado.setCellValueFactory(new PropertyValueFactory<>("marca"));
		this.colunaMarca1.setCellValueFactory(new PropertyValueFactory<>("estado"));

		ObservableList nova = FXCollections.observableArrayList(onibus.listarAcessoriosDisponiveis());

		acessorios.setItems(nova);


		//Fornecedor 
		ControlaEmpresa empresas = new ControlaEmpresa();

		this.colunaCnpjFornecedor.setCellValueFactory(new PropertyValueFactory<>("cnpj"));
		this.colunaNomeFornecedor.setCellValueFactory(new PropertyValueFactory<>("nome"));
		ObservableList nova1 = FXCollections.observableArrayList(empresas.todasEmpresasFornecedor());

		tabelaFornecedor.setItems(nova1);

		EventHandler selecionouFornecedor = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {

				atualizarTabelaPecas();
			}
		};


		tabelaFornecedor.setOnMouseClicked(selecionouFornecedor);

		////PECAS
		this.colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		this.colunaMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
		this.colunaQuantidade1.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
		this.colunaCodigo.setCellValueFactory(new PropertyValueFactory<>("cod"));


	}

	@FXML void atualizarTabelaFrota()
	{

		ObservableList listaFrota = FXCollections.observableArrayList(onibus.listarFrotas());
		System.out.println(listaFrota);
		tabelaFrota.setItems(listaFrota);

	}
	
	@FXML void atualizar()
    {
		System.out.println("atualizar");
		this.atualizarTabelaFrota();
		this.atualizarTabelaOnibus();
			
    }
   
	@FXML public void atualizarTabelaOnibus()
	{


		if(SFrota.isSelected()) {
			try {
				int cod = tabelaFrota.getSelectionModel().getSelectedItem().getCod();

				System.out.println(cod);
				System.out.println("if");


				ObservableList lista = FXCollections.observableArrayList(onibus.listarOnibusFrota(cod));
				tabelaOnibus.setItems(lista);
				ObservableList lista1 = FXCollections.observableArrayList();
				//		tabelaOcorrencias.setItems(lista1);
				//	tabelaAcessorios.setItems(lista1);
			}
			catch(NullPointerException e)
			{
				System.out.println("tem q selecionar");
			}

		}
		else
		{

			System.out.println("ele");
			ObservableList lista2 = FXCollections.observableArrayList(onibus.listarOnibusSemFrota());
			tabelaOnibus.setItems(lista2);
			ObservableList lista1 = FXCollections.observableArrayList();

		}
	}

	void atualizarOnibus(int cod)
	{
		ObservableList lista = FXCollections.observableArrayList(onibus.listarOnibusFrota(cod));
		tabelaOnibus.setItems(lista);

	}
	@FXML  void atualizarTabelaOcorrencia()
	{
		String placa = tabelaOnibus.getSelectionModel().getSelectedItem().getPlaca();

		ObservableList lista = FXCollections.observableArrayList(onibus.listarOcorrenciaOnibus(placa));
		this.tabelaOcorrencias.setItems(lista);

	}

	@FXML void atualizarTabelaPecas()
	{
		String cnpj = tabelaFornecedor.getSelectionModel().getSelectedItem().getCnpj();
		ArrayList<Peca> novo = onibus.listarPecasFornecedor(cnpj);
		System.out.println(cnpj);
		System.out.println(novo);
		ObservableList lista = FXCollections.observableArrayList(novo);
		this.pecas.setItems(lista);
	}

	@FXML  void atualizarTabelaAcessorios()
	{
		String placa = tabelaOnibus.getSelectionModel().getSelectedItem().getPlaca();
		ArrayList<Acessorio> novo = onibus.listarAcessorioOnibus(placa);
		ObservableList lista = FXCollections.observableArrayList(novo);
		this.tabelaAcessorios.setItems(lista);
	}


	@FXML
	void alterarOnibus() {

	}

	@FXML
	void cadastrar() {


	}

	@FXML
	void instalar() {

	}

	@FXML
	void remover() {

	}


	@FXML
	void alterar() {

	}

	@FXML void cadastrarAcessorio(){

	}

	@FXML void gerarOdem()
	{
		int codOcorrencia = tabelaOcorrencias.getSelectionModel().getSelectedItem().getCodigo();
		Telas.getInstance().setCodigo(codOcorrencia);
		Telas.getInstance().setPlaca(tabelaOcorrencias.getSelectionModel().getSelectedItem().getOnibus_placa());
		Stage novatela = new Stage();


		novatela.setScene(Telas.getInstance().getGerarOrdem());
		novatela.show();

	}
	@FXML
	void removerAcessorio() {
		ControlaOnibus onibus  = new ControlaOnibus();

		int cod = this.tabelaAcessorios.getSelectionModel().getSelectedItem().getCodigo();

		onibus.removerAcessorio(cod);

		this.atualizarTabelaAcessorios();


	}

	
	@FXML 
	void adicionarFrota()
	{
		int cod = tabelaFrota.getSelectionModel().getSelectedItem().getCod();

		onibus.adicionarAFrota(tabelaOnibus.getSelectionModel().getSelectedItem().getPlaca(), cod);
		
		atualizarTabelaFrota();
		atualizarTabelaOnibus();
	}
	@FXML void removerDaFrota()
	{
		try {
			int cod = tabelaFrota.getSelectionModel().getSelectedItem().getCod();
			onibus.removerDaFrota(tabelaOnibus.getSelectionModel().getSelectedItem().getPlaca());
			atualizarTabelaFrota();
			atualizarOnibus(cod);
		}
		catch(NullPointerException e)
		{
			msg.setText("Selecione uma frota e um de seus onibus para ser removido");
			//zerar tabela qunado não tiver nada selecionado
		}
	}
	@FXML
	void removerFrota() {

		ControlaOnibus onibus  = new ControlaOnibus();

		int cod = this.tabelaFrota.getSelectionModel().getSelectedItem().getCod();

		System.out.println(onibus.removerFrota(cod));
		//this.atualizarTabelaOnibus();


		ObservableList listaFrota = FXCollections.observableArrayList(onibus.listarFrotas());

		tabelaFrota.setItems(listaFrota);
	}

	@FXML
	void removerOnibus() {

		ControlaOnibus onibus  = new ControlaOnibus();

		String placa = this.tabelaOnibus.getSelectionModel().getSelectedItem().getPlaca();

		System.out.println(onibus.removerOnibusBD(placa));
		this.atualizarTabelaOnibus();



	}

	@FXML
	void telaCadastrar() {

		Stage novatela = new Stage();

		novatela.setScene(Telas.getInstance().getTelaCadastrarOnibus());
		novatela.show();

	}

	@FXML
	void telaDocumento() {


		try{
			Stage novatela = new Stage();


			Telas.getInstance().setPlaca(tabelaOnibus.getSelectionModel().getSelectedItem().getPlaca());
			novatela.setScene(Telas.getInstance().getTelaDocumentos());
			novatela.show();
		}

		catch(Exception e) { 
			msg.setText("Escolha um ônibus para visualizar ou cadastrar seus documentos");
		}}

	@FXML
	void telaOrdemServico() {

	}

	@FXML
	void telaVencimentos() {

		try{
			Stage novatela = new Stage();


			Telas.getInstance().setPlaca(tabelaOnibus.getSelectionModel().getSelectedItem().getPlaca());
			novatela.setScene(Telas.getInstance().gettelaVencimentos());
			novatela.show();
		}

		catch(Exception e) {
			msg.setText("Escolha um ônibus para visualizar ou cadastrar seus vencimentos");
		}
	}

	@FXML
	void telaVistoria() {

		try {
			Stage novatela = new Stage();


			Telas.getInstance().setPlaca(tabelaOnibus.getSelectionModel().getSelectedItem().getPlaca());
			novatela.setScene(Telas.getInstance().getTelaVistorias());
			novatela.show();
		}

		catch(Exception e) { 
			msg.setText("Escolha um ônibus para visualizar ou cadastrar seus documentos");
		}
	}

	@FXML void adicionarOcorrencia()
	{
		try {
			Stage novatela = new Stage();


			Telas.getInstance().setPlaca(tabelaOnibus.getSelectionModel().getSelectedItem().getPlaca());
			novatela.setScene(Telas.getInstance().getTelaAdicionarOcorrencia());
			novatela.show();
		}

		catch(Exception e) {
			msg.setText("Escolha um ônibus para cadastrar suas ocorrencias");
		}

	}
}
