public class Locomotiva {
    private int identificador;
    private double pesoMaximo;
    private int nroMaxVagoes;
    private Trem trem;

    public Locomotiva(int identificador, double pesoMaximo, int nroMaxVagoes) {
        this.identificador = identificador;
        this.pesoMaximo = pesoMaximo;
        this.nroMaxVagoes = nroMaxVagoes;
        this.trem = null;
    }

    public int getIdentificador() {
        return identificador;
    }

    public double getPesoMaximo() {
        return pesoMaximo;
    }

    public int getNroMaxVagoes() {
        return nroMaxVagoes;
    }

    public Trem getTrem() {
        return trem;
    }

    public void vincula(Trem trem){
        this.trem = trem;
    }
    public void desvincula(){
        this.trem = null;
    }

    @Override
    public String toString() {
        return "Locomotiva [identificador=" + identificador + ", nroMaxVagoes=" + nroMaxVagoes + ", pesoMaximo="
                + pesoMaximo + "]";
    }
}
