
public class Prateleira {
    private int idPrateleira;//chave primaria
    private String setor;
    private float capMaxPeso;
    private float capMaxVolume;

    //construtores

    //construtor sem parametros com valores invalidos
    public Prateleira() {
        this.idPrateleira = -1;
        this.setor = "";
        this.capMaxPeso = 0;
        this.capMaxVolume = 0;

    }

    //construtor com parametros 

    public Prateleira(int idPrateleira,String setor,float capMaxPeso,float capMaxVolume){
        this.idPrateleira=idPrateleira;
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

    public int getIdPrateleira() {
        return idPrateleira;
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

    public void setIdPrateleira(int idPrateleira) {
        this.idPrateleira = idPrateleira;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }
}
