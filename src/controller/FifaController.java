package controller;

import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import model.estrutura.Lista;
import model.estrutura.Pilha;
import model.estrutura.No;

public class FifaController implements IFifaController {
	
	private No<String> ultimo = null;
	
	public FifaController() {
		super();
	}

	@Override
	public Pilha<String> empilhaBrasileiros(String caminho, String nome) throws IOException {
	    Pilha<String> pilha = new Pilha<>();
	    BufferedReader buffer = new BufferedReader(new FileReader(caminho + "\\" + nome)); // Corrigido o caminho
	    String linha;
	    buffer.readLine(); 
	    while ((linha = buffer.readLine()) != null) {
	        String[] dados = linha.split(",");
	        String nacionalidade = dados[5];
	        if ("Brazil".equals(nacionalidade)) {
	            pilha.empilhar(linha);
	        }
	    }
	    buffer.close();
	    return pilha;
	}

	@Override
	public void desempilhaBonsBrasileiros(Pilha<String> pilha) throws IOException {
		String linha;
		String[] dados;
		while(!pilha.estaVazia()) {
			linha = pilha.desempilhar();
			dados = linha.split("," );
			int overall = Integer.parseInt(dados[7]);
			if(overall > 80) {
				System.out.println("Nome: " + dados[2] + ", Overall: " + overall);
			}
		}
	}

	@Override
	public Lista<String> listaRevelacoes(String caminho, String nome) throws IOException {
	    Lista<String> lista = new Lista<>();
	    BufferedReader buffer = new BufferedReader(new FileReader(caminho + "\\" + nome));
	    String linha;
	    buffer.readLine();
	    while ((linha = buffer.readLine()) != null) {
	        String[] dados = linha.split(",");
	        int idade = Integer.parseInt(dados[3]);
	        if (idade <= 20) {
	            lista.adicionar(linha);
	        }
	    }
	    buffer.close(); 
	    return lista;
	}
	
	@Override
	public void buscaListaBonsJovens(Lista<String> lista) throws IOException {
	    No<String> atual = lista.getFim();
	    String[] dados;
	    while (atual != null) {
	        dados = atual.getDado().split(",");
	        int overall = Integer.parseInt(dados[ 7]);
	        int idade = Integer.parseInt(dados[3]); 
	        if (overall > 80 && idade <= 20) {
	            System.out.println("Nome: " + dados[2] + ", Idade: " + idade + ", Overall: " + overall);
	        }
	        atual = atual.getAnterior();
	    }
	}
	
}
