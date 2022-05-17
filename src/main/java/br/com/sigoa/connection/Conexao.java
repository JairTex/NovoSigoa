package br.com.sigoa.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexao {
	
	private static final String LINK_DB = "jdbc:mysql://localhost/db_sigoa";//Verificar caminho para o BD
	private static final String USER_DB = "root";// Adicionar nome do usuario do mysql
	private static final String PSW_DB = "JairS218";// Adicionar senha se houver
	
	public static Connection getConnection() throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//Nome do driver utilizado
			
			return DriverManager.getConnection(LINK_DB, USER_DB, PSW_DB);	
		} 
		catch (ClassNotFoundException e) {
			throw new SQLException(e.getException());
		}
	}
	
	public static void closeConnection(Connection con) {
		try {
			if (con!=null) {
			con.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
	public static void closeConnection(Connection con, PreparedStatement stmt) {
		
		closeConnection(con);
		
		try {
			if (stmt!=null){
				stmt.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
	public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {
		
		closeConnection(con, stmt);
		
		try {
			if (rs!=null){
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
}