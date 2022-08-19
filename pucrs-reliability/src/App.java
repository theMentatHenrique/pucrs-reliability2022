import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    // o método main apresenta o menu de opções possiveis e redireciona conforme
    // escolha
    public static void main(String[] args) throws Exception {

        boolean continuar = true;

        ArrayList<Item> itens = new ArrayList<Item>();

        Item mock = new Item("doritos", "gulouseima", 100.5f, 200.0f, 100, "Gulouseimas", "20", 1);
        itens.add(mock);
        mock = new Item("Ruffles", "gulouseima", 100.5f, 205.0f, 300, "Gulouseimas", "10", 1);
        itens.add(mock);

        mock = new Item("Pringles", "gulouseima", 190.5f, 300.0f, 50, "Gulouseimas", "30", 1);
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
                    addItem(itens);
                    break;
                case 2:
                    System.out.println("2");
                    break;
                case 3:
                    System.out.println("3");
                    break;
                case 4:
                    System.out.println("4");
                    break;
                case 5:
                    System.out.println("5");
                    break;
                case 6:
                    System.out.println("6");
                    break;
                case 7:
                    System.out.println("7");
                    break;
                case 0:
                    System.out.println("0");
                    continuar = false;
                    break;
                default:
                    System.out.println("opcao invalida");
            }
        }

    }

    public static void addItem(ArrayList<Item> itens) {

        try {
            Item item = new Item();
            Scanner in = new Scanner(System.in);

            System.out.println("digite o tipo do produto:");
            item.setTipo(in.nextLine());

            System.out.println("digite o peso do produto:");
            item.setPeso(in.nextFloat());

            System.out.println("digite o volume do produto:");
            item.setVolume(in.nextFloat());

            System.out.println("digite a quantidade do produto:");
            item.setQuantidade(in.nextInt());

            // limpa o buffer
            in.nextLine();

            System.out.println("digite o setor do produto:");
            item.setSetor(in.nextLine());

            System.out.println("digite a localização do produto:");
            item.setLocalizacao(in.nextLine());

            itens.add(item);

            System.out.println("item adicionado com sucesso");

        } catch (InputMismatchException erro) {
            System.out.println("entrada inválida, tente novamente com outro tipo de entrada");
        }
    }

    public static int encontraIndice(String nome,ArrayList<Item> itens){

        for(int i=0;i<itens.size();i++){
            if(itens.get(i).getNome().equals(nome))return i;
        }


            return -1;
    }
    public static void deleteItem(ArrayList<Item> itens) {

        try {
            Scanner in = new Scanner(System.in);

            System.out.println("digite o nome do produto que deseja remover:");
            String nome=in.nextLine();
            int indiceElemento=encontraIndice(nome,itens);

            if(indiceElemento==-1){
                System.out.println("não foi encontrado nenhum item com este nome");
                return;
            }

            itens.remove(indiceElemento);
            System.out.println("item removido com sucesso");
          
        } catch (InputMismatchException erro) {
            System.out.println("entrada inválida, tente novamente com outro tipo de entrada");
        }
    }
}
