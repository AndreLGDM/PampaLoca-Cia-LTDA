package locadora;

public interface Ivetor {
    void imprime();

    void garanteEspaco();

    void adiciona(Object objeto);

    int tamanho();

    boolean contem(Object o);

    boolean cheio();

    boolean remove(Object objeto);

    Object getObjeto(int i);

    boolean vazio();

}
