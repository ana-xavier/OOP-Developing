
//Alunos: Ana Carolina Xavier, Carlos Oliveira, Kauana Galan e Maria Eduarda Oliveria

public class Locomotiva extends Veiculo {
    private double pesoMaximo;
    private int nroMaxVagoes;
    private Trem trem;

    public Locomotiva(int id, double pesoMaximo, int nroMaxVagoes){
        super(id);
        this.pesoMaximo=pesoMaximo;
        this.nroMaxVagoes=nroMaxVagoes;
        this.trem=null;
    }

    public double getPesoMaximo() {
        return pesoMaximo;
    }

    public int getNroMaxVagoes() {
        return nroMaxVagoes;
    }

    @Override
    public String toString() {
        return "Lc [id=" + super.getId() + ", pMax=" + pesoMaximo + ", nMaxV=" + nroMaxVagoes + "]";
    }

    

}