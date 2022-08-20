
public class Prateleira {
    private String nomePrateleira;//chave primaria
    private String setor;
    private float capMaxPeso;
    private float capMaxVolume;

    //construtores

    //construtor sem parametros com valores invalidos
    public Prateleira() {
        this.nomePrateleira ="";
        this.setor = "";
        this.capMaxPeso = 0;
        this.capMaxVolume = 0;

    }

    //construtor com parametros 

    public Prateleira(String nomePrateleira,String setor,float capMaxPeso,float capMaxVolume){
        this.nomePrateleira=nomePrateleira;
        this.setor=setor;
        this.capMaxPeso=capMaxPeso;
        this.capMaxVolume=capMaxVolume;
        
    }

    //getters

    public float getCapMaxPeso() {
        return capMaxPeso;
    }

    public float getCapMaxVolume() {
        return capMaxVolume;
    }

    public String getIdPrateleira() {
        return nomePrateleira;
    }

    public String getSetor() {
        return setor;
    }

    //setters
    public void setCapMaxPeso(float capMaxPeso) {
        this.capMaxPeso = capMaxPeso;
    }

    public void setCapMaxVolume(float capMaxVolume) {
        this.capMaxVolume = capMaxVolume;
    }

    public void setIdPrateleira(String nomePrateleira) {
        this.nomePrateleira = nomePrateleira;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }
}
