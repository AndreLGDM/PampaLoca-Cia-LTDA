package locadora;

import java.io.IOException;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException, IOException {

        Scanner scanner = new Scanner(System.in);
        Menu menuP = new Menu();
        Ivetor arrayVeiculos = new Vetor();
        Ivetor arrayClientes = new Vetor();
        Ivetor arrayLocacao = new Vetor();
        Locacao loc = null;
        Arquivo.lerArquivoCSV(arrayVeiculos, arrayClientes, arrayLocacao);

        menuP.intro();
        do {
            menuP.menuPrincipal(scanner);
            if (menuP.getEscolhaPrincipal().equals("1")) {
                menuP.menuCadastrar(scanner);
                switch (menuP.getQualTipoDeObjeto()) {
                    case "1":
                        Cliente c = new Cliente();
                        arrayClientes.adiciona(c);
                        Arquivo.gravarArquivoCSV(c);
                        break;
                    case "2":
                        menuP.menuVeiculo(scanner);
                        if (menuP.getQualTipoDeVeiculo().equals("1")) {
                            Carro carro = new Carro();
                            Arquivo.gravarArquivoCSV(carro, "Carro");
                            arrayVeiculos.adiciona(carro);
                        } else if (menuP.getQualTipoDeVeiculo().equals("2")) {
                            Caminhao caminhao = new Caminhao(scanner);
                            arrayVeiculos.adiciona(caminhao);
                            Arquivo.gravarArquivoCSV(caminhao, "Caminhão");
                        } else if (menuP.getQualTipoDeVeiculo().equals("3")) {
                            Onibus onibus = new Onibus(scanner);
                            arrayVeiculos.adiciona(onibus);
                            Arquivo.gravarArquivoCSV(onibus, "Ônibus");
                        } else if (menuP.getQualTipoDeVeiculo().equals("4")) {
                            Motocicleta motocicleta = new Motocicleta(scanner);
                            arrayVeiculos.adiciona(motocicleta);
                            Arquivo.gravarArquivoCSV(motocicleta, "Motocicleta");
                        }
                    default:
                }
            } else if (menuP.getEscolhaPrincipal().equals("2")) {
                menuP.menuListar(scanner);
                switch (menuP.getEscolhaListagem()) {
                    case "1":
                        arrayClientes.imprime();
                        break;
                    case "2":
                        arrayVeiculos.imprime();
                        break;
                    case "3":
                        arrayLocacao.imprime();
                        break;
                    default:
                }
            } else if (menuP.getEscolhaPrincipal().equals("3")) {
                menuP.menuLocacao(scanner);
                switch (menuP.getEscolhaLocacao()) {
                    case "1":
                        Cliente ClienteSeraLocado = null;
                        System.out.println("Digite a cnh do cliente que deseja incluir na locação: ");
                        String CNH = scanner.next();
                        for (int i = 0; i < arrayClientes.tamanho(); i++) {
                            ClienteSeraLocado = (Cliente) arrayClientes.getObjeto(i);
                            if (CNH.equals((ClienteSeraLocado.getCnh()))) {
                                break;
                            } 
                        }
                        Veiculo veiculoLocacao = null;
                            System.out.println("Digite a placa do veiculo que deseja incluir na locação: ");
                            String Placa = scanner.next();
                            for (int i = 0; i < arrayVeiculos.tamanho(); i++) {
                                veiculoLocacao = (Veiculo) arrayVeiculos.getObjeto(i);
                                if (Placa.equals((veiculoLocacao.getPlaca()))) {
                                    break;
                                } 
                            }
                            if (arrayLocacao.vazio() == false) {
                                for (int j = 0; j < arrayLocacao.tamanho(); j++) {
                                    if (veiculoLocacao.getPlaca() == loc.getVeiculo().getPlaca()) {
                                        System.out.println("O veiculo já está alugado!");
                                        break;
                                    }
                                }
                            }
                        
                            if (ClienteSeraLocado.isInadimplente() == false) {
                                loc = new Locacao(veiculoLocacao, ClienteSeraLocado);
                                loc.receberRetirada();
                                arrayLocacao.adiciona(loc);
                                ClienteSeraLocado.setInadimplente(true);
                                Arquivo.gravarArquivoCSV(loc);
                            } else {
                                System.out.println(
                                        "Cliente inadimplente ou em outra locação, não será possivel criar uma locação!");
                            }
                        break;
                    case "2":
                        if (!arrayLocacao.vazio()) {
                            for (int i = 0; i < arrayVeiculos.tamanho(); i++) {
                                Veiculo veiculoCadastrado = (Veiculo) arrayVeiculos.getObjeto(i);
                                boolean locado = false;
                                for (int j = 0; j < arrayLocacao.tamanho(); j++) {
                                    Locacao veiculoLocado = (Locacao) arrayLocacao.getObjeto(j);
                                    if (veiculoCadastrado.equals(veiculoLocado.getVeiculo())) {
                                        locado = true;
                                        break;
                                    }
                                }
                                if (!locado) {
                                    System.out.println(veiculoCadastrado);
                                }
                            }
                        } else {
                            arrayVeiculos.imprime();
                        }
                        break;
                }
            } else if (menuP.getEscolhaPrincipal().equals("4")) {
                menuP.menuExcluir(scanner);
                switch (menuP.getEscolhaExclusao()) {
                    case "1":

                        System.out.println("Digite a cnh do cliente que deseja excluir: ");
                        String CNH = scanner.next();
                        for (int i = 0; i < arrayClientes.tamanho(); i++) {
                            Cliente clienteRemovido = (Cliente) arrayClientes.getObjeto(i);
                            if (CNH.equals(clienteRemovido.getCnh())) {
                                arrayClientes.remove(clienteRemovido);
                                break;
                            }
                        }
                        break;
                    case "2":
                        System.out.println("Digite a placa do veículo que deseja excluir: ");
                        String Placa = scanner.next();
                        for (int i = 0; i < arrayClientes.tamanho(); i++) {
                            Veiculo veiculoRemovido = (Veiculo) arrayVeiculos.getObjeto(i);
                            if (Placa.equals(veiculoRemovido.getPlaca())) {
                                arrayClientes.remove(veiculoRemovido);
                                break;
                            }
                        }
                        break;
                    case "3":
                        System.out.println("Digite a cnh do cliente que deseja excluir a locação: ");
                        String Cnh = scanner.next();
                        for (int i = 0; i < arrayClientes.tamanho(); i++) {
                            Locacao locRemovida = (Locacao) arrayLocacao.getObjeto(i);
                            if (Cnh.equals((locRemovida.getCliente().getCnh()))) {
                                locRemovida.receberDevolucao();
                                locRemovida.tempoLocacao();
                                locRemovida.valorLocacao();
                                locRemovida.valorPago();
                                if (locRemovida.getCliente().isInadimplente() == false)
                                    arrayLocacao.remove(locRemovida);
                                break;
                            }
                        }
                        break;
                    default:
                }

            } else if (menuP.getEscolhaPrincipal().equals("5")) {
                menuP.menuEditar(scanner);
                switch (menuP.getEscolhaEdicao()) {
                    case "1":
                        System.out.println("Digite a cnh do cliente que deseja mudar dados: ");
                        String CNH = scanner.next();
                        for (int i = 0; i < arrayClientes.tamanho(); i++) {
                            Cliente clienteEditado = (Cliente) arrayClientes.getObjeto(i);
                            if (CNH.equals(clienteEditado.getCnh())) {
                                menuP.menuOQueEditar(scanner);
                                if (menuP.getoQueEditar().equals("1")) {
                                    System.out.println(clienteEditado.getNome());
                                    System.out.println("Digite o novo Nome: ");
                                    clienteEditado.setNome(scanner.next());
                                } else if (menuP.getoQueEditar().equals("2")) {
                                    System.out.println(clienteEditado.getCnh());
                                    System.out.println("Digite a nova Cnh: ");
                                    clienteEditado.setCnh(scanner.next());
                                } else if (menuP.getoQueEditar().equals("3")) {
                                    System.out.println(clienteEditado.getTelefone());
                                    System.out.println("Digite o novo Telefone: ");
                                    clienteEditado.setTelefone(scanner.nextLong());
                                } else if (menuP.getoQueEditar().equals("4")) {
                                    System.out.println(clienteEditado.getCpf());
                                    System.out.println("Digite o novo Cpf: ");
                                    clienteEditado.setCpf(scanner.next());
                                }
                                break;
                            }
                        }
                        break;
                    case "2":
                        System.out.println("Digite a placa do veículo que deseja mudar dados: ");
                        String Placa = scanner.next();
                        for (int i = 0; i < arrayVeiculos.tamanho(); i++) {
                            Veiculo veiculoEditado = (Veiculo) arrayVeiculos.getObjeto(i);
                            if (Placa.equals(veiculoEditado.getPlaca())) {
                                menuP.menuOQueEditarVeiculo(scanner);
                                if (menuP.getoQueEditarVeiculo().equals("1")) {
                                    if (menuP.getQualAtributoComum().equals("1")) {
                                        System.out.println(veiculoEditado.getPlaca());
                                        System.out.print("Digite a nova placa: ");
                                        veiculoEditado.setPlaca(scanner.next());
                                    } else if (menuP.getQualAtributoComum().equals("2")) {
                                        System.out.println(veiculoEditado.getModelo());
                                        System.out.print("Digite o novo Modelo: ");
                                        veiculoEditado.setModelo(scanner.next());
                                    } else if (menuP.getQualAtributoComum().equals("3")) {
                                        System.out.println(veiculoEditado.getMarca());
                                        System.out.print("Digite a nova Marca: ");
                                        veiculoEditado.setMarca(scanner.next());
                                    } else if (menuP.getQualAtributoComum().equals("4")) {
                                        System.out.println(veiculoEditado.getAno());
                                        System.out.print("Digite o novo Ano: ");
                                        veiculoEditado.setAno(scanner.nextInt());
                                    } else if (menuP.getQualAtributoComum().equals("5")) {
                                        System.out.println(veiculoEditado.getPotencia());
                                        System.out.print("Digite a nova Potencia: ");
                                        veiculoEditado.setPotencia(scanner.nextFloat());
                                    } else if (menuP.getQualAtributoComum().equals("6")) {
                                        System.out.println(veiculoEditado.getLugares());
                                        System.out.print("Digite a nova quantidade de lugares: ");
                                        veiculoEditado.setLugares(scanner.nextInt());
                                    } else if (menuP.getQualAtributoComum().equals("7")) {
                                        System.out.println(veiculoEditado.getAluguel());
                                        System.out.print("Digite o novo Aluguel: ");
                                        veiculoEditado.setAluguel(scanner.nextFloat());
                                    } else if (menuP.getQualAtributoComum().equals("8")) {
                                        System.out.println(veiculoEditado.getQuilometragem());
                                        System.out.print("Digite a nova Quilometragem: ");
                                        veiculoEditado.setQuilometragem(scanner.nextLong());
                                    }
                                } else if (menuP.getoQueEditarVeiculo().equals("2")) {
                                    menuP.qualAtributo(scanner);
                                    if (menuP.getQualAtributo().equals("1")) {
                                        for (int j = 0; j < arrayVeiculos.tamanho(); j++) {
                                            Caminhao caminhaoEditado = (Caminhao) arrayVeiculos.getObjeto(j);
                                            if (Placa.equals(caminhaoEditado.getPlaca())) {
                                                System.out.println(caminhaoEditado.getCapacidadeCarga());
                                                System.out.print("Digite a nova capacidade de carga:  ");
                                                caminhaoEditado.setCapacidadeCarga(scanner.nextInt());
                                            }
                                        }
                                    } else if (menuP.getQualAtributo().equals("2")) {
                                        for (int j = 0; j < arrayVeiculos.tamanho(); j++) {
                                            Onibus onibusEditado = (Onibus) arrayVeiculos.getObjeto(j);
                                            if (Placa.equals(onibusEditado.getPlaca())) {
                                                System.out.println(onibusEditado.isBanheiro());
                                                System.out.print("Digite se possui banheiro,(true ou false):  ");
                                                onibusEditado.setBanheiro(scanner.nextBoolean());
                                            }
                                        }
                                    } else if (menuP.getQualAtributo().equals("3")) {
                                        for (int j = 0; j < arrayVeiculos.tamanho(); j++) {
                                            Motocicleta motocicletaEditada = (Motocicleta) arrayVeiculos.getObjeto(j);
                                            if (Placa.equals(motocicletaEditada.getPlaca())) {
                                                System.out.println(motocicletaEditada.getCilindrada());
                                                System.out.print("Digite a nova cilindrada: ");
                                                motocicletaEditada.setCilindrada(scanner.nextInt());
                                            }
                                        }
                                    }
                                }
                            }
                        }
                }
            }
        } while (!menuP.getEscolhaPrincipal().equals("0"));
    }
}
