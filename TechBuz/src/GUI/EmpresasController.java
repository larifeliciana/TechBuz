package GUI;

import java.util.ArrayList;

import beans.Empresa;
import beans.Endereco;
import beans.Funcionario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import negocio.ControlaEmpresa;
import negocio.ControlaFuncionario;

public class EmpresasController {

	ObservableList cargos = FXCollections.observableArrayList("Fornecedor", "Matriz", "Oficina");
	ObservableList estados = FXCollections.observableArrayList("AC","AL","AP","AM","BA","CE","DF","ES","GO","MA","MT","MS","MG","PA","PB","PR","PE","PI","RJ","RN","RS","RO","RR","SC","SP","SE","TO");
	
    @FXML
    private TableView<Empresa> tabela;

    @FXML
    private TableColumn<Empresa, String> colunaNome;

    @FXML
    private TableColumn<Empresa, String> colunaCnpj;

    @FXML
    private TableColumn<Empresa, String> colunaEmail;

    @FXML
    private TextField campoBusca;

    @FXML
    private Button botaoBuscar;

    @FXML
    private RadioButton nomeBuscar;

    @FXML
    private ToggleGroup tipoBusca;

    @FXML
    private RadioButton cnpjBuscar;

    @FXML
    private RadioButton fornecedor;

    @FXML
    private ToggleGroup cargoGrupo;

    @FXML
    private RadioButton matriz;

    @FXML
    private RadioButton oficina;

    @FXML
    private RadioButton todos;

    @FXML
    private Label labelFoto;

    @FXML
    private TextField nome;

    @FXML
    private TextField cnpj;
    

    @FXML
    private TextField email;

    @FXML
    private TextField fone1;

    @FXML
    private TextField fone2;

    @FXML
    private TextField fone3;

    @FXML
    private TextField razao_social;

    @FXML
    private TextField rua;

    @FXML
    private TextField numero;

    @FXML
    private TextField cep;

    @FXML
    private TextField complemento;

    @FXML
    private TextField bairro;

    @FXML
    private TextField cidade;

    @FXML
    private ChoiceBox<?> estado;
    

    @FXML
    private ChoiceBox<?> tipo;

    @FXML
    private Button botaoCadastrar;

    @FXML
    private Label msg;

    @FXML private void initialize()
    {
    	estado.setItems(estados);
    	tipo.setItems(cargos);
    	
		colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		colunaCnpj.setCellValueFactory(new PropertyValueFactory<>("cpf"));
		colunaEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
      


		atualizarTabela();

    }
    
    
    
    @FXML private void voltar()
    {
    	Telas.getInstance().setScene(Telas.getInstance().getTelaInicial());
    }
    @FXML
    void atualizarTabela() {

    	ControlaEmpresa empresaControle = new ControlaEmpresa();
    	ArrayList<Empresa> empresa = new ArrayList<Empresa>();
		
		if(todos.isSelected())
		empresa = empresaControle.todasEmpresas(0);
		if(this.fornecedor.isSelected())
			empresa = empresaControle.todasEmpresasFornecedor();
		if(this.matriz.isSelected())
			empresa = empresaControle.todasEmpresasMatriz();
		if(this.oficina.isSelected())
			empresa = empresaControle.todasEmpresasOficina();
		
		tabela.setItems(FXCollections.observableList(empresa));
    }

    @FXML
    private void buscar() {

    	String busca = campoBusca.getText();
		ArrayList<Empresa> funcionarios = new ArrayList<Empresa>();
		Empresa oempresa = new Empresa();		
		ControlaEmpresa empresa = new ControlaEmpresa();
		
		if(cnpjBuscar.isSelected())
		{
			if(todos.isSelected())
			{
				oempresa = empresa.buscaEmpresaBD(busca, 0);
			}
			else if(fornecedor.isSelected())
			{
				oempresa = empresa.buscaEmpresaFornecedorBD(busca);
			}
			else if(matriz.isSelected())
			{
				oempresa = empresa.buscaEmpresaMatrizBD(busca);
			}
			else if(oficina.isSelected())
			{
				oempresa = empresa.buscaEmpresaOficinaBD(busca);
			}
			
			
			funcionarios.add(oempresa);
			}
	
		tabela.setItems(FXCollections.observableArrayList(funcionarios));
		
    }
    

    @FXML
    void cadastrar() {

    	//empresa
    	ControlaEmpresa empresas = new ControlaEmpresa();
    	
    	Empresa empresa = new Empresa();
    	Endereco endereco = new Endereco();
    	int opcode;
    	
    	empresa.setCnpj(this.cnpj.getText());
    	empresa.setEmail(this.email.getText());
    	empresa.setNome(this.nome.getText());
    	empresa.setRazao_social(this.razao_social.getText());
    	empresa.setTipo(this.tipo.getValue().toString());
    	
    	endereco.setBairro(this.bairro.getText());
    	endereco.setCep(this.cep.getText());
    	endereco.setCidade(this.cidade.getText());
    	endereco.setComplemento(this.complemento.getText());
    	endereco.setEmpresa_cnpj(this.cnpj.getText());
    	endereco.setEstado(estado.getValue().toString());
    	endereco.setNumero(this.numero.getText());
    	endereco.setRua(rua.getText());
    	
    	if(empresa.getTipo().equals("Fornecedor"));
    		opcode = 1;
    	
    	if(empresa.getTipo().equals("Matriz"));
    		opcode = 2;
    	
    	if(empresa.getTipo().equals("Oficina"));
    		opcode = 3;
    	
    	msg.setText(empresas.cadastrarEmpresaBD(empresa, endereco, opcode));
    	
    	
    	if(fone1.getText()!=null)
    	{
    		empresas.adicionarTelefone(fone1.getText(), empresa.getCnpj());
    	}
    		

       	if(fone2.getText()!=null)
       	{
       		empresas.adicionarTelefone(fone2.getText(), empresa.getCnpj());
       	}

       	if(fone3.getText()!=null)
       	{
       		
       		empresas.adicionarTelefone(fone3.getText(), empresa.getCnpj());
       	}
    	

       	this.bairro.setText("");
       	this.cep.setText("");
       	cidade.setText("");
       	estado.setValue(null);
       	numero.setText("");
       	complemento.setText("");
       	nome.setText("");
       	cnpj.setText("");
       	razao_social.setText("");
       	email.setText("");
       	nome.setText("");
       	
       	fone1.setText("");
       	fone2.setText("");
       	fone3.setText("");
       	
       	atualizarTabela();
    }

  
    @FXML
    void visualizar() {

    }
    
    
    @FXML
    private void remover() {

    	Empresa nova = new Empresa();
    	ControlaEmpresa empresas = new ControlaEmpresa();
    	
    	nova = tabela.getSelectionModel().getSelectedItem();
    	empresas.removerEmpresaBD(nova.getCnpj(), empresas.acharTipo(nova.getCnpj()));
    	
    	atualizarTabela();
    	

    }


}
