import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    // o método main apresenta o menu de opções possiveis e redireciona conforme
    // escolha
    public static void main(String[] args) throws Exception {

        //é instanciado uma lista de prateleiras previamente, pois as mesmas não estão incluidas no processo de CRUD
        ArrayList<Prateleira> prateleiras = new ArrayList<Prateleira>();
        Prateleira prateleira = new Prateleira("1C", "gulouseimas", 100000f, 100000f);
        prateleiras.add(prateleira);
        prateleira = new Prateleira("1P", "gulouseimas", 100f, 100f);
        prateleiras.add(prateleira);
        prateleira = new Prateleira("1B", "gulouseimas", 100f, 100f);
        prateleiras.add(prateleira);
        prateleira = new Prateleira("1I", "gulouseimas", 100f, 100f);
        prateleiras.add(prateleira);

        //abaixo esta o menu interativo e cada opcao leva a um método especifico
        boolean continuar = true;

        while (continuar) {
            Scanner in = new Scanner(System.in);

            System.out.println("qual operacao deseja realizar:");
            System.out.println("1-Adicionar item");
            System.out.println("2-Excluir item");
            System.out.println("3-Alterar item");
            System.out.println("4-Consultar item");
            System.out.println("5-Consultar item por setor");
            System.out.println("6-Consultar item por prateleira");
            System.out.println("7-Consultar prateleira por setor");
            System.out.println("0-Sair");

            int opt = in.nextInt();
            switch (opt) {

                case 1:
                    addItem(prateleiras, false);
                    break;
                case 2:
                    deleteItem(prateleiras);

                    break;
                case 3:
                    updateItem(prateleiras);
                    break;
                case 4:
                    listarItens(prateleiras);
                    break;
                case 5:
                    consultaItemPorSetor(prateleiras);
                    break;
                case 6:
                    consultaPorPrateleira(prateleiras);
                    break;
                case 7:
                    consultaPrateleiraPorSetor(prateleiras);
                    break;
                case 0:
                    continuar = false;
                    break;
                default:
                    System.out.println("opcao invalida");
            }
        }

    }

    //percorre todos os elementos do arrayList prateleiras e imprime todos os itens presente nestes objetos
    public static void listarItens(ArrayList<Prateleira> prateleiras) {

        //este laço percorre cada objeto de prateleiras
        for (int i = 0; i < prateleiras.size(); i++) {
            if (prateleiras.get(i).getItens().size() != 0) {

                //listItens imprime todos os itens contidos neste objeto de prateleiras
                prateleiras.get(i).listItens();
            }

        }

    }
    //recebe uma String e a converte para um float convertido da unidade disponibilizada para m3(metros cubicos) 
    public static float convertValorVolume(String valor) {

        try {
            float numero;

            //estes 3 ifs seguintes verificam a unidade dada na String e a converte em um numero aceitavel
            if (valor.contains("MM3")) {

                System.out.println("valor");
                valor = valor.replace(",", ".");
                valor = valor.replace("MM3", "");

                numero = Float.valueOf(valor);
                numero *= 0.000000001;
                return numero;

            }

            if (valor.contains("CM3")) {
                valor = valor.replace(",", ".");
                valor = valor.replace("CM3", "");

                numero = Float.parseFloat(valor);
                numero *= 0.000001;
                return numero;
            }
            if (valor.contains("M3")) {
                valor = valor.replace(",", ".");
                valor = valor.replace("M3", "");

                return numero = Float.valueOf(valor);

            }
            //caso não seja encontrado a formatação a se realizar, retorna um numero negativo e
            //neste retorno é tratado a ocorrência
            return -1f;

        }//caso haja algum erro durante converter o numero para float,
        //como ter uma letra indevida, retorna também um numero negativo a ser tratado posteriormente
         catch (NumberFormatException erro) {

            return -1f;
        }

    }
    //mesmos processos do método acima,porém para unidades de peso e não volume 
    public static float convertValorPeso(String valor) {
        try {
            float numero;

            if (valor.contains("KG")) {
                valor = valor.replace(",", ".");
                valor = valor.replace("KG", "");

                return numero = Float.valueOf(valor);

            }

            if (valor.contains("G")) {
                valor = valor.replace(",", ".");
                valor = valor.replace("G", "");

                numero = Float.parseFloat(valor);
                numero *= 0.001;
                return numero;
            }
            if (valor.contains("MG")) {
                valor = valor.replace(",", ".");
                valor = valor.replace("MG", "");

                numero = Float.parseFloat(valor);
                numero /= 1000000;
                return numero;
            }

            return -1f;
        } catch (NumberFormatException erro) {

            return -1f;
        }

    }

    // este método capta os valores do teclado e os atribui aos campos da classe Item com os devidos controles
    public static Item PopulaCampos() {
        try {
            Item item = new Item();
            Scanner in = new Scanner(System.in);

            System.out.println("digite o nome do produto:");
            item.setNome(in.nextLine());

            System.out.println("escolha o tipo do produto:");
            System.out.println("1-CARNES");
            System.out.println("2-HIGIENE");
            System.out.println("3-LIMPEZA");
            System.out.println("4-SALGADINHOS");
            System.out.println("5-CONGELADOS");
            System.out.println("6-FRIOS");
            System.out.println("7-ENLATADOS");
            System.out.println("8-BEBIDAS");
            System.out.println("9-PEIXES");
            System.out.println("10-OUTROS");

            //este if controla se o tipo se encaixa nas opções possiveis(1-9)
            //caso a entrada seja invalida apresenta mesma mensagem do catch
            int tipo = in.nextInt();
            if (tipo > 0 && tipo < 11) {
                item.setTipo(tipo);
            } else {
                System.out.println("entrada invalida, tente novamente com uma entrada valida");

                return null;
            }
            // limpa o buffer
            in.nextLine();

            //pega o valor como String e realiza a conversão para o tipo float devidamente formatado
            //todos casos são convertidos para letras maiusculas para evitar erros possiveis
            System.out.println("digite o peso do produto com a unidade de medida (100KG, 2.5G,200MG):");
            float peso = convertValorPeso((in.nextLine()).toUpperCase());

            //se o retorno for um numero negativo,não houve formatação correta e apresenta mesma mensagem do catch
            //ademais é setado o tipo devidamente
            if (peso != -1) {
                item.setPeso(peso);
            } else {
                System.out.println("entrada invalida, tente novamente com uma entrada valida");

                return null;
            }

            //mesma lógica acima desenvolvida,porém a chamada é para um método especifico para tratar volume
            System.out.println("digite o volume do produto com a unidade de medida(100M3,1.5CM3,10MM3):");
            float volume = convertValorVolume((in.nextLine()).toUpperCase());
            if (volume != -1) {
                item.setVolume(volume);
            } else {
                System.out.println("entrada invalida, tente novamente com uma entrada valida");

                //retorna nulo caso haja algum problema
                return null;
            }

            //a quantidade de um item deve ser maior que zero 
            System.out.println("digite a quantidade do produto:");
            int quantidade = in.nextInt();
            if (quantidade > 0) {
                item.setQuantidade(quantidade);
            } else {
                System.out.println("entrada invalida, tente novamente com uma entrada valida");

                return null;
            }

            // limpa o buffer
            in.nextLine();

            System.out.println("digite o setor do produto:");
            item.setSetor(in.nextLine());

            System.out.println("digite a localização do produto:");
            item.setLocalizacao(in.nextLine());

            return item;

        } catch (InputMismatchException erro) {
            System.out.println("entrada inválida, tente novamente com outro tipo de entrada");

            return null;
        }

    }

    //procura a prateleira especifica para o tipo de produto especificado e então adiciona este item a esta
    //prateleira

    public static boolean adicionaNaPrateleira(String letra, ArrayList<Prateleira> prateleiras, Item item) {

        for (int i = 0; i < prateleiras.size(); i++) {

            if (prateleiras.get(i).getNomePrateleira().contains(letra.trim())) {
                boolean adicionou = prateleiras.get(i).addItem(item);
                if (adicionou) {
                    return true;
                }
            }
        }
        System.out.println("não foram encontradas prateleiras disponiveis para depositar este item");
        return false;
    }

    //adiciona um novo item ao estoque com base nos dados fornecidos pelo usuario e coloca este item em 
    //uma prateleira especifica
    public static boolean addItem(ArrayList<Prateleira> prateleiras, boolean ehEdicao) {

        //popula um Item com os dados fornecidos pelo usuario 
        Item item = PopulaCampos();
        boolean terminou = false;

        //se for diferente de nulo, então não houve erro em captar os valores do usuario e pode seguir para 
        //adicionar
        if (item != null) {

            //a estrutura abaixo valida qual o tipo do produto e encaminha para o tipo de prateleira próprio para o mesmo

            switch (item.getTipo()) {

                case CARNES:
                    terminou = adicionaNaPrateleira("C", prateleiras, item);
                    break;
                case PEIXES:
                    terminou = adicionaNaPrateleira("P", prateleiras, item);
                    break;
                case BEBIDAS:
                    terminou = adicionaNaPrateleira("B", prateleiras, item);
                    break;
                case CONGELADOS:
                    terminou = adicionaNaPrateleira("I", prateleiras, item);
                    break;
                case ENLATADOS:
                    terminou = adicionaNaPrateleira("E", prateleiras, item);
                    break;
                case FRIOS:
                    terminou = adicionaNaPrateleira("F", prateleiras, item);
                    break;
                case HIGIENE:
                    terminou = adicionaNaPrateleira("H", prateleiras, item);
                    break;
                case LIMPEZA:
                    terminou = adicionaNaPrateleira("L", prateleiras, item);
                    break;
                case SALGADINHOS:
                    terminou = adicionaNaPrateleira("S", prateleiras, item);
                    break;
                case OUTROS:
                    terminou = adicionaNaPrateleira("O", prateleiras, item);
                    break;
            }

            //se o item foi alocado devidamente em alguma prateleira e não é uma edição, apresenta mensagem de sucesso

            if (terminou && !ehEdicao) {
                System.out.println("item adicionado com sucesso");
                return true;
            }

        }

        //nos demais casos retorna falso
        return false;
    }

    //apaga um item atraves do nome do mesmo,buscando pelas prateleiras este item e removendo da mesma caso encontrar

    public static boolean deleteItem(ArrayList<Prateleira> prateleiras) {

        try {
            Scanner in = new Scanner(System.in);

            System.out.println("digite o nome do produto que deseja remover:");
            String nome = in.nextLine();

            for (int i = 0; i < prateleiras.size(); i++) {
                
                //indice guarda qual posição do item presente no vetor de itens de prateleiras
                //caso não encontre,retorna -1
                int indice = prateleiras.get(i).encontraItem(nome);

                //se retornou um indice diferente de -1, então o item a ser excluido esta nesta prateleira e deve ser excluido
                if (indice != -1) {
                    prateleiras.get(i).deleteItem(indice);
                    System.out.println("Item deletado com sucesso");
                    return true ;
                }

            }
            //caso termine o laço,quer dizer que todas as prateleiras foram vistas e não foi encontrado o item
            System.out.println("não foi encontrado nenhum item com este nome");
            return false;

        } catch (InputMismatchException erro) {
            System.out.println("entrada inválida, tente novamente com outro tipo de entrada");
            return false;
        }
    }
    //a função de atualizar primeiro encontra o item a ser alterado entre as prateleiras
    //em seguida trata como se fosse adicionar um novo elemento, pois ao alterar o tipo pode-se mudar a prateleira
    //e apaga o item da antiga prateleira
    public static boolean updateItem(ArrayList<Prateleira> prateleiras) {

        Scanner in = new Scanner(System.in);

        System.out.println("digite o nome do produto que deseja atualizar:");
        String nome = in.nextLine();
        for (int i = 0; i < prateleiras.size(); i++) {

            //se for diferente de -1, encontrou o item entre as prateleiras
            int indice = prateleiras.get(i).encontraItem(nome);
            if (indice != -1) {
                
                System.out.println("item Selecionado:" + prateleiras.get(i).getItens().get(indice).getNome());
                System.out.println("digite abaixo os campos com os valores atualizados");

                //primeiro adiciona um novo item
                boolean adicionou = addItem(prateleiras, true);

                //se não houve nenhum erro durante a inclusão, apaga o item desatualizado da prateleira que estava
                //e imprime mensagem de sucesso
                //caso haja erro no processo de adicionar, imprime mensagem e retorna falso
                if (adicionou) {
                    prateleiras.get(i).deleteItem(indice);
                    System.out.println("item alterado com sucesso");
                    return true;
                }
                else{
                    System.out.println("não foi possivel atualizar o item");
                    return false;
                }

                            
            }
        }

        System.out.println("não foi encontrado nenhum item com este nome");
        return false;

    }
    //procura em todas prateleiras, todos os itens dentro das mesmas e cada item que tiver setor igual o informado, 
    //imprime o mesmo na tela

    public static void consultaItemPorSetor(ArrayList<Prateleira> prateleiras) {
        Scanner in = new Scanner(System.in);

        System.out.println("digite o nome do setor do produto:");
        String filtroSetor = in.nextLine();

        for (int i = 0; i < prateleiras.size(); i++) {
            prateleiras.get(i).consultaItemPorSetor(filtroSetor);
        }
        in.close();

    }

    //lista todos os itens presentes na prateleira especificada como entrada pelo seu nome
    public static void consultaPorPrateleira(ArrayList<Prateleira> prateleiras) {
        Scanner in = new Scanner(System.in);

        System.out.println("digite o nome da prateleira:");
        String filtroPrateleira = in.nextLine();

        for (int i = 0; i < prateleiras.size(); i++) {
            if (prateleiras.get(i).getNomePrateleira().equals(filtroPrateleira.trim())) {
                prateleiras.get(i).listItens();
            }
        }

    }

    //lista todas as prateleiras presentes no setor especificado

    public static void consultaPrateleiraPorSetor(ArrayList<Prateleira> prateleiras) {
        Scanner in = new Scanner(System.in);
        boolean encontrei = false;
        System.out.println("digite o setor da prateleira:");
        String filtroPrateleira = in.nextLine();

        for (int i = 0; i < prateleiras.size(); i++) {
            if (prateleiras.get(i).getSetor().equals(filtroPrateleira.trim())) {
                prateleiras.get(i).imprimePrateleira();
                encontrei = true;
            }
        }

        //se não encontrou nenhuma prateleira com o setor informado, retorna mensagem de erro
        if (!encontrei) {
            System.out.println("não foi encontrada nenhuma prateleira com este setor");
        }
    }

}
