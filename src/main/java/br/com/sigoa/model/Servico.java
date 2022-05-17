package br.com.sigoa.model;

public class Servico {
	
	private Integer id_servico; 
	private String nome_servico; 
	private Double valor_servico;
	
	public Servico(String nome_servico, Double valor_servico) {
		super();
		this.nome_servico = nome_servico;
		this.valor_servico = valor_servico;
	}

	public int getId_servico() {
		return id_servico;
	}

	public String getNome_servico() {
		return nome_servico;
	}

	public void setNome_servico(String nome_servico) {
		this.nome_servico = nome_servico;
	}

	public Double getValor_servico() {
		return valor_servico;
	}

	public void setValor_servico(Double valor_servico) {
		this.valor_servico = valor_servico;
	}
	
}
