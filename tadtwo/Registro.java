package tadtwo;

public class Registro {
    int id;
    String nome;
    int valor;

    public Registro(int id, String nome, int valor) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return String.format("Registro{id=%d, nome='%s', valor=%d}", id, nome, valor);
    }
}
