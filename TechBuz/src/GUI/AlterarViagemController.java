package GUI;

import java.sql.Timestamp;

import beans.Viagem;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import negocio.ControlaViagem;

public class AlterarViagemController {

    @FXML
    private TextField placa;

    @FXML
    private TextField linha;

    @FXML Label msg;
    @FXML
    private TextField data;

    @FXML
    private TextField status;

    @FXML
    private TextField motorista;

    @FXML
    private TextField cobrador;

    @FXML
    private TextField receita;

    @FXML
    private TextField pagante;

    @FXML
    private TextField meia;

    @FXML
    private TextField inteira;

    @FXML
    private TextField nao_pagante;

    @FXML
    private TextField catraca;

    ControlaViagem viagens = new ControlaViagem();
    
    Viagem a;
    String placa1, linha1;
    Timestamp data1;
    @FXML void initialize()
    {
    	a = Telas.getInstance().getViagem();
    	placa1 = a.getPlaca();
    	linha1 = a.getLinha();
    	data1 = a.getData_hr_min();
    	
    	placa.setText(a.getPlaca());
    	linha.setText(a.getLinha());
    	data.setText(a.getData_hr_min().toString());
    	status.setText(a.getStatus_viagem());
    	motorista.setText(a.getMotorista_cpf());
    	cobrador.setText(a.getCobrador_cpf());
    	receita.setText(a.getReceita()+"");
    	pagante.setText(a.getPagantes()+"");
    	meia.setText(a.getMeia()+"");
    	inteira.setText(a.getInteira()+"");
    	nao_pagante.setText(a.getNao_pagantes()+"");
    	catraca.setText(a.getDiferenca_catraca()+"");
    	
    	
    }
    @FXML
    void alterar() {
    	
    	a = new Viagem();
    	
    	a.setPlaca(placa.getText());
    	a.setLinha(linha.getText());
    	a.setData_hr_min(Timestamp.valueOf(data.getText()));
    	a.setStatus_viagem(status.getText());
    	a.setMotorista_cpf(motorista.getText());
    	a.setCobrador_cpf(cobrador.getText());
    	a.setReceita(Float.valueOf(receita.getText()));
    	a.setPagantes(Integer.valueOf(pagante.getText()));
    	a.setMeia(Integer.valueOf(meia.getText()));
    	a.setInteira(Integer.valueOf(inteira.getText()));
    	a.setNao_pagantes(Integer.valueOf(nao_pagante.getText()));
    	a.setDiferenca_catraca(Integer.valueOf(catraca.getText()));
    	
    	if(viagens.alterarViagem(a, placa1, linha1, data1))
    		msg.setText("Viagem alterada");
    	else
    		msg.setText("Viagem não pode ser alterada");
    	placa1 = a.getPlaca();
    	linha1 = a.getLinha();
    	data1 = a.getData_hr_min();
    	
    }

}
