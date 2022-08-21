import java.util.ArrayList;

import javax.print.attribute.standard.MediaSize.NA;

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

    public void consultaItemPorSetor(String setor){

        boolean nAchei=true;
        for (int i = 0; i < itens.size(); i++) {
            if (itens.get(i).getSetor().equals(setor.trim())) {
                itens.get(i).imprimeItem();
                nAchei=false;  
            }
        }
        if(nAchei){System.out.println("não foi encontrado nenhum item neste setor");}

    }

    public void listItens(){
        if(itens.size()==0){System.out.println("esta prateleira está vazia");}
        else{

            for (int i = 0; i < itens.size(); i++) {
                    itens.get(i).imprimeItem();
            }
        }
        
    }
    public void setCapMaxPeso(float capMaxPeso) {
        this.capMaxPeso = capMaxPeso;
    }

    public void atualizaItem(int indice,Item item){
        itens.set(indice, item);
    }
    public void addItem(Item item){
        if(validaCapacidade(item.getPeso()*item.getQuantidade(), item.getVolume()*item.getQuantidade())){
            itens.add(item);
            incrementPesoOcupado(item.getPeso());
            incrementVolumeOcupado(item.getVolume());
            return;
        }
        System.out.println("a prateleira não suporta adicionar este item");     
    }

    public void deleteItem(int indice){
        decrementPesoOcupado(itens.get(indice).getPeso());
        decrementVolumeOcupado(itens.get(indice).getVolume());
        itens.remove(indice);
    }

    public int encontraItem(String nome){
        for(int i=0;i<itens.size();i++){
            if(itens.get(i).getNome().equals(nome.trim())){return i;}
        }

        return -1;
    }

    public void setCapMaxVolume(float capMaxVolume) {
        this.capMaxVolume = capMaxVolume;
    }

    public void removePorIndice(int indice){
        
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
    public boolean validaCapacidade(float peso,float volume){
        float volumeAtual=this.volumeOcupado+volume;
        float pesoAtual=this.pesoOcupado+peso;
        if(pesoAtual>capMaxPeso || volumeAtual>capMaxVolume){return false;}
        return true;
    }
}
