import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

import beans.Empresa;
import beans.Funcionario;
import negocio.ControlaFuncionario;

public class Conexao {
	
	public static void main(String[] args) {
	
	/*	System.out.println("\tMENU\n1-Funcionarios\n2-Ve�culos e pecas\n3-Linhas\n4-Viagens\n");
		
		
		int op;
		Scanner scan = new Scanner(System.in);
		
		op = scan.nextInt();
		
		switch(op)
		{
		
		case 1:
			System.out.println("\tMENU FUNCION�RIOS\n1-Visualizar Funcion�rios(Gerar relat�rio)\n2-Atualizar Funcion�rios(treinamenoto, atividade, afastamento"
					+ "cadastrar ocorrencia");
			break;
		case 2:
			System.out.println("\tMENU VE�CULO\n1-Atualizar pecas (Lista pra adicionar e remover e adicionar quantidade)\n"
					+ "2-Atualizar onibus(pode prpode adicionar novos documentos ou vencimenots selecinando um onibus, pode adicionar "
					+ "novos veiiculos instalar acessorios\n3-Vistoria e servi�os");
			break;
		case 3:
			System.out.println("\tMENU LINHAS\nAtualizar linhas(lista de linhas e abre trajetos que podem ser alterados");
			break;
		case 4:
			System.out.println("\tMENU VIAGENS E CLIENTES");
			break;
		}
		
	*/
	
	ControlaFuncionario funcionarios = new ControlaFuncionario();

	Funcionario novo = funcionarios.buscarFuncionario("12412983518");
	
	System.out.println(novo.getNome());
	}
	
	
}
