package locadora;

import java.io.IOException;
import java.util.Scanner;

public class Caminhao extends Veiculo {

    private int capacidadeCarga;

    public Caminhao(Scanner scanner) throws InterruptedException, IOException {
        super();
        System.out.print("Digite a capacidade de carga: ");
        this.capacidadeCarga = scanner.nextInt();
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

    }

    public Caminhao(String placa, String modelo, int ano, float potencia, int lugares, String marca,
    long quilometragem, float aluguel, int capacidadeCarga) {
        super(placa, modelo, ano, potencia, lugares, marca, quilometragem, aluguel);
        this.capacidadeCarga = capacidadeCarga;
    }

    public int getCapacidadeCarga() {
        return capacidadeCarga;
    }

    public void setCapacidadeCarga(int capacidadeCarga) {
        this.capacidadeCarga = capacidadeCarga;
    }

    @Override
    public String toString() {
        return "caminhão {"+ placa +" "+ modelo +" "+ marca +" "+ ano +" "+ potencia
        +" "+ lugares +" "+ quilometragem +" "+ aluguel +" "+ capacidadeCarga +"}";

    }
}