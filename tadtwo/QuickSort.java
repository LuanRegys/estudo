package tadtwo;

public class QuickSort {

    public static void ordenar(Registro[] arr, int low, int high) {
        if (low < high) {
            int pi = particao(arr, low, high);
            ordenar(arr, low, pi - 1);
            ordenar(arr, pi + 1, high);
        }
    }

    private static int particao(Registro[] arr, int low, int high) {
        int pivot = arr[high].valor;
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j].valor < pivot) {
                i++;
                Registro temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        Registro temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        int tamanho = 10000;

        // Vetor aleatório
        Registro[] vetorAleatorio = GeradorDeVetores.gerarAleatorio(tamanho);
        long inicioAleatorio = System.currentTimeMillis();
        ordenar(vetorAleatorio, 0, vetorAleatorio.length - 1);
        long fimAleatorio = System.currentTimeMillis();
        System.out.printf("QuickSort (Aleatório) finalizado em %d ms (tamanho: %d)%n",
                (fimAleatorio - inicioAleatorio), tamanho);

        // Vetor inverso
        Registro[] vetorInverso = GeradorDeVetores.gerarInverso(tamanho);
        long inicioInverso = System.currentTimeMillis();
        ordenar(vetorInverso, 0, vetorInverso.length - 1);
        long fimInverso = System.currentTimeMillis();
        System.out.printf("QuickSort (Inverso) finalizado em %d ms (tamanho: %d)%n",
                (fimInverso - inicioInverso), tamanho);
    }
}
