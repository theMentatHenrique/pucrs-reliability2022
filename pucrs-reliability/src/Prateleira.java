import java.util.ArrayList;
public class Prateleira {
    private ArrayList<Item> itens;
    private String nomePrateleira;//chave primaria
    private String setor;
    private float capMaxPeso;
    private float capMaxVolume;
    private float pesoOcupado;
    private float volumeOcupado;

    //construtores

    //construtor sem parametros com valores invalidos
    public Prateleira() {
        this.itens=new ArrayList<Item>();
        this.nomePrateleira ="";
        this.setor = "";
        this.capMaxPeso = 0;
        this.capMaxVolume = 0;
        this.pesoOcupado=0;
        this.volumeOcupado=0;

    }

    //construtor com parametros 

    public Prateleira(String nomePrateleira,String setor,float capMaxPeso,float capMaxVolume){

        this.itens=new ArrayList<Item>();
        this.nomePrateleira=nomePrateleira;
        this.setor=setor;
        this.capMaxPeso=capMaxPeso;
        this.capMaxVolume=capMaxVolume;
        this.pesoOcupado=0;
        this.volumeOcupado=0;
        
    }

    //getters
    public float getPesoOcupado() {
        return pesoOcupado;
    }
    public float getVolumeOcupado() {
        return volumeOcupado;
    }
    public String getNomePrateleira() {
        return nomePrateleira;
    }

    public float getCapMaxPeso() {
        return capMaxPeso;
    }

    public float getCapMaxVolume() {
        return capMaxVolume;
    }

    public String getSetor() {
        return setor;
    }

    public ArrayList<Item> getItens(){
        return this.itens;
    }

    //setters

    
    public void setCapMaxPeso(float capMaxPeso) {
        this.capMaxPeso = capMaxPeso;
    }
    //adiciona um novo item no vetor e incrementa com os novos valores de peso/volume ocupados
    public boolean addItem(Item item){

        //é verificado se o peso/volume do item informados vezes a sua quantidade são suportados pela prateleira
        if(validaCapacidade(item.getPeso()*item.getQuantidade(), item.getVolume()*item.getQuantidade())){

            //caso for, adiciona este item e incrementa os novos valores para peso/volume ocupados
            itens.add(item);
            incrementPesoOcupado(item.getPeso()*item.getQuantidade());
            incrementVolumeOcupado(item.getVolume()*item.getQuantidade());
            return true;
        }
        return false;
    }

    //remove um item do vetor e atualiza o peso/volume ocupados
    public void deleteItem(int indice){
        decrementPesoOcupado(itens.get(indice).getPeso()*itens.get(indice).getQuantidade());
        decrementVolumeOcupado(itens.get(indice).getVolume()*itens.get(indice).getQuantidade());
        itens.remove(indice);
    }
    public void setCapMaxVolume(float capMaxVolume) {
        this.capMaxVolume = capMaxVolume;
    }
   public void setNomePrateleira(String nomePrateleira) {
       this.nomePrateleira = nomePrateleira;
   }
   public void incrementPesoOcupado(float peso) {
       this.pesoOcupado += peso;
   }
    public void setSetor(String setor) {
        this.setor = setor;
    }
    public void incrementVolumeOcupado(float volume){
        this.volumeOcupado+=volume;
    }
    public void decrementVolumeOcupado(float volume){
        this.volumeOcupado-=volume;
    }
    public void decrementPesoOcupado(float peso){
        this.pesoOcupado-=peso;
    }

    //métodos auxiliares

     //imprime em tela as propriedades da classe
     public void imprimePrateleira() {
        System.out.println("Nome da prateleira:"+this.getNomePrateleira());
        System.out.println("Setor:"+this.getSetor());
        System.out.println("Quantidade de itens:"+ this.getItens().size());
        System.out.println("Capacidade maxima de peso:"+ this.getCapMaxPeso()+"KG");
        System.out.println("Capacidade maxima de volume:"+ this.getCapMaxVolume()+"M3");
        System.out.println("Capacidade ocupada de peso:"+ this.getPesoOcupado()+"KG");
        System.out.println("Capacidade ocupada de volume:"+ this.getVolumeOcupado()+"M3");
        System.out.println("---------------------------------------------------------------");
    }
    //encontra o item especifico pelo nome,e caso haja correspondencia retorna o indice deste objeto
    //no vetor da classe
    public int encontraItem(String nome){
        for(int i=0;i<itens.size();i++){
            if(itens.get(i).getNome().equals(nome.trim())){return i;}
        }

        return -1;
    }

    //imprime em tela os itens presentes no vetor de itens que possuem o mesmo setor que o especificado
    public boolean consultaItemPorSetor(String setor){
        boolean encontrei=false;
        for (int i = 0; i < itens.size(); i++) {
            if (itens.get(i).getSetor().equals(setor.trim())) {
                encontrei=true;
                itens.get(i).imprimeItem();              
            }
        }
        return encontrei;   
    }
    
    //imprime em tela todos os itens presentes no vetor
    public void listItens(){
        if(itens.size()==0){System.out.println("esta prateleira está vazia");}
        else{

            for (int i = 0; i < itens.size(); i++) {
                    itens.get(i).imprimeItem();
            }
        }
        
    }

    //valida se é possivel adicionar mais um item no vetor
    public boolean validaCapacidade(float peso,float volume){

        //o volume/peso atual é o volume/peso já ocupado somado do volume/peso do item a ser adicionado
        float volumeAtual=this.volumeOcupado+volume;
        float pesoAtual=this.pesoOcupado+peso;

        //caso estes valores sejam maiores que as capacidades maximas da prateleira, retorna falso
        if(pesoAtual>capMaxPeso || volumeAtual>capMaxVolume){return false;}

        //caso não, retorna verdadeiro
        return true;
    }
}
