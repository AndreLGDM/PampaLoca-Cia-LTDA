package locadora;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Arquivo {

    public static void lerArquivoCSV(Ivetor vetVeiculos, Ivetor VetClientes, Ivetor VetLocacao) {
        try {
            File csvFile = new File("Veiculos.csv");
            Scanner fileScanner = new Scanner(csvFile);

            fileScanner.nextLine();
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] linhas = line.split(";");
                switch (linhas[6]) {
                    case "Carro":
                        Veiculo v = new Veiculo(linhas[0], linhas[1], Integer.parseInt(linhas[3]),
                                Float.parseFloat(linhas[4]), Integer.parseInt(linhas[5]), linhas[2],
                                Long.parseLong(linhas[8]), Float.parseFloat(linhas[7]));
                        vetVeiculos.adiciona(v);
                        break;
                    case "Caminhão":
                        Caminhao c = new Caminhao(linhas[0], linhas[1], Integer.parseInt(linhas[3]),
                                Float.parseFloat(linhas[4]), Integer.parseInt(linhas[5]), linhas[2],
                                Long.parseLong(linhas[8]), Float.parseFloat(linhas[7]), Integer.parseInt(linhas[9]));
                        vetVeiculos.adiciona(c);
                        break;
                    case "Ônibus":
                        Onibus o = new Onibus(linhas[0], linhas[1], Integer.parseInt(linhas[3]),
                                Float.parseFloat(linhas[4]), Integer.parseInt(linhas[5]), linhas[2],
                                Long.parseLong(linhas[8]), Float.parseFloat(linhas[7]),
                                Boolean.parseBoolean(linhas[11]));
                        vetVeiculos.adiciona(o);
                        break;
                    case "Motocicleta":
                        Motocicleta m = new Motocicleta(linhas[0], linhas[1], Integer.parseInt(linhas[3]),
                                Float.parseFloat(linhas[4]), Integer.parseInt(linhas[5]), linhas[2],
                                Long.parseLong(linhas[8]), Float.parseFloat(linhas[7]), Integer.parseInt(linhas[10]));
                        vetVeiculos.adiciona(m);
                        break;
                }
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            File csvFile = new File("Clientes.csv");
            Scanner fileScanner = new Scanner(csvFile);

            fileScanner.nextLine();
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] linhas = line.split(";");

                Cliente c = new Cliente(linhas[0], linhas[1], Long.parseLong(linhas[2]), linhas[3], Boolean.parseBoolean(linhas[4]));
                VetClientes.adiciona(c);

            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            File csvFile = new File("Locações.csv");
            Scanner fileScanner = new Scanner(csvFile);

            fileScanner.nextLine();
        while (fileScanner.hasNextLine()) {
            String[] linhas = fileScanner.nextLine().split(";");
            Veiculo v = new Veiculo(linhas[1], "", 0, 0, 0, "", 0, 0);
            Cliente c = new Cliente(null, linhas[0], 0, null, false);
            Locacao L = new Locacao(v, c);
            VetLocacao.adiciona(L);
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void gravarArquivoCSV(Cliente c) {

        try (FileOutputStream fos = new FileOutputStream("Clientes.csv", true);
        OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8)) {
       String data = String.join(";", c.getNome(), c.getCnh(), Long.toString(c.getTelefone()), c.getCpf(), String.valueOf(c.isInadimplente()));
       osw.write(data + "\n");
       osw.flush();
   } catch (IOException e) {
       e.printStackTrace();
   }
   
    }

    public static void gravarArquivoCSV(Carro ca, String tipo) {

        try (FileOutputStream fos = new FileOutputStream("Veiculos.csv", true);
                OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8)) {

            String ano = Integer.toString(ca.getAno());
            String lugares = Integer.toString(ca.getLugares());
            String km = Long.toString(ca.getQuilometragem());
            String potencia = Float.toString(ca.getPotencia());
            String aluguel = Float.toString(ca.getAluguel());

            String data =  ca.getPlaca() + ";" + ca.getModelo() + ";" + ca.getMarca() + ";" + ano + ";" + potencia
                    + ";" + lugares + ";" + tipo + ";" + aluguel + ";" + km + "\n";
            osw.write(data);
            osw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void gravarArquivoCSV(Caminhao c, String tipo) {

        try (FileOutputStream fos = new FileOutputStream("Veiculos.csv", true);
                OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8)) {

            String carga = Integer.toString(c.getCapacidadeCarga());
            String ano = Integer.toString(c.getAno());
            String lugares = Integer.toString(c.getLugares());
            String km = Long.toString(c.getQuilometragem());
            String potencia = Float.toString(c.getPotencia());
            String aluguel = Float.toString(c.getAluguel());
            osw.write(c.getPlaca() + ";" + c.getModelo() + ";" + c.getMarca() + ";" + " " + ano + ";" + potencia + ";" +
                    lugares + ";" + tipo + ";" + aluguel + ";" + km + ";" + carga + "\n");
            osw.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void gravarArquivoCSV(Onibus o, String tipo) {

        try (FileOutputStream fos = new FileOutputStream("Veiculos.csv", true);
                OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8)) {

            String banheiro = Boolean.toString(o.isBanheiro());
            String ano = Integer.toString(o.getAno());
            String lugares = Integer.toString(o.getLugares());
            String km = Long.toString(o.getQuilometragem());
            String potencia = Float.toString(o.getPotencia());
            String aluguel = Float.toString(o.getAluguel());
            osw.write(o.getPlaca() + ";" + o.getModelo() + ";" + o.getMarca() + ";" + ano + ";" + potencia + ";"
                    + lugares + ";" +
                    tipo + ";" + aluguel + ";" + km + ";" + " " + ";" + " " + ";" + banheiro + "\n");
            osw.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void gravarArquivoCSV(Motocicleta m, String tipo) {

        try {
            FileOutputStream fos = new FileOutputStream("Veiculos.csv", true);
            OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);

            StringBuilder sb = new StringBuilder();
            sb.append(m.getPlaca()).append(";")
                    .append(m.getModelo()).append(";")
                    .append(m.getMarca()).append(";")
                    .append(m.getAno()).append(";")
                    .append(m.getPotencia()).append(";")
                    .append(m.getLugares()).append(";")
                    .append(tipo).append(";")
                    .append(m.getAluguel()).append(";")
                    .append(m.getQuilometragem()).append(";")
                    .append(" ").append(";")
                    .append(m.getCilindrada()).append(";")
                    .append(" ").append("\n");
            osw.write(sb.toString());
            osw.flush();
            osw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void gravarArquivoCSV(Locacao L) {

        try {
            FileOutputStream fos = new FileOutputStream("Locações.csv", true);
            OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);

            String Placa = L.getVeiculo().getPlaca().toString();
            String CNH = L.getCliente().getCnh().toString();
            String dataDeRetirada = L.getDataDeRetirada().toString();
            String dataDeDevolucao = "null";
            osw.write(CNH);
            osw.write((";"));
            osw.write(Placa);
            osw.write((";"));
            osw.write((dataDeRetirada));
            osw.write(";");
            osw.write(dataDeDevolucao);
            osw.write(("\n"));
            osw.flush();
            osw.close();
        
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}