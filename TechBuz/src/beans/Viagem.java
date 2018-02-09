package beans;

import java.sql.Time;
import java.sql.Timestamp;

public class Viagem {
	private String placa;
	private String linha;
	private Timestamp data_hr_min;
	private float receita;
	private int meia;
	private int inteira;
	private int pagantes;
	private int nao_pagantes;
	private String status_viagem;
	private int diferenca_catraca;
	private int ocorrencia_onibus_codigo;
	private String motorista_cpf;
	private String cobrador_cpf;
	private String fiscal_cpf;
	private Time hora;
	public Viagem()
	{
		
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getLinha() {
		return linha;
	}

	public void setLinha(String linha) {
		this.linha = linha;
	}

	public Timestamp getData_hr_min() {
		return data_hr_min;
	}

	public void setData_hr_min(Timestamp data_hr_min) {
		this.data_hr_min = data_hr_min;
	}

	public float getReceita() {
		return receita;
	}

	public void setReceita(float receita) {
		this.receita = receita;
	}

	public int getMeia() {
		return meia;
	}

	public void setMeia(int meia) {
		this.meia = meia;
	}

	public int getInteira() {
		return inteira;
	}

	public void setInteira(int inteira) {
		this.inteira = inteira;
	}

	public int getPagantes() {
		return pagantes;
	}

	public void setPagantes(int pagantes) {
		this.pagantes = pagantes;
	}

	public int getNao_pagantes() {
		return nao_pagantes;
	}

	public void setNao_pagantes(int nao_pagantes) {
		this.nao_pagantes = nao_pagantes;
	}

	public String getStatus_viagem() {
		return status_viagem;
	}

	public void setStatus_viagem(String status_viagem) {
		this.status_viagem = status_viagem;
	}

	public int getDiferenca_catraca() {
		return diferenca_catraca;
	}

	public void setDiferenca_catraca(int diferenca_catraca) {
		this.diferenca_catraca = diferenca_catraca;
	}

	public int getOcorrencia_onibus_codigo() {
		return ocorrencia_onibus_codigo;
	}

	public void setOcorrencia_onibus_codigo(int ocorrencia_onibus_codigo) {
		this.ocorrencia_onibus_codigo = ocorrencia_onibus_codigo;
	}

	public String getMotorista_cpf() {
		return motorista_cpf;
	}

	public void setMotorista_cpf(String motorista_cpf) {
		this.motorista_cpf = motorista_cpf;
	}

	public String getCobrador_cpf() {
		return cobrador_cpf;
	}

	public void setCobrador_cpf(String cobrador_cpf) {
		this.cobrador_cpf = cobrador_cpf;
	}

	public String getFiscal_cpf() {
		return fiscal_cpf;
	}

	public void setFiscal_cpf(String fiscal_cpf) {
		this.fiscal_cpf = fiscal_cpf;
	}

	public Time getHora() {
		return hora;
	}

	public void setHora(Time hora) {
		this.hora = hora;
	}
	
	
	
}
