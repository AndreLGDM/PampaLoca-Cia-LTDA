package locadora;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Locacao {

    Scanner scanner = new Scanner(System.in);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private LocalDate DataDeRetirada;
    private LocalDate DataDeDevolucao;
    private Period diasAlugado;
    private float valorASerPago;
    private float valorPago;
    private Cliente cliente;
    private Veiculo veiculo;
    private boolean kmRodado;

    public Locacao(Veiculo v, Cliente c) {
        this.cliente = c;
        this.veiculo = v;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public boolean isKmRodado() {
        return kmRodado;
    }

    public void setKmRodado(boolean kmRodado) {
        this.kmRodado = kmRodado;
    }

    public LocalDate getDataDeRetirada() {
        return DataDeRetirada;
    }

    public void setDataDeRetirada(LocalDate dataDeRetirada) {
        DataDeRetirada = dataDeRetirada;
    }

    public LocalDate getDataDeDevolucao() {
        return DataDeDevolucao;
    }

    public void setDataDeDevolucao(LocalDate dataDeDevolucao) {
        DataDeDevolucao = dataDeDevolucao;
    }

    public float getValorASerPago() {
        return valorASerPago;
    }

    public void setValorASerPago(float valorASerPago) {
        this.valorASerPago = valorASerPago;
    }

    public float getValorPago() {
        return valorPago;
    }

    public void setValorPago(float valorPago) {
        this.valorPago = valorPago;
    }

    public void receberRetirada() {
        System.out.print("Digite a data de retirada: ");
        String dataDeRetirada = scanner.next();
        DataDeRetirada = LocalDate.parse(dataDeRetirada, formatter);
    }

    public void receberDevolucao() {
        System.out.print("Digite a data de devolucao: ");
        String dataDeDevolucao = scanner.next();
        DataDeDevolucao = LocalDate.parse(dataDeDevolucao, formatter);
    }

    public void tempoLocacao() {
        diasAlugado = Period.between(DataDeRetirada, DataDeDevolucao);
        System.out.println("Alugado por: " + diasAlugado.getDays() + " dias.");
    }

    public void valorLocacao() {
        setValorASerPago(veiculo.getAluguel() * diasAlugado.getDays());
        System.out.println("O Cliente rodou mais de 5.000Km com o veiculo? true or false");
        setKmRodado(scanner.nextBoolean());
        if (isKmRodado() == true) {
            System.out.print("Taxa adcional de R$ 500,00 adcionado ao valor!" + "\n");
            setValorASerPago(veiculo.getAluguel() * diasAlugado.getDays() + 500);
            System.out.print("Valor de Locação: R$" +valorASerPago);
        } else {
            System.out.print("Valor de Locação: R$" + valorASerPago);
        }
    }

    public void valorPago(){
        System.out.println();
        System.out.print("Digite o valor que o cliente pagou: ");
        this.valorPago = scanner.nextFloat();
        if(getValorPago() == getValorASerPago() || getValorPago() > getValorASerPago()){
            cliente.setInadimplente(false);
        }
    }

    @Override
    public String toString() {
        return "Locação {" + cliente.getCnh() +" "+ veiculo.getPlaca() +" "+ getDataDeRetirada() +"}" ;
    }
}
