
public class Main {

    public static void main(String[] args) {
        LDE lista = new LDE();
        lista.inserir(new Produto("Coca-cola 2L", 6.0), 0);
        lista.inserir(new Produto("Açucar 1 Kg", 4.0), 0);
        lista.inserir(new Produto("Feijão 2 Kg", 5.0), 1);
        lista.inserir(new Produto("Arroz 1 kg", 4.0), 1);
        lista.inserir(new Produto("Cerveja Itaipava lata", 2.5), 1);
        lista.inserir(new Produto("Doce de leite", 5), lista.getTamanho());
        lista.imprimir();
        
        lista.removerInicio();
        System.out.println("Impressão depois da remoção inicio /n");
        lista.imprimir();
        lista.removerFinal();
        System.out.println("Impressão depois da remoção final /n");
        lista.imprimir();
        lista.remover(1);
        System.out.println("Impressão depois da remoção indice 1 /n");
        lista.imprimir();
        System.out.println("Impressão inversa");
        lista.imprimirIniciandoNaCauda();

    }
}
