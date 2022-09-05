//import java.util.Scanner;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Patio {
    private ArrayList<Trem> trens;
    GaragemLocomotivas gl;
    GaragemVagoes gv;
    Random rand= new Random();
    Scanner entrada = new Scanner(System.in);

    public Patio(){
        trens = new ArrayList<Trem>(100);
        gl = new GaragemLocomotivas();
        gv = new GaragemVagoes();

        for (int i=0; i<20;i++)
        {
            gv.entra(new Vagao(100+rand.nextInt(899), 6000));
        }

        gl.entra(new Locomotiva(101, 6000, 5));
        gl.entra(new Locomotiva(461, 8000, 6));
        gl.entra(new Locomotiva(121, 7000, 5));
        gl.entra(new Locomotiva(801, 10000, 9));

    }

    //se não achar o trem da id, vai retornar o trem com id "0", se existir
    public Trem getTrem(int id){
        for(Trem t: trens){
            if (t.getId() == id){
                return t;
            }
        }
        return null;
    }

    public boolean checaIdTrem(int id){
        for(Trem t: trens){
            if (t.getId() == id){
                return true;
            }
        }
        return false;
    }

    public boolean desfazTrem(int idTrem) {
        if (!checaIdTrem(idTrem)) {
            return false;
        }
        Trem t = getTrem(idTrem);
        while(true) {
            Vagao v = t.desengataVagao();
            if (v == null) {
                break;
            }
            gv.entra(v);
        }
        while(true) {
            Locomotiva l = t.desengataLocomotiva();
            if (l == null) {
                break;
            }
            gl.entra(l);
        }
        trens.remove(t);
        t = null;
        return true;
    }


    public boolean inserirVagao(int idTrem){
        if(gv.getNumVagoes() < 1){
            System.out.println("Não há vagões disponíveis");
            return false;
        } else {
            System.out.println("Vagões disponíveis:" + gv.toString());
            System.out.print("Qual vagão deseja engatar?(ID) ");
            Vagao vagao = gv.sai(entrada.nextInt());
            Trem t = getTrem(idTrem);
            return t.engataVagao(vagao);
        }
    }

    public boolean inserirLocomotiva(int idTrem){
        if(gl.getNumLocomotivas() < 1){
            System.out.println("Nao há locomotivas disponíveis!");
            return false;
        } else {
            System.out.println("Locomotivas disponiveis: " + gl.toString());
            System.out.print("Qual locomotiva deseja engatar?(ID) ");
            Locomotiva locomotiva = gl.sai(entrada.nextInt());
            return getTrem(idTrem).engataLocomotiva(locomotiva);
        }
    }

    public void entra(Trem trem){
        trens.add(trem);
    }

    public String toString() {
        StringBuilder aux = new StringBuilder("Patio de trens\n\n");
        for(Trem l:trens){
            aux.append(l.toString()).append("\n");
        }
        return aux.toString();
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
        Vagao vagao = trem.desengataVagao();
        if(vagao == null){
            return false;
        } else {
            gv.entra(vagao);
            return true;
        }
    }

    public void listarLocomotivasLivres() {
        if(gl.getNumLocomotivas() < 1){
            System.out.println("Nao há locomotivas disponíveis!");
        } else {
            System.out.println("Locomotivas disponiveis: " + gl.toString());
        }
    }

    public void listarVagoesLivres() {
        if(gv.getNumVagoes() < 1){
            System.out.println("Não há vagões disponíveis");
        } else {
            System.out.println("Vagões disponíveis:" + gv.toString());
        }
    }

    public Trem criaTrem(int idTrem, int idLocomotiva){
        Trem t = new Trem(idTrem, gl.sai(idLocomotiva));
        trens.add(t);
        return t;
    }
}
