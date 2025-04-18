package tadtwo;

public class InsertionSort {

    public static void ordenar(Registro[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            Registro chave = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j].valor > chave.valor) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = chave;
        }
    }

    public static void main(String[] args) {
        int tamanho = 10000;

        // Vetor aleatório
        Registro[] vetorAleatorio = GeradorDeVetores.gerarAleatorio(tamanho);
        long inicioAleatorio = System.currentTimeMillis();
        ordenar(vetorAleatorio);
        long fimAleatorio = System.currentTimeMillis();
        System.out.printf("InsertionSort (Aleatório) finalizado em %d ms (tamanho: %d)%n",
                (fimAleatorio - inicioAleatorio), tamanho);

        // Vetor inverso
        Registro[] vetorInverso = GeradorDeVetores.gerarInverso(tamanho);
        long inicioInverso = System.currentTimeMillis();
        ordenar(vetorInverso);
        long fimInverso = System.currentTimeMillis();
        System.out.printf("InsertionSort (Inverso) finalizado em %d ms (tamanho: %d)%n",
                (fimInverso - inicioInverso), tamanho);
    }
}

