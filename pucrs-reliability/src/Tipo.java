public enum Tipo {
    CARNES(1), HIGIENE(2), LIMPEZA(3), SALGADINHOS(4), CONGELADOS(5),
    FRIOS(6),ENLATADOS(7),BEBIDAS(8),PEIXES(9),OUTROS(10);
    
    private final int valor;
    Tipo(int valorOpcao){
    valor = valorOpcao;
    }
    public int getValor(){
    return valor;
    }
    }