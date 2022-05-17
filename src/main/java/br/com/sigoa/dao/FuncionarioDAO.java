package br.com.sigoa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import br.com.sigoa.connection.Conexao;
import br.com.sigoa.model.Funcionario;

public class FuncionarioDAO {
	static public void CREATE(Funcionario funcionario) {
		
		String sql = "INSERT INTO tb_funcionario (nome_funcionario, cpf_funcionario, "
				+ "matricula_funcionario, endereco_funcionario, nascimento_funcionario, "
				+ "telefone_funcionario) "
				+ "VALUES (?, ?, ?, ?, ?, ?);";
	
		try {
			Connection con = Conexao.getConnection();
			
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setString(1, funcionario.getNome_funcionario());
			stmt.setString(2, funcionario.getCpf_funcionario());
			stmt.setString(3, funcionario.getMatricula_funcionario());
			stmt.setString(4, funcionario.getEndereco_funcionario());
			stmt.setString(5, funcionario.getNascimento_funcionario());
			stmt.setString(6, funcionario.getTelefone_funcionario());
			
			stmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso!", "Sucess", 2);
			
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
