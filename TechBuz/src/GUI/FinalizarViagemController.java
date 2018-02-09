package GUI;



import beans.Viagem;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import negocio.ControlaViagem;

public class FinalizarViagemController {

    @FXML
    private TextField receita;

    @FXML Label msg;
    @FXML
    private TextField meia;

    @FXML
    private TextField pagantes;

    @FXML
    private TextField inteira;

    @FXML
    private TextField nao_pagantes;

    @FXML
    private TextField catraca;

    @FXML
    private ChoiceBox<String> status;
    
    ControlaViagem viagens = new ControlaViagem();
    @FXML void initialize()
    {
    	status.setItems(FXCollections.observableArrayList("Concluída", "Incompleta"));
    }
    @FXML
    void finalizar() {

    	Viagem nova = Telas.getInstance().getViagem();
    	nova.setReceita(Float.valueOf(receita.getText()));
    	nova.setMeia(Integer.valueOf(meia.getText()));
    	nova.setPagantes(Integer.valueOf(pagantes.getText()));
    	nova.setInteira(Integer.valueOf(inteira.getText()));
    	nova.setNao_pagantes(Integer.valueOf(nao_pagantes.getText()));
    	nova.setDiferenca_catraca(Integer.valueOf(catraca.getText()));
    	nova.setStatus_viagem(status.getValue());
    
    	if(viagens.finalizarViagem(nova))
    		msg.setText("Viagem finalizada");
    	else 
    		msg.setText("Ouve um erro");
    	
    }

}
