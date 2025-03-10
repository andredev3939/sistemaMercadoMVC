package model;

public class Item {
	private int codigoItem;
	private String nome;
	private double preco;
	
	public Item(String nome, double preco) {
		this.nome = nome; // O valor nome da classe recebe o parâmetro nome do método construtor
		this.preco = preco;
	}
	public int getCodigoItem() { // getter recebe tipo e usa return
		return codigoItem; // Consegue acessar o private porque está no mesmo arquivo
	}
	public void setCodigoItem(int codigoItem) { // setter recebe void e usa .this e parâmetro
		this.codigoItem = codigoItem;
	}
	public String getNome() {
		return nome;	
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public double getPreco() {
		return preco;
	}
	
}
