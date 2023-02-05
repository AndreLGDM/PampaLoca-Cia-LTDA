package locadora;

import java.util.Scanner;

public class Veiculo {

    Scanner scanner = new Scanner(System.in);

    protected String placa;
    protected String modelo;
    protected int ano;
    protected float potencia;
    protected int lugares;
    protected String marca;
    protected long quilometragem;
    protected float aluguel;

    public Veiculo() {
        
        System.out.print("Digite a placa do veículo: ");
        this.placa = scanner.next();
        System.out.print("Digite o modelo do veículo: ");
        this.modelo = scanner.next();
        System.out.print("Digite a marca do veículo: ");
        this.marca = scanner.next();
        System.out.print("Digite o ano do veículo: ");
        this.ano = scanner.nextInt();
        System.out.print("Digite a potência do veículo: ");
        this.potencia = scanner.nextFloat();
        System.out.print("Digite a quantidade de lugares do veículo: ");
        this.lugares = scanner.nextInt();
        System.out.print("Digite o preço de aluguel deste veículo: R$ ");
        this.aluguel = scanner.nextFloat();
        System.out.print("Digite a quilometragem do veículo: ");
        this.quilometragem = scanner.nextLong();
        

    }

    public Veiculo(String placa, String modelo, int ano, float potencia, int lugares, String marca,
            long quilometragem, float aluguel) {
                this.potencia = potencia;
                this.placa = placa;
                this.modelo = modelo;
                this.ano = ano;
                this.lugares = lugares;
                this.marca = marca;
                this.quilometragem = quilometragem;
                this.aluguel = aluguel;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public float getPotencia() {
        return potencia;
    }

    public void setPotencia(float potencia) {
        this.potencia = potencia;
    }

    public int getLugares() {
        return lugares;
    }

    public void setLugares(int lugares) {
        this.lugares = lugares;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public long getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(long quilometragem) {
        this.quilometragem = quilometragem;
    }

    public float getAluguel() {
        return aluguel;
    }

    public void setAluguel(float aluguel) {
        this.aluguel = aluguel;
    }

    @Override
    public String toString() {
        return "carro {" + placa +" "+ modelo +" "+ marca +" "+ ano +" "+ potencia
                +" "+ lugares +" "+ quilometragem +" "+ aluguel + "}";
    }
}
