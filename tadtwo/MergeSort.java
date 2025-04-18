package tadtwo;

public class MergeSort {

    public static void ordenar(Registro[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            ordenar(arr, left, mid);
            ordenar(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(Registro[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        Registro[] leftArr = new Registro[n1];
        Registro[] rightArr = new Registro[n2];

        System.arraycopy(arr, left, leftArr, 0, n1);
        System.arraycopy(arr, mid + 1, rightArr, 0, n2);

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArr[i].valor <= rightArr[j].valor) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }

        while (i < n1) arr[k++] = leftArr[i++];
        while (j < n2) arr[k++] = rightArr[j++];
    }

    public static void main(String[] args) {
        int tamanho = 10000;

        // Vetor aleatório
        Registro[] vetorAleatorio = GeradorDeVetores.gerarAleatorio(tamanho);
        long inicioAleatorio = System.currentTimeMillis();
        ordenar(vetorAleatorio, 0, vetorAleatorio.length - 1);
        long fimAleatorio = System.currentTimeMillis();
        System.out.printf("MergeSort (Aleatório) finalizado em %d ms (tamanho: %d)%n",
                (fimAleatorio - inicioAleatorio), tamanho);

        // Vetor inverso
        Registro[] vetorInverso = GeradorDeVetores.gerarInverso(tamanho);
        long inicioInverso = System.currentTimeMillis();
        ordenar(vetorInverso, 0, vetorInverso.length - 1);
        long fimInverso = System.currentTimeMillis();
        System.out.printf("MergeSort (Inverso) finalizado em %d ms (tamanho: %d)%n",
                (fimInverso - inicioInverso), tamanho);
    }
}
