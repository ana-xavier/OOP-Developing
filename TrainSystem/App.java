import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner entrada = new Scanner(System.in);
        Patio trenzinhos = new Patio();
        int opcao, opcaoEdicao, tremId;
        
        System.out.println("Bem vindo ao sisteminha de trens!\n");

        do{
            opcao = menuPrincipal();
            switch(opcao){
                case 1:
                    boolean b = false;
                    do{
                        System.out.print("Qual o identificador do trem? ");
                        tremId = entrada.nextInt();
                        if(!trenzinhos.checaIdTrem(tremId)){
                            b=true;
                        } else {
                            System.out.println("Um trem com esse identificador ja existe");
                        }
                    }while(!b);
                    trenzinhos.listarLocomotivasLivres();
                    System.out.print("Qual será a primeira locomotiva: ");
                    int locomotivaId = entrada.nextInt();

                    trenzinhos.criaTrem(tremId, locomotivaId);

                    break;
                case 2:
                    System.out.println(trenzinhos);
                    System.out.print("Qual trem deseja editar? (insira o id)");
                    do{
                        tremId = entrada.nextInt();
                        b = trenzinhos.checaIdTrem(tremId);
                        if(!b){
                            System.out.println("Insira um trem válido!");
                        }
                    }while (!b);

                    do{
                        opcaoEdicao = menuEdicao();
                        switch(opcaoEdicao){
                            case 0:
                                System.out.println("Saindo da edição");
                                break;
                            //inserir locomotiva
                            case 1:
                                trenzinhos.inserirLocomotiva(tremId);
                                break;
                            //inserir vagão
                            case 2:
                                trenzinhos.inserirVagao(tremId);
                                break;
                            //remover o ultimo elemento
                            case 3:
                                trenzinhos.removerUltimo(tremId);
                                break;
                            //listas locomotivas livres
                            case 4:
                                trenzinhos.listarLocomotivasLivres();
                                break;
                            //listar vagões livres
                            case 5:
                                trenzinhos.listarVagoesLivres();
                                break;
                            default:
                                System.out.println("Opção inválida");
                                break;
                        }
                    }while(opcaoEdicao != 0);
                    break;
                case 3:
                    System.out.println(trenzinhos);
                    break;
                case 4:
                    System.out.println("Qual trem deseja desfazer? ");
                    tremId = entrada.nextInt();
                    if(!trenzinhos.desfazTrem(tremId)){
                        System.out.println("Esse trem não existe!");
                        opcao = 6;
                    }
                    break;
                case 5:
                    System.out.println("Fim do programa");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }while(opcao != 5);
    }

    public static int menuPrincipal(){
        Scanner entrada = new Scanner(System.in);
        int opcao;
        do{
            System.out.println("    Menu de opções!    ");
            System.out.println("   1 - Criar trem      ");
            System.out.println("   2 - Editar trem     ");
            System.out.println("   3 - Listar trens    ");
            System.out.println("   4 - Desfazer trem   ");
            System.out.println("   5 - Sair do programa");
            System.out.print(" Qual opção deseja?  ");
            opcao = entrada.nextInt();
            if(opcao < 1 || opcao > 5){
                System.out.println("Opção inválida");
            }
        }while(opcao < 1 || opcao > 5);

        return opcao;
    }

    public static int menuEdicao(){
        Scanner entrada = new Scanner(System.in);
        int opcao;
        do{
            System.out.println("\n   Menu de opção de edição de trem ");
            System.out.println("  1 - Inserir locomotiva             ");
            System.out.println("  2 - Inserir vagão                  ");
            System.out.println("  3 - Remover último elemento do trem");
            System.out.println("  4 - Listar locomotivas livres      ");
            System.out.println("  5 - Listar vagões livres           ");
            System.out.println("  0 - Parar de editar                ");
            System.out.print("Qual opção desejada?                   ");
            opcao = entrada.nextInt();
            if(opcao < 0 || opcao > 5){
                System.out.println("Opção inválida");
            }
        }while(opcao < 0 || opcao > 5);

        return opcao;
    }
}
