package com.erp;

public class Produtos {
	private String id;
	private String nome_produto;
	private static double preco;
	private double quantidade;

	public Produtos(String id, String nome, double preco, double quantidade) {
		this.id = id;
		this.nome_produto = nome;
		Produtos.preco = preco;
		this.quantidade = quantidade;
	}

	public double getQuantidade(){
		return quantidade;
	}
	public String getId() {
		return id;
	}

	public String getNome_Produto() {
		return nome_produto;
	}

	public double getPreco() {
		return preco;
	}

	@Override
	public String toString() {
		return id + "," + nome_produto + "," + preco;
	}

	public static Produtos fromString(String str) {
		String[] parts = str.split(",");
		return new Produtos(parts[0], parts[1], Double.parseDouble(parts[2]), preco);
	}
}
