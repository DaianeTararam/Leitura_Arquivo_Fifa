package controller;

import model.estrutura.Pilha;
import java.io.IOException;
import model.estrutura.Lista;

public interface IFifaController {
	
	public Pilha<String> empilhaBrasileiros(String caminho, String nome) throws IOException;
	public void desempilhaBonsBrasileiros(Pilha<String> pilha) throws IOException;
	public Lista<String> listaRevelacoes(String caminho, String nome) throws IOException;
	public void buscaListaBonsJovens(Lista<String> lista) throws IOException;
	
}
