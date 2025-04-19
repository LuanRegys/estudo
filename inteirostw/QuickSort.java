package inteirostw;

public class QuickSort {

    public static void ordenar(int[] arr, int inicio, int fim) {
        if (inicio < fim) {
            int pivo = particionar(arr, inicio, fim);
            ordenar(arr, inicio, pivo - 1);
            ordenar(arr, pivo + 1, fim);
        }
    }

    private static int particionar(int[] arr, int inicio, int fim) {
        int pivo = arr[fim];
        int i = inicio - 1;
        for (int j = inicio; j < fim; j++) {
            if (arr[j] < pivo) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[fim];
        arr[fim] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        int tamanho = 10000;
        int repeticoes = 10;
        long[] tempos = new long[repeticoes];

        for (int i = 0; i < repeticoes; i++) {
            int[] vetor = GeradorDeVetores.gerarAleatorio(tamanho);
            long inicio = System.currentTimeMillis();
            ordenar(vetor, 0, vetor.length - 1);
            long fim = System.currentTimeMillis();
            tempos[i] = fim - inicio;
        }

        double media = Estatisticas.calcularMedia(tempos);
        double desvio = Estatisticas.calcularDesvioPadrao(tempos, media);

        System.out.printf("QuickSort (%d elementos): Média = %.2f ms | Desvio Padrão = %.2f ms%n", tamanho, media, desvio);
    }
}
