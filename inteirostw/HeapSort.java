package inteirostw;

public class HeapSort {

    public static void ordenar(int[] arr) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    private static void heapify(int[] arr, int n, int i) {
        int maior = i;
        int esquerda = 2 * i + 1;
        int direita = 2 * i + 2;

        if (esquerda < n && arr[esquerda] > arr[maior])
            maior = esquerda;

        if (direita < n && arr[direita] > arr[maior])
            maior = direita;

        if (maior != i) {
            int swap = arr[i];
            arr[i] = arr[maior];
            arr[maior] = swap;

            heapify(arr, n, maior);
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

        System.out.printf("HeapSort (%d elementos): Média = %.2f ms | Desvio Padrão = %.2f ms%n", tamanho, media, desvio);
    }
}
