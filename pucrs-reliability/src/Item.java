public class Item {
    private String nome;
    private Tipo tipo;
    private float peso;
    private float volume;
    private int quantidade;
    private String setor;
    private String localizacao;

    // construtor sem parametro com valores invalidos
    public Item() {

        this.nome = "";
        this.tipo = null;
        this.peso = -1;
        this.volume = -1;
        this.quantidade = 0;
        this.setor = "";
        this.localizacao = "";

    }

    // construtor com parametros
    public Item(String nome, Tipo tipo, float peso, float volume, int quantidade, String setor,
            String localizacao) {
        this.nome = nome;
        this.tipo = tipo;
        this.peso = peso;
        this.volume = volume;
        this.quantidade = quantidade;
        this.setor = setor;
        this.localizacao = localizacao;

    }

    // getters
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

    public Tipo getTipo() {
        return tipo;
    }

    public float getVolume() {
        return volume;
    }

    // setters
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

    public void setVolume(float volume) {
        this.volume = volume;
    }
    // métodos auxiliares

    // imprime as propriedades da classe
    public void imprimeItem() {
        System.out.println("Nome:" + nome);
        System.out.println("Tipo:" + tipo);
        System.out.println("Peso:" + peso);
        System.out.println("Volume:" + volume);
        System.out.println("Quantidade:" + quantidade);
        System.out.println("Setor:" + setor);
        System.out.println("Localização na prateleira:" + localizacao);
        System.out.println("---------------------------------------------------------------");

    }

    // converte um inteiro vindo como parametro para o Enum equivalente de Tipo
    public void setTipo(int tipo) {
        switch (tipo) {
            case 1:
                this.tipo = Tipo.CARNES;
                break;
            case 2:
                this.tipo = Tipo.HIGIENE;
                break;
            case 3:
                this.tipo = Tipo.LIMPEZA;
                break;
            case 4:
                this.tipo = Tipo.SALGADINHOS;
                break;
            case 5:
                this.tipo = Tipo.CONGELADOS;
                break;
            case 6:
                this.tipo = Tipo.FRIOS;
                break;
            case 7:
                this.tipo = Tipo.ENLATADOS;
                break;
            case 8:
                this.tipo = Tipo.BEBIDAS;
                break;
            case 9:
                this.tipo = Tipo.PEIXES;
                break;
            case 10:
                this.tipo = Tipo.OUTROS;
                break;
            default:
                this.tipo = null;

        }

    }

}
