package model;
import java.util.ArrayList;

public class Categoria {
	private int codigoCategoria; // Útil para banco de dados (vai ser autoincrementado, por isso não está no construtor)
	private String nome; // Obs: a propriedade é privada, mas os getters e setters tornam os valores públicos!
 	private ArrayList<Item> itens;
	
	public Categoria(String nome) { // Construtor exige o nome da categoria
		this.setNome(nome);
		itens = new ArrayList<>();
	}
	/*
	 *  Getters e setters são utilizados para manipular os atributos das classes (acessar e alterar) 
	 *  Exemplos: objetoInstanciadoCategoria.getCodigoCategoria() retorna o código
	 *  objetoInstanciadoCategoria.setCodigoCategoria('parâmetro') atribui valor
	 */
	public int getCodigoCategoria() {
		return codigoCategoria;
	}
	public void setCodigoCategoria(int codigoCategoria) { // Setters atribuem valor e recebem parâmetros
		this.codigoCategoria = codigoCategoria;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	/* Cada categoria tem um conjunto de elementos arraylist */
	public void adicionarItem(Item item) {
		itens.add(item);
	}
	
	public void removerItem(int codigo) {
		System.out.println(itens.get(codigo).getNome() + " foi removido da categoria");
		itens.remove(codigo);
	}
	
	public ArrayList<Item> getItens(){
		return itens;
	}
	
	public void setItens(ArrayList<Item> itens) {
		this.itens = itens;
	}
	
}
