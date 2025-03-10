package view;
import model.Categoria;
import model.Item;
import model.Mercado; // Pra usar a classe, tem que importá-la

import java.util.ArrayList;

import controller.BancoDeDados;

public class Main {

	public static void main(String[] args) {
		BancoDeDados banco = new BancoDeDados();
		ArrayList<Categoria> categorias = banco.getCategorias();
		Categoria c;
		for(int i = 0; i < categorias.size(); i++) {
			ArrayList<Item> itens = categorias.get(i).getItens(); // Exibe conteúdo do banco já formatado
			System.out.println("Categoria: " + categorias.get(i).getNome());
			for(int j = 0; j < itens.size(); j++) {
				System.out.println("Nome: "+ itens.get(j).getNome()+ ", Preço: "+ itens.get(j).getPreco());
			}
			System.out.println("");
		}
	
		
		// Adicionando novos itens no banco
		Item energetico = new Item("Redbull que dá asas", 9.99);
		banco.escreverNoArquivo(energetico, 0);
		Item escovaDeDente = new Item("Escova de dente verde", 4.00);
		banco.escreverNoArquivo(escovaDeDente, 1);
		

		
		//Mercado mercadoBrasil = new Mercado("Mercado Brasil");
		
		/* Testes antes da implementação do banco em arquivo 
		// Categorias genéricas (cada categoria tem um conjunto de elementos arraylist recebidos como parâmetro da classe itens) 
		Categoria alimentos = new Categoria("Alimentos");
		Categoria higienePessoal = new Categoria("Higiene pessoal");
		Categoria produtosLimpeza = new Categoria("Produtos de limpeza");
		
		// Itens (depois são adicionados na categoria) 
		Item cafeTresCoracoes = new Item("Três corações", 4.00);
		Item cafeBrasileiro = new Item("Café brasileiro", 4.50);
		Item escovaDeDente = new Item("Escova de dente", 3.00);
		Item desodorante = new Item("Desodorante", 10.00);
		Item candida = new Item("Cândida", 20.00);
		Item detergente = new Item("Detergente", 5.00);
	
		alimentos.adicionarItem(cafeTresCoracoes);
		alimentos.adicionarItem(cafeBrasileiro);
		higienePessoal.adicionarItem(escovaDeDente);
		higienePessoal.adicionarItem(desodorante);
		produtosLimpeza.adicionarItem(candida);
		produtosLimpeza.adicionarItem(detergente);
		
		mercadoBrasil.adicionarCategoria(alimentos); // Já vem com os itens implícito
		mercadoBrasil.adicionarCategoria(higienePessoal);
		mercadoBrasil.adicionarCategoria(produtosLimpeza);
	
		// Métodos (apresentarCategoriaPorCodigo exibe todos os itens de categoria x)
		System.out.println("Todas as cateogrias cadastradas: ");
		mercadoBrasil.apresentarCategorias();
		System.out.println("Mostrar todos os itens: ");
		mercadoBrasil.apresentarItens();
		System.out.println("aoba");
		*/
	}
}
