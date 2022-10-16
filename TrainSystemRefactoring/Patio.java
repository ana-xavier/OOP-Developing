
//Alunos: Ana Carolina Xavier, Carlos Oliveira, Kauana Galan e Maria Eduarda Oliveria

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Patio {
    private ArrayList <Trem> trens;
    Garagem GG;
    Random random = new Random();
    Scanner input = new Scanner(System.in);

    public Patio(){
    trens = new ArrayList <Trem> (100);
    GG = new Garagem();

        for (int i=0; i<20;i++)
        {
            GG.entra(new VagaoCarga(100+random.nextInt(999), 6000));
        }

        for (int i=0; i<20;i++)
        {
            GG.entra(new VagaoPassageiros(100+random.nextInt(999), 60));
        }

        GG.entra(new Locomotiva(101, 6000, 6));
        GG.entra(new Locomotiva(102, 8000, 8));
        GG.entra(new Locomotiva(103, 7000, 7));
        GG.entra(new Locomotiva(104, 10000, 10));

    }
    public void entraTrem (Trem trem){ //adiciona trem
        trens.add(trem);
    }

    public Trem criaTrem(int idTrem, int idLocomotiva){ //cria trem

        Trem t = new Trem(idTrem,(Locomotiva)GG.sai(idLocomotiva));
        trens.add(t);
        return t;
    }

    public Trem getTremId(int id){
        for(Trem t : trens){
            if(t.getId() == id){
                return t;
            }
        }
        return null;
    }

    public boolean checkIdTrem(int id){
        for(Trem t: trens){
            if (t.getId() == id){
                return true;
            }
        }
        return false;
    }

    public boolean desfazTrem(int idTrem){ //desfaz o trem

        if (!checkIdTrem(idTrem)) {
            return false;
        }
        Trem t = getTremId(idTrem);
        while(true) {
            Veiculo v = t.desengataVagao();
            if (v == null) {
                break;
            }
            GG.entra(v);
        }

        trens.remove(t);
        t = null;
        return true;
    }

    public boolean removerUltimo(int idTrem) {
        Trem trem= null;
        for (int i=0; i<trens.size();i++)
        {
            trem= trens.get(i);
            if (trem.getId()== idTrem)
            {
                break;
            }
        }
        Veiculo vagao = trem.desengataVagao();
        if(vagao == null){
            return false;
        } else {
            GG.entra(vagao);
            return true;
        }
    }

    public boolean insereLocomotiva(int idTrem){ //inserir locomotiva
        if(GG.getNumLocomotiva() < 1){
            System.out.println("Nao há locomotivas disponíveis!");
            return false;
        } else {
            System.out.println("Locomotivas disponiveis: " + GG.toString());

            Veiculo locomotiva = GG.sai(input.nextInt());

            return getTremId(idTrem).engataLocomotiva((Locomotiva) locomotiva);
        }
    }

    public boolean insereVC(int idTrem){ //insere vagoes de carga
        if(GG.getNumVagaoCarga() < 1){
            System.out.println("Não há vagões de carga disponíveis.");
            return false;
        }
        else{
            System.out.println("Vagões de carga disponíveis: " + GG.toStringVC());
            System.out.println("Qual vagão deseja engatar? Insira o ID. ");

            Veiculo VC = GG.sai(input.nextInt()); // perguntar pq nao funciona pro kaka

            Trem t = getTremId(idTrem);

            return t.engataVagao(VC);
        }
    }

    public boolean insereVP (int idTrem){ //insere vagoes de passageiros
        if(GG.getNumVagaoPassageiro() < 1){
            System.out.println("Não há vagões de passageiros disponíveis.");
            return false;
        }
        else{
            System.out.println("Vagões de passageiros disponíveis: " + GG.toStringVP());
            System.out.println("Qual vagão deseja engatar? Insira o ID. ");

            Veiculo VP = GG.sai(input.nextInt()); //mesma coisa de cima

            Trem t = getTremId(idTrem);

            return t.engataVagao(VP);
        }
    }

    public void listarLocomotivasLivres(){ //locomotivas livres
        if(GG.getNumLocomotiva() < 1){
            System.out.println("Nao há locomotivas disponíveis!");
        } else {
            System.out.println("Locomotivas disponiveis: " + GG.toStringL());
        }
    }

    public void listarVCLivres() { //vagoes de carga livres
        if(GG.getNumVagaoCarga() < 1){
            System.out.println("Não há vagões disponíveis");
        } else {
            System.out.println("Vagões disponíveis:" + GG.toStringVC());
        }
    }

    public void listarVPLivres() { //vagoes de passageiros livres
        if(GG.getNumVagaoPassageiro() < 1){
            System.out.println("Não há vagões disponíveis");
        } else {
            System.out.println("Vagões disponíveis:" + GG.toStringVP());
        }
    }

    public String toString() {
        StringBuilder aux = new StringBuilder("Patio de trens\n\n");
        for(Trem l:trens){
            aux.append(l.toString()).append("\n");
        }
        return aux.toString();
    }

}
