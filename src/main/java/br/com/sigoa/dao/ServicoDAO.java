package br.com.sigoa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import br.com.sigoa.connection.Conexao;
import br.com.sigoa.model.Servico;

public class ServicoDAO {
	static public void CREATE(Servico servico) {
		
		String sql = "INSERT INTO tb_servico (nome_servico, "
				+ "valor_servico) VALUES (?, ?);";
		
		try {
			Connection con = Conexao.getConnection();
			
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setString(1, servico.getNome_servico());
			stmt.setString(2, servico.getValor_servico().toString());
			
			stmt.executeUpdate();
			
			
			JOptionPane.showMessageDialog(null, "Serviço cadastrado com sucesso!", "Sucess", 2);
			
			
			try {
				if(con != null){
					con.close();
				}
				if(stmt != null) {
					stmt.close();
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}		
	}
}
