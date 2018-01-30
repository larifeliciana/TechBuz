package GUI;

import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import beans.Funcionario;
import beans.Ocorrencia;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import negocio.ControlaFuncionario;
import negocio.ControlaOcorrencia;

public class TelaAdicionarOcorrenciaController {

	ObservableList statusList = FXCollections.observableArrayList("Em andamento", "Concluída");
	ObservableList tipoList = FXCollections.observableArrayList("Falta", "Atraso", "Multa");
	@FXML
	private Label nome;

	@FXML
	private Label cpf;

	@FXML
	private Label horariosumir;


	@FXML
	private Label valorsumir;


	@FXML
	private Label motivosumir;



	@FXML
	private DatePicker data;

	@FXML
	private ChoiceBox<String> status;

	@FXML
	private ChoiceBox<String> tipo;

	@FXML
	private TextArea justificativa;

	@FXML
	private TextField horario;

	@FXML
	private TextField motivo;

	@FXML
	private TextField valor;

	@FXML Label msg;




	@FXML private void initialize()
	{
		cpf.setText(Telas.getInstance().getCpf());
		ControlaFuncionario funcionarios = new ControlaFuncionario();
		Funcionario a = funcionarios.buscarFuncionario(cpf.getText());
		nome.setText(a.getNome());
		status.setItems(statusList);
		tipo.setItems(tipoList);

		/*//horario.setVisible(false);
		horario.setDisable(true);


	//	motivo.setVisible(false);
		motivo.setDisable(true);


		//valor.setVisible(false);
		valor.setDisable(true);
		 */



	}

	@FXML public void cadastrar()
	{
		Ocorrencia nova = new Ocorrencia();
		nova.setTipo(tipo.getValue());
		{

			int opcode = 0;

			if(nova.getTipo()=="Falta")
			{
				opcode = 1;
			}

			else if(nova.getTipo() == "Atraso")

			{
				opcode=2;
			}

			else if(nova.getTipo() == "Multa")
			{
				opcode = 3;
			}

			if(opcode == 0)
				msg.setText("Selecione um tipo");
			else {

				if(opcode == 2)
				{SimpleDateFormat format = new SimpleDateFormat("HH:mm"); // 12 hour format

				java.util.Date d1;
				try {
					d1 = (java.util.Date)format.parse(horario.getText());
					java.sql.Time ppstime = new java.sql.Time(d1.getTime());


					nova.setHorario(ppstime);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
				System.out.println("formato de hora incorreto");
				}
				}
				//java.sql.Time ppstime = new java.sql.Time(d1.getTime());

				nova.setData_ocorrencia(Date.valueOf(this.data.getValue()));
				nova.setFuncionario_cpf(this.cpf.getText());
				//nova.setHorario(ppstime);
				nova.setJustificativa(justificativa.getText());
				
				nova.setStatus_ocorrencia(status.getValue());
				if(opcode == 3) {
				nova.setMotivo(motivo.getText());
				
				nova.setValor(Float.valueOf(valor.getText()));
				}
				
				ControlaOcorrencia ocorrencias = new ControlaOcorrencia();


				msg.setText(ocorrencias.cadastrarOcorrencia(nova, opcode));

				this.data.setValue(null);
				this.horario.setText("");
				this.justificativa.setText("");
				this.motivo.setText("");
				this.status.setValue("null");
				this.tipo.setValue("");
				this.valor.setText("");
				//Date.valueOf(data_admissao.getValue())
			}}


	}}
