package view;

import java.io.IOException;
import model.estrutura.*;
import controller.FifaController;

public class Principal {
    public static void main(String[] args) {
        FifaController controller = new FifaController();
        
        try {
            
            Pilha<String> pilhaBrasileiros = controller.empilhaBrasileiros("C:\\TEMP", "data.csv");
            controller.desempilhaBonsBrasileiros(pilhaBrasileiros);
            System.out.println( pilhaBrasileiros.toString());
            System.out.println("---------------------------------");
            Lista<String> listaRevelacoes = controller.listaRevelacoes("C:\\TEMP", "data.csv");
            controller.buscaListaBonsJovens(listaRevelacoes);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
