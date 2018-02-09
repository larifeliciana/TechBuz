package Repositorio;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

import GUI.Telas;

public class Conectar {

	private java.sql.Connection con;
	
	private static Conectar instance;
	
	private Conectar()
	{
		try{
			
			if(Telas.getInstance().getLogado().getOpcode() == 1)
			{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/techbuz", "motorista","motorista");
			}

			if(Telas.getInstance().getLogado().getOpcode() == 2)
			{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/techbuz", "cobrador","cobrador");
			}
			if(Telas.getInstance().getLogado().getOpcode() == 3)
			{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/techbuz", "fiscal","fiscal");
			
			}
			if(Telas.getInstance().getLogado().getOpcode() == 4)
			{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/techbuz", "gerente","gerente");
			System.out.println(4);
			}
			
			if(Telas.getInstance().getLogado().getOpcode() == 0)
			{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println(0);

			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/techbuz", "dba1","dba1");
			
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("erro de classe");
		}
	}
	
	public static synchronized Conectar getInstance()
	{
		if(instance == null)
		{
			
			instance = new Conectar();
		}
		
		return instance;
	}

	public java.sql.Connection getCon() {
		return con;
	}

	public void setCon(java.sql.Connection con) {
		this.con = con;
	}
	
	public void fechar()
	{
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		instance = null;
	}
}
