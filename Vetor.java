package locadora;

public class Vetor implements Ivetor {

    private Object[] arrayObjetos = new Object[5];
    private int totalArrayObjetos = 0;

    @Override
    public void garanteEspaco() {
        if (this.cheio()) {
            Object[] novoObjeto = new Object[this.arrayObjetos.length * 2];
            for (int i = 0; i < this.arrayObjetos.length; i++) 
                novoObjeto[i] = this.arrayObjetos[i];
                this.arrayObjetos = novoObjeto;
            }
        }

    @Override
    public void imprime() {
        for (int i = 0; i < this.totalArrayObjetos; i++) {
            System.out.println(this.arrayObjetos[i]);
        }
    }

    @Override
    public void adiciona(Object o) {
        this.garanteEspaco();
        this.arrayObjetos[this.totalArrayObjetos] = o;
        this.totalArrayObjetos++;
    }

    @Override
    public int tamanho() {
        return this.totalArrayObjetos;
    }

    @Override
    public boolean contem(Object Objeto) {
        for (int i = 0; i < this.totalArrayObjetos; i++) {
            if (Objeto != this.arrayObjetos[i]) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean cheio() {
        if (totalArrayObjetos == this.arrayObjetos.length) {
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        int indice = -1;
        for (int i = 0; i < totalArrayObjetos; i++) // faz a busca
            if (o == this.arrayObjetos[i]) {
                indice = i;
                break;
            }
        if (indice != -1) { // achou o elemento
            for (int i = indice; i < (totalArrayObjetos - 1); i++)
                this.arrayObjetos[i] = this.arrayObjetos[i + 1];
            totalArrayObjetos--;
            return true;
        }
        return false;
    }

    public Object getObjeto(int i) {
        return this.arrayObjetos[i];
    }

    public boolean vazio() {
        if (totalArrayObjetos == 0) {
            return true;
        }
        return false;
    }

}
