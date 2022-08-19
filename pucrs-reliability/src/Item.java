public class Item {
    private String nome;
    private String tipo;
    private float peso;
    private float volume;
    private int quantidade;
    private String setor;
    private String localizacao;
    private int idPrateleira;// chave estrangeira com referencia a chave primaria da tabela prateleira

    //construtor sem parametro com valores invalidos 
    public Item() {
        
        this.nome = "";
        this.tipo = "";
        this.peso = -1;
        this.volume = -1;
        this.quantidade = 0;
        this.setor = "";
        this.localizacao = "";
        this.idPrateleira = -1;

    }

    //construtor com parametros
    public Item( String nome,String tipo,float peso, float volume, int quantidade, String setor, 
    String localizacao,int idPrateleira){
        this.nome=nome;
        this.tipo=tipo;
        this.peso=peso;
        this.volume=volume;
        this.quantidade=quantidade;
        this.setor=setor;
        this.localizacao=localizacao;
        this.idPrateleira=idPrateleira;

    }


    public int getIdPrateleira() {
        return idPrateleira;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public String getNome() {
        return nome;
    }

    public float getPeso() {
        return peso;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public String getSetor() {
        return setor;
    }

    public String getTipo() {
        return tipo;
    }

    public float getVolume() {
        return volume;
    }

    // setters
    

    public void setIdPrateleira(int idPrateleira) {
        this.idPrateleira = idPrateleira;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setVolume(float volume) {
        this.volume = volume;
    }

}
