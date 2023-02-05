package locadora;

import java.io.IOException;
import java.util.Scanner;

public class Motocicleta extends Veiculo {

    private int cilindrada;

    public Motocicleta(Scanner scanner) throws InterruptedException, IOException {

        super();
        System.out.print("Digite quantas cilindradas a moto possui: ");
        this.cilindrada = scanner.nextInt();
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

    }

    public Motocicleta(String placa, String modelo, int ano, float potencia, int lugares, String marca,
    long quilometragem, float aluguel,int cilindrada) {
        super(placa, modelo, ano, potencia, lugares, marca, quilometragem, aluguel);
        this.cilindrada = cilindrada;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    public String toString() {
        return "motocicleta {" + placa +" "+ modelo +" "+ marca +" "+ ano +" "+ potencia
        +" "+ lugares +" "+ quilometragem +" "+ aluguel +" "+ cilindrada + "}";
    }
}
