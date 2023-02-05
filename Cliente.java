package locadora;

import java.io.IOException;
import java.util.Scanner;

public class Cliente {

    private String nome;
    private String cnh;
    private long telefone;
    private String cpf;
    private boolean inadimplente;

    Scanner scanner = new Scanner(System.in);

    public Cliente() throws InterruptedException, IOException {
        System.out.print("Digite o nome do Cliente: ");
        this.nome = scanner.next();
        do {
            System.out.print("Digite a CNH do Cliente: ");
            this.cnh = scanner.next();
            if (getCnh().matches("[0-9]+") == false) {
                System.out.println("Cnh invalida!");
            }
        } while (getCnh().matches("[0-9]+") == false);
        System.out.print("Digite o telefone do Cliente: ");
        this.telefone = scanner.nextLong();
        do {
            System.out.print("Digite o CPF do Cliente: ");
            this.cpf = scanner.next();
            if (getCpf().matches("[0-9]+") == false) {
                System.out.println("cpf invalido!");
            }
        } while (getCpf().matches("[0-9]+") == false);
        this.inadimplente = false;
        if (System.getProperty("os.name").contains("Windows"))
							new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }

    public Cliente(String nome, String cnh, long telefone, String cpf, boolean inadimplente) {
        this.nome = nome;
        this.cnh = cnh;
        this.telefone = telefone;
        this.cpf = cpf;
        this.inadimplente = inadimplente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public long getTelefone() {
        return telefone;
    }

    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public boolean isInadimplente() {
        return inadimplente;
    }

    public void setInadimplente(boolean inadimplente) {
        this.inadimplente = inadimplente;
    }

    public void editarDados() {

    }

    @Override
    public String toString() {
        return "Cliente {" + nome +" "+ cnh +" "+ telefone +" "+ cpf +" "+ inadimplente + "}";
    }
}
