package inteirostw;

public class SelectionSort {

    public static void ordenar(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        int tamanho = 10000;
        int repeticoes = 10;
        long[] tempos = new long[repeticoes];

        for (int i = 0; i < repeticoes; i++) {
            int[] vetor = GeradorDeVetores.gerarAleatorio(tamanho);
            long inicio = System.currentTimeMillis();
            ordenar(vetor);
            long fim = System.currentTimeMillis();
            tempos[i] = fim - inicio;
        }

        double media = Estatisticas.calcularMedia(tempos);
        double desvio = Estatisticas.calcularDesvioPadrao(tempos, media);

        System.out.printf("SelectionSort (%d elementos): Média = %.2f ms | Desvio Padrão = %.2f ms%n", tamanho, media, desvio);
    }
}
