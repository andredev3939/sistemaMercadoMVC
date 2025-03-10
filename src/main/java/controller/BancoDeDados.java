package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import model.Categoria; // atenção
import model.Item;

public class BancoDeDados {
	private ArrayList<Categoria> categorias;
	ArrayList<Item> itens;
	 
	public BancoDeDados() {
		ArrayList<String> linhas = lerArquivo();
		categorias = linhasEmObjetos(linhas);
	}

	// Ao inicializar
	public ArrayList<String> lerArquivo() {
		try {
		InputStream is = new FileInputStream("target/itens.txt"); // Localiza o arquivo
 		InputStreamReader isr = new InputStreamReader(is); // Prepara para leitura
		BufferedReader br = new BufferedReader(isr); // Lê o arquivo
		String linha = br.readLine(); // Tudo em arquivos é lido em linhas
		ArrayList<String> todasLinhas = new ArrayList<>();
		while(linha != null) { // Enquanto for diferente de nulo, prossegue lendo as linhas do arquivo
			todasLinhas.add(linha);
			System.out.println(linha);
			linha = br.readLine();
		}
		br.close();
		isr.close();
		is.close();
		
		System.out.println("Terminei de ler o arquivo");
		return todasLinhas;
		} catch (Exception e) {
			System.out.println("Não consegui ler o arquivo. Segue a exceção: ");
		    e.printStackTrace();
		    return null;
		}
	}
	
	// Transformar dados do arquivo em objeto
	public ArrayList<Categoria> linhasEmObjetos(ArrayList<String> todasLinhas) {
		String[] dadosLinha = new String[3]; // 3 elementos (nome, preço e categoria)
		String nome;
		String categoria;
		ArrayList<Categoria> categorias = new ArrayList<>();
		double preco;
		// Transformar linha a linha, divindo as propriedades/index a partir da vírgula
		for (int i = 0; i < todasLinhas.size(); i++) { 
			dadosLinha = todasLinhas.get(i).split(","); // atencao
			nome = dadosLinha[0];
			preco = Double.parseDouble(dadosLinha[1]); // Por padrão, tudo que vem do arquivo vem como texto e tem de ser convertido
			categoria = dadosLinha[2];
			
			Item item = new Item(nome, preco);
			Categoria c = new Categoria(categoria);
			boolean opcao = false;
			
			for (int j = 0; j < categorias.size(); j++) {
				if (categorias.get(j).getNome().equals(c.getNome())) {
					categorias.get(j).adicionarItem(item);
					opcao = true;
				} 
			}
			if (opcao == false) {
				c.adicionarItem(item);
				//categorias.add(c);
			}
		}
		return categorias;		
	}
	
	public ArrayList<Categoria> getCategorias(){
		return categorias;
	}
	
	public void escreverNoArquivo(Item item, int codigoCategoria) {
		try {
			OutputStream os = new FileOutputStream("target/itens.txt", true) ; // Localiza o arquivo a ser escrito (ou cria)
			OutputStreamWriter osw = new OutputStreamWriter(os); // Prepara para escrita
			BufferedWriter bw = new BufferedWriter(osw); // Escreve o arquivo
			String linha = "";
			if(codigoCategoria == 0) {
				linha = item.getNome() + " , " + item.getPreco() + ", alimentos";
				bw.write(linha);
				bw.newLine();
			} else if (codigoCategoria == 1) {
				linha = item.getNome() + " , " + item.getPreco() + ", Higiene pessoal";
				bw.write(linha);
				bw.newLine();
			} else if (codigoCategoria == 2) {
				linha = item.getNome() + " , " + item.getPreco() + ", Produtos de limpeza";				
				bw.write(linha);
				bw.newLine();
			}
			bw.close();	
			osw.close();
			os.close();
		} catch (Exception e) {
			System.out.println("Não foi possível escrever no arquivo de texto");
		}
		
		
	}
}
