package br.com.sigoa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import br.com.sigoa.connection.Conexao;
import br.com.sigoa.model.Peca;

public class PecaDAO {
	static public void CREATE(Peca peca) {
			
			String sql = "INSERT INTO tb_peca (nome_peca, fabricante_peca,"
					+ "quantidade_peca, valor_peca) VALUES (?, ?, ?, ?);";
			
			try {
				Connection con = Conexao.getConnection();
				
				PreparedStatement stmt = con.prepareStatement(sql);
				
				stmt.setString(1, peca.getNome_peca());
				stmt.setString(2, peca.getFabricante_peca());
				stmt.setString(3, peca.getQuantidade_peca().toString());
				stmt.setString(4, peca.getValor_peca().toString());
				
				stmt.executeUpdate();
				
				JOptionPane.showMessageDialog(null, "Peça cadastrada com sucesso!", "Sucess", 2);
				
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
