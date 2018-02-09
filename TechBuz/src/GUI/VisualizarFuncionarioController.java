package GUI;

import beans.Endereco;
import beans.Funcionario;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import negocio.ControlaFuncionario;

public class VisualizarFuncionarioController {

	private String cpfString;
    @FXML
    private ImageView foto;

    @FXML
    private Label cargo;

    @FXML
    private Label ativo;

    @FXML
    private Label disponibilidade;

    @FXML
    private Label data_admissao;

    @FXML
    private MenuBar menu;

    @FXML
    private Menu menuOcorrencia;

    @FXML 
    private MenuItem adicionarOcorrencia;
    @FXML 
    private MenuItem RemoverOcorrencia;
    
    @FXML
    private Menu menuAfastamento;

    @FXML
    private Menu menuBancoHoras;

    @FXML
    private Menu menuTreinamento;

    @FXML
    private Label nome;

    @FXML
    private Label cpf;

    @FXML
    private Label telefone;

    @FXML
    private Label email;

    @FXML
    private Label celular;

    @FXML
    private Label rg;

    @FXML
    private Label nascimento;

    @FXML
    private Label rua;

    @FXML
    private Label numero;

    @FXML
    private Label bairro;

    @FXML
    private Label cep;

    @FXML
    private Label estado;

    @FXML
    private Label cidade;

    @FXML
    private Label complemento;
    
    
    @FXML private void initialize()
    {
    	String cpf = Telas.getInstance().getCpf();
    	this.cpfString = cpf;
    	
    	ControlaFuncionario funcionarios = new ControlaFuncionario();
    	int cargoInt = funcionarios.acharTipo(cpf) ;
    	//System.out.println(cargoInt+"+++");
    	String cargos = "";
    	
    	if(cargoInt == 1)
    	cargos = "Motorista";
    	
    	if(cargoInt == 2)
        	cargos = "Cobrador";
    	
    	if(cargoInt == 3)
        	cargos = "Fiscal";
    	
    	if(cargoInt == 4)
        	cargos = "Motorista";
    	
    	cargo.setText(cargos);
    	
    //	System.out.println("1");
    	Funcionario novo = funcionarios.buscarFuncionario(cpf);
    	
    	this.nome.setText(novo.getNome());
    	this.cpf.setText(novo.getCpf());
    	
    	System.out.println("2");
    	
    	if(novo.getAtivo().equals("S"))
    		this.ativo.setText("Ativo");
    	else
    		this.ativo.setText("Inativo");
    	this.telefone.setText(novo.getFone_2());
    	
    	if(novo.getDisponibilidade().equals("S"))
    		this.disponibilidade.setText("Disponível");
    	else
    		this.disponibilidade.setText("Indisponível");
    	
    	this.data_admissao.setText(novo.getData_admissao().toString());
    	this.email.setText(novo.getEmail());
    	this.rg.setText(novo.getIdentidade());
    	this.nascimento.setText(novo.getNascimento().toString());
    	this.celular.setText(novo.getFone_1());
    	
    	Endereco endereco = funcionarios.buscaEnderecoFuncionario(cpf);
    	
    	this.cep.setText(endereco.getCep());
    	this.bairro.setText(endereco.getBairro());
    	this.cidade.setText(endereco.getCidade());
    	this.estado.setText(endereco.getEstado());
    	this.complemento.setText(endereco.getComplemento());
    	this.rua.setText(endereco.getRua());
    	this.numero.setText(endereco.getNumero());
    //	this.foto.setImage(funcionarios.pegarFoto(cpf));
    	//endereco de funcionario
    	
    	
    }

    public  void telaOcorrencia()
    
    {
    	
    	Stage tela = new Stage();
    	tela.setScene(Telas.getInstance().getTelaOcorrencia());
    	tela.show();
    }
    
  public  void telaBanco()
    
    {
    	
    	Stage tela = new Stage();
    	tela.setScene(Telas.getInstance().getTelaBanco());
    	tela.show();
    }
    
    
    @FXML private void voltar()
    {
    	Telas.getInstance().setScene(Telas.getInstance().getTelaInicial());
    }
    
    public void telaAdicionarOcorrencia()
    {

    	Stage tela = new Stage();
    	tela.setScene(Telas.getInstance().getTelaAdicionarOcorrencia());
    	tela.show();

    }
    
    public void telaAfastamento()
    {

    	Stage tela = new Stage();
    	tela.setScene(Telas.getInstance().getTelaAfastamento());
    	tela.show();

    }
}
