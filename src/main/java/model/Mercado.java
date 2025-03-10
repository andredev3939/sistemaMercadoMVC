package model;
import java.util.ArrayList;

public class Mercado {
	private int codigoMercado; 
	private String nome;
	/* O mercado possui uma lista de categorias e itens, que possuem categorias */
	private ArrayList <Categoria> categorias;
	
	public Mercado(String nome) { // Construtor que preenche nome e coleções de categorias e itens
		this.setCategorias(new  ArrayList<>());
	}

	/* IDE gera automaticamente: Refactor > Encapsulate Field */
	
	public ArrayList <Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(ArrayList <Categoria> categorias) {
		this.categorias = categorias;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCodigoMercado() {
		return codigoMercado;
	}

	public void setCodigoMercado(int codigoMercado) {
		this.codigoMercado = codigoMercado;
	}
	
	public void adicionarCategoria(Categoria categoria) { // O parâmetro é uma classe
		categorias.add(categoria); // Adiciona o parâmetro categoria no array de categorias 
	}
	
	public void removerCategoria(int codigo) {
		System.out.println(categorias.get(codigo).getNome() + "foi removido");
	}
	
	public void apresentarCategorias() {
		for (int i=0; i < categorias.size(); i++) {
			System.out.println(categorias.get(i).getNome());
		}
	}
	
	public void apresentarItens() {
		for (int i = 0; i < categorias.size(); i++) {
			ArrayList<Item> itens = categorias.get(i).getItens();
			System.out.println("Categoria: " + i);
			for (int j = 0; j < itens.size(); j++) {
				System.out.println(itens.get(j).getNome() + ", Preço: " + itens.get(j).getPreco());
			}
			System.out.println("");
		}
	
	}
	
	public void apresentarCategoriaPorCodigo(int codigo) {
		for (int i=0; i < categorias.size(); i++) {
			if(codigo == 0) {
				for(int j=0; j < categorias.get(0).getItens().size(); j++) {
					System.out.println(categorias.get(0).getItens().get(j).getNome());
				}
				i = categorias.size();	
			} else if (codigo == 1) {
				for(int j=0; j < categorias.get(1).getItens().size(); j++) {
					System.out.println(categorias.get(1).getItens().get(j).getNome());
				}
				i = categorias.size();					
			} else if (codigo == 2) {
				for(int j=0; j < categorias.get(2).getItens().size(); j++) {
					System.out.println(categorias.get(2).getItens().get(j).getNome());
				}
				i = categorias.size();	
			}
		}

	}
	
}

 