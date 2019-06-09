package Repositório_Bilhete_Aereo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;



public class BilheteAereoRepositoryJDBC implements BilheteAerioRepository{
	
	private Connection conn;
	
	BilheteAereoRepositoryJDBC() throws Exception{
		setConexao();
		criarTabelaBilhete(conn);
	}
	
	
	@Override
	public void inserirBilhete(BilheteAereo bilhete) throws Exception {
		String sql = "insert into Bilhete (id, origem, destino, data_voo) values (?,?,?,?)";
		
		PreparedStatement statement = this.conn.prepareStatement(sql);
		statement.setInt(1, bilhete.getVoo());
		statement.setString(2, bilhete.getOrigem());
		statement.setString(3, bilhete.getDestino());
		statement.setDate(4, bilhete.getData());
		
		statement.execute();
		statement.close();
	}

	@Override
	public void excluirBilheteAereo(BilheteAereo bilhete) throws Exception {
		String sql = "delete from Bilhete where id = ?";
		
		PreparedStatement statement = this.conn.prepareStatement(sql);
		statement.setInt(1, bilhete.getVoo());
		
		statement.execute(sql);
		statement.close();	
	}
	
	
	@Override
	public void alterarBilheteAereo(BilheteAereo bilhete) throws Exception {
		String sql = "update bilhete set origem = ? , destino = ?, data = ? where id = ?";
		
		PreparedStatement statement = this.conn.prepareStatement(sql);
		statement.setString(1, bilhete.getOrigem());
		statement.setString(2, bilhete.getDestino());
		statement.setDate(3, bilhete.getData());
		statement.setInt(4, bilhete.getVoo());
		
		statement.execute(sql);
		statement.close();	
		
	}
	
	
	private void setConexao() {
		try {
			this.conn = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/aep",
					"postgres",
					"unicesumar");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private void criarTabelaBilhete(Connection conexão) throws Exception {
		String sql = "create table if not exists Bilhete ("
				+ "id integer not null primary key,"
				+ "origem varchar(255) not null unique,"
				+ "destino varchar(255) not null unique,"
				+ "data_voo date not null"
				+ ")";
		
		Statement statement = conexão.createStatement();
		statement.execute(sql);
		statement.close();		
	}

	public void selectBilhetes() throws Exception {
		String sql = "select * from bilhete";
		Statement statement = this.conn.prepareStatement(sql);
		statement.execute(sql);
		statement.close();		
	}
	
	
	
}
