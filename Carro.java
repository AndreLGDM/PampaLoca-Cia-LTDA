package locadora;

import java.io.IOException;

public class Carro extends Veiculo {

    public Carro() throws InterruptedException, IOException {

        super();
        if (System.getProperty("os.name").contains("Windows"))
							new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }

    @Override
    public String toString() {
        return "carro {" + placa +" "+ modelo +" "+ marca +" "+ ano +" "+ potencia
                +" "+ lugares +" "+ quilometragem +" "+ aluguel + "}";
    }

}
