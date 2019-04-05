package com.angoti;

public class Leilao {
	private Lance lanceVencedor;
	private String nome;
	private final double valorMinimo;
	private boolean status;
	int id;

	public Leilao(String n, double v) {
		nome = n;
		valorMinimo = v;
		status = true;
		lanceVencedor = new Lance("inicial", valorMinimo);
	}

	public Leilao(String nome, double valorMinimo, boolean status, int id) {
		super();
		this.nome = nome;
		this.valorMinimo = valorMinimo;
		this.status = status;
		this.id = id;
	}

	public void registrarLance(String nomeDaPessoa, double valor) {
		if (status && valor > lanceVencedor.valor)
			lanceVencedor = new Lance(nomeDaPessoa, valor);
	}

	public void finalizar() {
		status = false;
		System.out.println(nome + ": " + lanceVencedor.nome + " - " + lanceVencedor.valor);
	}

	public Lance getLanceVencedor() {
		return lanceVencedor;
	}

	public String getNome() {
		return nome;
	}

	public boolean isStatus() {
		return status;
	}

	public int getId() {
		return id;
	}

	public double getValorMinimo() {
		return valorMinimo;
	}
}
