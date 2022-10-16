
//Alunos: Ana Carolina Xavier, Carlos Oliveira, Kauana Galan e Maria Eduarda Oliveria

public class VagaoPassageiros extends Veiculo {
    //private int id;
    private int nroMaxPassageiros;
    private Trem trem;

    public VagaoPassageiros(int id, int nroMaxPassageiros){
        super(id);
        this.trem=null;
        this.nroMaxPassageiros=nroMaxPassageiros;
    }

    public int getNroMaxPassageiros() {
        return nroMaxPassageiros;
    }

    @Override
    public String toString() {
        return "VP [id=" + super.getId() + ", nMaxPass=" + nroMaxPassageiros+"]";
    }

}