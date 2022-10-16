
//Alunos: Ana Carolina Xavier, Carlos Oliveira, Kauana Galan e Maria Eduarda Oliveria

import java.util.ArrayList;
import java.util.List;

public class Trem{
    private int id;
    private List<Veiculo> veiculos;

    public Trem(int id, Locomotiva locomotiva){
        this.id=id;
        veiculos= new ArrayList<>();
        engataLocomotiva(locomotiva);
    }

    public int getId() {
        return id;
    }

    public boolean engataLocomotiva(Locomotiva locomotiva){
        if(veiculos.size()> 0){
            return false;
        }
        veiculos.add(locomotiva);
        locomotiva.vincula(this);
        return true;
    }
    
    public Locomotiva desengataLocomotiva(){
        if(veiculos.size()== 0){
            return null;
        }
        else if (veiculos.get(veiculos.size()-1) instanceof Locomotiva){
            Locomotiva aux = (Locomotiva)veiculos.remove(veiculos.size()-1);
        aux.desvincula();
        return aux;
        }
        return null;
    }

    public boolean engataVagao(Veiculo aux){
        if (limiteDeVagoesAtingido() || pesoMaximoDosVagoesAtingido()){
            return false;
        }
        else if (aux instanceof VagaoCarga || aux instanceof VagaoPassageiros){
            veiculos.add(aux);
            aux.vincula(this);
            return true;
        }
        return false;
    }
    
    public Veiculo desengataVagao(){
        if (veiculos.size() > 0){
            if(veiculos.get(veiculos.size()-1) instanceof VagaoPassageiros || veiculos.get(veiculos.size()-1) instanceof VagaoCarga){
                Veiculo aux= veiculos.get(veiculos.size()-1);
                veiculos.remove(aux);
                aux.desvincula();
                return aux;
            }
        }
        return null;
    }

    private boolean limiteDeVagoesAtingido(){
        int qtdade = 0;
        for(Veiculo v: veiculos){
            if(v instanceof Locomotiva){
                Locomotiva aux= (Locomotiva)v;
                qtdade += aux.getNroMaxVagoes();
            }
        }
        return veiculos.size()-1 >= qtdade;
    }

    private double pesoMaximoLocomotivasTracionam(){
        double peso = 0;
        double tx = 1.0;
        for(Veiculo v: veiculos){
            if (v instanceof Locomotiva){
                Locomotiva aux= (Locomotiva)v;
                peso += aux.getPesoMaximo() * tx;
                tx *= 0.9;
            } 
        }
        return peso;
    }

    private boolean pesoMaximoDosVagoesAtingido(){
        double peso = 0.0;
        for(Veiculo v: veiculos){
            if(v instanceof VagaoCarga){
                VagaoCarga aux= (VagaoCarga)v;
                peso += aux.getCargaMax();
            }
        } 
        return peso >= pesoMaximoLocomotivasTracionam();
    }

    private boolean nroMaximodePassageirosAtingido(){
        int nroPassageiros=0;
        for(Veiculo v: veiculos){
            if(v instanceof VagaoPassageiros){
                VagaoPassageiros aux= (VagaoPassageiros)v;
                nroPassageiros += aux.getNroMaxPassageiros();
            }
        } 
        return  nroPassageiros*80.0>= pesoMaximoLocomotivasTracionam();
    }

    @Override
    public String toString() {
        String aux = "T"+id+"+";
        for(int i=0; i<veiculos.size();i++){
            aux += "[L"+veiculos.get(i).getId()+"]+";
        }
        return aux;
    }
}

