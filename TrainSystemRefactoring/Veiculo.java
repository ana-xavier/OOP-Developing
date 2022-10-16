
//Alunos: Ana Carolina Xavier, Carlos Oliveira, Kauana Galan e Maria Eduarda Oliveria

public class Veiculo {
    private int id;
    private Trem trem;

    public Veiculo(int id){
        this.id=id;
        this.trem=null;
    }

    public int getId() {
        return id;
    }

    public Trem getTrem() {
        return trem;
    }

    public void vincula(Trem t){
        this.trem=t;
    }

    public void desvincula(){
        this.trem=null;
    }
}