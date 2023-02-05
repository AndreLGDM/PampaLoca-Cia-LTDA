package locadora;

import java.io.IOException;
import java.util.Scanner;

public class Onibus extends Veiculo {

    private boolean banheiro;

    public Onibus(Scanner scanner) throws InterruptedException, IOException {
        super();
        System.out.print("Este onibus possui banheiro? Digite true para sim e false para não: ");
        this.banheiro = scanner.nextBoolean();
        if (System.getProperty("os.name").contains("Windows"))
							new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }

    public Onibus(String placa, String modelo, int ano, float potencia, int lugares, String marca,
    long quilometragem, float aluguel, boolean banheiro) {
        super(placa, modelo, ano, potencia, lugares, marca, quilometragem, aluguel);
        this.banheiro = banheiro;
    }

    public boolean isBanheiro() {
        return banheiro;
    }

    public void setBanheiro(boolean banheiro) {
        this.banheiro = banheiro;
    }

    @Override
    public String toString() {
        return "onibus {" + placa +" "+ modelo +" "+ marca +" "+ ano +" "+ potencia
        +" "+ lugares +" "+ quilometragem +" "+ aluguel +" "+ banheiro +"}";
    }
}
