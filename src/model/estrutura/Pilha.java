package model.estrutura;
import model.estrutura.No;

public class Pilha<T> {
	private No<T>  topo;
	private int tamanho = 0;
	
	public Pilha() {
		this.topo = null;
	}
	public void empilhar(T dado) {
		No<T> novo = new No<>(dado);
		novo.setAnterior(topo);
		topo = novo;
		this.tamanho ++;
	}
	
	public T desempilhar() {
		if(this.topo == null) return null;
		T dado = this.topo.getDado();
		this.topo = this.topo.getAnterior();
		this.tamanho --;
		return dado;
	}
	
	public boolean estaVazia() {
		if(this.tamanho == 0) {
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		if(this.topo == null) {
			return "[]";
		}else {
			StringBuilder builder = new StringBuilder("[");
			No<T> memoria = this.topo;
			builder.append(memoria.getDado());
			while(memoria.getAnterior() != null) {
				builder.append (", ");
				memoria = memoria.getAnterior();
				builder.append(memoria.getDado());
			}
			builder.append("]");
			return builder.toString();
		}
		
	}
}
