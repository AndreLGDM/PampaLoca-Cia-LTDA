package locadora;

import java.util.Scanner;

import java.io.IOException;

public class Menu {

    private String escolhaPrincipal;
    private String escolhaLocacao;
    private String qualTipoDeObjeto;
    private String qualTipoDeVeiculo;
    private String escolhaListagem;
    private String escolhaEdicao;
    private String escolhaExclusao;
    private String oQueEditar;
    private String qualAtributo;
    private String oQueEditarVeiculo;
    private String qualAtributoComum;

    public String getQualAtributoComum() {
        return qualAtributoComum;
    }

    public void setQualAtributoComum(String qualAtributoComum) {
        this.qualAtributoComum = qualAtributoComum;
    }

    public String getoQueEditarVeiculo() {
        return oQueEditarVeiculo;
    }

    public void setoQueEditarVeiculo(String oQueEditarVeiculo) {
        this.oQueEditarVeiculo = oQueEditarVeiculo;
    }

    public String getQualAtributo() {
        return qualAtributo;
    }

    public void setQualAtributo(String qualAtributo) {
        this.qualAtributo = qualAtributo;
    }

    public String getoQueEditar() {
        return oQueEditar;
    }

    public void setoQueEditar(String oQueEditar) {
        this.oQueEditar = oQueEditar;
    }

    public String getEscolhaExclusao() {
        return escolhaExclusao;
    }

    public void setEscolhaExclusao(String escolhaExclusao) {
        this.escolhaExclusao = escolhaExclusao;
    }

    public String getEscolhaEdicao() {
        return escolhaEdicao;
    }

    public void setEscolhaEdicao(String escolhaEdicao) {
        this.escolhaEdicao = escolhaEdicao;
    }

    public String getEscolhaLocacao() {
        return escolhaLocacao;
    }

    public void setEscolhaLocacao(String escolhaLocacao) {
        this.escolhaLocacao = escolhaLocacao;
    }

    public String getEscolhaListagem() {
        return escolhaListagem;
    }

    public void setEscolhaListagem(String escolhaListagem) {
        this.escolhaListagem = escolhaListagem;
    }

    public String getQualTipoDeVeiculo() {
        return qualTipoDeVeiculo;
    }

    public void setQualTipoDeVeiculo(String qualTipoDeVeiculo) {
        this.qualTipoDeVeiculo = qualTipoDeVeiculo;
    }

    public String getQualTipoDeObjeto() {
        return qualTipoDeObjeto;
    }

    public void setQualTipoDeObjeto(String qualTipoDeObjeto) {
        this.qualTipoDeObjeto = qualTipoDeObjeto;
    }

    public String getEscolhaPrincipal() {
        return escolhaPrincipal;
    }

    public void setEscolhaPrincipal(String escolhaPrincipal) {
        this.escolhaPrincipal = escolhaPrincipal;
    }

    public void intro() {
        System.out.println("    Bem Vindo     ");
        System.out.println("PampaLoca & Cia LTDA");
        System.out.println();
    }

    public void menuPrincipal(Scanner scanner) throws InterruptedException, IOException {
        System.out.println(
                "1 - Cadastrar" + "\n" + "2 - listar" + "\n" + "3 - Locação" + "\n" + "4 - Excluir" + "\n"
                        + "5 - Editar" + "\n" + "0 - Sair");
        System.out.print("Escolha uma das opções: ");
        this.escolhaPrincipal = scanner.next();
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }

    public void menuCadastrar(Scanner scanner) throws InterruptedException, IOException {
        System.out.print("Deseja cadastrar um cliente ou um veículo? " + "\n");
        System.out.print("1 - Cliente." + "\n" + "2 - Veículo." + "\n" + "Escolha: ");
        this.qualTipoDeObjeto = scanner.next();
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }

    public void menuVeiculo(Scanner scanner) throws InterruptedException, IOException {
        System.out.print("1 - Carro." + "\n" + "2 - Caminhão." + "\n" + "3 - Ônibus." + "\n"
                + "4 - Motocicleta." + "\n");
        System.out.print("Digite o que qual tipo de veículo deseja cadastrar: ");
        qualTipoDeVeiculo = scanner.next();
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }

    public void menuListar(Scanner scanner) throws InterruptedException, IOException {
        System.out.print("Deseja listar cliente, veículos ou locações? " + "\n");
        System.out.print("1 - Cliente." + "\n" + "2 - Veículo." + "\n" + "3 - Locações." + "\n" + "Escolha: ");
        escolhaListagem = scanner.next();
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }

    public void menuLocacao(Scanner scanner) throws InterruptedException, IOException {
        System.out.println("1 - Incluir Locação " + "\n" + "2 - Consultar veículos não locados " + "\n" + "Escolha: ");
        escolhaLocacao = scanner.next();
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }

    public void menuExcluir(Scanner scanner) throws InterruptedException, IOException {
        System.out.print("Deseja excluir cliente, veículo ou locação?" + "\n");
        System.out.print("1 - Cliente." + "\n" + "2 - Veículo." + "\n" + "3 - Locação: " + "\n" + "Escolha: ");
        escolhaExclusao = scanner.next();
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }

    public void menuEditar(Scanner scanner) throws InterruptedException, IOException {
        System.out.print("Deseja editar cliente ou veículo?" + "\n");
        System.out.print("1 - Cliente." + "\n" + "2 - Veículo." + "\n" + "Escolha: ");
        escolhaEdicao = scanner.next();
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }

    public void menuOQueEditar(Scanner scanner) throws InterruptedException, IOException {
        System.out.print("O que desejar modificar?" + "\n");
        System.out.print("1 - Nome." + "\n" + "2 - Cnh." + "\n" + "3 - Telefone." + "\n" + "4 - Cpf." + "\n");
        oQueEditar = scanner.next();
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }

    public void menuOQueEditarVeiculo(Scanner scanner) throws InterruptedException, IOException {
        System.out.print("O que desejar modificar?" + "\n");
        System.out.print("1 - Atributo comum" + "\n" + "2 - Atributo Específico" + "\n");
        oQueEditarVeiculo = scanner.next();
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }

    public void qualAtributoComum(Scanner scanner) throws InterruptedException, IOException {
        System.out.print("O que desejar modificar?" + "\n");
        System.out.print("1 - Placa" + "\n" + "2 - Modelo" + "\n" + "3 - Marca" + "\n" + "4 - Ano" + "\n"
                + "5 - Potencia" + "\n" + "6 - lugares" + "\n" + "7 - Aluguel" + "\n" + "8 - Quilometragem" + "\n");
        qualAtributoComum = scanner.next();
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }

    public void qualAtributo(Scanner scanner) throws InterruptedException, IOException {
        System.out.print("1 - Carga" + "\n" + "2 - Banheiro" + "\n" + "3 - Cilindrada" + "\n");
        qualAtributo = scanner.next();
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }
}