
//Alunos: Ana Carolina Xavier, Carlos Oliveira, Kauana Galan e Maria Eduarda Oliveria

import java.util.ArrayList;

public class Garagem {
    private ArrayList <Veiculo> veiculoG;

    public Garagem () {
    veiculoG = new ArrayList<>(60);
    }

    public void entra (Veiculo veiculoEntra){
        veiculoG.add(veiculoEntra);
    }

    public Veiculo sai (int id){ // no resto do código eu preciso deixar claro o tipo q sai
        for(Veiculo v: veiculoG){
            if (v.getId() == id){
                veiculoG.remove(v);
               return v;
            }
        }
        return null;
    }

    public Integer getNumLocomotiva(){
        int num =0;
        for(int i = 0; i< veiculoG.size(); i++){
            if (veiculoG.get(i) instanceof Locomotiva){
                num += 1;
            }
        }
        return num;
    }

    public Integer getNumVagaoCarga(){
        int num = 0;
        for(int i = 0; i< veiculoG.size(); i++){
            if(veiculoG.get(i) instanceof VagaoCarga){
                num += 1;
            }
        }
        return num;
    }

    public Integer getNumVagaoPassageiro(){
        int num = 0;
        for(int i = 0; i< veiculoG.size(); i++){
            if(veiculoG.get(i) instanceof VagaoPassageiros){
                num += 1;
            }
        }
        return num;
    }

    public String toStringL() {
        StringBuilder aux = new StringBuilder("Garagem das locomotivas\n\n");
        for(Veiculo l: veiculoG){
            if(l instanceof Locomotiva) {
                aux.append(l.toString()).append("\n");
            }
        }
        return aux.toString();
    }

    public String toStringVC() {
        StringBuilder aux = new StringBuilder("Garagem dos vagões de carga\n\n");
        for(Veiculo vc: veiculoG){
            if (vc instanceof VagaoCarga){
                aux.append(vc.toString()).append("\n");
                }
            }
        return aux.toString();
        }

    public String toStringVP() {
        StringBuilder aux = new StringBuilder("Garagem dos vagões de passageiro\n\n");
        for(Veiculo vp: veiculoG){
            if (vp instanceof VagaoPassageiros){
                aux.append(vp.toString()).append("\n");
            }
        }
        return aux.toString();
    }

}
