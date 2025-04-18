package tadtwo;

import java.util.Random;

public class GeradorDeVetores {

    public static Registro[] gerarAleatorio(int tamanho) {
        Random rand = new Random();
        Registro[] vetor = new Registro[tamanho];
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = new Registro(i, "Item" + i, rand.nextInt(tamanho));
        }
        return vetor;
    }

    public static Registro[] gerarInverso(int tamanho) {
        Registro[] vetor = new Registro[tamanho];
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = new Registro(i, "Item" + i, tamanho - i);
        }
        return vetor;
    }

    public static Registro[] clonar(Registro[] original) {
        Registro[] copia = new Registro[original.length];
        for (int i = 0; i < original.length; i++) {
            Registro r = original[i];
            copia[i] = new Registro(r.id, r.nome, r.valor);
        }
        return copia;
    }
}
