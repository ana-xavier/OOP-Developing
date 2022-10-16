
//Alunos: Ana Carolina Xavier, Carlos Oliveira, Kauana Galan e Maria Eduarda Oliveria

import java.util.*;

public class Menu {
    public void menu() {
        Patio trenzinhos = new Patio();
        int opcao, opcaoEdicao, tremId;
        Scanner in = new Scanner(System.in);

        System.out.println("\033[0;32m" + "Bem vindo ao sisteminha de trens!\n");
        do {
            opcao = menuPrincipal();
            switch (opcao) {
                case 1:
                    boolean b = false;
                    do {
                        System.out.print("Qual o identificador do trem? ");
                        tremId = in.nextInt();
                        if (!trenzinhos.checkIdTrem(tremId)) {
                            b = true;
                        } else {
                            System.out.println("Um trem com esse identificador já existe!!!");
                        }
                    } while (!b);
                    trenzinhos.listarLocomotivasLivres();
                    System.out.println("Qual será a primeira locomotiva? Insira o identificador dela: ");
                    int locomotivaId = in.nextInt();

                    trenzinhos.criaTrem(tremId, locomotivaId);

                    break;
                case 2:
                    System.out.println(trenzinhos);
                    System.out.print("Qual trem deseja editar? Insira o id dele, por favor");
                    do {
                        tremId = in.nextInt();
                        b = trenzinhos.checkIdTrem(tremId);
                        if (!b) {
                            System.out.println("Insira um trem válido!");
                        }
                    } while (!b);

                    do {
                        opcaoEdicao = menuEdicao();
                        switch (opcaoEdicao) {
                            case 0:
                                System.out.println("Saindo da edição...");
                                System.out.println("Pronto!");
                                break;
                            //inserir locomotiva
                            case 1:
                                trenzinhos.insereLocomotiva(tremId);
                                break;
                            //inserir vagão de carga
                            case 2:
                                trenzinhos.insereVC(tremId);
                                break;
                            //inserir vagão de pessoas
                            case 3:
                                trenzinhos.insereVP(tremId);
                                //remover o ultimo elemento
                            case 4:
                                trenzinhos.removerUltimo(tremId);
                                break;
                            //listas locomotivas livres
                            case 5:
                                trenzinhos.listarLocomotivasLivres();
                                break;
                            //listar vagões de carga livres
                            case 6:
                                trenzinhos.listarVCLivres();
                                break;
                            //listar vagões de pessoas livres
                            case 7:
                                trenzinhos.listarVPLivres();
                            default:
                                System.out.println("Opção inválida");
                                break;
                        }
                    } while (opcaoEdicao != 0);
                    break;
                case 3:
                    System.out.println(trenzinhos);
                    break;
                case 4:
                    System.out.println("Qual trem deseja desfazer? ");
                    tremId = in.nextInt();
                    if (!trenzinhos.desfazTrem(tremId)) {
                        System.out.println("Esse trem não existe!");
                    }
                    break;
                case 5:
                    System.out.println("Fim do programa");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        } while (opcao != 5);
    }


    public static int menuPrincipal() {
        Scanner in = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("    Menu de opções!    ");
            System.out.println("   1 - Criar trem      ");
            System.out.println("   2 - Editar trem     ");
            System.out.println("   3 - Listar trens    ");
            System.out.println("   4 - Desfazer trem   ");
            System.out.println("   5 - Sair do programa");
            System.out.print(" Qual opção deseja?  ");
            opcao = in.nextInt();
            if (opcao < 1 || opcao > 5) {
                System.out.println("Opção inválida");
            }
        } while (opcao < 1 || opcao > 5);

        return opcao;
    }

    public static int menuEdicao() {
        Scanner in = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("\n   Menu de opção de edição de trem ");
            System.out.println("  1 - Inserir locomotiva             ");
            System.out.println("  2 - Inserir vagão de carga         ");
            System.out.println("  3 - Inserir vagão de passageiros   ");
            System.out.println("  4 - Remover último elemento do trem");
            System.out.println("  5 - Listar locomotivas livres      ");
            System.out.println("  6 - Listar vagões de carga livres  ");
            System.out.println("  7 - Listar vagões de pessoas livres");
            System.out.println("  0 - Parar de editar                ");
            System.out.print("Qual opção desejada?                   ");
            opcao = in.nextInt();
            if (opcao < 0 || opcao > 7) {
                System.out.println("Opção inválida");
            }
        } while (opcao < 0 || opcao > 7);

        return opcao;
    }

}
