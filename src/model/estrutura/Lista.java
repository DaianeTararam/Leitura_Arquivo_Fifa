package model.estrutura;
import model.estrutura.No;

public class Lista<String> {
	private No inicio;
	private No fim;
	
	public Lista() {
		this.inicio = null;
		this.fim = null;
	}
	
	public void adicionar(String dado) {
		No novo = new No(dado);
		if(this.inicio == null) {
			this.inicio = novo;
			this.fim = novo;
		}else {
			this.fim.setProximo(novo);
			novo.setAnterior(this.fim);
			this.fim = novo;
		}
	}
	
	public String remover() {
		if(this.fim == null) return null;
		String dado = this.fim.getDado();
		this.fim = this.fim.getAnterior();
		if(this.fim != null) {
			this.fim.setProximo(null);
		}else {
			this.inicio = null;
		}
		return dado;
	}
	public void imprimir() {
        No atual = this.inicio;
        while (atual != null) {
            System.out.println(atual.getDado());
            atual = atual.getProximo();
        }
    }
	
	public No getFim() {
		return this.fim;
	}

	

}
