package Repositorio;
import java.sql.*;
//import com.mysql.jdbc.*;
import beans.Onibus;

public class RepositorioOnibus {
	
	
	public boolean cadastrarOnibusBD(Onibus a)
	{
			try{
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con;
			
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/techbuz","root","");
			
			
			String query = "insert into onibus(placa, tipo, operacao, data_inclusao, disponibilidade, status_alocacao, num_sentados, cod_frota, ano) values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement stmt = con.prepareStatement(query);
			
			stmt.setString(1, a.getPlaca());
			stmt.setString(2, a.getTipo());
			stmt.setString(3, a.getOperacao());
			stmt.setString(4, ""+a.getData_inclusao());
			stmt.setString(5,""+ a.getDisponibilidade());
			stmt.setString(6, ""+a.getStatus_alocacao());
			stmt.setString(7,""+ a.getSentado());
			stmt.setString(8, ""+a.getCod_frota());
			stmt.setString(9, ""+a.getAno());
			
			
			stmt.executeUpdate();
			stmt.close(); 
			con.close();
			}
			catch(Exception e) {
				System.out.println("nao deu certo");
				return false;
			}
			
			return true;
		
	}
	
	public Onibus buscaEmpresaBD(String placa)
	{
		Onibus a = new Onibus();
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con;
			
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/techbuz","root","");
			
			
			String query = "select * from empresa where placa = ?";
			PreparedStatement stmt = con.prepareStatement(query);
			
			stmt.setString(1, placa);

			
			
			ResultSet resultado  = stmt.executeQuery();
			
			a.setAno(resultado.getInt("ano"));
			a.setCod_frota(resultado.getInt("cod_frota"));
			a.setData_inclusao(resultado.getDate("data_inclusao"));
			a.setDisponibilidade(resultado.getString("disponibilidade").charAt(0)); //char 
			a.setOperacao(resultado.getString("operacao"));
			a.setPlaca(resultado.getString("placa"));
			a.setSentado(resultado.getInt("sentado"));
			a.setStatus_alocacao(resultado.getString("status_alocacao").charAt(0)); //char
			a.setTipo(resultado.getString("tipo"));
			
			
			
			resultado.close();
			stmt.close(); 
			con.close();
			}
			catch(Exception e) {
				System.out.println("nao deu certo");
			//	return false;
			}
			
		return a;
			//return true;
		
		
	}
	
	public boolean removerOnibusBD(String placa)
	{
		

		try{
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con;
		
		con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/techbuz","root","");
		
		
		String query = "delete from empresa where cnpj = ?";
		PreparedStatement stmt = con.prepareStatement(query);
		
		stmt.setString(1, placa);
		
		
		stmt.executeUpdate();
		stmt.close(); 
		con.close();
		}
		catch(Exception e) {
			System.out.println("nao deu certo");
			return false;
		}
		
		return true;
	
}

}
