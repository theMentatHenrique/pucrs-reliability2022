import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    // o método main apresenta o menu de opções possiveis e redireciona conforme
    // escolha
    public static void main(String[] args) throws Exception {

        ArrayList<Prateleira> prateleiras=new ArrayList<Prateleira>();


        Prateleira prateleira=new Prateleira("1A","gulouseimas",100f,100f);
        Item mock = new Item("doritos", Tipo.SALGADINHOS, 100.5f, 200.0f, 100, "Gulouseimas", "20");
        prateleira.addItem(mock);
        mock = new Item("Ruffles",  Tipo.SALGADINHOS, 100.5f, 205.0f, 300, "Gulouseimas", "10");
        prateleira.addItem(mock);
        mock = new Item("Pringles",  Tipo.SALGADINHOS, 190.5f, 300.0f, 50, "Gulouseimas", "30");
        prateleira.addItem(mock);

        prateleiras.add(prateleira);
        
         prateleira=new Prateleira("1B","Higiene",10,100);
         mock = new Item("Lava-louça", Tipo.SALGADINHOS, 5.5f, 5.0f, 10, "Higiene", "5-andar");
        prateleira.addItem(mock);
        mock = new Item("Ruffles", Tipo.SALGADINHOS, 100.5f, 205.0f, 300, "Gulouseimas", "10");
        prateleira.addItem(mock);
        mock = new Item("Pringles", Tipo.SALGADINHOS, 190.5f, 300.0f, 50, "Gulouseimas", "30");
        prateleira.addItem(mock);

        Scanner in = new Scanner(System.in);
        int opt = in.nextInt();


        



        //boolean continuar = true;
       /* 
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
                    deleteItem(itens);
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
*/
    }
    
    public static float convertValorVolume(String valor){
        float numero;

            if(valor.contains("MM3")){

                System.out.println("valor");
                valor=valor.replace(",", ".");
                valor=valor.replace("MM3", "");

                 numero=Float.valueOf(valor);
                 numero*=0.000000001;
                 return numero;
                
            }

            if(valor.contains("CM3")){
                valor=  valor.replace(",", ".");
                valor=   valor.replace("CM3", "");

                numero=Float.parseFloat(valor);
                numero*= 0.000001;
                return numero;                
            }
            if(valor.contains("M3")){
                valor=valor.replace(",", ".");
                valor= valor.replace("M3", "");

               return   numero=Float.valueOf(valor);
                
            }

            System.out.println("entrada invalida ");
            
        return 1f;
    }

    public static float convertValorPeso(String valor){
        float numero;

            if(valor.contains("KG")){
                valor=valor.replace(",", ".");
                valor=valor.replace("KG", "");
                System.out.println(valor);

                return numero=Float.valueOf(valor);
                
            }

            if(valor.contains("G")){
              valor=  valor.replace(",", ".");
               valor= valor.replace("G", "");

                numero=Float.parseFloat(valor);
                numero*=0.001;
                return numero;                
            }
            if(valor.contains("MG")){
                valor=valor.replace(",", ".");
                valor=valor.replace("MG", "");

                numero=Float.parseFloat(valor);
                numero/=1000000;
                return numero;                
            }
            
            System.out.println("entrada invalida ");
            
            return 1f;
    }

    public static Item PopulaCampos() {
        try {
            Item item = new Item();
            Scanner in = new Scanner(System.in);

            System.out.println("digite o nome do produto:");
            item.setNome(in.nextLine());

            System.out.println("digite o tipo do produto:");
            int tipo=in.nextInt();
            if(tipo>0 && tipo<10){
            item.setTipo(in.nextInt());
            }
            else{
                System.out.println("entrada invalida, tente novamente com uma entrada valida");
                return null;
            }

            System.out.println("digite o peso do produto com a unidade de medida:");
            item.setPeso(convertValorPeso((in.nextLine()).toUpperCase()));

            System.out.println("digite o volume do produto:");
            item.setVolume(convertValorVolume((in.nextLine()).toUpperCase()));

            System.out.println("digite a quantidade do produto:");
            int quantidade=in.nextInt();
            if(quantidade>0){
            item.setQuantidade(quantidade);
            }
            else{
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

    public static void addItem(Prateleira prateleira) {

        Item item = PopulaCampos();

        if (item != null) {
            prateleira.addItem(item);
            System.out.println("item adicionado com sucesso");
        }
    }



    public static void deleteItem(ArrayList<Prateleira> prateleiras) {

        try {
            Scanner in = new Scanner(System.in);

            System.out.println("digite o nome do produto que deseja remover:");
            String nome = in.nextLine();

            for(int i=0;i<prateleiras.size();i++){

                int indice=prateleiras.get(i).encontraItem(nome);
                if(indice!=-1){
                    prateleiras.get(i).deleteItem(indice);
                return;
                }
            }

            System.out.println("não foi encontrado nenhum item com este nome");
          

        } catch (InputMismatchException erro) {
            System.out.println("entrada inválida, tente novamente com outro tipo de entrada");
        }
    }

    public static void updateItem(ArrayList<Prateleira> prateleiras) {

        Scanner in = new Scanner(System.in);

        System.out.println("digite o nome do produto que deseja atualizar:");
        String nome = in.nextLine();
        for(int i=0;i<prateleiras.size();i++){

            int indice=prateleiras.get(i).encontraItem(nome);
            if(indice!=-1){

                System.out.println("item Selecionado:" + prateleiras.get(i).getItens().get(indice).getNome());
                System.out.println("digite abaixo os campos com os valores atualizados");
                Item item = PopulaCampos();
                if (item != null) {
                    prateleiras.get(i).atualizaItem(indice, item);
                    System.out.println("item atualizado com sucesso");
                    return;
                }
            }
        }  
                    System.out.println("não foi encontrado nenhum item com este nome");

    }

    public void consultaItemPorSetor(ArrayList<Prateleira> prateleiras) {
        Scanner in = new Scanner(System.in);

        System.out.println("digite o nome do setor do produto:");
        String filtroSetor = in.nextLine();

        for(int i=0;i<prateleiras.size();i++){
                prateleiras.get(i).consultaItemPorSetor(filtroSetor);
        }     
    }

    public void consultaPorPrateleira(ArrayList<Prateleira> prateleiras) {
        Scanner in = new Scanner(System.in);

        System.out.println("digite o nome da prateleira:");
        String filtroPrateleira = in.nextLine();

        for (int i = 0; i < prateleiras.size(); i++) {
            if (prateleiras.get(i).getNomePrateleira().equals(filtroPrateleira.trim())) {
                    prateleiras.get(i).listItens();
                    }
        }

    }

}
