package GUI;

import java.io.File;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import beans.Endereco;
import beans.Funcionario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import negocio.ControlaFuncionario;


public class FuncionariosController {

	
	ObservableList cargos = FXCollections.observableArrayList("Motorista", "Cobrador", "Fiscal", "Gerente");
	ObservableList estados = FXCollections.observableArrayList("AC","AL","AP","AM","BA","CE","DF","ES","GO","MA","MT","MS","MG","PA","PB","PR","PE","PI","RJ","RN","RS","RO","RR","SC","SP","SE","TO");
	@FXML Button botaoCadastrar;
	@FXML Button foto;
	@FXML Label labelFoto;
	@FXML Label msg;
	@FXML TextField nome;
	@FXML TextField cpf;
	@FXML TextField identidade;
	@FXML TextField cnh;
	@FXML TextField email;
	@FXML TextField fone_1;
	@FXML TextField fone_2;
	@FXML DatePicker nascimento;
	@FXML DatePicker data_admissao;
	@FXML RadioButton m;
	@FXML RadioButton f;
	@FXML ChoiceBox cargo;
	@FXML TextField rua;
	@FXML TextField numero;
	@FXML TextField cep;
	@FXML TextField complemento;
	@FXML TextField bairro;
	@FXML TextField cidade;
	@FXML ChoiceBox estado;
	@FXML TableView tabela;
	@FXML TableColumn<Funcionario, String> colunaNome;
	@FXML TableColumn<Funcionario, String> colunaCpf;
	@FXML TableColumn<Funcionario, String> colunaEmail;
	@FXML ToggleGroup cargoGrupo;
	@FXML ToggleGroup tipoBusca;

	@FXML Button botaoRemover;
	@FXML Button botaoAlterar;
	@FXML Button botaoVisualizar;
	@FXML Button botaoBuscar;
	
	@FXML RadioButton motorista;
	@FXML RadioButton cobrador;
	@FXML RadioButton fiscal;
	@FXML RadioButton gerente;
	@FXML RadioButton todos;
	
	@FXML RadioButton nomeBuscar;
	@FXML RadioButton cpfBuscar;
	

	
	@FXML TextField campoBusca;
	List<Funcionario> funcionarios;
	//	tabela.setItems(FXCollections.observableArrayList(pessoas));

	@FXML private void initialize()
	{
		estado.setItems(estados);
		cargo.setItems(cargos);
		colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		colunaCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
		colunaEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
      


		atualizarTabela();

	}

	


	public void abrirFoto(ActionEvent event)
	{

		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Selecione a planilha");
		fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("JPG", "*.jpg"));        
		File file = fileChooser.showOpenDialog(null);  
		String foto = file.getAbsolutePath();
		labelFoto.setText(foto);
	}

	public void atualizarTabela()
	{
		ControlaFuncionario funcionariosControle = new ControlaFuncionario();

		
		if(todos.isSelected())
		funcionarios = funcionariosControle.retornarAtivos();
		if(motorista.isSelected())
			funcionarios = funcionariosControle.retornarAtivosMotorista();
		if(cobrador.isSelected())
			funcionarios = funcionariosControle.retornarAtivosCobrador();
		if(fiscal.isSelected())
			funcionarios = funcionariosControle.retornarAtivosFiscal();
		if(gerente.isSelected())
			funcionarios = funcionariosControle.retornarAtivosGerente();
		tabela.setItems(FXCollections.observableList(funcionarios));
	}



	public void cadastrar()
	{
		//
		Funcionario a = new Funcionario();
		Endereco b = new Endereco();

		a.setAtivo("S");
		a.setCnh(cnh.getText());
		a.setCpf(cpf.getText());
		a.setData_admissao(Date.valueOf(data_admissao.getValue())); 
		a.setDisponibilidade("S");
		a.setEmail(email.getText());
		a.setFone_1(fone_1.getText());
		a.setFone_2(fone_2.getText());
		a.setFoto(labelFoto.getText()); //o que fazer quando labelFoto for vazio
		a.setIdentidade(identidade.getText());
		a.setNascimento(Date.valueOf(nascimento.getValue()));
		a.setNome(nome.getText());
		if(m.isSelected())
			a.setSexo("M");
		else
			a.setSexo("F");

		b.setBairro(bairro.getText());
		b.setCep(cep.getText());
		b.setCidade(cidade.getText());
		b.setComplemento(complemento.getText());
		b.setEstado(estado.getValue().toString());
		b.setNumero(numero.getText());
		b.setRua(rua.getText());

		ControlaFuncionario funcionarios = new ControlaFuncionario();	

		try {
			if(cargo.getValue().equals("Motorista"))
			{
				msg.setText(funcionarios.cadastrarFuncionarioMotorista(a, b, a.getCnh()));
			}

			if(cargo.getValue().equals("Cobrador"))
			{
				msg.setText(funcionarios.cadastrarFuncionarioCobrador(a, b));
			}

			if(cargo.getValue().equals("Fiscal"))
			{
				msg.setText(funcionarios.cadastrarFuncionarioFiscal(a, b));
			}

			if(cargo.getValue().equals("Gerente"))
			{
				msg.setText(funcionarios.cadastrarFuncionarioGerente(a, b));
			}

			if(msg.getText() == "Funcionario cadastrado")
			{
			labelFoto.setText("");
			nome.setText("");
			cpf.setText("");
			identidade.setText("");
			cnh.setText("");
			email.setText("");
			fone_1.setText("");
			fone_2.setText("");
			nascimento.setValue(null);
			data_admissao.setValue(null);

			cargo.setValue(null);;
			rua.setText("");
			numero.setText("");
			cep.setText("");
			complemento.setText("");
			bairro.setText("");
			cidade.setText("");
			estado.setValue(null);			}
			}catch(Exception e)
		{
			System.out.println("exceção");
		}

		tabela.setItems(FXCollections.observableArrayList(funcionarios));

	}

	public void remover()
	{
		 Funcionario novo =  (Funcionario) 			tabela.getSelectionModel().getSelectedItem();
		 ControlaFuncionario funcionarios = new ControlaFuncionario();
		 //System.out.println(novo.getCpf());
		 
		 funcionarios.removerFuncionario(novo.getCpf(), funcionarios.acharTipo(novo.getCpf()));
		 atualizarTabela();
		
		 
	}
	
	public void alterar()
	{
		
	}
	
	public void visualizar()
	{
		
		Funcionario novo =  (Funcionario) 			tabela.getSelectionModel().getSelectedItem();
		
		System.out.println("MUDOU");
		Telas.getInstance().setCpf(novo.getCpf());
	
		Telas.setScene(Telas.getInstance().getTelaVisualizarFuncionario());
		
	}
	
	
	public void buscar()
	{
	
		String busca = campoBusca.getText();
		ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
		Funcionario ofuncionario = new Funcionario();		
		ControlaFuncionario funcionario = new ControlaFuncionario();
		
		if(cpfBuscar.isSelected())
		{
			if(todos.isSelected())
			{
				ofuncionario = funcionario.buscarFuncionario(busca);
			}
			else if(motorista.isSelected())
			{
				ofuncionario = funcionario.buscarFuncionarioMotorista(busca);
			}
			else if(cobrador.isSelected())
			{
				ofuncionario = funcionario.buscarFuncionarioCobrador(busca);
			}
			else if(fiscal.isSelected())
			{
				ofuncionario = funcionario.buscarFuncionarioFiscal(busca);
			}
			else if(gerente.isSelected())
			{
				ofuncionario = funcionario.buscarFuncionarioGerente(busca);
			}
			funcionarios.add(ofuncionario);
			}
		
		else if(nomeBuscar.isSelected())
		{
			if(todos.isSelected())
			{
				funcionarios = funcionario.buscarFuncionarioNome(busca);
			}
			else if(motorista.isSelected())
			{
				funcionarios = funcionario.buscarFuncionarioMotoristaNome(busca);
			}
			else if(cobrador.isSelected())
			{
				funcionarios = funcionario.buscarFuncionarioCobradorNome(busca);
			}
			else if(fiscal.isSelected())
			{
				funcionarios = funcionario.buscarFuncionarioFiscalNome(busca);
			}
			else if(gerente.isSelected())
			{
				funcionarios = funcionario.buscarFuncionarioGerenteNome(busca);
			}
			
		}
		
		tabela.setItems(FXCollections.observableArrayList(funcionarios));
		
		
		
	}

	
}
