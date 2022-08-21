//Trabalho de Ana Carolina Xavier, 21-08-22

public class Cofrinho {
    private Moeda [] cofrinho;
    private int proxLivre;
    private int tamanho;

    public Cofrinho(){
        proxLivre = 0;
        tamanho = 100;
        cofrinho = new Moeda[tamanho];  
    }

    public Cofrinho(int tamanho){
        proxLivre = 0;
        this.tamanho = tamanho;
        cofrinho = new Moeda[tamanho]; 
    }

    public boolean Insere(Moeda moeda){
        if(proxLivre >= tamanho){
            return false;
        }
        cofrinho[proxLivre] = moeda;
        proxLivre++;

        return true;
    }

    public Moeda Retira(){
        if((proxLivre) == 0){
            return null;
        }
        proxLivre--;
        return cofrinho[proxLivre];
    }

    public int getQtdadeMoedas(){
        return cofrinho.length;
    }

    public int getQtDeMoedasTipo(NomeMoeda nomeMoeda){
        int quant = 0;
        for(int pos = 0; pos < proxLivre; pos++){
            if(cofrinho[pos].getNomeMoeda().equals(nomeMoeda)){
                quant++;
            }
        }
        return quant;
    }

    public double getValorTotalCentavos(){
        double soma = 0.0;
        for(int pos = 0; pos < proxLivre; pos++){
            soma += cofrinho[pos].getValorCentavos();
        }
        return soma;
    }
    
    public double getValorTotalReais(){
        double soma = 0.0;
        for(int pos = 0; pos < proxLivre; pos++){
            soma += cofrinho[pos].getValorReais();
        }
        return soma;
    }

    public String toString(){
        String textin = "[";
        for(int pos = 0; pos < proxLivre; pos++){
            textin += cofrinho[pos].getNomeMoeda().name() + " , ";
        }
        textin += cofrinho[proxLivre -1].getNomeMoeda().name() + "]";
        return textin;
    }
}
