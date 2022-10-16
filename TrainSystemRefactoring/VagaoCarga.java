
//Alunos: Ana Carolina Xavier, Carlos Oliveira, Kauana Galan e Maria Eduarda Oliveria

public class VagaoCarga extends Veiculo {
    private double cargaMax;
    private Trem trem;
    //private int id;

    public VagaoCarga(int id, double cargaMax){
        super(id);
        this.trem=null;
        this.cargaMax=cargaMax;
    }

    public double getCargaMax(){
        return cargaMax;
    }

    @Override
    public String toString() {
        return "VG [cMax=" + cargaMax + ", id=" + super.getId() + "]";
    }
}