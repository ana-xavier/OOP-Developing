public class Vagao {
    private int id;
    private double cargaMax;
    private Trem trem;

    public Vagao(int id,double cargaMax){
        this.id = id;
        this.cargaMax = cargaMax;
        trem = null;
    }

    public int getId() {
        return id;
    }

    public double getCargaMax() {
        return cargaMax;
    }

    public Trem getTrem() {
        return trem;
    }

    public void vincula(Trem trem){
        this.trem = trem;
    }

    public void desvincula(Trem trem){
        this.trem = null;
    }

    @Override
    public String toString() {
        return "Vagao [cargaMax=" + cargaMax + ", id=" + id + "]";
    }    
}
